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
            CallableStatement cs = accesoDB.prepareCall("{call SP_ACTUALIZARPERSONA(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
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
            cs.setString(15, ciudad);
            cs.setString(16, provincia);
            cs.setString(17, pais);
            cs.setString(18, celular);
            cs.setString(19, nomfinca);
            cs.setString(20, nomanexo);
            cs.setInt(21, ejercicio);
            cs.setString(22, usuario);
            cs.setString(23, contrasena);
            cs.setString(24, tipousuario);
            cs.setString(25, estado);            

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
            CallableStatement cs = accesoDB.prepareCall("{call sp_iudPersona(?,?,?,?,?,?,?)}");
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
            cs.setString(15, ciudad);
            cs.setString(16, provincia);
            cs.setString(17, pais);
            cs.setString(18, celular);
            cs.setString(19, nomfinca);
            cs.setString(20, nomanexo);
            cs.setInt(21, ejercicio);
            cs.setString(22, usuario);
            cs.setString(23, contrasena);
            cs.setString(24, tipousuario);
            cs.setString(25, estado);

            int numFAfectas = cs.executeUpdate();

            if (numFAfectas == -1) {
                rptaRegistro = "Actualización Exitosa.";
            }
        } catch (Exception e) {

        }
        return rptaRegistro;
    }

    public String DeleteEmpresa(
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
            CallableStatement cs = accesoDB.prepareCall("{call sp_iudPersona(?,?,?,?,?,?)}");
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
            cs.setString(15, ciudad);
            cs.setString(16, provincia);
            cs.setString(17, pais);
            cs.setString(18, celular);
            cs.setString(19, nomfinca);
            cs.setString(20, nomanexo);
            cs.setInt(21, ejercicio);
            cs.setString(22, usuario);
            cs.setString(23, contrasena);
            cs.setString(24, tipousuario);
            cs.setString(25, estado);

            int numFAfectas = cs.executeUpdate();

            if (numFAfectas == -1) {
                rptaRegistro = "Registro Inactivo Exitosa.";
            }
        } catch (Exception e) {

        }
        return rptaRegistro;
    }

    public ArrayList<Persona> listPersona() {
        ArrayList listaPersona = new ArrayList();
        Persona persona;
        try {
            Connection accesoDB = modelo.Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareCall("{call SP_OBTENERPERSONA()}");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                persona = new Persona();
                persona.setIdpersona(rs.getInt(1));
                persona.setIdempresa(rs.getInt(2));
                persona.setIdsucursal(rs.getInt(3));
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
                persona.setCiudad(rs.getString(14));
                persona.setProvincia(rs.getString(15));
                persona.setPais(rs.getString(16));
                persona.setNomfinca(rs.getString(17));
                persona.setNomanexo(rs.getString(18));
                persona.setCelular(rs.getString(19));
                persona.setEstado(rs.getString(20));
                listaPersona.add(persona);
            }
        } catch (Exception e) {

        }
        return listaPersona;
    }  

}