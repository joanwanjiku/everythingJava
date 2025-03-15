package setsChallenge;

import java.util.Objects;

public class Task implements Comparable<Task> {
    private String assigne;
    private String prjName;
    private String description;
    private Status status;
    private Priority priority;

    public Task(String assigne, String prjName, String description, Status status, Priority priority) {
        this.assigne = assigne;
        this.prjName = prjName;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    public Task(String assigne, String prjName, String description, Priority priority) {
        this(assigne, prjName, description, assigne ==null? Status.IN_QUEUE:Status.ASSIGNED, priority);
    }

    public Task(String prjName, String description, Priority priority) {
        this(null, prjName, description, priority );
    }

    public String getAssigne() {
        return assigne;
    }

    public void setAssigne(String assigne) {
        this.assigne = assigne;
    }

    public String getPrjName() {
        return prjName;
    }

    public void setPrjName(String prjName) {
        this.prjName = prjName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return String.format("%-20s %-25s  %-10s %-10s %s", prjName, description, priority, assigne, status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(getPrjName(), task.getPrjName()) && Objects.equals(getDescription(), task.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrjName(), getDescription());
    }

    @Override
    public int compareTo(Task o) {
        int result = this.prjName.compareTo(o.prjName);
        if (result == 0) {
            result = this.description.compareTo(o.description);
        }
        return result;
    }
}
