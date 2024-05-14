package PresentationLayer;

import java.awt.Color;
import javax.swing.*;
import javax.swing.text.*;

public class Highlighter {

 public static void changeColor(int startIndex, int endIndex, JTextPane textPane) {
        StyledDocument doc = textPane.getStyledDocument();
        Style style = textPane.addStyle("ColorStyle", null);
        StyleConstants.setForeground(style, Color.YELLOW);

        doc.setCharacterAttributes(startIndex, endIndex - startIndex, style, false);
    }
 
 public static int findStringStartIndex(String target, JTextPane textPane) {
        String text = textPane.getText();
        return text.indexOf(target);
    }

}

