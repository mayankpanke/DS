package tree;


import org.hamcrest.core.Is;
import org.hamcrest.core.IsNull;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {

    @Test
    public void validateRootEmpty() {
        BinarySearchTree tree = new BinarySearchTree();
        Assert.assertThat(tree.getRoot(), IsNull.nullValue());
    }

    @Test
    public void validateRootGetsSet() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(10);
        Assert.assertThat(tree.getRoot().getData(), Is.is(10));
    }

    @Test
    public void validateLowerValueSetsOnLeft() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(10);
        tree.add(5);
        Assert.assertThat(tree.getRoot().getLeft().getData(), Is.is(5));
    }

    @Test
    public void  validateHigherVAlieSetsOnRight() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(10);
        tree.add(20);
        Assert.assertThat(tree.getRoot().getRight().getData(), Is.is(20));
    }

    @Test
    public void validateLowerToRootButHigherToSecondNodeAddedCorrectly() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(10);
        tree.add(5);
        tree.add(9);
        Assert.assertThat(tree.getRoot().getLeft().getRight().getData(), Is.is(9));
    }

    @Test
    public void validateHigherToRootButLowerToSecondNodeAddedOnLeft() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(10);
        tree.add(20);
        tree.add(15);
        Assert.assertThat(tree.getRoot().getRight().getLeft().getData(), Is.is(15));
    }
}