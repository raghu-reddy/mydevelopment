package org.raghu.gui.eventhandling;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

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
            System.out.println(de.getDocument().getText(0, de.getDocument().getLength()));
        } catch (BadLocationException ex) {
            Logger.getLogger(SearchChangeListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
