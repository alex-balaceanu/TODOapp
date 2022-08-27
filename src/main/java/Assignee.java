import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Assignee {
    String assignee_name;
    List<Task> assignee_list_of_tasks = new ArrayList<>();

    public Assignee(String assignee_name) {

        this.assignee_name = assignee_name;
    }

    public List<Task> getAssigneeListOfTasks() {
        return this.assignee_list_of_tasks;
    }

    public List<String> getAssigneeListOfTasksNames(){
        List<String> list_of_task_names = new ArrayList<>();
        for (Task task : this.assignee_list_of_tasks){
            list_of_task_names.add(task.task_name);
        }
        return list_of_task_names;
    }

    public void addTask(Task task) {

        this.assignee_list_of_tasks.add(task);
    }

    public void removeTask(Task task_name) {
        this.assignee_list_of_tasks.remove(task_name);
    }

}
