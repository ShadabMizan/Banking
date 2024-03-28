package BankApp;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class ContentPanel extends JPanel
{
	private static final long serialVersionUID = -8988141427436451461L;
	private final Font font = loadFont("Assets/Roboto-Regular.ttf");
	protected final Color primaryColour = new Color(0x612AFD);
	
	protected static JToggleButton selectedAction = new JToggleButton("Select an Action");
	
    private static Font loadFont(String fontFileName) 
    {
        Font font;    
        try {
            File fontFile = new File(fontFileName);
            font = Font.createFont(Font.TRUETYPE_FONT, fontFile); // Convert ttf to a Font object
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            font = new JLabel().getFont(); // If the font loading fails, fallback to default font
        }
        return font;
    }
    
    protected Font retrieveFont() { return this.font; }
    
    protected static JToggleButton getSelectedAction() { return selectedAction; }
}
