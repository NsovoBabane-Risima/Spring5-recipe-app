package guru.springframework.spring5recipeapp.service;

import guru.springframework.spring5recipeapp.commads.UnitOfMeasureCommand;

import java.util.Set;

public interface UnitOfMeasureService {
    Set<UnitOfMeasureCommand> listUoms();
}
