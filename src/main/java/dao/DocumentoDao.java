/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import modelo.Documento;

/**
 *
 * @author MustainE
 */
public class DocumentoDao {

    public String insertDocumento(
           int iddocumento,
           int idempresa,
           int idsucursal,
           int iddocutraza,
           int idtipodocumento,
           String serie,
           String correlativo,
           String fecha,
           String estado) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call SP_ACTUALIZARDOCUMENTO(?,?,?,?,?,?,?,?)}");
            cs.setInt(1, iddocumento);
            cs.setInt(2, idempresa);
            cs.setInt(3, idsucursal);
            cs.setInt(4, iddocutraza);
            cs.setInt(5, idtipodocumento);
            cs.setString(6, serie);
            cs.setString(7, correlativo);
            cs.setString(8, fecha);
            cs.setString(9, estado);
       

            int numFAfectas = cs.executeUpdate();

            if (numFAfectas == -1) {
                rptaRegistro = "Registro Exitoso.";
            }
        } catch (Exception e) {

        }
        return rptaRegistro;
    }

    public String UpdateDocumento(
           int iddocumento,
           int idempresa,
           int idsucursal,
           int iddocutraza,
           int idtipodocumento,
           String serie,
           String correlativo,
           String fecha,
           String estado) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call SP_ACTUALIZARDOCUMENTO(?,?,?,?,?,?,?,?)}");
            cs.setInt(1, iddocumento);
            cs.setInt(2, idempresa);
            cs.setInt(3, idsucursal);
            cs.setInt(4, iddocutraza);
            cs.setInt(5, idtipodocumento);
            cs.setString(6, serie);
            cs.setString(7, correlativo);
            cs.setString(8, fecha);
            cs.setString(9, estado);

            int numFAfectas = cs.executeUpdate();

            if (numFAfectas == -1) {
                rptaRegistro = "Registro Exitoso.";
            }
        } catch (Exception e) {

        }
        return rptaRegistro;
    }

    public ArrayList<Documento> listDocumento() {
        ArrayList listaDocumento = new ArrayList();
        Documento documento;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERDOCUMENTO()}");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                documento = new Documento();
                documento.setIdentificador(rs.getString(1));
                documento.setDescripcion(rs.getString(2));
                documento.setSerie(rs.getString(3));//armar otro para la vista
                documento.setCorrelativo(rs.getString(3));//armar otro para la vista
                documento.setFecha(rs.getString(4));
                documento.setEstado(rs.getString(5));
                listaDocumento.add(documento);
            }
        } catch (Exception e) {

        }
        return listaDocumento;
    }
  
   
    public ArrayList<Documento> nomDocumento() {
        ArrayList listaEmpresas = new ArrayList();
        Documento documento;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement("SELECT idempresa,RazonSocial FROM empresa where estado='A'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                documento = new Documento();
                documento.setIddocumento(rs.getInt(1));
                documento.setDescripcion(rs.getString(2));
                listaEmpresas.add(documento);
            }
        } catch (Exception e) {

        }
        return listaEmpresas;
    }
}