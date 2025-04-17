package com.InmobiliariaSayago.InmobiliariaSayago.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Propiedades {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String titulo;
    private String descripcion;
    private String direccion;
    private String ciudad;
    private String provincia;
    private int ambientes;
    private int banos;
    private Long precio;
    private boolean disponible;
    private Date fechaPublicacion;
    private String imagenPrincipal;

    @OneToMany(mappedBy = "propiedad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ImagenPropiedad> listaImg;

    public Propiedades() {
    }

    public Propiedades(Long id, String titulo, String descripcion, String direccion, String ciudad, String provincia, int ambientes, int banos, Long precio, boolean disponible, Date fechaPublicacion, String imagenPrincipal, List<ImagenPropiedad> listaImg) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.ambientes = ambientes;
        this.banos = banos;
        this.precio = precio;
        this.disponible = disponible;
        this.fechaPublicacion = fechaPublicacion;
        this.imagenPrincipal = imagenPrincipal;
        this.listaImg = listaImg;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getAmbientes() {
        return ambientes;
    }

    public void setAmbientes(int ambientes) {
        this.ambientes = ambientes;
    }

    public int getBanos() {
        return banos;
    }

    public void setBanos(int banos) {
        this.banos = banos;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getImagenPrincipal() {
        return imagenPrincipal;
    }

    public void setImagenPrincipal(String imagenPrincipal) {
        this.imagenPrincipal = imagenPrincipal;
    }

    public List<ImagenPropiedad> getListaImg() {
        return listaImg;
    }

    public void setListaImg(List<ImagenPropiedad> listaImg) {
        this.listaImg = listaImg;
    }
}
