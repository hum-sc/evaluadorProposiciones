package view;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Closure;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class View extends JFrame implements ActionListener{
    private ButtonsPanel bottomButtonsPanel;

    public boolean isPushed;

    private JLabel header, mostrar;
    private JButton close;
    private CompletableFuture<String> futureOption;
    
    public View(String title, String headerText){
        super(title);
        
        this.header = new JLabel(headerText);

        this.setDefaultCloseOperation( EXIT_ON_CLOSE );
        this.close = new JButton("Close");
        this.close.setActionCommand("10");
        bottomButtonsPanel = new ButtonsPanel(new JButton[]{close}, false);
        
        this.close.addActionListener(this);

        this.getContentPane().add(this.header, BorderLayout.NORTH);
        this.getContentPane().add(close, BorderLayout.SOUTH);
    
        isPushed=false;
    }
    

    public void showOrden(String header, String head,String title){
    	
    	JPanel Resultado = new JPanel();
    	Resultado.setPreferredSize(new Dimension(450,150));
    	this.mostrar = new JLabel(head);
    	Resultado.add(mostrar);
    	try{
            BorderLayout tmpLayout = (BorderLayout) this.getContentPane().getLayout();
            remove(tmpLayout.getLayoutComponent(BorderLayout.CENTER));
        } catch (Exception e){
        }

        this.getContentPane().add(Resultado, BorderLayout.CENTER);
        
        this.setTitle(title);
        this.header.setText(header);
        
        this.pack();
    }
    
    public void showMessage(String message){
        JOptionPane.showMessageDialog(null,message);
    }

    public void showInputOptions(String instruction, int requiredOptions []){
        JButton[] buttons = new JButton[requiredOptions.length];

        String options [] = {"A","B","C","D","*","/","+","-","^","(",")"};

        this.header.setText(instruction);
        
        for(int i = 0; i < requiredOptions.length; i++){
            buttons[i] = new JButton(options[requiredOptions[i]]);
            buttons[i].setActionCommand(requiredOptions[i]+"");
        }

        bottomButtonsPanel = new ButtonsPanel(buttons, true);
        bottomButtonsPanel.addActionListener(this);
        try{
            BorderLayout tmpLayout = (BorderLayout) this.getContentPane().getLayout();
            remove(tmpLayout.getLayoutComponent(BorderLayout.CENTER));
        } catch (Exception e){
        }

        this.getContentPane().add(bottomButtonsPanel, BorderLayout.CENTER);
        this.pack();
    
    }

    public int getOption() throws InterruptedException, ExecutionException{
        futureOption = new CompletableFuture<String>();
        int option = Integer.parseInt(futureOption.get());
        return option;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        futureOption.complete(e.getActionCommand());
        isPushed = true;
        if(e.getSource() == this.close){
            System.exit(0);
        }
    }
}
