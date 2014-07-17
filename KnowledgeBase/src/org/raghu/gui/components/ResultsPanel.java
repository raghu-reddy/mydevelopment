package org.raghu.gui.components;

import java.awt.GridLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import org.raghu.gui.eventhandling.ResultsSelectionListener;
import org.raghu.utils.application.AppObjects;

public class ResultsPanel extends JPanel {
    
    private static final long serialVersionUID = 1L;
    JList searchResults;
    
    public ResultsPanel() {
        super();
        Border border = AppBorders.getTitledEtchedBorder("Select your result");
        setBorder(border);
        setLayout(new GridLayout());
        
        DefaultListModel listModel = new DefaultListModel();
        searchResults = new JList(listModel);
        searchResults.setVisibleRowCount(3);
        JScrollPane jScrollPane = new JScrollPane(searchResults);
        add(jScrollPane);
        
        AppObjects.registerAppObject("ResultsPanel.searchResults", searchResults);
        searchResults.addListSelectionListener(new ResultsSelectionListener());
        
    }
    
}