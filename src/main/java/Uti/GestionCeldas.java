/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Uti;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class GestionCeldas extends DefaultTableCellRenderer {

    private String tipo = "text";

    //se definen por defecto los tipos de datos a usar
    private Font normal = new Font("Arial", Font.PLAIN, 11);
    private Font bold = new Font("Arial", Font.BOLD, 11);
    //public DecimalFormat formatea = new DecimalFormat("#########.##");
    public DecimalFormat df = new DecimalFormat("#,##0.00");
    //etiqueta que almacenará el icono a mostrar
    private JLabel label = new JLabel();
    public ImageIcon iconoVerMas = new ImageIcon("D:/Sistema/Imagenes/icons8_Forward_Button_20px.png");
    //private ImageIcon iconoVerMas = new ImageIcon(iconoVerMa.getImage().getScaledInstance(label.getWidth(),label.getHeight(),Image.SCALE_DEFAULT));
    //iconos disponibles para ser mostrados en la etiqueta dependiendo de la columna que lo contenga

    public GestionCeldas() {

    }

    public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Double.parseDouble(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

//
//constructor explicito con el tipo de dato que tendrá la celda
// @param tipo
//
    public GestionCeldas(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {

//
//Este metodo controla toda la tabla, podemos obtener el valor que contiene
// definir que celda está seleccionada, la fila y columna al tener el foco en ella.
// 
// cada evento sobre la tabla invocará a este metodo
//
        //definimos colores por defecto
        Color colorFondo = null;
        Color colorFondoPorDefecto = new Color(192, 192, 192);
        Color colorFondoSeleccion = new Color(140, 140, 140);
        Color colorFondodudo = new Color(217, 25, 11);

        /*
         * Si la celda del evento es la seleccionada se asigna el fondo por defecto para la selección
         */
        if (selected) {
            this.setBackground(colorFondoPorDefecto);
        } else {
            //Para las que no están seleccionadas se pinta el fondo de las celdas de blanco
            this.setBackground(Color.white);
        }

        /*
         * Se definen los tipos de datos que contendrán las celdas basado en la instancia que
         * se hace en la ventana de la tabla al momento de construirla
         */
        if (tipo.equals("texto")) {
            //si es tipo texto define el color de fondo del texto y de la celda así como la alineación
            if (focused) {
                colorFondo = colorFondoSeleccion;
            } else {
                colorFondo = colorFondoPorDefecto;
            }
            this.setHorizontalAlignment(JLabel.LEFT);
            this.setText((String) value);
            //this.setForeground( (selected)? new Color(255,255,255) :new Color(0,0,0) );   
            //this.setForeground( (selected)? new Color(255,255,255) :new Color(32,117,32) );
            this.setBackground((selected) ? colorFondo : Color.WHITE);
            this.setFont(normal);
            //this.setFont(bold);
            return this;
        }

        //si el tipo es icono entonces valida cual icono asignar a la etiqueta.
        if (tipo.equals("icono")) {
            if (String.valueOf(value).equals("VERMAS")) {
                label.setIcon(iconoVerMas);
                label.setText("Ver Más.");

            } else if (String.valueOf(value).equals("EDITAR")) {
//             label.setIcon(iconoEditar);
            }
            label.setHorizontalAlignment(JLabel.LEFT);
            label.setBackground(Color.WHITE);
            label.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
//            return boton;
            return label;
        }
        //definie si el tipo de dato el numerico para personalizarlo
        if (tipo.equals("numerico")) {
            if (focused) {
                colorFondo = colorFondoSeleccion;
            } else {
                colorFondo = colorFondoPorDefecto;
            }
            // System.out.println(value);
            this.setHorizontalAlignment(JLabel.CENTER);
            this.setText((String) value);
            this.setForeground((selected) ? new Color(255, 255, 255) : new Color(52, 128, 235));
            this.setBackground((selected) ? colorFondo : Color.WHITE);
            // this.setBackground( (selected)? colorFondo :Color.MAGENTA);
//            String v = String.valueOf(df.format(Double.valueOf(String.valueOf(value))));
          //  this.setText(v);
            this.setFont(bold);
            return this;
        }
        if (tipo.equals("numericop")) {
            if (focused) {
                colorFondo = colorFondoSeleccion;
            } else {
                colorFondo = colorFondoPorDefecto;
            }
            // System.out.println(value);
            this.setHorizontalAlignment(JLabel.CENTER);
            this.setText((String) value);
            this.setForeground((selected) ? new Color(255, 255, 255) : new Color(52, 128, 235));
            this.setBackground((selected) ? colorFondo : Color.WHITE);
            // this.setBackground( (selected)? colorFondo :Color.MAGENTA);
            String v = String.valueOf(df.format(Double.valueOf(String.valueOf(value))));
            this.setText(v);
            this.setFont(bold);
            return this;
        }
        if (tipo.equals("numerico1")) {
            if (focused) {
                colorFondo = colorFondoSeleccion;
            } else {
                colorFondo = colorFondoPorDefecto;
            }
            // System.out.println(value);
            this.setHorizontalAlignment(JLabel.CENTER);
            this.setText((String) value);
            this.setForeground((selected) ? new Color(255, 255, 255) : new Color(230, 84, 44));
            String v = String.valueOf(df.format(Double.valueOf(String.valueOf(value))));
            this.setText(v);
            this.setBackground((selected) ? colorFondo : Color.WHITE);
            //this.setBackground((selected) ? colorFondo : Color.WHITE);
            // this.setBackground( (selected)? colorFondo :Color.MAGENTA);
            this.setFont(bold);
            return this;
        }

        if (tipo.equals("numerico2")) {
            if (focused) {
                colorFondo = colorFondoSeleccion;
            } else {
                colorFondo = colorFondoPorDefecto;
            }
            // System.out.println(value);
            this.setHorizontalAlignment(JLabel.CENTER);
            this.setText((String) value);
            this.setForeground((selected) ? new Color(255, 255, 255) : new Color(32, 114, 32));
            this.setBackground((selected) ? colorFondo : Color.WHITE);

            if (column == 22 || column == 23 || column == 24 || column == 25 || column == 26) {
                String valor = String.valueOf(df.format(Double.valueOf(String.valueOf(value))));
                String v = String.valueOf(df.format(Double.valueOf(String.valueOf(value))));
                //System.out.println(valor);
                double valor1;
                if (isNumeric(valor) == true) {
                    valor1 = Double.parseDouble(valor);
                    if (valor1 <= 0) {
                        this.setBackground((selected) ? colorFondo : Color.RED);
                        this.setForeground((selected) ? new Color(255, 255, 255) : Color.white);
                        this.setText(v);
                    }

                } else {
                    this.setBackground((selected) ? colorFondo : Color.WHITE);                    
                    this.setText(v);
                }
            }

            // this.setBackground( (selected)? colorFondo :Color.MAGENTA);
            this.setFont(bold);
            return this;
        }

        return this;
    }
}
