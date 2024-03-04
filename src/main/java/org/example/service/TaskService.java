package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.TaskRepository;
import org.example.data.entity.Task;
import org.example.execptions.NotFoundException;
import org.example.util.Status;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskService {
    private final TaskRepository taskRepository;


    public List<Task> findAll(int offset, int limit){
        return taskRepository.findAll(PageRequest.of(offset, limit));
    }

    public Task findById(String id) {
        return taskRepository.findById(id).orElseThrow(()-> new NotFoundException("Task with id " + id + " is not found"));
    }


    @Transactional
    public void save(Task task){
        taskRepository.save(task);
        log.info("Task with " + task.getId() + " was saved");
    }

    @Transactional
    public void update(Task task){
        Task taskUpdated = taskRepository.findById(String.valueOf(task.getId())).orElseThrow(()-> new NotFoundException("Task is not found"));
        if(task.getDescription() != null){
            taskUpdated.setDescription(task.getDescription());
        }
        if(task.getStatus() != null){
            taskUpdated.setStatus(task.getStatus());
        }
        log.info("Task with " + task.getId() + " was updated");
        taskRepository.save(taskUpdated);
    }


    @Transactional
    public void deleteById(String id){
        taskRepository.findById(id).orElseThrow(()-> new NotFoundException("Task is not found"));
        taskRepository.deleteById(id);
        log.info("Task with " + id + " was deleted");
    }

}
