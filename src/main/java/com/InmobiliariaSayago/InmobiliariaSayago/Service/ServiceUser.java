package com.InmobiliariaSayago.InmobiliariaSayago.Service;

import com.InmobiliariaSayago.InmobiliariaSayago.Model.User;
import com.InmobiliariaSayago.InmobiliariaSayago.Repository.IRepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceUser implements IServiceUser{
    @Autowired
    IRepositoryUser repoUser;

    @Override
    public void addUser(User user) {
        if(user!=null)
        {
            repoUser.save(user);
        }
        else
        {
            System.out.println("No se pudo crear el user");
        }
    }

    @Override
    public void deleteUser(Long id) {
        if(id!=null || id!=0)
        {
            repoUser.deleteById(id);
        }
        else
        {
            System.out.println("El user no se puede eliminar en este momento");
        }
    }
}
