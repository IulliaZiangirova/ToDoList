package org.example.data.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.example.util.Status;

@Data
public class TaskDto {

    private int id;
    private String description;
    private Status status;
}
