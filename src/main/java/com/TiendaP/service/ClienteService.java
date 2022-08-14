package com.TiendaP.service;

import com.TiendaP.domain.Cliente;
import java.util.List;

public interface ClienteService {
    
    
    public List<Cliente> getClientes();
    
    public Cliente getCliente(Cliente cliente);
    
    public void save(Cliente cliente);
    
    public void delete(Cliente cliente);
    
    
    
}