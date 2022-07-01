package com.sena.springweb.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table 
public class Cancion {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String nombrecancion;

    @Column(length = 20)
    private String fechgrab;

    @Column(length=5)
    private String duracionmin;

    @Column
    private Boolean estado;

    @ManyToOne(fetch = FetchType.LAZY)
    private Album album;

    public Cancion(){
        
    }

    public Cancion(Integer id, String nombrecancion, String fechgrab, String duracionmin, Boolean estado,
            Album album) {
        this.id = id;
        this.nombrecancion = nombrecancion;
        this.fechgrab = fechgrab;
        this.duracionmin = duracionmin;
        this.estado = estado;
        this.album = album;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombrecancion() {
        return nombrecancion;
    }

    public void setNombrecancion(String nombrecancion) {
        this.nombrecancion = nombrecancion;
    }

    public String getFechgrab() {
        return fechgrab;
    }

    public void setFechgrab(String fechgrab) {
        this.fechgrab = fechgrab;
    }

    public String getDuracionmin() {
        return duracionmin;
    }

    public void setDuracionmin(String duracionmin) {
        this.duracionmin = duracionmin;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
