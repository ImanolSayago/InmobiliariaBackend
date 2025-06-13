package com.InmobiliariaSayago.InmobiliariaSayago.Controller;


import com.InmobiliariaSayago.InmobiliariaSayago.Model.Admin;
import com.InmobiliariaSayago.InmobiliariaSayago.Service.ServiceAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class ControllerAdmin {

    @Autowired
    ServiceAdmin servicead;

    @PostMapping("/verificar")
    public boolean verificado(@RequestBody Admin ad)
    {
        boolean verificado = false;

        verificado = servicead.Verificado(ad.getUsuario(),ad.getContrasena());
        return verificado;
    }



}
