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
import modelo.DetalleDocutraza;

/**
 *
 * @author MustainE
 */
public class DetalleDocutrazaDao {

    public String insertDetalleDocutraza(
            int iddetalledocutraza,
            int iddocutraza,
            int idlpaestimado,
            int idlpacontable,
            int idpersona,
            int sacos,
            double kb,
            double kn,
            double precio,
            double importetotal,
            String liqcompra,
            String fecha,
            String estado) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call SP_ACTUALIZARDETALLEDOCUTRAZA(?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, iddetalledocutraza);
            cs.setInt(2, iddocutraza);
            cs.setInt(3, idlpaestimado);
            cs.setInt(4, idlpacontable);
            cs.setInt(5, idpersona);
            cs.setInt(6, sacos);
            cs.setDouble(7, kb);
            cs.setDouble(8, kn);
            cs.setDouble(9, importetotal);
            cs.setString(10, liqcompra);
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

    public String UpdateDetalleDocutraza(
            int iddetalledocutraza,
            int iddocutraza,
            int idlpaestimado,
            int idlpacontable,
            int idpersona,
            int sacos,
            double kb,
            double kn,
            double precio,
            double importetotal,
            String liqcompra,
            String fecha,
            String estado) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call SP_ACTUALIZARDETALLEDOCUTRAZA(?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, iddetalledocutraza);
            cs.setInt(2, iddocutraza);
            cs.setInt(3, idlpaestimado);
            cs.setInt(4, idlpacontable);
            cs.setInt(5, idpersona);
            cs.setInt(6, sacos);
            cs.setDouble(7, kb);
            cs.setDouble(8, kn);
            cs.setDouble(9, importetotal);
            cs.setString(10, liqcompra);
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

    public ArrayList<DetalleDocutraza> listDetalleDocutraza() {
        ArrayList listaDetalleDocutraza = new ArrayList();
        DetalleDocutraza detalledocutraza;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERDETALLEDOCUTRAZA()}");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                detalledocutraza = new DetalleDocutraza();
                detalledocutraza.setIddocutraza(rs.getInt(1));
                detalledocutraza.setIdlpaestimado(rs.getInt(2));
                detalledocutraza.setIdlpacontable(rs.getInt(3));//armar otro para la vista
                detalledocutraza.setIdpersona(rs.getInt(4));//armar otro para la vista
                detalledocutraza.setSacos(rs.getInt(5));
                detalledocutraza.setKb(rs.getDouble(6));
                detalledocutraza.setKn(rs.getDouble(7));
                detalledocutraza.setTara(rs.getDouble(8));
                detalledocutraza.setPrecio(rs.getDouble(9));
                detalledocutraza.setImportetotal(rs.getDouble(10));
                detalledocutraza.setLiqcompra(rs.getString(11));
                detalledocutraza.setFecha(rs.getString(12));                
                detalledocutraza.setEstado(rs.getString(13));
                listaDetalleDocutraza.add(detalledocutraza);
            }
        } catch (Exception e) {

        }
        return listaDetalleDocutraza;
    }
   
}
