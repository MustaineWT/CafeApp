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
public class AperturaContrato {
    int idaperturacontrato;
    int idempresa;
    int idsucursal;
    int idpersona;
    double peso;
    double precio;
    String calidad;
    String humedad;
    String contrato;
    String fecha;
    String estado;

    public AperturaContrato() {
    }

    public AperturaContrato(int idaperturacontrato, int idempresa, int idsucursal, int idpersona, double peso, double precio, String calidad, String humedad, String contrato, String fecha, String estado) {
        this.idaperturacontrato = idaperturacontrato;
        this.idempresa = idempresa;
        this.idsucursal = idsucursal;
        this.idpersona = idpersona;
        this.peso = peso;
        this.precio = precio;
        this.calidad = calidad;
        this.humedad = humedad;
        this.contrato = contrato;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getIdaperturacontrato() {
        return idaperturacontrato;
    }

    public void setIdaperturacontrato(int idaperturacontrato) {
        this.idaperturacontrato = idaperturacontrato;
    }

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    public int getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(int idsucursal) {
        this.idsucursal = idsucursal;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public String getHumedad() {
        return humedad;
    }

    public void setHumedad(String humedad) {
        this.humedad = humedad;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
