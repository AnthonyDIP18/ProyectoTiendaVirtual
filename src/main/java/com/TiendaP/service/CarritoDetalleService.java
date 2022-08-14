package com.TiendaP.service;

import com.TiendaP.domain.Articulo;
import com.TiendaP.domain.CarritoDetalle;
import java.util.List;

public interface CarritoDetalleService {
    CarritoDetalle getCarritoDetalle(Long idCarrito, Articulo articulo);
    public List<CarritoDetalle> getCarritoDetalles(Long idCarrito);
    public void save(CarritoDetalle carritoDetalle);
    public void delete(CarritoDetalle carritoDetalle);
    public void deleteAll(Long idCarrito);
}
