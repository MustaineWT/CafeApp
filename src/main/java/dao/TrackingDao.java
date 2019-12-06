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
import modelo.Tracking;

/**
 *
 * @author MustainE
 */
public class TrackingDao {

    public static String cargaDatos() {
        String rptaRegistro = null;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call sp_reportetracking()}");

            int numFAfectas = cs.executeUpdate();

            if (numFAfectas == -1) {
                rptaRegistro = "Registro Exitoso.";
            }
        } catch (Exception e) {

        }
        return rptaRegistro;
    }

//System.outprintln(formatea.format(valor));
//Nos devuelve 1.000
    public static ArrayList<Tracking> listTracking(String idempresa) {
        ArrayList listaTracking = new ArrayList();
        Tracking tracking;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(modelo.Tracking.SELECT_FORMAT);
            ps.setString(1, idempresa);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tracking = new Tracking();
                tracking.setIdempresa(rs.getString(1));
                tracking.setIdcp(rs.getString(2));
                tracking.setIdcafepractice(rs.getString(3));
                tracking.setCodagri(rs.getString(4));
                tracking.setApeagri(rs.getString(5));
                tracking.setNomagri(rs.getString(6));
                tracking.setDniagri(rs.getString(7));
                tracking.setNomfinca(rs.getString(8));
                tracking.setNomanexo(rs.getString(9));
                tracking.setCpinicial(rs.getString(10));
                tracking.setOrginicial(rs.getString(11));
                tracking.setFtinicial(rs.getString(12));
                tracking.setRainfinicial(rs.getString(13));
                tracking.setConvinicial(rs.getString(14));
                tracking.setCpavance(rs.getString(15));
                tracking.setOrgavance(rs.getString(16));
                tracking.setFtavance(rs.getString(17));
                tracking.setRainfavance(rs.getString(18));
                tracking.setConvavance(rs.getString(19));
                tracking.setCpdisponible(rs.getString(20));
                tracking.setOrgdisponible(rs.getString(21));
                tracking.setFtdisponible(rs.getString(22));
                tracking.setRainfdisponible(rs.getString(23));
                tracking.setConvdisponible(rs.getString(24));
                listaTracking.add(tracking);
            }
        } catch (Exception e) {

        }
        return listaTracking;
    }

    public static ArrayList<Tracking> listTrackingini() {
        ArrayList listaTracking = new ArrayList();
        Tracking tracking;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(Tracking.SELECT_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tracking = new Tracking();
                tracking.setIdempresa(rs.getString(1));
                tracking.setIdcp(rs.getString(2));
                tracking.setIdcafepractice(rs.getString(3));
                tracking.setCodagri(rs.getString(4));
                tracking.setApeagri(rs.getString(5));
                tracking.setNomagri(rs.getString(6));
                tracking.setDniagri(rs.getString(7));
                tracking.setNomfinca(rs.getString(8));
                tracking.setNomanexo(rs.getString(9));
                tracking.setCpinicial(rs.getString(10));
                tracking.setOrginicial(rs.getString(11));
                tracking.setFtinicial(rs.getString(12));
                tracking.setRainfinicial(rs.getString(13));
                tracking.setConvinicial(rs.getString(14));
                tracking.setCpavance(rs.getString(15));
                tracking.setOrgavance(rs.getString(16));
                tracking.setFtavance(rs.getString(17));
                tracking.setRainfavance(rs.getString(18));
                tracking.setConvavance(rs.getString(19));
                tracking.setCpdisponible(rs.getString(20));
                tracking.setOrgdisponible(rs.getString(21));
                tracking.setFtdisponible(rs.getString(22));
                tracking.setRainfdisponible(rs.getString(23));
                tracking.setConvdisponible(rs.getString(24));
                listaTracking.add(tracking);
            }
            rs.close();
        } catch (Exception e) {

        }
        return listaTracking;
    }

    public static ArrayList<Tracking> listTrackingbuscar(String texto) {
        ArrayList listaTracking = new ArrayList();
        Tracking tracking;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement("SELECT idempresa,idcp,idcafepractice,codagricultor,apeagricultor,nomagricultor,dniagricultor,nomfinca,nomanexo\n"
                    + "      ,format(cpinicial, '#,##0.00') AS cpinicial\n"
                    + "      ,format(orginicial, '#,##0.00') AS orginicial\n"
                    + "      ,format(ftinicial, '#,##0.00') AS ftinicial\n"
                    + "      ,format(rainfinicial, '#,##0.00') AS rainfinicial\n"
                    + "      ,format(convinicial, '#,##0.00') AS convinicial\n"
                    + "      ,format(cpavance, '#,##0.00') AS cpavance\n"
                    + "      ,format(orgavance, '#,##0.00') AS orgavance\n"
                    + "      ,format(ftavance, '#,##0.00') AS ftavance\n"
                    + "      ,format(rainfavance, '#,##0.00') AS rainfavance\n"
                    + "      ,format(convavance, '#,##0.00') AS convavance\n"
                    + "      ,format(cpdisponible, '#,##0.00') AS cpdisponible\n"
                    + "      ,format(orgdisponible, '#,##0.00') AS orgdisponible\n"
                    + "      ,format(ftdisponible, '#,##0.00') AS ftdisponible\n"
                    + "      ,format(rainfdisponible, '#,##0.00') AS rainfdisponible\n"
                    + "      ,format(convdisponible, '#,##0.00') AS convdisponible\n"
                    + "  FROM tracking where idcp LIKE '%" + texto + "%' OR idcafepractice LIKE '%" + texto + "%'OR codagricultor LIKE '%" + texto + "%'OR apeagricultor LIKE '%" + texto + "%'"
                    + "OR nomagricultor LIKE '%" + texto + "%'OR dniagricultor LIKE '%" + texto + "%'OR nomfinca LIKE '%" + texto + "%'OR nomanexo LIKE '%" + texto + "%'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tracking = new Tracking();
                tracking.setIdempresa(rs.getString(1));
                tracking.setIdcp(rs.getString(2));
                tracking.setIdcafepractice(rs.getString(3));
                tracking.setCodagri(rs.getString(4));
                tracking.setApeagri(rs.getString(5));
                tracking.setNomagri(rs.getString(6));
                tracking.setDniagri(rs.getString(7));
                tracking.setNomfinca(rs.getString(8));
                tracking.setNomanexo(rs.getString(9));
                tracking.setCpinicial(rs.getString(10));
                tracking.setOrginicial(rs.getString(11));
                tracking.setFtinicial(rs.getString(12));
                tracking.setRainfinicial(rs.getString(13));
                tracking.setConvinicial(rs.getString(14));
                tracking.setCpavance(rs.getString(15));
                tracking.setOrgavance(rs.getString(16));
                tracking.setFtavance(rs.getString(17));
                tracking.setRainfavance(rs.getString(18));
                tracking.setConvavance(rs.getString(19));
                tracking.setCpdisponible(rs.getString(20));
                tracking.setOrgdisponible(rs.getString(21));
                tracking.setFtdisponible(rs.getString(22));
                tracking.setRainfdisponible(rs.getString(23));
                tracking.setConvdisponible(rs.getString(24));
                listaTracking.add(tracking);
            }
            rs.close();
        } catch (Exception e) {

        }
        return listaTracking;
    }

//    public static ArrayList<Empresas> nomEmpresa() {
//        ArrayList listaEmpresas = new ArrayList();
//        Empresas empresas;
//        try {
//            Connection accesoDB = modelo.Conexion.getConexion();
//            PreparedStatement ps = accesoDB.prepareStatement("SELECT idempresa,RazonSocial FROM empresa where estado='A'");
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                empresas = new Empresas();
//                empresas.setIdempresas(rs.getString(1));
//                empresas.setRsocialss(rs.getString(2));
//                listaEmpresas.add(empresas);
//            }
//        } catch (Exception e) {
//
//        }
//        return listaEmpresas;
//    }

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
                tracking.setCpdisponible(rs.getString(1));
                tracking.setOrgdisponible(rs.getString(2));
                tracking.setFtdisponible(rs.getString(3));
                tracking.setRainfdisponible(rs.getString(4));
                tracking.setConvdisponible(rs.getString(5));
                listaTracking.add(tracking);
            }
        } catch (Exception e) {

        }
        return listaTracking;
    }

    public ArrayList<Tracking> Totalesini() {
        ArrayList listaTracking = new ArrayList();
        Tracking tracking;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement("select sum(cpdisponible) as cafepractice,sum(orgdisponible) as organico,sum(ftdisponible) as fairtrade,sum(rainfdisponible) as rainforest,sum(convdisponible) as convencional from tracking where idempresa=(select top 1 idempresa from empresa where estado='A')");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tracking = new Tracking();
                tracking.setCpdisponible(rs.getString(1));
                tracking.setOrgdisponible(rs.getString(2));
                tracking.setFtdisponible(rs.getString(3));
                tracking.setRainfdisponible(rs.getString(4));
                tracking.setConvdisponible(rs.getString(5));
                listaTracking.add(tracking);
            }
        } catch (Exception e) {

        }
        return listaTracking;
    }

}
