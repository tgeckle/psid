
public class Item {
    String itemDescription;
    Double value;
    Double weight;
    
    public Item(String inputItemDescription, Double inputValue, Double inputWeight){
        itemDescription = inputItemDescription;
        value = inputValue;
        weight = inputWeight;
    }
    
    public void setItemDescription(String description){
        itemDescription = description;
    }
    
    public String getItemDescription(){
        return itemDescription;
    }
    
    public void setValue(Double v){
        value = v;
    }
    
    public Double getValue(){
        return value;
    }
    
    public void setWeight(Double w){
        weight = w;
    }
    
}
