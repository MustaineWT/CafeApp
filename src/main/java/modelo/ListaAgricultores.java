/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author wmtor
 */
public class ListaAgricultores {
    int idagricultor;
    String nombre;
        public ListaAgricultores() {
    }
      
    public ListaAgricultores(int idagricultor, String nombre) {
        this.idagricultor = idagricultor;
        this.nombre = nombre;
    }
    
     public int getIdagricultor() {
        return idagricultor;
    }

    public void setIdagricultor(int idagricultor) {
        this.idagricultor = idagricultor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String toString(){
        return nombre;
    }
    
}
