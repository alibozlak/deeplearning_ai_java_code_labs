package deeplearning_ai.machine_learning_specialization.course1.week2.with_nd4j;

import java.util.function.Function;

import org.nd4j.linalg.api.ndarray.INDArray;

public interface MultivariableFunction extends Function<INDArray, Double> {
    
    INDArray getWeights();
    double getBias();

    void updateWeights(INDArray newWeights);
    void updateBias(double newBias);

    INDArray applyAll(INDArray datasetFeatureMatrix);
}
