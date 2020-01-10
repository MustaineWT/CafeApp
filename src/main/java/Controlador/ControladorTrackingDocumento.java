/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Uti.GestionCeldas;
import static Uti.GestionCeldas.isNumeric;
import Uti.GestionEncabezadoTabla;
import Uti.ModeloTabla;
import Uti.Utilidades;
import dao.DetalleDocutrazaDao;
import dao.TrackingDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import modelo.Tracking;
import vista.TrackingCafeDocumentos;

/**
 *
 * @author MustainE
 */
public class ControladorTrackingDocumento implements ActionListener, MouseListener, KeyListener {

    TrackingCafeDocumentos vistaCRUD = new TrackingCafeDocumentos();
    TrackingDao modeloCRUD = new TrackingDao();
    ArrayList<Tracking> listaPersonas;
    ModeloTabla modelojt;
    private int filasTabla;
    private int columnasTabla;
    //DecimalFormat df = new DecimalFormat("###,###.##");
    double p = 0;
    double t = 0;
    DecimalFormat df = new DecimalFormat("#,###.00");
    String idempresa;
    String texto;

    public ControladorTrackingDocumento(TrackingCafeDocumentos vistaCRUD, TrackingDao modeloCRUD) {
        this.modeloCRUD = modeloCRUD;
        this.vistaCRUD = vistaCRUD;
        this.vistaCRUD.btnExcel.addActionListener(this);
        this.vistaCRUD.jtSeguimiento.addMouseListener(this);
        this.vistaCRUD.txtBuscador.addKeyListener(this);
    }

    public void InicializarCrud() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaCRUD.btnExcel) {
            DefaultTableModel modelo = new DefaultTableModel();
            vistaCRUD.jtSeguimiento.setModel(modelo);
            JFileChooser examinar = new JFileChooser("D:\\");
            examinar.setFileFilter(new FileNameExtensionFilter("Archivos excel", "xls", "xlsx"));
            int opcion = examinar.showOpenDialog(vistaCRUD.btnExcel);
            File archivoExcel = null;
            if (opcion == JFileChooser.APPROVE_OPTION) {
                archivoExcel = examinar.getSelectedFile().getAbsoluteFile();
                try {
                    Workbook leerExcel = Workbook.getWorkbook(archivoExcel);
                    for (int hoja = 0; hoja < leerExcel.getNumberOfSheets(); hoja++) {
                        Sheet hojaP = leerExcel.getSheet(hoja);
                        int columnas = hojaP.getColumns();
                        int filas = hojaP.getRows();
                        //Object data[] = new Object[columnas];
                        Object data[] = new Object[27];
                        modelo.addColumn("id");
                        modelo.addColumn("Emp");
                        modelo.addColumn("Suc");
                        modelo.addColumn("Cp");
                        modelo.addColumn("Org");
                        modelo.addColumn("C.Pract");
                        modelo.addColumn("CodA.");
                        modelo.addColumn("Apellidos");
                        modelo.addColumn("Nombres");
                        modelo.addColumn("Dni");
                        modelo.addColumn("Finca");
                        modelo.addColumn("Anexo");
                        modelo.addColumn("CP.I");
                        modelo.addColumn("Org.I.");
                        modelo.addColumn("Ft.I.");
                        modelo.addColumn("Rainf.I.");
                        modelo.addColumn("Conv.I.");
                        modelo.addColumn("Cp.A.");
                        modelo.addColumn("Org.A.");
                        modelo.addColumn("Ft.A.");
                        modelo.addColumn("Rainf.A.");
                        modelo.addColumn("Conv.A.");
                        modelo.addColumn("Cp.D.");
                        modelo.addColumn("Org.D.");
                        modelo.addColumn("Ft.D.");
                        modelo.addColumn("Rainf.D.");
                        modelo.addColumn("Conv.D.");
                        for (int fila = 0; fila < filas; fila++) {
                            for (int columna = 0; columna < columnas; columna++) {

                                if (fila >= 1) {

                                    data[0] = hojaP.getCell(0, fila).getContents();
                                    data[1] = hojaP.getCell(1, fila).getContents();
                                    data[2] = hojaP.getCell(2, fila).getContents();
                                    data[3] = hojaP.getCell(3, fila).getContents();
                                    data[4] = hojaP.getCell(4, fila).getContents();
                                    data[5] = hojaP.getCell(5, fila).getContents();
                                    data[6] = hojaP.getCell(6, fila).getContents();
                                    data[7] = hojaP.getCell(7, fila).getContents();
                                    data[8] = hojaP.getCell(8, fila).getContents();
                                    data[9] = hojaP.getCell(9, fila).getContents();
                                    data[10] = hojaP.getCell(10, fila).getContents();
                                    data[11] = hojaP.getCell(11, fila).getContents();
                                    data[12] = hojaP.getCell(12, fila).getContents();
                                    data[13] = hojaP.getCell(13, fila).getContents();
                                    data[14] = hojaP.getCell(14, fila).getContents();
                                    data[15] = hojaP.getCell(15, fila).getContents();
                                    data[16] = hojaP.getCell(16, fila).getContents();
                                    data[17] = hojaP.getCell(17, fila).getContents();
                                    data[18] = hojaP.getCell(18, fila).getContents();
                                    data[19] = hojaP.getCell(19, fila).getContents();
                                    data[20] = hojaP.getCell(20, fila).getContents();
                                    data[21] = hojaP.getCell(21, fila).getContents();
                                    data[22] = hojaP.getCell(22, fila).getContents();
                                    data[23] = hojaP.getCell(23, fila).getContents();
                                    data[24] = hojaP.getCell(24, fila).getContents();
                                    data[25] = hojaP.getCell(25, fila).getContents();
                                    data[26] = hojaP.getCell(26, fila).getContents();
                                }
                            }
                            modelo.addRow(data);
                        }
                    }
                    modelo.removeRow(0);
                    //JOptionPane.showMessageDialog(null, "Archivo excel almacenado es el Worbook" + leerExcel);
                } catch (IOException | BiffException ex) {
//                    Logger.getLogger(ControladorCrud.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Error al almacenar el excel en el workbook");

                }
            }
        }

    }

    public void construirTabla(int idempresa, int idsucursal) {
        listaPersonas = dao.TrackingDao_Documento.listDetalleTrackingDocumento(idempresa, idsucursal);

        ArrayList<String> titulosList = new ArrayList<>();

        titulosList.add("id");
        titulosList.add("Emp");
        titulosList.add("Suc");
        titulosList.add("Cp");
        titulosList.add("Org");
        titulosList.add("C.Pract");
        titulosList.add("CodA.");
        titulosList.add("Apellidos");
        titulosList.add("Nombres");
        titulosList.add("Dni");
        titulosList.add("Finca");
        titulosList.add("Anexo");
        titulosList.add("CP.I");
        titulosList.add("Org.I.");
        titulosList.add("Ft.I.");
        titulosList.add("Rainf.I.");
        titulosList.add("Conv.I.");
        titulosList.add("Cp.A.");
        titulosList.add("Org.A.");
        titulosList.add("Ft.A.");
        titulosList.add("Rainf.A.");
        titulosList.add("Conv.A.");
        titulosList.add("Cp.D.");
        titulosList.add("Org.D.");
        titulosList.add("Ft.D.");
        titulosList.add("Rainf.D.");
        titulosList.add("Conv.D.");

        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }
        Object[][] data = obtenerMatrizDatos(titulosList);
        construirTabla(titulos, data);

        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor9 = vistaCRUD.jtSeguimiento.getValueAt(i, 12).toString().replace(",", "");

                if (isNumeric(valor9) == true) {
                    p = Double.parseDouble(valor9);
                }
                t += p;
            }
            vistaCRUD.lblCPI.setText(df.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor10 = vistaCRUD.jtSeguimiento.getValueAt(i, 13).toString().replace(",", "");

                if (isNumeric(valor10) == true) {
                    p = Double.parseDouble(valor10);
                }
                t += p;
            }
            vistaCRUD.lblORGI.setText(df.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor11 = vistaCRUD.jtSeguimiento.getValueAt(i, 14).toString().replace(",", "");

                if (isNumeric(valor11) == true) {
                    p = Double.parseDouble(valor11);
                }
                t += p;
            }
            vistaCRUD.lblFTI.setText(df.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor12 = vistaCRUD.jtSeguimiento.getValueAt(i, 15).toString().replace(",", "");

                if (isNumeric(valor12) == true) {
                    p = Double.parseDouble(valor12);
                }
                t += p;
            }
            vistaCRUD.lblRAINFI.setText(df.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor13 = vistaCRUD.jtSeguimiento.getValueAt(i, 16).toString().replace(",", "");

                if (isNumeric(valor13) == true) {
                    p = Double.parseDouble(valor13);
                }
                t += p;
            }
            vistaCRUD.lblCONVI.setText(df.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor14 = vistaCRUD.jtSeguimiento.getValueAt(i, 17).toString().replace(",", "");

                if (isNumeric(valor14) == true) {
                    p = Double.parseDouble(valor14);
                }
                t += p;
            }
            vistaCRUD.lblCPA.setText(df.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor15 = vistaCRUD.jtSeguimiento.getValueAt(i, 18).toString().replace(",", "");

                if (isNumeric(valor15) == true) {
                    p = Double.parseDouble(valor15);
                }
                t += p;
            }
            vistaCRUD.lblORGA.setText(df.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor16 = vistaCRUD.jtSeguimiento.getValueAt(i, 19).toString().replace(",", "");

                if (isNumeric(valor16) == true) {
                    p = Double.parseDouble(valor16);
                }
                t += p;
            }
            vistaCRUD.lblFTA.setText(df.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor17 = vistaCRUD.jtSeguimiento.getValueAt(i, 20).toString().replace(",", "");

                if (isNumeric(valor17) == true) {
                    p = Double.parseDouble(valor17);
                }
                t += p;
            }
            vistaCRUD.lblRAINFA.setText(df.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor18 = vistaCRUD.jtSeguimiento.getValueAt(i, 21).toString().replace(",", "");

                if (isNumeric(valor18) == true) {
                    p = Double.parseDouble(valor18);
                }
                t += p;
            }
            vistaCRUD.lblCONVA.setText(df.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor19 = vistaCRUD.jtSeguimiento.getValueAt(i, 22).toString().replace(",", "");

                if (isNumeric(valor19) == true) {
                    p = Double.parseDouble(valor19);
                }
                t += p;
            }
            vistaCRUD.lblCPD.setText(df.format(t) + "");
            vistaCRUD.lblECP.setText(df.format(t) + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor20 = vistaCRUD.jtSeguimiento.getValueAt(i, 23).toString().replace(",", "");

                if (isNumeric(valor20) == true) {
                    p = Double.parseDouble(valor20);
                }
                t += p;
            }
            vistaCRUD.lblORGD.setText(df.format(t) + "");
            vistaCRUD.lblEOrg.setText(df.format(t) + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor21 = vistaCRUD.jtSeguimiento.getValueAt(i, 24).toString().replace(",", "");

                if (isNumeric(valor21) == true) {
                    p = Double.parseDouble(valor21);
                }
                t += p;
            }
            vistaCRUD.lblFTD.setText(df.format(t) + "");
            vistaCRUD.lblEFairTrade.setText(df.format(t) + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor22 = vistaCRUD.jtSeguimiento.getValueAt(i, 25).toString().replace(",", "");

                if (isNumeric(valor22) == true) {
                    p = Double.parseDouble(valor22);
                }
                t += p;
            }
            vistaCRUD.lblRAINFD.setText(df.format(t) + "");
            vistaCRUD.lblERainf.setText(df.format(t) + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor23 = vistaCRUD.jtSeguimiento.getValueAt(i, 26).toString().replace(",", "");

                if (isNumeric(valor23) == true) {
                    p = Double.parseDouble(valor23);
                }
                t += p;
            }
            vistaCRUD.lblCONVD.setText(df.format(t) + "");
            vistaCRUD.lblEConv.setText(df.format(t) + "");
            p = 0;
            t = 0;
        }
    }

    public void construirTablabuscar() {
        //listaPersonas = dao.TrackingDao.listTrackingbuscar(texto);
        ArrayList<String> titulosList = new ArrayList<>();
        titulosList.add("id");
        titulosList.add("Emp");
        titulosList.add("Suc");
        titulosList.add("Cp");
        titulosList.add("Org");
        titulosList.add("C.Pract");
        titulosList.add("CodA.");
        titulosList.add("Apellidos");
        titulosList.add("Nombres");
        titulosList.add("Dni");
        titulosList.add("Finca");
        titulosList.add("Anexo");
        titulosList.add("CP.I");
        titulosList.add("Org.I.");
        titulosList.add("Ft.I.");
        titulosList.add("Rainf.I.");
        titulosList.add("Conv.I.");
        titulosList.add("Cp.A.");
        titulosList.add("Org.A.");
        titulosList.add("Ft.A.");
        titulosList.add("Rainf.A.");
        titulosList.add("Conv.A.");
        titulosList.add("Cp.D.");
        titulosList.add("Org.D.");
        titulosList.add("Ft.D.");
        titulosList.add("Rainf.D.");
        titulosList.add("Conv.D.");

        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }
        Object[][] data = obtenerMatrizDatos(titulosList);
        construirTabla(titulos, data);

//        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
//            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
//                String valor9 = vistaCRUD.jtSeguimiento.getValueAt(i, 11).toString().replace(",", "");
//                //String valor9 = vistaCRUD.jtSeguimiento.getValueAt(i, 9).toString().replace(",", "");
//                
//                if (isNumeric(valor9) == true) {
//                    p = Double.parseDouble(valor9);
//                }
//                t += p;
//            }
//            vistaCRUD.lblCPI.setText(df.format(t).replace(".", ",") + "");
//            p = 0;
//            t = 0;
//        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor10 = vistaCRUD.jtSeguimiento.getValueAt(i, 12).toString().replace(",", "");

                if (isNumeric(valor10) == true) {
                    p = Double.parseDouble(valor10);
                }
                t += p;
            }
            vistaCRUD.lblORGI.setText(df.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor11 = vistaCRUD.jtSeguimiento.getValueAt(i, 13).toString().replace(",", "");

                if (isNumeric(valor11) == true) {
                    p = Double.parseDouble(valor11);
                }
                t += p;
            }
            vistaCRUD.lblFTI.setText(df.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor12 = vistaCRUD.jtSeguimiento.getValueAt(i, 15).toString().replace(",", "");

                if (isNumeric(valor12) == true) {
                    p = Double.parseDouble(valor12);
                }
                t += p;
            }
            vistaCRUD.lblRAINFI.setText(df.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor13 = vistaCRUD.jtSeguimiento.getValueAt(i, 16).toString().replace(",", "");

                if (isNumeric(valor13) == true) {
                    p = Double.parseDouble(valor13);
                }
                t += p;
            }
            vistaCRUD.lblCONVI.setText(df.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor14 = vistaCRUD.jtSeguimiento.getValueAt(i, 17).toString().replace(",", "");

                if (isNumeric(valor14) == true) {
                    p = Double.parseDouble(valor14);
                }
                t += p;
            }
            vistaCRUD.lblCPA.setText(df.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor15 = vistaCRUD.jtSeguimiento.getValueAt(i, 18).toString().replace(",", "");

                if (isNumeric(valor15) == true) {
                    p = Double.parseDouble(valor15);
                }
                t += p;
            }
            vistaCRUD.lblORGA.setText(df.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor16 = vistaCRUD.jtSeguimiento.getValueAt(i, 19).toString().replace(",", "");

                if (isNumeric(valor16) == true) {
                    p = Double.parseDouble(valor16);
                }
                t += p;
            }
            vistaCRUD.lblFTA.setText(df.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor17 = vistaCRUD.jtSeguimiento.getValueAt(i, 20).toString().replace(",", "");

                if (isNumeric(valor17) == true) {
                    p = Double.parseDouble(valor17);
                }
                t += p;
            }
            vistaCRUD.lblRAINFA.setText(df.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor18 = vistaCRUD.jtSeguimiento.getValueAt(i, 21).toString().replace(",", "");

                if (isNumeric(valor18) == true) {
                    p = Double.parseDouble(valor18);
                }
                t += p;
            }
            vistaCRUD.lblCONVA.setText(df.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor19 = vistaCRUD.jtSeguimiento.getValueAt(i, 22).toString().replace(",", "");

                if (isNumeric(valor19) == true) {
                    p = Double.parseDouble(valor19);
                }
                t += p;
            }
            vistaCRUD.lblCPD.setText(df.format(t) + "");
            vistaCRUD.lblECP.setText(df.format(t) + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor20 = vistaCRUD.jtSeguimiento.getValueAt(i, 23).toString().replace(",", "");

                if (isNumeric(valor20) == true) {
                    p = Double.parseDouble(valor20);
                }
                t += p;
            }
            vistaCRUD.lblORGD.setText(df.format(t) + "");
            vistaCRUD.lblEOrg.setText(df.format(t) + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor21 = vistaCRUD.jtSeguimiento.getValueAt(i, 24).toString().replace(",", "");

                if (isNumeric(valor21) == true) {
                    p = Double.parseDouble(valor21);
                }
                t += p;
            }
            vistaCRUD.lblFTD.setText(df.format(t) + "");
            vistaCRUD.lblEFairTrade.setText(df.format(t) + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor22 = vistaCRUD.jtSeguimiento.getValueAt(i, 25).toString().replace(",", "");

                if (isNumeric(valor22) == true) {
                    p = Double.parseDouble(valor22);
                }
                t += p;
            }
            vistaCRUD.lblRAINFD.setText(df.format(t) + "");
            vistaCRUD.lblERainf.setText(df.format(t) + "");

            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor23 = vistaCRUD.jtSeguimiento.getValueAt(i, 26).toString().replace(",", "");

                if (isNumeric(valor23) == true) {
                    p = Double.parseDouble(valor23);
                }
                t += p;
            }
            vistaCRUD.lblCONVD.setText(df.format(t) + "");
            vistaCRUD.lblEConv.setText(df.format(t) + "");

            p = 0;
            t = 0;
        }
    }

    private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {

        String informacion[][] = new String[listaPersonas.size()][titulosList.size()];

        for (int x = 0; x < informacion.length; x++) {

            informacion[x][Utilidades.idlpaestimado] = listaPersonas.get(x).getIdlpaestimado() + "";
            informacion[x][Utilidades.idempresa] = listaPersonas.get(x).getIdempresa() + "";
            informacion[x][Utilidades.idsucursal] = listaPersonas.get(x).getIdsucursal() + "";
            informacion[x][Utilidades.idcp] = listaPersonas.get(x).getIdcp() + "";
            informacion[x][Utilidades.idorga] = listaPersonas.get(x).getIdorga() + "";
            informacion[x][Utilidades.idcafepractice] = listaPersonas.get(x).getIdcafepractice() + "";
            informacion[x][Utilidades.codagricultor] = listaPersonas.get(x).getCodagricultor() + "";
            informacion[x][Utilidades.apellidos] = listaPersonas.get(x).getApellidos() + "";
            informacion[x][Utilidades.nombres] = listaPersonas.get(x).getNombres() + "";
            informacion[x][Utilidades.dni] = listaPersonas.get(x).getDni() + "";
            informacion[x][Utilidades.nomfinca] = listaPersonas.get(x).getNomfinca() + "";
            informacion[x][Utilidades.nomanexo] = listaPersonas.get(x).getNomanexo() + "";
            informacion[x][Utilidades.cpinicial] = listaPersonas.get(x).getCpinicial() + "";
            informacion[x][Utilidades.orginicial] = listaPersonas.get(x).getOrginicial() + "";
            informacion[x][Utilidades.ftinicial] = listaPersonas.get(x).getFtinicial() + "";
            informacion[x][Utilidades.rainfinicial] = listaPersonas.get(x).getRainfinicial() + "";
            informacion[x][Utilidades.convinicial] = listaPersonas.get(x).getConvinicial() + "";
            informacion[x][Utilidades.cpavance] = listaPersonas.get(x).getCpavanc() + "";
            informacion[x][Utilidades.orgavance] = listaPersonas.get(x).getOrgavanc() + "";
            informacion[x][Utilidades.ftavance] = listaPersonas.get(x).getFtavanc() + "";
            informacion[x][Utilidades.rainfavance] = listaPersonas.get(x).getRainfavanc() + "";
            informacion[x][Utilidades.convavance] = listaPersonas.get(x).getConviavanc() + "";
            informacion[x][Utilidades.cpdisponible] = listaPersonas.get(x).getCpdisp() + "";
            informacion[x][Utilidades.orgdisponible] = listaPersonas.get(x).getOrgdisp() + "";
            informacion[x][Utilidades.ftdisponible] = listaPersonas.get(x).getFtdisp() + "";
            informacion[x][Utilidades.rainfdisponible] = listaPersonas.get(x).getRainfdisp() + "";
            informacion[x][Utilidades.convdisponible] = listaPersonas.get(x).getConvidisp() + "";

            System.out.println(listaPersonas.get(x).getConvidisp() + "");

        }

        return informacion;
    }

    private void construirTabla(String[] titulos, Object[][] data) {
        modelojt = new ModeloTabla(data, titulos);
        vistaCRUD.jtSeguimiento.setModel(modelojt);

        filasTabla = vistaCRUD.jtSeguimiento.getRowCount();
        columnasTabla = vistaCRUD.jtSeguimiento.getColumnCount();

        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.cpinicial).setCellRenderer(new GestionCeldas("numericop"));
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.orginicial).setCellRenderer(new GestionCeldas("numericop"));
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.ftinicial).setCellRenderer(new GestionCeldas("numericop"));
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.rainfinicial).setCellRenderer(new GestionCeldas("numericop"));
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.convinicial).setCellRenderer(new GestionCeldas("numericop"));
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.cpavance).setCellRenderer(new GestionCeldas("numerico1"));
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.orgavance).setCellRenderer(new GestionCeldas("numerico1"));
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.ftavance).setCellRenderer(new GestionCeldas("numerico1"));
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.rainfavance).setCellRenderer(new GestionCeldas("numerico1"));
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.convavance).setCellRenderer(new GestionCeldas("numerico1"));
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.cpdisponible).setCellRenderer(new GestionCeldas("numerico2"));
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.orgdisponible).setCellRenderer(new GestionCeldas("numerico2"));
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.ftdisponible).setCellRenderer(new GestionCeldas("numerico2"));
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.rainfdisponible).setCellRenderer(new GestionCeldas("numerico2"));
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.convdisponible).setCellRenderer(new GestionCeldas("numerico2"));

        //se recorre y asigna el resto de celdas que serian las que almacenen datos de tipo texto
        for (int i = 0; i < titulos.length - 15; i++) {//se resta 7 porque las ultimas 7 columnas se definen arriba
            vistaCRUD.jtSeguimiento.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("texto"));
        }

        vistaCRUD.jtSeguimiento.getTableHeader().setReorderingAllowed(false);
        vistaCRUD.jtSeguimiento.setRowHeight(25);//tamaño de las celdas
        vistaCRUD.jtSeguimiento.setGridColor(new java.awt.Color(0, 0, 0));
        //Se define el tamaño de largo para cada columna y su contenido
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.idlpaestimado).setPreferredWidth(40);//nombre
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.idempresa).setPreferredWidth(60);//telefono
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.idsucursal).setPreferredWidth(60);//profesion
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.idcp).setPreferredWidth(70);//edad
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.idorga).setPreferredWidth(70);//nota1
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.idcafepractice).setPreferredWidth(70);//nota2
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.codagricultor).setPreferredWidth(50);//nota3
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.apellidos).setPreferredWidth(50);//nota3
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.nombres).setPreferredWidth(50);//nota3
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.nomfinca).setPreferredWidth(60);//promedio
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.nomanexo).setPreferredWidth(70);//accion perfil
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.cpinicial).setPreferredWidth(60);//accion evento
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.orginicial).setPreferredWidth(60);//accion evento
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.ftinicial).setPreferredWidth(60);//accion evento
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.rainfinicial).setPreferredWidth(60);//accion evento
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.convinicial).setPreferredWidth(60);//accion evento
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.cpavance).setPreferredWidth(60);//accion evento
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.orgavance).setPreferredWidth(60);//accion evento
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.ftavance).setPreferredWidth(60);//accion evento
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.rainfavance).setPreferredWidth(60);//accion evento
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.convavance).setPreferredWidth(60);//accion evento
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.cpdisponible).setPreferredWidth(60);//accion evento
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.orgdisponible).setPreferredWidth(60);//accion evento
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.ftdisponible).setPreferredWidth(60);//accion evento
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.rainfdisponible).setPreferredWidth(60);//accion evento
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.convdisponible).setPreferredWidth(60);//accion evento

        //personaliza el encabezado
        JTableHeader jtableHeader = vistaCRUD.jtSeguimiento.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        vistaCRUD.jtSeguimiento.setTableHeader(jtableHeader);

        //se asigna la tabla al scrollPane
//     scrollPaneTabla.setViewportView(vistaCRUD.jtSeguimiento);
    }

//
// Este metodo simularia el proceso o la acción que se quiere realizar si 
// se presiona alguno de los botones o iconos de la tabla
// @param fila
//
    private void validarSeleccionMouse(int fila) {
        Utilidades.filaSeleccionada = fila;

        //teniendo la fila entonces se obtiene el objeto correspondiente para enviarse como parammetro o imprimir la información
        Tracking miPersona = new Tracking();
        miPersona.setIdlpaestimado(Integer.valueOf(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.idlpaestimado).toString()));
        miPersona.setIdempresa(Integer.valueOf(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.idempresa).toString()));
        miPersona.setIdsucursal(Integer.valueOf(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.idsucursal).toString()));
        miPersona.setIdcp(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.idcp).toString());
        miPersona.setIdorga(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.idorga).toString());
        miPersona.setIdcafepractice(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.idcafepractice).toString());
        miPersona.setCodagricultor(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.codagricultor).toString());
        miPersona.setApellidos(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.apellidos).toString());
        miPersona.setNombres(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.nombres).toString());
        miPersona.setDni(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.dni).toString());
        miPersona.setNomfinca(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.nomfinca).toString());
        miPersona.setNomanexo(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.nomanexo).toString());
        miPersona.setCpinicial(Double.valueOf(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.cpinicial).toString()));
        miPersona.setOrginicial(Double.valueOf(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.orginicial).toString()));
        miPersona.setFtinicial(Double.valueOf(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.ftinicial).toString()));
        miPersona.setRainfinicial(Double.valueOf(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.rainfinicial).toString()));
        miPersona.setConvinicial(Double.valueOf(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.convinicial).toString()));
        miPersona.setCpavanc(Double.valueOf(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.cpavance).toString()));
        miPersona.setOrgavanc(Double.valueOf(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.orgavance).toString()));
        miPersona.setFtavanc(Double.valueOf(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.ftavance).toString()));
        miPersona.setRainfavanc(Double.valueOf(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.rainfavance).toString()));
        miPersona.setConviavanc(Double.valueOf(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.convavance).toString()));
        miPersona.setCpdisp(Double.valueOf(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.cpdisponible).toString()));
        miPersona.setOrgdisp(Double.valueOf(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.orgdisponible).toString()));
        miPersona.setFtdisp(Double.valueOf(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.ftdisponible).toString()));
        miPersona.setRainfdisp(Double.valueOf(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.rainfdisponible).toString()));
        miPersona.setConvidisp(Double.valueOf(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.convdisponible).toString()));

        String info = "INFO PERSONA\n";
        info += "Id: " + miPersona.getIdlpaestimado() + "\n";
        info += "Empresa: " + miPersona.getIdempresa() + "\n";
        info += "Sucursal: " + miPersona.getIdsucursal() + "\n";
        info += "Cp: " + miPersona.getIdcp() + "\n";
        info += "Orga: " + miPersona.getIdorga() + "\n";
        info += "Fairtrade: " + miPersona.getIdcafepractice() + "\n";
        info += "Codigo: " + miPersona.getCodagricultor() + "\n";
        info += "Apellidos: " + miPersona.getApellidos() + "\n";
        info += "Nombres: " + miPersona.getNombres() + "\n";
        info += "Dni: " + miPersona.getDni() + "\n";
        info += "Finca: " + miPersona.getNomfinca() + "\n";
        info += "Anexo: " + miPersona.getNomanexo() + "\n";
        info += "Cp Inicial: " + miPersona.getCpinicial() + "\n";
        info += "Orga Inicial: " + miPersona.getOrginicial() + "\n";
        info += "Ft Inicial: " + miPersona.getFtinicial() + "\n";
        info += "Rainforest Inicial: " + miPersona.getRainfinicial() + "\n";
        info += "Convecional Inicial: " + miPersona.getConvinicial() + "\n";

        JOptionPane.showMessageDialog(null, info);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (me.getSource() == vistaCRUD.jtSeguimiento) {
            //capturo fila o columna dependiendo de mi necesidad
            if (me.getClickCount() > 1) {
                int fila = vistaCRUD.jtSeguimiento.rowAtPoint(me.getPoint());
                int columna = vistaCRUD.jtSeguimiento.columnAtPoint(me.getPoint());

                validarSeleccionMouse(fila);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (ke.getSource() == vistaCRUD.txtBuscador) {
            try {
                texto = vistaCRUD.txtBuscador.getText();
                construirTablabuscar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "NO SE ENCUENTRA EL REGISTRO");
            }
        }
    }

}
