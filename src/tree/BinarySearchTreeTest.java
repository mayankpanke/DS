package tree;


import org.hamcrest.core.Is;
import org.hamcrest.core.IsNull;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static tree.BinarySearchTree.*;

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

    @Test
    public void validateNothingReturnedWhenTreeEmpty() {
        BinarySearchTree tree = new BinarySearchTree();
        Optional<Node> search = tree.search(10);
        Assert.assertThat(search.isPresent(), Is.is(false));
    }

    @Test
    public void validateSearchOnRoot() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(10);
        Optional<Node> search = tree.search(10);
        Assert.assertThat(search.get().getData(), Is.is(10));
    }

    @Test
    public void validateNotReturnedWhenValueNotPresent(){
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(10);
        Optional<Node> search = tree.search(20);
        Assert.assertThat(search.isPresent(), Is.is(false));
    }

    @Test
    public void validateLeftSideOfTreeSearched(){
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(10);
        tree.add(5);
        tree.add(7);
        tree.add(3);
        Optional<Node> search = tree.search(3);
        Assert.assertThat(search.get().getData(), Is.is(3));
    }

    @Test
    public void validateRightSideOfTreeSearched(){
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(10);
        tree.add(20);
        tree.add(15);
        tree.add(17);
        Optional<Node> search = tree.search(15);
        Assert.assertThat(search.get().getData(), Is.is(15));
    }

    @Test
    public void validateCorrectSideOfTreeSearched() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(10);
        tree.add(20);
        tree.add(15);
        tree.add(17);
        tree.add(5);
        tree.add(7);
        tree.add(3);
        Optional<Node> search = tree.search(3);
        Assert.assertThat(search.get().getData(), Is.is(3));
    }

    @Test
    public void validateGreaterNumberNotFoundInFullTree() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(10);
        tree.add(20);
        tree.add(15);
        tree.add(17);
        tree.add(5);
        tree.add(7);
        tree.add(3);
        Optional<Node> search = tree.search(30);
        Assert.assertThat(search.isPresent(), Is.is(false));
    }

    @Test
    public void validateLessNumberNotFoundInFullTree() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(10);
        tree.add(20);
        tree.add(15);
        tree.add(17);
        tree.add(5);
        tree.add(7);
        tree.add(3);
        Optional<Node> search = tree.search(1);
        Assert.assertThat(search.isPresent(), Is.is(false));
    }
}