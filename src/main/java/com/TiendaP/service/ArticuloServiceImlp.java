package com.TiendaP.service;

import com.TiendaP.dao.ArticuloDao;
import com.TiendaP.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ArticuloServiceImlp implements ArticuloService {

    @Autowired
    private ArticuloDao articuloDao;
    private Long idCategoria;

    @Override
    @Transactional(readOnly = true)
    public List<Articulo> getArticulos(boolean activo) {
        var lista = (List<Articulo>) articuloDao.findAll();

        if (activo) {
            lista.removeIf(e -> !e.isActivo());
        }

        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Articulo getArticulo(Articulo articulo) {
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Articulo articulo) {
        articuloDao.save(articulo);
    }

    @Override
    @Transactional
    public void delete(Articulo articulo) {
        articuloDao.delete(articulo);
        
    }

    @Override
    public List<Articulo> buscarPorCategoria(Articulo articulo) {
        return articuloDao.findByIdCategoria(idCategoria);
    }

}
