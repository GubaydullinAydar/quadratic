package ru.axiomatics.quadratic.services;

import ru.axiomatics.quadratic.dto.AnswersDto;
import ru.axiomatics.quadratic.dto.CoefficientsDto;

public interface CoefficientsAndAnswersService {
    AnswersDto getAnswersAndSave(CoefficientsDto coefficientsDto);
}
