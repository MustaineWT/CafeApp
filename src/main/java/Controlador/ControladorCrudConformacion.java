/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Uti.ModeloTabla;
import static Uti.UtilidadesExtras.reiniciarJTable;
import dao.ConformacionDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import vista.RPEstimado;

/**
 *
 * @author MustainE
 */
public class ControladorCrudConformacion implements ActionListener, MouseListener, KeyListener {

    RPEstimado vistaCRUD = new RPEstimado();
    ConformacionDao modeloCRUD = new ConformacionDao();
    int idempresa;
    int idsucursal;
    ModeloTabla modelojt;
    private int filasTabla;
    private int columnasTabla;
    DecimalFormat formatea = new DecimalFormat("###,###.##");
    String texto;

    public ControladorCrudConformacion(RPEstimado vistaCRUD, ConformacionDao modeloCRUD) {
        this.modeloCRUD = modeloCRUD;
        this.vistaCRUD = vistaCRUD;
        this.vistaCRUD.btnRegistrar.addActionListener(this);
        this.vistaCRUD.btnCancelar.addActionListener(this);
        this.vistaCRUD.btnBuscarPro.addActionListener(this);     
    }

    public void InicializarCrud() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vistaCRUD.btnRegistrar) {
            if (vistaCRUD.txtSacos.getText().isEmpty()
                    || vistaCRUD.txtKb.getText().isEmpty() || vistaCRUD.txtTara.getText().isEmpty() || vistaCRUD.txtKN.getText().isEmpty()
                    || vistaCRUD.txtPrecio.getText().isEmpty() || vistaCRUD.txtLiqCompra.getText().isEmpty()
                    || vistaCRUD.txtFecha.getDate().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe Llenar todos los datos necesarios.");
            } else {
                if (vistaCRUD.btnRegistrar.getText() == "Guardar") {
                    int iddetdoc =Integer.valueOf(vistaCRUD.txtIdDetDoc.getText().toString());
                    int iddocutraza =Integer.valueOf(vistaCRUD.txtIdDocT.getText().toString());
                    int idperLPAEst =Integer.valueOf(vistaCRUD.txtIdPerLPAEst.getText().toString());
                    int idperLPACon =Integer.valueOf(vistaCRUD.txtIdProLPACon.getText().toString());
                    int idpersona =Integer.valueOf(vistaCRUD.txtIdPersona.getText().toString());
                    int sacos =Integer.valueOf(vistaCRUD.txtSacos.getText().toString());
                    long kb =Long.valueOf(vistaCRUD.txtKb.getText().toString());                    
                    long tara =Long.valueOf(vistaCRUD.txtTara.getText().toString());
                    long kn =Long.valueOf(vistaCRUD.txtKN.getText().toString());
                    long precio =Long.valueOf(vistaCRUD.txtPrecio.getText().toString());
                    long importetotal =Long.valueOf(vistaCRUD.txtImpTotal.getText().toString());
                    String guia =vistaCRUD.txtGuia.getText();
                    String liqcompra =vistaCRUD.txtGuia.getText();
                    String Estado ="";
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                    String fecha = formatoFecha.format(vistaCRUD.txtFecha.getDate());

                    if ((String) vistaCRUD.jcbEstado.getSelectedItem() == "Activo") {
                        Estado = "I";
                    }
                    if ((String) vistaCRUD.jcbEstado.getSelectedItem() == "Inactivo") {
                        Estado = "A";
                    }
                    String rptaRegistro = modeloCRUD.UpdateConformacion(iddetdoc,iddocutraza,idperLPAEst,idperLPACon,idpersona,sacos,kb,tara,kn,precio,importetotal,guia,liqcompra,fecha,Estado);
                    if (rptaRegistro != null) {
                        JOptionPane.showMessageDialog(null, rptaRegistro);                       
                        
                        vistaCRUD.dispose();
//                        reiniciarJTable(vista.RAgriEstimado.jtListProveedores);
                        //Controlador.ControladorCrudDetalleDocutraza.construirTabla();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo realizar la actualización.");
                    }
                } else {
                        System.out.println("hola");
                }
            }
        }
        if (e.getSource() == vistaCRUD.btnRegistrar) {
        
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
        if (ke.getSource() == vistaCRUD.txtKN || ke.getSource() == vistaCRUD.txtPrecio) {
            try {
                //texto = vistaCRUD.txtBuscador.getText();
                //construirTablabuscar();
                if (vistaCRUD.txtKN.getText().isEmpty() || vistaCRUD.txtPrecio.getText().isEmpty()) {

                } else {
                    long rt = (long) (Double.valueOf(vistaCRUD.txtKN.getText()) * Double.valueOf(vistaCRUD.txtPrecio.getText()));
                    vistaCRUD.txtImpTotal.setText(String.valueOf(rt));//                   
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "NO SE ENCUENTRA EL REGISTRO");
            }

        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
      
    }
}
