package todoapp;

public class Task {
    private String name;
    private boolean isCompleted = false;

    public Task(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
    public boolean isCompleted() {
        return isCompleted;
    }
}
