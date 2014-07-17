package org.raghu.gui.eventhandling;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import org.raghu.utils.application.AppObjects;

public class ButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == (JButton) AppObjects.getAppObject("SearchPanel.clearButton")) {
            ((JTextField) AppObjects.getAppObject("SearchPanel.searchText")).setText("");
        }
    }
    
}
