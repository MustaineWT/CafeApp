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
public class ListaCombos {
    int idpersona;
    String razonsocial;

    public ListaCombos() {
    }

    public ListaCombos(int idpersona, String razonsocial) {
        this.idpersona = idpersona;
        this.razonsocial = razonsocial;
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
    public String toString(){
        return razonsocial;
    }
    

}
