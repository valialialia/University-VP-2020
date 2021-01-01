package com.botscrew.univ.services;

import java.util.List;

import com.botscrew.univ.models.impl.Lector;

public interface ILectorService {

    List<Lector> getLectorLike(String nameLike);
}
