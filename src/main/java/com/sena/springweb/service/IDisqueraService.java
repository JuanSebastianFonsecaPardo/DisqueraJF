package com.sena.springweb.service;
import java.util.List;

import com.sena.springweb.model.Disquera;

public interface IDisqueraService {
    public List<Disquera> findAll();
    public void save (Disquera disquera);
    public Disquera findOne(Integer id);
    public void delete(Integer id);
}
