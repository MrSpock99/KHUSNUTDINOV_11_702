package ru.itis.batmandbboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.batmandbboot.models.Subject;
import ru.itis.batmandbboot.repositories.SubjectRepository;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    SubjectRepository subjectRepository;

    public SearchServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Subject> searchSubject(String alias) {
        List<Subject> list = subjectRepository.getAllByAliasContainingIgnoreCase(alias);
        return subjectRepository.getAllByAliasContainingIgnoreCase(alias);
    }
}
