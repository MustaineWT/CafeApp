/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Uti.GestionCeldas;
import Uti.GestionEncabezadoTabla;
import Uti.ModeloTabla;
import Uti.UtilidadApC;
import Uti.UtilidadConformacion;
import static Uti.UtilidadesExtras.reiniciarJTable;
import dao.AperturaContratoDao;
import dao.ConformacionDao;
import dao.DetalleDocutrazaDao;
import dao.ListaCombosDao;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import modelo.AperturaContrato;
import dao.DetalleDocutrazaDao;
import dao.DocutrazaDao;
import dao.PerBuscadorDao;
import modelo.Conformacion;
import modelo.DetalleDocutraza;
import modelo.ListaAgricultores;
import modelo.ListaCombos;
import vista.RAgriEstimado;
import vista.RDocutraza_Document;
import vista.RPEstimado;
import vista.RProBuscador;
import vista.TraIni;
import static vista.TraIni.dskPrincipal;

/**
 *
 * @author MustainE
 */
public class ControladorCrudDetalleDocutraza implements ActionListener, MouseListener, KeyListener {

    RAgriEstimado vistaCRUD = new RAgriEstimado();
    DetalleDocutrazaDao modeloCRUD = new DetalleDocutrazaDao();
    ArrayList<AperturaContrato> listaAperturaContrato;
    ArrayList<AperturaContrato> idNuevoAperturaContrato;
    ArrayList<DetalleDocutraza> ListaConformacion;
    int idempresa;
    int idsucursal;
    ModeloTabla modelojt;
    private int filasTabla;
    private int columnasTabla;
    DecimalFormat formatea = new DecimalFormat("###,###.##");
    String texto;

    public ControladorCrudDetalleDocutraza(RAgriEstimado vistaCRUD, DetalleDocutrazaDao modeloCRUD) {
        this.modeloCRUD = modeloCRUD;
        this.vistaCRUD = vistaCRUD;
        this.vistaCRUD.btnImportar.addActionListener(this);
        this.vistaCRUD.btnRefresh.addActionListener(this);
        this.vistaCRUD.btnEditar.addActionListener(this);
        this.vistaCRUD.btnProcesar.addActionListener(this);
        this.vistaCRUD.btnRegistrar.addActionListener(this);
        this.vistaCRUD.btnExcel.addActionListener(this);
        this.vistaCRUD.jtListProveedores.addMouseListener(this);
    }

    public void InicializarCrud() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        idempresa = Integer.valueOf(TraIni.lblEmpresa.getText());
        idsucursal = Integer.valueOf(TraIni.lblSucursal.getText());

        if (e.getSource() == vistaCRUD.btnRefresh) {
            reiniciarJTable(vistaCRUD.jtListProveedores);
            int iddocutraza = Integer.valueOf(vistaCRUD.txtIdDocutraza.getText());
            construirTablaListConfor(idempresa, idsucursal,iddocutraza);  
        }
        if (e.getSource() == vistaCRUD.btnEditar) {
            int filaseleccionada;
            try {
                filaseleccionada = vistaCRUD.jtListProveedores.getSelectedRow();
                if (filaseleccionada == -1) {
                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
                } else {
                    

                    DefaultTableModel modelotabla = (DefaultTableModel) vistaCRUD.jtListProveedores.getModel();
                    String id = (String) modelotabla.getValueAt(filaseleccionada, 0);

                    int iddetalledocutraza = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIddetalledocutraza();
                    int empresa = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIdempresa();
                    int sucursal = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIdsucursal();
                    int iddocutraza = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIddocutraza();
                    int idcompracontrato = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIdcompracontrato();
                    String serieguia = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getSeriguia();
                    String correlativo = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getCorrelativo();
                    String certificado = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getCertificado();
                    int idlpaest = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIdlpaest();
                    int idlpacon = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIdlpacon();
                    int idpersona = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIdpersona();
                    String idorga = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIdorga();
                    String idcp = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIdcp();
                    String codagricultor = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getCodagricultor();
                    String nombresagri = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getNombresagri();
                    String nombresaest = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getNombresaest();
                    String nombresacont = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getNombresacont();
                    String dniruc = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getDniruc();
                    float cpdisp = (float) DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getCpdisp();
                    float orgdisp = (float) DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getOrgdisp();
                    float ftdisp = (float) DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getFtdisp();
                    float rainfdisp = (float) DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getRainfdisp();
                    float convdisp =(float)  DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getConvdisp();
                    int sacos = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getSacos();
                    float kb = (float) DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getKb();
                    float tara = (float) DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getTara();
                    float kn = (float) DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getKn();
                    float precio = (float) DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getPrecio();
                    float importetotal = (float) DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getImportetotal();
                    String guia = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getGuia();
                    String liqcompra = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getLiqcompra();
                    String fecha = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getFecha();
                    String estado = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getEstado();

                    RPEstimado ventana1 = new RPEstimado();
                    ConformacionDao modeloC = new ConformacionDao();
                    RProBuscador vistaCRUD = new RProBuscador();
                    PerBuscadorDao modeloCRUD = new PerBuscadorDao();
                    ControladorCrudConformacion controlaC = new ControladorCrudConformacion(ventana1, modeloC,vistaCRUD,modeloCRUD);
                    
                    controlaC.vistaCRUD.txtIdDetDoc.setText(String.valueOf(iddetalledocutraza));
                    controlaC.vistaCRUD.txtIdEmp.setText(String.valueOf(empresa));
                    controlaC.vistaCRUD.txtIdSuc.setText(String.valueOf(sucursal));
                    controlaC.vistaCRUD.txtIdDocT.setText(String.valueOf(iddocutraza));
                    controlaC.vistaCRUD.txtIdCC.setText(String.valueOf(idcompracontrato));
                    controlaC.vistaCRUD.txtSerieGuia.setText(serieguia);
                    controlaC.vistaCRUD.txtCorrelativo.setText(correlativo);
                    controlaC.vistaCRUD.txtCertificado.setText(certificado);
                    controlaC.vistaCRUD.txtIdPerLPAEst.setText(String.valueOf(idlpaest));
                    controlaC.vistaCRUD.txtIdProLPACon.setText(String.valueOf(idlpacon));
                    controlaC.vistaCRUD.txtIdPersona.setText(String.valueOf(idpersona));
                    controlaC.vistaCRUD.txtIdOrgaPro.setText(idorga);
                    controlaC.vistaCRUD.txtIdCpPro.setText(idcp);
                    controlaC.vistaCRUD.txtCodPro.setText(codagricultor);
                    controlaC.vistaCRUD.txtNomPro.setText(nombresagri);
                    controlaC.vistaCRUD.txtNomLPAEst.setText(nombresaest);
                    controlaC.vistaCRUD.txtNomLPACon.setText(nombresacont);
                    controlaC.vistaCRUD.txtDniRuc.setText(dniruc);
                    controlaC.vistaCRUD.txtCPDisp.setText(String.valueOf(cpdisp));
                    controlaC.vistaCRUD.txtORGDisp.setText(String.valueOf(orgdisp));
                    controlaC.vistaCRUD.txtFTDisp.setText(String.valueOf(ftdisp));
                    controlaC.vistaCRUD.txtRainfDisp.setText(String.valueOf(rainfdisp));
                    controlaC.vistaCRUD.txtConvDisp.setText(String.valueOf(convdisp));
                    controlaC.vistaCRUD.txtSacos.setText(String.valueOf(sacos));                    
                    controlaC.vistaCRUD.txtKb.setText(String.valueOf(kb));
                    controlaC.vistaCRUD.txtTara.setText(String.valueOf(tara));
                    controlaC.vistaCRUD.txtKN.setText(String.valueOf(kn));
                    controlaC.vistaCRUD.txtPrecio.setText(String.valueOf(precio));
                    controlaC.vistaCRUD.txtImpTotal.setText(String.valueOf(importetotal));
                    controlaC.vistaCRUD.txtGuia.setText(guia);
                    controlaC.vistaCRUD.txtLiqCompra.setText(liqcompra);
                    controlaC.vistaCRUD.txtFecha.setDate(Date.valueOf(fecha));
                    if (estado.equals("A")) {
                        controlaC.vistaCRUD.jcbEstado.setSelectedIndex(0);
                    } else {
                        controlaC.vistaCRUD.jcbEstado.setSelectedIndex(1);
                    }
                    dskPrincipal.add(ventana1);
                    ventana1.setVisible(true);
                }
            } catch (HeadlessException ex) {

                JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente", " .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);

            }
        }

        if (e.getSource() == vistaCRUD.btnRegistrar) {
            if (vistaCRUD.jtListProveedores.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Debe Ingresar datos en la tabla.");
            } else {
                String rptaRegistrodetalle="";
                for (int i = 0; i < vistaCRUD.jtListProveedores.getRowCount(); i++) {
                    int iddetalledocutraza = 0;
                    int iddocutraza = Integer.valueOf(vistaCRUD.txtIdDocutraza.getText().toString());
                    int idlpaestimado = Integer.valueOf(vistaCRUD.jtListProveedores.getValueAt(i, 3).toString());
                    int idlpacontable = Integer.valueOf(vistaCRUD.jtListProveedores.getValueAt(i, 3).toString());
                    int idpersona = Integer.valueOf(vistaCRUD.jtListProveedores.getValueAt(i, 3).toString());
                    int sacos = Integer.valueOf(vistaCRUD.jtListProveedores.getValueAt(i, 8).toString());
                    double kb = Double.valueOf(vistaCRUD.jtListProveedores.getValueAt(i, 9).toString().replace(".", "").replace(",", "."));
                    double tara = Double.valueOf(vistaCRUD.jtListProveedores.getValueAt(i, 10).toString().replace(".", "").replace(",", "."));
                    double kn = Double.valueOf(vistaCRUD.jtListProveedores.getValueAt(i, 11).toString().replace(".", "").replace(",", "."));
                    double precio = Double.valueOf(vistaCRUD.jtListProveedores.getValueAt(i, 12).toString().replace(".", "").replace(",", "."));
                    double importetotal = Double.valueOf(vistaCRUD.jtListProveedores.getValueAt(i, 13).toString().replace(".", "").replace(",", "."));
                    String guia = vistaCRUD.jtListProveedores.getValueAt(i, 14).toString();
                    String liqcompra = vistaCRUD.jtListProveedores.getValueAt(i, 15).toString();
                    String fecha = vistaCRUD.jtListProveedores.getValueAt(i, 16).toString();
                    String estado = "A";

                    rptaRegistrodetalle = modeloCRUD.insertDetalleDocutraza(iddetalledocutraza, iddocutraza,
                            idlpaestimado, idlpacontable, idpersona, sacos, kb, tara, kn, precio, importetotal, guia, liqcompra, fecha, estado);                    
                }
                if (rptaRegistrodetalle != null) {                        
                        vistaCRUD.dispose();
                        RDocutraza_Document ventana2 = new RDocutraza_Document();
                        DocutrazaDao modeloC2 = new DocutrazaDao();
                        ControladorCrudDocutraza controlaC = new ControladorCrudDocutraza(ventana2, modeloC2);
                        controlaC.vistaCRUD.btnAsigCon.setEnabled(false);
                    }

            }
        }

        if (e.getSource() == vistaCRUD.btnImportar) {
            DefaultTableModel modelo = new DefaultTableModel();
            vistaCRUD.jtListProveedores.setModel(modelo);
            JFileChooser examinar = new JFileChooser("D:\\");
            examinar.setFileFilter(new FileNameExtensionFilter("Archivos excel", "xls", "xlsx"));
            int opcion = examinar.showOpenDialog(vistaCRUD.btnImportar);
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
                        Object data[] = new Object[17];
                        modelo.addColumn("IdCp");
                        modelo.addColumn("IdOrga");
                        modelo.addColumn("CodAgri");
                        modelo.addColumn("Idp");
                        modelo.addColumn("Apellidos");
                        modelo.addColumn("Nombres");
                        modelo.addColumn("DniRuc");
                        modelo.addColumn("NomAnexo");
                        modelo.addColumn("Saco");
                        modelo.addColumn("Kb");
                        modelo.addColumn("Tara");
                        modelo.addColumn("Kn");
                        modelo.addColumn("Precio");
                        modelo.addColumn("Importe");
                        modelo.addColumn("Guia");
                        modelo.addColumn("LiqComp.");
                        modelo.addColumn("Fecha");                        
                        for (int fila = 0; fila < filas; fila++) {
                            for (int columna = 0; columna < columnas; columna++) {

                                if (fila >= 1) {                                    
                                    data[0] = hojaP.getCell(0, fila).getContents();
                                    data[1] = hojaP.getCell(1, fila).getContents();
                                    data[2] = hojaP.getCell(2, fila).getContents();                               
                                    data[3] = DetalleDocutrazaDao.listIdPersona(idempresa, hojaP.getCell(2, fila).getContents()).get(0).getIdpersona();                                   
                                    data[4] = hojaP.getCell(3, fila).getContents();
                                    data[5] = hojaP.getCell(4, fila).getContents();
                                    data[6] = hojaP.getCell(5, fila).getContents();
                                    data[7] = hojaP.getCell(6, fila).getContents();
                                    data[8] = hojaP.getCell(7, fila).getContents();
                                    data[9] = hojaP.getCell(8, fila).getContents();
                                    data[10] = hojaP.getCell(9, fila).getContents();
                                    data[11] = hojaP.getCell(10, fila).getContents();
                                    data[12] = hojaP.getCell(11, fila).getContents();
                                    data[13] = hojaP.getCell(12, fila).getContents();
                                    data[14] = hojaP.getCell(13, fila).getContents();
                                    data[15] = hojaP.getCell(14, fila).getContents();
                                    data[16] = hojaP.getCell(15, fila).getContents();
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
    
    
        public void construirTablaListConfor(int empresa, int sucursal, int dct) {

        ListaConformacion = dao.DetalleDocutrazaDao.listDetalleDocutraza(empresa, sucursal, dct);

        ArrayList<String> titulosList = new ArrayList<>();

        titulosList.add("Id");
        titulosList.add("IdCp");
        titulosList.add("IdOrga");
        titulosList.add("CodAgritulor");
        titulosList.add("IdPersona");
        titulosList.add("Apellidos");
        titulosList.add("Nombres");
        titulosList.add("Dni");
        titulosList.add("Anexo");
        titulosList.add("Sacos");
        titulosList.add("Kb");
        titulosList.add("Tara");
        titulosList.add("Kn");
        titulosList.add("Precio");
        titulosList.add("Importe");
        titulosList.add("Guia");
        titulosList.add("LiqCompra");
        titulosList.add("Fecha");
        titulosList.add("Estado");

        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }
        Object[][] data = obtenerMatrizDatosListConfor(titulosList);
        construirTablaListConfor(titulos, data);
    }

    public void construirTablabuscarListConfor(int empresa, int sucursal, String texto) {

        //ListaConformacion = dao.DetalleDocutrazaDao.listDetalleDocutraza(empresa, sucursal, texto);

        ArrayList<String> titulosList = new ArrayList<>();

        titulosList.add("Id");
        titulosList.add("IdCp");
        titulosList.add("IdOrga");
        titulosList.add("CodAgritulor");
        titulosList.add("IdPersona");
        titulosList.add("Apellidos");
        titulosList.add("Nombres");
        titulosList.add("Dni");
        titulosList.add("Anexo");
        titulosList.add("Sacos");
        titulosList.add("Kb");
        titulosList.add("Tara");
        titulosList.add("Kn");
        titulosList.add("Precio");
        titulosList.add("Importe");
        titulosList.add("Guia");
        titulosList.add("LiqCompra");
        titulosList.add("Fecha");
        titulosList.add("Estado");

        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }

        Object[][] data = obtenerMatrizDatosListConfor(titulosList);
        construirTablaListConfor(titulos, data);
    }

    private Object[][] obtenerMatrizDatosListConfor(ArrayList<String> titulosList) {

        String informacion[][] = new String[ListaConformacion.size()][titulosList.size()];

        for (int x = 0; x < informacion.length; x++) {

            informacion[x][UtilidadConformacion.iddetalledocutraza] = ListaConformacion.get(x).getIddetalledocutraza()+ "";
            informacion[x][UtilidadConformacion.idcp] = ListaConformacion.get(x).getIdcp()+ "";
            informacion[x][UtilidadConformacion.idorga] = ListaConformacion.get(x).getIdorga()+ "";
            informacion[x][UtilidadConformacion.codagricultor] = ListaConformacion.get(x).getCodagricultor()+ "";
            informacion[x][UtilidadConformacion.idpersona] = ListaConformacion.get(x).getIdpersona()+ "";
            informacion[x][UtilidadConformacion.apellidos] = ListaConformacion.get(x).getApellidos()+ "";
            informacion[x][UtilidadConformacion.nombres] = ListaConformacion.get(x).getNombres() + "";
            informacion[x][UtilidadConformacion.dniruc] = ListaConformacion.get(x).getDni() + "";
            informacion[x][UtilidadConformacion.nomanexo] = ListaConformacion.get(x).getAnexo() + "";
            informacion[x][UtilidadConformacion.sacos] = ListaConformacion.get(x).getSacos() + "";
            informacion[x][UtilidadConformacion.kb] = ListaConformacion.get(x).getKb() + "";
            informacion[x][UtilidadConformacion.tara] = ListaConformacion.get(x).getTara() + "";
            informacion[x][UtilidadConformacion.kn] = ListaConformacion.get(x).getKn() + "";
            informacion[x][UtilidadConformacion.precio] = ListaConformacion.get(x).getPrecio() + "";
            informacion[x][UtilidadConformacion.importetotal] = ListaConformacion.get(x).getImportetotal() + "";
            informacion[x][UtilidadConformacion.guia] = ListaConformacion.get(x).getGuia() + "";
            informacion[x][UtilidadConformacion.liqcompra] = ListaConformacion.get(x).getLiqcompra() + "";
            informacion[x][UtilidadConformacion.fecha] = ListaConformacion.get(x).getFecha() + "";
            informacion[x][UtilidadConformacion.estado] = ListaConformacion.get(x).getEstado() + "";
        }
        return informacion;
    }

    private void construirTablaListConfor(String[] titulos, Object[][] data) {
        modelojt = new ModeloTabla(data, titulos);
        //se asigna el modelo a la tabla
        vistaCRUD.jtListProveedores.setModel(modelojt);

        filasTabla = vistaCRUD.jtListProveedores.getRowCount();
        columnasTabla = vistaCRUD.jtListProveedores.getColumnCount();
        
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(UtilidadConformacion.sacos).setCellRenderer(new GestionCeldas("numerico"));
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(UtilidadConformacion.kb).setCellRenderer(new GestionCeldas("numerico"));
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(UtilidadConformacion.tara).setCellRenderer(new GestionCeldas("numerico"));
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(UtilidadConformacion.kn).setCellRenderer(new GestionCeldas("numerico"));
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(UtilidadConformacion.precio).setCellRenderer(new GestionCeldas("numerico"));
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(UtilidadConformacion.importetotal).setCellRenderer(new GestionCeldas("numerico"));

        vistaCRUD.jtListProveedores.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(3).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(4).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(5).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(6).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(7).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(8).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(15).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(16).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(17).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(18).setCellRenderer(new GestionCeldas("texto"));

        vistaCRUD.jtListProveedores.getTableHeader().setReorderingAllowed(false);
        vistaCRUD.jtListProveedores.setRowHeight(25);
        vistaCRUD.jtListProveedores.setGridColor(new java.awt.Color(0, 0, 0));

        vistaCRUD.jtListProveedores.getColumnModel().getColumn(UtilidadConformacion.iddetalledocutraza).setPreferredWidth(40);
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(UtilidadConformacion.idcp).setPreferredWidth(40);
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(UtilidadConformacion.idorga).setPreferredWidth(40);
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(UtilidadConformacion.codagricultor).setPreferredWidth(60);
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(UtilidadConformacion.idpersona).setPreferredWidth(60);
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(UtilidadConformacion.apellidos).setPreferredWidth(60);
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(UtilidadConformacion.nombres).setPreferredWidth(50);
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(UtilidadConformacion.dniruc).setPreferredWidth(70);
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(UtilidadConformacion.nomanexo).setPreferredWidth(60);
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(UtilidadConformacion.sacos).setPreferredWidth(60);
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(UtilidadConformacion.kb).setPreferredWidth(60);
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(UtilidadConformacion.tara).setPreferredWidth(60);
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(UtilidadConformacion.kn).setPreferredWidth(60);
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(UtilidadConformacion.precio).setPreferredWidth(60);
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(UtilidadConformacion.importetotal).setPreferredWidth(60);
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(UtilidadConformacion.guia).setPreferredWidth(60);
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(UtilidadConformacion.liqcompra).setPreferredWidth(60);
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(UtilidadConformacion.fecha).setPreferredWidth(60);
        vistaCRUD.jtListProveedores.getColumnModel().getColumn(UtilidadConformacion.estado).setPreferredWidth(60);

        JTableHeader jtableHeader = vistaCRUD.jtListProveedores.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        vistaCRUD.jtListProveedores.setTableHeader(jtableHeader);

        vistaCRUD.jScrollPane1.setViewportView(vistaCRUD.jtListProveedores);
    }
    
    private void validarSeleccionMouseListConfor(int fila) {
        UtilidadConformacion.filaSeleccionada = fila;

        //teniendo la fila entonces se obtiene el objeto correspondiente para enviarse como parammetro o imprimir la información
        DetalleDocutraza CC = new DetalleDocutraza();
        CC.setIddetalledocutraza(Integer.valueOf(vistaCRUD.jtListProveedores.getValueAt(fila, UtilidadConformacion.iddetalledocutraza).toString()));
        CC.setIdcp(vistaCRUD.jtListProveedores.getValueAt(fila, UtilidadConformacion.idcp).toString());
        CC.setIdorga(vistaCRUD.jtListProveedores.getValueAt(fila, UtilidadConformacion.idorga).toString());
        CC.setCodagricultor(vistaCRUD.jtListProveedores.getValueAt(fila, UtilidadConformacion.codagricultor).toString());
        CC.setIdpersona(Integer.valueOf(vistaCRUD.jtListProveedores.getValueAt(fila, UtilidadConformacion.idpersona).toString()));
        CC.setApellidos(vistaCRUD.jtListProveedores.getValueAt(fila, UtilidadConformacion.apellidos).toString());
        CC.setNombres(vistaCRUD.jtListProveedores.getValueAt(fila, UtilidadConformacion.nombres).toString());
        CC.setDni(vistaCRUD.jtListProveedores.getValueAt(fila, UtilidadConformacion.dniruc).toString());
        CC.setAnexo(vistaCRUD.jtListProveedores.getValueAt(fila, UtilidadConformacion.nomanexo).toString());
        CC.setSacos(Integer.valueOf(vistaCRUD.jtListProveedores.getValueAt(fila, UtilidadConformacion.sacos).toString()));
        CC.setKb(Double.valueOf(vistaCRUD.jtListProveedores.getValueAt(fila, UtilidadConformacion.kb).toString()));
        CC.setTara(Double.valueOf(vistaCRUD.jtListProveedores.getValueAt(fila, UtilidadConformacion.tara).toString()));
        CC.setKn(Double.valueOf(vistaCRUD.jtListProveedores.getValueAt(fila, UtilidadConformacion.kn).toString()));
        CC.setPrecio(Double.valueOf(vistaCRUD.jtListProveedores.getValueAt(fila, UtilidadConformacion.precio).toString()));
        CC.setImportetotal(Double.valueOf(vistaCRUD.jtListProveedores.getValueAt(fila, UtilidadConformacion.importetotal).toString()));
        CC.setGuia(vistaCRUD.jtListProveedores.getValueAt(fila, UtilidadConformacion.guia).toString());
        CC.setLiqcompra(vistaCRUD.jtListProveedores.getValueAt(fila, UtilidadConformacion.liqcompra).toString());
        CC.setFecha(vistaCRUD.jtListProveedores.getValueAt(fila, UtilidadConformacion.fecha).toString());
        CC.setEstado(vistaCRUD.jtListProveedores.getValueAt(fila, UtilidadConformacion.estado).toString());
        

        String info = "INFO DOCUMENTO\n";
        info += "id: " + CC.getIddetalledocutraza() + "\n";
        info += "idcp: " + CC.getIdcp() + "\n";
        info += "Idorga: " + CC.getIdorga() + "\n";
        info += "CodAgricultor: " + CC.getCodagricultor() + "\n";
        info += "Apellidos: " + CC.getApellidos() + "\n";
        info += "Nombres: " + CC.getNombres() + "\n";
        info += "Dni: " + CC.getDni() + "\n";
        info += "Anexo: " + CC.getAnexo() + "\n";
        info += "Sacos: " + CC.getSacos() + "\n";
        info += "Kb: " + CC.getKb() + "\n";
        info += "Tara: " + CC.getTara() + "\n";
        info += "Kn: " + CC.getKn() + "\n";
        info += "Precio: " + CC.getPrecio() + "\n";
        info += "Importe Total: " + CC.getImportetotal() + "\n";
        info += "Guia: " + CC.getGuia() + "\n";
        info += "Liquidacion Compra: " + CC.getLiqcompra() + "\n";
        info += "Fecha: " + CC.getFecha() + "\n";
        info += "Estado: " + CC.getEstado() + "\n";

        JOptionPane.showMessageDialog(null, info);
    }

    private void validarSeleccionMouseListConforA(int fila) {
        UtilidadConformacion.filaSeleccionada = fila;            
        vistaCRUD.btnEditar.setEnabled(true);
        vistaCRUD.btnRegistrar.setEnabled(false);
    }
    
    
    
    @Override
    public void mouseClicked(MouseEvent me) {
  if (me.getSource() == vistaCRUD.jtListProveedores) {

            if (me.getClickCount() > 1) {
                int fila = vistaCRUD.jtListProveedores.rowAtPoint(me.getPoint());
                int columna = vistaCRUD.jtListProveedores.columnAtPoint(me.getPoint());
                validarSeleccionMouseListConfor(fila);
            }
            if (me.getClickCount() == 1) {
                int fila = vistaCRUD.jtListProveedores.rowAtPoint(me.getPoint());
                int columna = vistaCRUD.jtListProveedores.columnAtPoint(me.getPoint());                
                validarSeleccionMouseListConforA(fila);
            }
        }
//        if (me.getSource() == vistaCRUD.jtListProveedores) {
//
//            if (me.getClickCount() > 1) {
//                int fila = vistaCRUD.jtListProveedores.rowAtPoint(me.getPoint());
//                int columna = vistaCRUD.jtListProveedores.columnAtPoint(me.getPoint());
//                //validarSeleccionMouse(fila);
//            }
//        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public void mouseReleased(MouseEvent me) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public void mouseEntered(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public void mouseExited(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }
}
