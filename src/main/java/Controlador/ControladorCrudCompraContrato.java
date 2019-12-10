package Controlador;

import Uti.GestionCeldas;
import Uti.GestionEncabezadoTabla;
import Uti.ModeloTabla;
import Uti.UtilidadApC;
import Uti.UtilidadCC;
import dao.AperturaContratoDao;
import dao.CompraContratoDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import modelo.CompraContrato;
import vista.RCompraContrato;

/**
 *
 * @author MustainE
 */
public class ControladorCrudCompraContrato implements ActionListener {

    RCompraContrato vistaCRUD = new RCompraContrato();
    CompraContratoDao modeloCRUD = new CompraContratoDao();
    ArrayList<CompraContrato> listaCompraContrato;
    int idcompracontrato;
    int idempresa;
    int idsucursal;
    int idaperturacontrato;
    ModeloTabla modelojt;
    private int filasTabla;
    private int columnasTabla;
    DecimalFormat formatea = new DecimalFormat("###,###.##");
    String texto;

    public ControladorCrudCompraContrato(RCompraContrato vistaCRUD, CompraContratoDao modeloCRUD) {
        this.modeloCRUD = modeloCRUD;
        this.vistaCRUD = vistaCRUD;

        this.vistaCRUD.btnNuevo1.addActionListener(this);
        this.vistaCRUD.btnEditar2.addActionListener(this);
        this.vistaCRUD.btnRegistrar.addActionListener(this);
    }

    public void InicializarCrud() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaCRUD.btnNuevo1) {
            idcompracontrato = 1;
            idempresa = 1;
            idsucursal = 1;
            idaperturacontrato = 1;
            construirTabla(idcompracontrato,idempresa,idsucursal,idaperturacontrato);
        }
    }

    public void construirTabla(int compracontrato,int empresa,int sucursal,int aperturacontrato) {

        listaCompraContrato = dao.CompraContratoDao.listCompraContrato(compracontrato, empresa, sucursal, aperturacontrato);

        ArrayList<String> titulosList = new ArrayList<>();

        titulosList.add("idCompraContrato");
        titulosList.add("IdEmpresa");
        titulosList.add("IdSucursal");
        titulosList.add("idAperturaContrato");
        titulosList.add("Peso");
        titulosList.add("Precio");
        titulosList.add("Fecha");
        titulosList.add("Estado");

        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        } 
        Object[][] data = obtenerMatrizDatos(titulosList);
        construirTabla(titulos, data);
    }

//    public void construirTablabuscar() {
//
//        listaCompraContrato = dao.CompraContratoDao.listCompraContrato(idempresa, idsucursal, texto);
//
//        ArrayList<String> titulosList = new ArrayList<>();
//
//        titulosList.add("idAperturaContrato");
//        titulosList.add("IdEmpresa");
//        titulosList.add("IdSucursal");
//        titulosList.add("Peso");
//        titulosList.add("Precio");
//        titulosList.add("Calidad");
//        titulosList.add("Humedad");
//        titulosList.add("Contrato");
//        titulosList.add("Fecha");
//        titulosList.add("Estado");
//
//        String titulos[] = new String[titulosList.size()];
//        for (int i = 0; i < titulos.length; i++) {
//            titulos[i] = titulosList.get(i);
//        }
//
//        Object[][] data = obtenerMatrizDatos(titulosList);
//        construirTabla(titulos, data);
//    }
//
    private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {

        String informacion[][] = new String[listaCompraContrato.size()][titulosList.size()];

        for (int x = 0; x < informacion.length; x++) {

            informacion[x][UtilidadCC.idcompracontrato] = listaCompraContrato.get(x).getIdcompracontrato() + "";
            informacion[x][UtilidadCC.idempresa] = listaCompraContrato.get(x).getIdempresa() + "";
            informacion[x][UtilidadCC.idsucursal] = listaCompraContrato.get(x).getIdsucursal() + "";
            informacion[x][UtilidadCC.idaperturacontrato] = listaCompraContrato.get(x).getIdaperturacontrato() + "";
            informacion[x][UtilidadCC.peso] = listaCompraContrato.get(x).getPeso() + "";
            informacion[x][UtilidadCC.precio] = listaCompraContrato.get(x).getPrecio() + "";
            informacion[x][UtilidadCC.fecha] = listaCompraContrato.get(x).getFecha() + "";
            informacion[x][UtilidadCC.estado] = listaCompraContrato.get(x).getEstado() + "";
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

        //se recorre y asigna el resto de celdas que serian las que almacenen datos de tipo texto
        // for (int i = 0; i < titulos.length - 8; i++) {//se resta 7 porque las ultimas 7 columnas se definen arriba
        //    System.out.println(i);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(5).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(6).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(7).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(8).setCellRenderer(new GestionCeldas("texto"));
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(9).setCellRenderer(new GestionCeldas("texto"));

        vistaCRUD.jtAperturaContrato.getTableHeader().setReorderingAllowed(false);
        vistaCRUD.jtAperturaContrato.setRowHeight(25);//tamaño de las celdas
        vistaCRUD.jtAperturaContrato.setGridColor(new java.awt.Color(0, 0, 0));

        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadCC.idcompracontrato).setPreferredWidth(40);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadCC.idempresa).setPreferredWidth(40);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadCC.idsucursal).setPreferredWidth(40);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadCC.idaperturacontrato).setPreferredWidth(40);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadCC.peso).setPreferredWidth(60);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadCC.precio).setPreferredWidth(60);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadCC.fecha).setPreferredWidth(50);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadCC.estado).setPreferredWidth(60);

        JTableHeader jtableHeader = vistaCRUD.jtAperturaContrato.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        vistaCRUD.jtAperturaContrato.setTableHeader(jtableHeader);

        vistaCRUD.jScrollPane1.setViewportView(vistaCRUD.jtAperturaContrato);
    }

    private void validarSeleccionMouse(int fila) {
        UtilidadApC.filaSeleccionada = fila;

        //teniendo la fila entonces se obtiene el objeto correspondiente para enviarse como parammetro o imprimir la información
        CompraContrato CC = new CompraContrato();
        CC.setIdcompracontrato(Integer.valueOf(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadCC.idcompracontrato).toString()));
        CC.setIdempresa(Integer.valueOf(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadCC.idempresa).toString()));
        CC.setIdsucursal(Integer.valueOf(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadCC.idsucursal).toString()));
        CC.setIdaperturacontrato(Integer.valueOf(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadCC.idaperturacontrato).toString()));
        CC.setPeso(Integer.valueOf(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadCC.peso).toString()));
        CC.setPrecio(Integer.valueOf(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadCC.precio).toString()));
        CC.setFecha(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadCC.fecha).toString());
        CC.setEstado(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadCC.estado).toString());

        String info = "INFO DOCUMENTO\n";
        info += "IdCompracontrato: " + CC.getIdcompracontrato()+ "\n";
        info += "IdEmpresa: " + CC.getIdempresa() + "\n";
        info += "IdSucursal: " + CC.getIdsucursal() + "\n";
        info += "IdAperturaContrato: " + CC.getIdaperturacontrato()+ "\n";
        info += "Peso: " + CC.getPeso() + "\n";
        info += "Precio: " + CC.getPrecio() + "\n";
        info += "Fecha: " + CC.getFecha() + "\n";
        info += "Estado: " + CC.getEstado() + "\n";

        JOptionPane.showMessageDialog(null, info);
    }

    private void validarSeleccionMouseDetalle(int fila) {
        UtilidadCC.filaSeleccionada = fila;

        //teniendo la fila entonces se obtiene el objeto correspondiente para enviarse como parammetro o imprimir la información        
        idempresa = Integer.valueOf(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadCC.idempresa).toString());
    }

    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == vistaCRUD.jtAperturaContrato) {
            if (me.getClickCount() > 1) {
                int fila = vistaCRUD.jtAperturaContrato.rowAtPoint(me.getPoint());
                int columna = vistaCRUD.jtAperturaContrato.columnAtPoint(me.getPoint());
                validarSeleccionMouse(fila);
            }
        }

        int fila = vistaCRUD.jtAperturaContrato.rowAtPoint(me.getPoint());
        int columna = vistaCRUD.jtAperturaContrato.columnAtPoint(me.getPoint());
    }

   
}
