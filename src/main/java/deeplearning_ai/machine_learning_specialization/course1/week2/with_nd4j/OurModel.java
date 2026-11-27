package deeplearning_ai.machine_learning_specialization.course1.week2.with_nd4j;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.ops.transforms.Transforms;

public class OurModel implements MultivariableFunction {

    private INDArray weights;
    private double bias;
    
    private static OurModel ourModel;

    private OurModel(INDArray initialWeights, double initialBias){
        this.weights = initialWeights;
        this.bias = initialBias;
    }

    public static OurModel create(INDArray initialWeights, double initialBias) {
        if (ourModel == null)
            ourModel = new OurModel(initialWeights, initialBias);

        return ourModel;
    }
    
    @Override
    public INDArray getWeights() {
        return this.weights;
    }

    @Override
    public double getBias() {
        return this.bias;
    }

    @Override
    public void updateWeights(INDArray newWeights) {
        this.weights = newWeights;
    }

    @Override
    public void updateBias(double newBias) {
        this.bias = newBias;
    }

    @Override
    public Double apply(INDArray featureVector) {
        INDArray result = Transforms.dot(this.weights, featureVector);
        double scalarResult = result.getDouble(0);
        return scalarResult + this.bias;
    }

    @Override
    public INDArray applyAll(INDArray datasetFeatureMatrix) 
    {
        // Conversion from vector to matrix :
        INDArray weightMatrix = this.weights.reshape(this.weights.length(), 1);

        // Matrix Multiplication : 
        INDArray matrixMultiplicationMatrix = datasetFeatureMatrix.mmul(weightMatrix);

        // Broadcasting :
        INDArray resultMatrix = matrixMultiplicationMatrix.add(this.bias);

        // Reshape : 
        return resultMatrix.reshape(-1);
    }
    
}
