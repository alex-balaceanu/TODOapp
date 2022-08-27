import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Task {
    String task_name;
    List<Assignee> task_assignees = new ArrayList<>();

    public Task(String task_name) {
        this.task_name = task_name;
    }

    public List<Assignee> getTaskAssignees() {
        return this.task_assignees;
    }

    public List<String> getTaskAssigneesNames() {
        List<String> assignees_names = new ArrayList<>();
        for(Assignee assignee : this.task_assignees){
            assignees_names.add(assignee.assignee_name);
        }
        return assignees_names;
    }

    public void addAssignee(Assignee assignee) {
        this.task_assignees.add(assignee);
    }

    public void removeAssignee(Assignee assignee) {
        this.task_assignees.remove(assignee);
    }
}
