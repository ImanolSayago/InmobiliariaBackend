package com.InmobiliariaSayago.InmobiliariaSayago.Service;


import com.InmobiliariaSayago.InmobiliariaSayago.Model.Propiedades;
import com.InmobiliariaSayago.InmobiliariaSayago.Respuestas.ResponseMessage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IServicePropiedad {
    public ResponseMessage crearProyecto(Propiedades propiedad, List<MultipartFile> archivos);

    public boolean borrarProyecto(Long id);

    public List<Propiedades>getPropiedades();

    public Propiedades getPropiedadByID(Long id);

    public boolean darDeBaja(Long id);

    public boolean editarPropiedad(Propiedades prop);
}
