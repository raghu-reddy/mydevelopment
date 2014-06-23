package org.raghu.gui.components;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class AppBorders {
    
    public static Border getTitledEtchedBorder(String title) {
        
        Border border = BorderFactory.createEtchedBorder();
        TitledBorder tBorder = new TitledBorder(border);
        tBorder.setTitle(title);
        tBorder.setTitleColor(Color.GRAY);
        tBorder.setTitleFont(new Font("Arial", Font.ITALIC, 12));
        return tBorder;
    }
    
}
