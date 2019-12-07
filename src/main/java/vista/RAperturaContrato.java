/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JOptionPane;

/**
 *
 * @author MustainE
 */
public class RAperturaContrato extends javax.swing.JInternalFrame {

    public RAperturaContrato() {
        initComponents();
        btnRegistrar.setEnabled(false);
        btnNuevo.setEnabled(true);
        btnEditar.setEnabled(true);
        txtIdApC.setEnabled(false);
        txtPeso.setEnabled(false);
        txtPrecio.setEnabled(false);
        txtImpTotal.setEnabled(false);
        txtContrato.setEnabled(false);
        txtCalidad.setEnabled(false);
        txtHumedad.setEnabled(false);
        txtFecha.setEnabled(false);        
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
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIdApC = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAperturaContrato = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        txtPeso = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jcbPersona = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        txtCalidad = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtHumedad = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtContrato = new javax.swing.JTextField();
        txtFecha = new com.toedter.calendar.JDateChooser();
        jLabel25 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtImpTotal = new javax.swing.JTextField();
        txtBuscarApC = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jcbEstado = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 0, 51));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("..Registro Tipo Documento..");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 0, 51), 1, true), "Mantenimiento de Apertura Contrato", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(153, 0, 51))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(153, 0, 51));
        jPanel2.setToolTipText("");
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 51));
        jLabel1.setText("idApContrato:");
        jLabel1.setToolTipText("");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 20));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 51));
        jLabel4.setText("Peso:");
        jLabel4.setToolTipText("");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, -1, 20));

        txtIdApC.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtIdApC.setForeground(new java.awt.Color(0, 0, 102));
        txtIdApC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtIdApC.setEnabled(false);
        txtIdApC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdApCActionPerformed(evt);
            }
        });
        jPanel2.add(txtIdApC, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 70, 20));

        jtAperturaContrato.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jtAperturaContrato.setForeground(new java.awt.Color(51, 51, 255));
        jtAperturaContrato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtAperturaContrato.setGridColor(new java.awt.Color(0, 51, 153));
        jScrollPane1.setViewportView(jtAperturaContrato);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 520, 300));

        btnEditar.setBackground(new java.awt.Color(153, 0, 51));
        btnEditar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(0, 0, 153));
        btnEditar.setIcon(new javax.swing.ImageIcon("D:\\Sistema\\Imagenes\\icons8_Edit_Property_20px.png")); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 490, 100, 30));

        jSeparator1.setForeground(new java.awt.Color(153, 0, 51));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 520, 10));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(153, 0, 51));
        jLabel19.setText("Estado:");
        jLabel19.setToolTipText("");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, 20));

        txtPrecio.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtPrecio.setForeground(new java.awt.Color(0, 0, 102));
        txtPrecio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 70, 20));

        txtPeso.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtPeso.setForeground(new java.awt.Color(0, 0, 102));
        txtPeso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(txtPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 120, 20));

        btnNuevo.setBackground(new java.awt.Color(153, 0, 51));
        btnNuevo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(0, 0, 153));
        btnNuevo.setIcon(new javax.swing.ImageIcon("D:\\Sistema\\Imagenes\\icons8_Add_List_20px.png")); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel2.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 490, 100, 30));

        btnRegistrar.setBackground(new java.awt.Color(153, 0, 51));
        btnRegistrar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(0, 0, 153));
        btnRegistrar.setIcon(new javax.swing.ImageIcon("D:\\Sistema\\Imagenes\\icons8_Save_20px.png")); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 490, 100, 30));

        jcbPersona.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jcbPersona.setForeground(new java.awt.Color(0, 0, 153));
        jcbPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "wtorres" }));
        jcbPersona.setToolTipText("");
        jcbPersona.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 1, true));
        jPanel2.add(jcbPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 470, 20));

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(153, 0, 51));
        jLabel21.setText("Fecha:");
        jLabel21.setToolTipText("");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, -1, 20));

        txtCalidad.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtCalidad.setForeground(new java.awt.Color(0, 0, 102));
        txtCalidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(txtCalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 60, 20));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(153, 0, 51));
        jLabel22.setText("Calidad:");
        jLabel22.setToolTipText("");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, -1, 20));

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(153, 0, 51));
        jLabel23.setText("Humedad:");
        jLabel23.setToolTipText("");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, -1, 20));

        txtHumedad.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtHumedad.setForeground(new java.awt.Color(0, 0, 102));
        txtHumedad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(txtHumedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 60, 20));

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(153, 0, 51));
        jLabel24.setText("Contrato:");
        jLabel24.setToolTipText("");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 20));

        txtContrato.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtContrato.setForeground(new java.awt.Color(0, 0, 102));
        txtContrato.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(txtContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 90, 20));
        jPanel2.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 90, -1));

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(153, 0, 51));
        jLabel25.setText("Cliente:");
        jLabel25.setToolTipText("");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 20));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 51));
        jLabel5.setText("Importe Total:");
        jLabel5.setToolTipText("");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, -1, 20));

        txtImpTotal.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtImpTotal.setForeground(new java.awt.Color(0, 0, 102));
        txtImpTotal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(txtImpTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 130, 20));

        txtBuscarApC.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtBuscarApC.setForeground(new java.awt.Color(0, 0, 102));
        txtBuscarApC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(txtBuscarApC, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 360, 20));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 51));
        jLabel6.setText("Buscar Apertura Contrato:");
        jLabel6.setToolTipText("");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, 20));

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(153, 0, 51));
        jLabel26.setText("Precio:");
        jLabel26.setToolTipText("");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 20));

        jcbEstado.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jcbEstado.setForeground(new java.awt.Color(0, 0, 153));
        jcbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Iniciado", "Anulado" }));
        jcbEstado.setToolTipText("");
        jcbEstado.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 1, true));
        jPanel2.add(jcbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 150, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 550, 530));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("REGISTRO APERTURA DE CONTRATO");
        jLabel2.setToolTipText("");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 570, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 580));

        getAccessibleContext().setAccessibleParent(jScrollPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtIdApCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdApCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdApCActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnNuevo;
    public javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JComboBox<String> jcbEstado;
    public javax.swing.JComboBox<String> jcbPersona;
    public javax.swing.JTable jtAperturaContrato;
    public javax.swing.JTextField txtBuscarApC;
    public javax.swing.JTextField txtCalidad;
    public javax.swing.JTextField txtContrato;
    public com.toedter.calendar.JDateChooser txtFecha;
    public javax.swing.JTextField txtHumedad;
    public javax.swing.JTextField txtIdApC;
    public javax.swing.JTextField txtImpTotal;
    public javax.swing.JTextField txtPeso;
    public javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
