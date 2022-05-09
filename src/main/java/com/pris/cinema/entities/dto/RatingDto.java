package com.pris.cinema.entities.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Accessors(chain = true)
@Getter
@Setter
public class RatingDto {

    @Min(value = 1, message = "Rating must be between 1 and 5.")
    @Max(value = 5, message = "Rating must be between 1 and 5.")
    @NotBlank(message = "Please enter a rating")
    protected Integer rating;

    protected Long movieId;

}
