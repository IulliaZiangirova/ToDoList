package org.example.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.data.dto.RestResponse;
import org.example.data.dto.TaskCreationDto;
import org.example.data.dto.TaskDto;
import org.example.service.TaskService;
import org.example.util.mapper.TaskMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @GetMapping//без value найдет всех players
    @ResponseStatus(HttpStatus.OK)
    public RestResponse findAll() {
        return new RestResponse(taskService.findAll());
    }

    @GetMapping("/{id}")//передача динамич айди - @PathVariable
    public RestResponse findById(@PathVariable String id) {
        return new RestResponse(taskMapper.toDto(taskService.findById(id)));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestResponse create(@RequestBody @Valid TaskCreationDto taskCreationDto) {
        taskService.save(taskMapper.toEntity(taskCreationDto));
        return new RestResponse("Created");
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RestResponse deleteById(@PathVariable String id) {
        taskService.deleteById(id);
        return new RestResponse("Deleted");
    }





}
