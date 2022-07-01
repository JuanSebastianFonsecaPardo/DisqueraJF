package com.sena.springweb.service;
import java.util.List;

import com.sena.springweb.model.Genero;

public interface IGeneroService {
    public List<Genero> findAll();
    public void save (Genero genero);
    public Genero findOne(Integer id);
    public void delete(Integer id);
}
