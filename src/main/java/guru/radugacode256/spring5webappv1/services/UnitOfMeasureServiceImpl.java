package guru.radugacode256.spring5webappv1.services;

import guru.radugacode256.spring5webappv1.Repositories.UnitOfMeasureRepository;
import guru.radugacode256.spring5webappv1.commands.UnitOfMeasureCommand;
import guru.radugacode256.spring5webappv1.converters.UnitOfMeasureToUnitOfMeasureCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository, UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
    }


    @Override
    public Set<UnitOfMeasureCommand> listAllUom() {
        return StreamSupport.stream(unitOfMeasureRepository.findAll()
                    .spliterator(), false)
                    .map(unitOfMeasureToUnitOfMeasureCommand::convert)
                    .collect(Collectors.toSet());
    }
}
