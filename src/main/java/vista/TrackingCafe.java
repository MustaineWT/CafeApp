/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import javax.swing.border.BevelBorder;

/**
 *
 * @author MustainE
 */
public class TrackingCafe extends javax.swing.JInternalFrame {

    public TrackingCafe() {
        initComponents();
        jtSeguimiento.setBackground(Color.WHITE);
        jtSeguimiento.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        jtSeguimiento.setOpaque(false);
    }

  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblERainf = new javax.swing.JLabel();
        lblEFairTrade = new javax.swing.JLabel();
        lblEOrg = new javax.swing.JLabel();
        lblECP = new javax.swing.JLabel();
        lblEConv = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtSeguimiento = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jcbEmpresa = new javax.swing.JComboBox<>();
        txtBuscador = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnBusca = new javax.swing.JButton();
        lblORGD = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblCPI = new javax.swing.JLabel();
        lblORGI = new javax.swing.JLabel();
        lblFTI = new javax.swing.JLabel();
        lblRAINFI = new javax.swing.JLabel();
        lblCONVI = new javax.swing.JLabel();
        lblCPA = new javax.swing.JLabel();
        lblORGA = new javax.swing.JLabel();
        lblFTA = new javax.swing.JLabel();
        lblRAINFA = new javax.swing.JLabel();
        lblCONVA = new javax.swing.JLabel();
        lblCPD = new javax.swing.JLabel();
        lblFTD = new javax.swing.JLabel();
        lblCONVD = new javax.swing.JLabel();
        lblRAINFD = new javax.swing.JLabel();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("..Tracking..");
        setPreferredSize(new java.awt.Dimension(1550, 780));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1550, 730));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true), "TRACKING COFFEE ESTIMATED AVIALABLE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 102, 255))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CAFE PRACTICE");
        jLabel3.setToolTipText("");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 130, 20));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("FAIRTRADE");
        jLabel7.setToolTipText("");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 130, 20));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("RAINFOREST");
        jLabel8.setToolTipText("");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 130, 20));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("CONVENCIONAL");
        jLabel18.setToolTipText("");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 130, 20));

        lblERainf.setBackground(new java.awt.Color(255, 255, 255));
        lblERainf.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lblERainf.setForeground(new java.awt.Color(102, 0, 102));
        lblERainf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblERainf.setIcon(new javax.swing.ImageIcon("D:\\Sistema\\Imagenes\\icons8_Circle_130px_3.png")); // NOI18N
        lblERainf.setText("100000000");
        lblERainf.setToolTipText("");
        lblERainf.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(lblERainf, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 130, 130));

        lblEFairTrade.setBackground(new java.awt.Color(255, 255, 255));
        lblEFairTrade.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lblEFairTrade.setForeground(new java.awt.Color(102, 0, 102));
        lblEFairTrade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEFairTrade.setIcon(new javax.swing.ImageIcon("D:\\Sistema\\Imagenes\\icons8_Circle_130px_2.png")); // NOI18N
        lblEFairTrade.setText("1000000.00");
        lblEFairTrade.setToolTipText("");
        lblEFairTrade.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(lblEFairTrade, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 130, 130));

        lblEOrg.setBackground(new java.awt.Color(255, 255, 255));
        lblEOrg.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lblEOrg.setForeground(new java.awt.Color(102, 0, 102));
        lblEOrg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEOrg.setIcon(new javax.swing.ImageIcon("D:\\Sistema\\Imagenes\\icons8_Circle_130px_1.png")); // NOI18N
        lblEOrg.setText("1000000.00");
        lblEOrg.setToolTipText("");
        lblEOrg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(lblEOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 130, 130));

        lblECP.setBackground(new java.awt.Color(255, 255, 255));
        lblECP.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lblECP.setForeground(new java.awt.Color(102, 0, 102));
        lblECP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblECP.setIcon(new javax.swing.ImageIcon("D:\\Sistema\\Imagenes\\icons8_Circle_130px.png")); // NOI18N
        lblECP.setText("1000000.00");
        lblECP.setToolTipText("");
        lblECP.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(lblECP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 130, 130));

        lblEConv.setBackground(new java.awt.Color(255, 255, 255));
        lblEConv.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lblEConv.setForeground(new java.awt.Color(102, 0, 102));
        lblEConv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEConv.setIcon(new javax.swing.ImageIcon("D:\\Sistema\\Imagenes\\icons8_Circle_130px_4.png")); // NOI18N
        lblEConv.setText("100000000");
        lblEConv.setToolTipText("");
        lblEConv.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(lblEConv, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 130, 120));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("ORGANICO");
        jLabel9.setToolTipText("");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 130, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 690, 190));

        jtSeguimiento.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 255), 1, true));
        jtSeguimiento.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jtSeguimiento.setForeground(new java.awt.Color(51, 51, 51));
        jtSeguimiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Emp", "IdOrg", "IdCp", "IdCafeP.", "Codigo", "Apellidos", "Nombres", "Dni", "Finca", "Anexo", "CP.I", "ORG:I", "FT.I", "Rainf.I", "Conv.I", "CP.A", "ORG.A", "FT.A", "Rainf.A", "Conv.A", "CP.D", "ORG.D", "FT:D", "Rainf.D", "Conv.D"
            }
        ));
        jtSeguimiento.setGridColor(new java.awt.Color(0, 51, 153));
        jScrollPane1.setViewportView(jtSeguimiento);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 1530, 450));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true), "Buscar Estimado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(0, 0, 204))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 204));
        jLabel5.setText("Empresa:");
        jLabel5.setToolTipText("");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 20));

        jcbEmpresa.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jcbEmpresa.setForeground(new java.awt.Color(0, 0, 153));
        jcbEmpresa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccionar--", "Seghuro", "Prodelsur", "AiCasa", "Rainforest", "Coagro" }));
        jcbEmpresa.setToolTipText("");
        jcbEmpresa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 1, true));
        jPanel3.add(jcbEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 260, -1));

        txtBuscador.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtBuscador.setForeground(new java.awt.Color(0, 0, 102));
        jPanel3.add(txtBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, 370, 20));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 204));
        jLabel11.setText("Buscar por otro dato cualquier columna:");
        jLabel11.setToolTipText("");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, -1, 20));

        btnBusca.setBackground(new java.awt.Color(204, 204, 255));
        btnBusca.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBusca.setForeground(new java.awt.Color(0, 0, 153));
        btnBusca.setIcon(new javax.swing.ImageIcon("D:\\Sistema\\Imagenes\\icons8_Search_20px.png")); // NOI18N
        btnBusca.setText("Buscar Emp");
        btnBusca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        btnBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaActionPerformed(evt);
            }
        });
        jPanel3.add(btnBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 130, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 1070, 60));

        lblORGD.setBackground(new java.awt.Color(255, 255, 255));
        lblORGD.setFont(new java.awt.Font("Arial", 1, 9)); // NOI18N
        lblORGD.setForeground(new java.awt.Color(0, 0, 153));
        lblORGD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblORGD.setText("000000.00");
        lblORGD.setToolTipText("");
        jPanel1.add(lblORGD, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 720, 60, 20));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("TOTALES GENERALES");
        jLabel10.setToolTipText("");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 720, 130, 20));

        lblCPI.setBackground(new java.awt.Color(255, 255, 255));
        lblCPI.setFont(new java.awt.Font("Arial", 1, 9)); // NOI18N
        lblCPI.setForeground(new java.awt.Color(0, 0, 153));
        lblCPI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCPI.setText("000000.00");
        lblCPI.setToolTipText("");
        jPanel1.add(lblCPI, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 720, 70, 20));

        lblORGI.setBackground(new java.awt.Color(255, 255, 255));
        lblORGI.setFont(new java.awt.Font("Arial", 1, 9)); // NOI18N
        lblORGI.setForeground(new java.awt.Color(0, 0, 153));
        lblORGI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblORGI.setText("000000.00");
        lblORGI.setToolTipText("");
        jPanel1.add(lblORGI, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 720, 50, 20));

        lblFTI.setBackground(new java.awt.Color(255, 255, 255));
        lblFTI.setFont(new java.awt.Font("Arial", 1, 9)); // NOI18N
        lblFTI.setForeground(new java.awt.Color(0, 0, 153));
        lblFTI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFTI.setText("000000.00");
        lblFTI.setToolTipText("");
        jPanel1.add(lblFTI, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 720, 50, 20));

        lblRAINFI.setBackground(new java.awt.Color(255, 255, 255));
        lblRAINFI.setFont(new java.awt.Font("Arial", 1, 9)); // NOI18N
        lblRAINFI.setForeground(new java.awt.Color(0, 0, 153));
        lblRAINFI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRAINFI.setText("000000.00");
        lblRAINFI.setToolTipText("");
        jPanel1.add(lblRAINFI, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 720, 50, 20));

        lblCONVI.setBackground(new java.awt.Color(255, 255, 255));
        lblCONVI.setFont(new java.awt.Font("Arial", 1, 9)); // NOI18N
        lblCONVI.setForeground(new java.awt.Color(0, 0, 153));
        lblCONVI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCONVI.setText("000000.00");
        lblCONVI.setToolTipText("");
        jPanel1.add(lblCONVI, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 720, 50, 20));

        lblCPA.setBackground(new java.awt.Color(255, 255, 255));
        lblCPA.setFont(new java.awt.Font("Arial", 1, 9)); // NOI18N
        lblCPA.setForeground(new java.awt.Color(0, 0, 153));
        lblCPA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCPA.setText("000000.00");
        lblCPA.setToolTipText("");
        jPanel1.add(lblCPA, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 720, 60, 20));

        lblORGA.setBackground(new java.awt.Color(255, 255, 255));
        lblORGA.setFont(new java.awt.Font("Arial", 1, 9)); // NOI18N
        lblORGA.setForeground(new java.awt.Color(0, 0, 153));
        lblORGA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblORGA.setText("000000.00");
        lblORGA.setToolTipText("");
        jPanel1.add(lblORGA, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 720, 60, 20));

        lblFTA.setBackground(new java.awt.Color(255, 255, 255));
        lblFTA.setFont(new java.awt.Font("Arial", 1, 9)); // NOI18N
        lblFTA.setForeground(new java.awt.Color(0, 0, 153));
        lblFTA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFTA.setText("000000.00");
        lblFTA.setToolTipText("");
        jPanel1.add(lblFTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 720, 50, 20));

        lblRAINFA.setBackground(new java.awt.Color(255, 255, 255));
        lblRAINFA.setFont(new java.awt.Font("Arial", 1, 9)); // NOI18N
        lblRAINFA.setForeground(new java.awt.Color(0, 0, 153));
        lblRAINFA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRAINFA.setText("000000.00");
        lblRAINFA.setToolTipText("");
        jPanel1.add(lblRAINFA, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 720, 50, 20));

        lblCONVA.setBackground(new java.awt.Color(255, 255, 255));
        lblCONVA.setFont(new java.awt.Font("Arial", 1, 9)); // NOI18N
        lblCONVA.setForeground(new java.awt.Color(0, 0, 153));
        lblCONVA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCONVA.setText("000000.00");
        lblCONVA.setToolTipText("");
        jPanel1.add(lblCONVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 720, 60, 20));

        lblCPD.setBackground(new java.awt.Color(255, 255, 255));
        lblCPD.setFont(new java.awt.Font("Arial", 1, 9)); // NOI18N
        lblCPD.setForeground(new java.awt.Color(0, 0, 153));
        lblCPD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCPD.setText("000000.00");
        lblCPD.setToolTipText("");
        jPanel1.add(lblCPD, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 720, 60, 20));

        lblFTD.setBackground(new java.awt.Color(255, 255, 255));
        lblFTD.setFont(new java.awt.Font("Arial", 1, 9)); // NOI18N
        lblFTD.setForeground(new java.awt.Color(0, 0, 153));
        lblFTD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFTD.setText("000000.00");
        lblFTD.setToolTipText("");
        jPanel1.add(lblFTD, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 720, 60, 20));

        lblCONVD.setBackground(new java.awt.Color(255, 255, 255));
        lblCONVD.setFont(new java.awt.Font("Arial", 1, 9)); // NOI18N
        lblCONVD.setForeground(new java.awt.Color(0, 0, 153));
        lblCONVD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCONVD.setText("000000.00");
        lblCONVD.setToolTipText("");
        jPanel1.add(lblCONVD, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 720, 60, 20));

        lblRAINFD.setBackground(new java.awt.Color(255, 255, 255));
        lblRAINFD.setFont(new java.awt.Font("Arial", 1, 9)); // NOI18N
        lblRAINFD.setForeground(new java.awt.Color(0, 0, 153));
        lblRAINFD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRAINFD.setText("000000.00");
        lblRAINFD.setToolTipText("");
        jPanel1.add(lblRAINFD, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 720, 60, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1548, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBusca;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JComboBox<String> jcbEmpresa;
    public javax.swing.JTable jtSeguimiento;
    public javax.swing.JLabel lblCONVA;
    public javax.swing.JLabel lblCONVD;
    public javax.swing.JLabel lblCONVI;
    public javax.swing.JLabel lblCPA;
    public javax.swing.JLabel lblCPD;
    public javax.swing.JLabel lblCPI;
    public javax.swing.JLabel lblECP;
    public javax.swing.JLabel lblEConv;
    public javax.swing.JLabel lblEFairTrade;
    public javax.swing.JLabel lblEOrg;
    public javax.swing.JLabel lblERainf;
    public javax.swing.JLabel lblFTA;
    public javax.swing.JLabel lblFTD;
    public javax.swing.JLabel lblFTI;
    public javax.swing.JLabel lblORGA;
    public javax.swing.JLabel lblORGD;
    public javax.swing.JLabel lblORGI;
    public javax.swing.JLabel lblRAINFA;
    public javax.swing.JLabel lblRAINFD;
    public javax.swing.JLabel lblRAINFI;
    public javax.swing.JTextField txtBuscador;
    // End of variables declaration//GEN-END:variables
}
