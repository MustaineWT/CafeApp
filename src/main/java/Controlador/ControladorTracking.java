/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Uti.GestionCeldas;
import static Uti.GestionCeldas.isNumeric;
import Uti.GestionEncabezadoTabla;
import Uti.ModeloTabla;
import Uti.Utilidades;
import dao.TrackingDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import modelo.Empresas;
import modelo.Tracking;
import vista.TrackingCafe;

/**
 *
 * @author MustainE
 */
public class ControladorTracking implements ActionListener, MouseListener, KeyListener {

    TrackingCafe vistaCRUD = new TrackingCafe();
    TrackingDao modeloCRUD = new TrackingDao();
    ArrayList<Tracking> listaPersonas;
    ModeloTabla modelojt;
    private int filasTabla;
    private int columnasTabla;
    DecimalFormat formatea = new DecimalFormat("###,###.##");
    double p = 0;
    double t = 0;

    String idempresa;
    String texto;

    public ControladorTracking(TrackingCafe vistaCRUD, TrackingDao modeloCRUD) {
        this.modeloCRUD = modeloCRUD;
        this.vistaCRUD = vistaCRUD;
        this.vistaCRUD.btnBusca.addActionListener(this);
        this.vistaCRUD.jtSeguimiento.addMouseListener(this);
        this.vistaCRUD.txtBuscador.addKeyListener(this);
    }

    public void InicializarCrud() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vistaCRUD.btnBusca) {
            Empresas em = (Empresas) vistaCRUD.jcbEmpresa.getSelectedItem();
            idempresa = em.getIdempresas().toString();
            vistaCRUD.lblECP.setText(String.valueOf(modeloCRUD.Totales(idempresa).get(0).getCpdisponible()));
            vistaCRUD.lblEOrg.setText(String.valueOf(modeloCRUD.Totales(idempresa).get(0).getOrgdisponible()));
            vistaCRUD.lblEFairTrade.setText(String.valueOf(modeloCRUD.Totales(idempresa).get(0).getFtdisponible()));
            vistaCRUD.lblERainf.setText(String.valueOf(modeloCRUD.Totales(idempresa).get(0).getRainfdisponible()));
            vistaCRUD.lblEConv.setText(String.valueOf(modeloCRUD.Totales(idempresa).get(0).getConvdisponible()));
            construirTabla();
        }

    }

    public void construirTabla() {
        dao.TrackingDao.cargaDatos();
        listaPersonas = dao.TrackingDao.listTracking(idempresa);

        ArrayList<String> titulosList = new ArrayList<>();

        titulosList.add("Emp");
        titulosList.add("IdCP");
        titulosList.add("IdCafeP.");
        titulosList.add("Cod.Org/Ft");
        titulosList.add("Apellidos");
        titulosList.add("Nombres");
        titulosList.add("Dni");
        titulosList.add("Finca");
        titulosList.add("Anexo");
        titulosList.add("CP.I.");
        titulosList.add("Org.I.");
        titulosList.add("Ft.I.");
        titulosList.add("Rainf.I.");
        titulosList.add("Conv.I.");
        titulosList.add("Cp.A.");
        titulosList.add("Org.A.");
        titulosList.add("Ft.A.");
        titulosList.add("Rainf.A.");
        titulosList.add("Conv.A.");
        titulosList.add("Cp.D.");
        titulosList.add("Org.D.");
        titulosList.add("Ft.D.");
        titulosList.add("Rainf.D.");
        titulosList.add("Conv.D.");

        //se asignan las columnas al arreglo para enviarse al momento de construir la tabla
        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }
//obtenemos los datos de la lista y los guardamos en la matriz
//que luego se manda a construir la tabla

        Object[][] data = obtenerMatrizDatos(titulosList);
        construirTabla(titulos, data);

        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor9 = vistaCRUD.jtSeguimiento.getValueAt(i, 9).toString().replace(",", "");

                if (isNumeric(valor9) == true) {
                    p = Double.parseDouble(valor9);
                }
                t += p;
            }
            vistaCRUD.lblCPI.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor10 = vistaCRUD.jtSeguimiento.getValueAt(i, 10).toString().replace(",", "");

                if (isNumeric(valor10) == true) {
                    p = Double.parseDouble(valor10);
                }
                t += p;
            }
            vistaCRUD.lblORGI.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor11 = vistaCRUD.jtSeguimiento.getValueAt(i, 11).toString().replace(",", "");

                if (isNumeric(valor11) == true) {
                    p = Double.parseDouble(valor11);
                }
                t += p;
            }
            vistaCRUD.lblFTI.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor12 = vistaCRUD.jtSeguimiento.getValueAt(i, 12).toString().replace(",", "");

                if (isNumeric(valor12) == true) {
                    p = Double.parseDouble(valor12);
                }
                t += p;
            }
            vistaCRUD.lblRAINFI.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor13 = vistaCRUD.jtSeguimiento.getValueAt(i, 13).toString().replace(",", "");

                if (isNumeric(valor13) == true) {
                    p = Double.parseDouble(valor13);
                }
                t += p;
            }
            vistaCRUD.lblCONVI.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor14 = vistaCRUD.jtSeguimiento.getValueAt(i, 14).toString().replace(",", "");

                if (isNumeric(valor14) == true) {
                    p = Double.parseDouble(valor14);
                }
                t += p;
            }
            vistaCRUD.lblCPA.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor15 = vistaCRUD.jtSeguimiento.getValueAt(i, 15).toString().replace(",", "");

                if (isNumeric(valor15) == true) {
                    p = Double.parseDouble(valor15);
                }
                t += p;
            }
            vistaCRUD.lblORGA.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor16 = vistaCRUD.jtSeguimiento.getValueAt(i, 16).toString().replace(",", "");

                if (isNumeric(valor16) == true) {
                    p = Double.parseDouble(valor16);
                }
                t += p;
            }
            vistaCRUD.lblFTA.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor17 = vistaCRUD.jtSeguimiento.getValueAt(i, 17).toString().replace(",", "");

                if (isNumeric(valor17) == true) {
                    p = Double.parseDouble(valor17);
                }
                t += p;
            }
            vistaCRUD.lblRAINFA.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor18 = vistaCRUD.jtSeguimiento.getValueAt(i, 18).toString().replace(",", "");

                if (isNumeric(valor18) == true) {
                    p = Double.parseDouble(valor18);
                }
                t += p;
            }
            vistaCRUD.lblCONVA.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor19 = vistaCRUD.jtSeguimiento.getValueAt(i, 19).toString().replace(",", "");

                if (isNumeric(valor19) == true) {
                    p = Double.parseDouble(valor19);
                }
                t += p;
            }
            vistaCRUD.lblCPD.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor20 = vistaCRUD.jtSeguimiento.getValueAt(i, 20).toString().replace(",", "");

                if (isNumeric(valor20) == true) {
                    p = Double.parseDouble(valor20);
                }
                t += p;
            }
            vistaCRUD.lblORGD.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor21 = vistaCRUD.jtSeguimiento.getValueAt(i, 21).toString().replace(",", "");

                if (isNumeric(valor21) == true) {
                    p = Double.parseDouble(valor21);
                }
                t += p;
            }
            vistaCRUD.lblFTD.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor22 = vistaCRUD.jtSeguimiento.getValueAt(i, 22).toString().replace(",", "");

                if (isNumeric(valor22) == true) {
                    p = Double.parseDouble(valor22);
                }
                t += p;
            }
            vistaCRUD.lblRAINFD.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor23 = vistaCRUD.jtSeguimiento.getValueAt(i, 23).toString().replace(",", "");

                if (isNumeric(valor23) == true) {
                    p = Double.parseDouble(valor23);
                }
                t += p;
            }
            vistaCRUD.lblCONVD.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
    }

    public void construirTablaini() {
        dao.TrackingDao.cargaDatos();
        listaPersonas = dao.TrackingDao.listTrackingini();

        ArrayList<String> titulosList = new ArrayList<>();

        titulosList.add("Emp");
        titulosList.add("IdCP");
        titulosList.add("IdCafeP.");
        titulosList.add("Cod.Org/Ft");
        titulosList.add("Apellidos");
        titulosList.add("Nombres");
        titulosList.add("Dni");
        titulosList.add("Finca");
        titulosList.add("Anexo");
        titulosList.add("CP.I.");
        titulosList.add("Org.I.");
        titulosList.add("Ft.I.");
        titulosList.add("Rainf.I.");
        titulosList.add("Conv.I.");
        titulosList.add("Cp.A.");
        titulosList.add("Org.A.");
        titulosList.add("Ft.A.");
        titulosList.add("Rainf.A.");
        titulosList.add("Conv.A.");
        titulosList.add("Cp.D.");
        titulosList.add("Org.D.");
        titulosList.add("Ft.D.");
        titulosList.add("Rainf.D.");
        titulosList.add("Conv.D.");

        //se asignan las columnas al arreglo para enviarse al momento de construir la tabla
        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }

//obtenemos los datos de la lista y los guardamos en la matriz
//que luego se manda a construir la tabla
        Object[][] data = obtenerMatrizDatos(titulosList);
        construirTabla(titulos, data);

        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor9 = vistaCRUD.jtSeguimiento.getValueAt(i, 9).toString().replace(",", "");

                if (isNumeric(valor9) == true) {
                    p = Double.parseDouble(valor9);
                }
                t += p;
            }
            vistaCRUD.lblCPI.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor10 = vistaCRUD.jtSeguimiento.getValueAt(i, 10).toString().replace(",", "");

                if (isNumeric(valor10) == true) {
                    p = Double.parseDouble(valor10);
                }
                t += p;
            }
            vistaCRUD.lblORGI.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor11 = vistaCRUD.jtSeguimiento.getValueAt(i, 11).toString().replace(",", "");

                if (isNumeric(valor11) == true) {
                    p = Double.parseDouble(valor11);
                }
                t += p;
            }
            vistaCRUD.lblFTI.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor12 = vistaCRUD.jtSeguimiento.getValueAt(i, 12).toString().replace(",", "");

                if (isNumeric(valor12) == true) {
                    p = Double.parseDouble(valor12);
                }
                t += p;
            }
            vistaCRUD.lblRAINFI.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor13 = vistaCRUD.jtSeguimiento.getValueAt(i, 13).toString().replace(",", "");

                if (isNumeric(valor13) == true) {
                    p = Double.parseDouble(valor13);
                }
                t += p;
            }
            vistaCRUD.lblCONVI.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor14 = vistaCRUD.jtSeguimiento.getValueAt(i, 14).toString().replace(",", "");

                if (isNumeric(valor14) == true) {
                    p = Double.parseDouble(valor14);
                }
                t += p;
            }
            vistaCRUD.lblCPA.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor15 = vistaCRUD.jtSeguimiento.getValueAt(i, 15).toString().replace(",", "");

                if (isNumeric(valor15) == true) {
                    p = Double.parseDouble(valor15);
                }
                t += p;
            }
            vistaCRUD.lblORGA.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor16 = vistaCRUD.jtSeguimiento.getValueAt(i, 16).toString().replace(",", "");

                if (isNumeric(valor16) == true) {
                    p = Double.parseDouble(valor16);
                }
                t += p;
            }
            vistaCRUD.lblFTA.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor17 = vistaCRUD.jtSeguimiento.getValueAt(i, 17).toString().replace(",", "");

                if (isNumeric(valor17) == true) {
                    p = Double.parseDouble(valor17);
                }
                t += p;
            }
            vistaCRUD.lblRAINFA.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor18 = vistaCRUD.jtSeguimiento.getValueAt(i, 18).toString().replace(",", "");

                if (isNumeric(valor18) == true) {
                    p = Double.parseDouble(valor18);
                }
                t += p;
            }
            vistaCRUD.lblCONVA.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor19 = vistaCRUD.jtSeguimiento.getValueAt(i, 19).toString().replace(",", "");

                if (isNumeric(valor19) == true) {
                    p = Double.parseDouble(valor19);
                }
                t += p;
            }
            vistaCRUD.lblCPD.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor20 = vistaCRUD.jtSeguimiento.getValueAt(i, 20).toString().replace(",", "");

                if (isNumeric(valor20) == true) {
                    p = Double.parseDouble(valor20);
                }
                t += p;
            }
            vistaCRUD.lblORGD.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor21 = vistaCRUD.jtSeguimiento.getValueAt(i, 21).toString().replace(",", "");

                if (isNumeric(valor21) == true) {
                    p = Double.parseDouble(valor21);
                }
                t += p;
            }
            vistaCRUD.lblFTD.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor22 = vistaCRUD.jtSeguimiento.getValueAt(i, 22).toString().replace(",", "");

                if (isNumeric(valor22) == true) {
                    p = Double.parseDouble(valor22);
                }
                t += p;
            }
            vistaCRUD.lblRAINFD.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor23 = vistaCRUD.jtSeguimiento.getValueAt(i, 23).toString().replace(",", "");

                if (isNumeric(valor23) == true) {
                    p = Double.parseDouble(valor23);
                }
                t += p;
            }
            vistaCRUD.lblCONVD.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
    }

    public void construirTablabuscar() {
        listaPersonas = dao.TrackingDao.listTrackingbuscar(texto);
        ArrayList<String> titulosList = new ArrayList<>();
        titulosList.add("Emp");
        titulosList.add("IdCP");
        titulosList.add("IdCafeP.");
        titulosList.add("Cod.Org/Ft");
        titulosList.add("Apellidos");
        titulosList.add("Nombres");
        titulosList.add("Dni");
        titulosList.add("Finca");
        titulosList.add("Anexo");
        titulosList.add("CP.I.");
        titulosList.add("Org.I.");
        titulosList.add("Ft.I.");
        titulosList.add("Rainf.I.");
        titulosList.add("Conv.I.");
        titulosList.add("Cp.A.");
        titulosList.add("Org.A.");
        titulosList.add("Ft.A.");
        titulosList.add("Rainf.A.");
        titulosList.add("Conv.A.");
        titulosList.add("Cp.D.");
        titulosList.add("Org.D.");
        titulosList.add("Ft.D.");
        titulosList.add("Rainf.D.");
        titulosList.add("Conv.D.");

        //se asignan las columnas al arreglo para enviarse al momento de construir la tabla
        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }
//obtenemos los datos de la lista y los guardamos en la matriz
//que luego se manda a construir la tabla

        Object[][] data = obtenerMatrizDatos(titulosList);
        construirTabla(titulos, data);

        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor9 = vistaCRUD.jtSeguimiento.getValueAt(i, 9).toString().replace(",", "");

                if (isNumeric(valor9) == true) {
                    p = Double.parseDouble(valor9);
                }
                t += p;
            }
            vistaCRUD.lblCPI.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor10 = vistaCRUD.jtSeguimiento.getValueAt(i, 10).toString().replace(",", "");

                if (isNumeric(valor10) == true) {
                    p = Double.parseDouble(valor10);
                }
                t += p;
            }
            vistaCRUD.lblORGI.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor11 = vistaCRUD.jtSeguimiento.getValueAt(i, 11).toString().replace(",", "");

                if (isNumeric(valor11) == true) {
                    p = Double.parseDouble(valor11);
                }
                t += p;
            }
            vistaCRUD.lblFTI.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor12 = vistaCRUD.jtSeguimiento.getValueAt(i, 12).toString().replace(",", "");

                if (isNumeric(valor12) == true) {
                    p = Double.parseDouble(valor12);
                }
                t += p;
            }
            vistaCRUD.lblRAINFI.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor13 = vistaCRUD.jtSeguimiento.getValueAt(i, 13).toString().replace(",", "");

                if (isNumeric(valor13) == true) {
                    p = Double.parseDouble(valor13);
                }
                t += p;
            }
            vistaCRUD.lblCONVI.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor14 = vistaCRUD.jtSeguimiento.getValueAt(i, 14).toString().replace(",", "");

                if (isNumeric(valor14) == true) {
                    p = Double.parseDouble(valor14);
                }
                t += p;
            }
            vistaCRUD.lblCPA.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor15 = vistaCRUD.jtSeguimiento.getValueAt(i, 15).toString().replace(",", "");

                if (isNumeric(valor15) == true) {
                    p = Double.parseDouble(valor15);
                }
                t += p;
            }
            vistaCRUD.lblORGA.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor16 = vistaCRUD.jtSeguimiento.getValueAt(i, 16).toString().replace(",", "");

                if (isNumeric(valor16) == true) {
                    p = Double.parseDouble(valor16);
                }
                t += p;
            }
            vistaCRUD.lblFTA.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor17 = vistaCRUD.jtSeguimiento.getValueAt(i, 17).toString().replace(",", "");

                if (isNumeric(valor17) == true) {
                    p = Double.parseDouble(valor17);
                }
                t += p;
            }
            vistaCRUD.lblRAINFA.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor18 = vistaCRUD.jtSeguimiento.getValueAt(i, 18).toString().replace(",", "");

                if (isNumeric(valor18) == true) {
                    p = Double.parseDouble(valor18);
                }
                t += p;
            }
            vistaCRUD.lblCONVA.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor19 = vistaCRUD.jtSeguimiento.getValueAt(i, 19).toString().replace(",", "");

                if (isNumeric(valor19) == true) {
                    p = Double.parseDouble(valor19);
                }
                t += p;
            }
            vistaCRUD.lblCPD.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor20 = vistaCRUD.jtSeguimiento.getValueAt(i, 20).toString().replace(",", "");

                if (isNumeric(valor20) == true) {
                    p = Double.parseDouble(valor20);
                }
                t += p;
            }
            vistaCRUD.lblORGD.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor21 = vistaCRUD.jtSeguimiento.getValueAt(i, 21).toString().replace(",", "");

                if (isNumeric(valor21) == true) {
                    p = Double.parseDouble(valor21);
                }
                t += p;
            }
            vistaCRUD.lblFTD.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor22 = vistaCRUD.jtSeguimiento.getValueAt(i, 22).toString().replace(",", "");

                if (isNumeric(valor22) == true) {
                    p = Double.parseDouble(valor22);
                }
                t += p;
            }
            vistaCRUD.lblRAINFD.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
        if (vistaCRUD.jtSeguimiento.getRowCount() > 0) {
            for (int i = 0; i < vistaCRUD.jtSeguimiento.getRowCount(); i++) {
                String valor23 = vistaCRUD.jtSeguimiento.getValueAt(i, 23).toString().replace(",", "");

                if (isNumeric(valor23) == true) {
                    p = Double.parseDouble(valor23);
                }
                t += p;
            }
            vistaCRUD.lblCONVD.setText(formatea.format(t).replace(".", ",") + "");
            p = 0;
            t = 0;
        }
    }
//
// Llena la información de la tabla usando la lista de personas trabajada 
// anteriormente, guardandola en una matriz que se retorna con toda 
// la información para luego ser asignada al modelo
// @param titulosList
// @return
//

    private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {

//se crea la matriz donde las filas son dinamicas pues corresponde
//a todos los usuarios, mientras que las columnas son estaticas
// correspondiendo a las columnas definidas por defecto
//
        String informacion[][] = new String[listaPersonas.size()][titulosList.size()];

        for (int x = 0; x < informacion.length; x++) {

            informacion[x][Utilidades.idempresa] = listaPersonas.get(x).getIdempresa() + "";
            informacion[x][Utilidades.idcp] = listaPersonas.get(x).getIdcp() + "";
            informacion[x][Utilidades.idcafepractice] = listaPersonas.get(x).getIdcafepractice() + "";
            informacion[x][Utilidades.codagri] = listaPersonas.get(x).getCodagri() + "";
            informacion[x][Utilidades.apeagri] = listaPersonas.get(x).getApeagri() + "";
            informacion[x][Utilidades.nomagri] = listaPersonas.get(x).getNomagri() + "";
            informacion[x][Utilidades.dniagri] = listaPersonas.get(x).getDniagri() + "";
            informacion[x][Utilidades.nomfinca] = listaPersonas.get(x).getNomfinca() + "";
            informacion[x][Utilidades.nomanexo] = listaPersonas.get(x).getNomanexo() + "";
            informacion[x][Utilidades.cpinicial] = listaPersonas.get(x).getCpinicial() + "";
            informacion[x][Utilidades.orginicial] = listaPersonas.get(x).getOrginicial() + "";
            informacion[x][Utilidades.ftinicial] = listaPersonas.get(x).getFtinicial() + "";
            informacion[x][Utilidades.rainfinicial] = listaPersonas.get(x).getRainfinicial() + "";
            informacion[x][Utilidades.convinicial] = listaPersonas.get(x).getConvinicial() + "";
            informacion[x][Utilidades.cpavance] = listaPersonas.get(x).getCpavance() + "";
            informacion[x][Utilidades.orgavance] = listaPersonas.get(x).getOrgavance() + "";
            informacion[x][Utilidades.ftavance] = listaPersonas.get(x).getFtavance() + "";
            informacion[x][Utilidades.rainfavance] = listaPersonas.get(x).getRainfavance() + "";
            informacion[x][Utilidades.convavance] = listaPersonas.get(x).getConvavance() + "";
            informacion[x][Utilidades.cpdisponible] = listaPersonas.get(x).getCpdisponible() + "";
            informacion[x][Utilidades.orgdisponible] = listaPersonas.get(x).getOrgdisponible() + "";
            informacion[x][Utilidades.ftdisponible] = listaPersonas.get(x).getFtdisponible() + "";
            informacion[x][Utilidades.rainfdisponible] = listaPersonas.get(x).getRainfdisponible() + "";
            informacion[x][Utilidades.convdisponible] = listaPersonas.get(x).getConvdisponible() + "";

            //se asignan las plabras clave para que en la clase GestionCeldas se use para asignar el icono correspondiente
            //informacion[x][Utilidades.PERFIL] = "PERFIL";
            //informacion[x][Utilidades.EVENTO] = "EVENTO";
        }

        return informacion;
    }

//
// Con los titulos y la información a mostrar se crea el modelo para 
// poder personalizar la tabla, asignando tamaño de celdas tanto en ancho como en alto
// así como los tipos de datos que va a poder soportar.
// @param titulos
// @param data
//
    private void construirTabla(String[] titulos, Object[][] data) {
        modelojt = new ModeloTabla(data, titulos);
        //se asigna el modelo a la tabla
        vistaCRUD.jtSeguimiento.setModel(modelojt);

        filasTabla = vistaCRUD.jtSeguimiento.getRowCount();
        columnasTabla = vistaCRUD.jtSeguimiento.getColumnCount();

        //se asigna el tipo de dato que tendrán las celdas de cada columna definida respectivamente para validar su personalización
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.cpinicial).setCellRenderer(new GestionCeldas("numerico"));
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.orginicial).setCellRenderer(new GestionCeldas("numerico"));
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.ftinicial).setCellRenderer(new GestionCeldas("numerico"));
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.rainfinicial).setCellRenderer(new GestionCeldas("numerico"));
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.convinicial).setCellRenderer(new GestionCeldas("numerico"));
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.cpavance).setCellRenderer(new GestionCeldas("numerico1"));
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.orgavance).setCellRenderer(new GestionCeldas("numerico1"));
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.ftavance).setCellRenderer(new GestionCeldas("numerico1"));
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.rainfavance).setCellRenderer(new GestionCeldas("numerico1"));
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.convavance).setCellRenderer(new GestionCeldas("numerico1"));
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.cpdisponible).setCellRenderer(new GestionCeldas("numerico2"));
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.orgdisponible).setCellRenderer(new GestionCeldas("numerico2"));
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.ftdisponible).setCellRenderer(new GestionCeldas("numerico2"));
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.rainfdisponible).setCellRenderer(new GestionCeldas("numerico2"));
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.convdisponible).setCellRenderer(new GestionCeldas("numerico2"));

        //se recorre y asigna el resto de celdas que serian las que almacenen datos de tipo texto
        for (int i = 0; i < titulos.length - 15; i++) {//se resta 7 porque las ultimas 7 columnas se definen arriba
            vistaCRUD.jtSeguimiento.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("texto"));
        }

        vistaCRUD.jtSeguimiento.getTableHeader().setReorderingAllowed(false);
        vistaCRUD.jtSeguimiento.setRowHeight(25);//tamaño de las celdas
        vistaCRUD.jtSeguimiento.setGridColor(new java.awt.Color(0, 0, 0));
        //Se define el tamaño de largo para cada columna y su contenido
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.idempresa).setPreferredWidth(40);//nombre
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.idcp).setPreferredWidth(60);//telefono
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.idcafepractice).setPreferredWidth(60);//profesion
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.codagri).setPreferredWidth(70);//edad
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.apeagri).setPreferredWidth(70);//nota1
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.nomagri).setPreferredWidth(70);//nota2
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.dniagri).setPreferredWidth(50);//nota3
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.nomfinca).setPreferredWidth(60);//promedio
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.nomanexo).setPreferredWidth(70);//accion perfil
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.cpinicial).setPreferredWidth(60);//accion evento
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.orginicial).setPreferredWidth(60);//accion evento
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.ftinicial).setPreferredWidth(60);//accion evento
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.rainfinicial).setPreferredWidth(60);//accion evento
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.convinicial).setPreferredWidth(60);//accion evento
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.cpavance).setPreferredWidth(60);//accion evento
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.orgavance).setPreferredWidth(60);//accion evento
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.ftavance).setPreferredWidth(60);//accion evento
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.rainfavance).setPreferredWidth(60);//accion evento
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.convavance).setPreferredWidth(60);//accion evento
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.cpdisponible).setPreferredWidth(60);//accion evento
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.orgdisponible).setPreferredWidth(60);//accion evento
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.ftdisponible).setPreferredWidth(60);//accion evento
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.rainfdisponible).setPreferredWidth(60);//accion evento
        vistaCRUD.jtSeguimiento.getColumnModel().getColumn(Utilidades.convdisponible).setPreferredWidth(60);//accion evento

        //personaliza el encabezado
        JTableHeader jtableHeader = vistaCRUD.jtSeguimiento.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        vistaCRUD.jtSeguimiento.setTableHeader(jtableHeader);

        //se asigna la tabla al scrollPane
//     scrollPaneTabla.setViewportView(vistaCRUD.jtSeguimiento);
    }

//
// Este metodo simularia el proceso o la acción que se quiere realizar si 
// se presiona alguno de los botones o iconos de la tabla
// @param fila
//
    private void validarSeleccionMouse(int fila) {
        Utilidades.filaSeleccionada = fila;

        //teniendo la fila entonces se obtiene el objeto correspondiente para enviarse como parammetro o imprimir la información
        Tracking miPersona = new Tracking();
        miPersona.setIdempresa(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.idempresa).toString());
        miPersona.setIdcp(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.idcp).toString());
        miPersona.setIdcafepractice(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.idcafepractice).toString());
        miPersona.setCodagri(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.codagri).toString());
        miPersona.setApeagri(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.apeagri).toString());
        miPersona.setNomagri(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.nomagri).toString());
        miPersona.setDniagri(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.dniagri).toString());
        miPersona.setNomfinca(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.nomfinca).toString());
        miPersona.setNomanexo(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.nomanexo).toString());
        miPersona.setCpinicial(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.cpinicial).toString());
        miPersona.setOrginicial(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.orginicial).toString());
        miPersona.setFtinicial(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.ftinicial).toString());
        miPersona.setRainfinicial(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.rainfinicial).toString());
        miPersona.setConvinicial(vistaCRUD.jtSeguimiento.getValueAt(fila, Utilidades.convinicial).toString());

        String info = "INFO PERSONA\n";
        info += "Empresa: " + miPersona.getIdempresa() + "\n";
        info += "Código Empresa: " + miPersona.getIdcp() + "\n";
        info += "Código Cafe Practice: " + miPersona.getIdcafepractice() + "\n";
        info += "Cod.Org/Ft Agricultor: " + miPersona.getCodagri() + "\n";
        info += "Apellidos: " + miPersona.getApeagri() + "\n";
        info += "Nombres: " + miPersona.getNomagri() + "\n";
        info += "Dni: " + miPersona.getDniagri() + "\n";
        info += "Finca: " + miPersona.getNomfinca() + "\n";
        info += "Anexo: " + miPersona.getNomanexo() + "\n";
        info += "Cp Inicial: " + miPersona.getCpinicial() + "\n";
        info += "Orga Inicial: " + miPersona.getOrginicial() + "\n";
        info += "Ft Inicial: " + miPersona.getFtinicial() + "\n";
        info += "Rainforest Inicial: " + miPersona.getRainfinicial() + "\n";
        info += "Convecional Inicial: " + miPersona.getConvinicial() + "\n";

        JOptionPane.showMessageDialog(null, info);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (me.getSource() == vistaCRUD.jtSeguimiento) {
            //capturo fila o columna dependiendo de mi necesidad
            if (me.getClickCount() > 1) {
                int fila = vistaCRUD.jtSeguimiento.rowAtPoint(me.getPoint());
                int columna = vistaCRUD.jtSeguimiento.columnAtPoint(me.getPoint());

                validarSeleccionMouse(fila);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (ke.getSource() == vistaCRUD.txtBuscador) {
            try {
                texto = vistaCRUD.txtBuscador.getText();
                construirTablabuscar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "NO SE ENCUENTRA EL REGISTRO");
            }
        }
    }

}
