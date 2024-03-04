package org.example.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.util.Status;


@Data
@Entity
@Table(schema = "todo", name = "task")
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Task(String description, Status status) {
        this.description = description;
        this.status = status;
    }

}
