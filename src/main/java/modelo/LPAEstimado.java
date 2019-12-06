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
public class LPAEstimado {
    int idlpaestimado;
    int idempresa;
    int idsucursal;
    int idpersona;
    int ejercicio;
    double cpinicial;
    double ftinicial;
    double rainfinicial;
    double convinicial;
    String estado;

    public LPAEstimado() {
    }

    public LPAEstimado(int idlpaestimado, int idempresa, int idsucursal, int idpersona, int ejercicio, double cpinicial, double ftinicial, double rainfinicial, double convinicial, String estado) {
        this.idlpaestimado = idlpaestimado;
        this.idempresa = idempresa;
        this.idsucursal = idsucursal;
        this.idpersona = idpersona;
        this.ejercicio = ejercicio;
        this.cpinicial = cpinicial;
        this.ftinicial = ftinicial;
        this.rainfinicial = rainfinicial;
        this.convinicial = convinicial;
        this.estado = estado;
    }

    public int getIdlpaestimado() {
        return idlpaestimado;
    }

    public void setIdlpaestimado(int idlpaestimado) {
        this.idlpaestimado = idlpaestimado;
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

    public int getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(int ejercicio) {
        this.ejercicio = ejercicio;
    }

    public double getCpinicial() {
        return cpinicial;
    }

    public void setCpinicial(double cpinicial) {
        this.cpinicial = cpinicial;
    }

    public double getFtinicial() {
        return ftinicial;
    }

    public void setFtinicial(double ftinicial) {
        this.ftinicial = ftinicial;
    }

    public double getRainfinicial() {
        return rainfinicial;
    }

    public void setRainfinicial(double rainfinicial) {
        this.rainfinicial = rainfinicial;
    }

    public double getConvinicial() {
        return convinicial;
    }

    public void setConvinicial(double convinicial) {
        this.convinicial = convinicial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
