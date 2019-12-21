/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Uti;

import com.sun.rowset.internal.Row;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import jxl.Cell;
import modelo.DetalleDocutraza;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author wmtor
 */
public class ExportarExcel {

    //public  void exportarExcel(JTable t, int empresa, int sucursal, int dct) throws IOException {
    public static void exportarExcel(){
        ArrayList<DetalleDocutraza> ListaConformacion = null;
//        JFileChooser chooser = new JFileChooser();
//        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
//        chooser.setFileFilter(filter);
//        chooser.setDialogTitle("Guardar archivo");
//        chooser.setAcceptAllFileFilterUsed(false);
//        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
//            String ruta = chooser.getSelectedFile().toString().concat(".xls");
//
//            File archivoXLS = new File(ruta);
//            if (archivoXLS.exists()) {
//                archivoXLS.delete();
//            }
            XSSFWorkbook workbook = new XSSFWorkbook();

            XSSFSheet sheet = workbook.createSheet("Employee Data");
            //ListaConformacion = dao.DetalleDocutrazaDao.listDetalleDocutraza(empresa, sucursal, dct);
            //int filas = t.getRowCount();
            Map<String, Object[]> data = new TreeMap<String, Object[]>();
          //  for (int fila = 0; fila < filas; fila++) {
//                data.put(fila + "", new Object[]{fila, ListaConformacion.get(fila).getIdcp(), ListaConformacion.get(fila).getIdorga()});
//            }

            data.put("1", new Object[]{"ID", "NAME", "LASTNAME"});
            data.put("2", new Object[]{1, "Lokesh", "Gupta"});
            data.put("3", new Object[]{2, "Lokesh", "Gupta"});
            data.put("4", new Object[]{3, "John", "Adwards"});
            data.put("5", new Object[]{4, "Brian", "Schultz"});
            //Iterate over data and write to sheet
            Set<String> keyset = data.keySet();
            int rownum = 0;
            for (String key : keyset) {
                XSSFRow row = sheet.createRow(rownum++);
                Object[] objArr = data.get(key);
                System.out.println(objArr);
                int cellnum = 0;
                for (Object obj : objArr) {
                    XSSFCell cell = row.createCell(cellnum++);
                    if (obj instanceof String) {
                        cell.setCellValue((String) obj);
                    } else if (obj instanceof Integer) {
                        cell.setCellValue((Integer) obj);
                        
                    }
                }
            }
            try {
                //Write the workbook in file system
                FileOutputStream out = new FileOutputStream(new File("howtodoinjava_demo.xlsx"));
                workbook.write(out);
                out.close();
                System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
//}
