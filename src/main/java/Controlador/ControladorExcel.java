/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
//PARA NO TENER PROBLEMAS REALIZAMOS PRIMERO
//LAS SIGUIENTES IMPORTACIONES

import java.awt.event.ActionEvent;
import java.io.*;

import Modelo.ModeloExcel;
import com.sun.rowset.internal.Row;
import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import jxl.Cell;
import jxl.Sheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import vista.RAgriEstimado;

/**
 *
 * @author JeanCarlos
 */
public class ControladorExcel implements ActionListener {

    ModeloExcel ModeloEX = new ModeloExcel();
    RAgriEstimado VistaEX = new RAgriEstimado();
    JFileChooser SelectArchivo = new JFileChooser();
    File archivo;
    int contador = 0;

    public ControladorExcel(RAgriEstimado VistaEX, ModeloExcel ModeloEX) {
        this.VistaEX = VistaEX;
        this.ModeloEX = ModeloEX;
        this.VistaEX.btnExcel.addActionListener(this);
    }

    public void AgregarFiltro() {
        SelectArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xls)", "xls"));
        SelectArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*.xlsx)", "xlsx"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        contador++;
        if (contador == 1) {
            AgregarFiltro();
        }
        if (e.getSource() == VistaEX.btnExcel) {
            DefaultTableModel modelotabla = (DefaultTableModel) VistaEX.jtListProveedores.getModel();
            String id = (String) modelotabla.getValueAt(1,17);
            ModeloEX.CrearExcel(VistaEX.jtListProveedores,id);
        }
    }
}
