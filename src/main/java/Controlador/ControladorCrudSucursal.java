/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Uti.GestionCeldas;
import Uti.GestionEncabezadoTabla;
import Uti.ModeloTabla;
import Uti.UtilidadSucursal;
import static Uti.UtilidadesExtras.reiniciarJTable;
import dao.SucursalDao;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import modelo.Sucursal;
import vista.RSucursal;
import vista.TraIni;

/**
 *
 * @author wmtor
 */
public class ControladorCrudSucursal implements ActionListener, MouseListener, KeyListener {

    RSucursal vistaCRUD = new RSucursal();
    SucursalDao modeloCRUD = new SucursalDao();
    ArrayList<Sucursal> listaSucursal;
    ArrayList<Sucursal> idNuevoSucursal;
    int idempresa;
    ModeloTabla modelojt;
    private int filasTabla;
    private int columnasTabla;
    DecimalFormat formatea = new DecimalFormat("###,###.##");
    String texto;

    public ControladorCrudSucursal(RSucursal vistaCRUD, SucursalDao modeloCRUD) {
        this.modeloCRUD = modeloCRUD;
        this.vistaCRUD = vistaCRUD;
        this.vistaCRUD.btnNuevo.addActionListener(this);
        this.vistaCRUD.btnEditar.addActionListener(this);
        this.vistaCRUD.btnRegistrar.addActionListener(this);
        this.vistaCRUD.jtAgricultorEstimado.addMouseListener(this);
    }

    public void InicializarCrud() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        idempresa = Integer.valueOf(TraIni.lblEmpresa.getText());
        if (e.getSource() == vistaCRUD.btnNuevo) {
            idNuevoSucursal = dao.SucursalDao.idNuevoSucursal();
            vistaCRUD.txtId.setText(String.valueOf(idNuevoSucursal.get(0).getIdsucursal() + 1));
            vistaCRUD.btnRegistrar.setEnabled(true);
            vistaCRUD.btnNuevo.setEnabled(false);
            vistaCRUD.btnEditar.setEnabled(false);
            vistaCRUD.txtIdcp.setEnabled(false);
            vistaCRUD.txtIdcafepractice.setEnabled(true);
            vistaCRUD.txtCodAgricultor.setEnabled(true);
            vistaCRUD.txtNombre.setEnabled(true);
            vistaCRUD.txtDni.setEnabled(true);
            vistaCRUD.txtIdorga.setEnabled(true);
            vistaCRUD.txtIdcp.requestFocus();

        }
        if (e.getSource() == vistaCRUD.btnRegistrar) {
            if (vistaCRUD.txtIdcp.getText().isEmpty()
                    || vistaCRUD.txtIdcafepractice.getText().isEmpty() || vistaCRUD.txtCodAgricultor.getText().isEmpty() || vistaCRUD.txtNombre.getText().isEmpty()
                    || vistaCRUD.txtDni.getText().isEmpty() || vistaCRUD.txtIdorga.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe Llenar todos los datos necesarios.");
            } else {
                if (vistaCRUD.btnRegistrar.getText() == "Guardar") {
                    int id = Integer.valueOf(vistaCRUD.txtId.getText());
                    String rciudad = vistaCRUD.txtIdcp.getText();
                    String ruc = vistaCRUD.txtIdorga.getText();
                    String direccion = vistaCRUD.txtIdcafepractice.getText();
                    String distrito = vistaCRUD.txtCodAgricultor.getText();
                    String pais = vistaCRUD.txtDni.getText();
                    String gironegocio = vistaCRUD.txtNombre.getText();

                    String Estado = "";
                    if ((String) vistaCRUD.jcbEstado.getSelectedItem() == "Inactivo") {
                        Estado = "I";
                    }
                    if ((String) vistaCRUD.jcbEstado.getSelectedItem() == "Activo") {
                        Estado = "A";
                    }
                    String rptaRegistro = modeloCRUD.updateSucursal(id, idempresa, rciudad, ruc, direccion, distrito, pais, gironegocio, Estado);
                    if (rptaRegistro != null) {
                        vistaCRUD.btnRegistrar.setEnabled(false);
                        vistaCRUD.btnNuevo.setEnabled(true);
                        vistaCRUD.btnEditar.setEnabled(true);
                        vistaCRUD.txtId.setEnabled(false);
                        vistaCRUD.txtIdcp.setEnabled(false);
                        vistaCRUD.txtIdcafepractice.setEnabled(false);
                        vistaCRUD.txtCodAgricultor.setEnabled(false);
                        vistaCRUD.txtNombre.setEnabled(false);
                        vistaCRUD.txtDni.setEnabled(false);
                        vistaCRUD.txtIdorga.setEnabled(false);
                        JOptionPane.showMessageDialog(null, rptaRegistro);
                        vistaCRUD.txtIdcp.setText("");
                        vistaCRUD.txtIdcafepractice.setText("");
                        vistaCRUD.txtCodAgricultor.setText("");
                        vistaCRUD.txtNombre.setText("");
                        vistaCRUD.txtDni.setText("");
                        vistaCRUD.txtIdorga.setText("");
                        reiniciarJTable(vistaCRUD.jtAgricultorEstimado);
                        construirTabla(idempresa);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo realizar la actualización.");
                    }
                } else {
                    int id = Integer.valueOf(vistaCRUD.txtId.getText());
                    String rciudad = vistaCRUD.txtIdcp.getText();
                    String ruc = vistaCRUD.txtIdorga.getText();
                    String direccion = vistaCRUD.txtIdcafepractice.getText();
                    String distrito = vistaCRUD.txtCodAgricultor.getText();
                    String pais = vistaCRUD.txtDni.getText();
                    String gironegocio = vistaCRUD.txtNombre.getText();
                    String Estado = "";
                    if ((String) vistaCRUD.jcbEstado.getSelectedItem() == "Inactivo") {
                        Estado = "I";
                    }
                    if ((String) vistaCRUD.jcbEstado.getSelectedItem() == "Activo") {
                        Estado = "A";
                    }
                    String rptaRegistro = modeloCRUD.insertSucursal(id, idempresa, rciudad, ruc, direccion, distrito, pais, gironegocio, Estado);
                    if (rptaRegistro != null) {
                        vistaCRUD.btnRegistrar.setEnabled(false);
                        vistaCRUD.btnNuevo.setEnabled(true);
                        vistaCRUD.btnEditar.setEnabled(true);
                        vistaCRUD.txtId.setEnabled(false);
                        vistaCRUD.txtIdcp.setEnabled(false);
                        vistaCRUD.txtIdcafepractice.setEnabled(false);
                        vistaCRUD.txtCodAgricultor.setEnabled(false);
                        vistaCRUD.txtNombre.setEnabled(false);
                        vistaCRUD.txtDni.setEnabled(false);
                        vistaCRUD.txtIdorga.setEnabled(false);
                        JOptionPane.showMessageDialog(null, rptaRegistro);
                        vistaCRUD.txtIdcp.setText("");
                        vistaCRUD.txtIdcafepractice.setText("");
                        vistaCRUD.txtCodAgricultor.setText("");
                        vistaCRUD.txtNombre.setText("");
                        vistaCRUD.txtDni.setText("");
                        vistaCRUD.txtIdorga.setText("");
                        reiniciarJTable(vistaCRUD.jtAgricultorEstimado);
                        construirTabla(idempresa);
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

                filaseleccionada = vistaCRUD.jtAgricultorEstimado.getSelectedRow();

                if (filaseleccionada == -1) {

                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila ");

                } else {

                    DefaultTableModel modelotabla = (DefaultTableModel) vistaCRUD.jtAgricultorEstimado.getModel();

                    String id = (String) modelotabla.getValueAt(filaseleccionada, 0);

                    int idsucursal = SucursalDao.SelectSucursal(Integer.valueOf(id)).get(0).getIdsucursal();
                    String razonsocial = SucursalDao.SelectSucursal(Integer.valueOf(id)).get(0).getNombreciudad();
                    String ruc = SucursalDao.SelectSucursal(Integer.valueOf(id)).get(0).getRuc();
                    String direccion = SucursalDao.SelectSucursal(Integer.valueOf(id)).get(0).getDireccion();
                    String distrito = SucursalDao.SelectSucursal(Integer.valueOf(id)).get(0).getDistrito();
                    String pais = SucursalDao.SelectSucursal(Integer.valueOf(id)).get(0).getPais();
                    String gironegocio = SucursalDao.SelectSucursal(Integer.valueOf(id)).get(0).getGironegocio();
                    String Estado = SucursalDao.SelectSucursal(Integer.valueOf(id)).get(0).getEstado();

                    vistaCRUD.txtId.setText(String.valueOf(id));
                    vistaCRUD.txtIdcp.setText(String.valueOf(razonsocial));
                    vistaCRUD.txtIdorga.setText(String.valueOf(ruc));
                    vistaCRUD.txtIdcafepractice.setText(String.valueOf(direccion));
                    vistaCRUD.txtCodAgricultor.setText(String.valueOf(distrito));
                    vistaCRUD.txtDni.setText(String.valueOf(pais));
                    vistaCRUD.txtNombre.setText(String.valueOf(gironegocio));
                    vistaCRUD.btnNuevo.setEnabled(false);
                    vistaCRUD.btnEditar.setEnabled(false);
                    vistaCRUD.txtId.setEnabled(false);
                    vistaCRUD.txtIdcp.setEnabled(true);
                    vistaCRUD.txtIdcafepractice.setEnabled(true);
                    vistaCRUD.txtCodAgricultor.setEnabled(true);
                    vistaCRUD.txtNombre.setEnabled(true);
                    vistaCRUD.txtDni.setEnabled(true);
                    vistaCRUD.txtIdorga.setEnabled(true);
                    vistaCRUD.txtIdcp.requestFocus();

                    if (Estado.equals("A")) {
                        vistaCRUD.jcbEstado.setSelectedIndex(0);
                    } else {
                        vistaCRUD.jcbEstado.setSelectedIndex(1);
                    }
                    reiniciarJTable(vistaCRUD.jtAgricultorEstimado);
                    construirTabla(idempresa);
                }
            } catch (HeadlessException ex) {

                JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente", " .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    public void construirTabla(int idempresa) {

        listaSucursal = dao.SucursalDao.listSucursal(idempresa);

        ArrayList<String> titulosList = new ArrayList<>();

        titulosList.add("Id");
        titulosList.add("Nom.Ciudad");
        titulosList.add("Ruc");
        titulosList.add("Direccion");
        titulosList.add("Distrito");
        titulosList.add("Pais");
        titulosList.add("Gironegocio");
        titulosList.add("Estado");

        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }
        Object[][] data = obtenerMatrizDatos(titulosList);
        construirTabla(titulos, data);
    }

    public void construirTablabuscar(int empresa,String texto) {

        listaSucursal = dao.SucursalDao.listSucursalBuscar(idempresa, texto);

        ArrayList<String> titulosList = new ArrayList<>();

        titulosList.add("Id");
        titulosList.add("Razonsocial");
        titulosList.add("Ruc");
        titulosList.add("Direccion");
        titulosList.add("Distrito");
        titulosList.add("Pais");
        titulosList.add("Gironegocio");
        titulosList.add("Estado");

        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }

        Object[][] data = obtenerMatrizDatos(titulosList);
        construirTabla(titulos, data);
    }

    private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {

        String informacion[][] = new String[listaSucursal.size()][titulosList.size()];

        for (int x = 0; x < informacion.length; x++) {

            informacion[x][UtilidadSucursal.idsucursal] = listaSucursal.get(x).getIdsucursal() + "";
            informacion[x][UtilidadSucursal.idempresa] = listaSucursal.get(x).getIdempresa()+ "";
            informacion[x][UtilidadSucursal.nombreciudad] = listaSucursal.get(x).getNombreciudad() + "";
            informacion[x][UtilidadSucursal.ruc] = listaSucursal.get(x).getRuc() + "";
            informacion[x][UtilidadSucursal.direccion] = listaSucursal.get(x).getDireccion() + "";
            informacion[x][UtilidadSucursal.distrito] = listaSucursal.get(x).getDistrito() + "";
            informacion[x][UtilidadSucursal.pais] = listaSucursal.get(x).getPais() + "";
            informacion[x][UtilidadSucursal.giro] = listaSucursal.get(x).getGironegocio() + "";
            informacion[x][UtilidadSucursal.estado] = listaSucursal.get(x).getEstado() + "";
        }
        return informacion;
    }

    private void construirTabla(String[] titulos, Object[][] data) {
        modelojt = new ModeloTabla(data, titulos);
        //se asigna el modelo a la tabla
        vistaCRUD.jtAgricultorEstimado.setModel(modelojt);

        filasTabla = vistaCRUD.jtAgricultorEstimado.getRowCount();
        columnasTabla = vistaCRUD.jtAgricultorEstimado.getColumnCount();

        vistaCRUD.jtAgricultorEstimado.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAgricultorEstimado.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAgricultorEstimado.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAgricultorEstimado.getColumnModel().getColumn(3).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAgricultorEstimado.getColumnModel().getColumn(4).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAgricultorEstimado.getColumnModel().getColumn(5).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAgricultorEstimado.getColumnModel().getColumn(6).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAgricultorEstimado.getColumnModel().getColumn(7).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAgricultorEstimado.getColumnModel().getColumn(8).setCellRenderer(new GestionCeldas("texto"));

        vistaCRUD.jtAgricultorEstimado.getTableHeader().setReorderingAllowed(false);
        vistaCRUD.jtAgricultorEstimado.setRowHeight(25);//tamaño de las celdas
        vistaCRUD.jtAgricultorEstimado.setGridColor(new java.awt.Color(0, 0, 0));

        vistaCRUD.jtAgricultorEstimado.getColumnModel().getColumn(UtilidadSucursal.idsucursal).setPreferredWidth(40);
        vistaCRUD.jtAgricultorEstimado.getColumnModel().getColumn(UtilidadSucursal.idempresa).setPreferredWidth(40);
        vistaCRUD.jtAgricultorEstimado.getColumnModel().getColumn(UtilidadSucursal.nombreciudad).setPreferredWidth(60);
        vistaCRUD.jtAgricultorEstimado.getColumnModel().getColumn(UtilidadSucursal.ruc).setPreferredWidth(60);
        vistaCRUD.jtAgricultorEstimado.getColumnModel().getColumn(UtilidadSucursal.direccion).setPreferredWidth(60);
        vistaCRUD.jtAgricultorEstimado.getColumnModel().getColumn(UtilidadSucursal.distrito).setPreferredWidth(50);
        vistaCRUD.jtAgricultorEstimado.getColumnModel().getColumn(UtilidadSucursal.pais).setPreferredWidth(70);
        vistaCRUD.jtAgricultorEstimado.getColumnModel().getColumn(UtilidadSucursal.giro).setPreferredWidth(70);
        vistaCRUD.jtAgricultorEstimado.getColumnModel().getColumn(UtilidadSucursal.estado).setPreferredWidth(60);

        JTableHeader jtableHeader = vistaCRUD.jtAgricultorEstimado.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        vistaCRUD.jtAgricultorEstimado.setTableHeader(jtableHeader);

        vistaCRUD.jScrollPane1.setViewportView(vistaCRUD.jtAgricultorEstimado);
    }

    private void validarSeleccionMouse(int fila) {
        UtilidadSucursal.filaSeleccionada = fila;

        //teniendo la fila entonces se obtiene el objeto correspondiente para enviarse como parammetro o imprimir la información
        Sucursal Emp = new Sucursal();
        Emp.setIdsucursal(Integer.valueOf(vistaCRUD.jtAgricultorEstimado.getValueAt(fila, UtilidadSucursal.idsucursal).toString()));
        Emp.setIdempresa(Integer.valueOf(vistaCRUD.jtAgricultorEstimado.getValueAt(fila, UtilidadSucursal.idempresa).toString()));
        Emp.setNombreciudad(vistaCRUD.jtAgricultorEstimado.getValueAt(fila, UtilidadSucursal.nombreciudad).toString());
        Emp.setRuc(vistaCRUD.jtAgricultorEstimado.getValueAt(fila, UtilidadSucursal.ruc).toString());
        Emp.setDireccion(vistaCRUD.jtAgricultorEstimado.getValueAt(fila, UtilidadSucursal.direccion).toString());
        Emp.setDistrito(vistaCRUD.jtAgricultorEstimado.getValueAt(fila, UtilidadSucursal.distrito).toString());
        Emp.setPais(vistaCRUD.jtAgricultorEstimado.getValueAt(fila, UtilidadSucursal.pais).toString());
        Emp.setGironegocio(vistaCRUD.jtAgricultorEstimado.getValueAt(fila, UtilidadSucursal.giro).toString());
        Emp.setEstado(vistaCRUD.jtAgricultorEstimado.getValueAt(fila, UtilidadSucursal.estado).toString());

        String info = "INFO DOCUMENTO\n";
        info += "id: " + Emp.getIdsucursal() + "\n";
        info += "IdEmp: " + Emp.getIdempresa() + "\n";
        info += "Nombre Ciudad: " + Emp.getNombreciudad() + "\n";
        info += "Direccion: " + Emp.getDireccion() + "\n";
        info += "Distrito: " + Emp.getDistrito() + "\n";
        info += "Pais: " + Emp.getPais() + "\n";
        info += "Gironegocio: " + Emp.getGironegocio() + "\n";
        info += "Estado: " + Emp.getEstado() + "\n";

        JOptionPane.showMessageDialog(null, info);
    }

    @Override
    public void mouseClicked(MouseEvent me) {

        if (me.getSource() == vistaCRUD.jtAgricultorEstimado) {

            if (me.getClickCount() > 1) {
                int fila = vistaCRUD.jtAgricultorEstimado.rowAtPoint(me.getPoint());
                int columna = vistaCRUD.jtAgricultorEstimado.columnAtPoint(me.getPoint());
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
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
