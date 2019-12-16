/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Uti.GestionCeldas;
import Uti.GestionEncabezadoTabla;
import Uti.ModeloTabla;
import Uti.UtilidadApC;
import static Uti.UtilidadesExtras.reiniciarJTable;
import dao.AperturaContratoDao;
import dao.ConformacionDao;
import dao.DetalleDocutrazaDao;
import dao.ListaCombosDao;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import modelo.AperturaContrato;
import modelo.DetalleDocutraza;
import modelo.ListaCombos;
import vista.RAgriEstimado;
import vista.RPEstimado;
import vista.TraIni;
import static vista.TraIni.dskPrincipal;

/**
 *
 * @author MustainE
 */
public class ControladorCrudDetalleDocutraza implements ActionListener, MouseListener, KeyListener {

    RAgriEstimado vistaCRUD = new RAgriEstimado();
    DetalleDocutraza modeloCRUD = new DetalleDocutraza();
    ArrayList<AperturaContrato> listaAperturaContrato;
    ArrayList<AperturaContrato> idNuevoAperturaContrato;
    int idempresa;
    int idsucursal;
    ModeloTabla modelojt;
    private int filasTabla;
    private int columnasTabla;
    DecimalFormat formatea = new DecimalFormat("###,###.##");
    String texto;

    public ControladorCrudDetalleDocutraza(RAgriEstimado vistaCRUD, DetalleDocutraza modeloCRUD) {
        this.modeloCRUD = modeloCRUD;
        this.vistaCRUD = vistaCRUD;
        this.vistaCRUD.btnImportar.addActionListener(this);
        this.vistaCRUD.btnEditar.addActionListener(this);
        this.vistaCRUD.btnProcesar.addActionListener(this);
        this.vistaCRUD.btnRegistrar.addActionListener(this);
        this.vistaCRUD.btnExcel.addActionListener(this);
        this.vistaCRUD.jtListProveedores.addMouseListener(this);
    }

    public void InicializarCrud() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        idempresa = Integer.valueOf(TraIni.lblEmpresa.getText());
        idsucursal = Integer.valueOf(TraIni.lblSucursal.getText());

        
        
        
         if (e.getSource() == vistaCRUD.btnEditar) {
               int filaseleccionada;
                    try {
                        filaseleccionada = vistaCRUD.jtListProveedores.getSelectedRow();
                        if (filaseleccionada == -1) {
                            JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
                        } else {
                            RPEstimado ventana1 = new RPEstimado();
                            ConformacionDao modeloC = new ConformacionDao();
                            ControladorCrudConformacion controlaC = new ControladorCrudConformacion(ventana1, modeloC);
                            dskPrincipal.add(ventana1);
                            ventana1.setVisible(true);

                            DefaultTableModel modelotabla = (DefaultTableModel) vistaCRUD.jtListProveedores.getModel();
                            String id = (String) modelotabla.getValueAt(filaseleccionada, 0);

                            int iddetalledocutraza = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIddetalledocutraza();
                            int empresa = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIdempresa();
                            int sucursal = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIdsucursal();
                            int iddocutraza = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIddocutraza();
                            int idcompracontrato = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIdcompracontrato();
                            String serieguia = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getSeriguia();
                            String correlativo = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getCorrelativo();
                            String certificado = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getCertificado();
                            int idlpaest = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIdlpaest();
                            int idlpacon = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIdlpacon();
                            int idpersona = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIdpersona();
                            String idorga = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIdorga();
                            String idcp = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getIdcp();
                            String codagricultor = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getCodagricultor();
                            String nombresagri = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getNombresagri();
                            String nombresaest = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getNombesaest();
                            String nombresacont = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getNombresacont();
                            String dniruc = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getDniruc();
                            long cpdisp = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getCpdisp();
                            long orgdisp = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getOrgdisp();
                            long ftdisp = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getFtdisp();
                            long rainfdisp = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getRainfdisp();
                            long convdisp = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getConvdisp();
                            int sacos = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getSacos();
                            long kb = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getKb();
                            long importetotal = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getImportetotal();
                            String guia = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getGuia();
                            String liqcompra = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getLiqcompra();
                            String fecha = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getFecha();
                            String estado = DetalleDocutrazaDao.listDetalleDocutraza_Select(idempresa, idsucursal, Integer.valueOf(id)).get(0).getEstado();

                            controlaC.vistaCRUD.txtIdDetDoc.setText(String.valueOf(iddetalledocutraza));
                            controlaC.vistaCRUD.txtIdEmp.setText(String.valueOf(empresa));
                            controlaC.vistaCRUD.txtIdSuc.setText(String.valueOf(sucursal));
                            controlaC.vistaCRUD.txtIdDocT.setText(String.valueOf(iddocutraza));
                            controlaC.vistaCRUD.txtIdCC.setText(String.valueOf(idcompracontrato));
                            controlaC.vistaCRUD.txtSerieGuia.setText(serieguia);
                            controlaC.vistaCRUD.txtCorrelativo.setText(correlativo);
                            controlaC.vistaCRUD.txtCertificado.setText(certificado);
                            controlaC.vistaCRUD.txtIdPerLPAEst.setText(String.valueOf(idlpaest));
                            controlaC.vistaCRUD.txtIdProLPACon.setText(String.valueOf(idlpacon));
                            controlaC.vistaCRUD.txtIdPersona.setText(String.valueOf(idpersona));
                            controlaC.vistaCRUD.txtIdOrgaPro.setText(idorga);
                            controlaC.vistaCRUD.txtIdCpPro.setText(idcp);
                            controlaC.vistaCRUD.txtCodPro.setText(codagricultor);
                            controlaC.vistaCRUD.txtNomPro.setText(nombresagri);
                            controlaC.vistaCRUD.txtNomLPAEst.setText(nombresaest);
                            controlaC.vistaCRUD.txtNomLPACon.setText(nombresacont);
                            controlaC.vistaCRUD.txtDniRuc.setText(dniruc);
                            controlaC.vistaCRUD.txtCPDisp.setText(String.valueOf(cpdisp));
                            controlaC.vistaCRUD.txtORGDisp.setText(String.valueOf(orgdisp));
                            controlaC.vistaCRUD.txtFTDisp.setText(String.valueOf(ftdisp));
                            controlaC.vistaCRUD.txtRainfDisp.setText(String.valueOf(rainfdisp));
                            controlaC.vistaCRUD.txtConvDisp.setText(String.valueOf(convdisp));
                            controlaC.vistaCRUD.txtSacos.requestFocus();
                        }
                    } catch (HeadlessException ex) {

                        JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente", " .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);

                    }
         }
        
        if (e.getSource() == vistaCRUD.btnRegistrar) {
            if (vistaCRUD.jtListProveedores.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Debe Ingresar datos en la tabla.");
            } else {
                if (vistaCRUD.btnRegistrar.getText() == "Guardar") {

                  

                } else {
                   
            }

        }
            
        if (e.getSource() == vistaCRUD.btnImportar) {
            DefaultTableModel modelo = new DefaultTableModel();
            vistaCRUD.jtListProveedores.setModel(modelo);
            JFileChooser examinar = new JFileChooser("C:\\Users\\User\\Google Drive\\CAFE.");
            examinar.setFileFilter(new FileNameExtensionFilter("Archivos excel", "xls", "xlsx"));
            int opcion = examinar.showOpenDialog(vistaCRUD.btnImportar);
            File archivoExcel = null;
            if (opcion == JFileChooser.APPROVE_OPTION) {
                archivoExcel = examinar.getSelectedFile().getAbsoluteFile();
                //JOptionPane.showMessageDialog(null, "Este es el Excel Selecionado la Ruta\n" + archivoExcel);
                try {
                    Workbook leerExcel = Workbook.getWorkbook(archivoExcel);
                    for (int hoja = 0; hoja < leerExcel.getNumberOfSheets(); hoja++) {
                        Sheet hojaP = leerExcel.getSheet(hoja);

                        int columnas = hojaP.getColumns();
                        int filas = hojaP.getRows();
                        //JOptionPane.showMessageDialog(null, "Nro de columnas" + columnas + "\n NroFilas :" + filas);
                        Object data[] = new Object[columnas];
                        for (int fila = 0; fila < filas; fila++) {
                            for (int columna = 0; columna < columnas; columna++) {
                                if (fila == 0) {
                                    modelo.addColumn(hojaP.getCell(columna, fila).getContents());
                                }
                                if (fila >= 1) {
                                    data[columna] = hojaP.getCell(columna, fila).getContents();
                                }
                            }
                            modelo.addRow(data);
                        }
                    }
                    modelo.removeRow(0);
                    //JOptionPane.showMessageDialog(null, "Archivo excel almacenado es el Worbook" + leerExcel);
                } catch (IOException | BiffException ex) {
                    Logger.getLogger(ControladorCrud.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Error al almacenar el excel en el workbook");

                }
            }
        }
    }

    public void construirTabla(int empresa, int sucursal) {

        listaAperturaContrato = dao.AperturaContratoDao.listAperturaContrato(empresa, sucursal);

        ArrayList<String> titulosList = new ArrayList<>();

        titulosList.add("Id");
        titulosList.add("Emp");
        titulosList.add("Suc");
        titulosList.add("Peso");
        titulosList.add("Precio");
        titulosList.add("ImpTotal");
        titulosList.add("Calidad");
        titulosList.add("Humedad");
        titulosList.add("Contrato");
        titulosList.add("Cliente");
        titulosList.add("Fecha");
        titulosList.add("Est");

        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }
        Object[][] data = obtenerMatrizDatos(titulosList);
        construirTabla(titulos, data);
    }

    public void construirTablabuscar() {

        listaAperturaContrato = dao.AperturaContratoDao.listAperturaContratoBuscar(idempresa, idsucursal, texto);

        ArrayList<String> titulosList = new ArrayList<>();

        titulosList.add("Id");
        titulosList.add("Emp");
        titulosList.add("Suc");
        titulosList.add("Peso");
        titulosList.add("Precio");
        titulosList.add("ImpTotal");
        titulosList.add("Calidad");
        titulosList.add("Humedad");
        titulosList.add("Contrato");
        titulosList.add("Cliente");
        titulosList.add("Fecha");
        titulosList.add("Est");

        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }

        Object[][] data = obtenerMatrizDatos(titulosList);
        construirTabla(titulos, data);
    }

    private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {

        String informacion[][] = new String[listaAperturaContrato.size()][titulosList.size()];

        for (int x = 0; x < informacion.length; x++) {

            informacion[x][UtilidadApC.idaperturacontrato] = listaAperturaContrato.get(x).getIdaperturacontrato() + "";
            informacion[x][UtilidadApC.idempresa] = listaAperturaContrato.get(x).getIdempresa() + "";
            informacion[x][UtilidadApC.idsucursal] = listaAperturaContrato.get(x).getIdsucursal() + "";
            informacion[x][UtilidadApC.peso] = listaAperturaContrato.get(x).getPeso() + "";
            informacion[x][UtilidadApC.precio] = listaAperturaContrato.get(x).getPrecio() + "";
            informacion[x][UtilidadApC.imptotal] = listaAperturaContrato.get(x).getImptotal() + "";
            informacion[x][UtilidadApC.calidad] = listaAperturaContrato.get(x).getCalidad() + "";
            informacion[x][UtilidadApC.humedad] = listaAperturaContrato.get(x).getHumedad() + "";
            informacion[x][UtilidadApC.contrato] = listaAperturaContrato.get(x).getContrato() + "";
            informacion[x][UtilidadApC.cliente] = listaAperturaContrato.get(x).getCliente() + "";
            informacion[x][UtilidadApC.fecha] = listaAperturaContrato.get(x).getFecha() + "";
            informacion[x][UtilidadApC.estado] = listaAperturaContrato.get(x).getEstado() + "";
        }
        return informacion;
    }

    private void construirTabla(String[] titulos, Object[][] data) {
        modelojt = new ModeloTabla(data, titulos);
        //se asigna el modelo a la tabla
        vistaCRUD.jtAperturaContrato.setModel(modelojt);

        filasTabla = vistaCRUD.jtAperturaContrato.getRowCount();
        columnasTabla = vistaCRUD.jtAperturaContrato.getColumnCount();

        //se asigna el tipo de dato que tendrán las celdas de cada columna definida respectivamente para validar su personalización
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.peso).setCellRenderer(new GestionCeldas("numerico"));
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.precio).setCellRenderer(new GestionCeldas("numerico"));
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.imptotal).setCellRenderer(new GestionCeldas("numerico"));

        //se recorre y asigna el resto de celdas que serian las que almacenen datos de tipo texto
        // for (int i = 0; i < titulos.length - 8; i++) {//se resta 7 porque las ultimas 7 columnas se definen arriba
        //    System.out.println(i);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(6).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(7).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(8).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(9).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(10).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(11).setCellRenderer(new GestionCeldas("texto"));

        vistaCRUD.jtAperturaContrato.getTableHeader().setReorderingAllowed(false);
        vistaCRUD.jtAperturaContrato.setRowHeight(25);//tamaño de las celdas
        vistaCRUD.jtAperturaContrato.setGridColor(new java.awt.Color(0, 0, 0));

        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.idaperturacontrato).setPreferredWidth(40);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.idempresa).setPreferredWidth(40);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.idsucursal).setPreferredWidth(40);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.peso).setPreferredWidth(60);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.precio).setPreferredWidth(60);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.imptotal).setPreferredWidth(60);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.calidad).setPreferredWidth(50);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.humedad).setPreferredWidth(70);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.contrato).setPreferredWidth(70);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.cliente).setPreferredWidth(70);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.fecha).setPreferredWidth(50);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.estado).setPreferredWidth(60);

        JTableHeader jtableHeader = vistaCRUD.jtAperturaContrato.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        vistaCRUD.jtAperturaContrato.setTableHeader(jtableHeader);

        vistaCRUD.jScrollPane1.setViewportView(vistaCRUD.jtAperturaContrato);
    }

    private void validarSeleccionMouse(int fila) {
        UtilidadApC.filaSeleccionada = fila;

        //teniendo la fila entonces se obtiene el objeto correspondiente para enviarse como parammetro o imprimir la información
        AperturaContrato ApC = new AperturaContrato();
        ApC.setIdaperturacontrato(Integer.valueOf(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.idaperturacontrato).toString()));
        ApC.setIdempresa(Integer.valueOf(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.idempresa).toString()));
        ApC.setIdsucursal(Integer.valueOf(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.idsucursal).toString()));
        ApC.setPeso(Double.valueOf(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.peso).toString()));
        ApC.setPrecio(Double.valueOf(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.precio).toString()));
        ApC.setImptotal(Double.valueOf(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.imptotal).toString()));
        ApC.setCalidad(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.calidad).toString());
        ApC.setHumedad(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.humedad).toString());
        ApC.setContrato(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.contrato).toString());
        ApC.setCliente(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.cliente).toString());
        ApC.setFecha(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.fecha).toString());
        ApC.setEstado(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.estado).toString());

        String info = "INFO DOCUMENTO\n";
        info += "id: " + ApC.getIdaperturacontrato() + "\n";
        info += "IdEmpresa: " + ApC.getIdempresa() + "\n";
        info += "IdSucursal: " + ApC.getIdsucursal() + "\n";
        info += "Peso: " + ApC.getPeso() + "\n";
        info += "Precio: " + ApC.getPrecio() + "\n";
        info += "Precio: " + ApC.getImptotal() + "\n";
        info += "Calidad: " + ApC.getCalidad() + "\n";
        info += "Humedad: " + ApC.getHumedad() + "\n";
        info += "Contrato: " + ApC.getContrato() + "\n";
        info += "Cliente: " + ApC.getCliente() + "\n";
        info += "Fecha: " + ApC.getFecha() + "\n";
        info += "Estado: " + ApC.getEstado() + "\n";

        JOptionPane.showMessageDialog(null, info);
    }

    private void validarSeleccionMouseDetalle(int fila) {
        UtilidadApC.filaSeleccionada = fila;

        //teniendo la fila entonces se obtiene el objeto correspondiente para enviarse como parammetro o imprimir la información        
        idempresa = Integer.valueOf(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.idempresa).toString());
    }

    @Override
    public void mouseClicked(MouseEvent me) {

        if (me.getSource() == vistaCRUD.jtAperturaContrato) {

            if (me.getClickCount() > 1) {
                int fila = vistaCRUD.jtAperturaContrato.rowAtPoint(me.getPoint());
                int columna = vistaCRUD.jtAperturaContrato.columnAtPoint(me.getPoint());
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
        if (ke.getSource() == vistaCRUD.txtPeso || ke.getSource() == vistaCRUD.txtPrecio) {
            try {
                //texto = vistaCRUD.txtBuscador.getText();
                //construirTablabuscar();
                if (vistaCRUD.txtPeso.getText().isEmpty() || vistaCRUD.txtPrecio.getText().isEmpty()) {

                } else {
                    long rt = (long) (Double.valueOf(vistaCRUD.txtPeso.getText()) * Double.valueOf(vistaCRUD.txtPrecio.getText()));
                    vistaCRUD.txtImpTotal.setText(String.valueOf(rt));//                   
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "NO SE ENCUENTRA EL REGISTRO");
            }

        }
    }

}
