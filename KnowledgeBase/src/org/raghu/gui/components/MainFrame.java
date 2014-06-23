package org.raghu.gui.components;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
        
        AppMenuBar appMenuBar;
        JPanel searchFrame;
        JPanel addFrame;
	
	public MainFrame() {
		super("Knowledge Base");
                setExtendedState(JFrame.MAXIMIZED_BOTH);
                appMenuBar = new AppMenuBar();
                add(appMenuBar, BorderLayout.NORTH);
                searchFrame = new JPanel();
                AddComponents.addAll(searchFrame);
                add(searchFrame, BorderLayout.CENTER);
	}

}
