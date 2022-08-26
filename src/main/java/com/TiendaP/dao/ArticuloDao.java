
package com.TiendaP.dao;

import com.TiendaP.domain.Articulo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
public interface ArticuloDao extends CrudRepository<Articulo,Long>{
    
    
    List<Articulo> findByIdCategoria(Long idCategoria );

    public List<Articulo> findByIdCategoria(Articulo idCategoria);
    
}
