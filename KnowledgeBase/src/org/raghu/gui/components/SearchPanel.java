package org.raghu.gui.components;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class SearchPanel extends JPanel {
    
    private static final long serialVersionUID = 1L;
    JTextField searchText;
    JButton clearButton;
    
    public SearchPanel() {
        super();
        Border border = AppBorders.getTitledEtchedBorder("Type your search here");
        setBorder(border);
        
        searchText = new JTextField(25);
        add(searchText);
        clearButton = new JButton("Clear");
        add(clearButton);
        
    }
    
}
