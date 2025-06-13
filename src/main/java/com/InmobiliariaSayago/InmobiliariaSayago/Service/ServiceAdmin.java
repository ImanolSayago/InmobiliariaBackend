package com.InmobiliariaSayago.InmobiliariaSayago.Service;

import com.InmobiliariaSayago.InmobiliariaSayago.Model.Admin;
import com.InmobiliariaSayago.InmobiliariaSayago.Repository.IRepositoryAdmin;
import com.InmobiliariaSayago.InmobiliariaSayago.Repository.IRepositoryPropiedades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceAdmin implements IServiceAdmin{

    @Autowired
    IRepositoryAdmin repoadmin;

    @Override
    public boolean Verificado(String usuario, String contra) {
        boolean verificado = false;
        Admin ad = repoadmin.findByusuario(usuario);
        if(ad!=null)
        {
            if(ad.getContrasena().equals(contra))
            {
                verificado = true;
            }
        }

        return verificado;
    }
}
