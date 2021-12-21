package co.in.graph;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DepthFirstSearchTest {

    @Test
    public void depthFirstSearch() {
        //Arrange
        DepthFirstSearch.Node inputGraph = getInputGraph();
        List<String> ouputList = new ArrayList<>();

        //Act
        inputGraph.depthFirstSearch(ouputList);

        //Assert
        List<String> expectedOutput = Arrays.asList("A", "B", "E", "F", "I", "J", "C", "D", "G", "H");
        Assert.assertEquals(expectedOutput, ouputList);
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
    private DepthFirstSearch.Node getInputGraph() {
        DepthFirstSearch.Node a = new DepthFirstSearch.Node("A");
        DepthFirstSearch.Node b = a.addChild("B");
        b.addChild("E");
        DepthFirstSearch.Node f = b.addChild("F");
        f.addChild("I");
        f.addChild("J");

        a.addChild("C");

        DepthFirstSearch.Node d = a.addChild("D");
        d.addChild("G");
        d.addChild("H");

        return a;
    }
}