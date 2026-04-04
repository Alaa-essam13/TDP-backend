package alaaesam.tdb.core.mapper;

import alaaesam.tdb.model.vto.ApprovedDestinationListItem;
import alaaesam.tdb.model.dto.DestinationDTO;
import alaaesam.tdb.model.dto.RegisterUserDTO;
import alaaesam.tdb.model.entity.Destination;
import alaaesam.tdb.model.entity.User;
import alaaesam.tdb.model.vto.DestinationVTO;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        builder = @Builder(disableBuilder = true)
)
@MapperConfig(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface GeneralMapper {

    User toUser(RegisterUserDTO registerUserDTO);
    Destination toDestination(DestinationDTO destinationDTO);
    List<Destination> toDestinations(List<DestinationDTO> destinationDTO);
    ApprovedDestinationListItem toApprovedDestinationListItem(Destination destination);
    List<ApprovedDestinationListItem> toApprovedDestinationList(List<Destination> content);

    DestinationVTO toDestinationVTO(Destination destination);
}
