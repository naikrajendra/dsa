package com.rpk.dsa;
import java.util.ArrayList;
import java.util.List;  

/**
 * This class provides a method to determine if it is possible to finish all courses given their prerequisites using topological sort.
 *  The `canFinish` method constructs a directed graph from the prerequisites and uses depth-first search (DFS) to detect cycles. If a cycle is detected, it indicates that it is impossible to finish all courses. The time complexity of this approach is O(V + E), where V is the number of courses and E is the number of prerequisites. The space complexity is O(V) for storing the graph and visited nodes.
 * Example usage:
 * ```java
 * CourseScheduleTopologicalSort courseSchedule = new CourseScheduleTopologicalSort();
 * int numCourses = 4;
 * int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}};
 * System.out.println(courseSchedule.canFinish(numCourses, prerequisites)); // Output: true
 * ```
 * This example demonstrates a scenario where it is possible to finish all courses by following the prerequisite order.
 * If there were a cycle in the prerequisites, the `canFinish` method would return false, indicating that it is impossible to complete all courses.
 * This class uses a depth-first search approach to perform topological sorting and detect cycles in the course prerequisite graph.
 * It provides a comprehensive explanation of the class functionality, usage example, and the underlying algorithmic approach.
 * The class is designed to be used in scenarios where one needs to determine the feasibility of completing all courses given a set of prerequisites, making it useful for academic planning and course scheduling applications.
 * This class can be particularly useful for students, academic advisors, and educational institutions to plan course schedules effectively and ensure that all prerequisite requirements can be met before attempting to complete a course.
 * It emphasizes the practical applications and benefits of using this class for course planning and scheduling, highlighting its relevance in real-world academic scenarios.
 * Overall, the `CourseScheduleTopologicalSort` class serves as a valuable tool for understanding and managing course prerequisites, providing both theoretical and practical insights into course scheduling and academic planning.
 * CourseScheduleTopologicalSort
 */


public class CourseScheduleTopologicalSort {

    // Method to determine if it is possible to finish all courses
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create an adjacency list to represent the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        // Array to track visited nodes
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course, List<List<Integer>> graph, int[] visited) {
        if (visited[course] == 1) return false;
        if (visited[course] == 2) return true;
        visited[course] = 1;
        for (int neighbor : graph.get(course)) {
            if (!dfs(neighbor, graph, visited)) {
                return false;
            }
        }
        visited[course] = 2;
        return true;
    }
    // Method to perform a depth-first search to detect cycles
    // Returns false if a cycle is detected, true otherwise 
    //main method to test the canFinish method with example inputs
    public static void main(String[] args) {
        CourseScheduleTopologicalSort courseSchedule = new CourseScheduleTopologicalSort();
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}};
        System.out.println(courseSchedule.canFinish(numCourses, prerequisites)); // Output: true
    }

}
