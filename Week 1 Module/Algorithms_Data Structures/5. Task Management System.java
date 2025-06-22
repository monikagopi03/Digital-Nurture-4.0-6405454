

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

class TaskList {
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
}