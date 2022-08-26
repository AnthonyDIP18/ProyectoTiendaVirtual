package com.TiendaP.controller;

import com.TiendaP.domain.Articulo;
import com.TiendaP.service.ArticuloService;
import com.TiendaP.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ArticuloController {
    
    @Autowired
    private ArticuloService articuloService;
    
    @Autowired
    private CategoriaService categoriaService;
   
     
     @GetMapping("/articulo/listado") 
    public String inicio(Model model) {
        var articulos = articuloService.getArticulos(false);
        model.addAttribute("articulos", articulos);
        return "/articulo/listado";

    }
    

    @GetMapping("/articulo/nuevo")
    public String nuevoArticulo(Articulo articulo, Model model) {
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        return "/articulo/modificar";

    }

    @PostMapping("/articulo/guardar")
    public String guardarArticulo(Articulo articulo) {
        articuloService.save(articulo);
        return "redirect:/articulo/listado";
    }

    @GetMapping("/articulo/modificar/{idArticulo}")
    public String modificarArticulo(Articulo articulo, Model model) {
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        
        articulo = articuloService.getArticulo(articulo);
        model.addAttribute("articulo", articulo);
        return "/articulo/modificar";

    }

    @GetMapping("/articulo/eliminar/{idArticulo}")
    public String eliminarArticulo(Articulo articulo) {
        articuloService.delete(articulo);
        return "redirect:/articulo/listado";
        
    }
    
    
    @GetMapping("/articulo/componentes")
    public String buscarPorCategoria(@RequestParam Articulo idCategoria, Model model, @ModelAttribute("articulo") Articulo articulo ){
        model.addAttribute("categoriaPorId", articuloService.buscarPorCategoria(idCategoria));
        return "redirect:/articulo/componentes";
    }
    
    
    
}
