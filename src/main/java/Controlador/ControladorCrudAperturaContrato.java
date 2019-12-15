package Controlador;

import Uti.GestionCeldas;
import Uti.GestionEncabezadoTabla;
import Uti.ModeloTabla;
import Uti.UtilidadApC;
import static Uti.UtilidadesExtras.reiniciarJTable;
import dao.AperturaContratoDao;
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
import modelo.ListaCombos;
import vista.RAperturaContrato;
import vista.TraIni;

/**
 *
 * @author MustainE
 */
public class ControladorCrudAperturaContrato implements ActionListener, MouseListener, KeyListener {

    RAperturaContrato vistaCRUD = new RAperturaContrato();
    AperturaContratoDao modeloCRUD = new AperturaContratoDao();
    ArrayList<AperturaContrato> listaAperturaContrato;
    ArrayList<AperturaContrato> idNuevoAperturaContrato;
    int idempresa;
    int idsucursal;
    ModeloTabla modelojt;
    private int filasTabla;
    private int columnasTabla;
    DecimalFormat formatea = new DecimalFormat("###,###.##");
    String texto;

    public ControladorCrudAperturaContrato(RAperturaContrato vistaCRUD, AperturaContratoDao modeloCRUD) {
        this.modeloCRUD = modeloCRUD;
        this.vistaCRUD = vistaCRUD;
        this.vistaCRUD.btnNuevo.addActionListener(this);
        this.vistaCRUD.btnEditar.addActionListener(this);
        this.vistaCRUD.btnRegistrar.addActionListener(this);
        this.vistaCRUD.jtAperturaContrato.addMouseListener(this);
    }

    public void InicializarCrud() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        idempresa = Integer.valueOf(TraIni.lblEmpresa.getText());
        idsucursal = Integer.valueOf(TraIni.lblSucursal.getText());
        if (e.getSource() == vistaCRUD.btnNuevo) {
            idNuevoAperturaContrato = dao.AperturaContratoDao.idNuevoAperturaContrato();
            vistaCRUD.txtIdApC.setText(String.valueOf(idNuevoAperturaContrato.get(0).getIdaperturacontrato() + 1));
            DefaultComboBoxModel value;
            value = new DefaultComboBoxModel();
            vistaCRUD.jcbPersona.setModel(value);

            for (int i = 0; i < ListaCombosDao.idCliente(idempresa, idsucursal).size(); i++) {
                value.addElement(new ListaCombos(Integer.valueOf(ListaCombosDao.idCliente(idempresa, idsucursal).get(i).getIdpersona()), ListaCombosDao.idCliente(idempresa, idsucursal).get(i).getRazonsocial()));
            }
            vistaCRUD.btnRegistrar.setEnabled(true);
            vistaCRUD.btnNuevo.setEnabled(false);
            vistaCRUD.btnEditar.setEnabled(false);
            vistaCRUD.txtIdApC.setEnabled(false);
            vistaCRUD.txtPeso.setEnabled(true);
            vistaCRUD.txtPrecio.setEnabled(true);
            vistaCRUD.txtImpTotal.setEnabled(false);
            vistaCRUD.txtContrato.setEnabled(true);
            vistaCRUD.txtCalidad.setEnabled(true);
            vistaCRUD.txtHumedad.setEnabled(true);
            Calendar c2 = new GregorianCalendar();
            vistaCRUD.txtFecha.setCalendar(c2);
            vistaCRUD.txtFecha.setEnabled(true);
            vistaCRUD.txtPrecio.requestFocus();

        }
        if (e.getSource() == vistaCRUD.btnRegistrar) {
            if (vistaCRUD.txtIdApC.getText().isEmpty()
                    || vistaCRUD.txtPeso.getText().isEmpty() || vistaCRUD.txtPrecio.getText().isEmpty()|| vistaCRUD.txtImpTotal.getText().isEmpty()
                    || vistaCRUD.txtContrato.getText().isEmpty()|| vistaCRUD.txtCalidad.getText().isEmpty()|| vistaCRUD.txtHumedad.getText().isEmpty()
                    || vistaCRUD.txtFecha.getDate().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe Llenar todos los datos necesarios.");
            } else {
                if (vistaCRUD.btnRegistrar.getText() == "Guardar") {
                    int idapc = Integer.valueOf(vistaCRUD.txtIdApC.getText());
                    ListaCombos cli = (ListaCombos) vistaCRUD.jcbPersona.getSelectedItem();
                    int cliente = cli.getIdpersona();
                    double peso = Double.valueOf(vistaCRUD.txtPeso.getText());
                    double precio = Double.valueOf(vistaCRUD.txtPrecio.getText());
                    double imptotal = Double.valueOf(vistaCRUD.txtImpTotal.getText());
                    String contrato = vistaCRUD.txtContrato.getText();
                    String calidad = vistaCRUD.txtCalidad.getText();
                    String humedad = vistaCRUD.txtHumedad.getText();
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                    String fecha = formatoFecha.format(vistaCRUD.txtFecha.getDate());
                    System.out.println(fecha);
                    String Estado = "";
                    if ((String) vistaCRUD.jcbEstado.getSelectedItem() == "Iniciado") {
                        Estado = "I";
                    }
                    if ((String) vistaCRUD.jcbEstado.getSelectedItem() == "Anulado") {
                        Estado = "A";
                    }
                    String rptaRegistro = modeloCRUD.UpdateAperturaContrato(idapc, idempresa, idsucursal, peso, precio,imptotal, calidad, humedad, contrato, cliente, fecha, Estado);
                    if (rptaRegistro != null) {
                        vistaCRUD.btnRegistrar.setEnabled(false);
                        vistaCRUD.btnNuevo.setEnabled(true);
                        vistaCRUD.btnEditar.setEnabled(true);
                        vistaCRUD.txtIdApC.setEnabled(false);
                        vistaCRUD.txtPeso.setEnabled(false);
                        vistaCRUD.txtPrecio.setEnabled(false);
                        vistaCRUD.txtImpTotal.setEnabled(false);
                        vistaCRUD.txtContrato.setEnabled(false);
                        vistaCRUD.txtCalidad.setEnabled(false);
                        vistaCRUD.txtHumedad.setEnabled(false);
                        vistaCRUD.txtFecha.setEnabled(false);
                        JOptionPane.showMessageDialog(null, rptaRegistro);
                        vistaCRUD.txtIdApC.setText("");
                        vistaCRUD.txtPeso.setText("");
                        vistaCRUD.txtPrecio.setText("");
                        vistaCRUD.txtImpTotal.setText("");
                        vistaCRUD.txtContrato.setText("");
                        vistaCRUD.txtCalidad.setText("");
                        vistaCRUD.txtHumedad.setText("");
                        vistaCRUD.txtFecha.setCalendar(null);
                        reiniciarJTable(vistaCRUD.jtAperturaContrato);
                        construirTabla(idempresa, idsucursal);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo realizar la actualización.");
                    }
                } else {
                    int idapc = Integer.valueOf(vistaCRUD.txtIdApC.getText());
                    ListaCombos cli = (ListaCombos) vistaCRUD.jcbPersona.getSelectedItem();
                    int cliente = cli.getIdpersona();
                    double peso = Double.valueOf(vistaCRUD.txtPeso.getText());
                    double precio = Double.valueOf(vistaCRUD.txtPrecio.getText());
                    double imptotal = Double.valueOf(vistaCRUD.txtImpTotal.getText());
                    String contrato = vistaCRUD.txtCalidad.getText();
                    String calidad = vistaCRUD.txtCalidad.getText();
                    String humedad = vistaCRUD.txtHumedad.getText();
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                    String fecha = formatoFecha.format(vistaCRUD.txtFecha.getDate());
                    System.out.println(fecha);
                    String Estado = "";
                    if ((String) vistaCRUD.jcbEstado.getSelectedItem() == "Iniciado") {
                        Estado = "I";
                    }
                    if ((String) vistaCRUD.jcbEstado.getSelectedItem() == "Anulado") {
                        Estado = "A";
                    }
                    String rptaRegistro = modeloCRUD.insertAperturaContrato(idapc, idempresa, idsucursal, peso, precio,imptotal, calidad, humedad, contrato, cliente, fecha, Estado);
                    if (rptaRegistro != null) {
                        vistaCRUD.btnRegistrar.setEnabled(true);
                        vistaCRUD.btnNuevo.setEnabled(true);
                        vistaCRUD.btnEditar.setEnabled(true);
                        vistaCRUD.txtIdApC.setEnabled(false);
                        vistaCRUD.txtPeso.setEnabled(false);
                        vistaCRUD.txtPrecio.setEnabled(false);
                        vistaCRUD.txtImpTotal.setEnabled(false);
                        vistaCRUD.txtContrato.setEnabled(false);
                        vistaCRUD.txtCalidad.setEnabled(false);
                        vistaCRUD.txtHumedad.setEnabled(false);
                        vistaCRUD.txtFecha.setEnabled(false);
                        JOptionPane.showMessageDialog(null, rptaRegistro);
                        vistaCRUD.txtIdApC.setText("");
                        vistaCRUD.txtPeso.setText("");
                        vistaCRUD.txtPrecio.setText("");
                        vistaCRUD.txtImpTotal.setText("");
                        vistaCRUD.txtContrato.setText("");
                        vistaCRUD.txtCalidad.setText("");
                        vistaCRUD.txtHumedad.setText("");
                        vistaCRUD.txtFecha.setCalendar(null);
                        reiniciarJTable(vistaCRUD.jtAperturaContrato);
                        construirTabla(idempresa, idsucursal);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo realizar el registro.");
                    }
                }
            }

        }
        if (e.getSource() == vistaCRUD.btnEditar) {
            vistaCRUD.btnRegistrar.setEnabled(true);
            vistaCRUD.btnRegistrar.setText("Guardar");

            DefaultComboBoxModel value;
            value = new DefaultComboBoxModel();
            vistaCRUD.jcbPersona.setModel(value);

            for (int i = 0; i < ListaCombosDao.idCliente(idempresa, idsucursal).size(); i++) {
                value.addElement(new ListaCombos(Integer.valueOf(ListaCombosDao.idCliente(idempresa, idsucursal).get(i).getIdpersona()), ListaCombosDao.idCliente(idempresa, idsucursal).get(i).getRazonsocial()));
            }

            int filaseleccionada;

            try {

                filaseleccionada = vistaCRUD.jtAperturaContrato.getSelectedRow();

                if (filaseleccionada == -1) {

                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");

                } else {

                    DefaultTableModel modelotabla = (DefaultTableModel) vistaCRUD.jtAperturaContrato.getModel();

                    String id = (String) modelotabla.getValueAt(filaseleccionada, 0);

                    int idapcontrato = AperturaContratoDao.SelectAperturaContrato(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIdaperturacontrato();
                    int idemp = AperturaContratoDao.SelectAperturaContrato(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIdempresa();
                    int idsuc = AperturaContratoDao.SelectAperturaContrato(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIdsucursal();
                    double peso = AperturaContratoDao.SelectAperturaContrato(idempresa, idsucursal, Integer.valueOf(id)).get(0).getPeso();
                    double precio = AperturaContratoDao.SelectAperturaContrato(idempresa, idsucursal, Integer.valueOf(id)).get(0).getPrecio();
                    double imptotal = AperturaContratoDao.SelectAperturaContrato(idempresa, idsucursal, Integer.valueOf(id)).get(0).getImptotal();
                    String calidad = AperturaContratoDao.SelectAperturaContrato(idempresa, idsucursal, Integer.valueOf(id)).get(0).getCalidad();
                    String humedad = AperturaContratoDao.SelectAperturaContrato(idempresa, idsucursal, Integer.valueOf(id)).get(0).getHumedad();
                    String Contrato = AperturaContratoDao.SelectAperturaContrato(idempresa, idsucursal, Integer.valueOf(id)).get(0).getContrato();
                    int idpersona = AperturaContratoDao.SelectAperturaContrato(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIdpersona();
                    String Fecha = AperturaContratoDao.SelectAperturaContrato(idempresa, idsucursal, Integer.valueOf(id)).get(0).getFecha();
                    String Estado = AperturaContratoDao.SelectAperturaContrato(idempresa, idsucursal, Integer.valueOf(id)).get(0).getEstado();
                    System.out.println(idapcontrato);
                    vistaCRUD.txtIdApC.setText(String.valueOf(idapcontrato));
                    vistaCRUD.txtPeso.setText(String.valueOf(peso));
                    vistaCRUD.txtPrecio.setText(String.valueOf(precio));
                    vistaCRUD.txtImpTotal.setText(String.valueOf(imptotal));
                    vistaCRUD.txtCalidad.setText(String.valueOf(calidad));
                    vistaCRUD.txtHumedad.setText(String.valueOf(humedad));
                    vistaCRUD.txtContrato.setText(String.valueOf(Contrato));
                    vistaCRUD.jcbPersona.setSelectedItem(idpersona);
                    vistaCRUD.txtFecha.setDate(Date.valueOf(Fecha));
                    vistaCRUD.btnNuevo.setEnabled(false);
                    vistaCRUD.btnEditar.setEnabled(false);
                    vistaCRUD.txtIdApC.setEnabled(false);
                    vistaCRUD.txtPeso.setEnabled(true);
                    vistaCRUD.txtPrecio.setEnabled(true);
                    vistaCRUD.txtImpTotal.setEnabled(false);
                    vistaCRUD.txtContrato.setEnabled(true);
                    vistaCRUD.txtCalidad.setEnabled(true);
                    vistaCRUD.txtHumedad.setEnabled(true);
                    vistaCRUD.txtFecha.setEnabled(true);
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

    public void construirTabla(int empresa, int sucursal) {

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
        Object[][] data = obtenerMatrizDatos(titulosList);
        construirTabla(titulos, data);
    }

    public void construirTablabuscar() {

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

        Object[][] data = obtenerMatrizDatos(titulosList);
        construirTabla(titulos, data);
    }

    private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {

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

    private void construirTabla(String[] titulos, Object[][] data) {
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

        vistaCRUD.jScrollPane1.setViewportView(vistaCRUD.jtAperturaContrato);
    }

    private void validarSeleccionMouse(int fila) {
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

    private void validarSeleccionMouseDetalle(int fila) {
        UtilidadApC.filaSeleccionada = fila;

        //teniendo la fila entonces se obtiene el objeto correspondiente para enviarse como parammetro o imprimir la información        
        idempresa = Integer.valueOf(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.idempresa).toString());
    }

    @Override
    public void mouseClicked(MouseEvent me) {

        if (me.getSource() == vistaCRUD.jtAperturaContrato) {

            if (me.getClickCount() > 1) {
                int fila = vistaCRUD.jtAperturaContrato.rowAtPoint(me.getPoint());
                int columna = vistaCRUD.jtAperturaContrato.columnAtPoint(me.getPoint());
                validarSeleccionMouse(fila);
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
                    vistaCRUD.txtImpTotal.setText(String.valueOf(rt));//                   
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "NO SE ENCUENTRA EL REGISTRO");
            }

        }
    }

}
