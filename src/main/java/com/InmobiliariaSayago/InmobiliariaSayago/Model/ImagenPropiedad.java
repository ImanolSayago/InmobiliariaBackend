package com.InmobiliariaSayago.InmobiliariaSayago.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ImagenPropiedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url; // URL en Cloudinary

    @ManyToOne
    @JoinColumn(name = "propiedad_id")
    @JsonIgnore
    private Propiedades propiedad;

    public ImagenPropiedad() {
    }

    public ImagenPropiedad(Long id, String url, Propiedades propiedad) {
        this.id = id;
        this.url = url;
        this.propiedad = propiedad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Propiedades getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedades propiedad) {
        this.propiedad = propiedad;
    }
}
