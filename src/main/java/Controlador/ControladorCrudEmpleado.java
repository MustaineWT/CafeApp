///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Controlador;
//
//import dao.EmpleadoDao;
//import java.awt.HeadlessException;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.JOptionPane;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;
//import vista.RPersonaUsuario;
////import vista.RegEmpleado;
//
///**
// *
// * @author MustainE
// */
//public class ControladorCrudEmpleado implements ActionListener {
//
//    RPersonaUsuario vistaCRUD = new RPersonaUsuario();
//    EmpleadoDao modeloCRUD = new EmpleadoDao();
//
//    public ControladorCrudEmpleado(RPersonaUsuario vistaCRUD, EmpleadoDao modeloCRUD) {
//        this.modeloCRUD = modeloCRUD;
//        this.vistaCRUD = vistaCRUD;
//        this.vistaCRUD.btnEditar.addActionListener(this);
//        this.vistaCRUD.btnRegistrar.addActionListener(this);
//        this.vistaCRUD.btnNuevo.addActionListener(this);
//    }
//
//    public void InicializarCrud() {
//
//    }
//
//    public void LlenarTabla(JTable tablaD) {
//        DefaultTableModel modeloT = new DefaultTableModel();
//        tablaD.setModel(modeloT);
//        modeloT.addColumn("idCliente");
//        modeloT.addColumn("Nombres");
//        modeloT.addColumn("Apellidos");
//        modeloT.addColumn("Dni");
//        modeloT.addColumn("Telefono");
//        modeloT.addColumn("Estado");
//        Object[] columna = new Object[6];
//        int numRegistros = modeloCRUD.listEmpleado().size();
//        for (int i = 0; i < numRegistros; i++) {
//            columna[0] = modeloCRUD.listEmpleado().get(i).getIdempleado();
//            columna[1] = modeloCRUD.listEmpleado().get(i).getNombres();
//            columna[2] = modeloCRUD.listEmpleado().get(i).getApellidos();
//            columna[3] = modeloCRUD.listEmpleado().get(i).getDni();
//            columna[4] = modeloCRUD.listEmpleado().get(i).getTelefono();
//            columna[5] = modeloCRUD.listEmpleado().get(i).getEstado();
//            modeloT.addRow(columna);
//        }
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == vistaCRUD.btnRegistrar) {
//            if ((String) vistaCRUD.jcbEstado.getSelectedItem() == "--Seleccionar--"
//                    || vistaCRUD.txtId.getText().isEmpty() || vistaCRUD.txtNombres.getText().isEmpty()
//                    || vistaCRUD.txtApellidos.getText().isEmpty() || vistaCRUD.txtDni.getText().isEmpty()|| vistaCRUD.txtTelefono.getText().isEmpty()) {
//                JOptionPane.showMessageDialog(null, "Debe Llenar todos los datos necesarios y/o Seleccionar Estado.");
//            } else {
//                String Estado="";
//                 if ((String) vistaCRUD.jcbEstado.getSelectedItem()=="Activo"){
//                    Estado="A";
//                }if ((String) vistaCRUD.jcbEstado.getSelectedItem()=="Inactivo"){
//                    Estado="I";
//                }
//                String id = vistaCRUD.txtId.getText();
//                String nombres = vistaCRUD.txtNombres.getText();
//                String apellidos = vistaCRUD.txtApellidos.getText();
//                String dni = vistaCRUD.txtDni.getText();
//                String telefono = vistaCRUD.txtTelefono.getText();
//                String rptaRegistro = modeloCRUD.insertEmpleado(nombres,apellidos,dni,telefono, Estado);
//                vistaCRUD.jcbEstado.setSelectedIndex(0);
//                vistaCRUD.txtId.setText("");
//                vistaCRUD.txtNombres.setText("");
//                vistaCRUD.txtApellidos.setText("");
//                vistaCRUD.txtDni.setText("");
//                vistaCRUD.txtTelefono.setText("");
//                vistaCRUD.jcbEstado.setSelectedIndex(0);
////                vistaCRUD.txtId.setEnabled(false);
//                vistaCRUD.txtNombres.setEnabled(false);
//                vistaCRUD.txtApellidos.setEnabled(false);
//                vistaCRUD.txtDni.setEnabled(false);
//                vistaCRUD.txtTelefono.setEnabled(false);
//                vistaCRUD.btnRegistrar.setEnabled(false);
//                vistaCRUD.btnEditar.setEnabled(true);
//                vistaCRUD.btnNuevo.setEnabled(true);
//                //vistaCRUD.txtRSocial.requestFocus();
//                LlenarTabla(vistaCRUD.jtEmpleado);
//                if (rptaRegistro != null) {
//                    JOptionPane.showMessageDialog(null, rptaRegistro);
//                } else {
//                    JOptionPane.showMessageDialog(null, "No se pudo realizar el registro.");
//                }
//
//            }
//        }
//        if (e.getSource() == vistaCRUD.btnNuevo) {
//            vistaCRUD.txtNombres.setEnabled(true);
//            vistaCRUD.txtApellidos.setEnabled(true);
//            vistaCRUD.txtDni.setEnabled(true);
//            vistaCRUD.txtTelefono.setEnabled(true);
//            vistaCRUD.btnRegistrar.setEnabled(true);
//            vistaCRUD.btnNuevo.setEnabled(false);
//            vistaCRUD.btnEditar.setEnabled(false);
//            vistaCRUD.txtNombres.requestFocus();
//            vistaCRUD.txtId.setText(modeloCRUD.idEmpleado().get(0).getIdempleado());
//        }
//        if (e.getSource() == vistaCRUD.btnEditar) {
//            if (vistaCRUD.btnEditar.getText() == "Guardar") {
//                String Estado = (String) vistaCRUD.jcbEstado.getSelectedItem();
//                String id = vistaCRUD.txtId.getText();
//                String nombres = vistaCRUD.txtNombres.getText();
//                String apellidos = vistaCRUD.txtApellidos.getText();
//                String dni = vistaCRUD.txtDni.getText();
//                String telefono = vistaCRUD.txtTelefono.getText();
//                String rptaRegistro = modeloCRUD.updateEmpleado(id,nombres,apellidos,dni,telefono,Estado);
//                vistaCRUD.btnRegistrar.setEnabled(false);
//                vistaCRUD.btnNuevo.setEnabled(true);
//                vistaCRUD.txtId.setEnabled(false);
//                vistaCRUD.txtNombres.setEnabled(false);
//                vistaCRUD.txtApellidos.setEnabled(false);
//                vistaCRUD.txtDni.setEnabled(false);
//                vistaCRUD.txtTelefono.setEnabled(false);
//                vistaCRUD.txtId.setText("");
//                vistaCRUD.txtNombres.setText("");
//                vistaCRUD.txtApellidos.setText("");
//                vistaCRUD.txtDni.setText("");
//                vistaCRUD.txtTelefono.setText("");
//                vistaCRUD.jcbEstado.setSelectedIndex(0);
//                vistaCRUD.btnEditar.setText("Editar");
//                LlenarTabla(vistaCRUD.jtEmpleado);
//                if (rptaRegistro != null) {
//                    JOptionPane.showMessageDialog(null, rptaRegistro);
//                } else {
//                    JOptionPane.showMessageDialog(null, "No se pudo realizar la actualización.");
//                }
//
//            } else {
//                int filaseleccionada;
//
//                try {
//
//                    filaseleccionada = vistaCRUD.jtEmpleado.getSelectedRow();
//
//                    if (filaseleccionada == -1) {
//
//                        JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
//
//                    } else {
//                        vistaCRUD.btnEditar.setText("Guardar");
//                        vistaCRUD.btnRegistrar.setEnabled(false);
//                        vistaCRUD.btnNuevo.setEnabled(false);
//                        vistaCRUD.txtNombres.setEnabled(true);
//                        vistaCRUD.txtApellidos.setEnabled(true);
//                        vistaCRUD.txtDni.setEnabled(true);
//                        vistaCRUD.txtTelefono.setEnabled(true);
//                        vistaCRUD.txtNombres.requestFocus();
//
//                        DefaultTableModel modelotabla = (DefaultTableModel) vistaCRUD.jtEmpleado.getModel();
//
//                        String id = (String) modelotabla.getValueAt(filaseleccionada, 0);
//                        String nombres = (String) modelotabla.getValueAt(filaseleccionada, 1);
//                        String apellidos = (String) modelotabla.getValueAt(filaseleccionada, 2);
//                        String dni = (String) modelotabla.getValueAt(filaseleccionada, 3);
//                        String telefono = (String) modelotabla.getValueAt(filaseleccionada, 4);
//                        String estado = (String) modelotabla.getValueAt(filaseleccionada, 5);
//
//                        vistaCRUD.txtId.setText(id);
//                        vistaCRUD.txtNombres.setText(nombres);
//                        vistaCRUD.txtApellidos.setText(apellidos);
//                        vistaCRUD.txtDni.setText(dni);
//                        vistaCRUD.txtTelefono.setText(telefono);
//                        if (estado.equals("A")) {
//                            vistaCRUD.jcbEstado.setSelectedIndex(1);
//                        } else {
//                            vistaCRUD.jcbEstado.setSelectedIndex(2);
//                        }
//                    }
//
//                } catch (HeadlessException ex) {
//
//                    JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente", " .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);
//
//                }
//            }
//        }
//
//    }
//}