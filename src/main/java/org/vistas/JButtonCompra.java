package org.vistas;

import org.modelos.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JButtonCompra extends JPanel {
    private Expendedor expendedor;
    private JPanelSelect comPanel;
    private PanelBilletera monedero;
    private Selector seleccion;
    private Moneda moneda;
    //Objeto fuente
    private JRadioButton  BotonComprar= new JRadioButton("Compra");

    public JButtonCompra(Expendedor exp, JPanelSelect comPanel, PanelBilletera monedero) {
        this.expendedor = exp;
        this. comPanel = comPanel;
        this.monedero = monedero;
        this.moneda = monedero.getMoneda();

        add(BotonComprar);

        BotonComprar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) { //clickea
                try {
                    seleccion = comPanel.getTipoProducto();
                    expendedor.comprarProducto(moneda, seleccion);
                } catch (PagoIncorrectoException ex) {
                    JOptionPane.showMessageDialog(null, "Debes seleccionar una moneda");
                } catch(NoHayProductoException ex) {
                    Moneda moneda = expendedor.getVuelto();
                    JOptionPane.showMessageDialog(null, "No hay stock o el producto no existe");
                } catch(PagoInsuficienteException ex) {
                    Moneda moneda = expendedor.getVuelto();
                    JOptionPane.showMessageDialog(null, "El pago es insuficiente");
                }

            }

            @Override
            public void mousePressed(MouseEvent e) { //presionado

            }

            @Override
            public void mouseReleased(MouseEvent e) { //soltado

            }

            @Override
            public void mouseEntered(MouseEvent e) { //entra (por encima)

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        // Crear el JFrame
        JFrame frame = new JFrame("Compra de Productos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Crear instancias de PanelExpendedor y PanelComprador
        Expendedor exp = new Expendedor(5);
        JPanelSelect com = new JPanelSelect();
        PanelBilletera mon = new PanelBilletera();

        // Inicializar la instancia de JButtonCompra
        JButtonCompra botonCompra = new JButtonCompra(exp, com, mon);

        // Añadir el panel de compra al frame
        frame.add(botonCompra);

        // Configuración y visualización del JFrame
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }


}
