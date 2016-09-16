import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.border.Border;

public class HomeStylePizza extends JFrame implements ActionListener
{

    private static final Insets bottomInsets = new Insets(10, 10, 10, 10);
    private static final Insets normalInsets = new Insets(10, 10, 0, 10);
    
    //create new decimal format object
  	DecimalFormat df = new DecimalFormat("#.00");

    // GUI components
    private JCheckBox cbTomato, cbGreenPepper, cbBlackOlives, cbMushrooms, cbExtraCheese,
            cbPepperoni, cbSausage;

    private JRadioButton rbSmall, rbMedium, rbLarge, rbThinCrust,
            rbMediumCrust, rbPan;

    private JTextArea textArea;

    public static void main(String[] args) {
    	HomeStylePizza hsp = new HomeStylePizza();
    } // End of main

    public HomeStylePizza()
    {
        JFrame frame = new JFrame("Pizza Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        int gridy = 0;

        addComponent(mainPanel, createTitlePanel(), 0, gridy++, 2, 1,
                normalInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        addComponent(mainPanel, createToppingPanel(), 0, gridy, 1, 1,
                normalInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new BorderLayout());
        eastPanel.add(createSizePanel(), BorderLayout.WEST);
        eastPanel.add(new JLabel(" "), BorderLayout.CENTER);
        eastPanel.add(createTypePanel(), BorderLayout.EAST);
        eastPanel.add(createButtonPanel(), BorderLayout.SOUTH);

        addComponent(mainPanel, eastPanel, 1, gridy++, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        addComponent(mainPanel, createTextAreaPanel(), 0, gridy++, 2, 1,
                bottomInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel createTitlePanel() {
        JPanel panel = new JPanel();

        JLabel lblWelcome = new JLabel("Welcome to Home Style Pizza Shop");
        Font titleFont = lblWelcome.getFont().deriveFont(20F);
        lblWelcome.setFont(titleFont);
        lblWelcome.setForeground(Color.RED);

        panel.add(lblWelcome);

        return panel;
    }

    private JPanel createToppingPanel() {
        Border redBorder = BorderFactory.createLineBorder(Color.RED, 2);
        Border emptyBorder = BorderFactory.createEmptyBorder(4, 10, 4, 10);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createCompoundBorder(redBorder,
                emptyBorder));
        panel.setLayout(new GridLayout(0, 1));

        JLabel ToppingLabel = new JLabel("Each Topping: $1.50");
        ToppingLabel.setForeground(Color.RED);
        panel.add(ToppingLabel);

        cbTomato = new JCheckBox("Tomato");
        cbTomato.addActionListener(this);
        cbGreenPepper = new JCheckBox("Green Pepper");
        cbGreenPepper.addActionListener(this);
        cbBlackOlives = new JCheckBox("Black Olives");
        cbBlackOlives.addActionListener(this);
        cbMushrooms = new JCheckBox("Mushrooms");
        cbMushrooms.addActionListener(this);
        cbExtraCheese = new JCheckBox("Extra Cheese");
        cbExtraCheese.addActionListener(this);
        cbPepperoni = new JCheckBox("Pepperoni");
        cbPepperoni.addActionListener(this);
        cbSausage = new JCheckBox("Sausage");
        cbSausage.addActionListener(this);

        // add components to optionBox1
        panel.add(cbTomato);
        panel.add(cbGreenPepper);
        panel.add(cbBlackOlives);
        panel.add(cbMushrooms);
        panel.add(cbExtraCheese);
        panel.add(cbPepperoni);
        panel.add(cbSausage);

        return panel;
    }

    private JPanel createSizePanel() {
        Border redBorder = BorderFactory.createLineBorder(Color.RED, 2);
        Border emptyBorder = BorderFactory.createEmptyBorder(4, 10, 4, 10);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createCompoundBorder(redBorder,
                emptyBorder));
        panel.setLayout(new GridLayout(0, 1));

        JLabel lblPizzaSize = new JLabel("Pizza Size");
        lblPizzaSize.setForeground(Color.RED);
        panel.add(lblPizzaSize);

        rbSmall = new JRadioButton("Small: $6.50");
        rbSmall.addActionListener(this);
        rbMedium = new JRadioButton("Medium: $8.50");
        rbMedium.addActionListener(this);
        rbLarge = new JRadioButton("Large: $10.00");
        rbLarge.addActionListener(this);

        // Create new ButtonGroup
        ButtonGroup group = new ButtonGroup();

        group.add(rbSmall);
        group.add(rbMedium);
        group.add(rbLarge);

        panel.add(rbSmall);
        panel.add(rbMedium);
        panel.add(rbLarge);

        return panel;
    }

    private JPanel createTypePanel() {
        Border redBorder = BorderFactory.createLineBorder(Color.RED, 2);
        Border emptyBorder = BorderFactory.createEmptyBorder(4, 10, 4, 10);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createCompoundBorder(redBorder,
                emptyBorder));
        panel.setLayout(new GridLayout(0, 1));

        JLabel lblPizzaType = new JLabel("Pizza Type");
        lblPizzaType.setForeground(Color.RED);
        panel.add(lblPizzaType);

        rbThinCrust = new JRadioButton("Thin Crust");
        rbThinCrust.addActionListener(this);
        rbMediumCrust = new JRadioButton("Medium Crust");
        rbMediumCrust.addActionListener(this);
        rbPan = new JRadioButton("Pan");
        rbPan.addActionListener(this);

        // Create new ButtonGroup
        ButtonGroup group = new ButtonGroup();

        // add components to optionBox2 and grp1
        group.add(rbThinCrust);
        group.add(rbMediumCrust);
        group.add(rbPan);

        panel.add(rbThinCrust);
        panel.add(rbMediumCrust);
        panel.add(rbPan);

        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();

        JButton btnProcessSelection = new JButton("Process Selection");
        btnProcessSelection.addActionListener(this);
        panel.add(btnProcessSelection);

        return panel;
    }

    private JPanel createTextAreaPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel lblYourOrder = new JLabel("Your order:");
        panel.add(lblYourOrder, BorderLayout.NORTH);
        
        JLabel order = new JLabel();

        textArea = new JTextArea(6, 12);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private void addComponent(Container container, Component component,
            int gridx, int gridy, int gridwidth, int gridheight, Insets insets,
            int anchor, int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy,
                gridwidth, gridheight, 1.0D, 1.0D, anchor, fill, insets, 0, 0);
        container.add(component, gbc);
    }
    
    private void displayBill()
    {
    	String crust="", size="", toppings="";
        double price=0;
        //type selection
        if(rbThinCrust.isSelected())
        {
            crust = "Thin";
        }
        if(rbMediumCrust.isSelected())
        {
            crust = "Medium";
        }
        if(rbPan.isSelected())
        {
            crust = "Pan";
        }
        //size selection
        if(rbSmall.isSelected())
        {
        	size = "Small";
        	price = 6.50;
        }
        if(rbMedium.isSelected())
        {
        	size = "Medium";
            price = 8.50;
        }
        if(rbLarge.isSelected())
        {
        	size = "Large";
        	price = 10.00;
        }
        //topping selection
        if(cbTomato.isSelected())
        {
        	toppings += "Tomato, ";
        	price += 1.50;
        }
        if(cbGreenPepper.isSelected())
        {
        	toppings += "Green Pepper, ";
        	price += 1.50;
        }
        if(cbBlackOlives.isSelected())
        {
        	toppings += "Black Olives, ";
        	price += 1.50;
        }
        if(cbMushrooms.isSelected())
        {
        	toppings += "Mushrooms, ";
        	price += 1.50;
        }
        if(cbExtraCheese.isSelected())
        {
        	toppings += "Extra Cheese, ";
        	price += 1.50;
        }
        if(cbPepperoni.isSelected())
        {
        	toppings += "Pepperoni, ";
        	price += 1.50;
        }
        if(cbSausage.isSelected())
        {
        	toppings += "Sausage, ";
        	price += 1.50;
        }
        textArea.setText("");
        textArea.append("Pizza Type: " + crust + "\n" + "Pizza Size: " + size + "\n" + "Toppings: " + toppings + "\n" + "Amount Due: $" + df.format(price) + "\n");
        //cbTomato, cbGreenPepper, cbBlackOlives, cbMushrooms, cbExtraCheese, cbPepperoni, cbSausage
    }

    public void actionPerformed(ActionEvent event) 
    {
    	if(event.getActionCommand().equals("Process Selection"))
    		displayBill();
    }
}
