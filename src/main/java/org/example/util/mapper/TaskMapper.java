package org.example.util.mapper;

import lombok.RequiredArgsConstructor;
import org.example.dao.TaskRepository;
import org.example.data.dto.TaskDto;
import org.example.data.entity.Task;
import org.example.data.dto.TaskCreationDto;
import org.example.util.Status;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskMapper {

    private final TaskRepository taskRepository;

    public Task toEntityForCreation(TaskCreationDto taskCreationDto){
        Task task = new Task();
        task.setDescription(taskCreationDto.getDescription());
        task.setStatus(Status.NEW);
        return task;
    }

    public Task toEntityForUpdate(TaskDto taskDto){
        Task task = new Task();
        task.setId(taskDto.getId());
        task.setDescription(taskDto.getDescription());
        task.setStatus(taskDto.getStatus());
        return task;
    }

    public TaskDto toDto (Task task){
        TaskDto taskDto = new TaskDto();
        taskDto.setId(taskDto.getId());
        taskDto.setDescription(task.getDescription());
        taskDto.setStatus(task.getStatus());
        return taskDto;
    }
}
