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
public class Artista {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private Integer nodocumento;

    @Column(length = 50)
    private String tipodocumento;

    @Column(length = 10)
    private String nombreartista;

    @Column(length=10)
    private String apellidoartista;

    @Column(length = 10)
    private String nombreartistico;

    @Column
    private String fechanacimiento;

    @Column(length = 10)
    private String emailartista;

    @Column
    private Boolean estado;

    @ManyToOne(fetch = FetchType.LAZY)
    private Disquera disquera;


    //consturctores

    public Artista(){

    }


    public Artista(Integer id, Integer nodocumento, String tipodocumento, String nombreartista,
            String apellidoartista, String nombreartistico, String fechanacimiento, String emailartista,
            Boolean estado) {
        this.id = id;
        this.nodocumento = nodocumento;
        this.tipodocumento = tipodocumento;
        this.nombreartista = nombreartista;
        this.apellidoartista = apellidoartista;
        this.nombreartistico = nombreartistico;
        this.fechanacimiento = fechanacimiento;
        this.emailartista = emailartista;
        this.estado = estado;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getNodocumento() {
        return nodocumento;
    }


    public void setNodocumento(Integer nodocumento) {
        this.nodocumento = nodocumento;
    }


    public String getTipodocumento() {
        return tipodocumento;
    }


    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }


    public String getNombreartista() {
        return nombreartista;
    }


    public void setNombreartista(String nombreartista) {
        this.nombreartista = nombreartista;
    }


    public String getApellidoartista() {
        return apellidoartista;
    }


    public void setApellidoartista(String apellidoartista) {
        this.apellidoartista = apellidoartista;
    }


    public String getNombreartistico() {
        return nombreartistico;
    }


    public void setNombreartistico(String nombreartistico) {
        this.nombreartistico = nombreartistico;
    }


    public String getFechanacimiento() {
        return fechanacimiento;
    }


    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }


    public String getEmailartista() {
        return emailartista;
    }


    public void setEmailartista(String emailartista) {
        this.emailartista = emailartista;
    }


    public Boolean getEstado() {
        return estado;
    }


    public void setEstado(Boolean estado) {
        this.estado = estado;
    }


    public Disquera getDisquera() {
        return disquera;
    }


    public void setDisquera(Disquera disquera) {
        this.disquera = disquera;
    }
}