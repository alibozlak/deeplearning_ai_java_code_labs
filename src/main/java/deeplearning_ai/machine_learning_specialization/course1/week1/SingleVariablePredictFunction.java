package deeplearning_ai.machine_learning_specialization.course1.week1;

import java.util.function.Function;

import org.nd4j.linalg.api.ndarray.INDArray;

public interface  SingleVariablePredictFunction extends Function<INDArray, INDArray> {

    float getWeight();
    float getBias();

    public void updateWeight(float newWeight);
    public void updateBias(float newBias);
}
