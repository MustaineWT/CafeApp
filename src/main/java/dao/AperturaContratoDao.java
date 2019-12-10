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
import modelo.AperturaContrato;

/**
 *
 * @author MustainE
 */
public class AperturaContratoDao {

    public String insertAperturaContrato(
            int idaperturacontrato,
            int idempresa,
            int idsucursal,
            double peso,
            double precio,
            double imptotal,
            String calidad,
            String humedad,
            String contrato,
            int idpersona,
            String fecha,
            String estado) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call SP_ACTUALIZARAPERTURACONTRATO(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, idaperturacontrato);
            cs.setInt(2, idempresa);
            cs.setInt(3, idsucursal);
            cs.setDouble(4, peso);
            cs.setDouble(5, precio);
            cs.setDouble(6, imptotal);
            cs.setString(7, calidad);
            cs.setString(8, humedad);
            cs.setString(9, contrato);
            cs.setInt(10, idpersona);
            cs.setString(11, fecha);
            cs.setString(12, estado);

            int numFAfectas = cs.executeUpdate();

            if (numFAfectas == -1) {
                rptaRegistro = "Registro Exitoso.";
            }
        } catch (Exception e) {

        }
        return rptaRegistro;
    }

    public String UpdateAperturaContrato(
            int idaperturacontrato,
            int idempresa,
            int idsucursal,
            double peso,
            double precio,
            double imptotal,
            String calidad,
            String humedad,
            String contrato,
            int idpersona,
            String fecha,
            String estado) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call SP_ACTUALIZARAPERTURACONTRATO(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, idaperturacontrato);
            cs.setInt(2, idempresa);
            cs.setInt(3, idsucursal);
            cs.setDouble(4, peso);
            cs.setDouble(5, precio);
            cs.setDouble(6, imptotal);
            cs.setString(7, calidad);
            cs.setString(8, humedad);
            cs.setString(9, contrato);
            cs.setInt(10, idpersona);
            cs.setString(11, fecha);
            cs.setString(12, estado);

            int numFAfectas = cs.executeUpdate();

            if (numFAfectas == -1) {
                rptaRegistro = "Registro Exitoso.";
            }
        } catch (Exception e) {

        }
        return rptaRegistro;
    }

    public static ArrayList<AperturaContrato> listAperturaContrato(
            int idempresa,
            int idsucursal) {
        ArrayList listaAperturaContrato = new ArrayList();
        AperturaContrato aperturacontrato;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERAPERTURACONTRATO(?,?)}");            
            ps.setInt(1, idempresa);
            ps.setInt(2, idsucursal);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()) {
                aperturacontrato = new AperturaContrato();                                
                aperturacontrato.setIdaperturacontrato(rs.getInt(1));
                aperturacontrato.setIdempresa(rs.getInt(2));
                aperturacontrato.setIdsucursal(rs.getInt(3));//armar otro para la vista
                aperturacontrato.setPeso(rs.getDouble(4));//armar otro para la vista
                aperturacontrato.setPrecio(rs.getDouble(5));
                aperturacontrato.setImptotal(rs.getDouble(6));
                aperturacontrato.setCalidad(rs.getString(7));
                aperturacontrato.setHumedad(rs.getString(8));
                aperturacontrato.setContrato(rs.getString(9));
                aperturacontrato.setCliente(rs.getString(11));
                aperturacontrato.setFecha(rs.getString(12));
                aperturacontrato.setEstado(rs.getString(13));
                listaAperturaContrato.add(aperturacontrato);
            }
            rs.close();
        } catch (Exception e) {

        }
        return listaAperturaContrato;
    }
    
    public static ArrayList<AperturaContrato> SelectAperturaContrato(
            int idempresa,
            int idsucursal,
            int idaperturacontrato) {
        ArrayList listaAperturaContrato = new ArrayList();
        AperturaContrato aperturacontrato;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERAPERTURACONTRATO_SELECT(?,?,?)}");            
            ps.setInt(1, idempresa);
            ps.setInt(2, idsucursal);
            ps.setInt(3, idaperturacontrato);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()) {
                aperturacontrato = new AperturaContrato();                                
                aperturacontrato.setIdaperturacontrato(rs.getInt(1));
                aperturacontrato.setIdempresa(rs.getInt(2));
                aperturacontrato.setIdsucursal(rs.getInt(3));//armar otro para la vista
                aperturacontrato.setPeso(rs.getDouble(4));//armar otro para la vista
                aperturacontrato.setPrecio(rs.getDouble(5));
                aperturacontrato.setImptotal(rs.getDouble(6));
                aperturacontrato.setCalidad(rs.getString(7));                
                aperturacontrato.setHumedad(rs.getString(8));
                aperturacontrato.setContrato(rs.getString(9));
                aperturacontrato.setIdpersona(rs.getInt(10));
                aperturacontrato.setFecha(rs.getString(11));
                aperturacontrato.setEstado(rs.getString(12));
                listaAperturaContrato.add(aperturacontrato);
            }
            rs.close();
        } catch (Exception e) {

        }
        return listaAperturaContrato;
    }
    
    
    
    
    public static ArrayList<AperturaContrato> listAperturaContratoBuscar(
            int idempresa,
            int idsucursal,
            String texto) {
        ArrayList listaAperturaContrato = new ArrayList();
        AperturaContrato aperturacontrato;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERAPERTURACONTRATOBUSCAR(?,?,?)}");
            ps.setInt(1, idempresa);
            ps.setInt(2, idsucursal);
            ps.setString(3, texto);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                aperturacontrato = new AperturaContrato();
                aperturacontrato.setIdaperturacontrato(rs.getInt(1));
                aperturacontrato.setIdempresa(rs.getInt(2));
                aperturacontrato.setIdsucursal(rs.getInt(3));//armar otro para la vista
                aperturacontrato.setIdpersona(rs.getInt(4));//armar otro para la vista
                aperturacontrato.setPeso(rs.getDouble(5));//armar otro para la vista
                aperturacontrato.setPrecio(rs.getDouble(6));
                aperturacontrato.setImptotal(rs.getDouble(7));
                aperturacontrato.setCalidad(rs.getString(8));
                aperturacontrato.setHumedad(rs.getString(9));
                aperturacontrato.setContrato(rs.getString(10));
                aperturacontrato.setFecha(rs.getString(11));
                aperturacontrato.setEstado(rs.getString(12));
                listaAperturaContrato.add(aperturacontrato);
            }
        } catch (Exception e) {

        }
        return listaAperturaContrato;
    }

    public ArrayList<AperturaContrato> nomDocumento() {
        ArrayList listaAperturaContrato = new ArrayList();
        AperturaContrato apcontrato;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement("SELECT idempresa,RazonSocial FROM empresa where estado='A'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                apcontrato = new AperturaContrato();
                //apcontrato.setIddocumento(rs.getInt(1));
                //apcontrato.setDescripcion(rs.getString(2));
                listaAperturaContrato.add(apcontrato);
            }
        } catch (Exception e) {

        }
        return listaAperturaContrato;
    }
    
     public static ArrayList<AperturaContrato> idNuevoAperturaContrato() {
        ArrayList listaAperturaContrato = new ArrayList();
        AperturaContrato aperturacontrato;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERIDNUEVOAPC()}");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                aperturacontrato = new AperturaContrato();
                aperturacontrato.setIdaperturacontrato(rs.getInt(1));             
                listaAperturaContrato.add(aperturacontrato);
            }
        } catch (Exception e) {
        }
        return listaAperturaContrato;
    }

    
    
    
    
}
