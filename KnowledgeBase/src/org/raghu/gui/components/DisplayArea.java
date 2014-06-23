package org.raghu.gui.components;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class DisplayArea extends JPanel {
    
    JTextArea jTextArea;
    
    public DisplayArea() {
        super();
        
        Border border = AppBorders.getTitledEtchedBorder("Topic Details");
        setBorder(border);
        setLayout(new GridLayout());
        
        jTextArea = new JTextArea();
        jTextArea.setAutoscrolls(true);
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        
        jTextArea.setText("Your text goes here");
        add(jScrollPane);
    }
    
}
