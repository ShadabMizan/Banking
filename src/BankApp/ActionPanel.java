package BankApp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class ActionPanel extends ContentPanel implements ActionListener
{
	private static final long serialVersionUID = -7808300546898795531L;
	
    private ArrayList<JToggleButton> optionButtons = new ArrayList<JToggleButton>();
    private ButtonGroup optionGroup = new ButtonGroup();
    
    private int numOfOptions = 5;
    
    private ActionButtonListener listener;
    
	public ActionPanel(ActionButtonListener listener)
	{       
		panelSetup();
		titleSetup();
		optionSetup(listener);
	}
	
	private void titleSetup()
	{
        // Title Styles
        JLabel actionTitle = new JLabel("Actions");
        actionTitle.setVerticalAlignment(JLabel.TOP);
        actionTitle.setHorizontalAlignment(JLabel.CENTER);
        actionTitle.setFont(super.retrieveFont().deriveFont(Font.PLAIN, 32)); //32px Font size
        
        this.add(actionTitle);
	}
	
	private void panelSetup()
	{
		// Panel Styles
        this.setBorder(BorderFactory.createEmptyBorder(16, 0, 16, 0)); // Add 16 pixels of padding above and below the panel
        
        this.setLayout(new GridLayout(numOfOptions + 1,1, 16, 0)); // Plus 1 for the title's spot in the column. 16px of vertical padding
        this.setBackground(new Color(0xF0F0F2));
        
        // Action Panel will have a set width of 264px. 
        // 800px becomes meaningless as ActionPanel will be bounded WEST
        this.setPreferredSize(new Dimension(264, 800)); 
	}
	
	private void optionSetup(ActionButtonListener listener)
	{
		this.listener = listener;
		
		
        for (int i = 0; i < 5; i++)
        {
        	JPanel optionPanel = new JPanel(new BorderLayout());
        	JToggleButton option = new JToggleButton();
        	String optionText = "";
        	switch(i)
        	{
        	case 0:
        		optionText = "1. Create an Account";
        		break;
        	case 1:
        		optionText = "2. View an Account";
        		break;
        	case 2:
        		optionText = "3. Deposit Funds";
        		break;
        	case 3:
        		optionText = "4. Withdraw Funds";
        		break;
        	case 4:
        		optionText = "5. E-Transfer";
        		break;
        	}
        	
        	// Styles for every option
        	option.setText(optionText);
        	option.setFont(super.retrieveFont().deriveFont(Font.PLAIN, 16)); // 16px font size
        	option.setFocusable(false);
        	option.setBorderPainted(false);
        	option.setBackground(getBackground());
        	
        	// ActionPanel listens to button presses to affect UI 
        	option.addActionListener(this);
        	option.addActionListener(new ActionListener() 
        	{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					if (listener != null)
					{
						listener.buttonClicked();
					}
				}
        	});
 
        	// Add the option to its button group and its ArrayList
            optionButtons.add(option);
        	optionGroup.add(option);
        	
        	// Add the panels to the ActionPanel
           	optionPanel.add(option, BorderLayout.CENTER);
        	this.add(optionPanel);
        }
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() instanceof JToggleButton)
		{
			updateSelectedOption(e);
//			System.out.println(super.getSelectedAction().getText());
		}
	}
	
	private void updateSelectedOption(ActionEvent e)
	{		
		for (JToggleButton button : optionButtons)
		{
			if (button.getSelectedObjects() == null)
			{
				button.setBackground(null);
				button.setBackground(getBackground()); // Reset to the parent's background colour
				button.setForeground(Color.black);
				
			}
		}
		
		JToggleButton selectedOption = new JToggleButton();
		selectedOption = (JToggleButton) e.getSource();
    	selectedOption.setContentAreaFilled(false);
    	selectedOption.setOpaque(true);
		selectedOption.setBackground(super.primaryColour);
		selectedOption.setForeground(Color.white);
		
		ContentPanel.selectedAction = selectedOption;
	}
}
