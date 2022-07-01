package com.sena.springweb.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Album {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String nombrealbum;

    @Column(length = 4)
    private Integer aniopublicacion;

    @Column
    private Boolean estado;

    @OneToMany(mappedBy = "album",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Cancion> cancion;

    @ManyToOne(fetch = FetchType.LAZY)
    private Genero genero;

    @ManyToOne(fetch = FetchType.LAZY)
    private Artista artista;

    //constructores 
    public Album(){
        cancion=new ArrayList<Cancion>();
    }

	public Album(Integer id, String nombrealbum, Integer aniopublicacion, Boolean estado, List<Cancion> cancion,
			Genero genero, Artista artista) {
		this.id = id;
		this.nombrealbum = nombrealbum;
		this.aniopublicacion = aniopublicacion;
		this.estado = estado;
		this.cancion = cancion;
		this.genero = genero;
		this.artista = artista;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombrealbum() {
		return nombrealbum;
	}

	public void setNombrealbum(String nombrealbum) {
		this.nombrealbum = nombrealbum;
	}

	public Integer getAniopublicacion() {
		return aniopublicacion;
	}

	public void setAniopublicacion(Integer aniopublicacion) {
		this.aniopublicacion = aniopublicacion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public List<Cancion> getCancion() {
		return cancion;
	}

	public void setCancion(List<Cancion> cancion) {
		this.cancion = cancion;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}
}