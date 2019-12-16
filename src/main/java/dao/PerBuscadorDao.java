/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.PerBuscador;

/**
 *
 * @author MustainE
 */
public class PerBuscadorDao {
     public static ArrayList<PerBuscador> listPerBuscador(
            int idempresa) {
        ArrayList listaPerbuscador = new ArrayList();
        PerBuscador perbuscador;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERPERSONA_AGRICULTOR(?)}");            
            ps.setInt(1, idempresa);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()) {
                perbuscador = new PerBuscador();                                
                perbuscador.setIdpersona(rs.getInt(1));
                perbuscador.setIdorga(rs.getString(2));
                perbuscador.setIdcp(rs.getString(3));
                perbuscador.setIdcafepractice(rs.getString(4));
                perbuscador.setCodagricultor(rs.getString(5));
                perbuscador.setNombres(rs.getString(6));
                perbuscador.setApellidos(rs.getString(7));
                perbuscador.setDniruc(rs.getString(8));
                perbuscador.setProvincia(rs.getString(9));
                perbuscador.setNomfinca(rs.getString(11));
                perbuscador.setNomanexo(rs.getString(12));
                perbuscador.setEstado(rs.getString(13));
                listaPerbuscador.add(perbuscador);
            }
            rs.close();
        } catch (Exception e) {

        }
        return listaPerbuscador;
    }  
            
     public static ArrayList<PerBuscador> listPerBuscadorBuscar(
            int idempresa,
             String texto) {
        ArrayList listaPerbuscador = new ArrayList();
        PerBuscador perbuscador;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERPERSONA_BUSCAR_AGRICULTOR(?,?)}");            
            ps.setInt(1, idempresa);
            ps.setString(1, texto);            
            ResultSet rs = ps.executeQuery();            
            while (rs.next()) {
                perbuscador = new PerBuscador();                                
                perbuscador.setIdpersona(rs.getInt(1));
                perbuscador.setIdorga(rs.getString(2));
                perbuscador.setIdcp(rs.getString(3));
                perbuscador.setIdcafepractice(rs.getString(4));
                perbuscador.setCodagricultor(rs.getString(5));
                perbuscador.setNombres(rs.getString(6));
                perbuscador.setApellidos(rs.getString(7));
                perbuscador.setDniruc(rs.getString(8));
                perbuscador.setProvincia(rs.getString(9));
                perbuscador.setNomfinca(rs.getString(11));
                perbuscador.setNomanexo(rs.getString(12));
                perbuscador.setEstado(rs.getString(13));
                listaPerbuscador.add(perbuscador);
            }
            rs.close();
        } catch (Exception e) {

        }
        return listaPerbuscador;
    }  
            
}
