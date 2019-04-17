package ru.itis.batmandbboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.batmandbboot.models.Expenses;

public interface ExpensesRepository extends JpaRepository<Expenses, Long> {
}
