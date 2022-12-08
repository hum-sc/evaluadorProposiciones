package view;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

public class ButtonsPanel extends JPanel {
        private JButton[] buttons;
        public ButtonsPanel(JButton [] buttons, boolean isVertical){
            super();
            GridLayout layout =  isVertical ? new GridLayout(buttons.length/2, 2) : new GridLayout(1,buttons.length);
            setLayout(layout);
            this.buttons = buttons;
            for(JButton button : buttons){
                add(button);
            }
        }

        public void updateButtoms(JButton [] buttons){
            removeAll();
            for(JButton button : buttons){
                add(button);
            }
        }

        public void addActionListener(ActionListener listener){
            for(JButton button : this.buttons){
                button.addActionListener(listener);
            }
        }
    
}
