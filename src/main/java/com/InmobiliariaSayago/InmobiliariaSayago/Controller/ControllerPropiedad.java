package com.InmobiliariaSayago.InmobiliariaSayago.Controller;

import com.InmobiliariaSayago.InmobiliariaSayago.Model.ImagenPropiedad;
import com.InmobiliariaSayago.InmobiliariaSayago.Model.Propiedades;
import com.InmobiliariaSayago.InmobiliariaSayago.Respuestas.ResponseMessage;
import com.InmobiliariaSayago.InmobiliariaSayago.Service.ServicePropiedad;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/propiedad")
public class ControllerPropiedad {

    private String ciudad;
    private String provincia;
    private int ambientes;
    private int banos;
    private Long precio;
    private boolean disponible;
    private String imagenPrincipal;

    @OneToMany(mappedBy = "propiedad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ImagenPropiedad> listaImg;

    @Autowired
    ServicePropiedad propiedadService ;

    @PostMapping("/crear")
    public ResponseEntity<ResponseMessage> crearProyecto(@RequestParam("titulo") String titulo,
                                                         @RequestParam("descripcion") String descripcion,
                                                         @RequestParam("direccion") String direccion,
                                                         @RequestParam("ciudad") String ciudad,
                                                         @RequestParam("provincia") String provincia,
                                                         @RequestParam("ambientes") int ambientes,
                                                         @RequestParam("banos") int banos,
                                                         @RequestParam("precio") Long precio,
                                                         @RequestParam("tipo") int tipo  ,
                                                         @RequestParam("cocheras") int cocheras,
                                                         @RequestParam("archivos") List<MultipartFile> archivos) {
        // Crear una nueva instancia de Proyecto con los datos recibidos
        Propiedades proyecto = new Propiedades();
        proyecto.setTitulo(titulo);
        proyecto.setDescripcion(descripcion);
        proyecto.setDireccion(direccion);
        proyecto.setCiudad(ciudad);
        proyecto.setProvincia(provincia);
        proyecto.setAmbientes(ambientes);
        proyecto.setBanos(banos);
        proyecto.setPrecio(precio);
        proyecto.setTipo(tipo);
        proyecto.setCocheras(cocheras);
        proyecto.setFechaPublicacion(new Date());
        proyecto.setDisponible(true);


        // Llamar al servicio para crear el proyecto y subir las imágenes
        try {
            ResponseMessage response = propiedadService.crearProyecto(proyecto, archivos);

            if (response.isSuccess()) {
                return ResponseEntity.ok(response);  // Si el proyecto se creó con éxito, devolvemos la respuesta
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);  // Error en la creación del proyecto
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("Error: " + e.getMessage(), false));  // Error en el proceso
        }
    }
    @GetMapping("/traer")
    public List<Propiedades> getPropiedades()
    {
        return propiedadService.getPropiedades();

    }


    @GetMapping("/traer/{id}")
    public Propiedades getPropiedadID(@PathVariable Long id){
        return propiedadService.getPropiedadByID(id);
    }


}