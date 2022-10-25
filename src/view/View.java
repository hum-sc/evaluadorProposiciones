package view;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Operation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class View extends JFrame implements ActionListener{
    private ButtonsPanel bottomButtonsPanel;

    public boolean isPushed;

    private JLabel header;
    private JButton close;
    
    private CompletableFuture<String> futureOption;
    private String options [];

    public View(String title, String headerText){
        super(title);
        
        this.header = new JLabel(headerText);
        this.close = new JButton("Close");

        
        this.close.setActionCommand("10");
        this.close.addActionListener(this);
        
        this.bottomButtonsPanel = new ButtonsPanel(new JButton[]{close}, false);

        this.getContentPane().add(this.header, BorderLayout.NORTH);
        this.getContentPane().add(close, BorderLayout.SOUTH);

        this.setDefaultCloseOperation( EXIT_ON_CLOSE );
        this.setVisible(true);
        
        this.isPushed=false;
    }
    

    public void showTable(String header, Map<String, boolean[]> data, String title){

        String[] columnNames = new String[data.size()];

        String[][] rowData = new String[8][data.size()];

        int i = 0;
        
        for(String key : data.keySet()){

            columnNames[i] = key;
            boolean[] tmpValues = data.get(key);
            
            for(int j = 0; j < tmpValues.length; j++){
                rowData[j][i] = tmpValues[j] ? "1" : "0";
            }

            i++;
        }

        JTable table = new JTable(rowData, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        
        scrollPane.setPreferredSize(new Dimension(450,150));

        table.setFillsViewportHeight(true);

        this.deleteCenterComponent();

        this.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        this.setTitle(title);
        this.header.setText(header);

        this.pack();

    }

    public void setOptions(String[] options){
        this.options = options;
    }

    public void showInputOptions(String instruction, int requiredOptions []){

        JButton[] buttons = new JButton[requiredOptions.length];

        

        this.header.setText(instruction);
        
        for(int i = 0; i < requiredOptions.length; i++){

            buttons[i] = new JButton(options[requiredOptions[i]]);
            buttons[i].setActionCommand(requiredOptions[i]+"");

        }
    
        bottomButtonsPanel = new ButtonsPanel(buttons, true);
        bottomButtonsPanel.addActionListener(this);
    
        this.deleteCenterComponent();

        this.getContentPane().add(bottomButtonsPanel, BorderLayout.CENTER);
        
        this.pack();
    
    }

    public void showBTree (String header, Operation head, Map<String, String> resultados){
        this.header.setText(header);
        PanelResultados panelResultados = new PanelResultados(head, resultados);
        this.deleteCenterComponent();
        this.getContentPane().add(panelResultados, BorderLayout.CENTER);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public int getOption() throws InterruptedException, ExecutionException{
        
        futureOption = new CompletableFuture<String>();
        
        int option = Integer.parseInt(futureOption.get());
        
        return option;
    }

    private void deleteCenterComponent(){
        try{

            BorderLayout tmpLayout = (BorderLayout) this.getContentPane().getLayout();
            remove(tmpLayout.getLayoutComponent(BorderLayout.CENTER));
            
        } catch (Exception e){}
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
