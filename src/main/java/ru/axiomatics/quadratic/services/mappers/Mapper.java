package ru.axiomatics.quadratic.services.mappers;

import ru.axiomatics.quadratic.dto.AnswersDto;
import ru.axiomatics.quadratic.dto.CoefficientsDto;
import ru.axiomatics.quadratic.models.CoefficientsAndAnswers;

public class Mapper {
    public static CoefficientsAndAnswers mapCoefficientDtoAndAnswerDtoToCoefficientsAndAnswersModel(CoefficientsDto coefficientsDto, AnswersDto answersDto) {
        CoefficientsAndAnswers coefficientsAndAnswers = new CoefficientsAndAnswers();
        coefficientsAndAnswers.setA(coefficientsDto.getA());
        coefficientsAndAnswers.setB(coefficientsAndAnswers.getB());
        coefficientsAndAnswers.setC(coefficientsAndAnswers.getC());
        coefficientsAndAnswers.setX1(answersDto.getX1());
        coefficientsAndAnswers.setX2(answersDto.getX2());
        return coefficientsAndAnswers;
    }
}
