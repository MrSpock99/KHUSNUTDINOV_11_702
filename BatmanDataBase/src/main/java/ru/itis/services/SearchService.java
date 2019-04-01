package ru.itis.services;

import ru.itis.models.Subject;

import java.util.List;

public interface SearchService {
    public List<Subject> searchSubject(String alias);
}
