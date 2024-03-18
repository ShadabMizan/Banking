package BankApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

public class InteractionPanel extends ContentPanel implements ActionButtonListener
{
	private static final long serialVersionUID = -8965688801455558536L;
	
	private JLabel label = new JLabel();

	InteractionPanel()
	{
		panelSetup(); 
		titleSetup();
	}
	
	private void panelSetup()
	{
		// Panel Styles
		int panelPadding = 8;
        this.setBorder(BorderFactory.createEmptyBorder(panelPadding, panelPadding, panelPadding, panelPadding)); // Add 16 pixels of padding around the panel
        this.setLayout(new BorderLayout(8,8)); // Add 8 pixels of inner paddings
        this.setBackground(new Color(0x222026));
        
        // Interaction Panel will have 1440px width and 200px height. 
        // Height will not scale, since Bounded SOUTH
        this.setPreferredSize(new Dimension(1440, 200)); 
	}
	
	private void titleSetup()
	{
        // Title Styles
		this.label.setText("Select an Action");
        this.label.setVerticalAlignment(JLabel.TOP);
        this.label.setHorizontalAlignment(JLabel.CENTER);
        this.label.setFont(super.retrieveFont().deriveFont(Font.PLAIN, 32)); //32px Font size
        this.label.setForeground(Color.white);
        
        this.add(this.label, BorderLayout.NORTH);
	}

	@Override
	public void buttonClicked() 
	{	
		// Execute the code in the form of a Runnable object, later when it should in the Event Dispatch Thread. Allows for proper synchronyzations.
	    SwingUtilities.invokeLater(() -> {
	    	// Set text to the name of the action starting after the numbered list. 
	        this.label.setText(super.getSelectedAction().getText().substring(2)); 
	    });
	}

	

}
