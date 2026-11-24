package deeplearning_ai.machine_learning_specialization.course1.week1;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

public class SingleVariablePredictFunctionImpl implements SingleVariablePredictFunction {

    private float weight;
    private float bias;

    private static SingleVariablePredictFunctionImpl singleVariablePredictFunctionImpl;

    private SingleVariablePredictFunctionImpl(float weight, float bias) {
        this.weight = weight;
        this.bias = bias;
    }

    public static SingleVariablePredictFunctionImpl create(float weight, float bias) {
        if (
            singleVariablePredictFunctionImpl == null || 
            singleVariablePredictFunctionImpl.weight != weight || 
            singleVariablePredictFunctionImpl.bias != bias
        ) 
            singleVariablePredictFunctionImpl = new SingleVariablePredictFunctionImpl(weight, bias);

        return singleVariablePredictFunctionImpl;
    }

    /**    
     * This methods uses <b>loop</b> <br>
     * @see java.util.function.Function#apply(java.lang.Object)
     */
    @Override
    public INDArray apply(INDArray featureArray) {
        int sampleSize = (int) featureArray.length();
        float[] predictArray = new float[sampleSize];
        for (int i = 0; i < sampleSize; i++)
            predictArray[i] = this.weight * featureArray.getFloat(i) + this.bias;

        return Nd4j.create(predictArray);
    }

    @Override 
    public float getWeight() {
        return this.weight;
    }

    @Override 
    public float getBias() {
        return this.bias;
    }

    @Override 
    public void updateWeight(float newWeight) {
        this.weight = newWeight;
    }

    @Override 
    public void updateBias(float newBias) {
        this.bias = newBias;
    }
}
