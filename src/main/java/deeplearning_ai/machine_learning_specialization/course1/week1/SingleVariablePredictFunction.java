package deeplearning_ai.machine_learning_specialization.course1.week1;

import java.util.function.Function;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

public class SingleVariablePredictFunction implements Function<INDArray, INDArray> {

    private float weight;
    private float bias;

    public SingleVariablePredictFunction(float weight, float bias) {
        this.weight = weight;
        this.bias = bias;
    }

    /**
     * Defaults : <br>
     * Weigth = w = 0.0f, <br>
     * Bias = b = 0.0f
     */
    public SingleVariablePredictFunction() {
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

    public float getWeight() {
        return this.weight;
    }

    public float getBias() {
        return this.bias;
    }
}
