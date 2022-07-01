package com.sena.springweb.controller;
import com.sena.springweb.model.Disquera;
import com.sena.springweb.service.IDisqueraService;

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
@SessionAttributes("disquera")
@RequestMapping("/disquera") 
public class DisqueraController {
    
    @Autowired
    private IDisqueraService disquera2;

    @GetMapping(path = {"/listar","","/"})
    public String lista(Model m){
        m.addAttribute("disquera", disquera2.findAll());
        return "disquera/listar";
    }
 
    @GetMapping("/ver/{id}")
    public String editar(@PathVariable Integer id, Model m){
        Disquera disquera=null;
        if (id>0) {
            disquera=disquera2.findOne(id);
        }else{
            return "redirect:listar";
        }

        m.addAttribute("disquera", disquera);
        m.addAttribute("accion", "Actualizar disquera");
        return "disquera/form";
    } 

    @GetMapping("/verd/{id}")
    public String verd(@PathVariable Integer id,Model m){
        Disquera disquera=null;
        if(id>0){
            disquera=disquera2.findOne(id);
        }else{
            return "redirect:listar";
        }
        m.addAttribute("disquera", disquera);
        return "disquera/verd";
    }
    

    @GetMapping("/form")
    public String form(Model m){
        Disquera disquera=new Disquera();
        m.addAttribute("disquera", disquera);
        m.addAttribute("accion", "Agregar disquera");
        return "disquera/form";
    }
    
    @PostMapping("/add")
    public String add(@Valid Disquera disquera, BindingResult res, Model m, SessionStatus status){
        if(res.hasErrors()){
            return "disquera/form";
        }
        disquera2.save(disquera);
        status.setComplete();
        return "redirect:listar";
        }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        if(id > 0){
            disquera2.delete(id);
        }
        return "redirect:..";
    }
    
}
        