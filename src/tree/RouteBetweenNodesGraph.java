package tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * In a directed graph find if there is a route between two nodes exist or not.
 */
public class RouteBetweenNodesGraph {

    public boolean existPath(Node start, Node end) {
        if (Objects.equals(start, end))
            return true;
        LinkedList<Node> nodesToVisit = new LinkedList<>();
        Set<Node> visitedNodes = new HashSet<>();
        visitedNodes.add(start);
        nodesToVisit.addAll(start.nextLevel());
        while (!nodesToVisit.isEmpty()) {
            Node node = nodesToVisit.removeFirst();
            if (visitedNodes.contains(node)) {
                continue;
            }
            visitedNodes.add(node);
            if (node.value.equals(end.value)) {
                return true;
            } else {
                nodesToVisit.addAll(node.nextLevel());
            }
        }
        return false;
    }


    static class Node {
        private String value;
        private List<Edges> edges;

        Node(String value) {
            this.value = value;
            this.edges = new ArrayList<>();
        }

        void addNode(Node nextNode) {
            edges.add(new Edges(this, nextNode));
        }

        Collection<Node> nextLevel() {
            return edges.stream()
                    .map(edge -> edge.endNode)
                    .collect(Collectors.toUnmodifiableSet());
        }

        private class Edges {
            Node endNode;
            Node startNode;

            Edges(Node startNode, Node endNode) {
                this.endNode = endNode;
                this.startNode = startNode;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(value, node.value) &&
                    Objects.equals(edges, node.edges);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, edges);
        }
    }
}