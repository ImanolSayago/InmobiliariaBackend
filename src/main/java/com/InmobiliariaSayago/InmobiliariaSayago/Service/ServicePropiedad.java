package com.InmobiliariaSayago.InmobiliariaSayago.Service;

import com.InmobiliariaSayago.InmobiliariaSayago.Model.ImagenPropiedad;
import com.InmobiliariaSayago.InmobiliariaSayago.Model.Propiedades;
import com.InmobiliariaSayago.InmobiliariaSayago.Repository.IRepositoryPropiedades;
import com.InmobiliariaSayago.InmobiliariaSayago.Repository.IRepositroyImagenPropiedad;
import com.InmobiliariaSayago.InmobiliariaSayago.Respuestas.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ServicePropiedad implements IServicePropiedad{

    @Autowired
    CloudinaryService cloudServ;

    @Autowired
    IRepositroyImagenPropiedad repoimagen;

    @Autowired
    IRepositoryPropiedades repoPropiedad;



    @Override
    public ResponseMessage crearProyecto(Propiedades propiedad, List<MultipartFile> archivos) {
        // Subir la imagen principal (primer archivo de la lista)
        String imagenPrincipalUrl = null;

        try {
            imagenPrincipalUrl = cloudServ.subirImagen(archivos.get(0));  // Usando el primer archivo como imagen principal
        } catch (IOException e) {
            e.printStackTrace();  // Para poder loguear el error
            return new ResponseMessage("Hubo un error al subir la imagen principal", false);  // Error al subir imagen principal
        }
        propiedad.setImagenPrincipal(imagenPrincipalUrl); // Asignamos la URL de la imagen principal al proyecto

        // Guardar el proyecto con la URL de la imagen principal
        Propiedades propiedadGuardada = repoPropiedad.save(propiedad);

        // Subir imágenes adicionales (si existen) y asociarlas al proyecto
        for (int i = 1; i < archivos.size(); i++) {
            String imagenUrl = null;
            try {
                imagenUrl = cloudServ.subirImagen(archivos.get(i));  // Subimos cada archivo adicional
            } catch (IOException e) {
                e.printStackTrace();  // Para poder loguear el error
                return new ResponseMessage("Hubo un error al subir una imagen adicional", false);  // Error al subir imagen adicional
            }

            // Crear una nueva entidad de ImagenProyecto y asociarla al proyecto
            ImagenPropiedad imagenProyecto = new ImagenPropiedad();
            imagenProyecto.setUrl(imagenUrl);  // Asignamos la URL de la imagen
            imagenProyecto.setPropiedad(propiedadGuardada);  // Asociamos la imagen al proyecto

            // Guardamos la imagen adicional en la base de datos
            repoimagen.save(imagenProyecto);
        }

        return new ResponseMessage("Proyecto creado con éxito", true);  // Respuesta exitosa
    }

    @Override
    public boolean borrarProyecto(Long id) {
        if(id!=null)
        {
            Propiedades pro =   repoPropiedad.findById(id).orElse(null);

            if(pro!=null)
            {
                repoPropiedad.delete(pro);
                return true;
            }

        }
        else
        {
            return false;
        }
        return false;
    }

    @Override
    public List<Propiedades> getPropiedades() {
        return repoPropiedad.findAll();
    }

    @Override
    public Propiedades getPropiedadByID(Long id) {
        return repoPropiedad.findById(id).orElse(null);
    }


}