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
public class Documento {
    int iddocumento;
    int idempresa;
    int idsucursal;
    int iddocutraza;
    int idtipodocumento;
    String serie;
    String Correlativo;
    String fecha;
    String estado;
    String identificador;
    String descripcion;
          

    public Documento() {
    }

    public Documento(int iddocumento,String identificador, String descripcion, String serie, String Correlativo, String fecha, String estado) {
        this.iddocumento = iddocumento;
        this.identificador = identificador;
        this.descripcion = descripcion;
        this.serie = serie;
        this.Correlativo = Correlativo;
        this.fecha = fecha;
        this.estado = estado;        
    }

     
    public Documento(int iddocumento, int idempresa, int idsucursal, int iddocutraza, int idtipodocumento, String serie, String Correlativo, String fecha, String estado) {
        this.iddocumento = iddocumento;
        this.idempresa = idempresa;
        this.idsucursal = idsucursal;
        this.iddocutraza = iddocutraza;
        this.idtipodocumento = idtipodocumento;
        this.serie = serie;
        this.Correlativo = Correlativo;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getIddocumento() {
        return iddocumento;
    }

    public void setIddocumento(int iddocumento) {
        this.iddocumento = iddocumento;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public int getIddocutraza() {
        return iddocutraza;
    }

    public void setIddocutraza(int iddocutraza) {
        this.iddocutraza = iddocutraza;
    }

    public int getIdtipodocumento() {
        return idtipodocumento;
    }

    public void setIdtipodocumento(int idtipodocumento) {
        this.idtipodocumento = idtipodocumento;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getCorrelativo() {
        return Correlativo;
    }

    public void setCorrelativo(String Correlativo) {
        this.Correlativo = Correlativo;
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
