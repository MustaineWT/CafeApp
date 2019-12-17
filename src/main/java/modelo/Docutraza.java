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
public class Docutraza {
    int iddocutraza;
    int idempresa;
    int idsucursal;
    int idcompracontrato;
    int idpersona;
    String razonsocial;
    String cliente;
    String serieguia;
    String correlativo;
    String certificado;
    int sacos;
    double kb;
    double precio;
    double kn;
    String fairtrade;
    String condicion;
    String fecha;
    String estado;

    public Docutraza() {
        
    }

    public Docutraza(int iddocutraza, int idempresa, int idsucursal, int idcompracontrato, String cliente, String serieguia, String correlativo, String certificado, int sacos, double kb, double kn, String fairtrade, String condicion, String fecha, String estado) {
        this.iddocutraza = iddocutraza;
        this.idempresa = idempresa;
        this.idsucursal = idsucursal;
        this.idcompracontrato = idcompracontrato;
        this.cliente = cliente;
        this.serieguia = serieguia;
        this.correlativo = correlativo;
        this.certificado = certificado;
        this.sacos = sacos;
        this.kb = kb;
        this.kn = kn;
        this.fairtrade = fairtrade;
        this.condicion = condicion;
        this.fecha = fecha;
        this.estado = estado;
    }
//
//    public Docutraza(int iddocutraza, int idempresa, int idsucursal, int idcompracontrato, int idpersona, String razonsocial, String cliente, String serieguia, String correlativo, String certificado, int sacos, double kb, double precio, double kn, String fairtrade, String condicion, String fecha, String estado) {
//        this.iddocutraza = iddocutraza;
//        this.idempresa = idempresa;
//        this.idsucursal = idsucursal;
//        this.idcompracontrato = idcompracontrato;
//        this.idpersona = idpersona;
//        this.razonsocial = razonsocial;
//        this.cliente = cliente;
//        this.serieguia = serieguia;
//        this.correlativo = correlativo;
//        this.certificado = certificado;
//        this.sacos = sacos;
//        this.kb = kb;
//        this.precio = precio;
//        this.kn = kn;
//        this.fairtrade = fairtrade;
//        this.condicion = condicion;
//        this.fecha = fecha;
//        this.estado = estado;
//    }

    public Docutraza(int iddocutraza, int idempresa, int idsucursal, int idcompracontrato, int idpersona, String razonsocial, String serieguia, String correlativo, String certificado, int sacos, double kb, double precio, double kn, String fairtrade, String condicion, String fecha, String estado) {
        this.iddocutraza = iddocutraza;
        this.idempresa = idempresa;
        this.idsucursal = idsucursal;
        this.idcompracontrato = idcompracontrato;
        this.idpersona = idpersona;
        this.razonsocial = razonsocial;
        this.serieguia = serieguia;
        this.correlativo = correlativo;
        this.certificado = certificado;
        this.sacos = sacos;
        this.kb = kb;
        this.precio = precio;
        this.kn = kn;
        this.fairtrade = fairtrade;
        this.condicion = condicion;
        this.fecha = fecha;
        this.estado = estado;
    }
    
    

    public int getIddocutraza() {
        return iddocutraza;
    }

    public void setIddocutraza(int iddocutraza) {
        this.iddocutraza = iddocutraza;
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

    public int getIdcompracontrato() {
        return idcompracontrato;
    }

    public void setIdcompracontrato(int idcompracontrato) {
        this.idcompracontrato = idcompracontrato;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getSerieguia() {
        return serieguia;
    }

    public void setSerieguia(String serieguia) {
        this.serieguia = serieguia;
    }

    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getKn() {
        return kn;
    }

    public void setKn(double kn) {
        this.kn = kn;
    }

    public String getFairtrade() {
        return fairtrade;
    }

    public void setFairtrade(String fairtrade) {
        this.fairtrade = fairtrade;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
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
