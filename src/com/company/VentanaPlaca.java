package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class VentanaPlaca extends JFrame {
    private JLabel etiqueta1, etiqueta2;
    private JTextField campo;
    private JButton verificar;
    private JDialog verificarPlaca;

    public VentanaPlaca() {
        super("Circulacion de vehiculo");
        etiqueta1 = new JLabel("Numero de placa");
        campo = new JTextField(10);
        verificar = new JButton("Verificar");
        verificarPlaca = new JDialog(this);
        verificarPlaca.setSize(500, 200);
        etiqueta2 = new JLabel("");
        FlowLayout F = new FlowLayout();
        setLayout(F);
        add(etiqueta1);
        add(campo);
        add(verificar);
        verificarPlaca.add(etiqueta2);
        verificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                verificarPlaca();
            }
        });
    }

    public int getParteNumerica(String placa) {
        int res = 0;

        for (int i = 0; i < placa.length(); i++) {
            char c = placa.charAt(i);
            if (c >= '0' && c <= '9') {
                res = res * 10 + Character.getNumericValue(c);
            }
        }
        return res % 10;
    }

    public void verificarPlaca() {
        if (permitido())
            etiqueta2.setText("Placa permitida para circular");
        else
            etiqueta2.setText("Placa no permitida para circular");
        verificarPlaca.setVisible(true);
    }

    public boolean permitido() {
        boolean resul = true;
        String placa = campo.getText();
        int numero = getParteNumerica(placa);

        if (numero == 0 || numero == 1) {
            if (Calendar.DAY_OF_WEEK == 0) {
                resul = false;
            }

        }
        if (numero == 2 || numero == 3) {
            if (Calendar.DAY_OF_WEEK == 1) {
                resul = false;
            }

        }
        if (numero == 4 || numero == 5) {
            if (Calendar.DAY_OF_WEEK == 2) {
                resul = false;
            }

        }
        if (numero == 6 || numero == 7) {
            if (Calendar.DAY_OF_WEEK == 3) {
                resul = false;
            }

        }
        if (numero == 8 || numero == 9) {
            if (Calendar.DAY_OF_WEEK == 4) {
                resul = false;
            }

        }
        return resul;
    }
}

