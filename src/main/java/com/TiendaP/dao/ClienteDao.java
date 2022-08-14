
package com.TiendaP.dao;

import com.TiendaP.domain.Cliente;
import org.springframework.data.repository.CrudRepository;
public interface ClienteDao extends CrudRepository<Cliente,Long>{
    
}
