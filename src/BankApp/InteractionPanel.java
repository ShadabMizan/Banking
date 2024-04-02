package BankApp;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import Logic.*;

public class InteractionPanel extends ContentPanel implements ActionButtonListener, ActionListener
{
	private static final long serialVersionUID = -8965688801455558536L;
	
	private JLabel label = new JLabel();
	
	private OkButtonListener listener;
	
	private JPanel cardPanel;
    private CardLayout cardLayout = new CardLayout();
	JPanel emptyPanel = new JPanel();
	
	private String currentCard;
	
	private CircularButton ok;
	
	private JTextField[] allFields = new JTextField[6]; 

	public InteractionPanel(OkButtonListener listener)
	{
		panelSetup(); 
		titleSetup();
		
		createAccountSetup();
		viewAccountSetup();
		depositFundsSetup();
		withdrawFundsSetup();
		eTransferSetup();
		
		cardLayout.show(cardPanel, "empty"); // Empty screen initially
		this.listener = listener;
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
        cardPanel = new JPanel(cardLayout);

		emptyPanel.setBackground(getBackground());
		cardPanel.add(emptyPanel, "empty");
		
		JPanel buttonPanel = new JPanel(new GridBagLayout());
		

        
		// Create a circular Button 
		ok = new CircularButton("OK", 100);
		ok.setPreferredSize(new Dimension(100,100));
		
		// Create empty borders to add space around the button
        int horizontalPadding = (buttonPanel.getWidth() - 100) / 2;
        int verticalPadding = (buttonPanel.getHeight() - 100) / 2;
        Insets padding = new Insets(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding);
		ok.setBorder(BorderFactory.createEmptyBorder(padding.top, padding.left, padding.bottom, padding.right));
		
		ok.setBackground(primaryColour);
		ok.setFont(super.retrieveFont().deriveFont(Font.PLAIN, 24));
		ok.setForeground(Color.white);
		
		ok.addActionListener(new ActionListener() 
		{
            @Override
            public void actionPerformed(ActionEvent e) 
            {
    			switch(currentCard)
    			{
    			case "Create an Account":
    				String name = allFields[0].getText();
    				double savingsBalance = Double.parseDouble(allFields[1].getText());
    				double checkingBalance = Double.parseDouble(allFields[2].getText());
    				listener.getNewAccount(createAccount(name, checkingBalance, savingsBalance));
    				
    				
    				break;
    			case "View an Account":
    				viewAllAccounts();
    				break;
    			case "Deposit Funds":
    				
    				
    				break;
    			case "Withdraw Funds":
    				
    				
    				break;
    			case "E-Transfer":
    				
    				
    				break;
    			}
            }
		});
		
		buttonPanel.add(ok);
		
		buttonPanel.setBackground(getBackground());
		
		this.add(buttonPanel, BorderLayout.EAST);
        this.add(cardPanel, BorderLayout.CENTER);	       
	}
	
	private void titleSetup()
	{
        // Title Styles
		label.setText("Select an Action");
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(super.retrieveFont().deriveFont(Font.PLAIN, 32)); //32px Font size
        label.setForeground(Color.white);
        
        this.add(label, BorderLayout.NORTH);
	}
	
	private void createAccountSetup()
	{
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBorder(new EmptyBorder(25,0,25,0)); 
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		
        JPanel gridPanel = new JPanel(new GridLayout(3,2,8,8));
        gridPanel.setPreferredSize(new Dimension(100,300));
        
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setFont(super.retrieveFont().deriveFont(Font.PLAIN, 20));
		nameLabel.setForeground(Color.white);
		JTextField nameField = new JTextField(20);
		allFields[0] = nameField;

		JLabel savingsLabel = new JLabel("Savings Balance:");
		savingsLabel.setFont(super.retrieveFont().deriveFont(Font.PLAIN, 20));
		savingsLabel.setForeground(Color.white);
		JTextField savingsField = new JTextField(8);
		allFields[1] = savingsField;
		
		JLabel checkingLabel = new JLabel("Checking Balance:");
		checkingLabel.setFont(super.retrieveFont().deriveFont(Font.PLAIN, 20));
		checkingLabel.setForeground(Color.white);
		JTextField checkingField = new JTextField(8);
		allFields[2] = checkingField;
		
		gridPanel.setBackground(getBackground());
		gridPanel.add(nameLabel);
		gridPanel.add(nameField);
		gridPanel.add(savingsLabel);
		gridPanel.add(savingsField);
		gridPanel.add(checkingLabel);
		gridPanel.add(checkingField);
		
		panel.setBackground(getBackground());
		panel.add(gridPanel, gbc);
        cardPanel.add(panel, "Create an Account");
	}
	
	private void viewAccountSetup()
	{
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBorder(new EmptyBorder(25,0,25,0)); 
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		JLabel accountName = new JLabel("Select Accounts to View");
		accountName.setFont(super.retrieveFont().deriveFont(Font.PLAIN, 20));
		accountName.setForeground(Color.white);
		
		panel.setBackground(getBackground());
		panel.add(accountName, gbc);
        cardPanel.add(panel, "View an Account");
	}
	
	private void depositFundsSetup()
	{
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBorder(new EmptyBorder(25,0,25,0)); 
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		JPanel depositGrid = new JPanel(new GridLayout(2,1,0,8));
		JLabel depositee = new JLabel("Select a depositor");
		depositee.setFont(super.retrieveFont().deriveFont(Font.PLAIN, 20));
		depositee.setForeground(Color.white);
		
		JTextField depositAmount = new JTextField(8);
		allFields[3] = depositAmount;
		
		depositGrid.setBackground(getBackground());
		depositGrid.add(depositee);
		depositGrid.add(depositAmount);
		
		panel.setBackground(getBackground());
		panel.add(depositGrid, gbc);
        cardPanel.add(panel, "Deposit Funds");
	}
	
	private void withdrawFundsSetup()
	{
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBorder(new EmptyBorder(25,0,25,0)); 
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		JPanel withdrawGrid = new JPanel(new GridLayout(2,1,0,8));
		
		JLabel withdrawee = new JLabel("Select a withdrawer");
		withdrawee.setFont(super.retrieveFont().deriveFont(Font.PLAIN, 20));
		withdrawee.setForeground(Color.white);
		
		JTextField withdrawAmount = new JTextField(8);
		allFields[4] = withdrawAmount;
		
		withdrawGrid.setBackground(getBackground());
		withdrawGrid.add(withdrawee);
		withdrawGrid.add(withdrawAmount);
		
		panel.setBackground(getBackground());
		
		panel.add(withdrawGrid, gbc);
        cardPanel.add(panel, "Withdraw Funds");
	}
	
	private void eTransferSetup()
	{
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBorder(new EmptyBorder(25,0,25,0)); 
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		JPanel transferGrid = new JPanel(new GridLayout(3,1, 0, 16));
		
		JPanel senderGrid = new JPanel(new GridLayout(1,3,16,0));
		
		JLabel sender = new JLabel("Select a sender");
		sender.setFont(super.retrieveFont().deriveFont(Font.PLAIN, 20));
		sender.setForeground(Color.white);
		
		JTextField sendingAmount = new JTextField(8);
		allFields[5] = sendingAmount;

		senderGrid.setBackground(getBackground());
		senderGrid.add(sender);
		senderGrid.add(sendingAmount);
		
		ImageIcon arrow = new ImageIcon("Assets/arrow-down.png");

		JPanel receiverPanel = new JPanel(new GridBagLayout());
		
		JLabel receiver = new JLabel("Select a recevier");
		receiver.setFont(super.retrieveFont().deriveFont(Font.PLAIN, 20));
		receiver.setForeground(Color.white);
		
		receiverPanel.add(receiver);
		receiverPanel.setBackground(getBackground());
		
		transferGrid.setBackground(getBackground());
		transferGrid.add(senderGrid);
		transferGrid.add(new JLabel(arrow));
		transferGrid.add(receiverPanel);
		
		panel.add(transferGrid, gbc);
		panel.setBackground(getBackground());
		
        cardPanel.add(panel, "E-Transfer");
	}
	
	@Override
	public void actionButtonClicked() 
	{	
		// Execute the code in the form of a Runnable object, later when it should in the Event Dispatch Thread. Allows for proper synchronyzations.
	    SwingUtilities.invokeLater(() -> {
	    	// Set text to the name of the action starting after the numbered list.
	    	String action = super.getSelectedAction().getText().substring(3);
	        label.setText(action);
	        cardLayout.show(cardPanel, action);
	        currentCard = action;
	        
	        clearTextFields();
	    });
	}

	private void clearTextFields()
	{
		for (JTextField field : allFields)
		{
			field.setText(null);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		clearTextFields();
	}
	
	private ClientAccount createAccount(String name, double checkingBalance, double savingsBalance)
	{
		return new ClientAccount(new SavingsAccount(name, savingsBalance), new CheckingAccount(name, checkingBalance));
	}
	
	private void viewAllAccounts()
	{
		for (ClientAccount client : ClientAccount.getAllClientAccounts())
		{
			System.out.println(client.print());
		}
	}
}
