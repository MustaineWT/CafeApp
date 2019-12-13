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

/**
 *
 * @author MustainE
 */
public class CompraContratoDao {
    
    public String insertCompraContrato(
            int idcompracontrato,
            int idempresa,
            int idsucursal,
            int idaperturacontrato,
            double peso,
            double precio,
            double imptotal,
            String fecha,
            String estado) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call SP_ACTUALIZARCOMPRACONTRATO(?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, idcompracontrato);
            cs.setInt(2, idempresa);
            cs.setInt(3, idsucursal);
            cs.setInt(4, idaperturacontrato);
            cs.setDouble(5, peso);
            cs.setDouble(6, precio);
            cs.setDouble(7, imptotal);
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

    public String UpdateCompraContrato(
            int idcompracontrato,
            int idempresa,
            int idsucursal,
            int idaperturacontrato,
            double peso,
            double precio,
            double imptotal,
            String fecha,
            String estado) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call SP_ACTUALIZARCOMPRACONTRATO(?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, idcompracontrato);
            cs.setInt(2, idempresa);
            cs.setInt(3, idsucursal);
            cs.setInt(4, idaperturacontrato);
            cs.setDouble(5, peso);
            cs.setDouble(6, precio);
            cs.setDouble(7, imptotal);
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

    public static ArrayList<CompraContrato> listCompraContrato(
            int idempresa,
            int idsucursal,
            int idapc) {
        ArrayList listaCompraContrato = new ArrayList();
        CompraContrato compracontrato;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERCOMPRACONTRATO(?,?,?)}");            
            ps.setInt(1, idempresa);
            ps.setInt(2, idsucursal);
            ps.setInt(3, idapc);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()) {
                compracontrato = new CompraContrato();                                
                compracontrato.setIdcompracontrato(rs.getInt(1));
                compracontrato.setIdempresa(rs.getInt(2));
                compracontrato.setIdsucursal(rs.getInt(3));//armar otro para la vista
                compracontrato.setIdaperturacontrato(rs.getInt(4));//armar otro para la vista
                compracontrato.setPeso(rs.getDouble(5));
                compracontrato.setPrecio(rs.getDouble(6));
                compracontrato.setImptotal(rs.getDouble(7));
                compracontrato.setFecha(rs.getString(8));
                compracontrato.setEstado(rs.getString(9));
                listaCompraContrato.add(compracontrato);
            }
            rs.close();
        } catch (Exception e) {

        }
        return listaCompraContrato;
    }
    
    public static ArrayList<CompraContrato> SelectCompraContrato(
            int idempresa,
            int idsucursal,
            int idcompracontrato) {
        ArrayList listaCompraContrato = new ArrayList();
        CompraContrato compracontrato;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERCOMPRACONTRATO_SELECT(?,?,?)}");            
            ps.setInt(1, idempresa);
            ps.setInt(2, idsucursal);
            ps.setInt(3, idcompracontrato);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()) {
               compracontrato = new CompraContrato();                                
                compracontrato.setIdcompracontrato(rs.getInt(1));
                compracontrato.setIdempresa(rs.getInt(2));
                compracontrato.setIdsucursal(rs.getInt(3));//armar otro para la vista
                compracontrato.setIdaperturacontrato(rs.getInt(4));//armar otro para la vista
                compracontrato.setPeso(rs.getDouble(5));
                compracontrato.setPrecio(rs.getDouble(6));
                compracontrato.setImptotal(rs.getDouble(7));
                compracontrato.setFecha(rs.getString(8));
                compracontrato.setEstado(rs.getString(9));
                listaCompraContrato.add(compracontrato);
            }
            rs.close();
        } catch (Exception e) {

        }
        return listaCompraContrato;
    }
    
    
    
    
    public static ArrayList<CompraContrato> listCompraContratoBuscar(
            int idempresa,
            int idsucursal,
            String texto) {
        ArrayList listaCompraContrato = new ArrayList();
        CompraContrato compracontrato;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERAPERTURACONTRATOBUSCAR(?,?,?)}");
            ps.setInt(1, idempresa);
            ps.setInt(2, idsucursal);
            ps.setString(3, texto);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                compracontrato = new CompraContrato();                                
                compracontrato.setIdcompracontrato(rs.getInt(1));
                compracontrato.setIdempresa(rs.getInt(2));
                compracontrato.setIdsucursal(rs.getInt(3));//armar otro para la vista
                compracontrato.setIdaperturacontrato(rs.getInt(4));//armar otro para la vista
                compracontrato.setPeso(rs.getDouble(5));
                compracontrato.setPrecio(rs.getDouble(6));
                compracontrato.setImptotal(rs.getDouble(7));
                compracontrato.setFecha(rs.getString(8));
                compracontrato.setEstado(rs.getString(9));
                listaCompraContrato.add(compracontrato);
            }
        } catch (Exception e) {

        }
        return listaCompraContrato;
    }
   
    
     public static ArrayList<CompraContrato> idNuevoCompraContrato() {
        ArrayList listaCompraContrato = new ArrayList();
        CompraContrato compracontrato;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERIDNUEVOCC()}");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                compracontrato = new CompraContrato();
                compracontrato.setIdcompracontrato(rs.getInt(1));             
                listaCompraContrato.add(compracontrato);
            }
        } catch (Exception e) {
        }
        return listaCompraContrato;
    }

    
    
}
