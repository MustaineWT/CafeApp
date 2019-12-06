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
            String ciudad,
            String pais,
            String gironegocio,
            String tipoexportacion,
            String estado) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call SP_ACTUALIZARSUCURSAL(?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, 0);
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

    public ArrayList<Sucursal> listSucursal() {
        ArrayList listaSucursal = new ArrayList();
        Sucursal sucursal;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERSUCURSAL()}");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sucursal = new Sucursal();
                sucursal.setIdsucursal(rs.getInt(1));
                sucursal.setIdempresa(rs.getInt(2));
                sucursal.setNombreciudad(rs.getString(3));
                sucursal.setRuc(rs.getString(4));
                sucursal.setDireccion(rs.getString(5));
                sucursal.setDistrito(rs.getString(6));
                sucursal.setCiudad(rs.getString(7));
                sucursal.setPais(rs.getString(8));
                sucursal.setGironegocio(rs.getString(9));
                sucursal.setEstado(rs.getString(10));
                listaSucursal.add(sucursal);
            }
        } catch (Exception e) {

        }
        return listaSucursal;
    }   

}
