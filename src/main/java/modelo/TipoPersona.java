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
public class TipoPersona {
    int idtipopersona;
    int idpersona;
    int agricultor;
    int cliente;
    int proveedor;
    int tercero;
    int empleado;
    String estado;

    public TipoPersona() {
    }

    public TipoPersona(int idtipopersona, int idpersona, int agricultor, int cliente, int proveedor, int tercero, int empleado, String estado) {
        this.idtipopersona = idtipopersona;
        this.idpersona = idpersona;
        this.agricultor = agricultor;
        this.cliente = cliente;
        this.proveedor = proveedor;
        this.tercero = tercero;
        this.empleado = empleado;
        this.estado = estado;
    }

    public int getIdtipopersona() {
        return idtipopersona;
    }

    public void setIdtipopersona(int idtipopersona) {
        this.idtipopersona = idtipopersona;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public int getAgricultor() {
        return agricultor;
    }

    public void setAgricultor(int agricultor) {
        this.agricultor = agricultor;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }

    public int getTercero() {
        return tercero;
    }

    public void setTercero(int tercero) {
        this.tercero = tercero;
    }

    public int getEmpleado() {
        return empleado;
    }

    public void setEmpleado(int empleado) {
        this.empleado = empleado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
