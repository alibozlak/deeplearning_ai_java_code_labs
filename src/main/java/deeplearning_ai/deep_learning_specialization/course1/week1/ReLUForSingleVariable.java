package deeplearning_ai.deep_learning_specialization.course1.week1;

import java.util.function.Function;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

/**
 * For SizeOfHouse-Price example. <br> 
 * <b>Model : float f(float sizeOfHouse) = weight * sizeOfHouse + bias</b> <br>
 * We have <b>m samples</b>. So <b>ReLU : INArray -> INDArray</b> <br><br>
 * 
 * <b>Price should not negative value</b>
 */
public class ReLUForSingleVariable implements Function<INDArray, INDArray> {

    private static ReLUForSingleVariable relu;

    private ReLUForSingleVariable(){}

    /**
     * For SizeOfHouse-Price example. <br> 
     * <b>Model : float f(float sizeOfHouse) = weight * sizeOfHouse + bias</b> <br>
     * We have <b>m samples</b>. So <b>ReLU : INArray -> INDArray</b> <br><br>
     * 
     * <b>Price should not negative value</b>
     * 
     * @return ReLUForSingleVariable
     */
    public static ReLUForSingleVariable create(){
        if (relu == null)
            relu = new ReLUForSingleVariable();
        return relu;
    }

    /** 
     * Has been applied with <b>loop</b> 
     */
    @Override
    public INDArray apply(INDArray ndArray) {
        int m = (int) ndArray.length();
        float[] resultArray = new float[m];

        for (int i = 0; i < m; i++)
            resultArray[i] = Math.max(0.f, ndArray.getFloat(i));
        return Nd4j.create(resultArray);
    }
    
}
