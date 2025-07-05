package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "batsmen", uniqueConstraints = @UniqueConstraint(columnNames = "batsmanName"))
public class Batsman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long batsmanId;

    @NotBlank(message = "Batsman name cannot be blank")
    private String batsmanName;

    @Min(value = 1, message = "Batting position must be at least 1")
    @Max(value = 11, message = "Batting position must be at most 11")
    private Integer battingPosition;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonBackReference
    private Team team;
}