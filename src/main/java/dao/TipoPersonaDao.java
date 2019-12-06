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
import modelo.TipoPersona;

/**
 *
 * @author MustainE
 */
public class TipoPersonaDao {

    public String insertTipoPersona(
            int idtipopersona,
            int idpersona,
            int agricultor,
            int cliente,
            int proveedor,
            int tercero,
            int empleado,
            String estado) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call SP_ACTUALIZARTIPOPERSONA(?,?,?,?,?,?,?,?)}");
            cs.setInt(1, 0);
            cs.setInt(2, idpersona);
            cs.setInt(3, agricultor);
            cs.setInt(4, cliente);
            cs.setInt(5, proveedor);
            cs.setInt(6, tercero);
            cs.setInt(7, empleado);
            cs.setString(8, estado);            
            int numFAfectas = cs.executeUpdate();

            if (numFAfectas == -1) {
                rptaRegistro = "Registro Exitoso.";
            }
        } catch (Exception e) {

        }
        return rptaRegistro;
    }

    public String updateTipoPersona(
            int idtipopersona,
            int idpersona,
            int agricultor,
            int cliente,
            int proveedor,
            int tercero,
            int empleado,
            String estado) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call SP_ACTUALIZARTIPOPERSONA(?,?,?,?,?,?,?,?)}");
            cs.setInt(1, idtipopersona);
            cs.setInt(2, idpersona);
            cs.setInt(3, agricultor);
            cs.setInt(4, cliente);
            cs.setInt(5, proveedor);
            cs.setInt(6, tercero);
            cs.setInt(7, empleado);
            cs.setString(8, estado); 

            int numFAfectas = cs.executeUpdate();

            if (numFAfectas == -1) {
                rptaRegistro = "Actualización Exitosa.";
            }
        } catch (Exception e) {

        }
        return rptaRegistro;
    }

    public String DeleteTipoPersona(
            int idtipopersona,
            int idpersona,
            int agricultor,
            int cliente,
            int proveedor,
            int tercero,
            int empleado,
            String estado) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call SP_ACTUALIZARTIPOPERSONA(?,?,?,?,?,?,?,?)}");
            cs.setInt(1, idtipopersona);
            cs.setInt(2, idpersona);
            cs.setInt(3, agricultor);
            cs.setInt(4, cliente);
            cs.setInt(5, proveedor);
            cs.setInt(6, tercero);
            cs.setInt(7, empleado);
            cs.setString(8, estado); 

            int numFAfectas = cs.executeUpdate();

            if (numFAfectas == -1) {
                rptaRegistro = "Registro Inactivo Exitosa.";
            }
        } catch (Exception e) {

        }
        return rptaRegistro;
    }

    public ArrayList<TipoPersona> listTipoPersona() {
        ArrayList listaTipoPersona = new ArrayList();
        TipoPersona tipopersona;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERTIPOPERSONA()}");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tipopersona = new TipoPersona();
                tipopersona.setIdtipopersona(rs.getInt(1));
                tipopersona.setIdpersona(rs.getInt(2));
                tipopersona.setAgricultor(rs.getInt(3));
                tipopersona.setCliente(rs.getInt(4));
                tipopersona.setProveedor(rs.getInt(5));
                tipopersona.setTercero(rs.getInt(6));
                tipopersona.setEmpleado(rs.getInt(7));
                tipopersona.setEstado(rs.getString(8));
                listaTipoPersona.add(tipopersona);
            }
        } catch (Exception e) {

        }
        return listaTipoPersona;
    }

}
