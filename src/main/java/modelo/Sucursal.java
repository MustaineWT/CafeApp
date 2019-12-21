/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author MustainE
 */
public class Sucursal {
    int idempresa;
    int idsucursal;    
    String rsocial;
    String nombreciudad;
    String ruc;
    String direccion;
    String distrito;
    String ciudad;
    String pais;
    String gironegocio;
    String estado;

    public Sucursal() {
    }

    public Sucursal(int idempresa, int idsucursal, String rsocial, String nombreciudad, String ruc, String gironegocio) {
        this.idempresa = idempresa;
        this.idsucursal = idsucursal;
        this.rsocial = rsocial;
        this.nombreciudad = nombreciudad;
        this.ruc = ruc;
        this.gironegocio = gironegocio;
    }


    public Sucursal(int idsucursal, int idempresa, String nombreciudad, String ruc, String direccion, String distrito, String ciudad, String pais, String gironegocio, String estado) {
        this.idsucursal = idsucursal;
        this.idempresa = idempresa;
        this.nombreciudad = nombreciudad;
        this.ruc = ruc;
        this.direccion = direccion;
        this.distrito = distrito;
        this.ciudad = ciudad;
        this.pais = pais;
        this.gironegocio = gironegocio;
        this.estado = estado;
    }

    public String getRsocial() {
        return rsocial;
    }

    public void setRsocial(String rsocial) {
        this.rsocial = rsocial;
    }

    
    public int getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(int idsucursal) {
        this.idsucursal = idsucursal;
    }

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    public String getNombreciudad() {
        return nombreciudad;
    }

    public void setNombreciudad(String nombreciudad) {
        this.nombreciudad = nombreciudad;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getGironegocio() {
        return gironegocio;
    }

    public void setGironegocio(String gironegocio) {
        this.gironegocio = gironegocio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
