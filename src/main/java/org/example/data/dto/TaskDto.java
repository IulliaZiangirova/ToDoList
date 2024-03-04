package org.example.data.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.util.Status;

@Data
public class TaskDto {

    @Min(value = 1, message = "Invalid id")
    private int id;
    private String description;
    private Status status;
}
