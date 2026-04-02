package alaaesam.tdb.core.mapper;

import alaaesam.tdb.model.dto.RegisterUserDTO;
import alaaesam.tdb.model.entity.User;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        builder = @Builder(disableBuilder = true)
)
@MapperConfig(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface GeneralMapper {

    User toUser(RegisterUserDTO registerUserDTO);
}
