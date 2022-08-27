import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Board {
    List<Task> list_of_tasks = new ArrayList<>();
    List<Assignee> people_on_board = new ArrayList<>();


    public void addTaskToBoard(String task_name) {
        if (!getListOfTasksNames().contains(task_name)) {
            this.list_of_tasks.add(new Task(task_name));
            System.out.println("Task added successfully");
        } else {
            System.out.println("Task already on board");
        }
    }

    public void removeTaskFromBoard(String task_name) {
        if(!getListOfTasksNames().contains(task_name)){
            System.out.println("Task doesn't exist");
        }
        for (Assignee assignee : this.people_on_board){
            assignee.assignee_list_of_tasks.removeIf(task -> Objects.equals(task.task_name, task_name));
        }
        this.list_of_tasks.removeIf(task -> Objects.equals(task.task_name, task_name));
        System.out.println("Task removed successfully");
    }

    public void removeAssigneeFromBoard(String assignee_name) {
        if(!getPeopleOnBoardNames().contains(assignee_name)){
            System.out.println("Person doesn't exist");
        }
        for (Task task : this.list_of_tasks){
            task.task_assignees.removeIf(assignee -> Objects.equals(assignee.assignee_name, assignee_name));
        }
        this.people_on_board.removeIf(assignee -> Objects.equals(assignee.assignee_name, assignee_name));
        System.out.println("Person removed successfully");
    }

    public void addAssigneeToBoard(String assignee_name) {
        if (!getPeopleOnBoardNames().contains(assignee_name)) {
            this.people_on_board.add(new Assignee(assignee_name));
            System.out.println("Person added successfully");
        } else {
            System.out.println("Person already on board");
        }
    }

    public void connectAssigneeToTask(String task_name, String assignee_name) {
        if (getListOfTasksNames().contains(task_name) && getPeopleOnBoardNames().contains(assignee_name)) {
            for (Task task : this.list_of_tasks) {
                if (Objects.equals(task.task_name, task_name)) {
                    for (Assignee assignee : this.people_on_board) {
                        if (Objects.equals(assignee.assignee_name, assignee_name)) {
                            assignee.addTask(task);
                            task.addAssignee(assignee);
                            System.out.println("Connected successfully");
                        }
                    }
                }
            }
        } else {
            System.out.println("Task or assignee doesn't exist");
        }
    }

    public void disconnectAssigneeFromTask(String task_name, String assignee_name) {
        if (getListOfTasksNames().contains(task_name) && getPeopleOnBoardNames().contains(assignee_name)) {
            for (Task task : this.list_of_tasks) {
                if (Objects.equals(task.task_name, task_name)) {
                    for (Assignee assignee : people_on_board) {
                        if (Objects.equals(assignee.assignee_name, assignee_name)) {
                            assignee.removeTask(task);
                            task.removeAssignee(assignee);
                            System.out.println("Disconnected successfully");
                        }
                    }
                }
            }
        } else {
            System.out.println("Task or assignee doesn't exist");
        }
    }

    public List<Task> getListOfTasks() {
        return this.list_of_tasks;
    }

    public List<String> getListOfTasksNames() {
        List<String> task_names = new ArrayList<>();
        for (Task task : this.list_of_tasks) {
            task_names.add(task.task_name);
        }
        return task_names;
    }

    public List<Assignee> getPeopleOnBoard() {

        return this.people_on_board;
    }

    public List<String> getPeopleOnBoardNames() {
        List<String> assignees_names = new ArrayList<>();
        for (Assignee assignee : this.people_on_board) {
            assignees_names.add(assignee.assignee_name);
        }
        return assignees_names;
    }

    public void printBoard() {
        System.out.println("Tasks \n" + getListOfTasksNames() + "\n" + "--------");
        System.out.println("People \n" + getPeopleOnBoardNames() + "\n" + "--------");
        System.out.println("Connections" + "\n" + "--------");
        for (Assignee assignee : this.people_on_board) {
            if (assignee.assignee_list_of_tasks.size() != 0) {
                System.out.println(assignee.assignee_name + "---" + assignee.getAssigneeListOfTasksNames());
            }
        }
    }
}
