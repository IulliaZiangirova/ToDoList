package org.example.dao;

import org.example.data.entity.Task;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, String> {

    @Query("select t from Task t")
    List<Task> findAll(PageRequest pageRequest);
}
