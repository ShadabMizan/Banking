package BankApp;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ContentPanel extends JPanel
{
	private static final long serialVersionUID = -8988141427436451461L;
	
	private Font font = loadFont("Assets/Roboto-Regular.ttf");
	
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
}
