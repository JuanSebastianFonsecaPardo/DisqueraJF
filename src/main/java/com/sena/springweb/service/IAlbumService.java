package com.sena.springweb.service;
import java.util.List;

import com.sena.springweb.model.Album;

public interface IAlbumService {
    
    public List<Album> findAll();
    public void save (Album album);
    public Album findOne(Integer id);
    public void delete(Integer id);
}
