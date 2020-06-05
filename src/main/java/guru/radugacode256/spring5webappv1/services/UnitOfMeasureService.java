package guru.radugacode256.spring5webappv1.services;

import guru.radugacode256.spring5webappv1.commands.UnitOfMeasureCommand;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UnitOfMeasureService {

    // Listing all unitsOfMeasure
    Set<UnitOfMeasureCommand> listAllUom();
}
