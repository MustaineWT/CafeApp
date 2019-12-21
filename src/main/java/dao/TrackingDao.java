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
import java.text.DecimalFormat;
import java.util.ArrayList;
import modelo.Tracking;

/**
 *
 * @author MustainE
 */
public class TrackingDao {
    DecimalFormat df = new DecimalFormat("#,###.00");
   
public static ArrayList<Tracking> listDetalleTracking(
        
        int idempresa,int idsucursal
        ) {
        ArrayList listaDetalleDocutraza = new ArrayList();
        Tracking tracking;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERTRACKINGACTUAL(?,?)}");
            ps.setInt(1, idempresa);
            ps.setInt(2, idsucursal);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tracking = new Tracking();
                tracking.setIdlpaestimado(rs.getInt(1));
                tracking.setIdempresa(rs.getInt(2));
                tracking.setIdsucursal(rs.getInt(3));
                tracking.setIdcp(rs.getString(4));
                tracking.setIdorga(rs.getString(5));
                tracking.setIdcafepractice(rs.getString(6));
                tracking.setCodagricultor(rs.getString(7));
                tracking.setApellidos(rs.getString(8));
                tracking.setNombres(rs.getString(9));
                tracking.setDni(rs.getString(10));
                tracking.setNomfinca(rs.getString(11));
                tracking.setNomanexo(rs.getString(12));
                tracking.setCpinicial(rs.getDouble(13));
                tracking.setOrginicial(rs.getDouble(14));
                tracking.setFtinicial(rs.getDouble(15));
                tracking.setRainfinicial(rs.getDouble(16));
                tracking.setConvinicial(rs.getDouble(17));
                tracking.setCpavanc(rs.getDouble(18));
                tracking.setOrgavanc(rs.getDouble(19));
                tracking.setFtavanc(rs.getDouble(20));
                tracking.setRainfavanc(rs.getDouble(21));
                tracking.setConviavanc(rs.getDouble(22));
                tracking.setCpdisp(rs.getDouble(23));
                tracking.setOrgdisp(rs.getDouble(24));
                tracking.setFtdisp(rs.getDouble(25));
                tracking.setRainfdisp(rs.getDouble(26));
                tracking.setConvidisp(rs.getDouble(27));
                
                listaDetalleDocutraza.add(tracking);
            }
        } catch (Exception e) {

        }
        return listaDetalleDocutraza;
    }

    public ArrayList<Tracking> Totales(String idempresa) {
        ArrayList listaTracking = new ArrayList();
        Tracking tracking;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement("select sum(cpdisponible) as cafepractice,sum(orgdisponible) as organico,sum(ftdisponible) as fairtrade,sum(rainfdisponible) as rainforest,sum(convdisponible) as convencional from tracking where idempresa=?");
            ps.setString(1, idempresa);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tracking = new Tracking();
//                tracking.setCpdisponible(rs.getString(1));
//                tracking.setOrgdisponible(rs.getString(2));
//                tracking.setFtdisponible(rs.getString(3));
//                tracking.setRainfdisponible(rs.getString(4));
//                tracking.setConvdisponible(rs.getString(5));
                listaTracking.add(tracking);
            }
        } catch (Exception e) {

        }
        return listaTracking;
    }

}
