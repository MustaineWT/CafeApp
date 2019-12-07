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
            String fecha,
            String estado) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call SP_ACTUALIZARCOMPRACONTRATO(?,?,?,?,?,?,?)}");
            cs.setInt(1, idaperturacontrato);
            cs.setInt(2, idempresa);
            cs.setInt(3, idsucursal);
            cs.setDouble(4, peso);
            cs.setDouble(5, precio);
            cs.setString(6, fecha);
            cs.setString(7, estado);

            int numFAfectas = cs.executeUpdate();

            if (numFAfectas == -1) {
                rptaRegistro = "Registro Exitoso.";
            }
        } catch (Exception e) {

        }
        return rptaRegistro;
    }

    public String UpdateDocumento(
            int idcompracontrato,
            int idempresa,
            int idsucursal,
            int idaperturacontrato,
            double peso,
            double precio,
            String fecha,
            String estado) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call SP_ACTUALIZARCOMPRACONTRATO(?,?,?,?,?,?,?)}");
            cs.setInt(1, idaperturacontrato);
            cs.setInt(2, idempresa);
            cs.setInt(3, idsucursal);
            cs.setDouble(4, peso);
            cs.setDouble(5, precio);
            cs.setString(6, fecha);
            cs.setString(7, estado);

            int numFAfectas = cs.executeUpdate();

            if (numFAfectas == -1) {
                rptaRegistro = "Registro Exitoso.";
            }
        } catch (Exception e) {

        }
        return rptaRegistro;
    }

    public static ArrayList<CompraContrato> listCompraContrato(
            int idcompracontrato,
            int idempresa,
            int idsucursal,
            int idaperturacontrato) {
        ArrayList listaCompraContrato = new ArrayList();
        CompraContrato compracontrato;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERCOMPRACONTRATO(?,?,?,?)}");
            ps.setInt(1, idcompracontrato);
            ps.setInt(2, idempresa);
            ps.setInt(3, idsucursal);
            ps.setInt(4, idaperturacontrato);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                compracontrato = new CompraContrato();
                compracontrato.setIdcompracontrato(rs.getInt(1));
                compracontrato.setIdempresa(rs.getInt(2));
                compracontrato.setIdsucursal(rs.getInt(3));
                compracontrato.setIdaperturacontrato(rs.getInt(4));
                compracontrato.setPeso(rs.getDouble(5));
                compracontrato.setPrecio(rs.getDouble(6));
                compracontrato.setFecha(rs.getString(7));
                compracontrato.setEstado(rs.getString(8));
                listaCompraContrato.add(compracontrato);
            }
        } catch (Exception e) {

        }
        return listaCompraContrato;
    }

}
