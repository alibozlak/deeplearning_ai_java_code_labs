package deeplearning_ai.machine_learning_specialization.course1.week2.loop_programming;

public class OurModel implements MultivariableFunction {

    private Double[] weights; 
    private Double bias;

    private static OurModel ourModel;

    private OurModel(Double[] weights, Double bias){
        this.weights = weights;
        this.bias = bias;
    }

    public static OurModel createModel(Double[] weights, Double bias) {
        if (ourModel == null)
            ourModel = new OurModel(weights, bias);
        return ourModel;
    }

    @Override
    public Double[] getWeights() {
        return this.weights;
    }

    @Override
    public Double getBias() {
        return this.bias;
    }

    @Override
    public void updateWeights(Double[] newWeights) {
        this.weights = newWeights;
    }

    @Override
    public void updateBias(Double newBias) {
        this.bias = newBias;
    }

    /**    
     * Method doesn't have <b>featureVector and weightVector validation</b>
     */
    @Override
    public Double apply(Double[] featureVector) {
        int n = this.weights.length;
        double dotProduct = 0;
        for (int j = 0; j < n; j++)
            dotProduct += this.weights[j] * featureVector[j];
        return dotProduct + this.bias;
    }

    @Override
    public double dw_j(int jThFeature, Double[] sampleFeatureVector) {
        return sampleFeatureVector[jThFeature];
    }
    
}
