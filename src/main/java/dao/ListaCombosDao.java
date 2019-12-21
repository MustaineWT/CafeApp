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
import modelo.ListaAgricultores;
import modelo.ListaCombos;

/**
 *
 * @author MustainE
 */
public class ListaCombosDao {
    public static ArrayList<ListaCombos> idCliente(
            int idempresa,
            int idsucursal
        ) {
        ArrayList ListaCombos = new ArrayList();
        ListaCombos cliente;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERCLIENTE(?,?)}");
            ps.setInt(1, idempresa);
            ps.setInt(2, idsucursal);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cliente = new ListaCombos();
                cliente.setIdpersona(rs.getInt(1));             
                cliente.setRazonsocial(rs.getString(2));
                ListaCombos.add(cliente);
            }
        } catch (Exception e) {
        }
        return ListaCombos;
    }
     public static ArrayList<ListaCombos> idTdocumento() {
        ArrayList ListaCombos = new ArrayList();
        ListaCombos tdocumento;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERTD()}");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tdocumento = new ListaCombos();
                tdocumento.setIdtdocumento(rs.getInt(1));             
                tdocumento.setIdentificador(rs.getString(2));
                ListaCombos.add(tdocumento);
            }
        } catch (Exception e) {
        }
        return ListaCombos;
    }
      public static ArrayList<ListaAgricultores> idAgricultores(int idempresa) {
        ArrayList ListaAgricultores = new ArrayList();
        ListaAgricultores lagricultores;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERPERSONA_AGRICULTOR(?)}");
            ps.setInt(1, idempresa);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lagricultores = new ListaAgricultores();
                lagricultores.setIdagricultor(rs.getInt(1));             
                lagricultores.setNombre(rs.getString(6));
                ListaAgricultores.add(lagricultores);
            }
        } catch (Exception e) {
        }
        return ListaAgricultores;
    }
}
