package com.web.recipes.services;

import com.web.recipes.commands.UnitOfMeasureCommand;
import com.web.recipes.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.web.recipes.repositories.reactive.UnitOfMeasureReactiveRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


/**
 * @author martsiomchyk
 */
@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {
    private final UnitOfMeasureReactiveRepository unitOfMeasureReactiveRepositoryRepository;
    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    public UnitOfMeasureServiceImpl(UnitOfMeasureReactiveRepository unitOfMeasureReactiveRepositoryRepository, UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
        this.unitOfMeasureReactiveRepositoryRepository = unitOfMeasureReactiveRepositoryRepository;
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
    }

    @Override
    public Flux<UnitOfMeasureCommand> listAllUoms() {
        return unitOfMeasureReactiveRepositoryRepository.findAll()
                .map(unitOfMeasureToUnitOfMeasureCommand::convert);
    }
}
