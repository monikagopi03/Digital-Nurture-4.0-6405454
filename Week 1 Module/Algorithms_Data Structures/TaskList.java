class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    Task(int id, String name, String status) {
        this.taskId = id;
        this.taskName = name;
        this.status = status;
        this.next = null;
    }
}

public class TaskList {
    Task head = null;

    void addTask(Task t) {
        if (head == null) head = t;
        else {
            Task current = head;
            while (current.next != null) current = current.next;
            current.next = t;
        }
    }

    Task searchTask(int id) {
        Task current = head;
        while (current != null) {
            if (current.taskId == id) return current;
            current = current.next;
        }
        return null;
    }

    void traverseTasks() {
        Task current = head;
        while (current != null) {
            System.out.println(current.taskName + " - " + current.status);
            current = current.next;
        }
    }

    void deleteTask(int id) {
        if (head == null) return;
        if (head.taskId == id) {
            head = head.next;
            return;
        }
        Task current = head;
        while (current.next != null && current.next.taskId != id) {
            current = current.next;
        }
        if (current.next != null)
            current.next = current.next.next;
    }

    public static void main(String[] args) {
        TaskList list = new TaskList();

        list.addTask(new Task(1, "Design", "Pending"));
        list.addTask(new Task(2, "Development", "In Progress"));
        list.addTask(new Task(3, "Testing", "Pending"));

        System.out.println("All Tasks:");
        list.traverseTasks();

        System.out.println("\nSearch Task ID 2:");
        Task found = list.searchTask(2);
        if (found != null)
            System.out.println(found.taskName + " - " + found.status);
        else
            System.out.println("Task not found");

        System.out.println("\nDeleting Task ID 2...");
        list.deleteTask(2);

        System.out.println("\nRemaining Tasks:");
        list.traverseTasks();
    }
}
