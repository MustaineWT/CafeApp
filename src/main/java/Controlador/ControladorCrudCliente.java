/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import dao.ClienteDao;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.RegCliente;

/**
 *
 * @author MustainE
 */
public class ControladorCrudCliente implements ActionListener {

    RegCliente vistaCRUD = new RegCliente();
    ClienteDao modeloCRUD = new ClienteDao();

    public ControladorCrudCliente(RegCliente vistaCRUD, ClienteDao modeloCRUD) {
        this.modeloCRUD = modeloCRUD;
        this.vistaCRUD = vistaCRUD;
        this.vistaCRUD.btnEditar.addActionListener(this);
        this.vistaCRUD.btnRegistrar.addActionListener(this);
        this.vistaCRUD.btnNuevo.addActionListener(this);
    }

    public void InicializarCrud() {

    }

    public void LlenarTabla(JTable tablaD) {
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        modeloT.addColumn("idCliente");
        modeloT.addColumn("Ruc");
        modeloT.addColumn("Razon Social");
        modeloT.addColumn("Direccion");
        modeloT.addColumn("Estado");
        Object[] columna = new Object[5];
        int numRegistros = modeloCRUD.listCliente().size();
        for (int i = 0; i < numRegistros; i++) {
            columna[0] = modeloCRUD.listCliente().get(i).getIdcliente();
            columna[1] = modeloCRUD.listCliente().get(i).getRuc();
            columna[2] = modeloCRUD.listCliente().get(i).getRazonsocial();
            columna[3] = modeloCRUD.listCliente().get(i).getDireccion();
            columna[4] = modeloCRUD.listCliente().get(i).getEstado();
            modeloT.addRow(columna);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaCRUD.btnRegistrar) {
            if ((String) vistaCRUD.jcbEstado.getSelectedItem() == "--Seleccionar--"
                    || vistaCRUD.txtId.getText().isEmpty() || vistaCRUD.txtRSocial.getText().isEmpty()
                    || vistaCRUD.txtRuc.getText().isEmpty() || vistaCRUD.txtDireccion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe Llenar todos los datos necesarios y/o Seleccionar Estado.");
            } else {
                String Estado="";
                 if ((String) vistaCRUD.jcbEstado.getSelectedItem()=="Activo"){
                    Estado="A";
                }if ((String) vistaCRUD.jcbEstado.getSelectedItem()=="Inactivo"){
                    Estado="I";
                }
                //String Estado = (String) vistaCRUD.jcbEstado.getSelectedItem();
                String id = vistaCRUD.txtId.getText();
                String razonsocial = vistaCRUD.txtRSocial.getText();
                String ruc = vistaCRUD.txtRuc.getText();
                String direccion = vistaCRUD.txtDireccion.getText();
                String rptaRegistro = modeloCRUD.insertCliente(ruc, razonsocial, direccion, Estado);
                vistaCRUD.jcbEstado.setSelectedIndex(0);
                vistaCRUD.txtId.setText("");
                vistaCRUD.txtRSocial.setText("");
                vistaCRUD.txtDireccion.setText("");
                vistaCRUD.txtRuc.setText("");
                vistaCRUD.jcbEstado.setSelectedIndex(0);
//                vistaCRUD.txtId.setEnabled(false);
                vistaCRUD.txtRSocial.setEnabled(false);
                vistaCRUD.txtDireccion.setEnabled(false);
                vistaCRUD.txtRuc.setEnabled(false);
                vistaCRUD.btnRegistrar.setEnabled(false);
                vistaCRUD.btnEditar.setEnabled(true);
                vistaCRUD.btnNuevo.setEnabled(true);
                //vistaCRUD.txtRSocial.requestFocus();
                LlenarTabla(vistaCRUD.jtClientes);
                if (rptaRegistro != null) {
                    JOptionPane.showMessageDialog(null, rptaRegistro);
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar el registro.");
                }

            }
        }
        if (e.getSource() == vistaCRUD.btnNuevo) {
            vistaCRUD.txtRSocial.setEnabled(true);
            vistaCRUD.txtDireccion.setEnabled(true);
            vistaCRUD.txtRuc.setEnabled(true);
            vistaCRUD.btnRegistrar.setEnabled(true);
            vistaCRUD.btnNuevo.setEnabled(false);
            vistaCRUD.btnEditar.setEnabled(false);
            vistaCRUD.txtRSocial.requestFocus();
            vistaCRUD.txtId.setText(modeloCRUD.idCliente().get(0).getIdcliente());
        }
        if (e.getSource() == vistaCRUD.btnEditar) {
            if (vistaCRUD.btnEditar.getText() == "Guardar") {
                String Estado = (String) vistaCRUD.jcbEstado.getSelectedItem();
                String id = vistaCRUD.txtId.getText();
                String razonsocial = vistaCRUD.txtRSocial.getText();
                String ruc = vistaCRUD.txtRuc.getText();
                String direccion = vistaCRUD.txtDireccion.getText();
                String rptaRegistro = modeloCRUD.updateCliente(id, ruc, razonsocial, direccion, Estado);
                vistaCRUD.btnRegistrar.setEnabled(false);
                vistaCRUD.btnNuevo.setEnabled(true);
                vistaCRUD.txtId.setEnabled(false);
                vistaCRUD.txtRSocial.setEnabled(false);
                vistaCRUD.txtRuc.setEnabled(false);
                vistaCRUD.txtDireccion.setEnabled(false);
                vistaCRUD.txtId.setText("");
                vistaCRUD.txtRSocial.setText("");
                vistaCRUD.txtRuc.setText("");
                vistaCRUD.txtDireccion.setText("");
                vistaCRUD.jcbEstado.setSelectedIndex(0);
                vistaCRUD.btnEditar.setText("Editar");
                LlenarTabla(vistaCRUD.jtClientes);
                if (rptaRegistro != null) {
                    JOptionPane.showMessageDialog(null, rptaRegistro);
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar la actualización.");
                }

            } else {
                int filaseleccionada;

                try {

                    filaseleccionada = vistaCRUD.jtClientes.getSelectedRow();

                    if (filaseleccionada == -1) {

                        JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");

                    } else {
                        vistaCRUD.btnEditar.setText("Guardar");
                        vistaCRUD.btnRegistrar.setEnabled(false);
                        vistaCRUD.btnNuevo.setEnabled(false);
                        vistaCRUD.txtRSocial.setEnabled(true);
                        vistaCRUD.txtDireccion.setEnabled(true);
                        vistaCRUD.txtRuc.setEnabled(true);
                        vistaCRUD.txtRSocial.requestFocus();

                        DefaultTableModel modelotabla = (DefaultTableModel) vistaCRUD.jtClientes.getModel();

                        String id = (String) modelotabla.getValueAt(filaseleccionada, 0);
                        String ruc = (String) modelotabla.getValueAt(filaseleccionada, 1);
                        String razonsocial = (String) modelotabla.getValueAt(filaseleccionada, 2);
                        String direccion = (String) modelotabla.getValueAt(filaseleccionada, 3);
                        String estado = (String) modelotabla.getValueAt(filaseleccionada, 4);

                        vistaCRUD.txtId.setText(id);
                        vistaCRUD.txtRuc.setText(ruc);
                        vistaCRUD.txtRSocial.setText(razonsocial);
                        vistaCRUD.txtDireccion.setText(direccion);
                        if (estado.equals("A")) {
                            vistaCRUD.jcbEstado.setSelectedIndex(1);
                        } else {
                            vistaCRUD.jcbEstado.setSelectedIndex(2);
                        }
                    }

                } catch (HeadlessException ex) {

                    JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente", " .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);

                }
            }
        }

    }
}
