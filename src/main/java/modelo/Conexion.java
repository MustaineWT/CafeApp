/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author MustainE
 */
public class Conexion {

    static Connection contacto = null;

    public static Connection getConexion() {

        boolean produccion = false;//cambiar a true para produccion.
        if (produccion == false) {
            String url = "jdbc:sqlserver://DESKTOP-3CPB4UK\\MSSQLSERVER:1433;databaseName=Cafebd";
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            } catch (ClassNotFoundException e) {
                JOptionPane.showConfirmDialog(null, "No se pudo establecer" + e.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
            }
            try {
                contacto = DriverManager.getConnection(url, "saaa", "123456");
            } catch (SQLException e) {
                JOptionPane.showConfirmDialog(null, "Error" + e.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            String url = "jdbc:sqlserver://CAFEAPROSEM\\MSSQLSERVER:1433;databaseName=Cafebd";
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            } catch (ClassNotFoundException e) {
                JOptionPane.showConfirmDialog(null, "No se pudo establecer" + e.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
            }
            try {
                contacto = DriverManager.getConnection(url, "saaa", "123456");
            } catch (SQLException e) {
                JOptionPane.showConfirmDialog(null, "Error" + e.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
            }
        }

        return contacto;
    }

    public static ResultSet Consulta(String consulta) {
        Connection con = getConexion();
        Statement declara;
        try {
            declara = con.createStatement();
            ResultSet respuesta = declara.executeQuery(consulta);

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "No se pudo establecer" + e.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

}