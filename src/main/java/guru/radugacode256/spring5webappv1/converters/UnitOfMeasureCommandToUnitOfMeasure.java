package guru.radugacode256.spring5webappv1.converters;

import guru.radugacode256.spring5webappv1.commands.UnitOfMeasureCommand;
import guru.radugacode256.spring5webappv1.model.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure  implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand unitOfMeasureCommand) {

        if (unitOfMeasureCommand != null){

            UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
            unitOfMeasure.setId(unitOfMeasureCommand.getId());
            unitOfMeasure.setDescription(unitOfMeasureCommand.getDescription());

            return unitOfMeasure;
        }
        return null;
    }
}
