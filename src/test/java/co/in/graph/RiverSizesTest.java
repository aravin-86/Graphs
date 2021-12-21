package co.in.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RiverSizesTest {

    /**
     * Rivers can be clearly seen below:
     *
     * [
     *  [1 , , 1 ,],
     *  [1 , 1 , ,],
     *  [, , 1 , 1],
     *  [1 , 1 , 1],
     *  [1 , 1 , 1]
     * ]
     *
     */
    @Test
    public void riverSizes() {
        int[][] input = {
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0},
        };

        List<Integer> expectedOutput = Arrays.asList(1, 2, 2, 2, 5);
        List<Integer> output = RiverSizes.riverSizes(input);
        Collections.sort(output);
        Assert.assertEquals(expectedOutput, output);
    }
}