package com.InmobiliariaSayago.InmobiliariaSayago.Repository;

import com.InmobiliariaSayago.InmobiliariaSayago.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryUser extends JpaRepository<User,Long> {
}
