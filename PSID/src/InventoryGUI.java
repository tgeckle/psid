
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 * Filename: InventoryGUI.java 
 * Author: Theresa Geckle / Joe Osborne
 * Date: Apr 8, 2017 / Apr 19, 2017
 * Purpose: Implements a GUI for interacting with the inventory management 
 * system.
 */
public class InventoryGUI extends JFrame {
    private HashMap<Integer, Item> inventory = new HashMap<>();
    
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
    
    // Fonts
    private Font labelFont = new Font("Sylfaen", Font.BOLD, 14);
    private Font buttonFont = new Font("Elephant", Font.PLAIN, 14);
    // Still working on how to set the Title Font for the frame
    private Font titleFont = new Font("Bernard MT Condensed", Font.BOLD, 11);  

    public InventoryGUI() {

        super("Personal Storage Inventory Database (PSID)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize JPanels
        JPanel frame = new JPanel(new BorderLayout());
        frame.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel inputPanel = new JPanel(new BorderLayout());
        JPanel inputFieldPanel = new JPanel(new FlowLayout());
        JPanel inputButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 180, 10));
        JPanel inventoryManagementPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 10));

        // Initialize Components
        JFileChooser chooser = new JFileChooser();
        
        JLabel skuLabel = new JLabel("SKU:");
        skuLabel.setFont(labelFont);
        JTextField skuField = new JTextField(5);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(labelFont);
        JTextField nameField = new JTextField(10);

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setFont(labelFont);
        JTextField descriptionField = new JTextField(20);

        JLabel weightLabel = new JLabel("Weight:");
        weightLabel.setFont(labelFont);
        JTextField weightField = new JTextField(5);

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setFont(labelFont);
        JTextField quantityField = new JTextField(5);

        JLabel valueLabel = new JLabel("Value:");
        valueLabel.setFont(labelFont);
        JTextField valueField = new JTextField(5);

        JButton addItemButton = new JButton("Add Item");
        addItemButton.setFont(buttonFont);
        JButton displayInventoryButton = new JButton("Display Inventory");
        displayInventoryButton.setFont(buttonFont);
        
        JButton removeItemButton = new JButton("Remove Item");
        removeItemButton.setFont(buttonFont);
        JButton removeAllButton = new JButton("Remove All");
        removeAllButton.setFont(buttonFont);
        JButton importButton = new JButton("Import Items from File");
        importButton.setFont(buttonFont);
        JButton exportButton = new JButton("Export Inventory to File");
        exportButton.setFont(buttonFont);
        
        // Listeners
        // Listener for the "Add Item" button. 
        addItemButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int sku = Integer.parseInt(skuField.getText());
                String name = nameField.getText();
                String description = descriptionField.getText();
                double weight = Double.parseDouble(weightField.getText());
                int quantity = Integer.parseInt(quantityField.getText());
                double value = Double.parseDouble(valueField.getText());
                
                inventory.put(sku, new Item(sku, name, description, weight, 
                        quantity, value));
            }
        });
        
        // Listener for "Import from File" button
        importButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chooser.setDialogTitle("Choose Input File");
                chooser.setFileFilter(filter);
                
                if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                    inventory = new HashMap<>(); // Clear the current inventory
                    try (Scanner input = new Scanner(chooser.getSelectedFile())) {
                        int sku;
                        String name;
                        String description;
                        double weight;
                        int quantity;
                        double value;
                        
                        while (input.hasNextLine()) {
                            sku = input.nextInt();
                            name = input.next();
                            description = input.next();
                            weight = input.nextDouble();
                            quantity = input.nextInt();
                            value = input.nextDouble();
                            input.nextLine();
                            
                            inventory.put(sku, new Item(sku, name, description, 
                                    weight, quantity, value));
                        }
                    }
                    catch (IOException exc) {
                    
                }
                }
            }
        });
        
        // Listener for "Export to File" button
        exportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chooser.setDialogTitle("Choose Output File Location");
                chooser.setFileFilter(filter);

                if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    try (FileWriter fw = new FileWriter(chooser.getSelectedFile()+".txt")) {
                        for (Item item : inventory.values()) {
                            fw.write(item.toString());
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        // For the JTable
        DefaultTableModel tableModel = new DefaultTableModel() {
            // Setting the table column names
            String[] columnNames = {"SKU", "Name", "Description", "Weight",
                "Quantity", "Value"};

            @Override
            public int getColumnCount() {
                return columnNames.length;
            }

            @Override
            public String getColumnName(int index) {
                return columnNames[index];
            }
        };

        JTable displayTable = new JTable(tableModel);
        JScrollPane displayPane = new JScrollPane(displayTable);
        JTableHeader headerFont = displayTable.getTableHeader();
        headerFont.setFont(new Font("Times New Roman", Font.BOLD, 12));


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
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        InventoryGUI gui = new InventoryGUI();

    }

}
