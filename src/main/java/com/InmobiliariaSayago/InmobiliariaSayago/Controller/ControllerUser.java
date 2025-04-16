package com.InmobiliariaSayago.InmobiliariaSayago.Controller;

import com.InmobiliariaSayago.InmobiliariaSayago.Model.User;
import com.InmobiliariaSayago.InmobiliariaSayago.Service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class ControllerUser {

    @Autowired
    ServiceUser serviceUser;

    @PostMapping("/crear")
    public void addUser(@RequestBody User user)
    {
        if(user!=null)
        {
            serviceUser.addUser(user);
        }
        else
        {
            System.out.println("El usuario no puede ser agregado por algun error, intente nuevamente");
        }
    }

    @DeleteMapping("/borrar")
    public void deleteUser(@PathVariable Long id)
    {
        if(id!=null)
        {
            serviceUser.deleteUser(id);
        }
        else
        {
            System.out.println("El id no puede estar vacio");
        }
    }
}
