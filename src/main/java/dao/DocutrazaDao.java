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
import modelo.Docutraza;

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
            String serieguia,
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
            CallableStatement cs = accesoDB.prepareCall("{call SP_ACTUALIZARDOCUTRAZA(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, iddocutraza);
            cs.setInt(2, idempresa);
            cs.setInt(3, idsucursal);
            cs.setInt(4, idcompracontrato);
            cs.setInt(5, idpersona);
            cs.setString(6, serieguia);
            cs.setString(7, correlativo);
            cs.setString(8, certificado);
            cs.setString(9, certificado);
            cs.setInt(10, sacos);
            cs.setDouble(11, kb);
            cs.setDouble(12, kn);
            cs.setString(13, fairtrade);
            cs.setString(14, condicion);
            cs.setString(15, fecha);
            cs.setString(16, estado);

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
            String serieguia,
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
            CallableStatement cs = accesoDB.prepareCall("{call SP_ACTUALIZARDOCUTRAZA(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, iddocutraza);
            cs.setInt(2, idempresa);
            cs.setInt(3, idsucursal);
            cs.setInt(4, idcompracontrato);
            cs.setInt(5, idpersona);
            cs.setString(6, serieguia);
            cs.setString(7, correlativo);
            cs.setString(8, certificado);
            cs.setString(9, certificado);
            cs.setInt(10, sacos);
            cs.setDouble(11, kb);
            cs.setDouble(12, kn);
            cs.setString(13, fairtrade);
            cs.setString(14, condicion);
            cs.setString(15, fecha);
            cs.setString(16, estado);

            int numFAfectas = cs.executeUpdate();

            if (numFAfectas == -1) {
                rptaRegistro = "Registro Exitoso.";
            }
        } catch (Exception e) {

        }
        return rptaRegistro;
    }

    public ArrayList<Docutraza> listDocutraza() {
        ArrayList listaDocutraza = new ArrayList();
        Docutraza docutraza;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERDOCUTRAZA()}");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                docutraza = new Docutraza();
                docutraza.setIdempresa(rs.getInt(1));
                docutraza.setIdsucursal(rs.getInt(2));
                docutraza.setIdcompracontrato(rs.getInt(3));//armar otro para la vista
                docutraza.setIdpersona(rs.getInt(4));//armar otro para la vista
                docutraza.setSerieguia(rs.getString(5));
                docutraza.setCorrelativo(rs.getString(6));
                docutraza.setCertificado(rs.getString(7));
                docutraza.setSacos(rs.getInt(8));
                docutraza.setKb(rs.getDouble(9));
                docutraza.setKn(rs.getDouble(10));
                docutraza.setFairtrade(rs.getString(11));
                docutraza.setCondicion(rs.getString(12));
                docutraza.setFecha(rs.getString(13));
                docutraza.setEstado(rs.getString(14));
                listaDocutraza.add(docutraza);
            }
        } catch (Exception e) {

        }
        return listaDocutraza;
    }
   
}
