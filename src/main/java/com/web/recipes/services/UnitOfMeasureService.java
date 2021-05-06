package com.web.recipes.services;

import com.web.recipes.commands.UnitOfMeasureCommand;
import reactor.core.publisher.Flux;


/**
 * @author martsiomchyk
 */

public interface UnitOfMeasureService {
    Flux<UnitOfMeasureCommand> listAllUoms();

}
