package com.TiendaP.service;

import com.TiendaP.domain.Articulo;
import java.util.List;

public interface ArticuloService {

    public List<Articulo> getArticulos(boolean activo);

    public Articulo getArticulo(Articulo articulo);

    public void save(Articulo articulo);

    public void delete(Articulo articulo);
    
    List<Articulo> buscarPorCategoria(Long idCategoria );

}
