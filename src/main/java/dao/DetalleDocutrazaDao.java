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
import modelo.DetalleDocutrazaSelect;

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
            cs.setInt(1, iddetalledocutraza);
            cs.setInt(2, iddocutraza);
            cs.setInt(3, idlpaestimado);
            cs.setInt(4, idlpacontable);
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

    public static ArrayList<DetalleDocutraza> listDetalleDocutraza(
        int idempresa,int idsucursal,int iddocutraza
        ) {
        ArrayList listaDetalleDocutraza = new ArrayList();
        DetalleDocutraza detalledocutraza;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERDETALLEDOCUTRAZA(?,?,?)}");
            ps.setInt(1, idempresa);
            ps.setInt(2, idsucursal);
            ps.setInt(3, iddocutraza);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                detalledocutraza = new DetalleDocutraza();
                detalledocutraza.setIddetalledocutraza(rs.getInt(1));
                detalledocutraza.setIdcp(rs.getString(2));
                detalledocutraza.setIdorga(rs.getString(3));
                detalledocutraza.setCodagricultor(rs.getString(4));
                detalledocutraza.setIdpersona(rs.getInt(5));
                detalledocutraza.setApellidos(rs.getString(6));
                detalledocutraza.setNombres(rs.getString(7));
                detalledocutraza.setDni(rs.getString(8));
                detalledocutraza.setAnexo(rs.getString(9));
                detalledocutraza.setSacos(rs.getInt(10));
                detalledocutraza.setKb(rs.getDouble(11));
                detalledocutraza.setTara(rs.getDouble(12));
                detalledocutraza.setKn(rs.getDouble(13));
                detalledocutraza.setPrecio(rs.getDouble(14));
                detalledocutraza.setImportetotal(rs.getDouble(15));
                detalledocutraza.setGuia(rs.getString(16));
                detalledocutraza.setLiqcompra(rs.getString(17));
                detalledocutraza.setFecha(rs.getString(18));
                detalledocutraza.setEstado(rs.getString(19));
                listaDetalleDocutraza.add(detalledocutraza);
            }
        } catch (Exception e) {

        }
        return listaDetalleDocutraza;
    }

    public static ArrayList<DetalleDocutraza> listIdPersona(
            int idempresa,
            String codagricultor
    ) {
        ArrayList listaDetalleDocutraza = new ArrayList();
        DetalleDocutraza detalledocutraza;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENER_AGRICULTOR(?,?)}");
            ps.setInt(1, idempresa);
            ps.setString(2, codagricultor);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                detalledocutraza = new DetalleDocutraza();
                detalledocutraza.setIdpersona(rs.getInt(1));
                listaDetalleDocutraza.add(detalledocutraza);
            }
        } catch (Exception e) {

        }
        return listaDetalleDocutraza;
    }

    public static ArrayList<DetalleDocutrazaSelect> listDetalleDocutraza_Select(
            int idempresa,
            int idsucursal,
            int iddetalledocutraza
    ) {
        ArrayList listaDetalleDocutraza = new ArrayList();
        DetalleDocutrazaSelect detalledocutrazaselect;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERDETALLEDOCUTRAZA_SELECT(?,?,?)}");
            ps.setInt(1, idempresa);
            ps.setInt(2, idsucursal);
            ps.setInt(3, iddetalledocutraza);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                detalledocutrazaselect = new DetalleDocutrazaSelect();
                detalledocutrazaselect.setIddetalledocutraza(rs.getInt(1));
                detalledocutrazaselect.setIdempresa(rs.getInt(2));
                detalledocutrazaselect.setIdsucursal(rs.getInt(3));
                detalledocutrazaselect.setIddocutraza(rs.getInt(4));
                detalledocutrazaselect.setIdcompracontrato(rs.getInt(5));
                detalledocutrazaselect.setSeriguia(rs.getString(6));
                detalledocutrazaselect.setCorrelativo(rs.getString(7));
                detalledocutrazaselect.setCertificado(rs.getString(8));
                detalledocutrazaselect.setIdlpaest(rs.getInt(9));
                detalledocutrazaselect.setIdlpacon(rs.getInt(10));
                detalledocutrazaselect.setIdpersona(rs.getInt(11));
                detalledocutrazaselect.setIdorga(rs.getString(12));
                detalledocutrazaselect.setIdcp(rs.getString(13));
                detalledocutrazaselect.setCodagricultor(rs.getString(14));
                detalledocutrazaselect.setNombresagri(rs.getString(15));
                detalledocutrazaselect.setNombresaest(rs.getString(16));
                detalledocutrazaselect.setNombresacont(rs.getString(17));
                detalledocutrazaselect.setDniruc(rs.getString(18));
                detalledocutrazaselect.setCpdisp(rs.getDouble(19));
                detalledocutrazaselect.setOrgdisp(rs.getDouble(20));
                detalledocutrazaselect.setFtdisp(rs.getDouble(21));
                detalledocutrazaselect.setRainfdisp(rs.getDouble(22));
                detalledocutrazaselect.setConvdisp(rs.getDouble(23));
                detalledocutrazaselect.setSacos(rs.getInt(24));
                detalledocutrazaselect.setKb(rs.getDouble(25));
                detalledocutrazaselect.setTara(rs.getDouble(26));
                detalledocutrazaselect.setKn(rs.getDouble(27));
                detalledocutrazaselect.setPrecio(rs.getDouble(28));
                detalledocutrazaselect.setImportetotal(rs.getDouble(29));
                detalledocutrazaselect.setGuia(rs.getString(30));
                detalledocutrazaselect.setLiqcompra(rs.getString(31));
                detalledocutrazaselect.setFecha(rs.getString(32));
                detalledocutrazaselect.setEstado(rs.getString(33));
                listaDetalleDocutraza.add(detalledocutrazaselect);
            }
        } catch (Exception e) {

        }
        return listaDetalleDocutraza;
    }

    public static ArrayList<DetalleDocutraza> listIddetDocutraza(
            int iddocutraza
    ) {
        ArrayList listaDetalleDocutraza = new ArrayList();
        DetalleDocutraza detalledocutraza;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENER_IDDETDOCUTRAZA(?)}");
            ps.setInt(1, iddocutraza);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                detalledocutraza = new DetalleDocutraza();
                detalledocutraza.setIddocutraza(rs.getInt(1));
                listaDetalleDocutraza.add(detalledocutraza);
            }
        } catch (Exception e) {

        }
        return listaDetalleDocutraza;
    }

}
