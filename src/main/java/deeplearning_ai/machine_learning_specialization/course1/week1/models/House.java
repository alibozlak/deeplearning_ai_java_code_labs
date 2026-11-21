package deeplearning_ai.machine_learning_specialization.course1.week1.models;

/**
 * House model has <b>Labeled data : price</b> <br> 
 * The model has single feature : <b>sqftArea</b> (1000 square feet) <br>
 * Also has target : <b>price</b> (1000s of dollars)
 */
public class House {
    
    /**
     * <b>Feature Unit : 1000 square feet (sqft)</b>
     */
    public final float sqftArea; 

    /**
     * <b>Target Unit : 1000s of dollars</b>
     */
    public final float price;

    public House (float howMany1000sqft, float howMuch1000sOfDollars){
        validateAreaAndPriceValues(howMany1000sqft, howMuch1000sOfDollars); 

        this.sqftArea = howMany1000sqft;
        this.price = howMuch1000sOfDollars;
    }

    private void validateAreaAndPriceValues(float area, float price) {
        if (area < 0 || price < 0)
            throw new RuntimeException("Area and Price should not be negative value !!");
    }

    @Override 
    public String toString() {
        return "{\"squareFeet\": " + this.sqftArea + " (1000 sqft), \"price:\": " + this.price + " (1000s of dollars)}";
    }
}
