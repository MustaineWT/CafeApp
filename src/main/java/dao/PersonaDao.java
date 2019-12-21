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
import modelo.Persona;

/**
 *
 * @author MustainE
 */
public class PersonaDao {

    public String insertPersona(
            int idpersona,
            int idempresa,
            int idsucursal,
            String tipopersona,
            String idorga,
            String idcp,
            String idcafepractice,
            String codagricultor,
            String razonsocial,
            String nombres,
            String apellidos,
            String dniruc,
            String email,
            String distrito,
            String direccion,
            String ciudad,
            String provincia,
            String pais,
            String celular,
            String nomfinca,
            String nomanexo,
            int ejercicio,
            String usuario,
            String contrasena,
            String tipousuario,
            String estado) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call SP_ACTUALIZARPERSONA(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, idpersona);
            cs.setInt(2, idempresa);
            cs.setInt(3, idsucursal);
            cs.setString(4, tipopersona);
            cs.setString(5, idorga);
            cs.setString(6, idcp);
            cs.setString(7, idcafepractice);
            cs.setString(8, codagricultor);
            cs.setString(9, razonsocial);
            cs.setString(10, nombres);
            cs.setString(11, apellidos);
            cs.setString(12, dniruc);
            cs.setString(13, email);
            cs.setString(14, direccion);
            cs.setString(15, distrito);
            cs.setString(16, ciudad);
            cs.setString(17, provincia);
            cs.setString(18, pais);
            cs.setString(19, celular);
            cs.setString(20, nomfinca);
            cs.setString(21, nomanexo);
            cs.setInt(22, ejercicio);
            cs.setString(23, usuario);
            cs.setString(24, contrasena);
            cs.setString(25, tipousuario);
            cs.setString(26, estado);

            int numFAfectas = cs.executeUpdate();

            if (numFAfectas == -1) {
                rptaRegistro = "Registro Exitoso.";
            }
        } catch (Exception e) {

        }
        return rptaRegistro;
    }

    public String updatePersona(
            int idpersona,
            int idempresa,
            int idsucursal,
            String tipopersona,
            String idorga,
            String idcp,
            String idcafepractice,
            String codagricultor,
            String razonsocial,
            String nombres,
            String apellidos,
            String dniruc,
            String email,
            String distrito,
            String direccion,
            String ciudad,
            String provincia,
            String pais,
            String celular,
            String nomfinca,
            String nomanexo,
            int ejercicio,
            String usuario,
            String contrasena,
            String tipousuario,
            String estado) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call SP_ACTUALIZARPERSONA(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, idpersona);
            cs.setInt(2, idempresa);
            cs.setInt(3, idsucursal);
            cs.setString(4, tipopersona);
            cs.setString(5, idorga);
            cs.setString(6, idcp);
            cs.setString(7, idcafepractice);
            cs.setString(8, codagricultor);
            cs.setString(9, razonsocial);
            cs.setString(10, nombres);
            cs.setString(11, apellidos);
            cs.setString(12, dniruc);
            cs.setString(13, email);
            cs.setString(14, direccion);
            cs.setString(15, distrito);
            cs.setString(16, ciudad);
            cs.setString(17, provincia);
            cs.setString(18, pais);
            cs.setString(19, celular);
            cs.setString(20, nomfinca);
            cs.setString(21, nomanexo);
            cs.setInt(22, ejercicio);
            cs.setString(23, usuario);
            cs.setString(24, contrasena);
            cs.setString(25, tipousuario);
            cs.setString(26, estado);

            int numFAfectas = cs.executeUpdate();

            if (numFAfectas == -1) {
                rptaRegistro = "Actualización Exitosa.";
            }
        } catch (Exception e) {

        }
        return rptaRegistro;
    }

    public static ArrayList<Persona> listPersona(int idempresa) {
        ArrayList listaPersona = new ArrayList();
        Persona persona;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERPERSONA(?)}");
            ps.setInt(1, idempresa);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                persona = new Persona();
                persona.setIdpersona(rs.getInt(1));
                persona.setIdempresa(rs.getInt(2));
                persona.setTipopersona(rs.getString(3));
                persona.setIdorga(rs.getString(4));
                persona.setIdcp(rs.getString(5));
                persona.setIdcafepractice(rs.getString(6));
                persona.setCodagricultor(rs.getString(7));
                persona.setRazonsocial(rs.getString(8));
                persona.setNombres(rs.getString(9));
                persona.setApellidos(rs.getString(10));
                persona.setDniruc(rs.getString(11));
                persona.setDireccion(rs.getString(12));
                persona.setDistrito(rs.getString(13));
                persona.setNomfinca(rs.getString(14));
                persona.setNomanexo(rs.getString(15));
                persona.setCelular(rs.getString(16));
                persona.setEstado(rs.getString(17));
                listaPersona.add(persona);
            }
        } catch (Exception e) {

        }
        return listaPersona;
    }
    public static ArrayList<Persona> listPersonaSelect(int idempresa,int idpersona) {
        ArrayList listaPersona = new ArrayList();
        Persona persona;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERPERSONA_SELECT(?,?)}");
            ps.setInt(1, idempresa);
            ps.setInt(1, idpersona);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                persona = new Persona();
                persona.setIdpersona(rs.getInt(1));
                persona.setTipopersona(rs.getString(3));
                persona.setIdorga(rs.getString(4));
                persona.setIdcp(rs.getString(5));
                persona.setIdcafepractice(rs.getString(6));
                persona.setCodagricultor(rs.getString(7));
                persona.setRazonsocial(rs.getString(8));
                persona.setNombres(rs.getString(9));
                persona.setApellidos(rs.getString(10));
                persona.setDniruc(rs.getString(11));
                persona.setEmail(rs.getString(12));
                persona.setDireccion(rs.getString(13));
                persona.setDistrito(rs.getString(14));
                persona.setCiudad(rs.getString(15));
                persona.setProvincia(rs.getString(16));
                persona.setPais(rs.getString(17));
                persona.setCelular(rs.getString(18));
                persona.setNomfinca(rs.getString(19));
                persona.setNomanexo(rs.getString(20));
                persona.setEjercicio(rs.getInt(21));
                persona.setUsuario(rs.getString(22));
                persona.setPassword(rs.getString(23));
                persona.setPersonatipo(rs.getString(24));
                persona.setEstado(rs.getString(25));
                listaPersona.add(persona);
            }
        } catch (Exception e) {

        }
        return listaPersona;
    }

         public static ArrayList<Persona> idNuevoPersona() {
        ArrayList listaPersona = new ArrayList();
        Persona persona;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERIDNUEVOPERSONA()}");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                persona = new Persona();
                persona.setIdpersona(rs.getInt(1));             
                listaPersona.add(persona);
            }
        } catch (Exception e) {
        }
        return listaPersona;
    }

}
