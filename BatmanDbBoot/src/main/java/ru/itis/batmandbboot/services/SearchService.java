package ru.itis.batmandbboot.services;


import ru.itis.batmandbboot.models.Subject;

import java.util.List;

public interface SearchService {
    public List<Subject> searchSubject(String alias);
}
