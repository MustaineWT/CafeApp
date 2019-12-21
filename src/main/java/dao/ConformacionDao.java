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
import modelo.PerBuscador;

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
            double kb,
            double tara,
            double kn,
            double precio,
            double importetotal,
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
            cs.setDouble(7, kb);
            cs.setDouble(8, tara);
            cs.setDouble(9, kn);
            cs.setDouble(10, precio);
            cs.setDouble(11, importetotal);
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
    
        public static ArrayList<PerBuscador> listIddpersona(
            int idempresa,int idpersona
    ) {
        ArrayList listaDetalleDocutraza = new ArrayList();
        PerBuscador perbuscador;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERCLIENTE_SELECT(?,?)}");
            ps.setInt(1, idempresa);
            ps.setInt(2, idpersona);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                perbuscador = new PerBuscador();
                perbuscador.setIdpersona(rs.getInt(1));
                perbuscador.setNombres(rs.getString(2));
                listaDetalleDocutraza.add(perbuscador);
            }
        } catch (Exception e) {

        }
        return listaDetalleDocutraza;
    }
    
    
    
    
    
    
    
    
    
    
}
