/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Uti.GestionCeldas;
import Uti.GestionEncabezadoTabla;
import Uti.ModeloTabla;
import Uti.UtilidadPersona;
import static Uti.UtilidadesExtras.reiniciarJTable;
import dao.ConformacionDao;
import dao.PerBuscadorDao;
import dao.PersonaDao;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import modelo.PerBuscador;
import modelo.Persona;
import vista.RProBuscador;
import vista.RPEstimado;
import vista.RPersonaUsuario;
import vista.TraIni;
import static vista.TraIni.dskPrincipal;

/**
 *
 * @author MustainE
 */
public class ControladorCrudPersonaUsuario implements ActionListener, MouseListener, KeyListener, ItemListener {

    RPersonaUsuario vistaCRUD = new RPersonaUsuario();
    PersonaDao modeloCRUD = new PersonaDao();
    ArrayList<Persona> listaPersona;
    ArrayList<Persona> idNuevoPersona;

    int idempresa;
    int idsucursal;
    String id;
    ModeloTabla modelojt;
    private int filasTabla;
    private int columnasTabla;
    DecimalFormat formatea = new DecimalFormat("###,###.##");
    String texto;

    public ControladorCrudPersonaUsuario(RPersonaUsuario vistaCRUD, PersonaDao modeloCRUD) {
        this.modeloCRUD = modeloCRUD;
        this.vistaCRUD = vistaCRUD;
        this.vistaCRUD.btnEditar.addActionListener(this);
        this.vistaCRUD.btnRegistrar.addActionListener(this);
        this.vistaCRUD.btnNuevo.addActionListener(this);
        this.vistaCRUD.jtPersona.addMouseListener(this);
    }

    public void InicializarCrud() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        idempresa = Integer.valueOf(TraIni.lblEmpresa.getText());
        idsucursal = Integer.valueOf(TraIni.lblSucursal.getText());
        if (e.getSource() == vistaCRUD.btnEditar) {
            vistaCRUD.btnRegistrar.setEnabled(true);
            vistaCRUD.btnRegistrar.setText("Guardar");

            int filaseleccionada;

            try {

                filaseleccionada = vistaCRUD.jtPersona.getSelectedRow();

                if (filaseleccionada == -1) {

                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");

                } else {

                    DefaultTableModel modelotabla = (DefaultTableModel) vistaCRUD.jtPersona.getModel();

                    String id = (String) modelotabla.getValueAt(filaseleccionada, 0);

                    int idpersona = PersonaDao.listPersonaSelect(idempresa, Integer.valueOf(id)).get(0).getIdpersona();
                    String idtipopersona = PersonaDao.listPersonaSelect(idempresa, Integer.valueOf(id)).get(0).getTipopersona();
                    String orga = PersonaDao.listPersonaSelect(idempresa, Integer.valueOf(id)).get(0).getIdorga();
                    String cp = PersonaDao.listPersonaSelect(idempresa, Integer.valueOf(id)).get(0).getIdcp();
                    String cafepractice = PersonaDao.listPersonaSelect(idempresa, Integer.valueOf(id)).get(0).getIdcafepractice();
                    String codagricultor = PersonaDao.listPersonaSelect(idempresa, Integer.valueOf(id)).get(0).getCodagricultor();
                    String razonsocial = PersonaDao.listPersonaSelect(idempresa, Integer.valueOf(id)).get(0).getRazonsocial();
                    String nombres = PersonaDao.listPersonaSelect(idempresa, Integer.valueOf(id)).get(0).getNombres();
                    String apellidos = PersonaDao.listPersonaSelect(idempresa, Integer.valueOf(id)).get(0).getApellidos();
                    String dniruc = PersonaDao.listPersonaSelect(idempresa, Integer.valueOf(id)).get(0).getDniruc();
                    String email = PersonaDao.listPersonaSelect(idempresa, Integer.valueOf(id)).get(0).getEmail();
                    String direccion = PersonaDao.listPersonaSelect(idempresa, Integer.valueOf(id)).get(0).getDireccion();
                    String distrito = PersonaDao.listPersonaSelect(idempresa, Integer.valueOf(id)).get(0).getDistrito();
                    String ciudad = PersonaDao.listPersonaSelect(idempresa, Integer.valueOf(id)).get(0).getCiudad();
                    String provincia = PersonaDao.listPersonaSelect(idempresa, Integer.valueOf(id)).get(0).getProvincia();
                    String pais = PersonaDao.listPersonaSelect(idempresa, Integer.valueOf(id)).get(0).getPais();
                    String celular = PersonaDao.listPersonaSelect(idempresa, Integer.valueOf(id)).get(0).getCelular();
                    String finca = PersonaDao.listPersonaSelect(idempresa, Integer.valueOf(id)).get(0).getNomfinca();
                    String anexo = PersonaDao.listPersonaSelect(idempresa, Integer.valueOf(id)).get(0).getNomanexo();
                    int ejercicio = PersonaDao.listPersonaSelect(idempresa, Integer.valueOf(id)).get(0).getEjercicio();
                    String usuario = PersonaDao.listPersonaSelect(idempresa, Integer.valueOf(id)).get(0).getUsuario();
                    String personatipo = PersonaDao.listPersonaSelect(idempresa, Integer.valueOf(id)).get(0).getPersonatipo();
                    String pass = PersonaDao.listPersonaSelect(idempresa, Integer.valueOf(id)).get(0).getPassword();
                    String estado = "";
                    if (estado.equals("I")) {
                        vistaCRUD.jcbEstado.setSelectedIndex(0);
                    } else {
                        vistaCRUD.jcbEstado.setSelectedIndex(1);
                    }
                    vistaCRUD.txtIdpersona.setText(String.valueOf(idpersona));
                    vistaCRUD.txtRSocial.setText(razonsocial);
                    vistaCRUD.txtRucDni.setText(dniruc);
                    vistaCRUD.txtNombres.setText(nombres);
                    vistaCRUD.txtApellidos.setText(apellidos);
                    vistaCRUD.txtDireccion.setText(direccion);
                    vistaCRUD.txtDistrito.setText(distrito);
                    vistaCRUD.txtProvincia.setText(provincia);
                    vistaCRUD.txtCiudad.setText(ciudad);
                    vistaCRUD.txtPais.setText(pais);
                    vistaCRUD.txtFinca.setText(finca);
                    vistaCRUD.txtAnexo.setText(anexo);
                    vistaCRUD.txtCorreo.setText(email);
                    vistaCRUD.txtCodAgricultor.setText(codagricultor);
                    vistaCRUD.txtOrga.setText(orga);
                    vistaCRUD.txtCp.setText(cp);
                    vistaCRUD.txtCafePractice.setText(cafepractice);
                    vistaCRUD.txtUsuario.setText(usuario);
                    vistaCRUD.txtCelular.setText(celular);
                    vistaCRUD.jYcEjercicio.setYear(ejercicio);
                    vistaCRUD.jRPPassword.setText(pass);
                    vistaCRUD.btnNuevo.setEnabled(false);
                    vistaCRUD.btnEditar.setEnabled(false);
                    vistaCRUD.txtIdpersona.setEnabled(false);
                    vistaCRUD.txtRSocial.requestFocus();
                    vistaCRUD.jcbPersona.setSelectedItem(personatipo);
                    vistaCRUD.jcbTipoUsuario.setSelectedItem(idtipopersona);
                    //reiniciarJTable(vistaCRUD.jtAperturaContrato);
                    //construirTabla(idempresa, idsucursal);
                }
            } catch (HeadlessException ex) {

                JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente", " .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);

            }
        }
        if (e.getSource() == vistaCRUD.btnNuevo) {
            idNuevoPersona = dao.PersonaDao.idNuevoPersona();
            vistaCRUD.txtIdpersona.setText(String.valueOf(idNuevoPersona.get(0).getIdpersona() + 1));
            vistaCRUD.txtRSocial.setText("");
            vistaCRUD.txtRucDni.setText("");
            vistaCRUD.txtNombres.setText("");
            vistaCRUD.txtApellidos.setText("");
            vistaCRUD.txtDireccion.setText("");
            vistaCRUD.txtDistrito.setText("");
            vistaCRUD.txtProvincia.setText("");
            vistaCRUD.txtCiudad.setText("");
            vistaCRUD.txtPais.setText("");
            vistaCRUD.txtFinca.setText("");
            vistaCRUD.txtAnexo.setText("");
            vistaCRUD.txtCorreo.setText("");
            vistaCRUD.txtCodAgricultor.setText("");
            vistaCRUD.txtOrga.setText("");
            vistaCRUD.txtCp.setText("");
            vistaCRUD.txtCafePractice.setText("");
            vistaCRUD.txtUsuario.setText("");
            vistaCRUD.jRPPassword.setText(null);
            vistaCRUD.btnRegistrar.setEnabled(true);
            vistaCRUD.btnNuevo.setEnabled(false);
            vistaCRUD.btnEditar.setEnabled(false);
            vistaCRUD.jYcEjercicio.setEndYear(2019);
            vistaCRUD.jYcEjercicio.setEnabled(false);

        }

        if (e.getSource() == vistaCRUD.btnRegistrar) {
            if (vistaCRUD.txtRSocial.getText().isEmpty()
                    || vistaCRUD.txtRucDni.getText().isEmpty()
                    || vistaCRUD.txtNombres.getText().isEmpty()
                    || vistaCRUD.txtApellidos.getText().isEmpty()
                    || vistaCRUD.txtDireccion.getText().isEmpty()
                    || vistaCRUD.txtDistrito.getText().isEmpty()
                    || vistaCRUD.txtProvincia.getText().isEmpty()
                    || vistaCRUD.txtCiudad.getText().isEmpty()
                    || vistaCRUD.txtPais.getText().isEmpty()
                    || vistaCRUD.txtFinca.getText().isEmpty()
                    || vistaCRUD.txtAnexo.getText().isEmpty()
                    || vistaCRUD.txtCorreo.getText().isEmpty()
                    || vistaCRUD.txtCodAgricultor.getText().isEmpty()
                    || vistaCRUD.txtOrga.getText().isEmpty()
                    || vistaCRUD.txtCp.getText().isEmpty()
                    || vistaCRUD.txtCafePractice.getText().isEmpty()
                    || vistaCRUD.txtUsuario.getText().isEmpty()
                    || vistaCRUD.jRPPassword.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe Llenar todos los datos necesarios.");
            } else {
                if (vistaCRUD.btnRegistrar.getText() == "Guardar") {
                    int idpersona = Integer.valueOf(vistaCRUD.txtIdpersona.getText());
                    String rsocial = vistaCRUD.txtRSocial.getText();
                    String rucdni = vistaCRUD.txtRucDni.getText();
                    String nombres = vistaCRUD.txtNombres.getText();
                    String apellidos = vistaCRUD.txtApellidos.getText();
                    String direccion = vistaCRUD.txtDireccion.getText();
                    String distrito = vistaCRUD.txtDistrito.getText();
                    String provincia = vistaCRUD.txtProvincia.getText();
                    String ciudad = vistaCRUD.txtCiudad.getText();
                    String pais = vistaCRUD.txtPais.getText();
                    String finca = vistaCRUD.txtFinca.getText();
                    int ejercicio = 2019;
                    String anexo = vistaCRUD.txtAnexo.getText();
                    String correo = vistaCRUD.txtCorreo.getText();
                    String codagricultor = vistaCRUD.txtCodAgricultor.getText();
                    String orga = vistaCRUD.txtOrga.getText();
                    String cp = vistaCRUD.txtCp.getText();
                    String cafepractice = vistaCRUD.txtCafePractice.getText();
                    String celular = vistaCRUD.txtCelular.getText();
                    String usuario = vistaCRUD.txtUsuario.getText();
                    String password = vistaCRUD.jRPPassword.getText();
                    String tipopersona = String.valueOf(vistaCRUD.jcbPersona.getSelectedItem());
                    String tipousuario = String.valueOf(vistaCRUD.jcbTipoUsuario.getSelectedItem());
                    String Estado = "";
                    if ((String) vistaCRUD.jcbPersona.getSelectedItem() == "Activo") {
                        Estado = "A";
                    }
                    if ((String) vistaCRUD.jcbEstado.getSelectedItem() == "Inactivo") {
                        Estado = "I";
                    }
                    String rptaRegistro = modeloCRUD.updatePersona(idpersona, idempresa, idsucursal, tipopersona, orga, cp, cafepractice, codagricultor, rsocial, nombres, apellidos, rucdni, correo, direccion, distrito,
                            ciudad, provincia, pais, celular, finca, anexo, ejercicio, usuario, password, tipousuario, Estado);
                    if (rptaRegistro != null) {
                        vistaCRUD.btnRegistrar.setEnabled(false);
                        vistaCRUD.btnNuevo.setEnabled(true);
                        vistaCRUD.btnEditar.setEnabled(true);
                        vistaCRUD.txtIdpersona.setText("");
                        vistaCRUD.txtRSocial.setText("");
                        vistaCRUD.txtRucDni.setText("");
                        vistaCRUD.txtNombres.setText("");
                        vistaCRUD.txtApellidos.setText("");
                        vistaCRUD.txtDireccion.setText("");
                        vistaCRUD.txtDistrito.setText("");
                        vistaCRUD.txtProvincia.setText("");
                        vistaCRUD.txtCiudad.setText("");
                        vistaCRUD.txtPais.setText("");
                        vistaCRUD.txtFinca.setText("");
                        vistaCRUD.txtAnexo.setText("");
                        vistaCRUD.txtCorreo.setText("");
                        vistaCRUD.txtCodAgricultor.setText("");
                        vistaCRUD.txtOrga.setText("");
                        vistaCRUD.txtCp.setText("");
                        vistaCRUD.txtCafePractice.setText("");
                        vistaCRUD.txtUsuario.setText("");
                        vistaCRUD.txtIdpersona.setEnabled(false);
                        vistaCRUD.txtRSocial.setEnabled(false);
                        vistaCRUD.txtRucDni.setEnabled(false);
                        vistaCRUD.txtNombres.setEnabled(false);
                        vistaCRUD.txtApellidos.setEnabled(false);
                        vistaCRUD.txtDireccion.setEnabled(false);
                        vistaCRUD.txtDistrito.setEnabled(false);
                        vistaCRUD.txtProvincia.setEnabled(false);
                        vistaCRUD.txtCiudad.setEnabled(false);
                        vistaCRUD.txtPais.setEnabled(false);
                        vistaCRUD.txtFinca.setEnabled(false);
                        vistaCRUD.txtAnexo.setEnabled(false);
                        vistaCRUD.txtCorreo.setEnabled(false);
                        vistaCRUD.txtCodAgricultor.setEnabled(false);
                        vistaCRUD.txtOrga.setEnabled(false);
                        vistaCRUD.txtCp.setEnabled(false);
                        vistaCRUD.txtCafePractice.setEnabled(false);
                        vistaCRUD.txtUsuario.setEnabled(false);
                        vistaCRUD.jRPPassword.setText(null);
                        vistaCRUD.jYcEjercicio.setEndYear(2019);
                        vistaCRUD.jYcEjercicio.setEnabled(false);

                        reiniciarJTable(vistaCRUD.jtPersona);
                        //construirTablaApc(idempresa, idsucursal);
                        //construirTablaCc(idempresa, idsucursal,apc);
                        construirTabla(idempresa);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo realizar la actualización.");
                    }
                } else {
                    int idpersona = Integer.valueOf(vistaCRUD.txtIdpersona.getText());
                    String rsocial = vistaCRUD.txtRSocial.getText();
                    String rucdni = vistaCRUD.txtRucDni.getText();
                    String nombres = vistaCRUD.txtNombres.getText();
                    String apellidos = vistaCRUD.txtApellidos.getText();
                    String direccion = vistaCRUD.txtDireccion.getText();
                    String distrito = vistaCRUD.txtDistrito.getText();
                    String provincia = vistaCRUD.txtProvincia.getText();
                    String ciudad = vistaCRUD.txtCiudad.getText();
                    String pais = vistaCRUD.txtPais.getText();
                    String finca = vistaCRUD.txtFinca.getText();
                    int ejercicio = 2019;
                    String anexo = vistaCRUD.txtAnexo.getText();
                    String correo = vistaCRUD.txtCorreo.getText();
                    String codagricultor = vistaCRUD.txtCodAgricultor.getText();
                    String orga = vistaCRUD.txtOrga.getText();
                    String cp = vistaCRUD.txtCp.getText();
                    String cafepractice = vistaCRUD.txtCafePractice.getText();
                    String celular = vistaCRUD.txtCelular.getText();
                    String usuario = vistaCRUD.txtUsuario.getText();
                    String password = vistaCRUD.jRPPassword.getText();
                    String tipopersona = String.valueOf(vistaCRUD.jcbPersona.getSelectedItem());
                    String tipousuario = String.valueOf(vistaCRUD.jcbTipoUsuario.getSelectedItem());
                    String Estado = "";
                    if ((String) vistaCRUD.jcbPersona.getSelectedItem() == "Activo") {
                        Estado = "A";
                    }
                    if ((String) vistaCRUD.jcbEstado.getSelectedItem() == "Inactivo") {
                        Estado = "I";
                    }
                    String rptaRegistro = modeloCRUD.insertPersona(idpersona, idempresa, idsucursal, tipopersona, orga, cp, cafepractice, codagricultor, rsocial, nombres, apellidos, rucdni, correo, direccion, distrito,
                            ciudad, provincia, pais, celular, finca, anexo, ejercicio, usuario, password, tipousuario, Estado);
                    if (rptaRegistro != null) {
                        vistaCRUD.btnRegistrar.setEnabled(false);
                        vistaCRUD.btnNuevo.setEnabled(true);
                        vistaCRUD.btnEditar.setEnabled(true);
                        vistaCRUD.txtIdpersona.setText("");
                        vistaCRUD.txtRSocial.setText("");
                        vistaCRUD.txtRucDni.setText("");
                        vistaCRUD.txtNombres.setText("");
                        vistaCRUD.txtApellidos.setText("");
                        vistaCRUD.txtDireccion.setText("");
                        vistaCRUD.txtDistrito.setText("");
                        vistaCRUD.txtProvincia.setText("");
                        vistaCRUD.txtCiudad.setText("");
                        vistaCRUD.txtPais.setText("");
                        vistaCRUD.txtFinca.setText("");
                        vistaCRUD.txtAnexo.setText("");
                        vistaCRUD.txtCorreo.setText("");
                        vistaCRUD.txtCodAgricultor.setText("");
                        vistaCRUD.txtOrga.setText("");
                        vistaCRUD.txtCp.setText("");
                        vistaCRUD.txtCafePractice.setText("");
                        vistaCRUD.txtUsuario.setText("");
                        vistaCRUD.txtIdpersona.setEnabled(false);
                        vistaCRUD.txtRSocial.setEnabled(false);
                        vistaCRUD.txtRucDni.setEnabled(false);
                        vistaCRUD.txtNombres.setEnabled(false);
                        vistaCRUD.txtApellidos.setEnabled(false);
                        vistaCRUD.txtDireccion.setEnabled(false);
                        vistaCRUD.txtDistrito.setEnabled(false);
                        vistaCRUD.txtProvincia.setEnabled(false);
                        vistaCRUD.txtCiudad.setEnabled(false);
                        vistaCRUD.txtPais.setEnabled(false);
                        vistaCRUD.txtFinca.setEnabled(false);
                        vistaCRUD.txtAnexo.setEnabled(false);
                        vistaCRUD.txtCorreo.setEnabled(false);
                        vistaCRUD.txtCodAgricultor.setEnabled(false);
                        vistaCRUD.txtOrga.setEnabled(false);
                        vistaCRUD.txtCp.setEnabled(false);
                        vistaCRUD.txtCafePractice.setEnabled(false);
                        vistaCRUD.txtUsuario.setEnabled(false);
                        vistaCRUD.jRPPassword.setText(null);
                        vistaCRUD.jYcEjercicio.setEndYear(2019);
                        vistaCRUD.jYcEjercicio.setEnabled(false);

                        reiniciarJTable(vistaCRUD.jtPersona);
                        //construirTablaApc(idempresa, idsucursal);
                        //construirTablaCc(idempresa, idsucursal,apc);
                        construirTabla(idempresa);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo realizar la actualización.");
                    }
                }
            }

        }
    }

    public void construirTabla(int empresa) {

        listaPersona = dao.PersonaDao.listPersona(empresa);

        ArrayList<String> titulosList = new ArrayList<>();

        titulosList.add("Id");
        titulosList.add("idEmp");
        titulosList.add("Tipo Persona");
        titulosList.add("Orga");
        titulosList.add("Cp");
        titulosList.add("CafePrac");
        titulosList.add("CodAgric");
        titulosList.add("Razon Social");
        titulosList.add("Nombres");
        titulosList.add("Apellidos");
        titulosList.add("Dni");
        titulosList.add("Dirección");
        titulosList.add("Distrito");
        titulosList.add("Finca");
        titulosList.add("Anexo");
        titulosList.add("Celular");
        titulosList.add("Est");

        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }
        Object[][] data = obtenerMatrizDatos(titulosList);
        construirTabla(titulos, data);
    }

    public void construirTablabuscar(int idempresa, String texto) {

        //listaPersona = dao.PersonaDao.listPerBuscadorBuscar(idempresa, texto);
        ArrayList<String> titulosList = new ArrayList<>();

        titulosList.add("Id");
        titulosList.add("idEmp");
        titulosList.add("Tipo Persona");
        titulosList.add("Orga");
        titulosList.add("Cp");
        titulosList.add("CafePrac");
        titulosList.add("CodAgric");
        titulosList.add("Razon Social");
        titulosList.add("Nombres");
        titulosList.add("Apellidos");
        titulosList.add("Dni");
        titulosList.add("Dirección");
        titulosList.add("Distrito");
        titulosList.add("Finca");
        titulosList.add("Anexo");
        titulosList.add("Celular");
        titulosList.add("Est");

        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }

        Object[][] data = obtenerMatrizDatos(titulosList);
        construirTabla(titulos, data);
    }

    private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {

        String informacion[][] = new String[listaPersona.size()][titulosList.size()];

        for (int x = 0; x < informacion.length; x++) {

            informacion[x][UtilidadPersona.idpersona] = listaPersona.get(x).getIdpersona() + "";
            informacion[x][UtilidadPersona.idempresa] = listaPersona.get(x).getIdempresa() + "";
            informacion[x][UtilidadPersona.tipopersona] = listaPersona.get(x).getTipopersona() + "";
            informacion[x][UtilidadPersona.idorga] = listaPersona.get(x).getIdorga() + "";
            informacion[x][UtilidadPersona.idcp] = listaPersona.get(x).getIdcp() + "";
            informacion[x][UtilidadPersona.idcafepractice] = listaPersona.get(x).getIdcafepractice() + "";
            informacion[x][UtilidadPersona.codagricultor] = listaPersona.get(x).getCodagricultor() + "";
            informacion[x][UtilidadPersona.razonsocial] = listaPersona.get(x).getRazonsocial() + "";
            informacion[x][UtilidadPersona.nombres] = listaPersona.get(x).getNombres() + "";
            informacion[x][UtilidadPersona.apellidos] = listaPersona.get(x).getApellidos() + "";
            informacion[x][UtilidadPersona.dniruc] = listaPersona.get(x).getDniruc() + "";
            informacion[x][UtilidadPersona.direccion] = listaPersona.get(x).getDireccion() + "";
            informacion[x][UtilidadPersona.distrito] = listaPersona.get(x).getDistrito() + "";
            informacion[x][UtilidadPersona.finca] = listaPersona.get(x).getNomfinca() + "";
            informacion[x][UtilidadPersona.anexo] = listaPersona.get(x).getNomanexo() + "";
            informacion[x][UtilidadPersona.celular] = listaPersona.get(x).getCelular() + "";
            informacion[x][UtilidadPersona.estado] = listaPersona.get(x).getEstado() + "";
        }
        return informacion;
    }

    private void construirTabla(String[] titulos, Object[][] data) {
        modelojt = new ModeloTabla(data, titulos);
        //se asigna el modelo a la tabla
        vistaCRUD.jtPersona.setModel(modelojt);

        filasTabla = vistaCRUD.jtPersona.getRowCount();
        columnasTabla = vistaCRUD.jtPersona.getColumnCount();

        vistaCRUD.jtPersona.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtPersona.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtPersona.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtPersona.getColumnModel().getColumn(3).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtPersona.getColumnModel().getColumn(4).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtPersona.getColumnModel().getColumn(5).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtPersona.getColumnModel().getColumn(6).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtPersona.getColumnModel().getColumn(7).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtPersona.getColumnModel().getColumn(8).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtPersona.getColumnModel().getColumn(9).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtPersona.getColumnModel().getColumn(10).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtPersona.getColumnModel().getColumn(11).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtPersona.getColumnModel().getColumn(12).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtPersona.getColumnModel().getColumn(13).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtPersona.getColumnModel().getColumn(14).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtPersona.getColumnModel().getColumn(15).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtPersona.getColumnModel().getColumn(16).setCellRenderer(new GestionCeldas("texto"));

        vistaCRUD.jtPersona.getTableHeader().setReorderingAllowed(false);
        vistaCRUD.jtPersona.setRowHeight(25);//tamaño de las celdas
        vistaCRUD.jtPersona.setGridColor(new java.awt.Color(0, 0, 0));

        vistaCRUD.jtPersona.getColumnModel().getColumn(UtilidadPersona.idpersona).setPreferredWidth(40);
        vistaCRUD.jtPersona.getColumnModel().getColumn(UtilidadPersona.idempresa).setPreferredWidth(40);
        vistaCRUD.jtPersona.getColumnModel().getColumn(UtilidadPersona.tipopersona).setPreferredWidth(40);
        vistaCRUD.jtPersona.getColumnModel().getColumn(UtilidadPersona.idorga).setPreferredWidth(60);
        vistaCRUD.jtPersona.getColumnModel().getColumn(UtilidadPersona.idcp).setPreferredWidth(60);
        vistaCRUD.jtPersona.getColumnModel().getColumn(UtilidadPersona.idcafepractice).setPreferredWidth(60);
        vistaCRUD.jtPersona.getColumnModel().getColumn(UtilidadPersona.codagricultor).setPreferredWidth(50);
        vistaCRUD.jtPersona.getColumnModel().getColumn(UtilidadPersona.razonsocial).setPreferredWidth(70);
        vistaCRUD.jtPersona.getColumnModel().getColumn(UtilidadPersona.nombres).setPreferredWidth(70);
        vistaCRUD.jtPersona.getColumnModel().getColumn(UtilidadPersona.apellidos).setPreferredWidth(70);
        vistaCRUD.jtPersona.getColumnModel().getColumn(UtilidadPersona.dniruc).setPreferredWidth(50);
        vistaCRUD.jtPersona.getColumnModel().getColumn(UtilidadPersona.direccion).setPreferredWidth(50);
        vistaCRUD.jtPersona.getColumnModel().getColumn(UtilidadPersona.distrito).setPreferredWidth(50);
        vistaCRUD.jtPersona.getColumnModel().getColumn(UtilidadPersona.finca).setPreferredWidth(50);
        vistaCRUD.jtPersona.getColumnModel().getColumn(UtilidadPersona.anexo).setPreferredWidth(50);
        vistaCRUD.jtPersona.getColumnModel().getColumn(UtilidadPersona.celular).setPreferredWidth(50);
        vistaCRUD.jtPersona.getColumnModel().getColumn(UtilidadPersona.estado).setPreferredWidth(60);

        JTableHeader jtableHeader = vistaCRUD.jtPersona.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        vistaCRUD.jtPersona.setTableHeader(jtableHeader);

        vistaCRUD.jScrollPane1.setViewportView(vistaCRUD.jtPersona);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == vistaCRUD.jtPersona) {

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
        idempresa = Integer.valueOf(TraIni.lblEmpresa.getText());
        if (ke.getSource() == vistaCRUD.txtBPersona) {
            try {
                texto = vistaCRUD.txtBPersona.getText();
                construirTablabuscar(idempresa, texto);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "NO SE ENCUENTRA EL REGISTRO");
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if (ie.getSource() == vistaCRUD.jcbTipoUsuario) {
            if (vistaCRUD.jcbPersona.getSelectedItem() == "Natural") {
                if (vistaCRUD.jcbTipoUsuario.getSelectedItem() == "Agricultor") {
                    vistaCRUD.txtRSocial.setText("S/N");
                    vistaCRUD.txtRSocial.setEnabled(false);
                    vistaCRUD.txtRucDni.setText("");
                    vistaCRUD.txtNombres.setText("");
                    vistaCRUD.txtApellidos.setText("");
                    vistaCRUD.txtDireccion.setText("");
                    vistaCRUD.txtDistrito.setText("");
                    vistaCRUD.txtProvincia.setText("");
                    vistaCRUD.txtCiudad.setText("");
                    vistaCRUD.txtPais.setText("Peru");
                    vistaCRUD.txtFinca.setText("");
                    vistaCRUD.txtAnexo.setText("");
                    vistaCRUD.txtCorreo.setText("S/N");
                    vistaCRUD.txtCodAgricultor.setText("");
                    vistaCRUD.txtOrga.setText("");
                    vistaCRUD.txtCp.setText("");
                    vistaCRUD.txtCafePractice.setText("");
                    vistaCRUD.txtUsuario.setText("S/N");
                    vistaCRUD.txtUsuario.setEnabled(false);
                    vistaCRUD.jRPPassword.setText("S/N");
                    vistaCRUD.jRPPassword.setEnabled(false);
                }
                if (vistaCRUD.jcbTipoUsuario.getSelectedItem() == "Cliente") {
                    vistaCRUD.txtRSocial.setText("S/N");
                    vistaCRUD.txtRSocial.setEnabled(false);
                    vistaCRUD.txtRucDni.setText("");
                    vistaCRUD.txtNombres.setText("");
                    vistaCRUD.txtApellidos.setText("");
                    vistaCRUD.txtDireccion.setText("");
                    vistaCRUD.txtDistrito.setText("");
                    vistaCRUD.txtProvincia.setText("");
                    vistaCRUD.txtCiudad.setText("");
                    vistaCRUD.txtPais.setText("Peru");
                    vistaCRUD.txtFinca.setText("S/N");
                    vistaCRUD.txtFinca.setEnabled(false);
                    vistaCRUD.txtAnexo.setText("S/N");
                    vistaCRUD.txtAnexo.setEnabled(false);
                    vistaCRUD.txtCorreo.setText("S/N");
                    vistaCRUD.txtCodAgricultor.setText("S/N");
                    vistaCRUD.txtCodAgricultor.setEnabled(false);
                    vistaCRUD.txtOrga.setText("");
                    vistaCRUD.txtCp.setText("");
                    vistaCRUD.txtCafePractice.setText("");
                    vistaCRUD.txtUsuario.setText("S/N");
                    vistaCRUD.txtUsuario.setEnabled(false);
                    vistaCRUD.jRPPassword.setText("S/N");
                    vistaCRUD.jRPPassword.setEnabled(false);
                }
                if (vistaCRUD.jcbTipoUsuario.getSelectedItem() == "Proveedor") {
                    vistaCRUD.txtRSocial.setText("S/N");
                    vistaCRUD.txtRSocial.setEnabled(false);
                    vistaCRUD.txtRucDni.setText("");
                    vistaCRUD.txtNombres.setText("");
                    vistaCRUD.txtApellidos.setText("");
                    vistaCRUD.txtDireccion.setText("");
                    vistaCRUD.txtDistrito.setText("");
                    vistaCRUD.txtProvincia.setText("");
                    vistaCRUD.txtCiudad.setText("");
                    vistaCRUD.txtPais.setText("Peru");
                    vistaCRUD.txtFinca.setText("S/N");
                    vistaCRUD.txtFinca.setEnabled(false);
                    vistaCRUD.txtAnexo.setText("S/N");
                    vistaCRUD.txtAnexo.setEnabled(false);
                    vistaCRUD.txtCorreo.setText("S/N");
                    vistaCRUD.txtCodAgricultor.setText("S/N");
                    vistaCRUD.txtCodAgricultor.setEnabled(false);
                    vistaCRUD.txtOrga.setText("S/N");
                    vistaCRUD.txtOrga.setEnabled(false);
                    vistaCRUD.txtCp.setText("S/N");
                    vistaCRUD.txtCp.setEnabled(false);
                    vistaCRUD.txtCafePractice.setText("S/N");
                    vistaCRUD.txtCafePractice.setEnabled(false);
                    vistaCRUD.txtUsuario.setText("S/N");
                    vistaCRUD.txtUsuario.setEnabled(false);
                    vistaCRUD.jRPPassword.setText("S/N");
                    vistaCRUD.jRPPassword.setEnabled(false);
                }
                if (vistaCRUD.jcbTipoUsuario.getSelectedItem() == "Tercero") {
                    vistaCRUD.txtRSocial.setText("S/N");
                    vistaCRUD.txtRSocial.setEnabled(false);
                    vistaCRUD.txtRucDni.setText("");
                    vistaCRUD.txtNombres.setText("");
                    vistaCRUD.txtApellidos.setText("");
                    vistaCRUD.txtDireccion.setText("");
                    vistaCRUD.txtDistrito.setText("");
                    vistaCRUD.txtProvincia.setText("");
                    vistaCRUD.txtCiudad.setText("");
                    vistaCRUD.txtPais.setText("Peru");
                    vistaCRUD.txtFinca.setText("S/N");
                    vistaCRUD.txtFinca.setEnabled(false);
                    vistaCRUD.txtAnexo.setText("S/N");
                    vistaCRUD.txtAnexo.setEnabled(false);
                    vistaCRUD.txtCorreo.setText("S/N");
                    vistaCRUD.txtCodAgricultor.setText("S/N");
                    vistaCRUD.txtCodAgricultor.setEnabled(false);
                    vistaCRUD.txtOrga.setText("S/N");
                    vistaCRUD.txtOrga.setEnabled(false);
                    vistaCRUD.txtCp.setText("S/N");
                    vistaCRUD.txtCp.setEnabled(false);
                    vistaCRUD.txtCafePractice.setText("S/N");
                    vistaCRUD.txtCafePractice.setEnabled(false);
                    vistaCRUD.txtUsuario.setText("S/N");
                    vistaCRUD.txtUsuario.setEnabled(false);
                    vistaCRUD.jRPPassword.setText("S/N");
                    vistaCRUD.jRPPassword.setEnabled(false);
                }
                if (vistaCRUD.jcbTipoUsuario.getSelectedItem() == "Empleado") {
                    vistaCRUD.txtRSocial.setText("S/N");
                    vistaCRUD.txtRSocial.setEnabled(false);
                    vistaCRUD.txtRucDni.setText("");
                    vistaCRUD.txtNombres.setText("");
                    vistaCRUD.txtApellidos.setText("");
                    vistaCRUD.txtDireccion.setText("");
                    vistaCRUD.txtDistrito.setText("");
                    vistaCRUD.txtProvincia.setText("");
                    vistaCRUD.txtCiudad.setText("");
                    vistaCRUD.txtPais.setText("Peru");
                    vistaCRUD.txtFinca.setText("S/N");
                    vistaCRUD.txtFinca.setEnabled(false);
                    vistaCRUD.txtAnexo.setText("S/N");
                    vistaCRUD.txtAnexo.setEnabled(false);
                    vistaCRUD.txtCorreo.setText("");
                    vistaCRUD.txtCodAgricultor.setText("S/N");
                    vistaCRUD.txtCodAgricultor.setEnabled(false);
                    vistaCRUD.txtCp.setText("S/N");
                    vistaCRUD.txtCp.setEnabled(false);
                    vistaCRUD.txtCafePractice.setText("S/N");
                    vistaCRUD.txtCafePractice.setEnabled(false);
                    vistaCRUD.jRPPassword.setText("");
                    vistaCRUD.txtUsuario.setText("");
                }

            }
            if (vistaCRUD.jcbPersona.getSelectedItem() == "Juridico") {
                if (vistaCRUD.jcbTipoUsuario.getSelectedItem() == "Agricultor") {
                    vistaCRUD.txtRSocial.setText("");
                    vistaCRUD.txtRucDni.setText("");
                    vistaCRUD.txtNombres.setText("S/N");
                    vistaCRUD.txtNombres.setEnabled(false);
                    vistaCRUD.txtApellidos.setText("S/N");
                    vistaCRUD.txtApellidos.setEnabled(false);
                    vistaCRUD.txtDireccion.setText("");
                    vistaCRUD.txtDistrito.setText("");
                    vistaCRUD.txtProvincia.setText("");
                    vistaCRUD.txtCiudad.setText("");
                    vistaCRUD.txtPais.setText("Peru");
                    vistaCRUD.txtFinca.setText("");
                    vistaCRUD.txtAnexo.setText("");
                    vistaCRUD.txtCorreo.setText("S/N");
                    vistaCRUD.txtCodAgricultor.setText("");
                    vistaCRUD.txtOrga.setText("");
                    vistaCRUD.txtCp.setText("");
                    vistaCRUD.txtCafePractice.setText("");
                    vistaCRUD.txtUsuario.setText("S/N");
                    vistaCRUD.txtUsuario.setEnabled(false);
                    vistaCRUD.jRPPassword.setText("S/N");
                    vistaCRUD.jRPPassword.setEnabled(false);
                }
                if (vistaCRUD.jcbTipoUsuario.getSelectedItem() == "Cliente") {
                    vistaCRUD.txtRSocial.setText("");
                    vistaCRUD.txtRucDni.setText("");
                    vistaCRUD.txtNombres.setText("S/N");
                    vistaCRUD.txtNombres.setEnabled(false);
                    vistaCRUD.txtApellidos.setText("S/N");
                    vistaCRUD.txtApellidos.setEnabled(false);
                    vistaCRUD.txtDireccion.setText("");
                    vistaCRUD.txtDistrito.setText("");
                    vistaCRUD.txtProvincia.setText("");
                    vistaCRUD.txtCiudad.setText("");
                    vistaCRUD.txtPais.setText("Peru");
                    vistaCRUD.txtFinca.setText("S/N");
                    vistaCRUD.txtFinca.setEnabled(false);
                    vistaCRUD.txtAnexo.setText("S/N");
                    vistaCRUD.txtAnexo.setEnabled(false);
                    vistaCRUD.txtCorreo.setText("S/N");
                    vistaCRUD.txtCodAgricultor.setText("S/N");
                    vistaCRUD.txtCodAgricultor.setEnabled(false);
                    vistaCRUD.txtOrga.setText("");
                    vistaCRUD.txtCp.setText("");
                    vistaCRUD.txtCafePractice.setText("");
                    vistaCRUD.txtUsuario.setText("S/N");
                    vistaCRUD.txtUsuario.setEnabled(false);
                    vistaCRUD.jRPPassword.setText("S/N");
                    vistaCRUD.jRPPassword.setEnabled(false);
                }
                if (vistaCRUD.jcbTipoUsuario.getSelectedItem() == "Proveedor") {
                    vistaCRUD.txtRSocial.setText("");
                    vistaCRUD.txtRucDni.setText("");
                    vistaCRUD.txtNombres.setText("S/N");
                    vistaCRUD.txtNombres.setEnabled(false);
                    vistaCRUD.txtApellidos.setText("S/N");
                    vistaCRUD.txtApellidos.setEnabled(false);
                    vistaCRUD.txtDireccion.setText("");
                    vistaCRUD.txtDistrito.setText("");
                    vistaCRUD.txtProvincia.setText("");
                    vistaCRUD.txtCiudad.setText("");
                    vistaCRUD.txtPais.setText("Peru");
                    vistaCRUD.txtFinca.setText("S/N");
                    vistaCRUD.txtFinca.setEnabled(false);
                    vistaCRUD.txtAnexo.setText("S/N");
                    vistaCRUD.txtAnexo.setEnabled(false);
                    vistaCRUD.txtCorreo.setText("S/N");
                    vistaCRUD.txtCodAgricultor.setText("S/N");
                    vistaCRUD.txtCodAgricultor.setEnabled(false);
                    vistaCRUD.txtOrga.setText("S/N");
                    vistaCRUD.txtOrga.setEnabled(false);
                    vistaCRUD.txtCp.setText("S/N");
                    vistaCRUD.txtCp.setEnabled(false);
                    vistaCRUD.txtCafePractice.setText("S/N");
                    vistaCRUD.txtCafePractice.setEnabled(false);
                    vistaCRUD.txtUsuario.setText("S/N");
                    vistaCRUD.txtUsuario.setEnabled(false);
                    vistaCRUD.jRPPassword.setText("S/N");
                    vistaCRUD.jRPPassword.setEnabled(false);
                }
                if (vistaCRUD.jcbTipoUsuario.getSelectedItem() == "Tercero") {
                    vistaCRUD.txtRSocial.setText("");
                    vistaCRUD.txtRucDni.setText("");
                    vistaCRUD.txtNombres.setText("S/N");
                    vistaCRUD.txtNombres.setEnabled(false);
                    vistaCRUD.txtApellidos.setText("S/N");
                    vistaCRUD.txtApellidos.setEnabled(false);
                    vistaCRUD.txtDireccion.setText("");
                    vistaCRUD.txtDistrito.setText("");
                    vistaCRUD.txtProvincia.setText("");
                    vistaCRUD.txtCiudad.setText("");
                    vistaCRUD.txtPais.setText("Peru");
                    vistaCRUD.txtFinca.setText("S/N");
                    vistaCRUD.txtFinca.setEnabled(false);
                    vistaCRUD.txtAnexo.setText("S/N");
                    vistaCRUD.txtAnexo.setEnabled(false);
                    vistaCRUD.txtCorreo.setText("S/N");
                    vistaCRUD.txtCodAgricultor.setText("S/N");
                    vistaCRUD.txtCodAgricultor.setEnabled(false);
                    vistaCRUD.txtOrga.setText("S/N");
                    vistaCRUD.txtOrga.setEnabled(false);
                    vistaCRUD.txtCp.setText("S/N");
                    vistaCRUD.txtCp.setEnabled(false);
                    vistaCRUD.txtCafePractice.setText("S/N");
                    vistaCRUD.txtCafePractice.setEnabled(false);
                    vistaCRUD.txtUsuario.setText("S/N");
                    vistaCRUD.txtUsuario.setEnabled(false);
                    vistaCRUD.jRPPassword.setText("S/N");
                    vistaCRUD.jRPPassword.setEnabled(false);
                }
                if (vistaCRUD.jcbTipoUsuario.getSelectedItem() == "Empleado") {
                    vistaCRUD.txtRSocial.setText("");
                    vistaCRUD.txtRucDni.setText("");
                    vistaCRUD.txtNombres.setText("S/N");
                    vistaCRUD.txtNombres.setEnabled(false);
                    vistaCRUD.txtApellidos.setText("S/N");
                    vistaCRUD.txtApellidos.setEnabled(false);
                    vistaCRUD.txtDireccion.setText("");
                    vistaCRUD.txtDistrito.setText("");
                    vistaCRUD.txtProvincia.setText("");
                    vistaCRUD.txtCiudad.setText("");
                    vistaCRUD.txtPais.setText("Peru");
                    vistaCRUD.txtFinca.setText("S/N");
                    vistaCRUD.txtFinca.setEnabled(false);
                    vistaCRUD.txtAnexo.setText("S/N");
                    vistaCRUD.txtAnexo.setEnabled(false);
                    vistaCRUD.txtCorreo.setText("");
                    vistaCRUD.txtCodAgricultor.setText("S/N");
                    vistaCRUD.txtCodAgricultor.setEnabled(false);
                    vistaCRUD.txtCp.setText("S/N");
                    vistaCRUD.txtCp.setEnabled(false);
                    vistaCRUD.txtCafePractice.setText("S/N");
                    vistaCRUD.txtCafePractice.setEnabled(false);
                    vistaCRUD.jRPPassword.setText("");
                    vistaCRUD.txtUsuario.setText("");
                }
            }
        }
    }
}
