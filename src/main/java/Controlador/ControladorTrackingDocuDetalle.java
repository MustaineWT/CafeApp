///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Controlador;
//
//import Uti.GestionCeldas;
//import static Uti.GestionCeldas.isNumeric;
//import Uti.GestionEncabezadoTabla;
//import Uti.ModeloTabla;
//import Uti.UtilidadesDocu;
//import dao.TrackingDocuDao;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.text.DecimalFormat;
//import java.util.ArrayList;
//import javax.swing.JOptionPane;
//import javax.swing.table.JTableHeader;
//import modelo.DetalleDocumento;
//import modelo.TrackingDocu;
//import vista.TrackingDocuDetalle;
//
///**
// *
// * @author MustainE
// */
//public class ControladorTrackingDocuDetalle implements ActionListener, MouseListener, KeyListener {
//
//    TrackingDocuDetalle vistaCRUD = new TrackingDocuDetalle();
//    TrackingDocuDao modeloCRUD = new TrackingDocuDao();
//    ArrayList<TrackingDocu> listaPersonas;
//    ArrayList<DetalleDocumento> listaDetalle;
//    ModeloTabla modelojt;
//    private int filasTabla;
//    private int columnasTabla;
//     DecimalFormat formatea = new DecimalFormat("###,###.##");
//    String idempresa;
//    String texto;
//    double t;
//    double p;
//
//    public ControladorTrackingDocuDetalle(TrackingDocuDetalle vistaCRUD, TrackingDocuDao modeloCRUD) {
//        this.modeloCRUD = modeloCRUD;
//        this.vistaCRUD = vistaCRUD;
//        this.vistaCRUD.btnBusca.addActionListener(this);
//        this.vistaCRUD.jtDetalleDocumento.addMouseListener(this);
//        //this.vistaCRUD.txtBusca.addKeyListener(this);
//    }
//
//    public void InicializarCrud() {
//
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//        if (e.getSource() == vistaCRUD.btnBusca) {
////            Empresas em = (Empresas) vistaCRUD.jcbEmpresa.getSelectedItem();
//  ///          idempresa = em.getIdempresas().toString();
//     //       vistaCRUD.lblEOrg.setText(String.valueOf(modeloCRUD.TotalGuiaCoagro(idempresa).get(0).getNroguia()));
//            //vistaCRUD.lblECp.setText(String.valueOf(modeloCRUD.TotalGuiaAprosem(idempresa).get(0).getNroguia()));
//            //vistaCRUD.lblEFairTrade.setText(String.valueOf(modeloCRUD.TotalGuiaCaniari(idempresa).get(0).getNroguia()));
//            //vistaCRUD.lblERainf.setText(String.valueOf(modeloCRUD.TotalGuiaEcovrae(idempresa).get(0).getNroguia()));            
//            
//       //  vistaCRUD.lblTcCoagro.setText(String.valueOf(modeloCRUD.TotalTcCoagro(idempresa).get(0).getTcs()));
//            //vistaCRUD.lblTcCoagro.setText(String.valueOf(modeloCRUD.TotalTcAprosem(idempresa).get(0).getTcs()));
//            //vistaCRUD.lblTcCoagro.setText(String.valueOf(modeloCRUD.TotalTcCaniari(idempresa).get(0).getTcs()));
//            //vistaCRUD.lblTcCoagro.setText(String.valueOf(modeloCRUD.TotalTcEcovrae(idempresa).get(0).getTcs()));
//        //    construirTabla();
//        }
//
//    }
//
//    public void construirTabla() {
//
//        listaPersonas = dao.TrackingDocuDao.listTrackingDocu(idempresa);
//
//        ArrayList<String> titulosList = new ArrayList<>();
//
//        titulosList.add("IdDocutraza");
//        titulosList.add("IdEmpresa");
//        titulosList.add("IdCliente");
//        titulosList.add("RazonSocial");
//        titulosList.add("Fecha");
//        titulosList.add("Certificado");
//        titulosList.add("NroGuia");
//        titulosList.add("NroContrato");
//        titulosList.add("NroTrilla");
//        titulosList.add("NroGuiaMcmNaki");
//        titulosList.add("Factura");
//        titulosList.add("Sacos");
//        titulosList.add("Kb");
//        titulosList.add("Kn");
//        titulosList.add("PrimaFairTrade");
//        titulosList.add("NotaCred/Debito");
//        titulosList.add("Tcs");
//        titulosList.add("Condición");
//        titulosList.add("Estado");        
//        titulosList.add(" ");
//
//        //se asignan las columnas al arreglo para enviarse al momento de construir la tabla
//        String titulos[] = new String[titulosList.size()];
//        for (int i = 0; i < titulos.length; i++) {
//            titulos[i] = titulosList.get(i);
//        }
////obtenemos los datos de la lista y los guardamos en la matriz
////que luego se manda a construir la tabla
//
//        Object[][] data = obtenerMatrizDatos(titulosList);
//        construirTabla(titulos, data);
//        if (vistaCRUD.jtDetalleDocumento.getRowCount() > 0) {
//            for (int i = 0; i < vistaCRUD.jtDetalleDocumento.getRowCount(); i++) {
//                String valor21=vistaCRUD.jtDetalleDocumento.getValueAt(i, 11).toString().replace(",","");
//                
//                if(isNumeric(valor21)==true)
//                p = Double.parseDouble(valor21);
//                t += p;
//            }            
//            vistaCRUD.lblCPI.setText(formatea.format(t)+ "");
//            p = 0;
//            t = 0;
//        }
//           if (vistaCRUD.jtDetalleDocumento.getRowCount() > 0) {
//            for (int i = 0; i < vistaCRUD.jtDetalleDocumento.getRowCount(); i++) {
//                String valor22=vistaCRUD.jtDetalleDocumento.getValueAt(i, 12).toString().replace(",","");
//                
//                if(isNumeric(valor22)==true)
//                p = Double.parseDouble(valor22);
//                t += p;
//            }            
//            vistaCRUD.lblORGI.setText(formatea.format(t)+ "");
//            p = 0;
//            t = 0;
//        }
//            if (vistaCRUD.jtDetalleDocumento.getRowCount() > 0) {
//            for (int i = 0; i < vistaCRUD.jtDetalleDocumento.getRowCount(); i++) {
//                String valor23=vistaCRUD.jtDetalleDocumento.getValueAt(i, 13).toString().replace(",","");
//                
//                if(isNumeric(valor23)==true)
//                p = Double.parseDouble(valor23);
//                t += p;
//            }            
//            vistaCRUD.lblFTI.setText(formatea.format(t)+ "");
//            p = 0;
//            t = 0;
//        }
//
//    }
//
//    public void construirTablaini(String iddocutraza) {
//
//        listaDetalle = dao.TrackingDocuDao.listTrackingDetalledocu(iddocutraza);
//
//        ArrayList<String> titulosList = new ArrayList<>();
//
//        titulosList.add("IdDocutraza");
//        titulosList.add("IdEmpresa");
//        titulosList.add("IdCliente");
//        titulosList.add("RazonSocial");
//        titulosList.add("Fecha");
//        titulosList.add("Certificado");
//        titulosList.add("NroGuia");
//        titulosList.add("NroContrato");
//        titulosList.add("NroTrilla");
//        titulosList.add("NroGuiaMcmNaki");
//        titulosList.add("Factura");
//        titulosList.add("Sacos");
//        titulosList.add("Kb");
//        titulosList.add("Kn");
//        titulosList.add("PrimaFairTrade");
//        titulosList.add("NotaCred/Debito");
//        titulosList.add("Tcs");
//        titulosList.add("Condición");
//        titulosList.add("Estado");        
//        titulosList.add(" ");
//
//        //se asignan las columnas al arreglo para enviarse al momento de construir la tabla
//        String titulos[] = new String[titulosList.size()];
//        for (int i = 0; i < titulos.length; i++) {
//            titulos[i] = titulosList.get(i);
//        }
////obtenemos los datos de la lista y los guardamos en la matriz
////que luego se manda a construir la tabla
//
//        Object[][] data = obtenerMatrizDatos(titulosList);
//        construirTabla(titulos, data);
//        if (vistaCRUD.jtDetalleDocumento.getRowCount() > 0) {
//            for (int i = 0; i < vistaCRUD.jtDetalleDocumento.getRowCount(); i++) {
//                String valor21=vistaCRUD.jtDetalleDocumento.getValueAt(i, 11).toString().replace(",","");
//                
//                if(isNumeric(valor21)==true)
//                p = Double.parseDouble(valor21);
//                t += p;
//            }            
//            vistaCRUD.lblCPI.setText(formatea.format(t)+ "");
//            p = 0;
//            t = 0;
//        }
//           if (vistaCRUD.jtDetalleDocumento.getRowCount() > 0) {
//            for (int i = 0; i < vistaCRUD.jtDetalleDocumento.getRowCount(); i++) {
//                String valor22=vistaCRUD.jtDetalleDocumento.getValueAt(i, 12).toString().replace(",","");
//                
//                if(isNumeric(valor22)==true)
//                p = Double.parseDouble(valor22);
//                t += p;
//            }            
//            vistaCRUD.lblORGI.setText(formatea.format(t)+ "");
//            p = 0;
//            t = 0;
//        }
//            if (vistaCRUD.jtDetalleDocumento.getRowCount() > 0) {
//            for (int i = 0; i < vistaCRUD.jtDetalleDocumento.getRowCount(); i++) {
//                String valor23=vistaCRUD.jtDetalleDocumento.getValueAt(i, 13).toString().replace(",","");
//                
//                if(isNumeric(valor23)==true)
//                p = Double.parseDouble(valor23);
//                t += p;
//            }            
//            vistaCRUD.lblFTI.setText(formatea.format(t)+ "");
//            p = 0;
//            t = 0;
//        }
//       
//    }
// public void construirTablabusca() {
//
//        listaPersonas = dao.TrackingDocuDao.listTrackingDocubusca(texto);
//
//        ArrayList<String> titulosList = new ArrayList<>();
//
//        titulosList.add("IdDocutraza");
//        titulosList.add("IdEmpresa");
//        titulosList.add("IdCliente");
//        titulosList.add("RazonSocial");
//        titulosList.add("Fecha");
//        titulosList.add("Certificado");
//        titulosList.add("NroGuia");
//        titulosList.add("NroContrato");
//        titulosList.add("NroTrilla");
//        titulosList.add("NroGuiaMcmNaki");
//        titulosList.add("Factura");
//        titulosList.add("Sacos");
//        titulosList.add("Kb");
//        titulosList.add("Kn");
//        titulosList.add("PrimaFairTrade");
//        titulosList.add("NotaCred/Debito");
//        titulosList.add("Tcs");
//        titulosList.add("Condición");
//        titulosList.add("Estado");
//        titulosList.add(" ");
//
//        //se asignan las columnas al arreglo para enviarse al momento de construir la tabla
//        String titulos[] = new String[titulosList.size()];
//        for (int i = 0; i < titulos.length; i++) {
//            titulos[i] = titulosList.get(i);
//        }
////obtenemos los datos de la lista y los guardamos en la matriz
////que luego se manda a construir la tabla
//
//        Object[][] data = obtenerMatrizDatos(titulosList);
//        construirTabla(titulos, data);
//       if (vistaCRUD.jtDetalleDocumento.getRowCount() > 0) {
//            for (int i = 0; i < vistaCRUD.jtDetalleDocumento.getRowCount(); i++) {
//                String valor21=vistaCRUD.jtDetalleDocumento.getValueAt(i, 11).toString().replace(",","");
//                
//                if(isNumeric(valor21)==true)
//                p = Double.parseDouble(valor21);
//                t += p;
//            }            
//            vistaCRUD.lblCPI.setText(formatea.format(t)+ "");
//            p = 0;
//            t = 0;
//        }
//           if (vistaCRUD.jtDetalleDocumento.getRowCount() > 0) {
//            for (int i = 0; i < vistaCRUD.jtDetalleDocumento.getRowCount(); i++) {
//                String valor22=vistaCRUD.jtDetalleDocumento.getValueAt(i, 12).toString().replace(",","");
//                
//                if(isNumeric(valor22)==true)
//                p = Double.parseDouble(valor22);
//                t += p;
//            }            
//            vistaCRUD.lblORGI.setText(formatea.format(t)+ "");
//            p = 0;
//            t = 0;
//        }
//            if (vistaCRUD.jtDetalleDocumento.getRowCount() > 0) {
//            for (int i = 0; i < vistaCRUD.jtDetalleDocumento.getRowCount(); i++) {
//                String valor23=vistaCRUD.jtDetalleDocumento.getValueAt(i, 13).toString().replace(",","");
//                
//                if(isNumeric(valor23)==true)
//                p = Double.parseDouble(valor23);
//                t += p;
//            }            
//            vistaCRUD.lblFTI.setText(formatea.format(t)+ "");
//            p = 0;
//            t = 0;
//        }
//    }
//  
//    private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {
//
////se crea la matriz donde las filas son dinamicas pues corresponde
////a todos los usuarios, mientras que las columnas son estaticas
//// correspondiendo a las columnas definidas por defecto
////
//        String informacion[][] = new String[listaPersonas.size()][titulosList.size()];
//
//        for (int x = 0; x < informacion.length; x++) {
//
//            informacion[x][UtilidadesDocu.iddocutraza] = listaPersonas.get(x).getIddocutraza() + "";
//            informacion[x][UtilidadesDocu.idempresa] = listaPersonas.get(x).getIdempresa() + "";
//            informacion[x][UtilidadesDocu.idcliente] = listaPersonas.get(x).getIdcliente() + "";
//            informacion[x][UtilidadesDocu.razonsocial] = listaPersonas.get(x).getRazonsocial() + "";
//            informacion[x][UtilidadesDocu.fecha] = listaPersonas.get(x).getFecha() + "";
//            informacion[x][UtilidadesDocu.certificado] = listaPersonas.get(x).getCertificado() + "";
//            informacion[x][UtilidadesDocu.nroguia] = listaPersonas.get(x).getNroguia() + "";
//            informacion[x][UtilidadesDocu.nrocontrato] = listaPersonas.get(x).getNrocontrato() + "";
//            informacion[x][UtilidadesDocu.nrotrilla] = listaPersonas.get(x).getNrotrilla() + "";
//            informacion[x][UtilidadesDocu.nroguiamcmnaki] = listaPersonas.get(x).getNroguiamcmnaki() + "";
//            informacion[x][UtilidadesDocu.factura] = listaPersonas.get(x).getFactura() + "";
//            informacion[x][UtilidadesDocu.sacos] = listaPersonas.get(x).getSacos() + "";
//            informacion[x][UtilidadesDocu.kb] = listaPersonas.get(x).getKb() + "";
//            informacion[x][UtilidadesDocu.kn] = listaPersonas.get(x).getKn() + "";
//            informacion[x][UtilidadesDocu.primafairtrade] = listaPersonas.get(x).getPrimafairtrade() + "";
//            informacion[x][UtilidadesDocu.notacredito] = listaPersonas.get(x).getNotacredito() + "";
//            informacion[x][UtilidadesDocu.tcs] = listaPersonas.get(x).getTcs() + "";
//            informacion[x][UtilidadesDocu.condicion] = listaPersonas.get(x).getCondicion() + "";
//            informacion[x][UtilidadesDocu.estado] = listaPersonas.get(x).getEstado() + "";
//            //se asignan las plabras clave para que en la clase GestionCeldas se use para asignar el icono correspondiente
//            informacion[x][UtilidadesDocu.VERMAS] = "VERMAS";
//            //informacion[x][UtilidadesDocu.EVENTO] = "EVENTO";
//        }
//
//        return informacion;
//    }
//
////
//// Con los titulos y la información a mostrar se crea el modelo para 
//// poder personalizar la tabla, asignando tamaño de celdas tanto en ancho como en alto
//// así como los tipos de datos que va a poder soportar.
//// @param titulos
//// @param data
////
//    private void construirTabla(String[] titulos, Object[][] data) {
//        modelojt = new ModeloTabla(data, titulos);
//        //se asigna el modelo a la tabla
//        vistaCRUD.jtDetalleDocumento.setModel(modelojt);
//
//        filasTabla = vistaCRUD.jtDetalleDocumento.getRowCount();
//        columnasTabla = vistaCRUD.jtDetalleDocumento.getColumnCount();
//
//        //se asigna el tipo de dato que tendrán las celdas de cada columna definida respectivamente para validar su personalización
//        vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(UtilidadesDocu.sacos).setCellRenderer(new GestionCeldas("numerico"));
//        vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(UtilidadesDocu.kb).setCellRenderer(new GestionCeldas("numerico"));
//        vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(UtilidadesDocu.kn).setCellRenderer(new GestionCeldas("numerico"));        
//        vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(UtilidadesDocu.VERMAS).setCellRenderer(new GestionCeldas("icono"));        
//
//        //se recorre y asigna el resto de celdas que serian las que almacenen datos de tipo texto
//       // for (int i = 0; i < titulos.length - 8; i++) {//se resta 7 porque las ultimas 7 columnas se definen arriba
//        //    System.out.println(i);
//            vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("texto"));
//            vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("texto"));
//            vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("texto"));
//            vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(3).setCellRenderer(new GestionCeldas("texto"));            
//            vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(4).setCellRenderer(new GestionCeldas("texto"));  
//            vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(5).setCellRenderer(new GestionCeldas("texto"));  
//            vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(6).setCellRenderer(new GestionCeldas("texto"));  
//            vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(7).setCellRenderer(new GestionCeldas("texto"));  
//            vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(8).setCellRenderer(new GestionCeldas("texto"));  
//            vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(9).setCellRenderer(new GestionCeldas("texto"));  
//            vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(10).setCellRenderer(new GestionCeldas("texto"));  
//            vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(14).setCellRenderer(new GestionCeldas("texto"));  
//            vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(15).setCellRenderer(new GestionCeldas("texto"));  
//            vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(16).setCellRenderer(new GestionCeldas("texto"));  
//            vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(17).setCellRenderer(new GestionCeldas("texto"));  
//            vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(18).setCellRenderer(new GestionCeldas("texto"));  
//         //   vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(19).setCellRenderer(new GestionCeldas("icono"));  
//        //}
//
//        vistaCRUD.jtDetalleDocumento.getTableHeader().setReorderingAllowed(false);
//        vistaCRUD.jtDetalleDocumento.setRowHeight(25);//tamaño de las celdas
//        vistaCRUD.jtDetalleDocumento.setGridColor(new java.awt.Color(0, 0, 0));
//        //Se define el tamaño de largo para cada columna y su contenido
//        vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(UtilidadesDocu.iddocutraza).setPreferredWidth(40);//nombre
//        vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(UtilidadesDocu.idempresa).setPreferredWidth(40);//nombre
//        vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(UtilidadesDocu.idcliente).setPreferredWidth(60);//telefono
//        vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(UtilidadesDocu.razonsocial).setPreferredWidth(60);//profesion
//        vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(UtilidadesDocu.fecha).setPreferredWidth(50);//edad
//        vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(UtilidadesDocu.certificado).setPreferredWidth(70);//nota1
//        vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(UtilidadesDocu.nroguia).setPreferredWidth(70);//nota2
//        vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(UtilidadesDocu.nrocontrato).setPreferredWidth(50);//nota3
//        vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(UtilidadesDocu.nrotrilla).setPreferredWidth(60);//promedio
//        vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(UtilidadesDocu.nroguiamcmnaki).setPreferredWidth(70);//accion perfil
//        vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(UtilidadesDocu.factura).setPreferredWidth(60);//accion evento
//        vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(UtilidadesDocu.sacos).setPreferredWidth(60);//accion evento
//        vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(UtilidadesDocu.kb).setPreferredWidth(60);//accion evento
//        vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(UtilidadesDocu.kn).setPreferredWidth(60);//accion evento
//        vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(UtilidadesDocu.primafairtrade).setPreferredWidth(60);//accion evento
//        vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(UtilidadesDocu.notacredito).setPreferredWidth(60);//accion evento
//        vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(UtilidadesDocu.tcs).setPreferredWidth(60);//accion evento
//        vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(UtilidadesDocu.condicion).setPreferredWidth(60);//accion evento
//        vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(UtilidadesDocu.estado).setPreferredWidth(20);//accion evento
//        vistaCRUD.jtDetalleDocumento.getColumnModel().getColumn(UtilidadesDocu.VERMAS).setPreferredWidth(65);//accion evento
//
//        //personaliza el encabezado
//        JTableHeader jtableHeader = vistaCRUD.jtDetalleDocumento.getTableHeader();
//        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
//        vistaCRUD.jtDetalleDocumento.setTableHeader(jtableHeader);
//
//        //se asigna la tabla al scrollPane
//     vistaCRUD.jScrollPane1.setViewportView(vistaCRUD.jtDetalleDocumento);
//    }
//
////
//// Este metodo simularia el proceso o la acción que se quiere realizar si 
//// se presiona alguno de los botones o iconos de la tabla
//// @param fila
////
//    private void validarSeleccionMouse(int fila) {
//        UtilidadesDocu.filaSeleccionada = fila;
//
//        //teniendo la fila entonces se obtiene el objeto correspondiente para enviarse como parammetro o imprimir la información
//        TrackingDocu miPersona = new TrackingDocu();
//        miPersona.setIddocutraza(vistaCRUD.jtDetalleDocumento.getValueAt(fila, UtilidadesDocu.iddocutraza).toString());
//        miPersona.setIdempresa(vistaCRUD.jtDetalleDocumento.getValueAt(fila, UtilidadesDocu.idempresa).toString());
//        miPersona.setIdcliente(vistaCRUD.jtDetalleDocumento.getValueAt(fila, UtilidadesDocu.idcliente).toString());
//        miPersona.setRazonsocial(vistaCRUD.jtDetalleDocumento.getValueAt(fila, UtilidadesDocu.razonsocial).toString());
//        miPersona.setFecha(vistaCRUD.jtDetalleDocumento.getValueAt(fila, UtilidadesDocu.fecha).toString());
//        miPersona.setCertificado(vistaCRUD.jtDetalleDocumento.getValueAt(fila, UtilidadesDocu.certificado).toString());
//        miPersona.setNroguia(vistaCRUD.jtDetalleDocumento.getValueAt(fila, UtilidadesDocu.nroguia).toString());
//        miPersona.setNrocontrato(vistaCRUD.jtDetalleDocumento.getValueAt(fila, UtilidadesDocu.nrocontrato).toString());
//        miPersona.setNrotrilla(vistaCRUD.jtDetalleDocumento.getValueAt(fila, UtilidadesDocu.nrotrilla).toString());
//        miPersona.setNroguiamcmnaki(vistaCRUD.jtDetalleDocumento.getValueAt(fila, UtilidadesDocu.nroguiamcmnaki).toString());
//        miPersona.setFactura(vistaCRUD.jtDetalleDocumento.getValueAt(fila, UtilidadesDocu.factura).toString());
//        miPersona.setSacos(Integer.parseInt((String) vistaCRUD.jtDetalleDocumento.getValueAt(fila, UtilidadesDocu.sacos)));
//        miPersona.setKb(Double.parseDouble((String) vistaCRUD.jtDetalleDocumento.getValueAt(fila, UtilidadesDocu.kb)));
//        miPersona.setKn(Double.parseDouble((String) vistaCRUD.jtDetalleDocumento.getValueAt(fila, UtilidadesDocu.kn)));
//        miPersona.setPrimafairtrade(vistaCRUD.jtDetalleDocumento.getValueAt(fila, UtilidadesDocu.primafairtrade).toString());
//        miPersona.setNotacredito(vistaCRUD.jtDetalleDocumento.getValueAt(fila, UtilidadesDocu.notacredito).toString());
//        miPersona.setTcs(vistaCRUD.jtDetalleDocumento.getValueAt(fila, UtilidadesDocu.tcs).toString());
//        miPersona.setCondicion(vistaCRUD.jtDetalleDocumento.getValueAt(fila, UtilidadesDocu.condicion).toString());
//        miPersona.setEstado(vistaCRUD.jtDetalleDocumento.getValueAt(fila, UtilidadesDocu.estado).toString());
//
//        String info = "INFO DOCUMENTO\n";
//        info += "Documento: " + miPersona.getIddocutraza() + "\n";
//        info += "Empresa: " + miPersona.getIdempresa() + "\n";
//        info += "Código Cliente: " + miPersona.getIdcliente() + "\n";
//        info += "Razón Social: " + miPersona.getRazonsocial() + "\n";
//        info += "Fecha: " + miPersona.getFecha() + "\n";
//        info += "Certificado: " + miPersona.getCertificado() + "\n";
//        info += "Guia: " + miPersona.getNroguia() + "\n";
//        info += "Contrato: " + miPersona.getNrocontrato() + "\n";
//        info += "Trilla: " + miPersona.getNrotrilla() + "\n";
//        info += "GuiaMcmNaki: " + miPersona.getNroguiamcmnaki() + "\n";
//        info += "Factura: " + miPersona.getFactura() + "\n";
//        info += "Sacos: " + miPersona.getSacos() + "\n";
//        info += "Kb: " + miPersona.getKb() + "\n";
//        info += "Kn: " + miPersona.getKn() + "\n";
//        info += "PrimaFairtrade: " + miPersona.getPrimafairtrade() + "\n";
//        info += "Nota Cred/Debito: " + miPersona.getNotacredito() + "\n";
//        info += "Tcs: " + miPersona.getTcs() + "\n";
//        info += "Condición: " + miPersona.getCondicion() + "\n";
//        info += "Estado: " + miPersona.getEstado() + "\n";
//
//        JOptionPane.showMessageDialog(null, info);
//    }
//
//    private void validarSeleccionMouseDetalle(int fila) {
//        UtilidadesDocu.filaSeleccionada = fila;
//
//        //teniendo la fila entonces se obtiene el objeto correspondiente para enviarse como parammetro o imprimir la información
//        TrackingDocu miPersona = new TrackingDocu();
//        miPersona.setIddocutraza(vistaCRUD.jtDetalleDocumento.getValueAt(fila, UtilidadesDocu.iddocutraza).toString());
//    }
//    @Override
//    public void mouseClicked(MouseEvent me) {
//        //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        if (me.getSource() == vistaCRUD.jtDetalleDocumento) {
//            //capturo fila o columna dependiendo de mi necesidad
//            if (me.getClickCount() > 1) {
//                int fila = vistaCRUD.jtDetalleDocumento.rowAtPoint(me.getPoint());
//                int columna = vistaCRUD.jtDetalleDocumento.columnAtPoint(me.getPoint());
//                //System.out.println(fila);
//                validarSeleccionMouse(fila);
//            }
//        }
//    }   
//
//    @Override
//    public void mousePressed(MouseEvent me) {
//        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent me) {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent me) {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void mouseExited(MouseEvent me) {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void keyTyped(KeyEvent ke) {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void keyPressed(KeyEvent ke) {
//       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void keyReleased(KeyEvent ke) {
////        if (ke.getSource() == vistaCRUD.txtBusca) {
////               try{
////            texto=vistaCRUD.txtBusca.getText();
////            System.out.println(texto);
////            construirTablabusca();
////               }catch(Exception e){
////                    JOptionPane.showMessageDialog(null, "NO SE ENCEUNTRA EL REGISTRO");
////               }
////        }
//    }
//
//}
