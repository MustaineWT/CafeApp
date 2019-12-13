/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Uti.GestionCeldas;
import Uti.GestionEncabezadoTabla;
import Uti.ModeloTabla;
import Uti.UtilidadCC;
import Uti.UtilidadDocu;
import static Uti.UtilidadesExtras.reiniciarJTable;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import modelo.CompraContrato;
import modelo.Docutraza;
import modelo.ListaCombos;
import vista.RDocutraza_Document;
import vista.TraIni;

/**
 *
 * @author MustainE
 */
public class ControladorCrudDocutraza implements ActionListener, MouseListener, KeyListener {

    RDocutraza_Document vistaCRUD = new RDocutraza_Document();
    DocutrazaDao modeloCRUD = new DocutrazaDao();
    ArrayList<CompraContrato> listaCompraContrato;
    ArrayList<Docutraza> listaDocutraza;
    ArrayList<Docutraza> idNuevoDocutraza;
    int idempresa;
    int idsucursal;
    ModeloTabla modelojt;
    private int filasTabla;
    private int columnasTabla;
    DecimalFormat formatea = new DecimalFormat("###,###.##");
    String texto;

    public ControladorCrudDocutraza(RDocutraza_Document vistaCRUD, DocutrazaDao modeloCRUD) {
        this.modeloCRUD = modeloCRUD;
        this.vistaCRUD = vistaCRUD;
        this.vistaCRUD.btnAsigConf.addActionListener(this);
        this.vistaCRUD.btnEditDocumento.addActionListener(this);
        this.vistaCRUD.btnEditDocutraza.addActionListener(this);
        this.vistaCRUD.btnNDocumento.addActionListener(this);
        this.vistaCRUD.btnNTrack.addActionListener(this);
        this.vistaCRUD.btnRegDocumento.addActionListener(this);
        this.vistaCRUD.btnRegTrack.addActionListener(this);
        this.vistaCRUD.btnVerConf.addActionListener(this);
        this.vistaCRUD.jtCompraContrato.addMouseListener(this);
        this.vistaCRUD.jtDocutraza.addMouseListener(this);

    }

    public void InicializarCrud() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        idempresa = Integer.valueOf(TraIni.lblEmpresa.getText());
        idsucursal = Integer.valueOf(TraIni.lblSucursal.getText());
        if (e.getSource() == vistaCRUD.btnNTrack) {
            idNuevoDocutraza = dao.DocutrazaDao.idNuevoDocutraza();
            vistaCRUD.txtIdDocutrza.setText(String.valueOf(idNuevoDocutraza.get(0).getIddocutraza() + 1));
            DefaultComboBoxModel value;
            value = new DefaultComboBoxModel();
            vistaCRUD.jcbCliente.setModel(value);

            for (int i = 0; i < ListaCombosDao.idCliente(idempresa, idsucursal).size(); i++) {
                value.addElement(new ListaCombos(Integer.valueOf(ListaCombosDao.idCliente(idempresa, idsucursal).get(i).getIdpersona()), ListaCombosDao.idCliente(idempresa, idsucursal).get(i).getRazonsocial()));
            }
            //aqui me quede.
            vistaCRUD.btnRegTrack.setEnabled(true);
            vistaCRUD.btnNTrack.setEnabled(false);
            vistaCRUD.btnEditDocutraza.setEnabled(false);
            vistaCRUD.txtIdDocutrza.setEnabled(false);
            vistaCRUD.txtidCompContrato.setEnabled(false);
            vistaCRUD.txtSerieGuia.setEnabled(true);
            vistaCRUD.txtCorrelativo.setEnabled(true);
            vistaCRUD.jdFecha.setEnabled(true);
            vistaCRUD.txtSacos.setEnabled(true);
            vistaCRUD.txtKb.setEnabled(true);
            vistaCRUD.txtKn.setEnabled(true);
            vistaCRUD.txtFairtrade.requestFocus();

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
                    double kb = Double.valueOf(vistaCRUD.txtKb.getText());
                    double kn = Double.valueOf(vistaCRUD.txtKn.getText());
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
                    double kb = Double.valueOf(vistaCRUD.txtKb.getText());
                    double kn = Double.valueOf(vistaCRUD.txtKn.getText());
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
                    double kb = DocutrazaDao.SelectDocutraza(idempresa, idsucursal, Integer.valueOf(id)).get(0).getKb();
                    double kn = DocutrazaDao.SelectDocutraza(idempresa, idsucursal, Integer.valueOf(id)).get(0).getKn();
                    String fairtrade = DocutrazaDao.SelectDocutraza(idempresa, idsucursal, Integer.valueOf(id)).get(0).getFairtrade();
                    String condicion = DocutrazaDao.SelectDocutraza(idempresa, idsucursal, Integer.valueOf(id)).get(0).getCondicion();
                    String fecha = DocutrazaDao.SelectDocutraza(idempresa, idsucursal, Integer.valueOf(id)).get(0).getFecha();
                    String estado = DocutrazaDao.SelectDocutraza(idempresa, idsucursal, Integer.valueOf(id)).get(0).getEstado();
                                        
                        vistaCRUD.txtIdDocutrza.setText(String.valueOf(iddocutraza));
                        vistaCRUD.txtidCompContrato.setText(String.valueOf(idcompcontrato));
                        vistaCRUD.jcbCliente.setSelectedItem(cliente);
                        vistaCRUD.txtSerieGuia.setText(serieguia);
                        vistaCRUD.txtCorrelativo.setText(correlativo);
                        vistaCRUD.jcbCondicion.setSelectedItem(condicion);
                        vistaCRUD.jcbCertificado.setSelectedItem(certificado);
                        vistaCRUD.jdFecha.setDate(Date.valueOf(fecha));
                        vistaCRUD.txtSacos.setText(String.valueOf(sacos));
                        vistaCRUD.txtKb.setText(String.valueOf(kb));
                        vistaCRUD.txtKn.setText(String.valueOf(kn));
                        vistaCRUD.txtFairtrade.setText(fairtrade);
                        vistaCRUD.txtSerieGuia.requestFocus();                                     

                    if (estado.equals("I")) {
                        vistaCRUD.jcbEstTrack.setSelectedIndex(0);
                    } else {
                        vistaCRUD.jcbEstTrack.setSelectedIndex(1);
                    }
                    //reiniciarJTable(vistaCRUD.jtDocutraza);
                    //construirTabla(idempresa, idsucursal);
                }
            } catch (HeadlessException ex) {

                JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente", " .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);

            }
        }
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
        Object[][] data = obtenerMatrizDatos(titulosList);
        construirTablaCompContrato(titulos, data);
    }

    public void construirTablabuscar(int empresa, int sucursal, String texto) {

        listaCompraContrato = dao.DocutrazaDao.listCompraContratoBuscar(empresa, sucursal,texto);        

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

        Object[][] data = obtenerMatrizDatos(titulosList);
        construirTablaCompContrato(titulos, data);
    }

    private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {

        String informacion[][] = new String[listaCompraContrato.size()][titulosList.size()];

        for (int x = 0; x < informacion.length; x++) {

            informacion[x][UtilidadCC.idcompracontrato] = listaCompraContrato.get(x).getIdcompracontrato() + "";
            informacion[x][UtilidadCC.idempresa] = listaCompraContrato.get(x).getIdempresa() + "";
            informacion[x][UtilidadCC.idsucursal] = listaCompraContrato.get(x).getIdsucursal() + "";
            informacion[x][UtilidadCC.idaperturacontrato] = listaCompraContrato.get(x).getIdaperturacontrato() + "";
            informacion[x][UtilidadCC.peso] = listaCompraContrato.get(x).getPeso() + "";
            informacion[x][UtilidadCC.precio] = listaCompraContrato.get(x).getPrecio() + "";
            informacion[x][UtilidadCC.imptotal] = listaCompraContrato.get(x).getImptotal() + "";
            informacion[x][UtilidadCC.fecha] = listaCompraContrato.get(x).getFecha()+ "";
            informacion[x][UtilidadCC.estado] = listaCompraContrato.get(x).getEstado() + "";
        }
        return informacion;
    }

    private void construirTablaCompContrato(String[] titulos, Object[][] data) {
        modelojt = new ModeloTabla(data, titulos);
        //se asigna el modelo a la tabla
        vistaCRUD.jtCompraContrato.setModel(modelojt);

        filasTabla = vistaCRUD.jtCompraContrato.getRowCount();
        columnasTabla = vistaCRUD.jtCompraContrato.getColumnCount();

        //se asigna el tipo de dato que tendrán las celdas de cada columna definida respectivamente para validar su personalización
        vistaCRUD.jtCompraContrato.getColumnModel().getColumn(UtilidadCC.peso).setCellRenderer(new GestionCeldas("numerico"));
        vistaCRUD.jtCompraContrato.getColumnModel().getColumn(UtilidadCC.precio).setCellRenderer(new GestionCeldas("numerico"));
        vistaCRUD.jtCompraContrato.getColumnModel().getColumn(UtilidadCC.imptotal).setCellRenderer(new GestionCeldas("numerico"));

        //se recorre y asigna el resto de celdas que serian las que almacenen datos de tipo texto
        // for (int i = 0; i < titulos.length - 8; i++) {//se resta 7 porque las ultimas 7 columnas se definen arriba
        //    System.out.println(i);
        vistaCRUD.jtCompraContrato.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtCompraContrato.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtCompraContrato.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtCompraContrato.getColumnModel().getColumn(3).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtCompraContrato.getColumnModel().getColumn(7).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtCompraContrato.getColumnModel().getColumn(8).setCellRenderer(new GestionCeldas("texto"));

        vistaCRUD.jtCompraContrato.getTableHeader().setReorderingAllowed(false);
        vistaCRUD.jtCompraContrato.setRowHeight(25);//tamaño de las celdas
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

        listaCompraContrato = dao.DocutrazaDao.listCompraContratoBuscar(empresa, sucursal,texto);        

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
            informacion[x][UtilidadDocu.correlativo] = listaDocutraza.get(x).getCorrelativo()+ "";
            informacion[x][UtilidadDocu.certificado] = listaDocutraza.get(x).getCertificado() + "";
            informacion[x][UtilidadDocu.sacos] = listaDocutraza.get(x).getSacos() + "";
            informacion[x][UtilidadDocu.kb] = listaDocutraza.get(x).getKb() + "";
            informacion[x][UtilidadDocu.kn] = listaDocutraza.get(x).getKn() + "";
            informacion[x][UtilidadDocu.fairtrade] = listaDocutraza.get(x).getFairtrade() + "";
            informacion[x][UtilidadDocu.condicion] = listaDocutraza.get(x).getCondicion() + "";
            informacion[x][UtilidadDocu.fecha] = listaDocutraza.get(x).getFecha() + "";
            informacion[x][UtilidadDocu.estado] = listaDocutraza.get(x).getEstado() + "";
            
        }
        return informacion;
    }

    private void construirTablaDocutraza(String[] titulos, Object[][] data) {
        modelojt = new ModeloTabla(data, titulos);
        //se asigna el modelo a la tabla
        vistaCRUD.jtDocutraza.setModel(modelojt);

        filasTabla = vistaCRUD.jtDocutraza.getRowCount();
        columnasTabla = vistaCRUD.jtDocutraza.getColumnCount();

        //se asigna el tipo de dato que tendrán las celdas de cada columna definida respectivamente para validar su personalización
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(UtilidadDocu.sacos).setCellRenderer(new GestionCeldas("numerico"));
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(UtilidadDocu.kb).setCellRenderer(new GestionCeldas("numerico"));
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(UtilidadDocu.kn).setCellRenderer(new GestionCeldas("numerico"));

        //se recorre y asigna el resto de celdas que serian las que almacenen datos de tipo texto
        // for (int i = 0; i < titulos.length - 8; i++) {//se resta 7 porque las ultimas 7 columnas se definen arriba
        //    System.out.println(i);
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(3).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(4).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(5).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(6).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(7).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(8).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(12).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(13).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(14).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtDocutraza.getColumnModel().getColumn(15).setCellRenderer(new GestionCeldas("texto"));

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
        DT.setKb(Double.valueOf(vistaCRUD.jtDocutraza.getValueAt(fila, UtilidadDocu.kb).toString()));
        DT.setKn(Double.valueOf(vistaCRUD.jtDocutraza.getValueAt(fila, UtilidadDocu.kn).toString()));
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
        info += "Kn: " + DT.getKn() + "\n";
        info += "Fairtrade: " + DT.getFairtrade() + "\n";
        info += "Condicion: " + DT.getCondicion() + "\n";
        info += "Fecha: " + DT.getFecha() + "\n";
        info += "Estado: " + DT.getEstado() + "\n";

        JOptionPane.showMessageDialog(null, info);
    }
 
    private void validarSeleccionMouseRgCC(int fila) {
        UtilidadCC.filaSeleccionada = fila;
        vistaCRUD.txtidCompContrato.setText(vistaCRUD.jtCompraContrato.getValueAt(fila, UtilidadCC.idcompracontrato).toString());   
    }
    private void validarSeleccionMouseRgDT(int fila) {
        UtilidadCC.filaSeleccionada = fila;
        vistaCRUD.txtidCompContrato.setText(vistaCRUD.jtCompraContrato.getValueAt(fila, UtilidadCC.idcompracontrato).toString());   
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
                vistaCRUD.btnNTrack.setEnabled(true);
                validarSeleccionMouseRgDT(fila);
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
    }

}
