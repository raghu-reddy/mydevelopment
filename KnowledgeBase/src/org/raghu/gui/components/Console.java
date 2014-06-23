package org.raghu.gui.components;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Console {

    public static void run(final JFrame jf) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //AddComponents.addAll(jf.getContentPane());
                jf.pack();
                jf.setVisible(true);
            }

        });
    }

}
