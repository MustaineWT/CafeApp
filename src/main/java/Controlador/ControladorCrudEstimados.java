/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import dao.EstimadoDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import modelo.Empleados;
import modelo.Empresas;
import vista.RegEstimados;

/**
 *
 * @author MustainE
 */
public class ControladorCrudEstimados implements ActionListener {

    RegEstimados vistaCRUD = new RegEstimados();
    EstimadoDao modeloCRUD = new EstimadoDao();

    public ControladorCrudEstimados(RegEstimados vistaCRUD, EstimadoDao modeloCRUD) {
        this.modeloCRUD = modeloCRUD;
        this.vistaCRUD = vistaCRUD;
        this.vistaCRUD.btnRegistrar.addActionListener(this);
        this.vistaCRUD.btnNuevo.addActionListener(this);
        this.vistaCRUD.btnImportar.addActionListener(this);
    }

    public void InicializarCrud() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaCRUD.btnRegistrar) {
            String validar = "A";
            for (int i = 0; i < vistaCRUD.jtEstimados.getRowCount(); i++) {
                String idorga = vistaCRUD.jtEstimados.getValueAt(i, 0).toString();
                if (idorga == "") {
                    validar = "B";
                    i = vistaCRUD.jtEstimados.getRowCount();
                }
            }
            if ((String) vistaCRUD.jcbEstado.getSelectedItem() == "--Seleccionar--") {
                JOptionPane.showMessageDialog(null, "Debe Llenar todos los datos necesarios y/o Seleccionar Estado.");
            } else if (validar == "B") {
                JOptionPane.showMessageDialog(null, "el excel no debe tener campos vacios.");
            } else {
                String Estado = "";
                if ((String) vistaCRUD.jcbEstado.getSelectedItem() == "Activo") {
                    Estado = "A";
                }
                if ((String) vistaCRUD.jcbEstado.getSelectedItem() == "Inactivo") {
                    Estado = "I";
                }
                String rptaRegistro = "";
                Empresas em = (Empresas) vistaCRUD.jcbEmpresa.getSelectedItem();
                String idempresa = em.getIdempresas().toString();
                Empleados emp = (Empleados) vistaCRUD.jcbEmpleado.getSelectedItem();
                String idempleado = emp.getIdempleados().toString();
                for (int i = 0; i < vistaCRUD.jtEstimados.getRowCount(); i++) {
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
                    String periodoini = formatoFecha.format(vistaCRUD.txtFc_Ini.getDate());
                    String periodofin = formatoFecha.format(vistaCRUD.txtFc_Fin.getDate());
                    String idorga = vistaCRUD.jtEstimados.getValueAt(i, 0).toString();
                    String idcp = vistaCRUD.jtEstimados.getValueAt(i, 1).toString();
                    String idcafepractice = vistaCRUD.jtEstimados.getValueAt(i, 2).toString();
                    String codagricultor = vistaCRUD.jtEstimados.getValueAt(i, 3).toString();
                    String apeagricultor = vistaCRUD.jtEstimados.getValueAt(i, 4).toString();
                    String nomagricultor = vistaCRUD.jtEstimados.getValueAt(i, 5).toString();
                    String dniagricultor = vistaCRUD.jtEstimados.getValueAt(i, 6).toString();
                    String nomfinca = vistaCRUD.jtEstimados.getValueAt(i, 7).toString();
                    String nomanexo = vistaCRUD.jtEstimados.getValueAt(i, 8).toString();
                    double cpinicial = Double.parseDouble(vistaCRUD.jtEstimados.getValueAt(i, 9).toString().replaceAll(",", "."));
                    double orginicial = Double.parseDouble(vistaCRUD.jtEstimados.getValueAt(i, 10).toString().replaceAll(",", "."));
                    double ftinicial = Double.parseDouble(vistaCRUD.jtEstimados.getValueAt(i, 11).toString().replaceAll(",", "."));
                    double rainfinicial = Double.parseDouble(vistaCRUD.jtEstimados.getValueAt(i, 12).toString().replaceAll(",", "."));
                    double convinicial = Double.parseDouble(vistaCRUD.jtEstimados.getValueAt(i, 13).toString().replaceAll(",", "."));
                    rptaRegistro = modeloCRUD.insertEstimados(periodoini, periodofin, idempresa, idempleado, idorga, idcp, idcafepractice, codagricultor, apeagricultor,
                            nomagricultor, dniagricultor, nomfinca, nomanexo, cpinicial, orginicial, ftinicial, rainfinicial, convinicial, Estado);
                }
                vistaCRUD.jcbEmpresa.setEnabled(false);
                vistaCRUD.jcbEmpleado.setEnabled(false);
                vistaCRUD.jcbEstado.setEnabled(false);
                vistaCRUD.txtFc_Ini.setEnabled(false);
                vistaCRUD.txtFc_Fin.setEnabled(false);
                if (rptaRegistro != null) {
                    JOptionPane.showMessageDialog(null, rptaRegistro);
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar el registro.");
                }
            }
        }
        if (e.getSource() == vistaCRUD.btnNuevo) {
            vistaCRUD.jcbEmpresa.setEnabled(true);
            vistaCRUD.jcbEmpleado.setEnabled(true);
            vistaCRUD.jcbEstado.setEnabled(true);
            vistaCRUD.txtFc_Ini.setEnabled(true);
            vistaCRUD.txtFc_Fin.setEnabled(true);
            DefaultComboBoxModel value1;
            value1 = new DefaultComboBoxModel();
            vistaCRUD.jcbEmpresa.setModel(value1);
            for (int i = 0; i < modeloCRUD.nomEmpresa().size(); i++) {
                value1.addElement(new Empresas(modeloCRUD.nomEmpresa().get(i).getIdempresas(), modeloCRUD.nomEmpresa().get(i).getRsocialss()));
            }
            DefaultComboBoxModel value2;
            value2 = new DefaultComboBoxModel();
            vistaCRUD.jcbEmpleado.setModel(value2);
            for (int i = 0; i < modeloCRUD.nomEmpleado().size(); i++) {
                value2.addElement(new Empleados(modeloCRUD.nomEmpleado().get(i).getIdempleados(), modeloCRUD.nomEmpleado().get(i).getNombre()));
            }
        }
           if (e.getSource() == vistaCRUD.btnImportar) {
            DefaultTableModel modelo = new DefaultTableModel();
            vistaCRUD.jtEstimados.setModel(modelo);
            JFileChooser examinar = new JFileChooser("C:\\Users\\User\\Google Drive\\CAFE.");
            examinar.setFileFilter(new FileNameExtensionFilter("Archivos excel", "xls", "xlsx"));
            int opcion = examinar.showOpenDialog(vistaCRUD.btnImportar);
            File archivoExcel = null;
            if (opcion == JFileChooser.APPROVE_OPTION) {
                archivoExcel = examinar.getSelectedFile().getAbsoluteFile();
                //JOptionPane.showMessageDialog(null, "Este es el Excel Selecionado la Ruta\n" + archivoExcel);
                try {
                    Workbook leerExcel = Workbook.getWorkbook(archivoExcel);
                    for (int hoja = 0; hoja < leerExcel.getNumberOfSheets(); hoja++) {
                        Sheet hojaP = leerExcel.getSheet(hoja);

                        int columnas = hojaP.getColumns();
                        int filas = hojaP.getRows();
                        //JOptionPane.showMessageDialog(null, "Nro de columnas" + columnas + "\n NroFilas :" + filas);
                        Object data[] = new Object[columnas];
                        for (int fila = 0; fila < filas; fila++) {
                            for (int columna = 0; columna < columnas; columna++) {
                                if (fila == 0) {
                                    modelo.addColumn(hojaP.getCell(columna, fila).getContents());
                                }
                                if (fila >= 1) {
                                    data[columna] = hojaP.getCell(columna, fila).getContents();
                                }
                            }
                            modelo.addRow(data);
                        }
                    }
                    modelo.removeRow(0);
                    //JOptionPane.showMessageDialog(null, "Archivo excel almacenado es el Worbook" + leerExcel);
                } catch (IOException | BiffException ex) {
                    Logger.getLogger(ControladorCrud.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Error al almacenar el excel en el workbook");

                }
            }
        }

    }
}
