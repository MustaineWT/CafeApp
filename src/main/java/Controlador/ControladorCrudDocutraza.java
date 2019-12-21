/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloExcel;
import Uti.GestionCeldas;
import Uti.GestionEncabezadoTabla;
import Uti.ModeloTabla;
import Uti.UtilidadCC;
import Uti.UtilidadDocu;
import Uti.UtilidadDocumento;
import static Uti.UtilidadesExtras.reiniciarJTable;
import dao.ConformacionDao;
import dao.DetalleDocutrazaDao;
import dao.DocutrazaDao;
import dao.ListaCombosDao;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import modelo.CompraContrato;
import modelo.DetalleDocutraza;
import modelo.Documento;
import modelo.Docutraza;
import modelo.ListaCombos;
import modelo.TipoDocumento;
import vista.RAgriEstimado;
import vista.RDocutraza_Document;
import vista.RPEstimado;
import vista.TraIni;
import static vista.TraIni.dskPrincipal;

/**
 *
 * @author MustainE
 */
public class ControladorCrudDocutraza implements ActionListener, MouseListener, KeyListener {

    RDocutraza_Document vistaCRUD = new RDocutraza_Document();
    DocutrazaDao modeloCRUD = new DocutrazaDao();
    ArrayList<CompraContrato> listaCompraContrato;
    ArrayList<Documento> listaDocumento;
    ArrayList<Docutraza> listaDocutraza;
    ArrayList<Docutraza> idNuevoDocutraza;
    ArrayList<TipoDocumento> idNuevoTD;
    int idempresa;
    int idsucursal;
    ModeloTabla modelojt;
    private int filasTabla;
    private int columnasTabla;
    DecimalFormat df = new DecimalFormat("#,###.00");
    //DecimalFormat formatea = new DecimalFormat("###,###.##");
    String texto;

    public ControladorCrudDocutraza(RDocutraza_Document vistaCRUD, DocutrazaDao modeloCRUD) {
        this.modeloCRUD = modeloCRUD;
        this.vistaCRUD = vistaCRUD;
        this.vistaCRUD.btnAsigCon.addActionListener(this);
        this.vistaCRUD.btnEditDocumento.addActionListener(this);
        this.vistaCRUD.btnEditDocutraza.addActionListener(this);
        this.vistaCRUD.btnNDocumento.addActionListener(this);
        this.vistaCRUD.btnNTrack.addActionListener(this);
        this.vistaCRUD.btnRegDocumento.addActionListener(this);
        this.vistaCRUD.btnRegTrack.addActionListener(this);
        this.vistaCRUD.btnVerConf.addActionListener(this);
        this.vistaCRUD.jtCompraContrato.addMouseListener(this);
        this.vistaCRUD.jtAscDocumentos.addMouseListener(this);
        this.vistaCRUD.jtDocutraza.addMouseListener(this);
        this.vistaCRUD.txtKb.addKeyListener(this);
        this.vistaCRUD.txtKn.addKeyListener(this);
    }

    public void InicializarCrud() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        idempresa = Integer.valueOf(TraIni.lblEmpresa.getText());
        idsucursal = Integer.valueOf(TraIni.lblSucursal.getText());
        if (e.getSource() == vistaCRUD.btnNDocumento) {
            idNuevoTD = dao.DocutrazaDao.idNuevoTD();
            vistaCRUD.txtIddocumento.setText(String.valueOf(idNuevoTD.get(0).getIdtipodocumento() + 1));
            DefaultComboBoxModel value;
            value = new DefaultComboBoxModel();
            vistaCRUD.jcbTDocumento.setModel(value);
            for (int i = 0; i < ListaCombosDao.idTdocumento().size(); i++) {
                value.addElement(new ListaCombos(ListaCombosDao.idTdocumento().get(i).getIdtdocumento(), ListaCombosDao.idTdocumento().get(i).getIdentificador()));
            }
            vistaCRUD.btnRegDocumento.setEnabled(true);
            vistaCRUD.btnNDocumento.setEnabled(false);
            vistaCRUD.btnEditDocumento.setEnabled(false);
            vistaCRUD.txtIddocumento.setEnabled(false);
            vistaCRUD.txtIdDocutraza.setEnabled(false);
            vistaCRUD.txtSerie.setEnabled(true);
            vistaCRUD.txtDocCorrelativo.setEnabled(true);
            Calendar c2 = new GregorianCalendar();
            vistaCRUD.txtFecha.setCalendar(c2);
            vistaCRUD.txtFecha.setEnabled(true);
            vistaCRUD.txtSerie.requestFocus();
        }

        if (e.getSource() == vistaCRUD.btnAsigCon) {

            int filaseleccionada;

            try {

                filaseleccionada = vistaCRUD.jtDocutraza.getSelectedRow();

                if (filaseleccionada == -1) {

                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");

                } else {

                    DefaultTableModel modelotabla = (DefaultTableModel) vistaCRUD.jtDocutraza.getModel();

                    String id = (String) modelotabla.getValueAt(filaseleccionada, 0);
                    String precio = (String) modelotabla.getValueAt(filaseleccionada, 12);
                    String peso = (String) modelotabla.getValueAt(filaseleccionada, 10);
                    String certificado = (String) modelotabla.getValueAt(filaseleccionada, 8);
                    String sacos = (String) modelotabla.getValueAt(filaseleccionada, 9);
                    RAgriEstimado ventana2 = new RAgriEstimado();
                    DetalleDocutrazaDao modeloC2 = new DetalleDocutrazaDao();
                    ControladorCrudDetalleDocutraza controlaC = new ControladorCrudDetalleDocutraza(ventana2, modeloC2);
                    controlaC.vistaCRUD.txtIdDocutraza.setText(id);
                    controlaC.vistaCRUD.txtPrecio.setText(precio);
                    controlaC.vistaCRUD.txtPeso.setText(peso);
                    controlaC.vistaCRUD.txtCertificado.setText(certificado);
                    controlaC.vistaCRUD.txtSaco.setText(sacos);
                    
                   
                    dskPrincipal.add(ventana2);
                    ventana2.setVisible(true);

                }
            } catch (HeadlessException ex) {

                JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente", " .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == vistaCRUD.btnVerConf) {

            int filaseleccionada;

            try {

                filaseleccionada = vistaCRUD.jtDocutraza.getSelectedRow();

                if (filaseleccionada == -1) {

                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");

                } else {

                    DefaultTableModel modelotabla = (DefaultTableModel) vistaCRUD.jtDocutraza.getModel();
                    String id = (String) modelotabla.getValueAt(filaseleccionada, 0); 
                    
                    String precio = (String) modelotabla.getValueAt(filaseleccionada, 12);
                    String peso = (String) modelotabla.getValueAt(filaseleccionada, 10);
                    String certificado = (String) modelotabla.getValueAt(filaseleccionada, 8);
                    String sacos = (String) modelotabla.getValueAt(filaseleccionada, 9);
                    RAgriEstimado ventana2 = new RAgriEstimado();
                    DetalleDocutrazaDao modeloC2 = new DetalleDocutrazaDao();
                    ControladorCrudDetalleDocutraza controlaC = new ControladorCrudDetalleDocutraza(ventana2, modeloC2);
                    controlaC.vistaCRUD.txtIdDocutraza.setText(id);
                    controlaC.vistaCRUD.txtPrecio.setText(precio);
                    controlaC.vistaCRUD.txtPeso.setText(peso);
                    controlaC.vistaCRUD.txtCertificado.setText(certificado);
                    controlaC.vistaCRUD.txtSaco.setText(sacos);
                    controlaC.construirTablaListConfor(idempresa, idsucursal,Integer.valueOf(id));   
                    controlaC.vistaCRUD.btnProcesar.setVisible(false);
                    controlaC.vistaCRUD.btnImportar.setVisible(false);
                    ModeloExcel ModeloEX=new ModeloExcel();
                
                    ControladorExcel ControlExcel=new ControladorExcel(ventana2, ModeloEX);
                    
                    dskPrincipal.add(ventana2);
                    ventana2.setVisible(true);
                    
                    

                }
            } catch (HeadlessException ex) {

                JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente", " .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);

            }

        }
        
        

        if (e.getSource() == vistaCRUD.btnNTrack) {
            idNuevoDocutraza = dao.DocutrazaDao.idNuevoDocutraza();
            vistaCRUD.txtIdDocutrza.setText(String.valueOf(idNuevoDocutraza.get(0).getIddocutraza() + 1));
            DefaultComboBoxModel value;
            value = new DefaultComboBoxModel();
            vistaCRUD.jcbCliente.setModel(value);

            for (int i = 0; i < ListaCombosDao.idCliente(idempresa, idsucursal).size(); i++) {
                value.addElement(new ListaCombos(Integer.valueOf(ListaCombosDao.idCliente(idempresa, idsucursal).get(i).getIdpersona()), ListaCombosDao.idCliente(idempresa, idsucursal).get(i).getRazonsocial()));
            }
            vistaCRUD.btnRegTrack.setEnabled(true);
            vistaCRUD.btnNTrack.setEnabled(false);
            vistaCRUD.btnEditDocutraza.setEnabled(false);
            vistaCRUD.txtIdDocutrza.setEnabled(false);
            vistaCRUD.txtidCompContrato.setEnabled(false);
            vistaCRUD.txtSerieGuia.setEnabled(true);
            vistaCRUD.txtCorrelativo.setEnabled(true);
            vistaCRUD.txtFairtrade.setEnabled(true);
            Calendar c2 = new GregorianCalendar();
            vistaCRUD.jdFecha.setCalendar(c2);
            vistaCRUD.jdFecha.setEnabled(true);
            vistaCRUD.txtSacos.setEnabled(true);
            vistaCRUD.txtKb.setEnabled(false);
            vistaCRUD.txtKn.setEnabled(true);
            vistaCRUD.txtSerieGuia.requestFocus();

        }
        if (e.getSource() == vistaCRUD.btnRegDocumento) {
            if (vistaCRUD.txtSerie.getText().isEmpty() || vistaCRUD.txtDocCorrelativo.getText().isEmpty()
                    || vistaCRUD.txtFecha.getDate().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe Llenar todos los datos necesarios.");
            } else {
                if (vistaCRUD.btnRegDocumento.getText() == "Guardar") {
                    int iddocumento = Integer.valueOf(vistaCRUD.txtIddocumento.getText());
                    int iddocutrazad = Integer.valueOf(vistaCRUD.txtIdDocutraza.getText());
                    ListaCombos cli = (ListaCombos) vistaCRUD.jcbTDocumento.getSelectedItem();
                    int tdocumento = cli.getIdpersona();
                    String serie = vistaCRUD.txtSerie.getText();
                    String correlativo = vistaCRUD.txtDocCorrelativo.getText();
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                    String fecha = formatoFecha.format(vistaCRUD.txtFecha.getDate());
                    String Estado = "";
                    if ((String) vistaCRUD.jcbEstDoc.getSelectedItem() == "Activo") {
                        Estado = "A";
                    }
                    if ((String) vistaCRUD.jcbEstDoc.getSelectedItem() == "Inactivo") {
                        Estado = "I";
                    }
                    String rptaRegistro = modeloCRUD.updateDocumento(iddocumento, idempresa, idsucursal, iddocutrazad, tdocumento, serie, correlativo, fecha, Estado);
                    if (rptaRegistro != null) {
                         vistaCRUD.btnRegDocumento.setEnabled(true);                        
                        vistaCRUD.btnEditDocutraza.setEnabled(false);
                        vistaCRUD.txtSerie.setEnabled(false);
                        vistaCRUD.txtIddocumento.setEnabled(false);
                        vistaCRUD.txtDocCorrelativo.setEnabled(false);
                        vistaCRUD.txtFecha.setEnabled(false);
                        JOptionPane.showMessageDialog(null, rptaRegistro);
                        vistaCRUD.txtSerie.setText("");
                        vistaCRUD.txtDocCorrelativo.setText("");
                        vistaCRUD.txtIddocumento.setText("");
                        vistaCRUD.txtFecha.setCalendar(null);
                        //reiniciarJTable(vistaCRUD.jtDocutraza);
                        reiniciarJTable(vistaCRUD.jtCompraContrato);
                        //construirTablaDocutraza(idempresa, idsucursal);
                        reiniciarJTable(vistaCRUD.jtAscDocumentos);
                        int dct = Integer.valueOf(vistaCRUD.txtIdDocutraza.getText());
                        construirTablaDocumento(idempresa, idsucursal, dct);
                        construirTablaCompraContrato(idempresa, idsucursal);
                        vistaCRUD.btnRegDocumento.setEnabled(false);
                        vistaCRUD.btnNDocumento.setEnabled(true);
                        vistaCRUD.btnRegDocumento.setText("Registrar");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo realizar la actualización.");
                    }
                } else {
                    int iddocumento = Integer.valueOf(vistaCRUD.txtIddocumento.getText());
                    int iddocutrazad = Integer.valueOf(vistaCRUD.txtIdDocutraza.getText());
                    ListaCombos cli = (ListaCombos) vistaCRUD.jcbTDocumento.getSelectedItem();
                    int tdocumento = cli.getIdpersona();
                    String serie = vistaCRUD.txtSerie.getText();
                    String correlativo = vistaCRUD.txtDocCorrelativo.getText();
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                    String fecha = formatoFecha.format(vistaCRUD.txtFecha.getDate());
                    String Estado = "";
                    if ((String) vistaCRUD.jcbEstDoc.getSelectedItem() == "Activo") {
                        Estado = "A";
                    }
                    if ((String) vistaCRUD.jcbEstDoc.getSelectedItem() == "Inactivo") {
                        Estado = "I";
                    }
                    String rptaRegistro = modeloCRUD.insertDocumento(iddocumento, idempresa, idsucursal, iddocutrazad, tdocumento, serie, correlativo, fecha, Estado);
                    if (rptaRegistro != null) {
                        vistaCRUD.btnRegDocumento.setEnabled(true);                        
                        vistaCRUD.btnEditDocutraza.setEnabled(false);
                        vistaCRUD.txtSerie.setEnabled(false);
                        vistaCRUD.txtIddocumento.setEnabled(false);
                        vistaCRUD.txtDocCorrelativo.setEnabled(false);
                        vistaCRUD.txtFecha.setEnabled(true);
                        vistaCRUD.txtDocCorrelativo.setEnabled(true);
                        JOptionPane.showMessageDialog(null, rptaRegistro);
                        vistaCRUD.txtSerie.setText("");
                        vistaCRUD.txtDocCorrelativo.setText("");
                        vistaCRUD.txtIddocumento.setText("");
                       
                        Calendar c2 = new GregorianCalendar();
                        vistaCRUD.txtFecha.setCalendar(c2);

                        //reiniciarJTable(vistaCRUD.jtDocutraza);
                        reiniciarJTable(vistaCRUD.jtCompraContrato);
                        //construirTablaDocutraza(idempresa, idsucursal);
                        reiniciarJTable(vistaCRUD.jtAscDocumentos);
                        int dct = Integer.valueOf(vistaCRUD.txtIdDocutraza.getText());
                        construirTablaDocumento(idempresa, idsucursal, dct);
                        construirTablaCompraContrato(idempresa, idsucursal);
                        vistaCRUD.btnRegDocumento.setEnabled(false);
                        vistaCRUD.btnNDocumento.setEnabled(true);
                        //vistaCRUD.btnRegDocumento.setText("Registrar");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo realizar la actualización.");
                    }
                }
            }

        }
        if (e.getSource() == vistaCRUD.btnEditDocumento) {
            vistaCRUD.btnRegDocumento.setEnabled(true);
            vistaCRUD.btnRegDocumento.setText("Guardar");

            DefaultComboBoxModel value;
            value = new DefaultComboBoxModel();
            vistaCRUD.jcbTDocumento.setModel(value);
            for (int i = 0; i < ListaCombosDao.idTdocumento().size(); i++) {
                value.addElement(new ListaCombos(ListaCombosDao.idTdocumento().get(i).getIdtdocumento(), ListaCombosDao.idTdocumento().get(i).getIdentificador()));
            }
            int filaseleccionada;

            try {

                filaseleccionada = vistaCRUD.jtAscDocumentos.getSelectedRow();

                if (filaseleccionada == -1) {

                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");

                } else {

                    DefaultTableModel modelotabla = (DefaultTableModel) vistaCRUD.jtAscDocumentos.getModel();

                    String id = (String) modelotabla.getValueAt(filaseleccionada, 0);

                    int iddocumento = DocutrazaDao.SelectDocumento(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIddocumento();
                    int empresa = DocutrazaDao.SelectDocumento(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIdempresa();
                    int sucursal = DocutrazaDao.SelectDocumento(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIdsucursal();
                    int iddocutraza = DocutrazaDao.SelectDocumento(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIddocutraza();
                    String identificador = DocutrazaDao.SelectDocumento(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIdentificador();
                    String serieguia = DocutrazaDao.SelectDocumento(idempresa, idsucursal, Integer.valueOf(id)).get(0).getSerie();
                    String correlativo = DocutrazaDao.SelectDocumento(idempresa, idsucursal, Integer.valueOf(id)).get(0).getCorrelativo();
                    String fecha = DocutrazaDao.SelectDocumento(idempresa, idsucursal, Integer.valueOf(id)).get(0).getFecha();
                    String estado = DocutrazaDao.SelectDocumento(idempresa, idsucursal, Integer.valueOf(id)).get(0).getEstado();
                    vistaCRUD.txtSerie.setEnabled(true);
                    vistaCRUD.txtDocCorrelativo.setEnabled(true);
                    vistaCRUD.txtFecha.setEnabled(true);
                    vistaCRUD.txtIddocumento.setText(String.valueOf(iddocumento));
                    vistaCRUD.txtIdDocutraza.setText(String.valueOf(iddocutraza));
                    vistaCRUD.jcbTDocumento.setSelectedItem(identificador);
                    vistaCRUD.txtSerie.setText(serieguia);
                    vistaCRUD.txtDocCorrelativo.setText(correlativo);
                    vistaCRUD.txtSerie.requestFocus();
                    reiniciarJTable(vistaCRUD.jtAscDocumentos);
                    int dct = Integer.valueOf(vistaCRUD.txtIdDocutraza.getText());
                    construirTablaDocumento(idempresa, idsucursal, dct);
                    if (estado.equals("I")) {
                        vistaCRUD.jcbEstDoc.setSelectedIndex(0);
                    } else {
                        vistaCRUD.jcbEstDoc.setSelectedIndex(1);
                    }
                    //reiniciarJTable(vistaCRUD.jtDocutraza);
                    //construirTabla(idempresa, idsucursal);
                }
            } catch (HeadlessException ex) {

                JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente", " .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);

            }
        }
        if (e.getSource() == vistaCRUD.btnRegTrack) {
            if (vistaCRUD.txtSerieGuia.getText().isEmpty() || vistaCRUD.txtCorrelativo.getText().isEmpty() || vistaCRUD.txtKn.getText().isEmpty()
                    || vistaCRUD.txtSacos.getText().isEmpty() || vistaCRUD.txtSacos.getText().isEmpty() || vistaCRUD.txtKb.getText().isEmpty()
                    || vistaCRUD.jdFecha.getDate().equals("") || vistaCRUD.txtFairtrade.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe Llenar todos los datos necesarios.");
            } else {
                if (vistaCRUD.btnRegTrack.getText() == "Guardar") {
                    int iddocutraza = Integer.valueOf(vistaCRUD.txtIdDocutrza.getText());
                    int idcompcontrato = Integer.valueOf(vistaCRUD.txtidCompContrato.getText());
                    ListaCombos cli = (ListaCombos) vistaCRUD.jcbCliente.getSelectedItem();
                    int cliente = cli.getIdpersona();
                    String serieguia = vistaCRUD.txtSerieGuia.getText();
                    String correlativo = vistaCRUD.txtCorrelativo.getText();
                    String certificado = String.valueOf(vistaCRUD.jcbCertificado.getSelectedItem());
                    int saco = Integer.valueOf(vistaCRUD.txtSacos.getText());
                    double kb = Float.valueOf(vistaCRUD.txtKb.getText().replace(".", "").replace(",", "."));
                    double kn = Float.valueOf(vistaCRUD.txtKn.getText().replace(".", "").replace(",", "."));
                    String fairtrade = vistaCRUD.txtCorrelativo.getText();
                    String condicion = String.valueOf(vistaCRUD.jcbCondicion.getSelectedItem());
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                    String fecha = formatoFecha.format(vistaCRUD.jdFecha.getDate());
                    String Estado = "";
                    if ((String) vistaCRUD.jcbEstTrack.getSelectedItem() == "Activo") {
                        Estado = "A";
                    }
                    if ((String) vistaCRUD.jcbEstTrack.getSelectedItem() == "Inactivo") {
                        Estado = "I";
                    }
                    String rptaRegistro = modeloCRUD.UpdateDocutraza(iddocutraza, idempresa, idsucursal, idcompcontrato, cliente, serieguia, correlativo, certificado, saco, kb, kn, fairtrade, condicion, fecha, Estado);
                    if (rptaRegistro != null) {
                        vistaCRUD.btnRegTrack.setEnabled(true);
                        vistaCRUD.btnNTrack.setEnabled(false);
                        vistaCRUD.btnEditDocutraza.setEnabled(false);
                        vistaCRUD.txtIdDocutrza.setEnabled(false);
                        vistaCRUD.txtidCompContrato.setEnabled(false);
                        vistaCRUD.txtSerieGuia.setEnabled(false);
                        vistaCRUD.txtCorrelativo.setEnabled(false);
                        vistaCRUD.jdFecha.setEnabled(false);
                        vistaCRUD.txtSacos.setEnabled(false);
                        vistaCRUD.txtKb.setEnabled(false);
                        vistaCRUD.txtKn.setEnabled(false);
                        vistaCRUD.txtFairtrade.setEnabled(false);
                        JOptionPane.showMessageDialog(null, rptaRegistro);
                        vistaCRUD.txtIdDocutrza.setText("");
                        vistaCRUD.txtidCompContrato.setText("");
                        vistaCRUD.txtSerieGuia.setText("");
                        vistaCRUD.txtCorrelativo.setText("");
                        vistaCRUD.txtSacos.setText("");
                        vistaCRUD.txtKb.setText("");
                        vistaCRUD.txtKn.setText("");
                        vistaCRUD.txtFairtrade.setText("");
                        vistaCRUD.jdFecha.setCalendar(null);
                        reiniciarJTable(vistaCRUD.jtDocutraza);
                        reiniciarJTable(vistaCRUD.jtCompraContrato);
                        construirTablaDocutraza(idempresa, idsucursal);
                        construirTablaCompraContrato(idempresa, idsucursal);
                        vistaCRUD.btnRegTrack.setEnabled(false);
                        vistaCRUD.btnRegTrack.setText("Registrar");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo realizar la actualización.");
                    }
                } else {
                    int iddocutraza = Integer.valueOf(vistaCRUD.txtIdDocutrza.getText());
                    int idcompcontrato = Integer.valueOf(vistaCRUD.txtidCompContrato.getText());
                    ListaCombos cli = (ListaCombos) vistaCRUD.jcbCliente.getSelectedItem();
                    int cliente = cli.getIdpersona();
                    String serieguia = vistaCRUD.txtSerieGuia.getText();
                    String correlativo = vistaCRUD.txtCorrelativo.getText();
                    String certificado = String.valueOf(vistaCRUD.jcbCertificado.getSelectedItem());
                    int saco = Integer.valueOf(vistaCRUD.txtSacos.getText());
                    float kb = Float.valueOf(vistaCRUD.txtKb.getText().replace(".", "").replace(",", "."));
                    float kn = Float.valueOf(vistaCRUD.txtKn.getText().replace(".", "").replace(",", "."));
                    String fairtrade = vistaCRUD.txtCorrelativo.getText();
                    String condicion = String.valueOf(vistaCRUD.jcbCondicion.getSelectedItem());
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                    String fecha = formatoFecha.format(vistaCRUD.jdFecha.getDate());
                    String Estado = "";
                    if ((String) vistaCRUD.jcbEstTrack.getSelectedItem() == "Activo") {
                        Estado = "A";
                    }
                    if ((String) vistaCRUD.jcbEstTrack.getSelectedItem() == "Inactivo") {
                        Estado = "I";
                    }
                    String rptaRegistro = modeloCRUD.insertDocutraza(iddocutraza, idempresa, idsucursal, idcompcontrato, cliente, serieguia, correlativo, certificado, saco, kb, kn, fairtrade, condicion, fecha, Estado);
                    if (rptaRegistro != null) {
                        vistaCRUD.btnRegTrack.setEnabled(true);
                        vistaCRUD.btnNTrack.setEnabled(false);
                        vistaCRUD.btnEditDocutraza.setEnabled(false);
                        vistaCRUD.txtIdDocutrza.setEnabled(false);
                        vistaCRUD.txtidCompContrato.setEnabled(false);
                        vistaCRUD.txtSerieGuia.setEnabled(false);
                        vistaCRUD.txtCorrelativo.setEnabled(false);
                        vistaCRUD.jdFecha.setEnabled(false);
                        vistaCRUD.txtSacos.setEnabled(false);
                        vistaCRUD.txtKb.setEnabled(false);
                        vistaCRUD.txtKn.setEnabled(false);
                        vistaCRUD.txtFairtrade.setEnabled(false);
                        JOptionPane.showMessageDialog(null, rptaRegistro);
                        vistaCRUD.txtIdDocutrza.setText("");
                        vistaCRUD.txtidCompContrato.setText("");
                        vistaCRUD.txtSerieGuia.setText("");
                        vistaCRUD.txtCorrelativo.setText("");
                        vistaCRUD.txtSacos.setText("");
                        vistaCRUD.txtKb.setText("");
                        vistaCRUD.txtKn.setText("");
                        vistaCRUD.txtFairtrade.setText("");
                        vistaCRUD.jdFecha.setCalendar(null);
                        reiniciarJTable(vistaCRUD.jtDocutraza);
                        reiniciarJTable(vistaCRUD.jtCompraContrato);
                        construirTablaDocutraza(idempresa, idsucursal);
                        construirTablaCompraContrato(idempresa, idsucursal);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo realizar la actualización.");
                    }
                }
            }

        }
        if (e.getSource() == vistaCRUD.btnEditDocutraza) {
            vistaCRUD.btnRegTrack.setEnabled(true);
            vistaCRUD.btnRegTrack.setText("Guardar");

            DefaultComboBoxModel value;
            value = new DefaultComboBoxModel();
            vistaCRUD.jcbCliente.setModel(value);

            for (int i = 0; i < ListaCombosDao.idCliente(idempresa, idsucursal).size(); i++) {
                value.addElement(new ListaCombos(Integer.valueOf(ListaCombosDao.idCliente(idempresa, idsucursal).get(i).getIdpersona()), ListaCombosDao.idCliente(idempresa, idsucursal).get(i).getRazonsocial()));
            }

            int filaseleccionada;

            try {

                filaseleccionada = vistaCRUD.jtDocutraza.getSelectedRow();

                if (filaseleccionada == -1) {

                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");

                } else {

                    DefaultTableModel modelotabla = (DefaultTableModel) vistaCRUD.jtDocutraza.getModel();

                    String id = (String) modelotabla.getValueAt(filaseleccionada, 0);

                    int iddocutraza = DocutrazaDao.SelectDocutraza(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIddocutraza();
                    int empresa = DocutrazaDao.SelectDocutraza(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIdempresa();
                    int sucursal = DocutrazaDao.SelectDocutraza(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIdsucursal();
                    int idcompcontrato = DocutrazaDao.SelectDocutraza(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIdcompracontrato();
                    String cliente = DocutrazaDao.SelectDocutraza(idempresa, idsucursal, Integer.valueOf(id)).get(0).getCliente();
                    String serieguia = DocutrazaDao.SelectDocutraza(idempresa, idsucursal, Integer.valueOf(id)).get(0).getSerieguia();
                    String correlativo = DocutrazaDao.SelectDocutraza(idempresa, idsucursal, Integer.valueOf(id)).get(0).getCorrelativo();
                    String certificado = DocutrazaDao.SelectDocutraza(idempresa, idsucursal, Integer.valueOf(id)).get(0).getCertificado();
                    int sacos = DocutrazaDao.SelectDocutraza(idempresa, idsucursal, Integer.valueOf(id)).get(0).getSacos();
                    float kb = (float) DocutrazaDao.SelectDocutraza(idempresa, idsucursal, Integer.valueOf(id)).get(0).getKb();
                    //float precio = (float) DocutrazaDao.SelectDocutraza(idempresa, idsucursal, Integer.valueOf(id)).get(0).getKb();
                    float kn = (float) DocutrazaDao.SelectDocutraza(idempresa, idsucursal, Integer.valueOf(id)).get(0).getKn();
                    String fairtrade = DocutrazaDao.SelectDocutraza(idempresa, idsucursal, Integer.valueOf(id)).get(0).getFairtrade();
                    String condicion = DocutrazaDao.SelectDocutraza(idempresa, idsucursal, Integer.valueOf(id)).get(0).getCondicion();
                    String fecha = DocutrazaDao.SelectDocutraza(idempresa, idsucursal, Integer.valueOf(id)).get(0).getFecha();
                    String estado = DocutrazaDao.SelectDocutraza(idempresa, idsucursal, Integer.valueOf(id)).get(0).getEstado();

                    vistaCRUD.txtSerieGuia.setEnabled(true);
                    vistaCRUD.txtCorrelativo.setEnabled(true);
                    vistaCRUD.jdFecha.setEnabled(true);
                    vistaCRUD.txtSacos.setEnabled(true);
                    vistaCRUD.txtKb.setEnabled(true);
                    vistaCRUD.txtKn.setEnabled(true);
                    vistaCRUD.txtFairtrade.setEnabled(true);
                    //
                    vistaCRUD.txtIdDocutrza.setText(String.valueOf(iddocutraza));
                    vistaCRUD.txtidCompContrato.setText(String.valueOf(idcompcontrato));
                    vistaCRUD.jcbCliente.setSelectedItem(cliente);
                    vistaCRUD.txtSerieGuia.setText(serieguia);
                    vistaCRUD.txtCorrelativo.setText(correlativo);
                    vistaCRUD.jcbCondicion.setSelectedItem(condicion);
                    vistaCRUD.jcbCertificado.setSelectedItem(certificado);
                    vistaCRUD.jdFecha.setDate(Date.valueOf(fecha));
                    vistaCRUD.txtSacos.setText(String.valueOf(sacos));
                    vistaCRUD.txtKb.setText(df.format(kb));
                    vistaCRUD.txtKn.setText(df.format(kn));
                    vistaCRUD.txtFairtrade.setText(fairtrade);
                    vistaCRUD.txtSerieGuia.requestFocus();

                    if (estado.equals("I")) {
                        vistaCRUD.jcbEstTrack.setSelectedIndex(1);
                    } else {
                        vistaCRUD.jcbEstTrack.setSelectedIndex(0);
                    }
                    //reiniciarJTable(vistaCRUD.jtDocutraza);
                    //construirTabla(idempresa, idsucursal);
                }
            } catch (HeadlessException ex) {

                JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente", " .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    public void construirTablaDocumento(int empresa, int sucursal, int dct) {

        listaDocumento = dao.DocutrazaDao.listaDocumento(empresa, sucursal, dct);

        ArrayList<String> titulosList = new ArrayList<>();

        titulosList.add("Id");
        titulosList.add("Emp");
        titulosList.add("Suc");
        titulosList.add("idDocTz");
        titulosList.add("Tipo");
        titulosList.add("Serie");
        titulosList.add("Correlativo");
        titulosList.add("Fecha");
        titulosList.add("Est.");

        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }
        Object[][] data = obtenerMatrizDatosDoc(titulosList);
        construirTablaDocumento(titulos, data);
    }

    public void construirTablabuscarDoc(int empresa, int sucursal, String texto) {

        listaDocumento = dao.DocutrazaDao.listaDocumentoBuscar(empresa, sucursal);

        ArrayList<String> titulosList = new ArrayList<>();

        titulosList.add("Id");
        titulosList.add("Emp");
        titulosList.add("Suc");
        titulosList.add("idDocTz");
        titulosList.add("Tipo");
        titulosList.add("Serie");
        titulosList.add("Correlativo");
        titulosList.add("Fecha");
        titulosList.add("Est.");

        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }

        Object[][] data = obtenerMatrizDatosDoc(titulosList);
        construirTablaDocumento(titulos, data);
    }

    private Object[][] obtenerMatrizDatosDoc(ArrayList<String> titulosList) {

        String informacion[][] = new String[listaDocumento.size()][titulosList.size()];

        for (int x = 0; x < informacion.length; x++) {

            informacion[x][UtilidadDocumento.iddocumento] = listaDocumento.get(x).getIddocumento() + "";
            informacion[x][UtilidadDocumento.idempresa] = listaDocumento.get(x).getIdempresa() + "";
            informacion[x][UtilidadDocumento.idsucursal] = listaDocumento.get(x).getIdsucursal() + "";
            informacion[x][UtilidadDocumento.iddocutraza] = listaDocumento.get(x).getIddocutraza() + "";
            informacion[x][UtilidadDocumento.identificador] = listaDocumento.get(x).getIdentificador() + "";
            informacion[x][UtilidadDocumento.serie] = listaDocumento.get(x).getSerie() + "";
            informacion[x][UtilidadDocumento.correlativo] = listaDocumento.get(x).getCorrelativo() + "";
            informacion[x][UtilidadDocumento.fecha] = listaDocumento.get(x).getFecha() + "";
            informacion[x][UtilidadDocumento.estado] = listaDocumento.get(x).getEstado() + "";
        }
        return informacion;
    }

    private void construirTablaDocumento(String[] titulos, Object[][] data) {
        modelojt = new ModeloTabla(data, titulos);
        //se asigna el modelo a la tabla
        vistaCRUD.jtAscDocumentos.setModel(modelojt);

        filasTabla = vistaCRUD.jtAscDocumentos.getRowCount();
        columnasTabla = vistaCRUD.jtAscDocumentos.getColumnCount();

        vistaCRUD.jtAscDocumentos.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAscDocumentos.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAscDocumentos.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAscDocumentos.getColumnModel().getColumn(3).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAscDocumentos.getColumnModel().getColumn(4).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAscDocumentos.getColumnModel().getColumn(5).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAscDocumentos.getColumnModel().getColumn(6).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAscDocumentos.getColumnModel().getColumn(7).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAscDocumentos.getColumnModel().getColumn(8).setCellRenderer(new GestionCeldas("texto"));

        vistaCRUD.jtAscDocumentos.getTableHeader().setReorderingAllowed(false);
        vistaCRUD.jtAscDocumentos.setRowHeight(25);
        vistaCRUD.jtAscDocumentos.setGridColor(new java.awt.Color(0, 0, 0));

        vistaCRUD.jtAscDocumentos.getColumnModel().getColumn(UtilidadDocumento.iddocumento).setPreferredWidth(40);
        vistaCRUD.jtAscDocumentos.getColumnModel().getColumn(UtilidadDocumento.idempresa).setPreferredWidth(40);
        vistaCRUD.jtAscDocumentos.getColumnModel().getColumn(UtilidadDocumento.idsucursal).setPreferredWidth(40);
        vistaCRUD.jtAscDocumentos.getColumnModel().getColumn(UtilidadDocumento.iddocutraza).setPreferredWidth(60);
        vistaCRUD.jtAscDocumentos.getColumnModel().getColumn(UtilidadDocumento.identificador).setPreferredWidth(60);
        vistaCRUD.jtAscDocumentos.getColumnModel().getColumn(UtilidadDocumento.serie).setPreferredWidth(60);
        vistaCRUD.jtAscDocumentos.getColumnModel().getColumn(UtilidadDocumento.correlativo).setPreferredWidth(50);
        vistaCRUD.jtAscDocumentos.getColumnModel().getColumn(UtilidadDocumento.fecha).setPreferredWidth(70);
        vistaCRUD.jtAscDocumentos.getColumnModel().getColumn(UtilidadDocumento.estado).setPreferredWidth(60);

        JTableHeader jtableHeader = vistaCRUD.jtAscDocumentos.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        vistaCRUD.jtAscDocumentos.setTableHeader(jtableHeader);

        vistaCRUD.jScrollPane4.setViewportView(vistaCRUD.jtAscDocumentos);
    }

    public void construirTablaCompraContrato(int empresa, int sucursal) {

        listaCompraContrato = dao.DocutrazaDao.listCompraContrato(empresa, sucursal);

        ArrayList<String> titulosList = new ArrayList<>();

        titulosList.add("Id");
        titulosList.add("Emp");
        titulosList.add("Suc");
        titulosList.add("idCC");
        titulosList.add("Peso");
        titulosList.add("Precio");
        titulosList.add("ImpTotal");
        titulosList.add("Fecha");
        titulosList.add("Est.");

        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }
        Object[][] data = obtenerMatrizDatosCC(titulosList);
        construirTablaCompContrato(titulos, data);
    }

    public void construirTablabuscarCC(int empresa, int sucursal, String texto) {

        listaCompraContrato = dao.DocutrazaDao.listCompraContratoBuscar(empresa, sucursal, texto);

        ArrayList<String> titulosList = new ArrayList<>();

        titulosList.add("Id");
        titulosList.add("Emp");
        titulosList.add("Suc");
        titulosList.add("Peso");
        titulosList.add("Precio");
        titulosList.add("ImpTotal");
        titulosList.add("Calidad");
        titulosList.add("Humedad");
        titulosList.add("Contrato");
        titulosList.add("Cliente");
        titulosList.add("Fecha");
        titulosList.add("Est");

        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }

        Object[][] data = obtenerMatrizDatosCC(titulosList);
        construirTablaCompContrato(titulos, data);
    }

    private Object[][] obtenerMatrizDatosCC(ArrayList<String> titulosList) {

        String informacion[][] = new String[listaCompraContrato.size()][titulosList.size()];

        for (int x = 0; x < informacion.length; x++) {

            informacion[x][UtilidadCC.idcompracontrato] = listaCompraContrato.get(x).getIdcompracontrato() + "";
            informacion[x][UtilidadCC.idempresa] = listaCompraContrato.get(x).getIdempresa() + "";
            informacion[x][UtilidadCC.idsucursal] = listaCompraContrato.get(x).getIdsucursal() + "";
            informacion[x][UtilidadCC.idaperturacontrato] = listaCompraContrato.get(x).getIdaperturacontrato() + "";
            informacion[x][UtilidadCC.peso] = df.format(listaCompraContrato.get(x).getPeso()) + "";
            informacion[x][UtilidadCC.precio] = listaCompraContrato.get(x).getPrecio() + "";
            informacion[x][UtilidadCC.imptotal] = listaCompraContrato.get(x).getImptotal() + "";
            informacion[x][UtilidadCC.fecha] = listaCompraContrato.get(x).getFecha() + "";
            informacion[x][UtilidadCC.estado] = listaCompraContrato.get(x).getEstado() + "";
        }
        return informacion;
    }

    private void construirTablaCompContrato(String[] titulos, Object[][] data) {
        modelojt = new ModeloTabla(data, titulos);
        vistaCRUD.jtCompraContrato.setModel(modelojt);

        filasTabla = vistaCRUD.jtCompraContrato.getRowCount();
        columnasTabla = vistaCRUD.jtCompraContrato.getColumnCount();

        vistaCRUD.jtCompraContrato.getColumnModel().getColumn(UtilidadCC.peso).setCellRenderer(new GestionCeldas("numerico"));
        vistaCRUD.jtCompraContrato.getColumnModel().getColumn(UtilidadCC.precio).setCellRenderer(new GestionCeldas("numerico"));
        vistaCRUD.jtCompraContrato.getColumnModel().getColumn(UtilidadCC.imptotal).setCellRenderer(new GestionCeldas("numerico"));

        vistaCRUD.jtCompraContrato.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtCompraContrato.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtCompraContrato.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtCompraContrato.getColumnModel().getColumn(3).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtCompraContrato.getColumnModel().getColumn(7).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtCompraContrato.getColumnModel().getColumn(8).setCellRenderer(new GestionCeldas("texto"));

        vistaCRUD.jtCompraContrato.getTableHeader().setReorderingAllowed(false);
        vistaCRUD.jtCompraContrato.setRowHeight(25);
        vistaCRUD.jtCompraContrato.setGridColor(new java.awt.Color(0, 0, 0));

        vistaCRUD.jtCompraContrato.getColumnModel().getColumn(UtilidadCC.idcompracontrato).setPreferredWidth(40);
        vistaCRUD.jtCompraContrato.getColumnModel().getColumn(UtilidadCC.idempresa).setPreferredWidth(40);
        vistaCRUD.jtCompraContrato.getColumnModel().getColumn(UtilidadCC.idsucursal).setPreferredWidth(40);
        vistaCRUD.jtCompraContrato.getColumnModel().getColumn(UtilidadCC.idaperturacontrato).setPreferredWidth(60);
        vistaCRUD.jtCompraContrato.getColumnModel().getColumn(UtilidadCC.peso).setPreferredWidth(60);
        vistaCRUD.jtCompraContrato.getColumnModel().getColumn(UtilidadCC.precio).setPreferredWidth(60);
        vistaCRUD.jtCompraContrato.getColumnModel().getColumn(UtilidadCC.imptotal).setPreferredWidth(50);
        vistaCRUD.jtCompraContrato.getColumnModel().getColumn(UtilidadCC.fecha).setPreferredWidth(70);
        vistaCRUD.jtCompraContrato.getColumnModel().getColumn(UtilidadCC.estado).setPreferredWidth(60);

        JTableHeader jtableHeader = vistaCRUD.jtCompraContrato.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        vistaCRUD.jtCompraContrato.setTableHeader(jtableHeader);

        vistaCRUD.jScrollPane2.setViewportView(vistaCRUD.jtCompraContrato);
    }

    public void construirTablaDocutraza(int empresa, int sucursal) {

        listaDocutraza = dao.DocutrazaDao.listDocutraza(empresa, sucursal);

        ArrayList<String> titulosList = new ArrayList<>();

        titulosList.add("Id");
        titulosList.add("Emp");
        titulosList.add("Suc");
        titulosList.add("idCC");
        titulosList.add("idP");
        titulosList.add("RazonSocial");
        titulosList.add("Serie");
        titulosList.add("Correlativo");
        titulosList.add("Certificado");
        titulosList.add("Sacos");
        titulosList.add("Kb");
        titulosList.add("Precio");
        titulosList.add("Kn");
        titulosList.add("Fairtrade");
        titulosList.add("Condicion");
        titulosList.add("Fecha");
        titulosList.add("Est.");

        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }
        Object[][] data = obtenerMatrizDatosDocutraza(titulosList);
        construirTablaDocutraza(titulos, data);
    }

    public void construirTablabuscarDocutraza(int empresa, int sucursal, String texto) {

        listaCompraContrato = dao.DocutrazaDao.listCompraContratoBuscar(empresa, sucursal, texto);

        ArrayList<String> titulosList = new ArrayList<>();

        titulosList.add("Id");
        titulosList.add("Emp");
        titulosList.add("Suc");
        titulosList.add("idCC");
        titulosList.add("idP");
        titulosList.add("RazonSocial");
        titulosList.add("Serie");
        titulosList.add("Correlativo");
        titulosList.add("Certificado");
        titulosList.add("Sacos");
        titulosList.add("Kb");
        titulosList.add("Precio");
        titulosList.add("Kn");
        titulosList.add("Fairtrade");
        titulosList.add("Condicion");
        titulosList.add("Fecha");
        titulosList.add("Est.");

        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }

        Object[][] data = obtenerMatrizDatosDocutraza(titulosList);
        construirTablaDocutraza(titulos, data);
    }

    private Object[][] obtenerMatrizDatosDocutraza(ArrayList<String> titulosList) {

        String informacion[][] = new String[listaDocutraza.size()][titulosList.size()];
        for (int x = 0; x < informacion.length; x++) {
            informacion[x][UtilidadDocu.iddocutraza] = listaDocutraza.get(x).getIddocutraza() + "";
            informacion[x][UtilidadDocu.idempresa] = listaDocutraza.get(x).getIdempresa() + "";
            informacion[x][UtilidadDocu.idsucursal] = listaDocutraza.get(x).getIdsucursal() + "";
            informacion[x][UtilidadDocu.idcompracontrato] = listaDocutraza.get(x).getIdcompracontrato() + "";
            informacion[x][UtilidadDocu.idpersona] = listaDocutraza.get(x).getIdpersona() + "";
            informacion[x][UtilidadDocu.razonsocial] = listaDocutraza.get(x).getRazonsocial() + "";
            informacion[x][UtilidadDocu.serieguia] = listaDocutraza.get(x).getSerieguia() + "";
            informacion[x][UtilidadDocu.correlativo] = listaDocutraza.get(x).getCorrelativo() + "";
            informacion[x][UtilidadDocu.certificado] = listaDocutraza.get(x).getCertificado() + "";
            informacion[x][UtilidadDocu.sacos] = listaDocutraza.get(x).getSacos() + "";
            informacion[x][UtilidadDocu.kb] = df.format(listaDocutraza.get(x).getKb()) + "";
            informacion[x][UtilidadDocu.precio] = df.format(listaDocutraza.get(x).getPrecio()) + "";
            informacion[x][UtilidadDocu.kn] = df.format(listaDocutraza.get(x).getKn()) + "";
            informacion[x][UtilidadDocu.fairtrade] = listaDocutraza.get(x).getFairtrade() + "";
            informacion[x][UtilidadDocu.condicion] = listaDocutraza.get(x).getCondicion() + "";
            informacion[x][UtilidadDocu.fecha] = listaDocutraza.get(x).getFecha() + "";
            informacion[x][UtilidadDocu.estado] = listaDocutraza.get(x).getEstado() + "";
        }
        return informacion;
    }

    private void construirTablaDocutraza(String[] titulos, Object[][] data) {
        modelojt = new ModeloTabla(data, titulos);
        vistaCRUD.jtDocutraza.setModel(modelojt);
        filasTabla = vistaCRUD.jtDocutraza.getRowCount();
        columnasTabla = vistaCRUD.jtDocutraza.getColumnCount();
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(UtilidadDocu.sacos).setCellRenderer(new GestionCeldas("numerico"));
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(UtilidadDocu.kb).setCellRenderer(new GestionCeldas("numerico"));
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(UtilidadDocu.precio).setCellRenderer(new GestionCeldas("numerico"));
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(UtilidadDocu.kn).setCellRenderer(new GestionCeldas("numerico"));

        vistaCRUD.jtDocutraza.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(3).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(4).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(5).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(6).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(7).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(8).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(13).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(14).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(15).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(16).setCellRenderer(new GestionCeldas("texto"));

        vistaCRUD.jtDocutraza.getTableHeader().setReorderingAllowed(false);
        vistaCRUD.jtDocutraza.setRowHeight(25);//tamaño de las celdas
        vistaCRUD.jtDocutraza.setGridColor(new java.awt.Color(0, 0, 0));

        vistaCRUD.jtDocutraza.getColumnModel().getColumn(UtilidadDocu.iddocutraza).setPreferredWidth(40);
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(UtilidadDocu.idempresa).setPreferredWidth(40);
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(UtilidadDocu.idsucursal).setPreferredWidth(40);
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(UtilidadDocu.idcompracontrato).setPreferredWidth(40);
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(UtilidadDocu.idpersona).setPreferredWidth(40);
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(UtilidadDocu.razonsocial).setPreferredWidth(40);
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(UtilidadDocu.serieguia).setPreferredWidth(40);
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(UtilidadDocu.correlativo).setPreferredWidth(40);
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(UtilidadDocu.certificado).setPreferredWidth(40);
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(UtilidadDocu.sacos).setPreferredWidth(40);
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(UtilidadDocu.kb).setPreferredWidth(40);
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(UtilidadDocu.precio).setPreferredWidth(40);
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(UtilidadDocu.kn).setPreferredWidth(40);
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(UtilidadDocu.fairtrade).setPreferredWidth(40);
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(UtilidadDocu.condicion).setPreferredWidth(40);
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(UtilidadDocu.fecha).setPreferredWidth(70);
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(UtilidadDocu.estado).setPreferredWidth(60);

        JTableHeader jtableHeader = vistaCRUD.jtDocutraza.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        vistaCRUD.jtDocutraza.setTableHeader(jtableHeader);

        vistaCRUD.jScrollPane3.setViewportView(vistaCRUD.jtDocutraza);
    }

    private void validarSeleccionMouseCC(int fila) {
        UtilidadCC.filaSeleccionada = fila;

        //teniendo la fila entonces se obtiene el objeto correspondiente para enviarse como parammetro o imprimir la información
        CompraContrato CC = new CompraContrato();
        CC.setIdcompracontrato(Integer.valueOf(vistaCRUD.jtCompraContrato.getValueAt(fila, UtilidadCC.idcompracontrato).toString()));
        CC.setIdempresa(Integer.valueOf(vistaCRUD.jtCompraContrato.getValueAt(fila, UtilidadCC.idempresa).toString()));
        CC.setIdsucursal(Integer.valueOf(vistaCRUD.jtCompraContrato.getValueAt(fila, UtilidadCC.idsucursal).toString()));
        CC.setIdaperturacontrato(Integer.valueOf(vistaCRUD.jtCompraContrato.getValueAt(fila, UtilidadCC.idaperturacontrato).toString()));
        CC.setPeso(Double.valueOf(vistaCRUD.jtCompraContrato.getValueAt(fila, UtilidadCC.peso).toString()));
        CC.setPrecio(Double.valueOf(vistaCRUD.jtCompraContrato.getValueAt(fila, UtilidadCC.precio).toString()));
        CC.setImptotal(Double.valueOf(vistaCRUD.jtCompraContrato.getValueAt(fila, UtilidadCC.imptotal).toString()));
        CC.setFecha(vistaCRUD.jtCompraContrato.getValueAt(fila, UtilidadCC.fecha).toString());
        CC.setEstado(vistaCRUD.jtCompraContrato.getValueAt(fila, UtilidadCC.estado).toString());

        String info = "INFO DOCUMENTO\n";
        info += "id: " + CC.getIdcompracontrato() + "\n";
        info += "IdEmpresa: " + CC.getIdempresa() + "\n";
        info += "IdSucursal: " + CC.getIdsucursal() + "\n";
        info += "idApC: " + CC.getIdaperturacontrato() + "\n";
        info += "Peso: " + CC.getPeso() + "\n";
        info += "Precio: " + CC.getPrecio() + "\n";
        info += "Imptotal: " + CC.getImptotal() + "\n";
        info += "Fecha: " + CC.getFecha() + "\n";
        info += "Estado: " + CC.getEstado() + "\n";

        JOptionPane.showMessageDialog(null, info);
    }

    private void validarSeleccionMouseDT(int fila) {
        UtilidadDocu.filaSeleccionada = fila;

        //teniendo la fila entonces se obtiene el objeto correspondiente para enviarse como parammetro o imprimir la información
        Docutraza DT = new Docutraza();
        DT.setIddocutraza(Integer.valueOf(vistaCRUD.jtDocutraza.getValueAt(fila, UtilidadDocu.iddocutraza).toString()));
        DT.setIdempresa(Integer.valueOf(vistaCRUD.jtDocutraza.getValueAt(fila, UtilidadDocu.idempresa).toString()));
        DT.setIdsucursal(Integer.valueOf(vistaCRUD.jtDocutraza.getValueAt(fila, UtilidadDocu.idsucursal).toString()));
        DT.setIdcompracontrato(Integer.valueOf(vistaCRUD.jtDocutraza.getValueAt(fila, UtilidadDocu.idcompracontrato).toString()));
        DT.setIdpersona(Integer.valueOf(vistaCRUD.jtDocutraza.getValueAt(fila, UtilidadDocu.idpersona).toString()));
        DT.setRazonsocial(vistaCRUD.jtDocutraza.getValueAt(fila, UtilidadDocu.razonsocial).toString());
        DT.setSerieguia(vistaCRUD.jtDocutraza.getValueAt(fila, UtilidadDocu.serieguia).toString());
        DT.setCorrelativo(vistaCRUD.jtDocutraza.getValueAt(fila, UtilidadDocu.correlativo).toString());
        DT.setCertificado(vistaCRUD.jtDocutraza.getValueAt(fila, UtilidadDocu.certificado).toString());
        DT.setSacos(Integer.valueOf(vistaCRUD.jtDocutraza.getValueAt(fila, UtilidadDocu.sacos).toString()));
        DT.setKb(Double.valueOf(vistaCRUD.jtDocutraza.getValueAt(fila, UtilidadDocu.kb).toString().replace(".", "").replace(",", ".")));
        DT.setPrecio(Double.valueOf(vistaCRUD.jtDocutraza.getValueAt(fila, UtilidadDocu.precio).toString().replace(".", "").replace(",", ".")));
        DT.setKn(Double.valueOf(vistaCRUD.jtDocutraza.getValueAt(fila, UtilidadDocu.kn).toString().replace(".", "").replace(",", ".")));
        DT.setFairtrade(vistaCRUD.jtDocutraza.getValueAt(fila, UtilidadDocu.fairtrade).toString());
        DT.setCondicion(vistaCRUD.jtDocutraza.getValueAt(fila, UtilidadDocu.condicion).toString());
        DT.setFecha(vistaCRUD.jtDocutraza.getValueAt(fila, UtilidadDocu.fecha).toString());
        DT.setEstado(vistaCRUD.jtDocutraza.getValueAt(fila, UtilidadDocu.estado).toString());

        String info = "INFO DOCUMENTO\n";
        info += "id: " + DT.getIddocutraza() + "\n";
        info += "IdEmpresa: " + DT.getIdempresa() + "\n";
        info += "IdSucursal: " + DT.getIdsucursal() + "\n";
        info += "idCC: " + DT.getIdcompracontrato() + "\n";
        info += "idP: " + DT.getIdpersona() + "\n";
        info += "RazonSocial: " + DT.getRazonsocial() + "\n";
        info += "Serie: " + DT.getSerieguia() + "\n";
        info += "Correlativo: " + DT.getCorrelativo() + "\n";
        info += "Certificado: " + DT.getCertificado() + "\n";
        info += "Sacos: " + DT.getSacos() + "\n";
        info += "Kb: " + DT.getKb() + "\n";
        info += "Precio: " + DT.getPrecio() + "\n";
        info += "Kn: " + DT.getKn() + "\n";
        info += "Fairtrade: " + DT.getFairtrade() + "\n";
        info += "Condicion: " + DT.getCondicion() + "\n";
        info += "Fecha: " + DT.getFecha() + "\n";
        info += "Estado: " + DT.getEstado() + "\n";

        JOptionPane.showMessageDialog(null, info);
    }

    private void validarSeleccionMouseDoc(int fila) {
        UtilidadCC.filaSeleccionada = fila;

        //teniendo la fila entonces se obtiene el objeto correspondiente para enviarse como parammetro o imprimir la información
        Documento CC = new Documento();
        CC.setIddocumento(Integer.valueOf(vistaCRUD.jtAscDocumentos.getValueAt(fila, UtilidadDocumento.iddocumento).toString()));
        CC.setIdempresa(Integer.valueOf(vistaCRUD.jtAscDocumentos.getValueAt(fila, UtilidadDocumento.idempresa).toString()));
        CC.setIdsucursal(Integer.valueOf(vistaCRUD.jtAscDocumentos.getValueAt(fila, UtilidadDocumento.idsucursal).toString()));
        CC.setIddocutraza(Integer.valueOf(vistaCRUD.jtAscDocumentos.getValueAt(fila, UtilidadDocumento.iddocutraza).toString()));
        CC.setIdentificador(vistaCRUD.jtAscDocumentos.getValueAt(fila, UtilidadDocumento.identificador).toString());
        CC.setSerie(vistaCRUD.jtAscDocumentos.getValueAt(fila, UtilidadDocumento.serie).toString());
        CC.setCorrelativo(vistaCRUD.jtAscDocumentos.getValueAt(fila, UtilidadDocumento.correlativo).toString());
        CC.setFecha(vistaCRUD.jtAscDocumentos.getValueAt(fila, UtilidadDocumento.fecha).toString());
        CC.setEstado(vistaCRUD.jtAscDocumentos.getValueAt(fila, UtilidadDocumento.estado).toString());

        String info = "INFO DOCUMENTO\n";
        info += "id: " + CC.getIddocumento() + "\n";
        info += "IdEmpresa: " + CC.getIdempresa() + "\n";
        info += "IdSucursal: " + CC.getIdsucursal() + "\n";
        info += "idDocuTraza: " + CC.getIddocutraza() + "\n";
        info += "Identificador: " + CC.getIdentificador() + "\n";
        info += "Serie: " + CC.getSerie() + "\n";
        info += "Correlativo: " + CC.getCorrelativo() + "\n";
        info += "Fecha: " + CC.getFecha() + "\n";
        info += "Estado: " + CC.getEstado() + "\n";

        JOptionPane.showMessageDialog(null, info);
    }

    private void validarSeleccionMouseRgCC(int fila) {
        UtilidadCC.filaSeleccionada = fila;
        vistaCRUD.txtidCompContrato.setText(vistaCRUD.jtCompraContrato.getValueAt(fila, UtilidadCC.idcompracontrato).toString());
        vistaCRUD.txtKb.setText(vistaCRUD.jtCompraContrato.getValueAt(fila, UtilidadCC.peso).toString());
        vistaCRUD.txtIdDocutrza.setText("");
        vistaCRUD.txtIdDocutraza.setText("");
        vistaCRUD.txtKn.setText("");
        vistaCRUD.txtFairtrade.setText("");
        vistaCRUD.txtSerieGuia.setText("");
        vistaCRUD.txtCorrelativo.setText("");
        vistaCRUD.txtSacos.setText("");
        vistaCRUD.jdFecha.setDate(null);
        vistaCRUD.btnNTrack.setEnabled(true);
        vistaCRUD.btnEditDocutraza.setEnabled(false);
        vistaCRUD.btnRegTrack.setEnabled(false);
        vistaCRUD.btnNDocumento.setEnabled(false);
    }

    private void validarSeleccionMouseRgDT(int fila) {
        UtilidadDocu.filaSeleccionada = fila;
        vistaCRUD.txtIdDocutrza.setText(vistaCRUD.jtDocutraza.getValueAt(fila, UtilidadDocu.iddocutraza).toString());
        vistaCRUD.txtIdDocutraza.setText(vistaCRUD.jtDocutraza.getValueAt(fila, UtilidadDocu.iddocutraza).toString());
        vistaCRUD.txtidCompContrato.setText("");
        vistaCRUD.txtKb.setText("");
        vistaCRUD.btnNTrack.setEnabled(false);
        vistaCRUD.btnNDocumento.setEnabled(true);
        vistaCRUD.btnEditDocutraza.setEnabled(true);
        vistaCRUD.btnEditDocumento.setEnabled(false);
        vistaCRUD.btnRegDocumento.setEnabled(false);
        ///
        vistaCRUD.txtIddocumento.setText("");
        vistaCRUD.txtSerie.setText("");
        vistaCRUD.txtDocCorrelativo.setText("");
        vistaCRUD.txtFecha.setDate(null);
        vistaCRUD.txtIddocumento.setEnabled(false);
        vistaCRUD.txtSerie.setEnabled(false);
        vistaCRUD.txtDocCorrelativo.setEnabled(false);
        vistaCRUD.txtFecha.setEnabled(false);
        
        
        
        
        
        
        
        
        
        
        
        
        
        idempresa = Integer.valueOf(TraIni.lblEmpresa.getText());
        idsucursal = Integer.valueOf(TraIni.lblSucursal.getText());

        int dct = Integer.valueOf(vistaCRUD.jtDocutraza.getValueAt(fila, UtilidadDocu.iddocutraza).toString());
        reiniciarJTable(vistaCRUD.jtAscDocumentos);
        construirTablaDocumento(idempresa, idsucursal, dct);
        int iddocutraza = dao.DetalleDocutrazaDao.listIddetDocutraza(dct).get(0).getIddocutraza();

        if (iddocutraza == 0) {
            vistaCRUD.btnAsigCon.setEnabled(true);
            vistaCRUD.btnVerConf.setEnabled(false);
        } else {
            vistaCRUD.btnAsigCon.setEnabled(false);
            vistaCRUD.btnVerConf.setEnabled(true);
        }

    }

    private void validarSeleccionMouseRgDoc(int fila) {
        UtilidadDocu.filaSeleccionada = fila;
        vistaCRUD.txtIdDocutraza.setText("");
        vistaCRUD.btnNDocumento.setEnabled(false);
        vistaCRUD.btnEditDocumento.setEnabled(true);
        vistaCRUD.btnRegDocumento.setEnabled(false);
    }

    @Override
    public void mouseClicked(MouseEvent me) {

        if (me.getSource() == vistaCRUD.jtCompraContrato) {

            if (me.getClickCount() > 1) {
                int fila = vistaCRUD.jtCompraContrato.rowAtPoint(me.getPoint());
                int columna = vistaCRUD.jtCompraContrato.columnAtPoint(me.getPoint());
                validarSeleccionMouseCC(fila);
            }
            if (me.getClickCount() == 1) {
                int fila = vistaCRUD.jtCompraContrato.rowAtPoint(me.getPoint());
                int columna = vistaCRUD.jtCompraContrato.columnAtPoint(me.getPoint());
                vistaCRUD.btnNTrack.setEnabled(true);
                validarSeleccionMouseRgCC(fila);
            }
        }
        if (me.getSource() == vistaCRUD.jtDocutraza) {

            if (me.getClickCount() > 1) {
                int fila = vistaCRUD.jtDocutraza.rowAtPoint(me.getPoint());
                int columna = vistaCRUD.jtDocutraza.columnAtPoint(me.getPoint());
                validarSeleccionMouseDT(fila);
            }
            if (me.getClickCount() == 1) {
                int fila = vistaCRUD.jtDocutraza.rowAtPoint(me.getPoint());
                int columna = vistaCRUD.jtDocutraza.columnAtPoint(me.getPoint());
                validarSeleccionMouseRgDT(fila);

            }
        }
        if (me.getSource() == vistaCRUD.jtAscDocumentos) {

            if (me.getClickCount() > 1) {
                int fila = vistaCRUD.jtAscDocumentos.rowAtPoint(me.getPoint());
                int columna = vistaCRUD.jtAscDocumentos.columnAtPoint(me.getPoint());
                validarSeleccionMouseDoc(fila);
            }
            if (me.getClickCount() == 1) {
                int fila = vistaCRUD.jtAscDocumentos.rowAtPoint(me.getPoint());
                int columna = vistaCRUD.jtAscDocumentos.columnAtPoint(me.getPoint());
                validarSeleccionMouseRgDoc(fila);
            }
        }
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
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        if (ke.getSource() == vistaCRUD.txtKb || ke.getSource() == vistaCRUD.txtKn) {
//            if (vistaCRUD.txtKb.getText().isEmpty() || vistaCRUD.txtKn.getText().isEmpty()) {
//
//            } else {
//                if (vistaCRUD.txtKn.getText().length() == 4) {
//                    float tfcomp = Float.valueOf(vistaCRUD.txtKn.getText());
//                    vistaCRUD.txtKn.setText(df.format(tfcomp));
//                }
//                //float tpeso = Float.valueOf(vistaCRUD.txtKb.getText());
//
//            }
//        }
    }
}
