package org.vistas.botonmonedas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import org.modelos.Moneda;
import org.modelos.Moneda2000;
import org.vistas.JPanelBilletera;

public class Boton2000 extends JRadioButton implements MouseListener {
    private JPanelBilletera panelBilletera;
    private int contador = 223;

    public Boton2000(JPanelBilletera panelBilletera) {
        super();

        URL url2000 = getClass().getClassLoader().getResource("2000pesos.png");
        URL urlSeleccionado = getClass().getClassLoader().getResource("2000pesosDark.png");

        int ancho = 100;
        int alto = 100;
        ImageIcon icon2000 = new ImageIcon(new ImageIcon(url2000).getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        ImageIcon iconSeleccionado = new ImageIcon(new ImageIcon(urlSeleccionado).getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        this.setIcon(icon2000);
        this.setSelectedIcon(iconSeleccionado);
        this.panelBilletera = panelBilletera;
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Moneda moneda = new Moneda2000(contador);
        panelBilletera.setTipoMoneda(moneda);
        contador++;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}