package ua.kpi.share.dto;

/**
 * Created by oleh on 24.05.2015.
 */
public class TaskApply {
    private int userId;
    private int price;
    private int taskId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
}
