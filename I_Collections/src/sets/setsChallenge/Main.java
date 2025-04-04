package sets.setsChallenge;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Task> tasks = TaskData.getTasks("all");
        printTasksAndSort("All tasks", tasks);

        Comparator<Task> sortByPriority = Comparator.comparing(Task::getPriority);
        Set<Task> annTasks = TaskData.getTasks("Ann");
        printTasksAndSort("Ann tasks", annTasks, sortByPriority);

//       tasks Assigned to atleast one of your 3 team members, A U B U C
        Set<Task> assignedTasks = new HashSet<>(annTasks);
        assignedTasks.addAll(TaskData.getTasks("Bob"));
        assignedTasks.addAll(TaskData.getTasks("Carol"));
        printTasksAndSort("Tasks assigned to A U B U C", assignedTasks, sortByPriority);

//       Tasks needed to be assigned, All - A U B U C
        Set<Task> unassignedTasks = new HashSet<>(tasks);
        unassignedTasks.removeAll(assignedTasks);
        printTasksAndSort("Tasks needed to be assigned", unassignedTasks, sortByPriority);
//       Tasks assigned to more than one member, A n B n C

//        Solution

        Set<Task> carolsTasks = TaskData.getTasks("Carol");
        Set<Task> bobsTasks = TaskData.getTasks("Bob");
        List<Set<Task>> unionTasks = List.of(annTasks, bobsTasks, carolsTasks);
        Set<Task> allAssignedTasks = getUnion(unionTasks);


        printTasksAndSort(" All Assigned Tasks to the 3 emps", allAssignedTasks);
        Set<Task> everyTask = getUnion(List.of(allAssignedTasks, tasks));
        printTasksAndSort("The True All Tasks", everyTask);

        Set<Task> missingTasks = getDifference(everyTask, tasks);
        printTasksAndSort("Missing Tasks", missingTasks);

        Set<Task> actualUnassignedTasks = getDifference(tasks, allAssignedTasks);
        printTasksAndSort("Unassigned Tasks", unassignedTasks, sortByPriority);

        Set<Task> overlap = getUnion(List.of(
                getIntersect(annTasks, bobsTasks),
                getIntersect(carolsTasks, bobsTasks),
                getIntersect(annTasks, carolsTasks)
        ));
        printTasksAndSort("Assigned to Multiples", overlap, sortByPriority);

        List<Task> overlapping = new ArrayList<>();
        for (Set<Task> set : unionTasks) {
            Set<Task> dupes = getIntersect(set, overlap);
            overlapping.addAll(dupes);
        }

        Comparator<Task> priorityNatural = sortByPriority.thenComparing(
                Comparator.naturalOrder());
        printTasksAndSort("Overlapping", overlapping, priorityNatural);


    }


    private static Set<Task> getUnion(List<Set<Task>> sets) {
        Set<Task> union = new HashSet<>();
        sets.forEach(union::addAll);
        return union;
    }

    private static Set<Task> getIntersect(Set<Task> a, Set<Task> b) {
        Set<Task> intersect = new HashSet<>(a);
        intersect.retainAll(b);
        return intersect;
    }

    private static Set<Task> getDifference(Set<Task> a, Set<Task> b) {
        Set<Task> result = new HashSet<>(a);
        result.removeAll(b);
        return result;
    }

    private static void printTasksAndSort(String header, Collection<Task> tasks) {
        printTasksAndSort(header, tasks, null);
        // Implement sorting tasks by priority and print them
    }

    private static void printTasksAndSort(String header, Collection<Task> tasks, Comparator<Task> sorter) {
        String separator = "-".repeat(90);
        System.out.println(separator);
        System.out.println(header);
        System.out.println(separator);

        List<Task> list = new ArrayList<>(tasks);
        list.sort(sorter);
        list.forEach(System.out::println);
        // Implement sorting tasks by priority and print them
    }
}
