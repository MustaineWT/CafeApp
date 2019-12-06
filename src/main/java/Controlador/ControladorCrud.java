/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import vista.RegDocumento;
import dao.DocumentoDao;
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
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import modelo.Clientes;
import modelo.Empresas;

/**
 *
 * @author MustainE
 */
public class ControladorCrud implements ActionListener {

    RegDocumento vistaCRUD = new RegDocumento();
    DocumentoDao modeloCRUD = new DocumentoDao();

    public ControladorCrud(RegDocumento vistaCRUD, DocumentoDao modeloCRUD) {
        this.modeloCRUD = modeloCRUD;
        this.vistaCRUD = vistaCRUD;
        this.vistaCRUD.btnRegistrar.addActionListener(this);
        this.vistaCRUD.btnImportar.addActionListener(this);
        this.vistaCRUD.btnNuevo.addActionListener(this);
    }

    public void InicializarCrud() {

    }

    public void LlenarTabla(JTable tablaD) {
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        modeloT.addColumn("Fecha");
        modeloT.addColumn("Empresa");
        modeloT.addColumn("Cliente");
        modeloT.addColumn("Certificado");
        modeloT.addColumn("Nro.Guia");
        modeloT.addColumn("Nro.Contrato");
        modeloT.addColumn("Nro.Trilla");
        modeloT.addColumn("Nro.GuiaMcmNaki");
        modeloT.addColumn("Facturas");
        modeloT.addColumn("Sacos");
        modeloT.addColumn("Kb");
        modeloT.addColumn("Kn");
        modeloT.addColumn("Pri.Fairtrade");
        modeloT.addColumn("NCredito");
        modeloT.addColumn("Tcs");
        modeloT.addColumn("Condición");

        Object[] columna = new Object[15];
        int numRegistros = modeloCRUD.listDocumento().size();
        for (int i = 0; i < numRegistros; i++) {
            columna[0] = modeloCRUD.listDocumento().get(i).getFecha();
            columna[1] = modeloCRUD.listDocumento().get(i).getEmpresa();
            columna[2] = modeloCRUD.listDocumento().get(i).getCliente();
            columna[3] = modeloCRUD.listDocumento().get(i).getCertificado();
            columna[4] = modeloCRUD.listDocumento().get(i).getNroguia();
            columna[5] = modeloCRUD.listDocumento().get(i).getNrocontrato();
            columna[6] = modeloCRUD.listDocumento().get(i).getNrotrilla();
            columna[7] = modeloCRUD.listDocumento().get(i).getNroguiamcmnaki();
            columna[8] = modeloCRUD.listDocumento().get(i).getFactura();
            columna[9] = modeloCRUD.listDocumento().get(i).getSacos();
            columna[10] = modeloCRUD.listDocumento().get(i).getKb();
            columna[11] = modeloCRUD.listDocumento().get(i).getKn();
            columna[12] = modeloCRUD.listDocumento().get(i).getPrimafairtrade();
            columna[13] = modeloCRUD.listDocumento().get(i).getNotacredito();
            columna[14] = modeloCRUD.listDocumento().get(i).getTcs();
            columna[15] = modeloCRUD.listDocumento().get(i).getCondicion();
            modeloT.addRow(columna);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaCRUD.btnRegistrar) {
            String validar = "A";
            for (int i = 0; i < vistaCRUD.jtDocumentos.getRowCount(); i++) {
                String idorga = vistaCRUD.jtDocumentos.getValueAt(i, 0).toString();
                System.out.println(idorga);
                if (idorga == "") {
                    validar = "B";
                    i = vistaCRUD.jtDocumentos.getRowCount();
                }
            }
            if (//(String) vistaCRUD.jcbEmpresa.getSelectedItem() == "--Seleccionar--" || (String) vistaCRUD.jcbCliente.getSelectedItem() == "--Seleccionar--"
                    //  || (String) vistaCRUD.jcbEstado.getSelectedItem() == "--Seleccionar--" || (String) vistaCRUD.jcbCondicion.getSelectedItem() == "--Seleccionar--"
                    //  || (String) vistaCRUD.jcbCertificado.getSelectedItem() == "--Seleccionar--"
                    //  || 
                    vistaCRUD.txtFecha.getDate() == null
                    || vistaCRUD.txtTrilla.getText().isEmpty() || vistaCRUD.txtGuiaMcmNaki.getText().isEmpty()
                    || vistaCRUD.txtFactura.getText().isEmpty() || vistaCRUD.txtPFairtrade.getText().isEmpty()
                    || vistaCRUD.txtNCredito.getText().isEmpty() || vistaCRUD.txtTc.getText().isEmpty() || vistaCRUD.txtKB.getText().isEmpty()
                    || vistaCRUD.txtKN.getText().isEmpty() || vistaCRUD.txtSacos.getText().isEmpty() || vistaCRUD.txtFecha.getDateFormatString().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe Llenar todos los datos necesarios y/o Seleccionar cliente, empresa,certificado,condición.");

            } else if (validar == "B") {
                JOptionPane.showMessageDialog(null, "el excel no debe tener campos vacios.");
            } else {
                Clientes cl = (Clientes) vistaCRUD.jcbCliente.getSelectedItem();
                Empresas em = (Empresas) vistaCRUD.jcbEmpresa.getSelectedItem();
                String empresa = em.getIdempresas().toString();
                String cliente = cl.getIdclientes().toString();
                String certificado = (String) vistaCRUD.jcbCertificado.getSelectedItem();
                String Estado = "";
                if ((String) vistaCRUD.jcbEstado.getSelectedItem() == "Activo") {
                    Estado = "A";
                }
                if ((String) vistaCRUD.jcbEstado.getSelectedItem() == "Inactivo") {
                    Estado = "I";
                }
                String nroguia = vistaCRUD.txtGuia.getText();
                String nrocontrato = vistaCRUD.txtContrato.getText();
                String nrotrilla = vistaCRUD.txtTrilla.getText();
                String nroguiamcmnaki = vistaCRUD.txtGuiaMcmNaki.getText();
                String factura = vistaCRUD.txtFactura.getText();
                int sacos = Integer.parseInt(vistaCRUD.txtSacos.getText());
                double kb = Double.parseDouble(vistaCRUD.txtKB.getText());
                double kn = Double.parseDouble(vistaCRUD.txtKN.getText());
                String primafairtrade = vistaCRUD.txtPFairtrade.getText();
                String notacredito = vistaCRUD.txtNCredito.getText();
                String tcs = vistaCRUD.txtTc.getText();
                String condicion = (String) vistaCRUD.jcbCondicion.getSelectedItem();
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
                String fecha = formatoFecha.format(vistaCRUD.txtFecha.getDate());

                String rptaRegistro = modeloCRUD.insertDocumento(empresa, cliente, fecha, certificado, nroguia, nrocontrato, nrotrilla, nroguiamcmnaki, factura,
                        sacos, kb, kn, primafairtrade, notacredito, tcs, condicion, Estado);

                String iddocutraza = modeloCRUD.idDocumento2().get(0).getDocutraza();
                String rptaRegistrodetalle = "";

                for (int i = 0; i < vistaCRUD.jtDocumentos.getRowCount(); i++) {
                    String idorga = vistaCRUD.jtDocumentos.getValueAt(i, 0).toString();
                    String idcp = vistaCRUD.jtDocumentos.getValueAt(i, 1).toString();
                    String codagricultor = vistaCRUD.jtDocumentos.getValueAt(i, 2).toString();
                    String apeagricultor = vistaCRUD.jtDocumentos.getValueAt(i, 3).toString();
                    String nomagricultor = vistaCRUD.jtDocumentos.getValueAt(i, 4).toString();
                    String dniagricultor = vistaCRUD.jtDocumentos.getValueAt(i, 5).toString();
                    String nomfinca = vistaCRUD.jtDocumentos.getValueAt(i, 6).toString();
                    String nomanexo = vistaCRUD.jtDocumentos.getValueAt(i, 7).toString();
                    int sacoss = Integer.parseInt(vistaCRUD.jtDocumentos.getValueAt(i, 8).toString());
                    double kbb = Double.parseDouble(vistaCRUD.jtDocumentos.getValueAt(i, 9).toString().replaceAll(",", "."));
                    double taraa = Double.parseDouble(vistaCRUD.jtDocumentos.getValueAt(i, 10).toString().replaceAll(",", "."));
                    double knn = Double.parseDouble(vistaCRUD.jtDocumentos.getValueAt(i, 11).toString().replaceAll(",", "."));
                    double precioo = Double.parseDouble(vistaCRUD.jtDocumentos.getValueAt(i, 12).toString().replaceAll(",", "."));
                    double importetotall = Double.parseDouble(vistaCRUD.jtDocumentos.getValueAt(i, 13).toString().replaceAll(",", "."));
                    String liqcompra = vistaCRUD.jtDocumentos.getValueAt(i, 14).toString();
                    String fecha2 = vistaCRUD.jtDocumentos.getValueAt(i, 15).toString();                    
                    String guia = vistaCRUD.jtDocumentos.getValueAt(i, 16).toString();
                    String Estado1 = "";
                    if ((String) vistaCRUD.jcbEstado.getSelectedItem() == "Activo") {
                        Estado = "A";
                    }
                    if ((String) vistaCRUD.jcbEstado.getSelectedItem() == "Inactivo") {
                        Estado = "I";
                    }
                    rptaRegistrodetalle = modeloCRUD.insertDetalle(iddocutraza, idorga, idcp, codagricultor, apeagricultor, nomagricultor, dniagricultor, nomfinca, nomanexo,
                            sacoss, kbb, taraa, knn, precioo, importetotall, liqcompra, fecha2, guia, Estado1);

                }

                if (rptaRegistrodetalle != null) {
                    JOptionPane.showMessageDialog(null, rptaRegistro);
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar el registro.");
                }
                vistaCRUD.jcbEmpresa.setSelectedIndex(0);
                vistaCRUD.jcbCliente.setSelectedIndex(0);
                vistaCRUD.jcbEstado.setSelectedIndex(0);
                vistaCRUD.jcbCondicion.setSelectedIndex(0);
                vistaCRUD.jcbCertificado.setSelectedIndex(0);
                vistaCRUD.txtId.setText("");
                vistaCRUD.txtGuia.setText("");
                vistaCRUD.txtContrato.setText("S/N");
                vistaCRUD.txtTrilla.setText("S/N");
                vistaCRUD.txtGuiaMcmNaki.setText("S/N");
                vistaCRUD.txtFactura.setText("S/N");
                vistaCRUD.txtSacos.setText("0");
                vistaCRUD.txtKB.setText("0.00");
                vistaCRUD.txtKN.setText("0.00");
                vistaCRUD.txtPFairtrade.setText("S/N");
                vistaCRUD.txtNCredito.setText("S/N");
                vistaCRUD.txtTc.setText("S/N");
                vistaCRUD.txtId.setEnabled(false);
                vistaCRUD.txtGuia.setEnabled(false);
                vistaCRUD.txtContrato.setEnabled(false);
                vistaCRUD.txtTrilla.setEnabled(false);
                vistaCRUD.txtGuiaMcmNaki.setEnabled(false);
                vistaCRUD.txtFactura.setEnabled(false);
                vistaCRUD.txtSacos.setEnabled(false);
                vistaCRUD.txtKB.setEnabled(false);
                vistaCRUD.txtKN.setEnabled(false);
                vistaCRUD.txtPFairtrade.setEnabled(false);
                vistaCRUD.txtNCredito.setEnabled(false);
                vistaCRUD.txtTc.setEnabled(false);
                vistaCRUD.jcbEmpresa.setEnabled(false);
                vistaCRUD.jcbCliente.setEnabled(false);
                vistaCRUD.jcbEstado.setEnabled(false);
                vistaCRUD.jcbCondicion.setEnabled(false);
                vistaCRUD.jcbCertificado.setEnabled(false);
                vistaCRUD.btnRegistrar.setEnabled(false);
                vistaCRUD.btnNuevo.setEnabled(true);
                DefaultTableModel modelo = (DefaultTableModel) vistaCRUD.jtDocumentos.getModel();
                while (modelo.getRowCount() > 0) {
                    modelo.removeRow(0);
                }

                TableColumnModel modCol = vistaCRUD.jtDocumentos.getColumnModel();
                while (modCol.getColumnCount() > 0) {
                    modCol.removeColumn(modCol.getColumn(0));
                }
                if (rptaRegistro != null) {
                    JOptionPane.showMessageDialog(null, rptaRegistro);
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar el registro.");
                }
            }
        }
        if (e.getSource() == vistaCRUD.btnNuevo) {
            DefaultComboBoxModel value;
            value = new DefaultComboBoxModel();
            vistaCRUD.jcbCliente.setModel(value);
            for (int i = 0; i < modeloCRUD.nomCliente().size(); i++) {
                value.addElement(new Clientes(modeloCRUD.nomCliente().get(i).getIdclientes(), modeloCRUD.nomCliente().get(i).getRsocials()));
            }
            DefaultComboBoxModel value1;
            value1 = new DefaultComboBoxModel();
            vistaCRUD.jcbEmpresa.setModel(value1);
            for (int i = 0; i < modeloCRUD.nomEmpresa().size(); i++) {
                value1.addElement(new Empresas(modeloCRUD.nomEmpresa().get(i).getIdempresas(), modeloCRUD.nomEmpresa().get(i).getRsocialss()));
            }
            vistaCRUD.jcbEstado.setSelectedIndex(1);
            vistaCRUD.jcbCondicion.setSelectedIndex(1);
            vistaCRUD.jcbCertificado.setSelectedIndex(1);
            vistaCRUD.btnRegistrar.setEnabled(true);
            vistaCRUD.btnNuevo.setEnabled(false);
            vistaCRUD.txtFecha.setEnabled(true);
            vistaCRUD.jcbEmpresa.setEnabled(true);
            vistaCRUD.jcbCliente.setEnabled(true);
            vistaCRUD.jcbEstado.setEnabled(true);
            vistaCRUD.jcbCondicion.setEnabled(true);
            vistaCRUD.jcbCertificado.setEnabled(true);
            vistaCRUD.txtId.setEnabled(false);
            vistaCRUD.txtGuia.setEnabled(true);
            vistaCRUD.txtContrato.setEnabled(true);
            vistaCRUD.txtTrilla.setEnabled(true);
            vistaCRUD.txtGuiaMcmNaki.setEnabled(true);
            vistaCRUD.txtFactura.setEnabled(true);
            vistaCRUD.txtSacos.setEnabled(true);
            vistaCRUD.txtKB.setEnabled(true);
            vistaCRUD.txtKN.setEnabled(true);
            vistaCRUD.txtPFairtrade.setEnabled(true);
            vistaCRUD.txtNCredito.setEnabled(true);
            vistaCRUD.txtTc.setEnabled(true);
            vistaCRUD.txtGuia.requestFocus();
            vistaCRUD.txtId.setText(modeloCRUD.idDocumento().get(0).getDocutraza());
        }
        if (e.getSource() == vistaCRUD.btnImportar) {
            DefaultTableModel modelo = new DefaultTableModel();
            vistaCRUD.jtDocumentos.setModel(modelo);
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
