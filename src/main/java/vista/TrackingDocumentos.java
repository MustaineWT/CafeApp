/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;

/**
 *
 * @author MustainE
 */
public class TrackingDocumentos extends javax.swing.JInternalFrame {

    public TrackingDocumentos() {
        initComponents();
        jtDocuseguimiento.setBackground(Color.WHITE);
        jtDocuseguimiento.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        jtDocuseguimiento.setOpaque(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        lblTcEcovrae = new javax.swing.JLabel();
        lblTcAprosem = new javax.swing.JLabel();
        lblTcCaniari = new javax.swing.JLabel();
        lblTcCoagro = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblERainf = new javax.swing.JLabel();
        lblEFairTrade = new javax.swing.JLabel();
        lblEOrg = new javax.swing.JLabel();
        lblECP = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jcbEmpresa = new javax.swing.JComboBox<>();
        btnBusca = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtBusca = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        lblSacos = new javax.swing.JLabel();
        lblKb = new javax.swing.JLabel();
        lblKn = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDocuseguimiento = new javax.swing.JTable();

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
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true), "TRACKING COFFEE SEGUIMIENTO DOCUMENTOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(102, 102, 255))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("TCS GENERADOS");
        jLabel2.setToolTipText("");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 30, 130, 20));

        jcMousePanel1.setIcon(new javax.swing.ImageIcon("D:\\Sistema\\Imagenes\\APROSEM.png")); // NOI18N
        jcMousePanel1.setIconLogo(new javax.swing.ImageIcon("D:\\Sistema\\Imagenes\\fondotrans.png")); // NOI18N
        jcMousePanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTcEcovrae.setBackground(new java.awt.Color(255, 255, 255));
        lblTcEcovrae.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblTcEcovrae.setForeground(new java.awt.Color(255, 255, 255));
        lblTcEcovrae.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTcEcovrae.setText("0");
        lblTcEcovrae.setToolTipText("");
        jcMousePanel1.add(lblTcEcovrae, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 50, 53));

        lblTcAprosem.setBackground(new java.awt.Color(255, 255, 255));
        lblTcAprosem.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblTcAprosem.setForeground(new java.awt.Color(255, 255, 255));
        lblTcAprosem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTcAprosem.setText("0");
        lblTcAprosem.setToolTipText("");
        jcMousePanel1.add(lblTcAprosem, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 0, 55, 60));

        lblTcCaniari.setBackground(new java.awt.Color(255, 255, 255));
        lblTcCaniari.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblTcCaniari.setForeground(new java.awt.Color(255, 255, 255));
        lblTcCaniari.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTcCaniari.setText("0");
        lblTcCaniari.setToolTipText("");
        jcMousePanel1.add(lblTcCaniari, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 56, 60));

        lblTcCoagro.setBackground(new java.awt.Color(255, 255, 255));
        lblTcCoagro.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblTcCoagro.setForeground(new java.awt.Color(255, 255, 255));
        lblTcCoagro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTcCoagro.setText("12");
        lblTcCoagro.setToolTipText("");
        jcMousePanel1.add(lblTcCoagro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 55, 53));

        jPanel2.add(jcMousePanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 440, 130));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("APROSEM");
        jLabel3.setToolTipText("");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 130, 20));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("CAÑIARI");
        jLabel7.setToolTipText("");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 130, 20));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("ECOVRAE");
        jLabel8.setToolTipText("");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 130, 20));

        lblERainf.setBackground(new java.awt.Color(255, 255, 255));
        lblERainf.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lblERainf.setForeground(new java.awt.Color(102, 0, 102));
        lblERainf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblERainf.setIcon(new javax.swing.ImageIcon("D:\\Sistema\\Imagenes\\icons8_Circle_130px_3.png")); // NOI18N
        lblERainf.setText("0");
        lblERainf.setToolTipText("");
        lblERainf.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(lblERainf, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 130, 130));

        lblEFairTrade.setBackground(new java.awt.Color(255, 255, 255));
        lblEFairTrade.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lblEFairTrade.setForeground(new java.awt.Color(102, 0, 102));
        lblEFairTrade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEFairTrade.setIcon(new javax.swing.ImageIcon("D:\\Sistema\\Imagenes\\icons8_Circle_130px_2.png")); // NOI18N
        lblEFairTrade.setText("0");
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
        lblECP.setText("0");
        lblECP.setToolTipText("");
        lblECP.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(lblECP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 130, 130));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("GUÍAS GENERADAS");
        jLabel9.setToolTipText("");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 130, 20));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 102, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("COAGRO");
        jLabel22.setToolTipText("");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 130, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 1000, 190));

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

        btnBusca.setBackground(new java.awt.Color(204, 204, 255));
        btnBusca.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBusca.setForeground(new java.awt.Color(0, 0, 153));
        btnBusca.setIcon(new javax.swing.ImageIcon("D:\\Sistema\\Imagenes\\icons8_Search_20px.png")); // NOI18N
        btnBusca.setText("Buscar Empresa");
        btnBusca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        btnBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaActionPerformed(evt);
            }
        });
        jPanel3.add(btnBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 130, 40));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 204));
        jLabel13.setText("Buscar por cualquier columna:");
        jLabel13.setToolTipText("");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, -1, 20));

        txtBusca.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtBusca.setForeground(new java.awt.Color(0, 0, 102));
        jPanel3.add(txtBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 410, 20));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 1120, 70));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("TOTALES GENERALES");
        jLabel10.setToolTipText("");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 720, 130, 20));

        lblSacos.setBackground(new java.awt.Color(255, 255, 255));
        lblSacos.setFont(new java.awt.Font("Arial", 1, 9)); // NOI18N
        lblSacos.setForeground(new java.awt.Color(0, 0, 153));
        lblSacos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSacos.setText("000000.00");
        lblSacos.setToolTipText("");
        jPanel1.add(lblSacos, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 720, 80, 20));

        lblKb.setBackground(new java.awt.Color(255, 255, 255));
        lblKb.setFont(new java.awt.Font("Arial", 1, 9)); // NOI18N
        lblKb.setForeground(new java.awt.Color(0, 0, 153));
        lblKb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKb.setText("000000.00");
        lblKb.setToolTipText("");
        jPanel1.add(lblKb, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 720, 80, 20));

        lblKn.setBackground(new java.awt.Color(255, 255, 255));
        lblKn.setFont(new java.awt.Font("Arial", 1, 9)); // NOI18N
        lblKn.setForeground(new java.awt.Color(0, 0, 153));
        lblKn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKn.setText("000000.00");
        lblKn.setToolTipText("");
        jPanel1.add(lblKn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 720, 80, 20));

        jtDocuseguimiento.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 255), 1, true));
        jtDocuseguimiento.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jtDocuseguimiento.setForeground(new java.awt.Color(51, 51, 51));
        jtDocuseguimiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtDocuseguimiento.setGridColor(new java.awt.Color(0, 51, 153));
        jScrollPane1.setViewportView(jtDocuseguimiento);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 1520, 440));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1548, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaActionPerformed

    }//GEN-LAST:event_btnBuscaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBusca;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JScrollPane jScrollPane1;
    private jcMousePanel.jcMousePanel jcMousePanel1;
    public javax.swing.JComboBox<String> jcbEmpresa;
    public javax.swing.JTable jtDocuseguimiento;
    public javax.swing.JLabel lblECP;
    public javax.swing.JLabel lblEFairTrade;
    public javax.swing.JLabel lblEOrg;
    public javax.swing.JLabel lblERainf;
    public javax.swing.JLabel lblKb;
    public javax.swing.JLabel lblKn;
    public javax.swing.JLabel lblSacos;
    public javax.swing.JLabel lblTcAprosem;
    public javax.swing.JLabel lblTcCaniari;
    public javax.swing.JLabel lblTcCoagro;
    public javax.swing.JLabel lblTcEcovrae;
    public javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}
