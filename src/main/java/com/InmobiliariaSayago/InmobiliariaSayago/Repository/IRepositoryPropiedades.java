package com.InmobiliariaSayago.InmobiliariaSayago.Repository;

import com.InmobiliariaSayago.InmobiliariaSayago.Model.Propiedades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryPropiedades extends JpaRepository<Propiedades,Long> {
}
