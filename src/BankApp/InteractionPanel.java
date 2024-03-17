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

public class InteractionPanel extends ContentPanel implements ActionListener
{
	private static final long serialVersionUID = -8965688801455558536L;
	
	private JLabel interactionTitle = new JLabel();
	private JToggleButton selectedOption = new JToggleButton();

	InteractionPanel()
	{
		panelSetup();
        titleSetup("Select an Option");
	}
	
	InteractionPanel(JToggleButton selectedOption)
	{
		this.selectedOption = selectedOption;
		panelSetup();
		titleSetup(selectedOption.getText());
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
	
	private void titleSetup(String title)
	{
        // Title Styles
		interactionTitle.setText(title);
        interactionTitle.setVerticalAlignment(JLabel.TOP);
        interactionTitle.setHorizontalAlignment(JLabel.CENTER);
        interactionTitle.setFont(super.retrieveFont().deriveFont(Font.PLAIN, 32)); //32px Font size
        interactionTitle.setForeground(Color.white);
        
        this.add(interactionTitle, BorderLayout.NORTH);
	}


	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() instanceof JToggleButton)
		{
			this.selectedOption = (JToggleButton) e.getSource();
			
			System.out.println(this.selectedOption.getText());
			this.interactionTitle.setText(this.selectedOption.getText());
		}
	}
}
