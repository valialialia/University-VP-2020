package com.botscrew.univ.services.impl;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.botscrew.univ.models.impl.Lector;
import com.botscrew.univ.repositories.LectorRepository;
import com.botscrew.univ.services.ILectorService;
import org.springframework.beans.factory.annotation.Autowired;

public class LectorService implements ILectorService {

    private final LectorRepository lectorRepository;

    @Autowired
    public LectorService(LectorRepository lectorRepository) {
        this.lectorRepository = lectorRepository;
    }

    @Override
    public List<Lector> getLectorLike(String nameLike) {

            return StreamSupport
                    .stream(lectorRepository.findAll().spliterator(), false)
                    .filter(lector -> Pattern.matches(nameLike, lector.getFirstName()))
                    .filter(lector -> Pattern.matches(nameLike, lector.getLastName()))
                    .collect(Collectors.toList());

    }
}
