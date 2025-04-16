package com.InmobiliariaSayago.InmobiliariaSayago.Service;

import com.InmobiliariaSayago.InmobiliariaSayago.Model.ImagenPropiedad;
import com.InmobiliariaSayago.InmobiliariaSayago.Repository.IRepositroyImagenPropiedad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImagenProp implements IServiceImagenProp{

    @Autowired
    IRepositroyImagenPropiedad repoImagen;

    @Override
    public List<ImagenPropiedad> getImagenes() {
        return repoImagen.findAll();
    }
}
