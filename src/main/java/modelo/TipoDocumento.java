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
public class TipoDocumento {
    int idtipodocumento;
    String identificador;
    String descripcion;
    String estado;

    public TipoDocumento() {
    }

    public TipoDocumento(int idtipodocumento, String identificador, String descripcion, String estado) {
        this.idtipodocumento = idtipodocumento;
        this.identificador = identificador;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getIdtipodocumento() {
        return idtipodocumento;
    }

    public void setIdtipodocumento(int idtipodocumento) {
        this.idtipodocumento = idtipodocumento;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
