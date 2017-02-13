"""
Build Order: You are given a list of projects and a list of dependencies
(which is a list of pairs of projects, where the second project is dependent on the first project).
All of a project'sdependencies must be built before the project is.
Find a build order that will allow the projects to be built. If there is no valid build order, return an error.
EXAMPLE Input:
projects: a, b, c, d, e, f
dependencies: (a, d), (f, b), (b, d), (f, a), (d, c) Output: f, e, a, b, d, c
Hints: #26, #47, #60, #85, # 125, # 733

Given:
a, b, c, d, e, f
a : [b]
b : [d]
d : [c]
f : [a,b]

Output:
f,e,a,b,d,c

Objective:
create a path that has a build order (list of projects)

"""

def find_starting_project(dependencies):
    # create a reversed_dependencies to check if second project is dependent on first project
    reversed_dependencies = set()
    for dep in dependencies:
        reversed_dependencies.add(dependencies[dep])
    # decide a starting project which does not have any dependencies
    for dep in dependencies:
        if dep not in reversed_dependencies:
            return dep
    return None

def create_build_order(projects,dependencies):
    # initializaitons
    # create a list of builder orders
    queue = build_order = []
    # create a set for visited build order to prevent repeats
    visited = set()
    project = find_starting_project(dependencies)
    # add all the projects that are not in the dependencies or reversed_dependencies
    for proj in projects:
        if proj not in dependencies and proj not in dependencies[proj]:
            build_order.append(proj)
    # put the starting project in the queue
    queue.append(project)
    # put the starting project in build order in the pront
    #build_order.insert(0,project)

    # breadth first search
    # while queue is not empty
    while queue:
        # pop the first element
        project = queue.pop()
        # check if that element is already visited
        if project not in visited:
            # append all the edges into the queue
            queue.extend(dependencies[project])
            # add the element into our build order
            build_order.append(project)

    return build_order


# time complexity: O(n + k) = # of vertexes, k = # of edges
# space complexity: O(n + k)
