package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.models.Subject;
import ru.itis.repositories.SubjectsRepositoryJdbcImpl;

import java.util.List;

public class SearchServiceImpl implements SearchService {
    @Autowired
    SubjectsRepositoryJdbcImpl subjectRepository;

    public SearchServiceImpl(SubjectsRepositoryJdbcImpl subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Subject> searchSubject(String alias) {
        return subjectRepository.findAllByAlias(alias);
    }
}
