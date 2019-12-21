package Controlador;

import Uti.GestionCeldas;
import static Uti.GestionCeldas.isNumeric;
import Uti.GestionEncabezadoTabla;
import Uti.ModeloTabla;
import Uti.UtilidadApC;
import Uti.UtilidadCC;
import static Uti.UtilidadesExtras.reiniciarJTable;
import dao.AperturaContratoDao;
import dao.CompraContratoDao;
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
import modelo.AperturaContrato;
import modelo.CompraContrato;
import modelo.ListaCombos;
import vista.RAperturaContrato;
import vista.RCompraContrato;
import vista.TraIni;

/**
 *
 * @author MustainE
 */
public class ControladorCrudCompraContrato implements ActionListener, MouseListener, KeyListener {

    RCompraContrato vistaCRUD = new RCompraContrato();
    CompraContratoDao modeloCRUD = new CompraContratoDao();
    ArrayList<AperturaContrato> listaAperturaContrato;
    ArrayList<CompraContrato> listaCompraContrato;
    ArrayList<CompraContrato> idNuevoCompraContrato;
    int idempresa;
    int idsucursal;
    ModeloTabla modelojt;
    private int filasTabla;
    private int columnasTabla;
    DecimalFormat formatea = new DecimalFormat("##,##0.00");
    String texto;

    public ControladorCrudCompraContrato(RCompraContrato vistaCRUD, CompraContratoDao modeloCRUD) {
        this.modeloCRUD = modeloCRUD;
        this.vistaCRUD = vistaCRUD;
        this.vistaCRUD.btnNuevo.addActionListener(this);
        this.vistaCRUD.btnEditar.addActionListener(this);
        this.vistaCRUD.btnRegistrar.addActionListener(this);
        this.vistaCRUD.jtAperturaContrato.addMouseListener(this);
        this.vistaCRUD.jtCompraContrato.addMouseListener(this);
        this.vistaCRUD.txtPeso.addKeyListener(this);
        this.vistaCRUD.txtPrecio.addKeyListener(this);
    }

    public void InicializarCrud() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        idempresa = Integer.valueOf(TraIni.lblEmpresa.getText());
        idsucursal = Integer.valueOf(TraIni.lblSucursal.getText());
        if (e.getSource() == vistaCRUD.btnNuevo) {
            if (Double.valueOf(vistaCRUD.txtTfaltantecomp.getText().replace(".", "").replace(",", ".")) <= 0) {
                //vistaCRUD.txtPeso.setEnabled(false);
                // vistaCRUD.btnRegistrar.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Ya no puede realizar más compras su apertura esta en cero faltante.");

            } else {
                vistaCRUD.txtPeso.setText("0.00");
                vistaCRUD.txtPrecio.setText("0.00");
                vistaCRUD.txtImptotal.setText("0.00");
                idNuevoCompraContrato = dao.CompraContratoDao.idNuevoCompraContrato();
                vistaCRUD.txtIdCC.setText(String.valueOf(idNuevoCompraContrato.get(0).getIdcompracontrato() + 1));
                vistaCRUD.btnRegistrar.setEnabled(true);
                vistaCRUD.btnNuevo.setEnabled(false);
                vistaCRUD.btnEditar.setEnabled(false);
                vistaCRUD.txtIdCC.setEnabled(false);
                vistaCRUD.txtIdApc.setEnabled(false);
                vistaCRUD.txtPrecio.setEnabled(true);
                vistaCRUD.txtPeso.setEnabled(true);
                vistaCRUD.txtImptotal.setEnabled(false);
                Calendar c2 = new GregorianCalendar();
                vistaCRUD.jdFecha.setCalendar(c2);
                vistaCRUD.jdFecha.setEnabled(true);
                vistaCRUD.txtPrecio.requestFocus();
            }
        }
        if (e.getSource() == vistaCRUD.btnRegistrar) {
            if (vistaCRUD.txtPrecio.getText().isEmpty() || vistaCRUD.txtPeso.getText().isEmpty() || vistaCRUD.txtImptotal.getText().isEmpty()
                    || vistaCRUD.jdFecha.getDate().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe Llenar todos los datos necesarios.");
            } else {
                if (vistaCRUD.btnRegistrar.getText() == "Guardar") {
                    int idcc = Integer.valueOf(vistaCRUD.txtIdCC.getText());
                    int idapc = Integer.valueOf(vistaCRUD.txtIdApc.getText());
                    double precio = Double.valueOf(vistaCRUD.txtPrecio.getText());
                    double peso = Double.valueOf(vistaCRUD.txtPeso.getText());
                    double imptotal = Double.valueOf(vistaCRUD.txtImptotal.getText());
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                    String fecha = formatoFecha.format(vistaCRUD.jdFecha.getDate());
                    String Estado = "";
                    if ((String) vistaCRUD.jcbEstado.getSelectedItem() == "Activo") {
                        Estado = "A";
                    }
                    if ((String) vistaCRUD.jcbEstado.getSelectedItem() == "Inactivo") {
                        Estado = "I";
                    }
                    String rptaRegistro = modeloCRUD.UpdateCompraContrato(idcc, idempresa, idsucursal, idapc, peso, precio, imptotal, fecha, Estado);
                    if (rptaRegistro != null) {
                        vistaCRUD.btnRegistrar.setEnabled(false);
                        vistaCRUD.btnNuevo.setEnabled(true);
                        vistaCRUD.btnEditar.setEnabled(true);
                        vistaCRUD.txtIdApc.setEnabled(false);
                        vistaCRUD.txtIdCC.setEnabled(false);
                        vistaCRUD.txtPeso.setEnabled(false);
                        vistaCRUD.txtPrecio.setEnabled(false);
                        vistaCRUD.txtImptotal.setEnabled(false);
                        vistaCRUD.jdFecha.setEnabled(false);
                        JOptionPane.showMessageDialog(null, rptaRegistro);
                        //vistaCRUD.txtIdApc.setText("");
                        vistaCRUD.txtIdCC.setText("");
                        vistaCRUD.txtPeso.setText("0.00");
                        vistaCRUD.txtPrecio.setText("0.00");
                        vistaCRUD.txtImptotal.setText("0.00");
                        vistaCRUD.jdFecha.setCalendar(null);
                        reiniciarJTable(vistaCRUD.jtCompraContrato);
                        //construirTablaApc(idempresa, idsucursal);
                        //construirTablaCc(idempresa, idsucursal,apc);
                        int apc = Integer.valueOf(vistaCRUD.txtIdApc.getText());
                        construirTablaCc(idempresa, idsucursal,apc);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo realizar la actualización.");
                    }
                } else {
                    int idcc = Integer.valueOf(vistaCRUD.txtIdCC.getText());
                    int idapc = Integer.valueOf(vistaCRUD.txtIdApc.getText());
                    double precio = Double.valueOf(vistaCRUD.txtPrecio.getText());
                    double peso = Double.valueOf(vistaCRUD.txtPeso.getText());
                    double imptotal = Double.valueOf(vistaCRUD.txtImptotal.getText().replace(".", "").replace(",", "."));
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                    String fecha = formatoFecha.format(vistaCRUD.jdFecha.getDate());
                    String Estado = "";
                    if ((String) vistaCRUD.jcbEstado.getSelectedItem() == "Activo") {
                        Estado = "A";
                    }
                    if ((String) vistaCRUD.jcbEstado.getSelectedItem() == "Inactivo") {
                        Estado = "I";
                    }
                    String rptaRegistro = modeloCRUD.insertCompraContrato(idcc, idempresa, idsucursal, idapc, peso, precio, imptotal, fecha, Estado);
                    if (rptaRegistro != null) {
                        vistaCRUD.btnRegistrar.setEnabled(false);
                        vistaCRUD.btnNuevo.setEnabled(true);
                        vistaCRUD.btnEditar.setEnabled(true);
                        vistaCRUD.txtIdApc.setEnabled(false);
                        vistaCRUD.txtIdCC.setEnabled(false);
                        vistaCRUD.txtPeso.setEnabled(false);
                        vistaCRUD.txtPrecio.setEnabled(false);
                        vistaCRUD.txtImptotal.setEnabled(false);
                        vistaCRUD.jdFecha.setEnabled(false);
                        JOptionPane.showMessageDialog(null, rptaRegistro);
                        //vistaCRUD.txtIdApc.setText("");
                        vistaCRUD.txtIdCC.setText("");
                        vistaCRUD.txtPeso.setText("0.00");
                        vistaCRUD.txtPrecio.setText("0.00");
                        vistaCRUD.txtImptotal.setText("0.00");
                        vistaCRUD.jdFecha.setCalendar(null);
                        reiniciarJTable(vistaCRUD.jtCompraContrato);
                        //construirTablaApc(idempresa, idsucursal);
                        int apc = Integer.valueOf(vistaCRUD.txtIdApc.getText());
                        construirTablaCc(idempresa, idsucursal,apc);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo realizar el registro.");
                    }
                }
            }

        }
        if (e.getSource() == vistaCRUD.btnEditar) {
            vistaCRUD.btnRegistrar.setEnabled(true);
            vistaCRUD.btnRegistrar.setText("Guardar");

            int filaseleccionada;

            try {

                filaseleccionada = vistaCRUD.jtCompraContrato.getSelectedRow();

                if (filaseleccionada == -1) {

                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");

                } else {

                    DefaultTableModel modelotabla = (DefaultTableModel) vistaCRUD.jtAperturaContrato.getModel();

                    String id = (String) modelotabla.getValueAt(filaseleccionada, 0);

                    int idapcontrato = CompraContratoDao.SelectCompraContrato(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIdcompracontrato();
                    int idemp = CompraContratoDao.SelectCompraContrato(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIdempresa();
                    int idsuc = CompraContratoDao.SelectCompraContrato(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIdsucursal();
                    int idapc = CompraContratoDao.SelectCompraContrato(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIdaperturacontrato();
                    double peso = CompraContratoDao.SelectCompraContrato(idempresa, idsucursal, Integer.valueOf(id)).get(0).getPeso();
                    double precio = CompraContratoDao.SelectCompraContrato(idempresa, idsucursal, Integer.valueOf(id)).get(0).getPrecio();
                    double imptotal = CompraContratoDao.SelectCompraContrato(idempresa, idsucursal, Integer.valueOf(id)).get(0).getImptotal();
                    String Fecha = CompraContratoDao.SelectCompraContrato(idempresa, idsucursal, Integer.valueOf(id)).get(0).getFecha();
                    String Estado = CompraContratoDao.SelectCompraContrato(idempresa, idsucursal, Integer.valueOf(id)).get(0).getEstado();
                    vistaCRUD.txtIdCC.setText(String.valueOf(idapcontrato));
                    vistaCRUD.txtIdApc.setText(String.valueOf(idapc));
                    vistaCRUD.txtPrecio.setText(String.valueOf(precio));
                    vistaCRUD.txtPeso.setText(String.valueOf(peso));
                    vistaCRUD.txtImptotal.setText(String.valueOf(imptotal));
                    vistaCRUD.jdFecha.setDate(Date.valueOf(Fecha));
                    vistaCRUD.btnNuevo.setEnabled(false);
                    vistaCRUD.btnEditar.setEnabled(false);
                    vistaCRUD.txtIdCC.setEnabled(false);
                    vistaCRUD.txtIdApc.setEnabled(false);
                    vistaCRUD.txtPeso.setEnabled(true);
                    vistaCRUD.txtPrecio.setEnabled(true);
                    vistaCRUD.txtImptotal.setEnabled(true);
                    vistaCRUD.jdFecha.setEnabled(true);
                    vistaCRUD.txtPrecio.requestFocus();

                    if (Estado.equals("I")) {
                        vistaCRUD.jcbEstado.setSelectedIndex(0);
                    } else {
                        vistaCRUD.jcbEstado.setSelectedIndex(1);
                    }
                    //reiniciarJTable(vistaCRUD.jtAperturaContrato);
                    //construirTabla(idempresa, idsucursal);
                }
            } catch (HeadlessException ex) {

                JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente", " .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    public void construirTablaApc(int empresa, int sucursal) {

        listaAperturaContrato = dao.AperturaContratoDao.listAperturaContrato(empresa, sucursal);

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
        Object[][] data = obtenerMatrizDatosApc(titulosList);
        construirTablaApc(titulos, data);
    }

    public void construirTablabuscarApc() {

        listaAperturaContrato = dao.AperturaContratoDao.listAperturaContratoBuscar(idempresa, idsucursal, texto);

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

        Object[][] data = obtenerMatrizDatosApc(titulosList);
        construirTablaApc(titulos, data);
    }

    private Object[][] obtenerMatrizDatosApc(ArrayList<String> titulosList) {

        String informacion[][] = new String[listaAperturaContrato.size()][titulosList.size()];

        for (int x = 0; x < informacion.length; x++) {

            informacion[x][UtilidadApC.idaperturacontrato] = listaAperturaContrato.get(x).getIdaperturacontrato() + "";
            informacion[x][UtilidadApC.idempresa] = listaAperturaContrato.get(x).getIdempresa() + "";
            informacion[x][UtilidadApC.idsucursal] = listaAperturaContrato.get(x).getIdsucursal() + "";
            informacion[x][UtilidadApC.peso] = listaAperturaContrato.get(x).getPeso() + "";
            informacion[x][UtilidadApC.precio] = listaAperturaContrato.get(x).getPrecio() + "";
            informacion[x][UtilidadApC.imptotal] = listaAperturaContrato.get(x).getImptotal() + "";
            informacion[x][UtilidadApC.calidad] = listaAperturaContrato.get(x).getCalidad() + "";
            informacion[x][UtilidadApC.humedad] = listaAperturaContrato.get(x).getHumedad() + "";
            informacion[x][UtilidadApC.contrato] = listaAperturaContrato.get(x).getContrato() + "";
            informacion[x][UtilidadApC.cliente] = listaAperturaContrato.get(x).getCliente() + "";
            informacion[x][UtilidadApC.fecha] = listaAperturaContrato.get(x).getFecha() + "";
            informacion[x][UtilidadApC.estado] = listaAperturaContrato.get(x).getEstado() + "";
        }
        return informacion;
    }

    private void construirTablaApc(String[] titulos, Object[][] data) {
        modelojt = new ModeloTabla(data, titulos);
        //se asigna el modelo a la tabla
        vistaCRUD.jtAperturaContrato.setModel(modelojt);

        filasTabla = vistaCRUD.jtAperturaContrato.getRowCount();
        columnasTabla = vistaCRUD.jtAperturaContrato.getColumnCount();

        //se asigna el tipo de dato que tendrán las celdas de cada columna definida respectivamente para validar su personalización
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.peso).setCellRenderer(new GestionCeldas("numerico"));
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.precio).setCellRenderer(new GestionCeldas("numerico"));
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.imptotal).setCellRenderer(new GestionCeldas("numerico"));

        //se recorre y asigna el resto de celdas que serian las que almacenen datos de tipo texto
        // for (int i = 0; i < titulos.length - 8; i++) {//se resta 7 porque las ultimas 7 columnas se definen arriba
        //    System.out.println(i);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(6).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(7).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(8).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(9).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(10).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(11).setCellRenderer(new GestionCeldas("texto"));

        vistaCRUD.jtAperturaContrato.getTableHeader().setReorderingAllowed(false);
        vistaCRUD.jtAperturaContrato.setRowHeight(25);//tamaño de las celdas
        vistaCRUD.jtAperturaContrato.setGridColor(new java.awt.Color(0, 0, 0));

        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.idaperturacontrato).setPreferredWidth(40);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.idempresa).setPreferredWidth(40);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.idsucursal).setPreferredWidth(40);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.peso).setPreferredWidth(60);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.precio).setPreferredWidth(60);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.imptotal).setPreferredWidth(60);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.calidad).setPreferredWidth(50);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.humedad).setPreferredWidth(70);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.contrato).setPreferredWidth(70);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.cliente).setPreferredWidth(70);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.fecha).setPreferredWidth(50);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.estado).setPreferredWidth(60);

        JTableHeader jtableHeader = vistaCRUD.jtAperturaContrato.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        vistaCRUD.jtAperturaContrato.setTableHeader(jtableHeader);

        vistaCRUD.jScrollPane2.setViewportView(vistaCRUD.jtAperturaContrato);
    }

    public void construirTablaCc(int empresa, int sucursal, int apc) {

        listaCompraContrato = dao.CompraContratoDao.listCompraContrato(empresa, sucursal, apc);

        ArrayList<String> titulosList = new ArrayList<>();

        titulosList.add("Id");
        titulosList.add("Emp");
        titulosList.add("Suc");
        titulosList.add("IdApc");
        titulosList.add("Peso");
        titulosList.add("Precio");
        titulosList.add("ImpTotal");
        titulosList.add("Fecha");
        titulosList.add("Est");

        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }
        Object[][] data = obtenerMatrizDatosCc(titulosList);
        construirTablaCc(titulos, data);
    }

    public void construirTablabuscarCc() {

        listaCompraContrato = dao.CompraContratoDao.listCompraContratoBuscar(idempresa, idsucursal, texto);

        ArrayList<String> titulosList = new ArrayList<>();

        titulosList.add("Id");
        titulosList.add("Emp");
        titulosList.add("Suc");
        titulosList.add("Peso");
        titulosList.add("Precio");
        titulosList.add("ImpTotal");
        titulosList.add("Fecha");
        titulosList.add("Est");

        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }

        Object[][] data = obtenerMatrizDatosCc(titulosList);
        construirTablaCc(titulos, data);
    }

    private Object[][] obtenerMatrizDatosCc(ArrayList<String> titulosList) {

        String informacion[][] = new String[listaCompraContrato.size()][titulosList.size()];

        for (int x = 0; x < informacion.length; x++) {

            informacion[x][UtilidadCC.idcompracontrato] = listaCompraContrato.get(x).getIdcompracontrato() + "";
            informacion[x][UtilidadCC.idempresa] = listaCompraContrato.get(x).getIdempresa() + "";
            informacion[x][UtilidadCC.idsucursal] = listaCompraContrato.get(x).getIdsucursal() + "";
            informacion[x][UtilidadCC.idaperturacontrato] = listaCompraContrato.get(x).getIdaperturacontrato() + "";
            informacion[x][UtilidadCC.peso] = listaCompraContrato.get(x).getPeso() + "";
            informacion[x][UtilidadCC.precio] = listaCompraContrato.get(x).getPrecio() + "";
            informacion[x][UtilidadCC.imptotal] = listaCompraContrato.get(x).getImptotal() + "";
            informacion[x][UtilidadCC.fecha] = listaCompraContrato.get(x).getFecha() + "";
            informacion[x][UtilidadCC.estado] = listaCompraContrato.get(x).getEstado() + "";
        }
        return informacion;
    }

    private void construirTablaCc(String[] titulos, Object[][] data) {
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
        vistaCRUD.jtCompraContrato.getColumnModel().getColumn(UtilidadCC.idaperturacontrato).setPreferredWidth(40);
        vistaCRUD.jtCompraContrato.getColumnModel().getColumn(UtilidadCC.peso).setPreferredWidth(60);
        vistaCRUD.jtCompraContrato.getColumnModel().getColumn(UtilidadCC.precio).setPreferredWidth(60);
        vistaCRUD.jtCompraContrato.getColumnModel().getColumn(UtilidadCC.imptotal).setPreferredWidth(60);
        vistaCRUD.jtCompraContrato.getColumnModel().getColumn(UtilidadCC.fecha).setPreferredWidth(50);
        vistaCRUD.jtCompraContrato.getColumnModel().getColumn(UtilidadCC.estado).setPreferredWidth(60);

        JTableHeader jtableHeader = vistaCRUD.jtCompraContrato.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        vistaCRUD.jtCompraContrato.setTableHeader(jtableHeader);

        vistaCRUD.jScrollPane1.setViewportView(vistaCRUD.jtCompraContrato);
    }

    private void validarSeleccionMouseCC(int fila) {
        UtilidadApC.filaSeleccionada = fila;

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
        info += "id: " + CC.getIdaperturacontrato() + "\n";
        info += "Peso: " + CC.getPeso() + "\n";
        info += "Precio: " + CC.getPrecio() + "\n";
        info += "ImpTotal: " + CC.getImptotal() + "\n";
        info += "Fecha: " + CC.getFecha() + "\n";
        info += "Estado: " + CC.getEstado() + "\n";

        JOptionPane.showMessageDialog(null, info);
    }

    private void validarSeleccionMouseAPC(int fila) {
        UtilidadApC.filaSeleccionada = fila;

        //teniendo la fila entonces se obtiene el objeto correspondiente para enviarse como parammetro o imprimir la información
        AperturaContrato ApC = new AperturaContrato();
        ApC.setIdaperturacontrato(Integer.valueOf(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.idaperturacontrato).toString()));
        ApC.setIdempresa(Integer.valueOf(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.idempresa).toString()));
        ApC.setIdsucursal(Integer.valueOf(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.idsucursal).toString()));
        ApC.setPeso(Double.valueOf(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.peso).toString()));
        ApC.setPrecio(Double.valueOf(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.precio).toString()));
        ApC.setImptotal(Double.valueOf(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.imptotal).toString()));
        ApC.setCalidad(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.calidad).toString());
        ApC.setHumedad(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.humedad).toString());
        ApC.setContrato(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.contrato).toString());
        ApC.setCliente(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.cliente).toString());
        ApC.setFecha(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.fecha).toString());
        ApC.setEstado(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.estado).toString());

        String info = "INFO DOCUMENTO\n";
        info += "id: " + ApC.getIdaperturacontrato() + "\n";
        info += "IdEmpresa: " + ApC.getIdempresa() + "\n";
        info += "IdSucursal: " + ApC.getIdsucursal() + "\n";
        info += "Peso: " + ApC.getPeso() + "\n";
        info += "Precio: " + ApC.getPrecio() + "\n";
        info += "Precio: " + ApC.getImptotal() + "\n";
        info += "Calidad: " + ApC.getCalidad() + "\n";
        info += "Humedad: " + ApC.getHumedad() + "\n";
        info += "Contrato: " + ApC.getContrato() + "\n";
        info += "Cliente: " + ApC.getCliente() + "\n";
        info += "Fecha: " + ApC.getFecha() + "\n";
        info += "Estado: " + ApC.getEstado() + "\n";

        JOptionPane.showMessageDialog(null, info);
    }

    private void validarSeleccionMouseCc(int fila) {
        UtilidadCC.filaSeleccionada = fila;
        vistaCRUD.txtIdCC.setText(vistaCRUD.jtCompraContrato.getValueAt(fila, UtilidadCC.idcompracontrato).toString());
        vistaCRUD.txtIdApc.setText("");
    }

    private void validarSeleccionMouseApc(int fila) {
        UtilidadCC.filaSeleccionada = fila;
        vistaCRUD.txtIdApc.setText(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.idaperturacontrato).toString());
        vistaCRUD.txtIdCC.setText("");
        double p = 0;
        double t = 0;
        double peso = Double.valueOf(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.peso).toString());
        if (vistaCRUD.jtCompraContrato.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtCompraContrato.getRowCount(); i++) {
                String valor4 = vistaCRUD.jtCompraContrato.getValueAt(i, 4).toString();

                if (isNumeric(valor4) == true) {
                    p = Double.parseDouble(valor4);
                }
                t += p;
            }
            vistaCRUD.txtTcompraContrato.setText(String.format("%.2f", t));
            vistaCRUD.txtTfaltantecomp.setText(String.valueOf(String.format("%.2f", (peso - t))));
        } else {
            double valor4 = Double.valueOf(vistaCRUD.jtAperturaContrato.getValueAt(fila, 3).toString());
            vistaCRUD.txtTcompraContrato.setText(formatea.format(valor4));
            vistaCRUD.txtTfaltantecomp.setText(vistaCRUD.txtTcompraContrato.getText());
        }

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
                vistaCRUD.btnNuevo.setEnabled(true);
                validarSeleccionMouseCc(fila);

            }
        }
        if (me.getSource() == vistaCRUD.jtAperturaContrato) {

            if (me.getClickCount() > 1) {
                int fila = vistaCRUD.jtAperturaContrato.rowAtPoint(me.getPoint());
                int columna = vistaCRUD.jtAperturaContrato.columnAtPoint(me.getPoint());
                validarSeleccionMouseAPC(fila);
            }

            if (me.getClickCount() == 1) {

                idempresa = Integer.valueOf(TraIni.lblEmpresa.getText());
                idsucursal = Integer.valueOf(TraIni.lblSucursal.getText());
                int fila = vistaCRUD.jtAperturaContrato.rowAtPoint(me.getPoint());
                int columna = vistaCRUD.jtAperturaContrato.columnAtPoint(me.getPoint());
                vistaCRUD.btnNuevo.setEnabled(true);
                int apc = Integer.valueOf(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.idaperturacontrato).toString());
                
                reiniciarJTable(vistaCRUD.jtCompraContrato);
                construirTablaCc(idempresa, idsucursal, apc);
                validarSeleccionMouseApc(fila);

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
        if (ke.getSource() == vistaCRUD.txtPeso || ke.getSource() == vistaCRUD.txtPrecio) {
            try {
                //texto = vistaCRUD.txtBuscador.getText();
                //construirTablabuscar();
                if (vistaCRUD.txtPeso.getText().isEmpty() || vistaCRUD.txtPrecio.getText().isEmpty()) {

                } else {
                    long rt = (long) (Double.valueOf(vistaCRUD.txtPeso.getText()) * Double.valueOf(vistaCRUD.txtPrecio.getText()));
                    vistaCRUD.txtImptotal.setText(String.valueOf(formatea.format(rt)));//                   
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "NO SE ENCUENTRA EL REGISTRO");
            }
            if (vistaCRUD.txtPeso.getText().isEmpty() || vistaCRUD.txtPrecio.getText().isEmpty()) {
            } else {
                double tpeso = Double.valueOf(vistaCRUD.txtPeso.getText());
                double tfcomp = Double.valueOf(vistaCRUD.txtTfaltantecomp.getText().replace(".", "").replace(",", "."));

                long v = (long) (tfcomp - tpeso);
                if (tpeso > tfcomp) {
                    vistaCRUD.btnRegistrar.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "El total del peso ingreso excede en: " + v + " el peso faltante de la Apertura de contrato.");
                } else {
                    vistaCRUD.btnRegistrar.setEnabled(true);
                }
            }

        }
    }

}
