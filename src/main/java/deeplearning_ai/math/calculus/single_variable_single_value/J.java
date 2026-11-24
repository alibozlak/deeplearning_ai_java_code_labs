package deeplearning_ai.math.calculus.single_variable_single_value;

public class J implements SingleVariableSingleValueFunction {

    private float sizeOfHouse;
    private float realPrice;

    private static J cost;

    private J(float sizeOfHouse, float realPrice){
        this.sizeOfHouse = sizeOfHouse;
        this.realPrice = realPrice;
    }

    public static J getFunction(float sizeOfHouse, float realPrice) {
        if (cost == null)
            cost = new J(sizeOfHouse,realPrice);
        return cost;
    }

    @Override
    public Float apply(Float w) {
        return (float) Math.pow(this.sizeOfHouse * w - this.realPrice, 2);
    }

    public float calculateDerivative(float w) {
        return 2 * this.sizeOfHouse * (this.sizeOfHouse * w - this.realPrice);
    }

    @Override 
    public String getFunctionName(){
        return "J";
    }
    
}
