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
import modelo.AperturaContrato;

/**
 *
 * @author MustainE
 */
public class ConformacionDao {
        
    public String UpdateConformacion(
            int iddetdoc,
            int iddocutraza,
            int idperLPAEst,
            int idperLPACon,
            int idpersona,
            int sacos, 
            long kb,
            long tara,
            long kn,
            long precio,
            long importetotal,
            String guia,
            String liqcompra,
            String fecha,
            String estado) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call SP_ACTUALIZARDETALLEDOCUTRAZA(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, iddetdoc);
            cs.setInt(2, iddocutraza);
            cs.setInt(3, idperLPAEst);
            cs.setInt(4, idperLPACon);
            cs.setInt(5, idpersona);
            cs.setInt(6, sacos);
            cs.setLong(7, kb);
            cs.setLong(8, tara);
            cs.setLong(9, kn);
            cs.setLong(10, precio);
            cs.setLong(11, importetotal);
            cs.setString(12, guia);
            cs.setString(13, liqcompra);
            cs.setString(14, fecha);
            cs.setString(15, estado);

            int numFAfectas = cs.executeUpdate();

            if (numFAfectas == -1) {
                rptaRegistro = "Registro Exitoso.";
            }
        } catch (Exception e) {

        }
        return rptaRegistro;
    }
}
