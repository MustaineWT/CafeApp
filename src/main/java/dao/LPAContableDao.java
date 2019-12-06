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
import modelo.LPAContable;

/**
 *
 * @author MustainE
 */
public class LPAContableDao {
     public String insertLPAContable(
            int idlpacontable,
            int idempresa,
            int idsucursal,
            int idpersona,
            int ejercicio,
            double cpinicial,
            double ftinicial,
            double rainfinicial,
            double convinicial,
            String estado) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call SP_ACTUALIZARLPACONTABLE(?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, idlpacontable);
            cs.setInt(2, idempresa);
            cs.setInt(3, idsucursal);
            cs.setInt(4, idpersona);
            cs.setInt(5, ejercicio);
            cs.setDouble(6, cpinicial);
            cs.setDouble(7, ftinicial);
            cs.setDouble(8, rainfinicial);
            cs.setDouble(9, convinicial);
            cs.setString(10, estado);

            int numFAfectas = cs.executeUpdate();

            if (numFAfectas == -1) {
                rptaRegistro = "Registro Exitoso.";
            }
        } catch (Exception e) {

        }
        return rptaRegistro;
    }

    public String UpdateLPAContable(
            int idlpacontable,
            int idempresa,
            int idsucursal,
            int idpersona,
            int ejercicio,
            double cpinicial,
            double ftinicial,
            double rainfinicial,
            double convinicial,
            String estado) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call SP_ACTUALIZARLPACONTABLE(?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, idlpacontable);
            cs.setInt(2, idempresa);
            cs.setInt(3, idsucursal);
            cs.setInt(4, idpersona);
            cs.setInt(5, ejercicio);
            cs.setDouble(6, cpinicial);
            cs.setDouble(7, ftinicial);
            cs.setDouble(8, rainfinicial);
            cs.setDouble(9, convinicial);
            cs.setString(10, estado);

            int numFAfectas = cs.executeUpdate();

            if (numFAfectas == -1) {
                rptaRegistro = "Registro Exitoso.";
            }
        } catch (Exception e) {

        }
        return rptaRegistro;
    }

    public ArrayList<LPAContable> listLPAContable(
            int idempresa,
            int idsucursal) {
        ArrayList listaLPAContable = new ArrayList();
        LPAContable lpacontable;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERLPACONTABLE(?,?)}");
            ps.setInt(1, idempresa);
            ps.setInt(2, idsucursal);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lpacontable = new LPAContable();
                lpacontable.setIdlpacontable(rs.getInt(1));
                lpacontable.setIdempresa(rs.getInt(2));
                lpacontable.setIdsucursal(rs.getInt(3));
                lpacontable.setIdpersona(rs.getInt(4));
                lpacontable.setEjercicio(rs.getInt(5));
                lpacontable.setCpinicial(rs.getDouble(6));
                lpacontable.setFtinicial(rs.getDouble(7));
                lpacontable.setRainfinicial(rs.getDouble(8));
                lpacontable.setConvinicial(rs.getDouble(9));                
                lpacontable.setEstado(rs.getString(10));
                listaLPAContable.add(lpacontable);
            }
        } catch (Exception e) {

        }
        return listaLPAContable;
    }

}
