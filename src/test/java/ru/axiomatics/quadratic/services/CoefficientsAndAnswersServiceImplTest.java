package ru.axiomatics.quadratic.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.axiomatics.quadratic.controllers.exceptions.DiscriminantLessZeroException;
import ru.axiomatics.quadratic.dto.AnswersDto;
import ru.axiomatics.quadratic.dto.CoefficientsDto;
import ru.axiomatics.quadratic.repositories.CoefficientsAndAnswersRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CoefficientsAndAnswersServiceImplTest {

    @Autowired
    CoefficientsAndAnswersService coefficientsAndAnswersService;

    @MockBean
    CoefficientsAndAnswersRepository coefficientsAndAnswersRepository;


    @Test
    void shouldReturnX1EqualsX2() {
        AnswersDto answersDto = coefficientsAndAnswersService.getAnswersAndSave(new CoefficientsDto(3, -18, 27));
        assertEquals(answersDto.getX1(), answersDto.getX2());
    }

    @Test
    void shouldReturnX1NotEqualsX2() {
        AnswersDto answersDto = coefficientsAndAnswersService.getAnswersAndSave(new CoefficientsDto(4, 64, 0));
        assertNotEquals(answersDto.getX1(), answersDto.getX2());
        assertEquals(-16.0D, answersDto.getX1());
        assertEquals(0, answersDto.getX2());
    }

    @Test
    void shouldThrowDiscriminantLessZeroException() {
        Exception exception = assertThrows(DiscriminantLessZeroException.class,
                () -> coefficientsAndAnswersService.getAnswersAndSave(new CoefficientsDto(9, 6, 2)));
        assertEquals("No solution discriminant less than zero", exception.getMessage());
    }
}