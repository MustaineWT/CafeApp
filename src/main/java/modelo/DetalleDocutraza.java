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
public class DetalleDocutraza {
    int iddetalledocutraza;
    int iddocutraza;
    int idlpaestimado;
    int idlpacontable;
    int idpersona;
    int sacos;
    double kb;
    double tara;
    double kn;
    double precio;
    double importetotal;
    String liqcompra;
    String fecha;
    String estado;

    public DetalleDocutraza() {
    }

    public DetalleDocutraza(int iddetalledocutraza, int iddocutraza, int idlpaestimado, int idlpacontable, int idpersona, int sacos, double kb, double tara, double kn, double precio, double importetotal, String liqcompra, String fecha, String estado) {
        this.iddetalledocutraza = iddetalledocutraza;
        this.iddocutraza = iddocutraza;
        this.idlpaestimado = idlpaestimado;
        this.idlpacontable = idlpacontable;
        this.idpersona = idpersona;
        this.sacos = sacos;
        this.kb = kb;
        this.tara = tara;
        this.kn = kn;
        this.precio = precio;
        this.importetotal = importetotal;
        this.liqcompra = liqcompra;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getIddetalledocutraza() {
        return iddetalledocutraza;
    }

    public void setIddetalledocutraza(int iddetalledocutraza) {
        this.iddetalledocutraza = iddetalledocutraza;
    }

    public int getIddocutraza() {
        return iddocutraza;
    }

    public void setIddocutraza(int iddocutraza) {
        this.iddocutraza = iddocutraza;
    }

    public int getIdlpaestimado() {
        return idlpaestimado;
    }

    public void setIdlpaestimado(int idlpaestimado) {
        this.idlpaestimado = idlpaestimado;
    }

    public int getIdlpacontable() {
        return idlpacontable;
    }

    public void setIdlpacontable(int idlpacontable) {
        this.idlpacontable = idlpacontable;
    }

 
    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public int getSacos() {
        return sacos;
    }

    public void setSacos(int sacos) {
        this.sacos = sacos;
    }

    public double getKb() {
        return kb;
    }

    public void setKb(double kb) {
        this.kb = kb;
    }

    public double getTara() {
        return tara;
    }

    public void setTara(double tara) {
        this.tara = tara;
    }

    public double getKn() {
        return kn;
    }

    public void setKn(double kn) {
        this.kn = kn;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getImportetotal() {
        return importetotal;
    }

    public void setImportetotal(double importetotal) {
        this.importetotal = importetotal;
    }

    public String getLiqcompra() {
        return liqcompra;
    }

    public void setLiqcompra(String liqcompra) {
        this.liqcompra = liqcompra;
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
