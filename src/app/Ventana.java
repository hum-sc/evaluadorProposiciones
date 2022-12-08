package app;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Ventana extends JFrame {
    private JButton proposicionesButton;
    private JButton arbolOperaciones;
    private JButton torresHanoi;
    public Ventana(ActionListener listener) {
        super("Menu");
        this.setLayout(null);
        this.proposicionesButton = new JButton("Evaluar proposiciones");
        this.arbolOperaciones = new JButton("Generar recorridos de operaciones");
        this.torresHanoi = new JButton("Torres de Hanoi");

        this.proposicionesButton.setActionCommand("proposiciones");
        this.arbolOperaciones.setActionCommand("arbolOperaciones");
        this.torresHanoi.setActionCommand("torresHanoi");

        this.proposicionesButton.addActionListener(listener);
        this.arbolOperaciones.addActionListener(listener);
        this.torresHanoi.addActionListener(listener);

        this.setSize(500, 500);
        this.setBackground(Color.GRAY);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationByPlatform(true);
        
        proposicionesButton.setBounds(100, 100, 300, 30);
        arbolOperaciones.setBounds(100, 200, 300, 30);
        torresHanoi.setBounds(100, 300, 300, 30);

        this.getContentPane().add(proposicionesButton);
        this.getContentPane().add(arbolOperaciones);
        this.getContentPane().add(torresHanoi);

        this.setVisible(true);
    }

}
