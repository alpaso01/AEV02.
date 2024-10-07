package com.dam.alex;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Controlador {
    private Modelo modelo;
    private Vista vista;

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
        initController();
    }

    private void initController() {
        vista.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPalabra();
            }
        });

        vista.getBtnReemplazar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reemplazarPalabra();
            }
        });
    }

    public void iniciar() {
        modelo.leerTexto("C:\\\\Users\\\\alex\\\\Downloads\\\\AE_02_T1_2_Streams_Material.zip\\\\AE_02_T1_2_Streams_Material\\\\AE02_T1_2_Streams_Groucho.txt");
        vista.getTextAreaOriginal().setText(modelo.getTexto());
        vista.getTextAreaModificado().setText(modelo.getTexto());
        vista.setVisible(true);
    }

    private void buscarPalabra() {
        String palabra = vista.getTextFieldBuscar().getText();
        int count = modelo.buscarPalabra(palabra);
        JOptionPane.showMessageDialog(vista.getFrame(), "La palabra '" + palabra + "' aparece " + count + " veces.");
    }

    private void reemplazarPalabra() {
        String palabraVieja = vista.getTextFieldBuscar().getText();
        String palabraNueva = vista.getTextFieldReemplazar().getText();
        String nuevoTexto = modelo.reemplazarPalabra(palabraVieja, palabraNueva);
        vista.getTextAreaModificado().setText(nuevoTexto);
        modelo.leerTexto("C:\\Users\\alex\\Downloads\\AE_02_T1_2_Streams_Material.zip\\AE_02_T1_2_Streams_Material\\AE02_T1_2_Streams_Groucho.txt");
    }
}
