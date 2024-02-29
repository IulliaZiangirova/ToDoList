package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dao.TaskRepository;
import org.example.data.entity.Task;
import org.example.execptions.NotFoundException;
import org.example.util.Status;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;


    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    public Task findById(String id) {
        return taskRepository.findById(id).orElseThrow(()-> new NotFoundException("Task with id " + id + " is not found"));
    }

    public int getAllCount(){
        return Math.toIntExact(taskRepository.count());
    }

    public void save(Task task){
        taskRepository.save(task);
    }

    @Transactional
    public Task update(int id, String description, Status status){
        Task taskUpdated = taskRepository.findById(String.valueOf(id)).orElseThrow(()-> new NotFoundException("Task with id " + id + " is not found"));
        taskUpdated.setDescription(description);
        taskUpdated.setStatus(status);
        taskRepository.save(taskUpdated);
        return taskUpdated;
    }


    @Transactional
    public void deleteById(String id){
        taskRepository.deleteById(id);
    }

}
