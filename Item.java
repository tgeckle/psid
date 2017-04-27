package inventorygui;

/**
 * Filename: Item.java 
 * Author: Theresa Geckle / Joe Osborne 
 * Date: Apr 22, 2017 / Apr 23, 2017 
 * Purpose: Group Project
 */
public class Item {

    private int itemSKU;
    private String itemName;
    private String itemDescription;
    private double weight;
    private int quantity;
    private double value;

    public Item(int inputSKU, String inputName, String inputItemDescription,
            double inputWeight, int inputQuantity, double inputValue) {
        itemSKU = inputSKU;
        itemName = inputName;
        itemDescription = inputItemDescription;
        weight = inputWeight;
        quantity = inputQuantity;
        value = inputValue;
    }

    public int getSKU() {
        return itemSKU;
    }

    public String getName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public double getWeight() {
        return weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getValue() {
        return value;
    }

    /*
    Adds or subtracts a given number from the item quantity.  We may wish to add
    a custom exception for if the quantity would otherwise go into the negatives,
    but we probably don't need to.
     */
    public void changeQuantity(int delta) {
        quantity += delta;
    }

    // What prints to file
    public String toString() {
        return itemSKU + "\t" + itemName + "\t" + itemDescription + "\t"
                + weight + (" lbs") + "\t" + quantity + "\t" + ("$ ") + value
                + System.getProperty("line.separator");
    }

}
