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
public class PerBuscador {
    int idpersona;
    String idorga;
    String idcp;
    String idcafepractice;
    String codagricultor;
    String nombres;
    String apellidos;
    String dniruc;
    String provincia;
    String nomfinca;
    String nomanexo;
    String estado;

    public PerBuscador() {
    }

    public PerBuscador(int idpersona, String idorga, String idcp, String idcafepractice, String codagricultor, String nombres, String apellidos, String dniruc, String provincia, String nomfinca, String nomanexo, String estado) {
        this.idpersona = idpersona;
        this.idorga = idorga;
        this.idcp = idcp;
        this.idcafepractice = idcafepractice;
        this.codagricultor = codagricultor;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dniruc = dniruc;
        this.provincia = provincia;
        this.nomfinca = nomfinca;
        this.nomanexo = nomanexo;
        this.estado = estado;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getIdorga() {
        return idorga;
    }

    public void setIdorga(String idorga) {
        this.idorga = idorga;
    }

    public String getIdcp() {
        return idcp;
    }

    public void setIdcp(String idcp) {
        this.idcp = idcp;
    }

    public String getIdcafepractice() {
        return idcafepractice;
    }

    public void setIdcafepractice(String idcafepractice) {
        this.idcafepractice = idcafepractice;
    }

    public String getCodagricultor() {
        return codagricultor;
    }

    public void setCodagricultor(String codagricultor) {
        this.codagricultor = codagricultor;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDniruc() {
        return dniruc;
    }

    public void setDniruc(String dniruc) {
        this.dniruc = dniruc;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getNomfinca() {
        return nomfinca;
    }

    public void setNomfinca(String nomfinca) {
        this.nomfinca = nomfinca;
    }

    public String getNomanexo() {
        return nomanexo;
    }

    public void setNomanexo(String nomanexo) {
        this.nomanexo = nomanexo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
          
}
