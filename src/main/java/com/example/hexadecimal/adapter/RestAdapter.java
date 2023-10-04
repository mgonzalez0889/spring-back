package com.example.hexadecimal.adapter;

import com.example.hexadecimal.domain.Cliente;
import com.example.hexadecimal.port.ClientApplicationPort;
import org.slf4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "*"})
@RestController
@RequestMapping("/api")
@Validated
public class RestAdapter {

    @Autowired
    private ClientApplicationPort clientApplicationPort;
    private final Logger log = org.slf4j.LoggerFactory.getLogger(RestAdapter.class);

    @RequestMapping(value = "/clientes", method = RequestMethod.GET)
    public List<Cliente> index() {
        return clientApplicationPort.findAll();

    }

}
