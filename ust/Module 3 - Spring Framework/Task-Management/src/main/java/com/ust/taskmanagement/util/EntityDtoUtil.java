package com.ust.taskmanagement.util;

import com.ust.taskmanagement.model.Task;

public class EntityDtoUtil {
    public static Task convertToEntity(Task task){
        return new Task(task.getId(), task.getName(), task.getDescription(), task.getDueDate(), task.getTaskStatus(), task.getStatus());
    }
    public static Task convertToDto(Task task){
        return new Task(task.getId(), task.getName(), task.getDescription(), task.getDueDate(), task.getTaskStatus(), task.getStatus());
    }
}
