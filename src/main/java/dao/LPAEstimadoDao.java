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
import modelo.LPAEstimado;

/**
 *
 * @author MustainE
 */
public class LPAEstimadoDao{
      public String insertLPAEstimado(
            int idlpaestimado,
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
            cs.setInt(1, idlpaestimado);
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

    public String UpdateLPAEstimado(
            int idlpaestimado,
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
            cs.setInt(1, idlpaestimado);
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

    public ArrayList<LPAEstimado> listLPAEstimado(
            int idempresa,
            int idsucursal) {
        ArrayList listaLPAEstimado = new ArrayList();
        LPAEstimado lpaestimado;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERLPAESTIMADO(?,?)}");
            ps.setInt(1, idempresa);
            ps.setInt(2, idsucursal);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lpaestimado = new LPAEstimado();
                lpaestimado.setIdlpaestimado(rs.getInt(1));
                lpaestimado.setIdempresa(rs.getInt(2));
                lpaestimado.setIdsucursal(rs.getInt(3));
                lpaestimado.setIdpersona(rs.getInt(4));
                lpaestimado.setEjercicio(rs.getInt(5));
                lpaestimado.setCpinicial(rs.getDouble(6));
                lpaestimado.setFtinicial(rs.getDouble(7));
                lpaestimado.setRainfinicial(rs.getDouble(8));
                lpaestimado.setConvinicial(rs.getDouble(9));                
                lpaestimado.setEstado(rs.getString(10));
                listaLPAEstimado.add(lpaestimado);
            }
        } catch (Exception e) {

        }
        return listaLPAEstimado;
    }
}
