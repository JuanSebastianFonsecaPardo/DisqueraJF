package com.sena.springweb.controller;
import com.sena.springweb.model.Artista;
import com.sena.springweb.model.Disquera;
import com.sena.springweb.service.IArtistaService;
import com.sena.springweb.service.IDisqueraService;

import java.util.List;

//importe de librerias

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

@Controller //catalogar clase como un controlador
@SessionAttributes("artista")
@RequestMapping("/artista") 
public class ArtistaController {
    @Autowired
    private IDisqueraService disquera3;


    @Autowired
    private IArtistaService artista2;

    @GetMapping(path = {"/listar","","/"})
    public String lista(Model m){
        m.addAttribute("artista", artista2.findAll());
        return "artista/listar";
    }
 
    @GetMapping("/ver/{id}")
    public String editar(@PathVariable Integer id, Model m){
        Artista artista=null;
        List<Disquera> disquera=disquera3.findAll();
        if (id>0) {
            artista=artista2.findOne(id);
        }else{
            return "redirect:listar";
        }

        m.addAttribute("artista", artista);
        m.addAttribute("disquera", disquera);
        m.addAttribute("accion", "Actualizar artista");
        return "artista/form";
    } 

    @GetMapping("/vera/{id}")
    public String vera(@PathVariable Integer id,Model m){
        Artista artista=null;
        if(id>0){
            artista=artista2.findOne(id);
        }else{
            return "redirect:listar";
        }
        m.addAttribute("artista", artista);
        return "artista/vera";
    }
    

    @GetMapping("/form")
    public String form(Model m){
        Artista artista=new Artista();
        List<Disquera> disquera=disquera3.findAll();
        m.addAttribute("artista", artista);
        m.addAttribute("disquera", disquera);
        m.addAttribute("accion", "Agregar artista");
        return "artista/form";
    }
    
    @PostMapping("/add")
    public String add(@Valid Artista artista, BindingResult res, Model m, SessionStatus status){
        if(res.hasErrors()){
            return "artista/form";
        }
        artista2.save(artista);
        status.setComplete();
        return "redirect:listar";
        }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        if(id > 0){
            artista2.delete(id);
        }
        return "redirect:..";
    }
    
}
        