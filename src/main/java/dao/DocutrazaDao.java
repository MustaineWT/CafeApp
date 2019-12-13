/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.CompraContrato;
import modelo.Docutraza;
import modelo.TipoDocumento;

/**
 *
 * @author MustainE
 */
public class DocutrazaDao {

      public String insertDocutraza(
            int iddocutraza,
            int idempresa,
            int idsucursal,
            int idcompracontrato,
            int idpersona,
            String serie,
            String correlativo,
            String certificado,
            int sacos,
            double kb,
            double kn,
            String fairtrade,
            String condicion,
            String fecha,
            String estado) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call SP_ACTUALIZARDOCUTRAZA(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, iddocutraza);
            cs.setInt(2, idempresa);
            cs.setInt(3, idsucursal);
            cs.setInt(4, idcompracontrato);
            cs.setInt(5, idpersona);
            cs.setString(6, serie);
            cs.setString(7, correlativo);
            cs.setString(8, certificado);
            cs.setInt(9, sacos);
            cs.setDouble(10, kb);
            cs.setDouble(11, kn);
            cs.setString(12, fairtrade);
            cs.setString(13, condicion);
            cs.setString(14, fecha);
            cs.setString(15, estado);

            int numFAfectas = cs.executeUpdate();

            if (numFAfectas == -1) {
                rptaRegistro = "Registro Exitoso.";
            }
        } catch (Exception e) {

        }
        return rptaRegistro;
    }

    public String UpdateDocutraza(
            int iddocutraza,
            int idempresa,
            int idsucursal,
            int idcompracontrato,
            int idpersona,
            String serie,
            String correlativo,
            String certificado,
            int sacos,
            double kb,
            double kn,
            String fairtrade,
            String condicion,
            String fecha,
            String estado) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call SP_ACTUALIZARDOCUTRAZA(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, iddocutraza);
            cs.setInt(2, idempresa);
            cs.setInt(3, idsucursal);
            cs.setInt(4, idcompracontrato);
            cs.setInt(5, idpersona);
            cs.setString(6, serie);
            cs.setString(7, correlativo);
            cs.setString(8, certificado);
            cs.setInt(9, sacos);
            cs.setDouble(10, kb);
            cs.setDouble(11, kn);
            cs.setString(12, fairtrade);
            cs.setString(13, condicion);
            cs.setString(14, fecha);
            cs.setString(15, estado);

            int numFAfectas = cs.executeUpdate();

            if (numFAfectas == -1) {
                rptaRegistro = "Registro Exitoso.";
            }
        } catch (Exception e) {

        }
        return rptaRegistro;
    }

    public static ArrayList<Docutraza> listDocutraza(
            int idempresa,
            int idsucursal) {
        ArrayList listaDocutraza = new ArrayList();
        Docutraza docutraza;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERDOCUTRAZA(?,?)}");            
            ps.setInt(1, idempresa);
            ps.setInt(2, idsucursal);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()) {
                docutraza = new Docutraza();                                
                docutraza.setIddocutraza(rs.getInt(1));
                docutraza.setIdempresa(rs.getInt(2));
                docutraza.setIdsucursal(rs.getInt(3));
                docutraza.setIdcompracontrato(rs.getInt(4));
                docutraza.setIdpersona(rs.getInt(5));
                docutraza.setRazonsocial(rs.getString(6));
                docutraza.setSerieguia(rs.getString(7));
                docutraza.setCorrelativo(rs.getString(8));
                docutraza.setCertificado(rs.getString(9));
                docutraza.setSacos(rs.getInt(10));
                docutraza.setKb(rs.getDouble(11));
                docutraza.setKn(rs.getDouble(12));
                docutraza.setFairtrade(rs.getString(13));
                docutraza.setCondicion(rs.getString(14));
                docutraza.setFecha(rs.getString(15));
                docutraza.setEstado(rs.getString(16));
                listaDocutraza.add(docutraza);
            }
            rs.close();
        } catch (Exception e) {

        }
        return listaDocutraza;
    }
    public static ArrayList<CompraContrato> listCompraContrato(
            int idempresa,
            int idsucursal) {
        ArrayList listaCompracontrato = new ArrayList();
        CompraContrato compracontrato;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERCOMPRACONTRATO_DOCUTRAZA(?,?)}");            
            ps.setInt(1, idempresa);
            ps.setInt(2, idsucursal);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()) {
                compracontrato = new CompraContrato();                                
                compracontrato.setIdcompracontrato(rs.getInt(1));
                compracontrato.setIdempresa(rs.getInt(2));
                compracontrato.setIdsucursal(rs.getInt(3));
                compracontrato.setIdaperturacontrato(rs.getInt(4));
                compracontrato.setPeso(rs.getDouble(5));
                compracontrato.setPrecio(rs.getDouble(6));
                compracontrato.setImptotal(rs.getDouble(7));
                compracontrato.setFecha(rs.getString(8));
                compracontrato.setEstado(rs.getString(9));
                listaCompracontrato.add(compracontrato);
            }
            rs.close();
        } catch (Exception e) {

        }
        return listaCompracontrato;
    }
    
    public static ArrayList<Docutraza> SelectDocutraza(
            int idempresa,
            int idsucursal,
            int iddocutraza) {
        ArrayList listaDocutraza = new ArrayList();
        Docutraza docutraza;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERDOCUTRAZA_SELECT(?,?,?)}");            
            ps.setInt(1, idempresa);
            ps.setInt(2, idsucursal);
            ps.setInt(3, iddocutraza);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()) {
                docutraza = new Docutraza();                                
                docutraza.setIddocutraza(rs.getInt(1));
                docutraza.setIdempresa(rs.getInt(2));
                docutraza.setIdsucursal(rs.getInt(3));
                docutraza.setIdcompracontrato(rs.getInt(4));
                docutraza.setCliente(rs.getString(5));
                docutraza.setSerieguia(rs.getString(6));
                docutraza.setCorrelativo(rs.getString(7));
                docutraza.setCertificado(rs.getString(8));
                docutraza.setSacos(rs.getInt(9));
                docutraza.setKb(rs.getDouble(10));
                docutraza.setKn(rs.getDouble(11));
                docutraza.setFairtrade(rs.getString(12));
                docutraza.setCondicion(rs.getString(13));
                docutraza.setFecha(rs.getString(14));
                docutraza.setEstado(rs.getString(15));
                listaDocutraza.add(docutraza);
            }
            rs.close();
        } catch (Exception e) {

        }
        return listaDocutraza;
    }
       
    public static ArrayList<CompraContrato> listCompraContratoBuscar(
            int idempresa,
            int idsucursal,
            String texto) {
        ArrayList listaDocutraza = new ArrayList();
        CompraContrato docutraza;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERAPERTURACONTRATOBUSCAR(?,?,?)}");
            ps.setInt(1, idempresa);
            ps.setInt(2, idsucursal);
            ps.setString(3, texto);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                docutraza = new CompraContrato();                                
//                docutraza.setIddocutraza(rs.getInt(1));
//                docutraza.setIdempresa(rs.getInt(2));
//                docutraza.setIdsucursal(rs.getInt(3));
//                docutraza.setIdcompracontrato(rs.getInt(4));
//                docutraza.setCliente(rs.getString(5));
//                docutraza.setSerieguia(rs.getString(6));
//                docutraza.setCorrelativo(rs.getString(7));
//                docutraza.setCertificado(rs.getString(8));
//                docutraza.setSacos(rs.getInt(9));
//                docutraza.setKb(rs.getDouble(10));
//                docutraza.setKn(rs.getDouble(11));
//                docutraza.setFairtrade(rs.getString(12));
//                docutraza.setCondicion(rs.getString(13));
//                docutraza.setFecha(rs.getString(14));
//                docutraza.setEstado(rs.getString(15));
                listaDocutraza.add(docutraza);
            }
        } catch (Exception e) {

        }
        return listaDocutraza;
    }
    
    public static ArrayList<Docutraza> listDocutrazaBuscar(
            int idempresa,
            int idsucursal,
            String texto) {
        ArrayList listaDocutraza = new ArrayList();
        Docutraza docutraza;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERAPERTURACONTRATOBUSCAR(?,?,?)}");
            ps.setInt(1, idempresa);
            ps.setInt(2, idsucursal);
            ps.setString(3, texto);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                docutraza = new Docutraza();                                
                docutraza.setIddocutraza(rs.getInt(1));
                docutraza.setIdempresa(rs.getInt(2));
                docutraza.setIdsucursal(rs.getInt(3));
                docutraza.setIdcompracontrato(rs.getInt(4));
                docutraza.setCliente(rs.getString(5));
                docutraza.setSerieguia(rs.getString(6));
                docutraza.setCorrelativo(rs.getString(7));
                docutraza.setCertificado(rs.getString(8));
                docutraza.setSacos(rs.getInt(9));
                docutraza.setKb(rs.getDouble(10));
                docutraza.setKn(rs.getDouble(11));
                docutraza.setFairtrade(rs.getString(12));
                docutraza.setCondicion(rs.getString(13));
                docutraza.setFecha(rs.getString(14));
                docutraza.setEstado(rs.getString(15));
                listaDocutraza.add(docutraza);
            }
        } catch (Exception e) {

        }
        return listaDocutraza;
    }
    
     public static ArrayList<Docutraza> idNuevoDocutraza() {
        ArrayList listaDocutraza = new ArrayList();
        Docutraza docutraza;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERIDNUEVOAPC()}");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                docutraza = new Docutraza();
                docutraza.setIddocutraza(rs.getInt(1));             
                listaDocutraza.add(docutraza);
            }
        } catch (Exception e) {
        }
        return listaDocutraza;
    }
  public static ArrayList<TipoDocumento> idNuevoTD() {
        ArrayList listaTipodocumento = new ArrayList();
        TipoDocumento tipodocumento;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERIDNUEVOTD()}");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tipodocumento = new TipoDocumento();
                tipodocumento.setIdtipodocumento(rs.getInt(1));             
                listaTipodocumento.add(tipodocumento);
            }
        } catch (Exception e) {
        }
        return listaTipodocumento;
    }
    
    
    
}
