package org.raghu.gui.components;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import org.raghu.gui.eventhandling.ButtonListener;
import org.raghu.gui.eventhandling.SearchChangeListener;
import org.raghu.utils.application.AppObjects;

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
        
        AppObjects.registerAppObject("SearchPanel.searchText", searchText);
        AppObjects.registerAppObject("SearchPanel.clearButton", clearButton);

        searchText.getDocument().addDocumentListener(new SearchChangeListener());
        clearButton.addActionListener(new ButtonListener());
        
    }
    
}
