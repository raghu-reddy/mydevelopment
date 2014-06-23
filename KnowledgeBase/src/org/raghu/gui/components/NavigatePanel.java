package org.raghu.gui.components;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.Border;
import org.raghu.services.NavigationTree;

public class NavigatePanel extends JPanel {

    JScrollPane jScrollPane;
    JTree jTree;

    public NavigatePanel() {

        super();

        Border border = AppBorders.getTitledEtchedBorder("Navigation");
        setBorder(border);
        setLayout(new GridLayout());

        jTree = new NavigationTree().getTree();
        jScrollPane = new JScrollPane(jTree);        
        add(jScrollPane);
    }

}
