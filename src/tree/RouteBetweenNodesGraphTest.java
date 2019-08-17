package tree;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import static tree.RouteBetweenNodesGraph.Node;

public class RouteBetweenNodesGraphTest {

    @Test
    public void validateWhenStartAndEndIsSame() {
        Node node = new Node("P1");
        Node nodep11 = new Node("P11");
        Node nodep12 = new Node("P12");
        node.addNode(nodep11);
        node.addNode(nodep12);
        RouteBetweenNodesGraph route = new RouteBetweenNodesGraph();
        boolean exist = route.existPath(node, node);
        Assert.assertThat(exist, Is.is(true));
    }

    @Test
    public void validateRouteFoundWhenItExist() {
        Node node = new Node("P1");
        Node nodep11 = new Node("P11");
        Node nodep12 = new Node("P12");
        node.addNode(nodep11);
        node.addNode(nodep12);
        RouteBetweenNodesGraph route = new RouteBetweenNodesGraph();
        boolean exist = route.existPath(node, nodep12);
        Assert.assertThat(exist, Is.is(true));
    }

    @Test
    public void validateRouteInCyclicFoundWhenItExist() {
        Node node = new Node("P1");
        Node nodep11 = new Node("P11");
        Node nodep12 = new Node("P12");
        node.addNode(nodep11);
        node.addNode(nodep12);
        nodep12.addNode(node);
        Node node21 = new Node("P21");
        Node node22 = new Node("P21");
        nodep11.addNode(node21);
        nodep12.addNode(node22);
        RouteBetweenNodesGraph route = new RouteBetweenNodesGraph();
        boolean exist = route.existPath(node, node21);
        Assert.assertThat(exist, Is.is(true));
    }

    @Test
    public void validateRouteNotFoundWhenItNotExist() {
        Node node = new Node("P1");
        Node nodep11 = new Node("P11");
        Node nodep12 = new Node("P12");
        node.addNode(nodep11);
        node.addNode(nodep12);
        nodep12.addNode(node);
        Node node21 = new Node("P21");
        Node node22 = new Node("P22");
        nodep12.addNode(node22);
        RouteBetweenNodesGraph route = new RouteBetweenNodesGraph();
        boolean exist = route.existPath(node, node21);
        Assert.assertThat(exist, Is.is(false));
    }
}