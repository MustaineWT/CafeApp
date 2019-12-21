/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.PerBuscador;
import modelo.Sucursal;

/**
 *
 * @author wmtor
 */
public class Select_SucursalDao {
     public static ArrayList<Sucursal> listSelecSucursal(
            int idempresa) {
        ArrayList listasucursal = new ArrayList();
        Sucursal sucursal;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERSUCURSAL_SELECT(?)}");            
            ps.setInt(1, idempresa);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()) {
                sucursal = new Sucursal();                                
                sucursal.setIdempresa(rs.getInt(1));
                sucursal.setIdsucursal(rs.getInt(2));
                sucursal.setRsocial(rs.getString(3));
                sucursal.setNombreciudad(rs.getString(4));
                sucursal.setRuc(rs.getString(5));
                sucursal.setGironegocio(rs.getString(5));
                listasucursal.add(sucursal);
            }
            rs.close();
        } catch (Exception e) {

        }
        return listasucursal;
    }  
}
