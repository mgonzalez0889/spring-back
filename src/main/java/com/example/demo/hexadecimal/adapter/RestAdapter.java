package com.example.demo.hexadecimal.adapter;

import com.example.demo.hexadecimal.domain.Clientes;
import com.example.demo.hexadecimal.port.ClientApplicationPort;

import org.slf4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:4200", "*"})
@RestController
@RequestMapping("/api")
public class RestAdapter {

    @Autowired
    private ClientApplicationPort clientApplicationPort;

    //@Autowired
    //private UploadRepositoryPort uploadRepositoryPort;
    private final Logger log = org.slf4j.LoggerFactory.getLogger(RestAdapter.class);

    //@RequestMapping(value = "/clients", method = RequestMethod.GET)
    //@ApiResponses({ @ApiResponse(code = 200, message = "Success", response = Cliente.class) })
    @GetMapping("/clients")
    public List<Clientes> indexAll() {
        return clientApplicationPort.findAll();
    }

    @GetMapping("/clientes/page/{page}")
    public Page<Clientes> indexPage(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 4);
        return clientApplicationPort.finAll(pageable);
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping("/clientes/{id}")
    public ResponseEntity<?> showClient(@PathVariable Long id) {
        Clientes clientes = null;
        Map<String, Object> response = new HashMap<>();
        try {
            clientes = clientApplicationPort.findById(id);

        }catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(clientes == null) {
            response.put("mensaje", "El cliente ID: ".concat(id.toString().concat(" no existe en la base de datos")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

        }

        return  new ResponseEntity<Clientes>(clientes, HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/clientes")
    public ResponseEntity<?> createClient(@Valid @RequestBody Clientes clientes, BindingResult result) {
        Clientes clientesNew = null;

        Map<String, Object> response = new HashMap<>();

        if(result.hasErrors()) {

            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() + "'" + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            clientesNew = clientApplicationPort.save(clientes);
        }catch(DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El cliente se ha creado con exito");
        response.put("cliente", clientesNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            Clientes clientes = clientApplicationPort.findById(id);
            String nombreFotoAnterior = clientes.getFoto();
            //uploadRepositoryPort.eliminar(nombreFotoAnterior);
            clientApplicationPort.delete(id);
        }catch(DataAccessException e) {
            response.put("mensaje", "Error al eliminar cliente en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }

        response.put("mensaje", "El cliente ha sido eliminado");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }




}
