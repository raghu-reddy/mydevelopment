package org.raghu.gui.eventhandling;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import org.raghu.services.AppConfig;
import org.raghu.utils.application.AppObjects;

public class SearchChangeListener implements DocumentListener {

    @Override
    public void insertUpdate(DocumentEvent de) {
        highlightResults(de);
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        highlightResults(de);
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        highlightResults(de);
    }
    
    private void highlightResults(DocumentEvent de) {
        try {
            String searchStr = de.getDocument().getText(0, de.getDocument().getLength());
            ArrayList<String> results = AppConfig.getAppConfig().getSearchTree().searchTree(searchStr);
            
            ((JTextArea) AppObjects.getAppObject("DisplayArea")).setText(results.toString());
            JList jList = (JList) AppObjects.getAppObject("ResultsPanel.searchResults");
            
            DefaultListModel jListModel = (DefaultListModel) jList.getModel();
            jListModel.removeAllElements();
            for (String current: results) {
                jListModel.addElement(current);
            }
            
            jList.setSelectedIndex(0);
            
        } catch (BadLocationException ex) {
            Logger.getLogger(SearchChangeListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
