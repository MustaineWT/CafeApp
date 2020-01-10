package Controlador;

import Uti.GestionCeldas;
import Uti.GestionEncabezadoTabla;
import Uti.ModeloTabla;
import Uti.UtilidadEmp;
import static Uti.UtilidadesExtras.reiniciarJTable;
import dao.EmpresaDao;
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
import modelo.Empresa;
import vista.REmpresa;
import vista.TraIni;

/**
 *
 * @author MustainE
 */
public class ControladorCrudEmpresa implements ActionListener, MouseListener, KeyListener {

    REmpresa vistaCRUD = new REmpresa();
    EmpresaDao modeloCRUD = new EmpresaDao();
    ArrayList<Empresa> listaEmpresa;
    ArrayList<Empresa> idNuevoEmpresa;
    int idempresa;
    ModeloTabla modelojt;
    private int filasTabla;
    private int columnasTabla;
    DecimalFormat formatea = new DecimalFormat("###,###.##");
    String texto;

    public ControladorCrudEmpresa(REmpresa vistaCRUD, EmpresaDao modeloCRUD) {
        this.modeloCRUD = modeloCRUD;
        this.vistaCRUD = vistaCRUD;
        this.vistaCRUD.btnNuevo.addActionListener(this);
        this.vistaCRUD.btnEditar.addActionListener(this);
        this.vistaCRUD.btnRegistrar.addActionListener(this);
        this.vistaCRUD.jtEmpresa.addMouseListener(this);
    }

    public void InicializarCrud() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        idempresa = Integer.valueOf(TraIni.lblEmpresa.getText());
        if (e.getSource() == vistaCRUD.btnNuevo) {
            idNuevoEmpresa = dao.EmpresaDao.idNuevoEmpresa();
            vistaCRUD.txtIdempresa.setText(String.valueOf(idNuevoEmpresa.get(0).getIdempresa() + 1));
            vistaCRUD.btnRegistrar.setEnabled(true);
            vistaCRUD.btnNuevo.setEnabled(false);
            vistaCRUD.btnEditar.setEnabled(false);
            vistaCRUD.txtIdempresa.setEnabled(false);
            vistaCRUD.txtRSocial.setEnabled(true);
            vistaCRUD.txtRuc.setEnabled(true);
            vistaCRUD.txtDireccion.setEnabled(true);
            vistaCRUD.txtDistrito.setEnabled(true);
            vistaCRUD.txtCiudad.setEnabled(true);
            vistaCRUD.txtPais.setEnabled(true);
            vistaCRUD.txtGnegocio.setEnabled(true);
            vistaCRUD.txtTexportacion.setEnabled(true);
            vistaCRUD.txtRSocial.requestFocus();
        }
        if (e.getSource() == vistaCRUD.btnRegistrar) {
            if (vistaCRUD.txtIdempresa.getText().isEmpty()
                    || vistaCRUD.txtRSocial.getText().isEmpty() || vistaCRUD.txtRuc.getText().isEmpty() || vistaCRUD.txtDireccion.getText().isEmpty()
                    || vistaCRUD.txtCiudad.getText().isEmpty() || vistaCRUD.txtDistrito.getText().isEmpty() || vistaCRUD.txtPais.getText().isEmpty()
                    || vistaCRUD.txtGnegocio.getText().isEmpty() || vistaCRUD.txtTexportacion.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe Llenar todos los datos necesarios.");
            } else {
                if (vistaCRUD.btnRegistrar.getText() == "Guardar") {
                    int id = Integer.valueOf(vistaCRUD.txtIdempresa.getText());
                    String razonsocial = vistaCRUD.txtRSocial.getText();
                    String ruc = vistaCRUD.txtRuc.getText();
                    String direccion = vistaCRUD.txtDireccion.getText();
                    String distrito = vistaCRUD.txtDistrito.getText();
                    String ciudad = vistaCRUD.txtCiudad.getText();
                    String pais = vistaCRUD.txtPais.getText();
                    String gironegocio = vistaCRUD.txtGnegocio.getText();
                    String tipoexportacion = vistaCRUD.txtTexportacion.getText();

                    String Estado = "";
                    if ((String) vistaCRUD.jcbEstado.getSelectedItem() == "Inactivo") {
                        Estado = "I";
                    }
                    if ((String) vistaCRUD.jcbEstado.getSelectedItem() == "Activo") {
                        Estado = "A";
                    }
                    String rptaRegistro = modeloCRUD.UpdateEmpresa(id, razonsocial, ruc, direccion, distrito, ciudad, pais, gironegocio, tipoexportacion, Estado);
                    if (rptaRegistro != null) {
                        vistaCRUD.btnRegistrar.setEnabled(false);
                        vistaCRUD.btnNuevo.setEnabled(true);
                        vistaCRUD.btnEditar.setEnabled(true);
                        vistaCRUD.txtIdempresa.setEnabled(false);
                        vistaCRUD.txtRSocial.setEnabled(false);
                        vistaCRUD.txtRuc.setEnabled(false);
                        vistaCRUD.txtDireccion.setEnabled(false);
                        vistaCRUD.txtDistrito.setEnabled(false);
                        vistaCRUD.txtCiudad.setEnabled(false);
                        vistaCRUD.txtPais.setEnabled(false);
                        vistaCRUD.txtGnegocio.setEnabled(false);
                        vistaCRUD.txtTexportacion.setEnabled(false);
                        JOptionPane.showMessageDialog(null, rptaRegistro);
                        vistaCRUD.txtIdempresa.setText("");
                        vistaCRUD.txtRSocial.setText("");
                        vistaCRUD.txtRuc.setText("");
                        vistaCRUD.txtDireccion.setText("");
                        vistaCRUD.txtDistrito.setText("");
                        vistaCRUD.txtCiudad.setText("");
                        vistaCRUD.txtPais.setText("");
                        vistaCRUD.txtGnegocio.setText("");
                        vistaCRUD.txtTexportacion.setText("");
                        reiniciarJTable(vistaCRUD.jtEmpresa);
                        construirTabla();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo realizar la actualización.");
                    }
                } else {
                    int id = Integer.valueOf(vistaCRUD.txtIdempresa.getText());
                    String razonsocial = vistaCRUD.txtRSocial.getText();
                    String ruc = vistaCRUD.txtRuc.getText();
                    String direccion = vistaCRUD.txtDireccion.getText();
                    String distrito = vistaCRUD.txtDistrito.getText();
                    String ciudad = vistaCRUD.txtCiudad.getText();
                    String pais = vistaCRUD.txtPais.getText();
                    String gironegocio = vistaCRUD.txtGnegocio.getText();
                    String tipoexportacion = vistaCRUD.txtTexportacion.getText();
                    String Estado = "";
                    if ((String) vistaCRUD.jcbEstado.getSelectedItem() == "Inactivo") {
                        Estado = "I";
                    }
                    if ((String) vistaCRUD.jcbEstado.getSelectedItem() == "Activo") {
                        Estado = "A";
                    }
                    String rptaRegistro = modeloCRUD.insertEmpresa(id, razonsocial, ruc, direccion, distrito, ciudad, pais, gironegocio, tipoexportacion, Estado);
                    if (rptaRegistro != null) {
                        vistaCRUD.btnRegistrar.setEnabled(false);
                        vistaCRUD.btnNuevo.setEnabled(true);
                        vistaCRUD.btnEditar.setEnabled(true);
                        vistaCRUD.txtIdempresa.setEnabled(false);
                        vistaCRUD.txtRSocial.setEnabled(false);
                        vistaCRUD.txtRuc.setEnabled(false);
                        vistaCRUD.txtDireccion.setEnabled(false);
                        vistaCRUD.txtDistrito.setEnabled(false);
                        vistaCRUD.txtCiudad.setEnabled(false);
                        vistaCRUD.txtPais.setEnabled(false);
                        vistaCRUD.txtGnegocio.setEnabled(false);
                        vistaCRUD.txtTexportacion.setEnabled(false);
                        JOptionPane.showMessageDialog(null, rptaRegistro);
                        vistaCRUD.txtIdempresa.setText("");
                        vistaCRUD.txtRSocial.setText("");
                        vistaCRUD.txtRuc.setText("");
                        vistaCRUD.txtDireccion.setText("");
                        vistaCRUD.txtDistrito.setText("");
                        vistaCRUD.txtCiudad.setText("");
                        vistaCRUD.txtPais.setText("");
                        vistaCRUD.txtGnegocio.setText("");
                        vistaCRUD.txtTexportacion.setText("");
                        reiniciarJTable(vistaCRUD.jtEmpresa);
                        construirTabla();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo realizar el registro.");
                    }
                }
            }

        }
        if (e.getSource() == vistaCRUD.btnEditar) {
            vistaCRUD.btnRegistrar.setEnabled(true);
            vistaCRUD.btnRegistrar.setText("Guardar");

            int filaseleccionada;

            try {

                filaseleccionada = vistaCRUD.jtEmpresa.getSelectedRow();

                if (filaseleccionada == -1) {

                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila ");

                } else {

                    DefaultTableModel modelotabla = (DefaultTableModel) vistaCRUD.jtEmpresa.getModel();

                    String id = (String) modelotabla.getValueAt(filaseleccionada, 0);

                    int empresa = EmpresaDao.SelectEmpresa(Integer.valueOf(id)).get(0).getIdempresa();
                    String razonsocial = EmpresaDao.SelectEmpresa(Integer.valueOf(id)).get(0).getRazonSocial();
                    String ruc = EmpresaDao.SelectEmpresa(Integer.valueOf(id)).get(0).getRuc();
                    String direccion = EmpresaDao.SelectEmpresa(Integer.valueOf(id)).get(0).getDireccion();
                    String distrito = EmpresaDao.SelectEmpresa(Integer.valueOf(id)).get(0).getDistrito();
                    String ciudad = EmpresaDao.SelectEmpresa(Integer.valueOf(id)).get(0).getCiudad();
                    String pais = EmpresaDao.SelectEmpresa(Integer.valueOf(id)).get(0).getPais();
                    String gironegocio = EmpresaDao.SelectEmpresa(Integer.valueOf(id)).get(0).getGironegocio();
                    String tipoexportacion = EmpresaDao.SelectEmpresa(Integer.valueOf(id)).get(0).getTipoexportacion();
                    String Estado = EmpresaDao.SelectEmpresa(Integer.valueOf(id)).get(0).getEstado();

                    vistaCRUD.btnNuevo.setEnabled(false);
                    vistaCRUD.btnEditar.setEnabled(false);
                    vistaCRUD.txtIdempresa.setEnabled(false);
                    vistaCRUD.txtRSocial.setEnabled(true);
                    vistaCRUD.txtRuc.setEnabled(true);
                    vistaCRUD.txtDireccion.setEnabled(true);
                    vistaCRUD.txtDistrito.setEnabled(true);
                    vistaCRUD.txtCiudad.setEnabled(true);
                    vistaCRUD.txtPais.setEnabled(true);
                    vistaCRUD.txtGnegocio.setEnabled(true);
                    vistaCRUD.txtTexportacion.setEnabled(true);
                    vistaCRUD.txtIdempresa.setText(String.valueOf(empresa));
                    vistaCRUD.txtRSocial.setText(razonsocial);
                    vistaCRUD.txtRuc.setText(ruc);
                    vistaCRUD.txtDireccion.setText(direccion);
                    vistaCRUD.txtDistrito.setText(distrito);
                    vistaCRUD.txtCiudad.setText(ciudad);
                    vistaCRUD.txtPais.setText(pais);
                    vistaCRUD.txtGnegocio.setText(gironegocio);
                    vistaCRUD.txtTexportacion.setText(tipoexportacion);
                    vistaCRUD.txtTexportacion.requestFocus();

                    if (Estado.equals("A")) {
                        vistaCRUD.jcbEstado.setSelectedIndex(0);
                    } else {
                        vistaCRUD.jcbEstado.setSelectedIndex(1);
                    }
                    reiniciarJTable(vistaCRUD.jtEmpresa);
                    construirTabla();
                }
            } catch (HeadlessException ex) {

                JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente", " .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    public void construirTabla() {

        listaEmpresa = dao.EmpresaDao.listEmpresa();

        ArrayList<String> titulosList = new ArrayList<>();

        titulosList.add("Id");
        titulosList.add("Razonsocial");
        titulosList.add("Ruc");
        titulosList.add("Direccion");
        titulosList.add("Distrito");
        titulosList.add("Ciudad");
        titulosList.add("Pais");
        titulosList.add("Gironegocio");
        titulosList.add("Tipoexportacion");
        titulosList.add("Estado");

        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }
        Object[][] data = obtenerMatrizDatos(titulosList);
        construirTabla(titulos, data);
    }

    public void construirTablabuscar() {

        listaEmpresa = dao.EmpresaDao.listEmpresaBuscar(idempresa, texto);

        ArrayList<String> titulosList = new ArrayList<>();

        titulosList.add("Id");
        titulosList.add("Razonsocial");
        titulosList.add("Ruc");
        titulosList.add("Direccion");
        titulosList.add("Distrito");
        titulosList.add("Ciudad");
        titulosList.add("Pais");
        titulosList.add("Gironegocio");
        titulosList.add("Tipoexportacion");
        titulosList.add("Estado");

        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }

        Object[][] data = obtenerMatrizDatos(titulosList);
        construirTabla(titulos, data);
    }

    private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {

        String informacion[][] = new String[listaEmpresa.size()][titulosList.size()];

        for (int x = 0; x < informacion.length; x++) {

            informacion[x][UtilidadEmp.idempresa] = listaEmpresa.get(x).getIdempresa() + "";
            informacion[x][UtilidadEmp.razonsocial] = listaEmpresa.get(x).getRazonSocial() + "";
            informacion[x][UtilidadEmp.direccion] = listaEmpresa.get(x).getDireccion() + "";
            informacion[x][UtilidadEmp.ruc] = listaEmpresa.get(x).getRuc() + "";
            informacion[x][UtilidadEmp.distrito] = listaEmpresa.get(x).getDistrito() + "";
            informacion[x][UtilidadEmp.ciudad] = listaEmpresa.get(x).getCiudad() + "";
            informacion[x][UtilidadEmp.pais] = listaEmpresa.get(x).getPais() + "";
            informacion[x][UtilidadEmp.gironegocio] = listaEmpresa.get(x).getGironegocio() + "";
            informacion[x][UtilidadEmp.tipoexportacion] = listaEmpresa.get(x).getTipoexportacion() + "";
            informacion[x][UtilidadEmp.estado] = listaEmpresa.get(x).getEstado() + "";
        }
        return informacion;
    }

    private void construirTabla(String[] titulos, Object[][] data) {
        modelojt = new ModeloTabla(data, titulos);
        //se asigna el modelo a la tabla
        vistaCRUD.jtEmpresa.setModel(modelojt);

        filasTabla = vistaCRUD.jtEmpresa.getRowCount();
        columnasTabla = vistaCRUD.jtEmpresa.getColumnCount();

        vistaCRUD.jtEmpresa.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtEmpresa.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtEmpresa.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtEmpresa.getColumnModel().getColumn(3).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtEmpresa.getColumnModel().getColumn(4).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtEmpresa.getColumnModel().getColumn(5).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtEmpresa.getColumnModel().getColumn(6).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtEmpresa.getColumnModel().getColumn(7).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtEmpresa.getColumnModel().getColumn(8).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtEmpresa.getColumnModel().getColumn(9).setCellRenderer(new GestionCeldas("texto"));

        vistaCRUD.jtEmpresa.getTableHeader().setReorderingAllowed(false);
        vistaCRUD.jtEmpresa.setRowHeight(25);//tamaño de las celdas
        vistaCRUD.jtEmpresa.setGridColor(new java.awt.Color(0, 0, 0));

        vistaCRUD.jtEmpresa.getColumnModel().getColumn(UtilidadEmp.idempresa).setPreferredWidth(40);
        vistaCRUD.jtEmpresa.getColumnModel().getColumn(UtilidadEmp.razonsocial).setPreferredWidth(40);
        vistaCRUD.jtEmpresa.getColumnModel().getColumn(UtilidadEmp.ruc).setPreferredWidth(60);
        vistaCRUD.jtEmpresa.getColumnModel().getColumn(UtilidadEmp.direccion).setPreferredWidth(60);
        vistaCRUD.jtEmpresa.getColumnModel().getColumn(UtilidadEmp.distrito).setPreferredWidth(60);
        vistaCRUD.jtEmpresa.getColumnModel().getColumn(UtilidadEmp.ciudad).setPreferredWidth(50);
        vistaCRUD.jtEmpresa.getColumnModel().getColumn(UtilidadEmp.pais).setPreferredWidth(70);
        vistaCRUD.jtEmpresa.getColumnModel().getColumn(UtilidadEmp.gironegocio).setPreferredWidth(70);
        vistaCRUD.jtEmpresa.getColumnModel().getColumn(UtilidadEmp.tipoexportacion).setPreferredWidth(70);
        vistaCRUD.jtEmpresa.getColumnModel().getColumn(UtilidadEmp.estado).setPreferredWidth(60);

        JTableHeader jtableHeader = vistaCRUD.jtEmpresa.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        vistaCRUD.jtEmpresa.setTableHeader(jtableHeader);

        vistaCRUD.jScrollPane1.setViewportView(vistaCRUD.jtEmpresa);
    }

    private void validarSeleccionMouse(int fila) {
        UtilidadEmp.filaSeleccionada = fila;

        //teniendo la fila entonces se obtiene el objeto correspondiente para enviarse como parammetro o imprimir la información
        Empresa Emp = new Empresa();
        Emp.setIdempresa(Integer.valueOf(vistaCRUD.jtEmpresa.getValueAt(fila, UtilidadEmp.idempresa).toString()));
        Emp.setRazonSocial(vistaCRUD.jtEmpresa.getValueAt(fila, UtilidadEmp.razonsocial).toString());
        Emp.setRuc(vistaCRUD.jtEmpresa.getValueAt(fila, UtilidadEmp.ruc).toString());
        Emp.setDireccion(vistaCRUD.jtEmpresa.getValueAt(fila, UtilidadEmp.direccion).toString());
        Emp.setDistrito(vistaCRUD.jtEmpresa.getValueAt(fila, UtilidadEmp.distrito).toString());
        Emp.setCiudad(vistaCRUD.jtEmpresa.getValueAt(fila, UtilidadEmp.ciudad).toString());
        Emp.setPais(vistaCRUD.jtEmpresa.getValueAt(fila, UtilidadEmp.pais).toString());
        Emp.setGironegocio(vistaCRUD.jtEmpresa.getValueAt(fila, UtilidadEmp.gironegocio).toString());
        Emp.setTipoexportacion(vistaCRUD.jtEmpresa.getValueAt(fila, UtilidadEmp.tipoexportacion).toString());
        Emp.setEstado(vistaCRUD.jtEmpresa.getValueAt(fila, UtilidadEmp.estado).toString());

        String info = "INFO DOCUMENTO\n";
        info += "id: " + Emp.getIdEmpresa() + "\n";
        info += "Razonsocial: " + Emp.getRazonSocial() + "\n";
        info += "Ruc: " + Emp.getRuc() + "\n";
        info += "Direccion: " + Emp.getDireccion() + "\n";
        info += "Distrito: " + Emp.getDistrito() + "\n";
        info += "Ciudad: " + Emp.getCiudad() + "\n";
        info += "Pais: " + Emp.getPais() + "\n";
        info += "Gironegocio: " + Emp.getGironegocio() + "\n";
        info += "Tipoexportacion: " + Emp.getTipoexportacion() + "\n";
        info += "Estado: " + Emp.getEstado() + "\n";

        JOptionPane.showMessageDialog(null, info);
    }

    @Override
    public void mouseClicked(MouseEvent me) {

        if (me.getSource() == vistaCRUD.jtEmpresa) {

            if (me.getClickCount() > 1) {
                int fila = vistaCRUD.jtEmpresa.rowAtPoint(me.getPoint());
                int columna = vistaCRUD.jtEmpresa.columnAtPoint(me.getPoint());
                validarSeleccionMouse(fila);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public void mouseReleased(MouseEvent me) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public void mouseEntered(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public void mouseExited(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
