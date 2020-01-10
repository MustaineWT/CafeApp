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
import modelo.Empresa;
import modelo.Sucursal;

/**
 *
 * @author MustainE
 */
public class SucursalDao {

    public String insertSucursal(
            int idsucursal,
            int idempresa,
            String nombreciudad,
            String ruc,
            String direccion,
            String distrito,
            String pais,
            String gironegocio,
            String estado) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call SP_ACTUALIZARSUCURSAL(?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, 0);
            cs.setInt(2, idempresa);
            cs.setString(3, nombreciudad);
            cs.setString(4, ruc);
            cs.setString(5, direccion);
            cs.setString(6, distrito);
            cs.setString(7, pais);
            cs.setString(8, gironegocio);
            cs.setString(9, estado);

            int numFAfectas = cs.executeUpdate();

            if (numFAfectas == -1) {
                rptaRegistro = "Registro Exitoso.";
            }
        } catch (Exception e) {

        }
        return rptaRegistro;
    }

    public String updateSucursal(
            int idsucursal,
            int idempresa,
            String nombreciudad,
            String ruc,
            String direccion,
            String distrito,
            String pais,
            String gironegocio,
            String estado) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call SP_ACTUALIZARSUCURSAL(?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, idsucursal);
            cs.setInt(2, idempresa);
            cs.setString(3, nombreciudad);
            cs.setString(4, ruc);
            cs.setString(5, direccion);
            cs.setString(6, distrito);
            cs.setString(7, pais);
            cs.setString(8, gironegocio);
            cs.setString(9, estado);

            int numFAfectas = cs.executeUpdate();

            if (numFAfectas == -1) {
                rptaRegistro = "Actualización Exitosa.";
            }
        } catch (Exception e) {

        }
        return rptaRegistro;
    }

    public String DeleteSucursal(
            int idsucursal,
            int idempresa,
            String nombreciudad,
            String ruc,
            String direccion,
            String distrito,
            String ciudad,
            String pais,
            String gironegocio,
            String tipoexportacion,
            String estado) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call SP_ACTUALIZARSUCURSAL(?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, idsucursal);
            cs.setInt(2, idempresa);
            cs.setString(3, nombreciudad);
            cs.setString(4, ruc);
            cs.setString(5, direccion);
            cs.setString(6, distrito);
            cs.setString(7, ciudad);
            cs.setString(8, pais);
            cs.setString(9, gironegocio);
            cs.setString(10, tipoexportacion);
            cs.setString(11, estado);

            int numFAfectas = cs.executeUpdate();

            if (numFAfectas == -1) {
                rptaRegistro = "Registro Inactivo Exitosa.";
            }
        } catch (Exception e) {

        }
        return rptaRegistro;
    }

     public static ArrayList<Sucursal> listSucursalBuscar(
            int idempresa,
            String texto) {
        ArrayList listaEmpresa = new ArrayList();
        Sucursal sucursal;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERSUCURSALBUSCAR(?,?)}");
            ps.setInt(1, idempresa);
            ps.setString(2, texto);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sucursal = new Sucursal();
                sucursal.setIdsucursal(rs.getInt(1));
                sucursal.setIdempresa(rs.getInt(2));
                sucursal.setNombreciudad(rs.getString(3));//armar otro para la vista
                sucursal.setRuc(rs.getString(4));
                sucursal.setDireccion(rs.getString(5));//armar otro para la vista
                sucursal.setDistrito(rs.getString(6));//armar otro para la vista                
                sucursal.setPais(rs.getString(7));
                sucursal.setGironegocio(rs.getString(8));
                sucursal.setEstado(rs.getString(9));
                listaEmpresa.add(sucursal);
            }
        } catch (Exception e) {

        }
        return listaEmpresa;
    }
    
    public static ArrayList<Sucursal> listSucursal(
    int idempresa) {
        ArrayList listaSucursal = new ArrayList();
        Sucursal sucursal;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERSUCURSAL(?)}");
            ps.setInt(1, idempresa);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sucursal = new Sucursal();
                sucursal.setIdsucursal(rs.getInt(1));
                sucursal.setIdempresa(rs.getInt(2));
                sucursal.setNombreciudad(rs.getString(3));
                sucursal.setRuc(rs.getString(4));
                sucursal.setDireccion(rs.getString(5));
                sucursal.setDistrito(rs.getString(6));
                sucursal.setPais(rs.getString(7));
                sucursal.setGironegocio(rs.getString(8));
                sucursal.setEstado(rs.getString(9));
                listaSucursal.add(sucursal);
            }
        } catch (Exception e) {

        }
        return listaSucursal;
    }   
     public static ArrayList<Sucursal> idNuevoSucursal() {
        ArrayList listaSucursal = new ArrayList();
        Sucursal sucursal;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERIDSUCURSAL()}");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sucursal = new Sucursal();
                sucursal.setIdsucursal(rs.getInt(1));             
                listaSucursal.add(sucursal);
            }
        } catch (Exception e) {
        }
        return listaSucursal;
    }

     public static ArrayList<Sucursal> SelectSucursal(
            int idsucursal) {
        ArrayList listaEmpresa = new ArrayList();
        Sucursal sucursal;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERSUCURSAL_SELECTDOS(?)}");            
            ps.setInt(1, idsucursal);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()) {
                sucursal = new Sucursal();                                
                sucursal.setIdsucursal(rs.getInt(1));
                sucursal.setIdempresa(rs.getInt(2));
                sucursal.setNombreciudad(rs.getString(3));//armar otro para la vista
                sucursal.setRuc(rs.getString(4));
                sucursal.setDireccion(rs.getString(5));
                sucursal.setDistrito(rs.getString(6));      
                sucursal.setPais(rs.getString(7));
                sucursal.setGironegocio(rs.getString(8));
                sucursal.setEstado(rs.getString(9));                
                listaEmpresa.add(sucursal);
            }
            rs.close();
        } catch (Exception e) {

        }
        return listaEmpresa;
    }
}
