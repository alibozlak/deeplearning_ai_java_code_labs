package deeplearning_ai.machine_learning_specialization.course1.week1;

import org.nd4j.linalg.api.ndarray.INDArray;

@FunctionalInterface 
public interface CostFunction {
    
    float calculate(INDArray predictions, INDArray realValues);
}
