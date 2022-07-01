package com.sena.springweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.springweb.model.Album;
import com.sena.springweb.model.IAlbum;

@Service
public class AlbumServicelmpl implements IAlbumService{

    @Autowired
    private IAlbum lopez;
    
    @Override
    public List<Album> findAll() {
        return (List<Album>) lopez.findAll();
    }

    @Override
    public void save(Album album) {
        lopez.save(album);
    }

    @Override
    public Album findOne(Integer id) {
        return lopez.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        lopez.deleteById(id);
        
    }
    
}
