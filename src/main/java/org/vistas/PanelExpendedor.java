package org.vistas;
import org.modelos.Expendedor;
import org.vistas.paneldepositos.JPanelDepositos;

import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

//Se debe instanciar a expendedor
public class PanelExpendedor extends JPanel{
    //Aqui una variable de tipo Expendedor para poder instanciarla
    //getter expendedor
    //Otra idea seira pasar el expendor para botoncomprar
    private Expendedor exp;
    private JPanelDepositos panelDepositos;
    private DepositoEspecial depositoEspecial;

    public PanelExpendedor(int size) {
        this.exp = new Expendedor(size);
        this.panelDepositos = new JPanelDepositos(exp);
        panelDepositos.setPreferredSize(new Dimension(440,440));
        add(panelDepositos);

    }

    public Expendedor getExpendedor(){
        return exp;
    }

    public JPanelDepositos getPanelDepositos(){
        return panelDepositos;
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Crear el JFrame (ventana)
            JFrame frame = new JFrame("Deposito con respectivo Botón");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 300);
            // Crear una instancia de PanelPrincipal y añadirla al JFrame
            PanelExpendedor panelExpendedor = new PanelExpendedor(5);
            frame.add(panelExpendedor);
            // Hacer visible el JFrame
            frame.setVisible(true);
        });
    }
}
