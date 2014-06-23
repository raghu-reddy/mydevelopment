package org.raghu.gui.components;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class AppMenuBar extends JMenuBar {
    
    JMenu admin;
    JMenuItem adminAddAdminUser;
    
    public AppMenuBar() {
        super();
        admin = new JMenu("Admin");
        adminAddAdminUser = new JMenuItem("Add User");
        admin.add(adminAddAdminUser);
        add(admin);
        
    }
    
}
