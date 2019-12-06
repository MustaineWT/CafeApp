///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Controlador;
//
//import Uti.GestionCeldas;
//import Uti.GestionEncabezadoTabla;
//import dao.TrackingDao;
//import java.awt.Color;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.JTableHeader;
//import modelo.Empresas;
//import vista.TrackingCafe;
//
///**
// *
// * @author MustainE
// */
//public class ControladorTrackingVerStandard implements MouseListener, ActionListener {
//
//    TrackingCafe vistaCRUD = new TrackingCafe();
//    TrackingDao modeloCRUD = new TrackingDao();
//    String idempresa = "";
//
//    public ControladorTrackingVerStandard(TrackingCafe vistaCRUD, TrackingDao modeloCRUD) {
//        this.modeloCRUD = modeloCRUD;
//        this.vistaCRUD = vistaCRUD;
//        this.vistaCRUD.btnBusca.addActionListener(this);
//        this.vistaCRUD.jtSeguimiento.addMouseListener(this);
//    }
//
//    public void InicializarCrud() {
//
//    }
//
//    public void LlenarTabla(JTable tablaD) {
//        
//        
//        
//        
//        
//        
//        
//        
//        vistaCRUD.lblECP.setText(String.valueOf(modeloCRUD.Totalesini().get(0).getCpdisponible()));
//        vistaCRUD.lblEOrg.setText(String.valueOf(modeloCRUD.Totalesini().get(0).getOrgdisponible()));
//        vistaCRUD.lblEFairTrade.setText(String.valueOf(modeloCRUD.Totalesini().get(0).getFtdisponible()));
//        vistaCRUD.lblERainf.setText(String.valueOf(modeloCRUD.Totalesini().get(0).getRainfdisponible()));
//        vistaCRUD.lblEConv.setText(String.valueOf(modeloCRUD.Totalesini().get(0).getConvdisponible()));
//        DefaultTableModel modeloT = new DefaultTableModel();
//        
//         vistaCRUD.jtSeguimiento.getTableHeader().setReorderingAllowed(false);
//        vistaCRUD.jtSeguimiento.setRowHeight(25);//tamaño de las celdas
//        vistaCRUD.jtSeguimiento.setGridColor(new java.awt.Color(0, 0, 0));
//        //Se define el tamaño de largo para cada columna y su contenido
//        
//         tablaD.setModel(modeloT);
//        JTableHeader jtableHeader = tablaD.getTableHeader();
//        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
//        tablaD.setTableHeader(jtableHeader);
//      
//        modeloT.addColumn("Emp");
//        modeloT.addColumn("IdOrg");
//        modeloT.addColumn("IdCP");
//        modeloT.addColumn("IdCafeP.");
//        modeloT.addColumn("Código");
//        modeloT.addColumn("Apellidos");
//        modeloT.addColumn("Nombres");
//        modeloT.addColumn("Dni");
//        modeloT.addColumn("Finca");
//        modeloT.addColumn("Anexo");
//        modeloT.addColumn("CP.I.");
//        modeloT.addColumn("Org.I.");
//        modeloT.addColumn("Ft.I.");
//        modeloT.addColumn("Rainf.I.");
//        modeloT.addColumn("Conv.I.");
//        modeloT.addColumn("Cp.A.");
//        modeloT.addColumn("Org.A.");
//        modeloT.addColumn("Ft.A.");
//        modeloT.addColumn("Rainf.A.");
//        modeloT.addColumn("Conv.A.");
//        modeloT.addColumn("Cp.D.");
//        modeloT.addColumn("Org.D.");
//        modeloT.addColumn("Ft.D.");
//        modeloT.addColumn("Rainf.D.");
//        modeloT.addColumn("Conv.D.");
//        tablaD.getColumnModel().getColumn(0).setPreferredWidth(40);
//        tablaD.getColumnModel().getColumn(1).setPreferredWidth(100);
//        tablaD.getColumnModel().getColumn(2).setPreferredWidth(40);
//        tablaD.getColumnModel().getColumn(3).setPreferredWidth(100);
//        tablaD.getColumnModel().getColumn(4).setPreferredWidth(100);
//        tablaD.getColumnModel().getColumn(5).setPreferredWidth(100);
//        tablaD.getColumnModel().getColumn(7).setPreferredWidth(100);
//        tablaD.getColumnModel().getColumn(8).setPreferredWidth(100);
//        tablaD.getColumnModel().getColumn(9).setPreferredWidth(100);
//        tablaD.getColumnModel().getColumn(10).setPreferredWidth(60);
//        tablaD.getColumnModel().getColumn(11).setPreferredWidth(60);
//        tablaD.getColumnModel().getColumn(12).setPreferredWidth(60);
//        tablaD.getColumnModel().getColumn(13).setPreferredWidth(60);
//        tablaD.getColumnModel().getColumn(14).setPreferredWidth(60);
//        tablaD.getColumnModel().getColumn(15).setPreferredWidth(60);
//        tablaD.getColumnModel().getColumn(16).setPreferredWidth(60);
//        tablaD.getColumnModel().getColumn(17).setPreferredWidth(60);
//        tablaD.getColumnModel().getColumn(18).setPreferredWidth(60);
//        tablaD.getColumnModel().getColumn(19).setPreferredWidth(60);
//        tablaD.getColumnModel().getColumn(20).setPreferredWidth(60);
//        tablaD.getColumnModel().getColumn(21).setPreferredWidth(60);
//        tablaD.getColumnModel().getColumn(22).setPreferredWidth(60);
//        tablaD.getColumnModel().getColumn(23).setPreferredWidth(60);
//        tablaD.getColumnModel().getColumn(24).setPreferredWidth(60);
//
//        Object[] columna = new Object[25];
//        
//        int numRegistros = modeloCRUD.listTrackingini().size();
//        for (int i = 0; i < numRegistros; i++) {
//            columna[0] = modeloCRUD.listTrackingini().get(i).getIdempresa();
//            columna[1] = modeloCRUD.listTrackingini().get(i).getIdorga();
//            columna[2] = modeloCRUD.listTrackingini().get(i).getIdcp();
//            columna[3] = modeloCRUD.listTrackingini().get(i).getIdcafepractice();
//            columna[4] = modeloCRUD.listTrackingini().get(i).getCodagri();
//            columna[5] = modeloCRUD.listTrackingini().get(i).getApeagri();
//            columna[6] = modeloCRUD.listTrackingini().get(i).getNomagri();
//            columna[7] = modeloCRUD.listTrackingini().get(i).getDniagri();
//            columna[8] = modeloCRUD.listTrackingini().get(i).getNomfinca();
//            columna[9] = modeloCRUD.listTrackingini().get(i).getNomanexo();
//            columna[10] = modeloCRUD.listTrackingini().get(i).getCpinicial();
//            columna[11] = modeloCRUD.listTrackingini().get(i).getOrginicial();
//            columna[12] = modeloCRUD.listTrackingini().get(i).getFtinicial();
//            columna[13] = modeloCRUD.listTrackingini().get(i).getRainfinicial();
//            columna[14] = modeloCRUD.listTrackingini().get(i).getConvinicial();
//            columna[15] = modeloCRUD.listTrackingini().get(i).getCpavance();
//            columna[16] = modeloCRUD.listTrackingini().get(i).getOrgavance();
//            columna[17] = modeloCRUD.listTrackingini().get(i).getFtavance();
//            columna[18] = modeloCRUD.listTrackingini().get(i).getRainfavance();
//            columna[19] = modeloCRUD.listTrackingini().get(i).getConvavance();
//            columna[20] = modeloCRUD.listTrackingini().get(i).getCpdisponible();
//            columna[21] = modeloCRUD.listTrackingini().get(i).getOrgdisponible();
//            columna[22] = modeloCRUD.listTrackingini().get(i).getFtdisponible();
//            columna[23] = modeloCRUD.listTrackingini().get(i).getRainfdisponible();
//            columna[24] = modeloCRUD.listTrackingini().get(i).getConvdisponible();
//            modeloT.addRow(columna);
//        }
//    }
//
//    public void LlenarTablabutton(JTable tablaD) {
//        DefaultTableModel modeloT = new DefaultTableModel();
//       
//         vistaCRUD.jtSeguimiento.getTableHeader().setReorderingAllowed(false);
//        vistaCRUD.jtSeguimiento.setRowHeight(25);//tamaño de las celdas
//        vistaCRUD.jtSeguimiento.setGridColor(new java.awt.Color(0, 0, 0));
//        //Se define el tamaño de largo para cada columna y su contenido
//        
//        tablaD.setModel(modeloT);
//        JTableHeader jtableHeader = tablaD.getTableHeader();
//        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
//        tablaD.setTableHeader(jtableHeader);
//        modeloT.addColumn("Emp");
//        modeloT.addColumn("IdOrg");
//        modeloT.addColumn("IdCP");
//        modeloT.addColumn("IdCafeP.");
//        modeloT.addColumn("Código");
//        modeloT.addColumn("Apellidos");
//        modeloT.addColumn("Nombres");
//        modeloT.addColumn("Dni");
//        modeloT.addColumn("Finca");
//        modeloT.addColumn("Anexo");
//        modeloT.addColumn("CP.I.");
//        modeloT.addColumn("Org.I.");
//        modeloT.addColumn("Ft.I.");
//        modeloT.addColumn("Rainf.I.");
//        modeloT.addColumn("Conv.I.");
//        modeloT.addColumn("Cp.A.");
//        modeloT.addColumn("Org.A.");
//        modeloT.addColumn("Ft.A.");
//        modeloT.addColumn("Rainf.A.");
//        modeloT.addColumn("Conv.A.");
//        modeloT.addColumn("Cp.D.");
//        modeloT.addColumn("Org.D.");
//        modeloT.addColumn("Ft.D.");
//        modeloT.addColumn("Rainf.D.");
//        modeloT.addColumn("Conv.D.");
//        tablaD.getColumnModel().getColumn(0).setPreferredWidth(40);
//        tablaD.getColumnModel().getColumn(1).setPreferredWidth(100);
//        tablaD.getColumnModel().getColumn(2).setPreferredWidth(40);
//        tablaD.getColumnModel().getColumn(3).setPreferredWidth(100);
//        tablaD.getColumnModel().getColumn(4).setPreferredWidth(100);
//        tablaD.getColumnModel().getColumn(5).setPreferredWidth(100);
//        tablaD.getColumnModel().getColumn(7).setPreferredWidth(100);
//        tablaD.getColumnModel().getColumn(8).setPreferredWidth(100);
//        tablaD.getColumnModel().getColumn(9).setPreferredWidth(100);
//        tablaD.getColumnModel().getColumn(10).setPreferredWidth(60);
//        tablaD.getColumnModel().getColumn(11).setPreferredWidth(60);
//        tablaD.getColumnModel().getColumn(12).setPreferredWidth(60);
//        tablaD.getColumnModel().getColumn(13).setPreferredWidth(60);
//        tablaD.getColumnModel().getColumn(14).setPreferredWidth(60);
//        tablaD.getColumnModel().getColumn(15).setPreferredWidth(60);
//        tablaD.getColumnModel().getColumn(16).setPreferredWidth(60);
//        tablaD.getColumnModel().getColumn(17).setPreferredWidth(60);
//        tablaD.getColumnModel().getColumn(18).setPreferredWidth(60);
//        tablaD.getColumnModel().getColumn(19).setPreferredWidth(60);
//        tablaD.getColumnModel().getColumn(20).setPreferredWidth(60);
//        tablaD.getColumnModel().getColumn(21).setPreferredWidth(60);
//        tablaD.getColumnModel().getColumn(22).setPreferredWidth(60);
//        tablaD.getColumnModel().getColumn(23).setPreferredWidth(60);
//        tablaD.getColumnModel().getColumn(24).setPreferredWidth(60);
//        Object[] columna = new Object[25];
//        int numRegistros = modeloCRUD.listTracking(idempresa).size();
//        for (int i = 0; i < numRegistros; i++) {
//            columna[0] = modeloCRUD.listTracking(idempresa).get(i).getIdempresa();
//            columna[1] = modeloCRUD.listTracking(idempresa).get(i).getIdorga();
//            columna[2] = modeloCRUD.listTracking(idempresa).get(i).getIdcp();
//            columna[3] = modeloCRUD.listTracking(idempresa).get(i).getIdcafepractice();
//            columna[4] = modeloCRUD.listTracking(idempresa).get(i).getCodagri();
//            columna[5] = modeloCRUD.listTracking(idempresa).get(i).getApeagri();
//            columna[6] = modeloCRUD.listTracking(idempresa).get(i).getNomagri();
//            columna[7] = modeloCRUD.listTracking(idempresa).get(i).getDniagri();
//            columna[8] = modeloCRUD.listTracking(idempresa).get(i).getNomfinca();
//            columna[9] = modeloCRUD.listTracking(idempresa).get(i).getNomanexo();
//            columna[10] = modeloCRUD.listTracking(idempresa).get(i).getCpinicial();
//            columna[11] = modeloCRUD.listTracking(idempresa).get(i).getOrginicial();
//            columna[12] = modeloCRUD.listTracking(idempresa).get(i).getFtinicial();
//            columna[13] = modeloCRUD.listTracking(idempresa).get(i).getRainfinicial();
//            columna[14] = modeloCRUD.listTracking(idempresa).get(i).getConvinicial();
//            columna[15] = modeloCRUD.listTracking(idempresa).get(i).getCpavance();
//            columna[16] = modeloCRUD.listTracking(idempresa).get(i).getOrgavance();
//            columna[17] = modeloCRUD.listTracking(idempresa).get(i).getFtavance();
//            columna[18] = modeloCRUD.listTracking(idempresa).get(i).getRainfavance();
//            columna[19] = modeloCRUD.listTracking(idempresa).get(i).getConvavance();
//            columna[20] = modeloCRUD.listTracking(idempresa).get(i).getCpdisponible();
//            columna[21] = modeloCRUD.listTracking(idempresa).get(i).getOrgdisponible();
//            columna[22] = modeloCRUD.listTracking(idempresa).get(i).getFtdisponible();
//            columna[23] = modeloCRUD.listTracking(idempresa).get(i).getRainfdisponible();
//            columna[24] = modeloCRUD.listTracking(idempresa).get(i).getConvdisponible();
//            modeloT.addRow(columna);
//        }
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == vistaCRUD.btnBusca) {
//            Empresas em = (Empresas) vistaCRUD.jcbEmpresa.getSelectedItem();
//            idempresa = em.getIdempresas().toString();
//            LlenarTabla(vistaCRUD.jtSeguimiento);
//            vistaCRUD.lblECP.setText(String.valueOf(modeloCRUD.Totales(idempresa).get(0).getCpdisponible()));
//            vistaCRUD.lblEOrg.setText(String.valueOf(modeloCRUD.Totales(idempresa).get(0).getOrgdisponible()));
//            vistaCRUD.lblEFairTrade.setText(String.valueOf(modeloCRUD.Totales(idempresa).get(0).getFtdisponible()));
//            vistaCRUD.lblERainf.setText(String.valueOf(modeloCRUD.Totales(idempresa).get(0).getRainfdisponible()));
//            vistaCRUD.lblEConv.setText(String.valueOf(modeloCRUD.Totales(idempresa).get(0).getConvdisponible()));
//
//        }
//
//    }
//
//    @Override
//    public void mouseClicked(MouseEvent me) {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void mousePressed(MouseEvent me) {
//        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent me) {
//        //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent me) {
////        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void mouseExited(MouseEvent me) {
//        //      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//}
