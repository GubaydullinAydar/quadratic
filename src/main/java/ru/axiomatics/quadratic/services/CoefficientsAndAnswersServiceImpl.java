package ru.axiomatics.quadratic.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.axiomatics.quadratic.controllers.exceptions.DiscriminantLessZeroException;
import ru.axiomatics.quadratic.dto.AnswersDto;
import ru.axiomatics.quadratic.dto.CoefficientsDto;
import ru.axiomatics.quadratic.repositories.CoefficientsAndAnswersRepository;

import static ru.axiomatics.quadratic.services.mappers.Mapper.mapCoefficientDtoAndAnswerDtoToCoefficientsAndAnswersModel;

@Service
@RequiredArgsConstructor
public class CoefficientsAndAnswersServiceImpl implements CoefficientsAndAnswersService {

    private final CoefficientsAndAnswersRepository coefficientsAndAnswersRepository;

    @Override
    public AnswersDto getAnswersAndSave(CoefficientsDto coefficientsDto) {
        AnswersDto answersDto = answersCalculation(coefficientsDto);

        coefficientsAndAnswersRepository.save(
                mapCoefficientDtoAndAnswerDtoToCoefficientsAndAnswersModel(coefficientsDto, answersDto)
        );

        return answersDto;
    }

    private AnswersDto answersCalculation(CoefficientsDto coefficientsDto) {
        double x1;
        double x2;
        double a = coefficientsDto.getA();
        double b = coefficientsDto.getB();
        double c = coefficientsDto.getC();

        double discriminant = b * b - 4 * a * c;

        if (discriminant == 0) {
            x1 = (-b) / (2 * a);
            x2 = x1;
        } else if (discriminant > 0) {
            x1 = (-b - Math.sqrt(discriminant)) / (2 * a);
            x2 = (-b + Math.sqrt(discriminant)) / (2 * a);
        } else {
            throw new DiscriminantLessZeroException("No solution discriminant less than zero");
        }

        return new AnswersDto(x1, x2);
    }
}
