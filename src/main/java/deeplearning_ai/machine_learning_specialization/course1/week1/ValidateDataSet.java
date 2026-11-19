package deeplearning_ai.machine_learning_specialization.course1.week1;

import org.nd4j.linalg.api.ndarray.INDArray;

public class ValidateDataSet {
    
    /**
     * 
     * @param featureArray : INDArray
     * @param targetArray : INDArray
     * @return m = sampleCount : long
     */
    public static long validateFeatureArraySizeAndTargetArraySize(INDArray featureArray, INDArray targetArray) {
        long sampleCount = featureArray.length();
        if (sampleCount != targetArray.length())
            throw new RuntimeException("Feature array size and Target array size should be equal !!");

        return sampleCount;
    }
}
