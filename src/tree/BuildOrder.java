package tree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * You are given a list of projects and a list of dependencies (which is a list of pairs of
 * projects, where the second project is dependent on the first project). All of a project's dependencies
 * must be built before the project is. Find a build order that will allow the projects to be built. If there
 * is no valid build order, return an error.
 */

public class BuildOrder {

    private Set<Project> visited = new HashSet<>();

    public List<Project> build(Project ...projects) throws Exception {
        if(projects == null || projects.length == 0) {
            return Collections.emptyList();
        }
        if(projects.length == 1 && projects[0].prerequisite.isEmpty()) {
            return Collections.singletonList(projects[0]);
        }
        List<Project> nonDependentProjects = Arrays.stream(projects)
                .filter(project -> project.dependents == 0)
                .collect(Collectors.toList());

        if(nonDependentProjects.isEmpty()) {
            throw new Exception("Could not build as there is no project to start with without pre-requisite");
        }
        for(Project startingProject : nonDependentProjects) {
            Stack<Project> stack = new Stack<>();
            buildDependency(startingProject, stack);
            stack.add(startingProject);
            if(!stack.isEmpty()) {
                List<Project> deps = buildDependentList(stack);
                if(deps.containsAll(Arrays.asList(projects))) {
                    return deps;
                }
            }
        }
        throw new Exception("Could not build given projects");
    }

    private List<Project> buildDependentList(Stack<Project> stack) {
        List<Project> dependentProjects = new ArrayList<>();
        while(!stack.isEmpty()) {
            dependentProjects.add(stack.pop());
        }
        return dependentProjects;
    }

    private void buildDependency(Project project, Stack<Project> stack) throws Exception {
        if(visited.contains(project)){
            throw new Exception("There is a cycle in dependencies, could not build");
        }
        visited.add(project);
        if(project.prerequisite == null || project.prerequisite.size() == 0) {
            return;
        } else {
            for(Project dep : project.prerequisite) {
                buildDependency(dep, stack);
                stack.push(dep);
            }
        }
    }

    static class Project {
        private String name;
        private List<Project> prerequisite;
        private int dependents;

        Project(String name) {
            this.name = name;
            this.prerequisite = new ArrayList<>();
            this.dependents = 0;
        }

        void addPerquisite(Project req) {
            req.prerequisite.add(this);
            this.dependents++;
        }

        @Override
        public String toString() {
            return "Project{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}

