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

/**
 *
 * @author MustainE
 */
public class EmpresaDao {

    public String insertEmpresa(
            int id,
            String razonsocial,
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
            CallableStatement cs = accesoDB.prepareCall("{call SP_ACTUALIZAR_EMPRESA(?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, 0);
            cs.setString(2, razonsocial);
            cs.setString(3, ruc);
            cs.setString(4, direccion);
            cs.setString(5, distrito);
            cs.setString(6, ciudad);
            cs.setString(7, pais);
            cs.setString(8, gironegocio);
            cs.setString(9, tipoexportacion);
            cs.setString(10, estado);

            int numFAfectas = cs.executeUpdate();

            if (numFAfectas == -1) {
                rptaRegistro = "Registro Exitoso.";
            }
        } catch (Exception e) {

        }
        return rptaRegistro;
    }

    public String UpdateEmpresa(
            int id,
            String razonsocial,
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
            CallableStatement cs = accesoDB.prepareCall("{call SP_ACTUALIZAR_EMPRESA(?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, id);
            cs.setString(2, razonsocial);
            cs.setString(3, ruc);
            cs.setString(4, direccion);
            cs.setString(5, distrito);
            cs.setString(6, ciudad);
            cs.setString(7, pais);
            cs.setString(8, gironegocio);
            cs.setString(9, tipoexportacion);
            cs.setString(10, estado);

            int numFAfectas = cs.executeUpdate();

            if (numFAfectas == -1) {
                rptaRegistro = "Actualización Exitosa.";
            }
        } catch (Exception e) {

        }
        return rptaRegistro;
    }

    public String DeleteEmpresa(
            int id,
            String razonsocial,
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
            CallableStatement cs = accesoDB.prepareCall("{call SP_ACTUALIZAR_EMPRESA(?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, id);
            cs.setString(2, razonsocial);
            cs.setString(3, ruc);
            cs.setString(4, direccion);
            cs.setString(5, distrito);
            cs.setString(6, ciudad);
            cs.setString(7, pais);
            cs.setString(8, gironegocio);
            cs.setString(9, tipoexportacion);
            cs.setString(10, estado);

            int numFAfectas = cs.executeUpdate();

            if (numFAfectas == -1) {
                rptaRegistro = "Registro Inactivo Exitosa.";
            }
        } catch (Exception e) {

        }
        return rptaRegistro;
    }

    public static ArrayList<Empresa> listEmpresa() {
        ArrayList listaEmpresa = new ArrayList();
        Empresa empresa;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENEREMPRESA()}");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                empresa = new Empresa();
                empresa.setIdempresa(rs.getInt(1));
                empresa.setRazonSocial(rs.getString(2));
                empresa.setRuc(rs.getString(3));
                empresa.setDireccion(rs.getString(4));
                empresa.setDistrito(rs.getString(5));
                empresa.setCiudad(rs.getString(6));
                empresa.setPais(rs.getString(7));
                empresa.setGironegocio(rs.getString(8));
                empresa.setTipoexportacion(rs.getString(9));
                empresa.setEstado(rs.getString(10));
                listaEmpresa.add(empresa);
            }
        } catch (Exception e) {

        }
        return listaEmpresa;
    }   

    public static ArrayList<Empresa> SelectEmpresa(
            int idempresa) {
        ArrayList listaEmpresa = new ArrayList();
        Empresa empresa;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENEREMPRESA_SELECT(?)}");            
            ps.setInt(1, idempresa);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()) {
                empresa = new Empresa();                                
                empresa.setIdempresa(rs.getInt(1));
                empresa.setRazonSocial(rs.getString(2));//armar otro para la vista
                empresa.setRuc(rs.getString(3));
                empresa.setDireccion(rs.getString(4));
                empresa.setDistrito(rs.getString(5));                
                empresa.setCiudad(rs.getString(6));
                empresa.setPais(rs.getString(7));
                empresa.setGironegocio(rs.getString(8));
                empresa.setTipoexportacion(rs.getString(9));
                empresa.setEstado(rs.getString(10));                
                listaEmpresa.add(empresa);
            }
            rs.close();
        } catch (Exception e) {

        }
        return listaEmpresa;
    }
    
    public static ArrayList<Empresa> listEmpresaBuscar(
            int idempresa,
            String texto) {
        ArrayList listaEmpresa = new ArrayList();
        Empresa empresa;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENEREMPRESABUSCAR(?,?)}");
            ps.setInt(1, idempresa);
            ps.setString(2, texto);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                empresa = new Empresa();
                empresa.setIdempresa(rs.getInt(1));
                empresa.setRazonSocial(rs.getString(2));//armar otro para la vista
                empresa.setRuc(rs.getString(3));
                empresa.setDireccion(rs.getString(4));//armar otro para la vista
                empresa.setDistrito(rs.getString(5));//armar otro para la vista
                empresa.setCiudad(rs.getString(6));
                empresa.setPais(rs.getString(7));
                empresa.setGironegocio(rs.getString(8));
                empresa.setTipoexportacion(rs.getString(9));
                empresa.setEstado(rs.getString(10));
                listaEmpresa.add(empresa);
            }
        } catch (Exception e) {

        }
        return listaEmpresa;
    }
    
    
    
     public static ArrayList<Empresa> idNuevoEmpresa() {
        ArrayList listaEmpresa = new ArrayList();
        Empresa empresa;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENEREMPRESA()}");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                empresa = new Empresa();
                empresa.setIdempresa(rs.getInt(1));             
                listaEmpresa.add(empresa);
            }
        } catch (Exception e) {
        }
        return listaEmpresa;
    }
    
    
    
}
