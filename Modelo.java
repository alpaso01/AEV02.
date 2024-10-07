package com.dam.alex;
import java.io.*;
import java.util.*;

public class Modelo {
    private String texto;

    public void cargarTextoDesdeArchivo(String rutaArchivo) throws IOException {
        BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo));
        StringBuilder sb = new StringBuilder();
        String linea;
        while ((linea = lector.readLine()) != null) {
            sb.append(linea).append("\n");
        }
        texto = sb.toString();
        lector.close();
    }

    public int buscarPalabra(String palabra) {
        int contador = 0;
        String[] palabras = texto.split("\\W+");
        for (String p : palabras) {
            if (p.equalsIgnoreCase(palabra)) {
                contador++;
            }
        }
        return contador;
    }

    public String reemplazarPalabra(String palabraVieja, String palabraNueva) {
        return texto.replaceAll("\\b" + palabraVieja + "\\b", palabraNueva);
    }

    public void guardarTextoEnArchivo(String rutaArchivo, String nuevoTexto) throws IOException {
        BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaArchivo));
        escritor.write(nuevoTexto);
        escritor.close();
    }

    public String obtenerTexto() {
        return texto;
    }

	public void leerTexto(String string) {
		// TODO Auto-generated method stub
		
	}

	public String getTexto() {
		// TODO Auto-generated method stub
		return null;
	}
}

