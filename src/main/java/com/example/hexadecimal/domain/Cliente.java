package com.example.hexadecimal.domain;


import com.example.demo.models.entity.Factura;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message="No puede estar vacio")
    @Size(min=4, max=12, message="El tamaño debe estar entre 4 y 12 caracteres")
    @Column(nullable=false)
    private String nombre;

    @NotEmpty(message="No puede estar vacio")
    private String apellido;

    @NotEmpty(message="No puede estar vacio")
    @Email(message="No es un correo valido")
    @Column(nullable=false, unique=false)
    private String email;

    @NotNull(message="No puede estar vacio")
    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    private String foto;

    @NotNull(message="la region no puede ser vacia")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="region_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private com.example.hexadecimal.domain.Region region;
    //@PrePersist
	/*public void prePersist() {
		createAt = new Date();
	}
	*/
    @JsonIgnoreProperties(value={"cliente", "hibernateLazyInitializer", "handler"}, allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Factura> facturas;


    public Cliente() {
        this.facturas = new ArrayList<>();
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }


    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }


    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }






    /**
     *
     */
    private static final long serialVersionUID = 1L;

}
