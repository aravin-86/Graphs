package co.in.graph;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {

    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return child;
        }

        // O(V + E) Time | O(V) Space
        public List<String> depthFirstSearch(List<String> array) {
            array.add(name);
            for(Node child : children) {
                child.depthFirstSearch(array);
            }

            return array;
        }
    }
}
