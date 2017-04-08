
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;


/**
 * Filename: InventoryGUI.java
 * Author: Theresa Geckle
 * Date: Apr 8, 2017
 * Purpose: 
 */
public class InventoryGUI extends JFrame {
    
    public InventoryGUI() {
        super("PSID");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize JPanels
        JPanel frame = new JPanel(new BorderLayout());
        frame.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        JPanel inputPanel = new JPanel(new BorderLayout());
        JPanel inputFieldPanel = new JPanel(new FlowLayout());
        JPanel inputButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 180, 10));
        JPanel inventoryManagementPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 10));
        
        // Initialize Components
        JLabel skuLabel = new JLabel("SKU:");
        JTextField skuField = new JTextField(5);
        
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(10);
        
        JLabel descriptionLabel = new JLabel("Description:");
        JTextField descriptionField = new JTextField(20);
        
        JLabel weightLabel = new JLabel("Weight:");
        JTextField weightField = new JTextField(5);
        
        JLabel quantityLabel = new JLabel("Quantity:");
        JTextField quantityField = new JTextField(5);
        
        JLabel valueLabel = new JLabel("Value:");
        JTextField valueField = new JTextField(5);
        
        JButton addItemButton = new JButton("Add Item");
        JButton displayInventoryButton = new JButton("Display Inventory");
        
        JTable displayTable = new JTable(25, 6);
        JScrollPane displayPane = new JScrollPane(displayTable);
        
        JButton removeItemButton = new JButton("Remove Item");
        JButton removeAllButton = new JButton("Remove All");
        JButton importButton = new JButton("Import Items from File");
        JButton exportButton = new JButton("Export Inventory to File");
        
        // Add Components to Panels
        inputFieldPanel.add(skuLabel);
        inputFieldPanel.add(skuField);
        inputFieldPanel.add(nameLabel);
        inputFieldPanel.add(nameField);
        inputFieldPanel.add(descriptionLabel);
        inputFieldPanel.add(descriptionField);
        inputFieldPanel.add(weightLabel);
        inputFieldPanel.add(weightField);
        inputFieldPanel.add(quantityLabel);
        inputFieldPanel.add(quantityField);
        inputFieldPanel.add(valueLabel);
        inputFieldPanel.add(valueField);
        
        inputButtonPanel.add(addItemButton);
        inputButtonPanel.add(displayInventoryButton);
        
        inputPanel.add(inputFieldPanel, BorderLayout.NORTH);
        inputPanel.add(inputButtonPanel, BorderLayout.SOUTH);
        
        inventoryManagementPanel.add(removeItemButton);
        inventoryManagementPanel.add(removeAllButton);
        inventoryManagementPanel.add(importButton);
        inventoryManagementPanel.add(exportButton);
        
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(displayPane, BorderLayout.CENTER);
        frame.add(inventoryManagementPanel, BorderLayout.SOUTH);

        add(frame);
        
        pack();
        setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InventoryGUI gui = new InventoryGUI();
    }

}
