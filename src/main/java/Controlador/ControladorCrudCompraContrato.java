package Controlador;

import Uti.GestionCeldas;
import Uti.GestionEncabezadoTabla;
import Uti.ModeloTabla;
import Uti.UtilidadApC;
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
import vista.CompraContrato;
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
//    private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {
//
//        String informacion[][] = new String[listaAperturaContrato.size()][titulosList.size()];
//
//        for (int x = 0; x < informacion.length; x++) {
//
//            informacion[x][UtilidadApC.idaperturacontrato] = listaAperturaContrato.get(x).getIdaperturacontrato()+ "";
//            informacion[x][UtilidadApC.idempresa] = listaAperturaContrato.get(x).getIdempresa() + "";
//            informacion[x][UtilidadApC.idsucursal] = listaAperturaContrato.get(x).getIdsucursal() + "";
//            informacion[x][UtilidadApC.peso] = listaAperturaContrato.get(x).getPeso() + "";
//            informacion[x][UtilidadApC.precio] = listaAperturaContrato.get(x).getPrecio() + "";
//            informacion[x][UtilidadApC.calidad] = listaAperturaContrato.get(x).getCalidad() + "";
//            informacion[x][UtilidadApC.humedad] = listaAperturaContrato.get(x).getHumedad() + "";
//            informacion[x][UtilidadApC.contrato] = listaAperturaContrato.get(x).getContrato() + "";
//            informacion[x][UtilidadApC.fecha] = listaAperturaContrato.get(x).getFecha() + "";
//            informacion[x][UtilidadApC.estado] = listaAperturaContrato.get(x).getEstado() + "";
//        }
//        return informacion;
//    }

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

        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.idaperturacontrato).setPreferredWidth(40);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.idempresa).setPreferredWidth(40);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.idsucursal).setPreferredWidth(40);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.peso).setPreferredWidth(60);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.precio).setPreferredWidth(60);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.calidad).setPreferredWidth(50);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.humedad).setPreferredWidth(70);
        vistaCRUD.jtAperturaContrato.getColumnModel().getColumn(UtilidadApC.contrato).setPreferredWidth(70);
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
        CompraContrato ApC = new AperturaContrato();
        ApC.setIdaperturacontrato(Integer.valueOf(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.idaperturacontrato).toString()));
        ApC.setIdempresa(Integer.valueOf(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.idempresa).toString()));
        ApC.setIdsucursal(Integer.valueOf(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.idsucursal).toString()));
        ApC.setPeso(Integer.valueOf(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.peso).toString()));
        ApC.setPrecio(Integer.valueOf(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.precio).toString()));
        ApC.setCalidad(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.calidad).toString());
        ApC.setHumedad(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.humedad).toString());
        ApC.setContrato(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.contrato).toString());
        ApC.setFecha(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.fecha).toString());
        ApC.setEstado(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.estado).toString());

        String info = "INFO DOCUMENTO\n";
        info += "IdAperturaContrato: " + ApC.getIdaperturacontrato()+ "\n";
        info += "IdEmpresa: " + ApC.getIdempresa() + "\n";
        info += "IdSucursal: " + ApC.getIdsucursal() + "\n";
        info += "Peso: " + ApC.getPeso() + "\n";
        info += "Precio: " + ApC.getPrecio() + "\n";
        info += "Calidad: " + ApC.getCalidad() + "\n";
        info += "Humedad: " + ApC.getHumedad() + "\n";
        info += "Contrato: " + ApC.getContrato() + "\n";
        info += "Fecha: " + ApC.getFecha() + "\n";
        info += "Estado: " + ApC.getEstado() + "\n";

        JOptionPane.showMessageDialog(null, info);
    }

    private void validarSeleccionMouseDetalle(int fila) {
        UtilidadApC.filaSeleccionada = fila;

        //teniendo la fila entonces se obtiene el objeto correspondiente para enviarse como parammetro o imprimir la información        
        idempresa = Integer.valueOf(vistaCRUD.jtAperturaContrato.getValueAt(fila, UtilidadApC.idempresa).toString());
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
