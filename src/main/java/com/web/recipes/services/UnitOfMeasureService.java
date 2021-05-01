package com.web.recipes.services;

import com.web.recipes.commands.UnitOfMeasureCommand;

import java.util.Set;

/**
 * @author martsiomchyk
 */

public interface UnitOfMeasureService {
    Set<UnitOfMeasureCommand> listAllUoms();

}
