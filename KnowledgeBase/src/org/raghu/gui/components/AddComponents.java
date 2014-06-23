package org.raghu.gui.components;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import org.raghu.gui.eventhandling.SearchChangeListener;

public class AddComponents {

    public static void addAll(Container container) {

        GridBagConstraints gbc = new GridBagConstraints();
        
        container.setLayout(new GridBagLayout());
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        SearchPanel searchPanel = new SearchPanel();
        container.add(searchPanel, gbc);
        searchPanel.searchText.getDocument().addDocumentListener(new SearchChangeListener());
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        NavigatePanel navigatePanel = new NavigatePanel();
        container.add(navigatePanel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 6;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        DisplayArea displayArea = new DisplayArea();
        container.add(displayArea, gbc);
        
        
    }

}
