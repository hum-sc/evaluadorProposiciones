package torresHanoi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener {
    private JTextField numeroDiscos;
    private JTextField torreInicial;
    private JTextField torreFinal;
    private JButton calcular;
    private JTextArea resultado;
    private JLabel numeroDiscosLabel;
    private JLabel torreInicialLabel;
    private JLabel torreFinalLabel;

    private JScrollPane resultadoPane;
    public Ventana() {
        super("Torres de Hanoi");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationByPlatform(true);

        numeroDiscos = new JTextField();
        torreInicial = new JTextField();
        torreFinal = new JTextField();
        calcular = new JButton("Calcular");
        resultado = new JTextArea("");
        numeroDiscosLabel = new JLabel("Numero de discos");
        torreInicialLabel = new JLabel("Torre inicial");
        torreFinalLabel = new JLabel("Torre final");

        resultado.setEnabled(false);
        resultado.setSize(23,40);
        resultado.setLineWrap(true);
        resultado.setForeground(Color.BLACK);

        resultadoPane = new JScrollPane(resultado);
        resultadoPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        resultadoPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        resultadoPane.setBorder(BorderFactory.createLineBorder(Color.black));

        resultadoPane.setLocation(10,20);

        numeroDiscosLabel.setBounds(260, 20, 230, 30);
        numeroDiscos.setBounds(260, 50, 230, 30);
        torreInicialLabel.setBounds(260, 80, 230, 30);
        torreInicial.setBounds(260, 110, 230, 30);
        torreFinalLabel.setBounds(260, 140, 230, 30);
        torreFinal.setBounds(260, 170, 230, 30);
        calcular.setBounds(260, 200, 230, 30);

        calcular.addActionListener(this);

        this.getContentPane().add(numeroDiscosLabel);
        this.getContentPane().add(numeroDiscos);
        this.getContentPane().add(torreInicialLabel);
        this.getContentPane().add(torreInicial);
        this.getContentPane().add(torreFinalLabel);
        this.getContentPane().add(torreFinal);
        this.getContentPane().add(calcular);
        this.getContentPane().add(resultadoPane);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calcular) {
            ControlTorres cT = new ControlTorres();
            int n, o, f, a;
            n = Integer.parseInt(numeroDiscos.getText());
            o = Integer.parseInt(torreInicial.getText());
            f = Integer.parseInt(torreFinal.getText());
            a = Math.abs(f-o);
            resultado.setText(cT.hanoi(n,o,a,f));
        }
    }
}
