package deeplearning_ai.machine_learning_specialization.course1.week2.loop_programming;

import java.util.function.Function;

public interface MultivariableFunction extends Function<Double[], Double> {
    
    Double[] getWeights();
    Double getBias();

    void updateWeights(Double[] newWeights);
    void updateBias(Double newBias);

    /**
     * <b>Method helpful next days.</b> (For chain rule) <br>
     * @param jThFeature j. weight index
     * @return <b>df/dw_j</b>
     */
    double dw_j(int jThFeature, Double[] sampleFeatureVector);
}
