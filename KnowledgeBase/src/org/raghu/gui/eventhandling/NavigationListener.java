package org.raghu.gui.eventhandling;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import org.raghu.services.AppConfig;
import org.raghu.services.NavigationNode;
import org.raghu.utils.application.AppObjects;
import org.raghu.utils.reader.All;
import org.raghu.utils.reader.ErrorReadingSourceException;
import org.raghu.utils.reader.InputFileReader;
import org.raghu.utils.reader.InputReader;
import org.raghu.utils.reader.Reader;
import org.raghu.utils.reader.ReaderConstants;

public class NavigationListener implements TreeSelectionListener {

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = 
                (DefaultMutableTreeNode) ((JTree) e.getSource()).getLastSelectedPathComponent();
        
        NavigationNode navigationNode = (NavigationNode) node.getUserObject();
        InputReader reader = null;
        String fileLocation = AppConfig.getAppConfig().getContentsSrcName();
        StringBuilder strBldr = new StringBuilder(
                fileLocation.substring(0, fileLocation.lastIndexOf("\\")+1));
        strBldr.append("datafiles\\\\");
        String filePath = strBldr+navigationNode.getContentLocation();
        System.out.println("Opening : "+filePath);
        
        try {
            reader = new InputFileReader(filePath);
        } catch (ErrorReadingSourceException ex) {
            ex.printStackTrace();
            System.exit(0);
        }
        
        String text = 
                ((All) Reader.readNext(reader, ReaderConstants.ALL)).toString();
        
        ((JTextArea) AppObjects.getAppObject("DisplayArea")).setText(text);
    }

}
