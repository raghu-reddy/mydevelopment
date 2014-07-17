package org.raghu.gui.components;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.Border;
import org.raghu.gui.eventhandling.NavigationListener;
import org.raghu.services.NavigationTree;
import org.raghu.utils.application.AppObjects;

public class NavigatePanel extends JPanel {

    JScrollPane jScrollPane;
    JTree jTree;

    public NavigatePanel() {

        super();

        Border border = AppBorders.getTitledEtchedBorder("Navigation");
        setBorder(border);
        setLayout(new GridLayout());

        jTree = new NavigationTree().getTree();
        jTree.setExpandsSelectedPaths(true);
        AppObjects.registerAppObject("NavigationTree", jTree);
;
        jScrollPane = new JScrollPane(jTree);        
        add(jScrollPane);
        jTree.addTreeSelectionListener(new NavigationListener());
    }

}
