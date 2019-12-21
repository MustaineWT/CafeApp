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
import dao.ConformacionDao;
import dao.PerBuscadorDao;
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
import vista.RAgriEstimado;
import vista.RProBuscador;
import vista.RPEstimado;
import vista.TraIni;
import static vista.TraIni.dskPrincipal;

/**
 *
 * @author MustainE
 */
public class ControladorCrudBuscar{}
//public class ControladorCrudBuscar implements ActionListener, MouseListener, KeyListener {

//    RProBuscador vistaCRUD = new RProBuscador();
//    PerBuscadorDao modeloCRUD = new PerBuscadorDao();
//    ArrayList<PerBuscador> listaPerBuscador;
//    int idempresa;
//    int idsucursal;
//    String id;
//    ModeloTabla modelojt;
//    private int filasTabla;
//    private int columnasTabla;
//    DecimalFormat formatea = new DecimalFormat("###,###.##");
//    String texto;
//
//    public ControladorCrudBuscar(RProBuscador vistaCRUD,PerBuscadorDao modeloCRUD) {
//        this.modeloCRUD = modeloCRUD;
//        this.vistaCRUD = vistaCRUD;
//        this.vistaCRUD.btnSeleccionar.addActionListener(this);
//        this.vistaCRUD.btnCancelar.addActionListener(this);
//        this.vistaCRUD.jtProBuscador.addMouseListener(this);
//        
//    }
//
//    public void InicializarCrud() {
//
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        idempresa = Integer.valueOf(TraIni.lblEmpresa.getText());
//        if (e.getSource() == vistaCRUD.btnSeleccionar) {
//            int filaseleccionada;
//            try {
//                filaseleccionada = vistaCRUD.jtProBuscador.getSelectedRow();
//                if (filaseleccionada == -1) {
//                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
//                } else {
//                    DefaultTableModel modelotabla = (DefaultTableModel) vistaCRUD.jtProBuscador.getModel();
//                    vistaCRUD.dispose();
//                    id = (String) modelotabla.getValueAt(filaseleccionada, 0);            
//                    RPEstimado ventana1 = new RPEstimado();
//                    ConformacionDao modeloC = new ConformacionDao();
//                    //ControladorCrudConformacion controlaC = new ControladorCrudConformacion(ventana1, modeloC,id);
//                    
//                  
//                     dskPrincipal.add(ventana1);
//                    ventana1.setVisible(true);
//                    //ventana1.txtIdB.setText(id);    
//                    //System.out.println(ventana1.txtIdB.getText());
//                   // controlaC.vistaCRUD.btnSelectAgricultor.doClick();
//                    
//                }
//            } catch (HeadlessException ex) {
//                JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente", " .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
//
//            }
//        }
//        if (e.getSource() == vistaCRUD.btnCancelar) {
//            vistaCRUD.dispose();
//        }
//    }
//
//    public void construirTabla(int empresa) {
//
//        listaPerBuscador = dao.PerBuscadorDao.listPerBuscador(empresa);
//
//        ArrayList<String> titulosList = new ArrayList<>();
//
//        titulosList.add("Id");
//        titulosList.add("Orga");
//        titulosList.add("CP");
//        titulosList.add("CafePractice");
//        titulosList.add("CodAgric");
//        titulosList.add("Nombres");
//        titulosList.add("Apellidos");
//        titulosList.add("Dni");
//        titulosList.add("Provincia");
//        titulosList.add("Nomfinca");
//        titulosList.add("NomAnexo");
//        titulosList.add("Est");
//
//        String titulos[] = new String[titulosList.size()];
//        for (int i = 0; i < titulos.length; i++) {
//            titulos[i] = titulosList.get(i);
//        }
//        Object[][] data = obtenerMatrizDatos(titulosList);
//        construirTabla(titulos, data);
//    }
//
//    public void construirTablabuscar(int idempresa, String texto) {
//
//        listaPerBuscador = dao.PerBuscadorDao.listPerBuscadorBuscar(idempresa, texto);
//
//        ArrayList<String> titulosList = new ArrayList<>();
//
//        titulosList.add("Id");
//        titulosList.add("Orga");
//        titulosList.add("CP");
//        titulosList.add("CafePractice");
//        titulosList.add("CodAgric");
//        titulosList.add("Nombres");
//        titulosList.add("Apellidos");
//        titulosList.add("Dni");
//        titulosList.add("Provincia");
//        titulosList.add("Nomfinca");
//        titulosList.add("NomAnexo");
//        titulosList.add("Est");
//
//        String titulos[] = new String[titulosList.size()];
//        for (int i = 0; i < titulos.length; i++) {
//            titulos[i] = titulosList.get(i);
//        }
//
//        Object[][] data = obtenerMatrizDatos(titulosList);
//        construirTabla(titulos, data);
//    }
//
//    private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {
//
//        String informacion[][] = new String[listaPerBuscador.size()][titulosList.size()];
//
//        for (int x = 0; x < informacion.length; x++) {
//
//            informacion[x][UtilidadPBuscar.idpersona] = listaPerBuscador.get(x).getIdpersona() + "";
//            informacion[x][UtilidadPBuscar.idorga] = listaPerBuscador.get(x).getIdorga() + "";
//            informacion[x][UtilidadPBuscar.idcafepractice] = listaPerBuscador.get(x).getIdcafepractice() + "";
//            informacion[x][UtilidadPBuscar.codagricultor] = listaPerBuscador.get(x).getCodagricultor() + "";
//            informacion[x][UtilidadPBuscar.nombres] = listaPerBuscador.get(x).getNombres() + "";
//            informacion[x][UtilidadPBuscar.apellidos] = listaPerBuscador.get(x).getApellidos() + "";
//            informacion[x][UtilidadPBuscar.dniruc] = listaPerBuscador.get(x).getDniruc() + "";
//            informacion[x][UtilidadPBuscar.provincia] = listaPerBuscador.get(x).getProvincia() + "";
//            informacion[x][UtilidadPBuscar.nomfinca] = listaPerBuscador.get(x).getNomfinca() + "";
//            informacion[x][UtilidadPBuscar.nomanexo] = listaPerBuscador.get(x).getNomanexo() + "";
//            informacion[x][UtilidadPBuscar.estado] = listaPerBuscador.get(x).getEstado() + "";
//        }
//        return informacion;
//    }
//
//    private void construirTabla(String[] titulos, Object[][] data) {
//        modelojt = new ModeloTabla(data, titulos);
//        //se asigna el modelo a la tabla
//        vistaCRUD.jtProBuscador.setModel(modelojt);
//
//        filasTabla = vistaCRUD.jtProBuscador.getRowCount();
//        columnasTabla = vistaCRUD.jtProBuscador.getColumnCount();
//
//        vistaCRUD.jtProBuscador.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("texto"));
//        vistaCRUD.jtProBuscador.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("texto"));
//        vistaCRUD.jtProBuscador.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("texto"));
//        vistaCRUD.jtProBuscador.getColumnModel().getColumn(3).setCellRenderer(new GestionCeldas("texto"));
//        vistaCRUD.jtProBuscador.getColumnModel().getColumn(4).setCellRenderer(new GestionCeldas("texto"));
//        vistaCRUD.jtProBuscador.getColumnModel().getColumn(5).setCellRenderer(new GestionCeldas("texto"));
//        vistaCRUD.jtProBuscador.getColumnModel().getColumn(6).setCellRenderer(new GestionCeldas("texto"));
//        vistaCRUD.jtProBuscador.getColumnModel().getColumn(7).setCellRenderer(new GestionCeldas("texto"));
//        vistaCRUD.jtProBuscador.getColumnModel().getColumn(8).setCellRenderer(new GestionCeldas("texto"));
//        vistaCRUD.jtProBuscador.getColumnModel().getColumn(9).setCellRenderer(new GestionCeldas("texto"));
//        vistaCRUD.jtProBuscador.getColumnModel().getColumn(10).setCellRenderer(new GestionCeldas("texto"));
//        vistaCRUD.jtProBuscador.getColumnModel().getColumn(11).setCellRenderer(new GestionCeldas("texto"));
//
//        vistaCRUD.jtProBuscador.getTableHeader().setReorderingAllowed(false);
//        vistaCRUD.jtProBuscador.setRowHeight(25);//tamaño de las celdas
//        vistaCRUD.jtProBuscador.setGridColor(new java.awt.Color(0, 0, 0));
//
//        vistaCRUD.jtProBuscador.getColumnModel().getColumn(UtilidadPBuscar.idpersona).setPreferredWidth(40);
//        vistaCRUD.jtProBuscador.getColumnModel().getColumn(UtilidadPBuscar.idorga).setPreferredWidth(40);
//        vistaCRUD.jtProBuscador.getColumnModel().getColumn(UtilidadPBuscar.idcp).setPreferredWidth(40);
//        vistaCRUD.jtProBuscador.getColumnModel().getColumn(UtilidadPBuscar.idcafepractice).setPreferredWidth(60);
//        vistaCRUD.jtProBuscador.getColumnModel().getColumn(UtilidadPBuscar.codagricultor).setPreferredWidth(60);
//        vistaCRUD.jtProBuscador.getColumnModel().getColumn(UtilidadPBuscar.nombres).setPreferredWidth(60);
//        vistaCRUD.jtProBuscador.getColumnModel().getColumn(UtilidadPBuscar.apellidos).setPreferredWidth(50);
//        vistaCRUD.jtProBuscador.getColumnModel().getColumn(UtilidadPBuscar.dniruc).setPreferredWidth(70);
//        vistaCRUD.jtProBuscador.getColumnModel().getColumn(UtilidadPBuscar.provincia).setPreferredWidth(70);
//        vistaCRUD.jtProBuscador.getColumnModel().getColumn(UtilidadPBuscar.nomfinca).setPreferredWidth(70);
//        vistaCRUD.jtProBuscador.getColumnModel().getColumn(UtilidadPBuscar.nomanexo).setPreferredWidth(50);
//        vistaCRUD.jtProBuscador.getColumnModel().getColumn(UtilidadPBuscar.estado).setPreferredWidth(60);
//
//        JTableHeader jtableHeader = vistaCRUD.jtProBuscador.getTableHeader();
//        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
//        vistaCRUD.jtProBuscador.setTableHeader(jtableHeader);
//
//        vistaCRUD.jScrollPane1.setViewportView(vistaCRUD.jtProBuscador);
//    }
//
//    @Override
//    public void mouseClicked(MouseEvent me) {
//        if (me.getSource() == vistaCRUD.jtProBuscador) {
//
//            if (me.getClickCount() == 1) {
//                vistaCRUD.btnSeleccionar.setEnabled(true);
//            } else {
//                vistaCRUD.btnSeleccionar.setEnabled(false);
//            }
//        }
//    }
//
//    @Override
//    public void mousePressed(MouseEvent me) {
//
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent me) {
//
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent me) {
//
//    }
//
//    @Override
//    public void mouseExited(MouseEvent me) {
//
//    }
//
//    @Override
//    public void keyTyped(KeyEvent ke) {
//
//    }
//
//    @Override
//    public void keyPressed(KeyEvent ke) {
//
//    }
//
//    @Override
//    public void keyReleased(KeyEvent ke) {
//        idempresa = Integer.valueOf(TraIni.lblEmpresa.getText());
//        if (ke.getSource() == vistaCRUD.txtBuscar) {
//            try {
//                texto = vistaCRUD.txtBuscar.getText();
//                construirTablabuscar(idempresa, texto);
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "NO SE ENCUENTRA EL REGISTRO");
//            }
//        }
//    }
//}
