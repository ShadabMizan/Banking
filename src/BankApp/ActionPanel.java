package BankApp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class ActionPanel extends ContentPanel
{
	private static final long serialVersionUID = -7808300546898795531L;

	ActionPanel()
	{
		// Panel Styles
        this.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16)); // Add 16 pixels of padding around the panel
        this.setLayout(new BorderLayout(24,24)); // Add 24 pixels of inner paddings
        this.setBackground(new Color(0xF0F0F2));
        
        // Action Panel will have a set width of 264px. 
        // 800px becomes meaningless as ActionPanel will be bounded WEST
        this.setPreferredSize(new Dimension(264, 800)); 
        
        // Title Styles
        JLabel actionTitle = new JLabel("Actions");
        actionTitle.setVerticalAlignment(JLabel.TOP);
        actionTitle.setHorizontalAlignment(JLabel.CENTER);
        actionTitle.setFont(super.retrieveFont().deriveFont(Font.PLAIN, 32)); //32px Font size
        
        // Add Components to Panel
        this.add(actionTitle);
	}
}
