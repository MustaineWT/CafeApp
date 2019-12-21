/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Uti.GestionCeldas;
import Uti.GestionEncabezadoTabla;
import Uti.ModeloTabla;
import Uti.UtilidadSelect_Suc;
import dao.ConformacionDao;
import dao.Select_SucursalDao;
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
import modelo.PerBuscador;
import modelo.Sucursal;
import vista.RPEstimado;
import vista.RPSel_Sucursal;
import vista.TraIni;
import static vista.TraIni.dskPrincipal;

/**
 *
 * @author wmtor
 */
public class ControladorCrudSelecSucursal implements ActionListener, MouseListener, KeyListener {

    RPSel_Sucursal vistaCRUD = new RPSel_Sucursal();
    Select_SucursalDao modeloCRUD = new Select_SucursalDao();
    ArrayList<Sucursal> listaSucursal;
    int idempresa;
    int idsucursal;
    String id;
    ModeloTabla modelojt;
    private int filasTabla;
    private int columnasTabla;
    DecimalFormat formatea = new DecimalFormat("###,###.##");
    String texto;

    public ControladorCrudSelecSucursal(RPSel_Sucursal vistaCRUD, Select_SucursalDao modeloCRUD) {
        this.modeloCRUD = modeloCRUD;
        this.vistaCRUD = vistaCRUD;
        this.vistaCRUD.btnSeleccionar.addActionListener(this);
        this.vistaCRUD.btnCancelar.addActionListener(this);
        this.vistaCRUD.jtSucursales.addMouseListener(this);

    }

    public void InicializarCrud() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vistaCRUD.btnSeleccionar) {
            int filaseleccionada;
            try {
                filaseleccionada = vistaCRUD.jtSucursales.getSelectedRow();
                if (filaseleccionada == -1) {
                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
                } else {
                    DefaultTableModel modelotabla = (DefaultTableModel) vistaCRUD.jtSucursales.getModel();

                    String empresa = (String) modelotabla.getValueAt(filaseleccionada, 0);
                    String sucursal = (String) modelotabla.getValueAt(filaseleccionada, 1);
                    TraIni.lblEmpresa.setText(empresa);
                    TraIni.lblSucursal.setText(sucursal);
                    vistaCRUD.dispose();
                }
            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente", " .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);

            }
        }
        if (e.getSource() == vistaCRUD.btnCancelar) {
            vistaCRUD.dispose();
        }
    }

    public void construirTabla(int empresa) {

        listaSucursal = dao.Select_SucursalDao.listSelecSucursal(empresa);

        ArrayList<String> titulosList = new ArrayList<>();

        titulosList.add("IdEmp");
        titulosList.add("IdSuc");
        titulosList.add("Razon Social");
        titulosList.add("Ciudad");
        titulosList.add("Ruc");
        titulosList.add("Giro");

        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }
        Object[][] data = obtenerMatrizDatos(titulosList);
        construirTabla(titulos, data);
    }

    public void construirTablabuscar(int idempresa, String texto) {

        //listaSucursal = dao.Select_SucursalDao.listSelecSucursal(empresa);
        ArrayList<String> titulosList = new ArrayList<>();

        titulosList.add("IdEmp");
        titulosList.add("IdSuc");
        titulosList.add("Razon Social");
        titulosList.add("Ciudad");
        titulosList.add("Ruc");
        titulosList.add("Giro");

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

            informacion[x][UtilidadSelect_Suc.idempresa] = listaSucursal.get(x).getIdempresa() + "";
            informacion[x][UtilidadSelect_Suc.idsucursal] = listaSucursal.get(x).getIdsucursal() + "";
            informacion[x][UtilidadSelect_Suc.razonsocial] = listaSucursal.get(x).getRsocial() + "";
            informacion[x][UtilidadSelect_Suc.ciudad] = listaSucursal.get(x).getNombreciudad() + "";
            informacion[x][UtilidadSelect_Suc.ruc] = listaSucursal.get(x).getRuc() + "";
            informacion[x][UtilidadSelect_Suc.giro] = listaSucursal.get(x).getGironegocio() + "";
        }
        return informacion;
    }

    private void construirTabla(String[] titulos, Object[][] data) {
        modelojt = new ModeloTabla(data, titulos);
        //se asigna el modelo a la tabla
        vistaCRUD.jtSucursales.setModel(modelojt);

        filasTabla = vistaCRUD.jtSucursales.getRowCount();
        columnasTabla = vistaCRUD.jtSucursales.getColumnCount();

        vistaCRUD.jtSucursales.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtSucursales.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtSucursales.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtSucursales.getColumnModel().getColumn(3).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtSucursales.getColumnModel().getColumn(4).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtSucursales.getColumnModel().getColumn(5).setCellRenderer(new GestionCeldas("texto"));

        vistaCRUD.jtSucursales.getTableHeader().setReorderingAllowed(false);
        vistaCRUD.jtSucursales.setRowHeight(25);//tamaño de las celdas
        vistaCRUD.jtSucursales.setGridColor(new java.awt.Color(0, 0, 0));

        vistaCRUD.jtSucursales.getColumnModel().getColumn(UtilidadSelect_Suc.idempresa).setPreferredWidth(40);
        vistaCRUD.jtSucursales.getColumnModel().getColumn(UtilidadSelect_Suc.idsucursal).setPreferredWidth(40);
        vistaCRUD.jtSucursales.getColumnModel().getColumn(UtilidadSelect_Suc.razonsocial).setPreferredWidth(40);
        vistaCRUD.jtSucursales.getColumnModel().getColumn(UtilidadSelect_Suc.ciudad).setPreferredWidth(60);
        vistaCRUD.jtSucursales.getColumnModel().getColumn(UtilidadSelect_Suc.ruc).setPreferredWidth(60);
        vistaCRUD.jtSucursales.getColumnModel().getColumn(UtilidadSelect_Suc.giro).setPreferredWidth(60);

        JTableHeader jtableHeader = vistaCRUD.jtSucursales.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        vistaCRUD.jtSucursales.setTableHeader(jtableHeader);
        vistaCRUD.jScrollPane1.setViewportView(vistaCRUD.jtSucursales);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == vistaCRUD.jtSucursales) {

            if (me.getClickCount() == 1) {
                vistaCRUD.btnSeleccionar.setEnabled(true);
            } else {
                vistaCRUD.btnSeleccionar.setEnabled(false);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }
}
