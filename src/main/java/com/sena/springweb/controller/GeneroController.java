package com.sena.springweb.controller;
import com.sena.springweb.model.Genero;
import com.sena.springweb.service.IGeneroService;

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
@SessionAttributes("genero")
@RequestMapping("/genero") 
public class GeneroController {
    
    @Autowired
    private IGeneroService genero2;

    @GetMapping(path = {"/listar","","/"})
    public String lista(Model m){
        m.addAttribute("genero", genero2.findAll());
        return "genero/listar";
    }
 
    @GetMapping("/ver/{id}")
    public String editar(@PathVariable Integer id, Model m){
        Genero genero=null;
        if (id>0) {
            genero=genero2.findOne(id);
        }else{
            return "redirect:listar";
        }

        m.addAttribute("genero", genero);
        m.addAttribute("accion", "Actualizar genero");
        return "genero/form";
    } 

    @GetMapping("/verg/{id}")
    public String verg(@PathVariable Integer id,Model m){
        Genero genero=null;
        if(id>0){
            genero=genero2.findOne(id);
        }else{
            return "redirect:listar";
        }
        m.addAttribute("genero", genero);
        return "genero/verg";
    }
    

    @GetMapping("/form")
    public String form(Model m){
        Genero genero=new Genero();
        m.addAttribute("genero", genero);
        m.addAttribute("accion", "Agregar genero");
        return "genero/form";
    }
    
    @PostMapping("/add")
    public String add(@Valid Genero genero, BindingResult res, Model m, SessionStatus status){
        if(res.hasErrors()){
            return "genero/form";
        }
        genero2.save(genero);
        status.setComplete();
        return "redirect:listar";
        }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        if(id > 0){
            genero2.delete(id);
        }
        return "redirect:..";
    }
    
}
        