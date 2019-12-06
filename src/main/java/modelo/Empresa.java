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
public class Empresa {
    int idempresa;
    String razonSocial;
    String ruc;
    String direccion;
    String distrito;
    String ciudad;
    String pais;
    String gironegocio;
    String tipoexportacion;
    String estado;

    public Empresa() {
    }

    public Empresa(int idempresa, String razonSocial, String ruc, String direccion, String distrito, String ciudad, String pais, String gironegocio, String tipoexportacion, String estado) {
        this.idempresa = idempresa;
        this.razonSocial = razonSocial;
        this.ruc = ruc;
        this.direccion = direccion;
        this.distrito = distrito;
        this.ciudad = ciudad;
        this.pais = pais;
        this.gironegocio = gironegocio;
        this.tipoexportacion = tipoexportacion;
        this.estado = estado;
    }

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
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

    public String getTipoexportacion() {
        return tipoexportacion;
    }

    public void setTipoexportacion(String tipoexportacion) {
        this.tipoexportacion = tipoexportacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
