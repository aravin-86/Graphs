package co.in.graph;

public class YoungestCommonAncestor {

    // O(d) Time | O(1) Space, where d is the depth of the ancestral tree
    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {

        int depthOne = getDepth(descendantOne, topAncestor);
        int depthTwo = getDepth(descendantTwo, topAncestor);

        if(depthOne > depthTwo) {
            return findCommonAncestor(descendantOne, descendantTwo, depthOne - depthTwo);
        } else {
            return findCommonAncestor(descendantTwo, descendantOne, depthTwo - depthOne);
        }
    }

    private static AncestralTree findCommonAncestor(AncestralTree lowerDescendant, AncestralTree higherDescendant, int level) {

        while(level > 0) {
            lowerDescendant = lowerDescendant.ancestor;
            level--;
        }

        while(lowerDescendant != higherDescendant) {
            lowerDescendant = lowerDescendant.ancestor;
            higherDescendant = higherDescendant.ancestor;
        }

        return lowerDescendant;
    }

    private static int getDepth(AncestralTree descendantTree, AncestralTree topAncestor) {
        AncestralTree currentDescendant = descendantTree;
        int depth = 0;
        while(currentDescendant != topAncestor) {
            depth++;
            currentDescendant = currentDescendant.ancestor;
        }

        return depth;
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }
}
