/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
//PARA NO TENER PROBLEMAS REALIZAMOS PRIMERO
//LAS SIGUIENTES IMPORTACIONES

import java.awt.Desktop;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.*;

/**
 *
 * @author JeanCarlos
 */
public class ModeloExcel {

    Workbook book;

    public String CrearExcel(JTable tabla,String ArchivoNombre) {
        int NumeroFila = tabla.getRowCount(), NumeroColumna = tabla.getColumnCount();
        String nombreArchivo = "GRP_"+ArchivoNombre+".xlsx";
        String rutaArchivo = "C:\\Users\\wmtor\\Desktop\\" + nombreArchivo;
        String hoja = "Hoja1";
        XSSFWorkbook libro = new XSSFWorkbook();
        XSSFSheet hoja1 = libro.createSheet(hoja);
     
        CellStyle style = libro.createCellStyle();
        Font font = libro.createFont();

        font.setBoldweight((short) 0.1);
        style.setFont(font);
        //generar los datos para el documento
    
        for (int i = 0; i < NumeroFila;i++) {
            XSSFRow row = hoja1.createRow(i);//se crea las filas
            for (int j = 0; j < NumeroColumna; j++) {
                if (i == 0) {//para la cabecera
                    XSSFCell cell = row.createCell(j);//se crea las celdas para la cabecera, junto con la posición
                    cell.setCellStyle(style); // se añade el style crea anteriormente 
                    cell.setCellValue(String.valueOf(tabla.getColumnName(j)));//se añade el contenido					
                } else {//para el contenido
                    XSSFCell cell = row.createCell(j);//se crea las celdas para la contenido, junto con la posición
                    cell.setCellValue(String.valueOf(tabla.getValueAt(i, j))); //se añade el contenido
                }
            }
        }

        File file;
        file = new File(rutaArchivo);
        try (FileOutputStream fileOuS = new FileOutputStream(file)) {
            if (file.exists()) {// si el archivo existe se elimina
                file.delete();
                System.out.println("Archivo eliminado");
            }
            libro.write(fileOuS);
            fileOuS.flush();
            fileOuS.close();
            System.out.println("Archivo Creado");
            Desktop.getDesktop().open(file);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Archivo ";
    }
}
