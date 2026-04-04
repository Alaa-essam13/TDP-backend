package alaaesam.tdb.api.service;

import alaaesam.tdb.model.vto.ApprovedDestinationResultSet;
import alaaesam.tdb.model.dto.DestinationDTO;
import alaaesam.tdb.model.vto.DestinationVTO;
import alaaesam.tdb.model.vto.DestinationsResultSet;

import java.util.List;

public interface DestinationService {
    DestinationsResultSet getAllDestinations(Integer page,Integer size);
    void approveDestinations(List<DestinationDTO> destinationDTO);
    void removeDestination(Long destinationId);
    ApprovedDestinationResultSet getAllApprovedDestinations(String quickSearch,Integer page,Integer size);
    DestinationVTO getDestination(Long destinationId);
}
