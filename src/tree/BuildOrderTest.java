package tree;

import org.hamcrest.CoreMatchers;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tree.BuildOrder.Project;

import java.util.Iterator;
import java.util.List;

public class BuildOrderTest {

    @Rule
    public ExpectedException exceptionExpected = ExpectedException.none();

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
        Iterator<Project> builtOrderItr = build.iterator();
        Assert.assertThat(builtOrderItr.next(), Is.is(p1));
        Assert.assertThat(builtOrderItr.next(), CoreMatchers.either(Is.is(p2)).or(Is.is(p3)));
        Assert.assertThat(builtOrderItr.next(), CoreMatchers.either(Is.is(p4)).or(Is.is(p5)));
        Assert.assertThat(builtOrderItr.next(), CoreMatchers.either(Is.is(p2)).or(Is.is(p3)));
        Assert.assertThat(builtOrderItr.next(), CoreMatchers.either(Is.is(p4)).or(Is.is(p5)));
    }

    @Test
    public void validateCouldNotBuildOrder() throws Exception {
        Project p1 = new Project("P1");
        Project p2 = new Project("P2");
        Project p3 = new Project("P3");
        Project p4 = new Project("P4");
        Project p5 = new Project("P5");
        p2.addPerquisite(p1);
        p3.addPerquisite(p1);
        p4.addPerquisite(p2);
        BuildOrder order = new BuildOrder();

        exceptionExpected.expect(Exception.class);
        List<Project> build = order.build(p1, p2, p3, p4, p5);
    }

    @Test
    public void validateCouldNotDueToCyclicBuildOrder() throws Exception {
        Project p1 = new Project("P1");
        Project p2 = new Project("P2");
        Project p3 = new Project("P3");
        Project p4 = new Project("P4");
        Project p5 = new Project("P5");
        p2.addPerquisite(p1);
        p3.addPerquisite(p1);
        p4.addPerquisite(p2);
        p5.addPerquisite(p3);
        p3.addPerquisite(p5);
        BuildOrder order = new BuildOrder();

        exceptionExpected.expect(Exception.class);
        List<Project> build = order.build(p1, p2, p3, p4, p5);
    }
}
