/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Uti.GestionCeldas;
import Uti.GestionEncabezadoTabla;
import Uti.ModeloTabla;
import Uti.UtilidadPBuscar;
import static Uti.UtilidadesExtras.reiniciarJTable;
import dao.ConformacionDao;
import dao.DetalleDocutrazaDao;
import dao.PerBuscadorDao;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import modelo.PerBuscador;
import vista.RAgriEstimado;
import vista.RPEstimado;
import vista.RProBuscador;
import vista.TraIni;
import static vista.TraIni.dskPrincipal;

/**
 *
 * @author MustainE
 */
public class ControladorCrudConformacion implements ActionListener, MouseListener, KeyListener {

    RPEstimado vistaCRUD = new RPEstimado();
    ConformacionDao modeloCRUD = new ConformacionDao();
    RProBuscador vistaCRUDb = new RProBuscador();
    PerBuscadorDao modeloCRUDb = new PerBuscadorDao();
    ArrayList<PerBuscador> listaPerBuscador;
    int idempresa;
    int idsucursal;
    ModeloTabla modelojt;
    private int filasTabla;
    private int columnasTabla;
    public static int valor = 0;
    public static int v1 = 0;
    public static String nombre = "";
    DecimalFormat formatea = new DecimalFormat("###,###.##");
    String texto;

    public ControladorCrudConformacion(RPEstimado vistaCRUD, ConformacionDao modeloCRUD, RProBuscador vistaCRUDb, PerBuscadorDao modeloCRUDb) {
        this.modeloCRUD = modeloCRUD;
        this.vistaCRUD = vistaCRUD;
        this.modeloCRUDb = modeloCRUDb;
        this.vistaCRUDb = vistaCRUDb;
        this.vistaCRUD.btnRegistrar.addActionListener(this);
        this.vistaCRUD.btnCancelar.addActionListener(this);
        this.vistaCRUD.btnBuscarPro.addActionListener(this);
        this.vistaCRUD.btnActualizar.addActionListener(this);
        this.vistaCRUDb.jtProBuscador.addMouseListener(this);
        this.vistaCRUDb.btnCancelar.addActionListener(this);
        this.vistaCRUDb.btnSeleccionar.addActionListener(this);
        this.vistaCRUD.txtSacos.addKeyListener(this);
        this.vistaCRUD.txtKN.addKeyListener(this);
        this.vistaCRUD.txtKb.addKeyListener(this);
        this.vistaCRUD.txtPrecio.addKeyListener(this);
        this.vistaCRUD.txtSacos.addKeyListener(this);

    }

    public void InicializarCrud() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        idempresa = Integer.valueOf(TraIni.lblEmpresa.getText());
        idsucursal = Integer.valueOf(TraIni.lblSucursal.getText());
        if (e.getSource() == vistaCRUDb.btnSeleccionar) {
            valor = Integer.parseInt(vistaCRUDb.txtIdAgricultor.getText());

            nombre = ConformacionDao.listIddpersona(idempresa, valor).get(0).getNombres();
            vistaCRUDb.dispose();
            vistaCRUD.btnBuscarPro.setEnabled(false);
        }

        if (e.getSource() == vistaCRUD.btnActualizar) {          
            String v = String.valueOf(valor);
            String m = nombre;
            vistaCRUD.txtIdProLPACon.setText(v);
            vistaCRUD.txtNomLPACon.setText(m);
            vistaCRUD.btnActualizar.setEnabled(false);
            vistaCRUD.btnActualizar.setBackground(Color.GRAY);
        }

        if (e.getSource() == vistaCRUDb.btnCancelar) {
            vistaCRUDb.dispose();

        }

        if (e.getSource() == vistaCRUD.btnRegistrar) {
            if (vistaCRUD.txtSacos.getText().isEmpty()
                    || vistaCRUD.txtKb.getText().isEmpty() || vistaCRUD.txtTara.getText().isEmpty() || vistaCRUD.txtKN.getText().isEmpty()
                    || vistaCRUD.txtPrecio.getText().isEmpty() || vistaCRUD.txtLiqCompra.getText().isEmpty()
                    || vistaCRUD.txtFecha.getDate().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe Llenar todos los datos necesarios.");
            } else {
                if (vistaCRUD.btnRegistrar.getText() == "Guardar") {
                    int iddetdoc = Integer.valueOf(vistaCRUD.txtIdDetDoc.getText().toString());
                    int iddocutraza = Integer.valueOf(vistaCRUD.txtIdDocT.getText().toString());
                    int idperLPAEst = Integer.valueOf(vistaCRUD.txtIdPerLPAEst.getText().toString());
                    int idperLPACon = Integer.valueOf(vistaCRUD.txtIdProLPACon.getText().toString());
                    int idpersona = Integer.valueOf(vistaCRUD.txtIdPersona.getText().toString());
                    int sacos = Integer.valueOf(vistaCRUD.txtSacos.getText().toString());
                    double kb = Double.valueOf(vistaCRUD.txtKb.getText().toString());
                    double tara = Double.valueOf(vistaCRUD.txtTara.getText().toString());
                    double kn = Double.valueOf(vistaCRUD.txtKN.getText().toString());
                    double precio = Double.valueOf(vistaCRUD.txtPrecio.getText().toString());
                    double importetotal = Double.valueOf(vistaCRUD.txtImpTotal.getText().toString());
                    String guia = vistaCRUD.txtGuia.getText();
                    String liqcompra = vistaCRUD.txtGuia.getText();
                    String Estado = "";
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                    String fecha = formatoFecha.format(vistaCRUD.txtFecha.getDate());

                    if ((String) vistaCRUD.jcbEstado.getSelectedItem() == "Activo") {
                        Estado = "A";
                    }
                    if ((String) vistaCRUD.jcbEstado.getSelectedItem() == "Inactivo") {
                        Estado = "I";
                    }
                    String rptaRegistro = modeloCRUD.UpdateConformacion(iddetdoc, iddocutraza, idperLPAEst, idperLPACon, idpersona, sacos, kb, tara, kn, precio, importetotal, guia, liqcompra, fecha, Estado);
                    if (rptaRegistro != null) {
                        JOptionPane.showMessageDialog(null, rptaRegistro);

                        RAgriEstimado ventana1 = new RAgriEstimado();
                        DetalleDocutrazaDao modeloCdd = new DetalleDocutrazaDao();
                        ControladorCrudDetalleDocutraza controlaCd = new ControladorCrudDetalleDocutraza(ventana1, modeloCdd);
                        reiniciarJTable(controlaCd.vistaCRUD.jtListProveedores);
                        controlaCd.construirTablaListConfor(idempresa, idsucursal, iddocutraza);
                        vistaCRUD.dispose();
                        //Controlador.ControladorCrudDetalleDocutraza.construirTabla();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo realizar la actualización.");
                    }
                } else {
                    int iddetdoc = Integer.valueOf(vistaCRUD.txtIdDetDoc.getText().toString());
                    int iddocutraza = Integer.valueOf(vistaCRUD.txtIdDocT.getText().toString());
                    int idperLPAEst = Integer.valueOf(vistaCRUD.txtIdPerLPAEst.getText().toString());
                    int idperLPACon = Integer.valueOf(vistaCRUD.txtIdProLPACon.getText().toString());
                    int idpersona = Integer.valueOf(vistaCRUD.txtIdPersona.getText().toString());
                    int sacos = Integer.valueOf(vistaCRUD.txtSacos.getText().toString());
                    double kb = Double.valueOf(vistaCRUD.txtKb.getText().toString());
                    double tara = Double.valueOf(vistaCRUD.txtTara.getText().toString());
                    double kn = Double.valueOf(vistaCRUD.txtKN.getText().toString());
                    double precio = Double.valueOf(vistaCRUD.txtPrecio.getText().toString());
                    double importetotal = Double.valueOf(vistaCRUD.txtImpTotal.getText().toString());
                    String guia = vistaCRUD.txtGuia.getText();
                    String liqcompra = vistaCRUD.txtLiqCompra.getText();
                    String Estado = "";
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                    String fecha = formatoFecha.format(vistaCRUD.txtFecha.getDate());

                    if ((String) vistaCRUD.jcbEstado.getSelectedItem() == "Activo") {
                        Estado = "A";
                    }
                    if ((String) vistaCRUD.jcbEstado.getSelectedItem() == "Inactivo") {
                        Estado = "I";
                    }

                    String rptaRegistro = modeloCRUD.UpdateConformacion(iddetdoc, iddocutraza, idperLPAEst, idperLPACon, idpersona, sacos, kb, tara, kn, precio, importetotal, guia, liqcompra, fecha, Estado);

                    if (rptaRegistro != null) {
                        JOptionPane.showMessageDialog(null, rptaRegistro);

                        RAgriEstimado.btnRefresh.doClick();
                        vistaCRUD.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo realizar la actualización.");
                    }
                }
            }
        }
        if (e.getSource() == vistaCRUD.btnCancelar) {
            vistaCRUD.dispose();
        }
        if (e.getSource() == vistaCRUD.btnBuscarPro) {

            RPEstimado ventana1 = new RPEstimado();
            ConformacionDao modeloC = new ConformacionDao();
            RProBuscador vistaCRUDbb = new RProBuscador();
            PerBuscadorDao modeloCRUDbb = new PerBuscadorDao();
            ControladorCrudConformacion controlaC = new ControladorCrudConformacion(ventana1, modeloC, vistaCRUDbb, modeloCRUDbb);

            reiniciarJTable(controlaC.vistaCRUDb.jtProBuscador);

            controlaC.construirTabla(idempresa);
            //vistaCRUD.btnBuscarPro.setText("Actualizar");
            dskPrincipal.add(vistaCRUDbb);
            vistaCRUDbb.setVisible(true);
            vistaCRUD.btnActualizar.setEnabled(true);
            vistaCRUD.btnActualizar.setBackground(Color.green);

        }
    }

    public void construirTabla(int empresa) {

        listaPerBuscador = dao.PerBuscadorDao.listPerBuscador(empresa);

        ArrayList<String> titulosList = new ArrayList<>();

        titulosList.add("Id");
        titulosList.add("Orga");
        titulosList.add("CP");
        titulosList.add("CafePractice");
        titulosList.add("CodAgric");
        titulosList.add("Nombres");
        titulosList.add("Apellidos");
        titulosList.add("Dni");
        titulosList.add("Provincia");
        titulosList.add("Nomfinca");
        titulosList.add("NomAnexo");
        titulosList.add("Est");

        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }
        Object[][] data = obtenerMatrizDatos(titulosList);
        construirTabla(titulos, data);
    }

    public void construirTablabuscar(int idempresa, String texto) {

        listaPerBuscador = dao.PerBuscadorDao.listPerBuscadorBuscar(idempresa, texto);

        ArrayList<String> titulosList = new ArrayList<>();

        titulosList.add("Id");
        titulosList.add("Orga");
        titulosList.add("CP");
        titulosList.add("CafePractice");
        titulosList.add("CodAgric");
        titulosList.add("Nombres");
        titulosList.add("Apellidos");
        titulosList.add("Dni");
        titulosList.add("Provincia");
        titulosList.add("Nomfinca");
        titulosList.add("NomAnexo");
        titulosList.add("Est");

        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }

        Object[][] data = obtenerMatrizDatos(titulosList);
        construirTabla(titulos, data);
    }

    private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {

        String informacion[][] = new String[listaPerBuscador.size()][titulosList.size()];

        for (int x = 0; x < informacion.length; x++) {

            informacion[x][UtilidadPBuscar.idpersona] = listaPerBuscador.get(x).getIdpersona() + "";
            informacion[x][UtilidadPBuscar.idorga] = listaPerBuscador.get(x).getIdorga() + "";
            informacion[x][UtilidadPBuscar.idcafepractice] = listaPerBuscador.get(x).getIdcafepractice() + "";
            informacion[x][UtilidadPBuscar.codagricultor] = listaPerBuscador.get(x).getCodagricultor() + "";
            informacion[x][UtilidadPBuscar.nombres] = listaPerBuscador.get(x).getNombres() + "";
            informacion[x][UtilidadPBuscar.apellidos] = listaPerBuscador.get(x).getApellidos() + "";
            informacion[x][UtilidadPBuscar.dniruc] = listaPerBuscador.get(x).getDniruc() + "";
            informacion[x][UtilidadPBuscar.provincia] = listaPerBuscador.get(x).getProvincia() + "";
            informacion[x][UtilidadPBuscar.nomfinca] = listaPerBuscador.get(x).getNomfinca() + "";
            informacion[x][UtilidadPBuscar.nomanexo] = listaPerBuscador.get(x).getNomanexo() + "";
            informacion[x][UtilidadPBuscar.estado] = listaPerBuscador.get(x).getEstado() + "";
        }
        return informacion;
    }

    private void construirTabla(String[] titulos, Object[][] data) {
        modelojt = new ModeloTabla(data, titulos);
        //se asigna el modelo a la tabla
        vistaCRUDb.jtProBuscador.setModel(modelojt);

        filasTabla = vistaCRUDb.jtProBuscador.getRowCount();
        columnasTabla = vistaCRUDb.jtProBuscador.getColumnCount();

        vistaCRUDb.jtProBuscador.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUDb.jtProBuscador.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUDb.jtProBuscador.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUDb.jtProBuscador.getColumnModel().getColumn(3).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUDb.jtProBuscador.getColumnModel().getColumn(4).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUDb.jtProBuscador.getColumnModel().getColumn(5).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUDb.jtProBuscador.getColumnModel().getColumn(6).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUDb.jtProBuscador.getColumnModel().getColumn(7).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUDb.jtProBuscador.getColumnModel().getColumn(8).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUDb.jtProBuscador.getColumnModel().getColumn(9).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUDb.jtProBuscador.getColumnModel().getColumn(10).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUDb.jtProBuscador.getColumnModel().getColumn(11).setCellRenderer(new GestionCeldas("texto"));

        vistaCRUDb.jtProBuscador.getTableHeader().setReorderingAllowed(false);
        vistaCRUDb.jtProBuscador.setRowHeight(25);//tamaño de las celdas
        vistaCRUDb.jtProBuscador.setGridColor(new java.awt.Color(0, 0, 0));

        vistaCRUDb.jtProBuscador.getColumnModel().getColumn(UtilidadPBuscar.idpersona).setPreferredWidth(40);
        vistaCRUDb.jtProBuscador.getColumnModel().getColumn(UtilidadPBuscar.idorga).setPreferredWidth(40);
        vistaCRUDb.jtProBuscador.getColumnModel().getColumn(UtilidadPBuscar.idcp).setPreferredWidth(40);
        vistaCRUDb.jtProBuscador.getColumnModel().getColumn(UtilidadPBuscar.idcafepractice).setPreferredWidth(60);
        vistaCRUDb.jtProBuscador.getColumnModel().getColumn(UtilidadPBuscar.codagricultor).setPreferredWidth(60);
        vistaCRUDb.jtProBuscador.getColumnModel().getColumn(UtilidadPBuscar.nombres).setPreferredWidth(60);
        vistaCRUDb.jtProBuscador.getColumnModel().getColumn(UtilidadPBuscar.apellidos).setPreferredWidth(50);
        vistaCRUDb.jtProBuscador.getColumnModel().getColumn(UtilidadPBuscar.dniruc).setPreferredWidth(70);
        vistaCRUDb.jtProBuscador.getColumnModel().getColumn(UtilidadPBuscar.provincia).setPreferredWidth(70);
        vistaCRUDb.jtProBuscador.getColumnModel().getColumn(UtilidadPBuscar.nomfinca).setPreferredWidth(70);
        vistaCRUDb.jtProBuscador.getColumnModel().getColumn(UtilidadPBuscar.nomanexo).setPreferredWidth(50);
        vistaCRUDb.jtProBuscador.getColumnModel().getColumn(UtilidadPBuscar.estado).setPreferredWidth(60);

        JTableHeader jtableHeader = vistaCRUDb.jtProBuscador.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        vistaCRUDb.jtProBuscador.setTableHeader(jtableHeader);

        vistaCRUDb.jScrollPane1.setViewportView(vistaCRUDb.jtProBuscador);
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
        idempresa = Integer.valueOf(TraIni.lblEmpresa.getText());
        if (ke.getSource() == vistaCRUDb.txtBuscar) {
            try {
                texto = vistaCRUDb.txtBuscar.getText();
                construirTablabuscar(idempresa, texto);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "NO SE ENCUENTRA EL REGISTRO");
            }
        }

        if (ke.getSource() == vistaCRUD.txtKN || ke.getSource() == vistaCRUD.txtPrecio || ke.getSource() == vistaCRUD.txtKb) {

            if (vistaCRUD.txtKN.getText().isEmpty() || vistaCRUD.txtPrecio.getText().isEmpty() || vistaCRUD.txtKb.getText().isEmpty()) {
            } else {
                try {
                    //texto = vistaCRUD.txtBuscador.getText();
                    //construirTablabuscar();
                    if (vistaCRUD.txtKN.getText().isEmpty() || vistaCRUD.txtPrecio.getText().isEmpty()) {

                    } else {

                        float rt = (float) (Double.valueOf(vistaCRUD.txtKN.getText()) * Double.valueOf(vistaCRUD.txtPrecio.getText()));
                        vistaCRUD.txtImpTotal.setText(String.valueOf(rt));//                   
                        float rtt = (float) (Double.valueOf(vistaCRUD.txtSacos.getText()) * 0.2);
                        vistaCRUD.txtTara.setText(String.valueOf(rtt));//                   
                        float rttt = (float) (Double.valueOf(vistaCRUD.txtKb.getText()) - Double.valueOf(vistaCRUD.txtTara.getText()));
                        vistaCRUD.txtKN.setText(String.valueOf(rttt));//
                    }
                } catch (Exception e) {
                }
            }
        }
        if (ke.getSource() == vistaCRUD.txtSacos) {
            if (vistaCRUD.txtSacos.getText().isEmpty()) {
            } else {
                float rtd = (float) (Double.valueOf(vistaCRUD.txtSacos.getText()) * 69);
                vistaCRUD.txtKb.setText(String.valueOf(rtd));//   
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == vistaCRUDb.jtProBuscador) {

            if (me.getClickCount() == 1) {
                int filaseleccionada;
                try {
                    filaseleccionada = vistaCRUDb.jtProBuscador.getSelectedRow();
                    if (filaseleccionada == -1) {
                        JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
                    } else {
                        DefaultTableModel modelotabla = (DefaultTableModel) vistaCRUDb.jtProBuscador.getModel();
                        String id = (String) modelotabla.getValueAt(filaseleccionada, 0);
                        vistaCRUDb.txtIdAgricultor.setText(id);

                    }
                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente", " .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);

                }

                vistaCRUDb.btnSeleccionar.setEnabled(true);
            } else {
                vistaCRUDb.btnSeleccionar.setEnabled(false);
            }
        }
    }

}
