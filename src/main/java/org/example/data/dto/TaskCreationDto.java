package org.example.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.example.util.Status;

@Data
public class TaskCreationDto {
    @NotEmpty(message = "Can't be empty")
    private String description;
    private Status status;

}
