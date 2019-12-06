/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wimdata.trac_api;

import org.apache.commons.lang3.StringUtils;
import vista.Login;
import vista.TraIni;

/**
 *
 * @author MustainE
 */
public class MainTrac {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //TraIni vistaP = new TraIni();
        Login vistaP = new Login();
        //RegDocumento rd = new RegDocumento();
       // RegEmpleado re = new RegEmpleado();
        //RegEmpresa rem = new RegEmpresa();
        //RegCliente rc = new RegCliente();
        vistaP.dispose();
        vistaP.setUndecorated(true);
        vistaP.setVisible(true);
        vistaP.setLocationRelativeTo(null);
        
    }

}
