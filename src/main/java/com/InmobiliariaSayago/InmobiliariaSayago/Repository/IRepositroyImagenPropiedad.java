package com.InmobiliariaSayago.InmobiliariaSayago.Repository;

import com.InmobiliariaSayago.InmobiliariaSayago.Model.ImagenPropiedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IRepositroyImagenPropiedad extends JpaRepository<ImagenPropiedad,Long> {
    //List<ImagenPropiedad> findByProyectoId(Long PropiedadId);//
}
