/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Controlador.ControladorCrudDetalleDocutraza;
import Controlador.ControladorCrudDocutraza;
import javax.swing.JOptionPane;
import modelo.DetalleDocutraza;
import static vista.TraIni.dskPrincipal;

/**
 *
 * @author MustainE
 */
public class RDocutraza_Document extends javax.swing.JInternalFrame {

    public RDocutraza_Document() {
        initComponents();
        btnRegTrack.setEnabled(false);
        btnNTrack.setEnabled(false);
        btnEditDocutraza.setEnabled(false);
        txtIdDocutrza.setEnabled(false);
        txtidCompContrato.setEnabled(false);
        txtSerieGuia.setEnabled(false);
        txtCorrelativo.setEnabled(false);
        jdFecha.setEnabled(false);
        txtSacos.setEnabled(false);
        txtKb.setEnabled(false);
        txtKn.setEnabled(false);
        txtFairtrade.setEnabled(false);
        //
        txtSerie.setEnabled(false);
        txtDocCorrelativo.setEnabled(false);
        txtFecha.setEnabled(false);
        btnNDocumento.setEnabled(false);
        btnEditDocumento.setEnabled(false);
        btnRegDocumento.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtCompraContrato = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jcbCliente = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jdFecha = new com.toedter.calendar.JDateChooser();
        jLabel21 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIdDocutrza = new javax.swing.JTextField();
        txtKb = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jcbCondicion = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        txtSerieGuia = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtCorrelativo = new javax.swing.JTextField();
        jcbEstTrack = new javax.swing.JComboBox<>();
        txtSacos = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtKn = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtFairtrade = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jcbCertificado = new javax.swing.JComboBox<>();
        btnRegTrack = new javax.swing.JButton();
        btnEditDocutraza = new javax.swing.JButton();
        btnNTrack = new javax.swing.JButton();
        txtidCompContrato = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        jLabel32 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtIddocumento = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txtDocCorrelativo = new javax.swing.JTextField();
        jcbEstDoc = new javax.swing.JComboBox<>();
        jcbTDocumento = new javax.swing.JComboBox<>();
        btnNDocumento = new javax.swing.JButton();
        btnRegDocumento = new javax.swing.JButton();
        txtIdDocutraza = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnEditDocumento = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtDocutraza = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtAscDocumentos = new javax.swing.JTable();
        btnVerConf = new javax.swing.JButton();
        btnAsigCon = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 0, 51));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("..Registro Documento..");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 0, 51), 1, true), "Mantenimiento de Control de Tracking", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(153, 0, 51))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(153, 0, 51));
        jPanel2.setToolTipText("");
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setForeground(new java.awt.Color(153, 0, 51));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 870, 10));

        jtCompraContrato.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jtCompraContrato.setForeground(new java.awt.Color(51, 51, 255));
        jtCompraContrato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtCompraContrato.setGridColor(new java.awt.Color(0, 51, 153));
        jScrollPane2.setViewportView(jtCompraContrato);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 390, 250));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 0, 51), 1, true), "Registro de control de trackinglist", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11), new java.awt.Color(153, 0, 51))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jcbCliente.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jcbCliente.setForeground(new java.awt.Color(0, 0, 153));
        jcbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "wtorres" }));
        jcbCliente.setToolTipText("");
        jcbCliente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 1, true));
        jPanel3.add(jcbCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 400, -1));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(153, 0, 51));
        jLabel19.setText("Estado:");
        jLabel19.setToolTipText("");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, 20));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 51));
        jLabel5.setText("Condicion:");
        jLabel5.setToolTipText("");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, -1, 20));

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(153, 0, 51));
        jLabel25.setText("Certificado:");
        jLabel25.setToolTipText("");
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 20));
        jPanel3.add(jdFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 110, -1));

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(153, 0, 51));
        jLabel21.setText("Fecha:");
        jLabel21.setToolTipText("");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, -1, 20));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 51));
        jLabel3.setText("idDocutraza:");
        jLabel3.setToolTipText("");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 20));

        txtIdDocutrza.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtIdDocutrza.setForeground(new java.awt.Color(0, 0, 102));
        txtIdDocutrza.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtIdDocutrza.setEnabled(false);
        txtIdDocutrza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdDocutrzaActionPerformed(evt);
            }
        });
        jPanel3.add(txtIdDocutrza, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 60, -1));

        txtKb.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtKb.setForeground(new java.awt.Color(0, 0, 102));
        txtKb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(txtKb, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 80, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 51));
        jLabel4.setText("KBruto:");
        jLabel4.setToolTipText("");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, -1, 20));

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(153, 0, 51));
        jLabel28.setText("Cliente:");
        jLabel28.setToolTipText("");
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 20));

        jcbCondicion.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jcbCondicion.setForeground(new java.awt.Color(0, 0, 153));
        jcbCondicion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Real", "Anulado", "Papeles" }));
        jcbCondicion.setToolTipText("");
        jcbCondicion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 1, true));
        jPanel3.add(jcbCondicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 150, -1));

        jLabel29.setBackground(new java.awt.Color(255, 255, 255));
        jLabel29.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(153, 0, 51));
        jLabel29.setText("SerieGuia:");
        jLabel29.setToolTipText("");
        jPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 20));

        txtSerieGuia.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtSerieGuia.setForeground(new java.awt.Color(0, 0, 102));
        txtSerieGuia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(txtSerieGuia, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 70, -1));

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(153, 0, 51));
        jLabel30.setText("Correlativo:");
        jLabel30.setToolTipText("");
        jPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, -1, 20));

        txtCorrelativo.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtCorrelativo.setForeground(new java.awt.Color(0, 0, 102));
        txtCorrelativo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(txtCorrelativo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 90, -1));

        jcbEstTrack.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jcbEstTrack.setForeground(new java.awt.Color(0, 0, 153));
        jcbEstTrack.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        jcbEstTrack.setToolTipText("");
        jcbEstTrack.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 1, true));
        jPanel3.add(jcbEstTrack, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 120, -1));

        txtSacos.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtSacos.setForeground(new java.awt.Color(0, 0, 102));
        txtSacos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(txtSacos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 60, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 0, 51));
        jLabel7.setText("Sacos:");
        jLabel7.setToolTipText("");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 20));

        txtKn.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtKn.setForeground(new java.awt.Color(0, 0, 102));
        txtKn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(txtKn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 80, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 0, 51));
        jLabel8.setText("KNeto:");
        jLabel8.setToolTipText("");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, 20));

        txtFairtrade.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtFairtrade.setForeground(new java.awt.Color(0, 0, 102));
        txtFairtrade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(txtFairtrade, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 160, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 0, 51));
        jLabel9.setText("Fairtrade:");
        jLabel9.setToolTipText("");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, 20));

        jcbCertificado.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jcbCertificado.setForeground(new java.awt.Color(0, 0, 153));
        jcbCertificado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CP", "CPO", "FT", "FTCP", "FTO", "FTOCP" }));
        jcbCertificado.setToolTipText("");
        jcbCertificado.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 1, true));
        jPanel3.add(jcbCertificado, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 150, -1));

        btnRegTrack.setBackground(new java.awt.Color(0, 153, 153));
        btnRegTrack.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnRegTrack.setForeground(new java.awt.Color(255, 255, 255));
        btnRegTrack.setIcon(new javax.swing.ImageIcon("D:\\Sistema\\Imagenes\\icons8_Save_20px.png")); // NOI18N
        btnRegTrack.setText("Registrar");
        btnRegTrack.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        btnRegTrack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegTrackActionPerformed(evt);
            }
        });
        jPanel3.add(btnRegTrack, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 100, 30));

        btnEditDocutraza.setBackground(new java.awt.Color(0, 153, 153));
        btnEditDocutraza.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEditDocutraza.setForeground(new java.awt.Color(255, 255, 255));
        btnEditDocutraza.setIcon(new javax.swing.ImageIcon("D:\\Sistema\\Imagenes\\icons8_Edit_Property_20px.png")); // NOI18N
        btnEditDocutraza.setText("Editar");
        btnEditDocutraza.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        btnEditDocutraza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditDocutrazaActionPerformed(evt);
            }
        });
        jPanel3.add(btnEditDocutraza, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 100, 30));

        btnNTrack.setBackground(new java.awt.Color(0, 153, 153));
        btnNTrack.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnNTrack.setForeground(new java.awt.Color(255, 255, 255));
        btnNTrack.setIcon(new javax.swing.ImageIcon("D:\\Sistema\\Imagenes\\icons8_Add_List_20px.png")); // NOI18N
        btnNTrack.setText("Nuevo");
        btnNTrack.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        btnNTrack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNTrackActionPerformed(evt);
            }
        });
        jPanel3.add(btnNTrack, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 100, 30));

        txtidCompContrato.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtidCompContrato.setForeground(new java.awt.Color(0, 0, 102));
        txtidCompContrato.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtidCompContrato.setEnabled(false);
        txtidCompContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidCompContratoActionPerformed(evt);
            }
        });
        jPanel3.add(txtidCompContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 60, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 51));
        jLabel6.setText("idCContrato:");
        jLabel6.setToolTipText("");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, 20));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 480, 250));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 0, 51), 1, true), "Registro de Documentos Asociados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 11), new java.awt.Color(153, 0, 51))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(153, 0, 51));
        jLabel20.setText("Estado:");
        jLabel20.setToolTipText("");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, 20));

        jLabel31.setBackground(new java.awt.Color(255, 255, 255));
        jLabel31.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(153, 0, 51));
        jLabel31.setText("Tipo Documento:");
        jLabel31.setToolTipText("");
        jPanel4.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 20));
        jPanel4.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 110, -1));

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(153, 0, 51));
        jLabel32.setText("Fecha:");
        jLabel32.setToolTipText("");
        jPanel4.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 40, 20));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 0, 51));
        jLabel11.setText("idDocumento:");
        jLabel11.setToolTipText("");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 20));

        txtIddocumento.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtIddocumento.setForeground(new java.awt.Color(0, 0, 102));
        txtIddocumento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtIddocumento.setEnabled(false);
        txtIddocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIddocumentoActionPerformed(evt);
            }
        });
        jPanel4.add(txtIddocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 50, -1));

        jLabel34.setBackground(new java.awt.Color(255, 255, 255));
        jLabel34.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(153, 0, 51));
        jLabel34.setText("Serie:");
        jLabel34.setToolTipText("");
        jPanel4.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, 20));

        txtSerie.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtSerie.setForeground(new java.awt.Color(0, 0, 102));
        txtSerie.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(txtSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 70, -1));

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(153, 0, 51));
        jLabel35.setText("Correlativo:");
        jLabel35.setToolTipText("");
        jPanel4.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, -1, 20));

        txtDocCorrelativo.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtDocCorrelativo.setForeground(new java.awt.Color(0, 0, 102));
        txtDocCorrelativo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(txtDocCorrelativo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 90, -1));

        jcbEstDoc.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jcbEstDoc.setForeground(new java.awt.Color(0, 0, 153));
        jcbEstDoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        jcbEstDoc.setToolTipText("");
        jcbEstDoc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 1, true));
        jPanel4.add(jcbEstDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 110, -1));

        jcbTDocumento.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jcbTDocumento.setForeground(new java.awt.Color(0, 0, 153));
        jcbTDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccionar--" }));
        jcbTDocumento.setToolTipText("");
        jcbTDocumento.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 1, true));
        jPanel4.add(jcbTDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 150, -1));

        btnNDocumento.setBackground(new java.awt.Color(0, 153, 153));
        btnNDocumento.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnNDocumento.setForeground(new java.awt.Color(255, 255, 255));
        btnNDocumento.setIcon(new javax.swing.ImageIcon("D:\\Sistema\\Imagenes\\icons8_Add_List_20px.png")); // NOI18N
        btnNDocumento.setText("Nuevo");
        btnNDocumento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        btnNDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNDocumentoActionPerformed(evt);
            }
        });
        jPanel4.add(btnNDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 100, 30));

        btnRegDocumento.setBackground(new java.awt.Color(0, 153, 153));
        btnRegDocumento.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnRegDocumento.setForeground(new java.awt.Color(255, 255, 255));
        btnRegDocumento.setIcon(new javax.swing.ImageIcon("D:\\Sistema\\Imagenes\\icons8_Save_20px.png")); // NOI18N
        btnRegDocumento.setText("Registrar");
        btnRegDocumento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        btnRegDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegDocumentoActionPerformed(evt);
            }
        });
        jPanel4.add(btnRegDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 100, 30));

        txtIdDocutraza.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtIdDocutraza.setForeground(new java.awt.Color(0, 0, 102));
        txtIdDocutraza.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtIdDocutraza.setEnabled(false);
        txtIdDocutraza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdDocutrazaActionPerformed(evt);
            }
        });
        jPanel4.add(txtIdDocutraza, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 50, -1));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 0, 51));
        jLabel16.setText("idDocuTraza:");
        jLabel16.setToolTipText("");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, 20));

        btnEditDocumento.setBackground(new java.awt.Color(0, 153, 153));
        btnEditDocumento.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEditDocumento.setForeground(new java.awt.Color(255, 255, 255));
        btnEditDocumento.setIcon(new javax.swing.ImageIcon("D:\\Sistema\\Imagenes\\icons8_Edit_Property_20px.png")); // NOI18N
        btnEditDocumento.setText("Editar");
        btnEditDocumento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        btnEditDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditDocumentoActionPerformed(evt);
            }
        });
        jPanel4.add(btnEditDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 100, 30));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, 470, 190));

        jtDocutraza.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jtDocutraza.setForeground(new java.awt.Color(51, 51, 255));
        jtDocutraza.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtDocutraza.setGridColor(new java.awt.Color(0, 51, 153));
        jScrollPane3.setViewportView(jtDocutraza);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 880, 320));

        jtAscDocumentos.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jtAscDocumentos.setForeground(new java.awt.Color(51, 51, 255));
        jtAscDocumentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtAscDocumentos.setGridColor(new java.awt.Color(0, 51, 153));
        jScrollPane4.setViewportView(jtAscDocumentos);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 220, 470, 430));

        btnVerConf.setBackground(new java.awt.Color(0, 153, 153));
        btnVerConf.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnVerConf.setForeground(new java.awt.Color(255, 255, 255));
        btnVerConf.setIcon(new javax.swing.ImageIcon("D:\\Sistema\\Imagenes\\icons8_Add_List_20px.png")); // NOI18N
        btnVerConf.setText("Ver Conformación");
        btnVerConf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        btnVerConf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerConfActionPerformed(evt);
            }
        });
        jPanel2.add(btnVerConf, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 620, 160, 30));

        btnAsigCon.setBackground(new java.awt.Color(0, 153, 153));
        btnAsigCon.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAsigCon.setForeground(new java.awt.Color(255, 255, 255));
        btnAsigCon.setIcon(new javax.swing.ImageIcon("D:\\Sistema\\Imagenes\\icons8_Add_List_20px.png")); // NOI18N
        btnAsigCon.setText("Asignar Conformación");
        btnAsigCon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        jPanel2.add(btnAsigCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 620, 160, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1380, 660));
        jPanel2.getAccessibleContext().setAccessibleName("Mantenimiento de Compra Contrato");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("REGISTRO DE CONTROL DE TRACKINGLIST");
        jLabel2.setToolTipText("");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1400, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegTrackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegTrackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegTrackActionPerformed

    private void btnEditDocutrazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditDocutrazaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditDocutrazaActionPerformed

    private void btnVerConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerConfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerConfActionPerformed

    private void txtIdDocutrzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdDocutrzaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdDocutrzaActionPerformed

    private void btnRegDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegDocumentoActionPerformed

    private void btnNDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNDocumentoActionPerformed

    private void txtIddocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIddocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIddocumentoActionPerformed

    private void txtIdDocutrazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdDocutrazaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdDocutrazaActionPerformed

    private void btnEditDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditDocumentoActionPerformed

    private void btnNTrackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNTrackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNTrackActionPerformed

    private void txtidCompContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidCompContratoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidCompContratoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAsigCon;
    public javax.swing.JButton btnEditDocumento;
    public javax.swing.JButton btnEditDocutraza;
    public javax.swing.JButton btnNDocumento;
    public javax.swing.JButton btnNTrack;
    public javax.swing.JButton btnRegDocumento;
    public javax.swing.JButton btnRegTrack;
    public javax.swing.JButton btnVerConf;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JComboBox<String> jcbCertificado;
    public javax.swing.JComboBox<String> jcbCliente;
    public javax.swing.JComboBox<String> jcbCondicion;
    public javax.swing.JComboBox<String> jcbEstDoc;
    public javax.swing.JComboBox<String> jcbEstTrack;
    public javax.swing.JComboBox<String> jcbTDocumento;
    public com.toedter.calendar.JDateChooser jdFecha;
    public javax.swing.JTable jtAscDocumentos;
    public javax.swing.JTable jtCompraContrato;
    public javax.swing.JTable jtDocutraza;
    public javax.swing.JTextField txtCorrelativo;
    public javax.swing.JTextField txtDocCorrelativo;
    public javax.swing.JTextField txtFairtrade;
    public com.toedter.calendar.JDateChooser txtFecha;
    public javax.swing.JTextField txtIdDocutraza;
    public javax.swing.JTextField txtIdDocutrza;
    public javax.swing.JTextField txtIddocumento;
    public javax.swing.JTextField txtKb;
    public javax.swing.JTextField txtKn;
    public javax.swing.JTextField txtSacos;
    public javax.swing.JTextField txtSerie;
    public javax.swing.JTextField txtSerieGuia;
    public javax.swing.JTextField txtidCompContrato;
    // End of variables declaration//GEN-END:variables
}
