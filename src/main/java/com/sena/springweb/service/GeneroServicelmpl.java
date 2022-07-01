package com.sena.springweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.springweb.model.Genero;
import com.sena.springweb.model.IGenero;

@Service
public class GeneroServicelmpl implements IGeneroService{

    @Autowired
    private IGenero generod;
    @Override
    public List<Genero> findAll() {
        return (List<Genero>) generod.findAll();
    }

    @Override
    public void save(Genero genero) {
        generod.save(genero);
    }

    @Override
    public Genero findOne(Integer id) {
        return generod.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        generod.deleteById(id);
        
    }
    
}
