package ru.axiomatics.quadratic.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.axiomatics.quadratic.dto.AnswersDto;
import ru.axiomatics.quadratic.dto.CoefficientsDto;
import ru.axiomatics.quadratic.services.CoefficientsAndAnswersService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/answer")
@Tag(name = "Answers for quadratic equation")
public class AnswersRestController {

    private final CoefficientsAndAnswersService coefficientsAndAnswersService;

    @Operation(summary = "Get answers for quadratic equation", description = "")
    @GetMapping(value = "")
    public AnswersDto getAnswers(@RequestBody CoefficientsDto coefficientsDto) {
        return coefficientsAndAnswersService.getAnswersAndSave(coefficientsDto);
    }
}
