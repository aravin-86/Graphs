package co.in.graph;

import org.junit.Assert;
import org.junit.Test;

public class SingleCycleCheckTest {

    @Test
    public void hasSingleCycle() {
        //Arrange
        int[] array = {2, 3, 1, -4, -4, 2};

        //Act & Assert
        Assert.assertTrue(SingleCycleCheck.hasSingleCycle(array));
    }
}