package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.example.util.Status;

@Data
public class TaskCreationDto {
    @NotBlank
    private String description;
    @NotBlank
    private Status status;

}
