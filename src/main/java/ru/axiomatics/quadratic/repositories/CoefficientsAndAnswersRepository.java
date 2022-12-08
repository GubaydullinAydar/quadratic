package ru.axiomatics.quadratic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.axiomatics.quadratic.models.CoefficientsAndAnswers;

import java.util.UUID;

public interface CoefficientsAndAnswersRepository extends JpaRepository<CoefficientsAndAnswers, UUID> {
}
