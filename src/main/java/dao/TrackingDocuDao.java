///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import modelo.TrackingDocu;
//
///**
// *
// * @author MustainE
// */
//public class TrackingDocuDao {
//
//    public static ArrayList<TrackingDocu> listTrackingDocuini() {
//        ArrayList listaTrackingDocudocu = new ArrayList();
//        TrackingDocu detalledocumento;
//        try {
//            Connection accesoDB = modelo.Conexion.getConexion();
//            PreparedStatement ps = accesoDB.prepareStatement(modelo.TrackingDocu.SELECT_ALL);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                detalledocumento = new TrackingDocu();
//                detalledocumento.setIddocutraza(rs.getString(1));
//                detalledocumento.setIdempresa(rs.getString(2));
//                detalledocumento.setIdcliente(rs.getString(3));
//                detalledocumento.setRazonsocial(rs.getString(4));
//                detalledocumento.setFecha(rs.getString(5));
//                detalledocumento.setCertificado(rs.getString(6));
//                detalledocumento.setNroguia(rs.getString(7));
//                detalledocumento.setNrocontrato(rs.getString(8));
//                detalledocumento.setNrotrilla(rs.getString(9));
//                detalledocumento.setNroguiamcmnaki(rs.getString(10));
//                detalledocumento.setFactura(rs.getString(11));
//                detalledocumento.setSacos(rs.getInt(12));
//                detalledocumento.setKb(rs.getDouble(13));
//                detalledocumento.setKn(rs.getDouble(14));
//                detalledocumento.setPrimafairtrade(rs.getString(15));
//                detalledocumento.setNotacredito(rs.getString(16));
//                detalledocumento.setTcs(rs.getString(17));
//                detalledocumento.setCondicion(rs.getString(18));
//                detalledocumento.setEstado(rs.getString(19));
//                listaTrackingDocudocu.add(detalledocumento);
//            }
//        } catch (Exception e) {
//
//        }
//        return listaTrackingDocudocu;
//    }
//
//    public static ArrayList<TrackingDocu> listTrackingDocu() {
//        ArrayList listaTrackingDocudocu = new ArrayList();
//        TrackingDocu detalledocumento;
//        try {
//            Connection accesoDB = modelo.Conexion.getConexion();
//            PreparedStatement ps = accesoDB.prepareStatement(modelo.TrackingDocu.SELECT_ALLIDEMPRESA);
//            ps.setString(1, idempresa);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                detalledocumento = new TrackingDocu();
//                detalledocumento.setIddocutraza(rs.getString(1));
//                detalledocumento.setIdempresa(rs.getString(2));
//                detalledocumento.setIdcliente(rs.getString(3));
//                detalledocumento.setRazonsocial(rs.getString(4));
//                detalledocumento.setFecha(rs.getString(5));
//                detalledocumento.setCertificado(rs.getString(6));
//                detalledocumento.setNroguia(rs.getString(7));
//                detalledocumento.setNrocontrato(rs.getString(8));
//                detalledocumento.setNrotrilla(rs.getString(9));
//                detalledocumento.setNroguiamcmnaki(rs.getString(10));
//                detalledocumento.setFactura(rs.getString(11));
//                detalledocumento.setSacos(rs.getInt(12));
//                detalledocumento.setKb(rs.getDouble(13));
//                detalledocumento.setKn(rs.getDouble(14));
//                detalledocumento.setPrimafairtrade(rs.getString(15));
//                detalledocumento.setNotacredito(rs.getString(16));
//                detalledocumento.setTcs(rs.getString(17));
//                detalledocumento.setCondicion(rs.getString(18));
//                detalledocumento.setEstado(rs.getString(19));
//                listaTrackingDocudocu.add(detalledocumento);
//            }
//        } catch (Exception e) {
//
//        }
//        return listaTrackingDocudocu;
//    }
//
//    public static ArrayList<TrackingDocu> listTrackingDocubusca(String texto) {
//        ArrayList listaTrackingDocudocu = new ArrayList();
//        TrackingDocu detalledocumento;
//        try {
//            Connection accesoDB = modelo.Conexion.getConexion();
//            PreparedStatement ps = accesoDB.prepareStatement("select t1.idDocutraza,t1.idEmpresa,t1.idCliente,t2.RazonSocial,t1.fecha,t1.Certificado,t1.nroguia,t1.NroContrato,t1.NroTrilla,t1.NroGuiaMcmNaki,\n"
//                    + "t1.Factura,t1.Sacos,t1.kb,t1.kn,t1.PrimaFairtrade,t1.NotaCredito,t1.Tcs,t1.Condicion,t1.Estado from Docutraza t1\n"
//                    + "inner join cliente t2\n"
//                    + "on (t1.idCliente=t2.idCliente) where t1.idCliente like '%" + texto + "%' or t2.RazonSocial  like '%" + texto + "%' or t1.fecha like '%" + texto + "%' or t1.Certificado like '%" + texto + "%' or t1.nroguia like '%" + texto + "%' or t1.NroContrato like '%" + texto + "%' or t1.NroTrilla like '%" + texto + "%' or \n"
//                    + "t1.NroGuiaMcmNaki like '%" + texto + "%' or t1.Factura like '%" + texto + "%' or t1.PrimaFairtrade like '%" + texto + "%' or t1.NotaCredito like '%" + texto + "%' or t1.Tcs like '%" + texto + "%' or t1.Condicion like '%" + texto + "%' or \n"
//                    + "t1.Estado like '%" + texto + "%' order by Fecha asc");
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                detalledocumento = new TrackingDocu();
//                detalledocumento.setIddocutraza(rs.getString(1));
//                detalledocumento.setIdempresa(rs.getString(2));
//                detalledocumento.setIdcliente(rs.getString(3));
//                detalledocumento.setRazonsocial(rs.getString(4));
//                detalledocumento.setFecha(rs.getString(5));
//                detalledocumento.setCertificado(rs.getString(6));
//                detalledocumento.setNroguia(rs.getString(7));
//                detalledocumento.setNrocontrato(rs.getString(8));
//                detalledocumento.setNrotrilla(rs.getString(9));
//                detalledocumento.setNroguiamcmnaki(rs.getString(10));
//                detalledocumento.setFactura(rs.getString(11));
//                detalledocumento.setSacos(rs.getInt(12));
//                detalledocumento.setKb(rs.getDouble(13));
//                detalledocumento.setKn(rs.getDouble(14));
//                detalledocumento.setPrimafairtrade(rs.getString(15));
//                detalledocumento.setNotacredito(rs.getString(16));
//                detalledocumento.setTcs(rs.getString(17));
//                detalledocumento.setCondicion(rs.getString(18));
//                detalledocumento.setEstado(rs.getString(19));
//                listaTrackingDocudocu.add(detalledocumento);
//            }
//        } catch (Exception e) {
//
//        }
//        return listaTrackingDocudocu;
//    }
//
////    public static ArrayList<DetalleDocumento> listTrackingDetalledocu(String iddocutraza) {
////        ArrayList listaDetalleDocumento = new ArrayList();
////        DetalleDocumento detalledocumento;
////        try {
////            Connection accesoDB = modelo.Conexion.getConexion();
////            PreparedStatement ps = accesoDB.prepareStatement(modelo.DetalleDocumento.SELECT_DETALLE);
////            ps.setString(1, iddocutraza);
////            ResultSet rs = ps.executeQuery();
////            while (rs.next()) {
////                detalledocumento = new DetalleDocumento();
////                detalledocumento.setId(rs.getInt(1));
////                detalledocumento.setIddocutraza(rs.getString(1));
////                detalledocumento.setIdorga(rs.getString(2));
////                detalledocumento.setIdcp(rs.getString(3));
////                detalledocumento.setCodagricultor(rs.getString(4));
////                detalledocumento.setApeagricultor(rs.getString(5));
////                detalledocumento.setNomagricultor(rs.getString(6));
////                detalledocumento.setDniagricultor(rs.getString(7));
////                detalledocumento.setNomfinca(rs.getString(8));
////                detalledocumento.setNomanexo(rs.getString(9));
////                detalledocumento.setSacos(rs.getInt(10));
////                detalledocumento.setKb(rs.getDouble(11));
////                detalledocumento.setTara(rs.getDouble(12));
////                detalledocumento.setKn(rs.getDouble(13));
////                detalledocumento.setPrecio(rs.getDouble(14));
////                detalledocumento.setImportetotal(rs.getDouble(15));
////                detalledocumento.setLiqcompra(rs.getString(16));
////                detalledocumento.setFecha(rs.getString(17));
////                detalledocumento.setGuia(rs.getString(18));
////                detalledocumento.setEstado(rs.getString(19));
////                listaDetalleDocumento.add(detalledocumento);
////            }
////        } catch (Exception e) {
////
////        }
////        return listaDetalleDocumento;
////    }
////
////    public static ArrayList<Empresas> nomEmpresa() {
////        ArrayList listaEmpresas = new ArrayList();
////        Empresas empresas;
////        try {
////            Connection accesoDB = modelo.Conexion.getConexion();
////            PreparedStatement ps = accesoDB.prepareStatement("SELECT idempresa,RazonSocial FROM empresa where estado='A'");
////            ResultSet rs = ps.executeQuery();
////            while (rs.next()) {
////                empresas = new Empresas();
////                empresas.setIdempresas(rs.getString(1));
////                empresas.setRsocialss(rs.getString(2));
////                listaEmpresas.add(empresas);
////            }
////        } catch (Exception e) {
////
////        }
////        return listaEmpresas;
////    }
//
//    public ArrayList<TrackingDocu> TotalGuiaCoagro(String idempresa) {
//        ArrayList listaTrackingDocu = new ArrayList();
//        TrackingDocu detalledocumento;
//        try {
//            Connection accesoDB = modelo.Conexion.getConexion();
//            PreparedStatement ps = accesoDB.prepareStatement("select count(nroguia) AS GUIA from Docutraza where idempresa=?");
//            ps.setString(1, idempresa);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                detalledocumento = new TrackingDocu();
//                detalledocumento.setNroguia(rs.getString(1));
//                listaTrackingDocu.add(detalledocumento);
//            }
//        } catch (Exception e) {
//
//        }
//        return listaTrackingDocu;
//    }
//       public ArrayList<TrackingDocu> TotalTcCoagro(String idempresa) {
//        ArrayList listaTrackingDocu = new ArrayList();
//        TrackingDocu detalledocumento;
//        try {
//            Connection accesoDB = modelo.Conexion.getConexion();
//            PreparedStatement ps = accesoDB.prepareStatement("select count(tcs) AS TC  from Docutraza where tcs<>'S/N' and idempresa=?");
//            ps.setString(1, idempresa);
//            ResultSet rs = ps.executeQuery();s
//            while (rs.next()) {
//                detalledocumento = new TrackingDocu();
//                detalledocumento.setTcs(rs.getString(1));
//                listaTrackingDocu.add(detalledocumento);
//            }
//        } catch (Exception e) {
//
//        }
//        return listaTrackingDocu;
//    }
//
//}
