package com.InmobiliariaSayago.InmobiliariaSayago.Service;

import com.InmobiliariaSayago.InmobiliariaSayago.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceUser {

    public void addUser(User user);

    public void deleteUser(Long id);
}
