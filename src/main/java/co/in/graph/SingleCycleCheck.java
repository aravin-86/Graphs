package co.in.graph;

/**
 * @see <a href="https://www.algoexpert.io/questions/Single%20Cycle%20Check">Single Cycle Check</a>
 */
public class SingleCycleCheck {

    // O(n) Time | O(1) Space
    public static boolean hasSingleCycle(int[] array) {
        int currentIdx = 0;
        int visitedElementsCount = 0;

        while(visitedElementsCount < array.length) {
            if(visitedElementsCount > 0 && currentIdx == 0) {
                return false;
            }

            visitedElementsCount++;
            currentIdx = getNextIdx(currentIdx, array);
        }

        return currentIdx == 0;
    }

    private static int getNextIdx(int currentIdx, int[] array) {
        int nextIdx = (currentIdx + array[currentIdx]) % array.length;
        return nextIdx >=0 ? nextIdx : nextIdx + array.length;
    }
}
