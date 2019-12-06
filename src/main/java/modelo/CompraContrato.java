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
public class CompraContrato {
    int idcompracontrato;
    int idempresa;
    int idsucursal;
    int idaperturacontrato;
    double peso;
    double precio;
    String fecha;
    String estado;

    public CompraContrato() {
    }

    public CompraContrato(int idcompracontrato, int idempresa, int idsucursal, int idaperturacontrato, double peso, double precio, String fecha, String estado) {
        this.idcompracontrato = idcompracontrato;
        this.idempresa = idempresa;
        this.idsucursal = idsucursal;
        this.idaperturacontrato = idaperturacontrato;
        this.peso = peso;
        this.precio = precio;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getIdcompracontrato() {
        return idcompracontrato;
    }

    public void setIdcompracontrato(int idcompracontrato) {
        this.idcompracontrato = idcompracontrato;
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

    public int getIdaperturacontrato() {
        return idaperturacontrato;
    }

    public void setIdaperturacontrato(int idaperturacontrato) {
        this.idaperturacontrato = idaperturacontrato;
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
