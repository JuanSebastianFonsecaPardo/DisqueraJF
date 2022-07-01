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
import com.sena.springweb.model.Artista;
import com.sena.springweb.model.Genero;
import com.sena.springweb.service.IAlbumService;
import com.sena.springweb.service.IArtistaService;
import com.sena.springweb.service.IGeneroService;

@Controller
@SessionAttributes("album")
@RequestMapping ("/album")
public class AlbumController {

    @Autowired
    private IAlbumService album2;

    @Autowired
    private IArtistaService artista2;

    @Autowired
    private IGeneroService genero2;

    @GetMapping("/listar")
    public String listar(@Valid Album album,Model m){
        m.addAttribute("album", album2.findAll());
        m.addAttribute("artista", artista2.findAll());
        return "album/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model m){
        Album album=null;
        List<Genero> genero=genero2.findAll();
        if (id>0) {
            album=album2.findOne(id);
        }else{
            return "redirect:album/listar";
        }
        m.addAttribute("album", album);
        m.addAttribute("genero", genero);
        m.addAttribute("accion", "Editar Album");
        return "album/form";
    }

    @GetMapping("/vera/{id}")
    public String vera(@PathVariable Integer id,Model m){
        Album album=null;
        if(id>0){
            album=album2.findOne(id);
        }else{
            return "redirect:listar";
        }
        m.addAttribute("album", album);
        return "album/vera";
    }

    @GetMapping("/form")
    public String form(Model m){
        Album album=new Album();
        List<Genero> genero=genero2.findAll();
        List<Artista> artista=artista2.findAll();
        m.addAttribute("album", album);
        m.addAttribute("genero", genero);
        m.addAttribute("artista", artista);
        m.addAttribute("accion", "Agregar Album");
        return "album/form";
    }

    @PostMapping("/add")
    public String add(@Valid Album album,BindingResult res,Model Album, SessionStatus status){
        album2.save(album);
        status.setComplete();
        return "redirect:listar";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        if(id>0) {
            album2.delete(id);
        }
        return "redirect:/listar";
    }
}
