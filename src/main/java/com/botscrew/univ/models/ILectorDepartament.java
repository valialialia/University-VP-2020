package com.botscrew.univ.models;

import com.botscrew.univ.models.impl.Departament;
import com.botscrew.univ.models.impl.Lector;

public interface ILectorDepartament {

    Lector getLector();

    Departament getDepartament();
}
