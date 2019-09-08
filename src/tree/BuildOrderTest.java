package tree;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import tree.BuildOrder.Project;

import java.util.List;

public class BuildOrderTest {

    @Test
    public void validateBuildOrder() throws Exception {
        Project p1 = new Project("P1");
        Project p2 = new Project("P2");
        Project p3 = new Project("P3");
        Project p4 = new Project("P4");
        Project p5 = new Project("P5");
        p2.addPerquisite(p1);
        p3.addPerquisite(p1);
        p4.addPerquisite(p2);
        p5.addPerquisite(p3);
        BuildOrder order = new BuildOrder();
        List<Project> build = order.build(p1, p2, p3, p4, p5);

        Assert.assertThat(true, Is.is(build.containsAll(List.of(p1, p2, p4, p3, p5))));
    }
}
