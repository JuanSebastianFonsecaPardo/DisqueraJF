package com.sena.springweb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.sena.springweb.model.Album;
import com.sena.springweb.model.Cancion;
import com.sena.springweb.service.IAlbumService;
import com.sena.springweb.service.ICancionService;

@Controller //catalogar clase como un controlador
@SessionAttributes("cancion")
@RequestMapping("/cancion") 
public class CancionController {
    @Autowired
    private ICancionService cancion3;

    @Autowired
    private IAlbumService album3;

    @GetMapping("/listar")
    public String listar(@Valid Cancion cancion, Model m){
        m.addAttribute("canc", cancion3.findAll());
        return "cancion/listar";
    }
 
    @GetMapping("/ver/{id}")
    public String ver(@PathVariable Integer id, Model m){
        Cancion cancion=null;
        List<Album> album=album3.findAll();
        if (id>0) {
            cancion=cancion3.findOne(id);
        }else{
            return "redirect:cancion/listar";
        }
        m.addAttribute("cancion", cancion);
        m.addAttribute("album", album);
        m.addAttribute("accion", "Actualizar cancion");
        return "cancion/form";
    }

    @GetMapping("/form")
    public String form(Model m){
        Cancion cancion=new Cancion();
        List<Album> album=album3.findAll();
        m.addAttribute("cancion", cancion);
        m.addAttribute("album", album);
        m.addAttribute("accion", "Agregar cancion");
        return "cancion/form";
    }
    
    @PostMapping("/add")
    public String add(@Valid Cancion cancion, BindingResult res, Model m, SessionStatus status){
        cancion3.save(cancion);
        status.setComplete();
        return "redirect:listar";
        }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        if(id > 0){
            cancion3.delete(id);
        }
        return "redirect:..";
    }
    
}
