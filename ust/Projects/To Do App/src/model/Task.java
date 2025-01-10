package model;
//implements Comparable<Task>
public class Task {
    private String title;
    private int priority;
    private Status status;

    public Task(String title, int priority) {
        this.title = title;
        this.priority = priority;
        this.status = Status.Completed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

//    @Override
//    public int compareTo(Task t) {
//         return (int)t.priority-(int)priority;
//       // return Integer.compare(t.priority,priority);
//    }
}
