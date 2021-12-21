package co.in.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BreadthFirstSearchTest {

    @Test
    public void breadthFirstSearch() {
        //Arrange
        BreadthFirstSearch.Node inputGraph = getInputGraph();
        List<String> outputList = new ArrayList<>();
        //Act
        inputGraph.breadthFirstSearch(outputList);

        //Assert
        List<String> expectedOutput = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");
        Assert.assertEquals(expectedOutput, outputList);
    }

    /**
     *  Below is the Input Graph:
     *             A
     *           / | \
     *          B  C  D
     *        /  \   / \
     *       E    F G   H
     *           / \
     *          I   J
     *
     * @return Graph
     */
    private BreadthFirstSearch.Node getInputGraph() {
        BreadthFirstSearch.Node a = new BreadthFirstSearch.Node("A");
        BreadthFirstSearch.Node b = a.addChild("B");
        a.addChild("C");
        BreadthFirstSearch.Node d = a.addChild("D");

        b.addChild("E");
        BreadthFirstSearch.Node f = b.addChild("F");

        d.addChild("G");
        d.addChild("H");

        f.addChild("I");
        f.addChild("J");

        return a;
    }
}