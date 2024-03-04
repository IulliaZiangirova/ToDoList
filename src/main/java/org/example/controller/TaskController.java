package org.example.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.data.dto.RestResponse;
import org.example.data.dto.TaskCreationDto;
import org.example.data.dto.TaskDto;
import org.example.data.entity.Task;
import org.example.service.TaskService;
import org.example.util.mapper.TaskMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor

public class TaskController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String findAll(Model model, @RequestParam(value = "page", defaultValue = "1") int page,
                                @RequestParam(value = "limit", defaultValue = "10") int limit) {
        List<Task> tasks= taskService.findAll((page - 1) * limit, limit);
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping("/{id}")
    public RestResponse findById(@PathVariable String id) {
        return new RestResponse(taskMapper.toDto(taskService.findById(id)));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestResponse create(@RequestBody @Valid TaskCreationDto taskCreationDto) {
        taskService.save(taskMapper.toEntityForCreation(taskCreationDto));
        return new RestResponse("Created");
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RestResponse deleteById(@PathVariable String id) {
        taskService.deleteById(id);
        return new RestResponse("Deleted");
    }

    @PatchMapping()
    @ResponseStatus(HttpStatus.OK)
    public RestResponse update(@Valid @RequestBody TaskDto taskDto){
        taskService.update(taskMapper.toEntityForUpdate(taskDto));
        return new RestResponse("Updated");
    }





}
