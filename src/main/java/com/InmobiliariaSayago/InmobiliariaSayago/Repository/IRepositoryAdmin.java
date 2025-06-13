package com.InmobiliariaSayago.InmobiliariaSayago.Repository;

import com.InmobiliariaSayago.InmobiliariaSayago.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryAdmin extends JpaRepository<Admin,Long> {
    Admin findByusuario(String usuario);
}
