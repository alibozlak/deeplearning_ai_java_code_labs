package deeplearning_ai.machine_learning_specialization.course1.week1;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

public class SingleVariablePredictFunctionImpl implements SingleVariablePredictFunction {

    private float weight;
    private float bias;

    public SingleVariablePredictFunctionImpl(float weight, float bias) {
        this.weight = weight;
        this.bias = bias;
    }

    /**
     * Defaults : <br>
     * Weigth = w = 0.0f, <br>
     * Bias = b = 0.0f
     */
    public SingleVariablePredictFunctionImpl() {
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
