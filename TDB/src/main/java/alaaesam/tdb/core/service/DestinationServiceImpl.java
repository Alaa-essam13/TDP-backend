package alaaesam.tdb.core.service;

import alaaesam.tdb.api.repository.DestinationRepository;
import alaaesam.tdb.api.service.DestinationService;
import alaaesam.tdb.core.mapper.GeneralMapper;
import alaaesam.tdb.lib.error.AppException;
import alaaesam.tdb.model.vto.ApprovedDestinationListItem;
import alaaesam.tdb.model.vto.ApprovedDestinationResultSet;
import alaaesam.tdb.model.dto.DestinationDTO;
import alaaesam.tdb.model.entity.Destination;
import alaaesam.tdb.model.vto.DestinationItemVTO;
import alaaesam.tdb.model.vto.DestinationVTO;
import alaaesam.tdb.model.vto.DestinationsResultSet;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static alaaesam.tdb.lib.error.Error.DESTINATION_ALREADY_EXIST;
import static alaaesam.tdb.lib.error.Error.DESTINATION_NOT_FOUND;

@Service
@AllArgsConstructor
public class DestinationServiceImpl implements DestinationService {
    private final RestClient restClient;
    private final GeneralMapper mapper;
    private final DestinationRepository destinationRepository;

    @Override
    public DestinationsResultSet getAllDestinations(Integer page, Integer size) {
        List<DestinationItemVTO> response = restClient
                .get()
                .retrieve()
                .body(new ParameterizedTypeReference<List<DestinationItemVTO>>() {
                });

        if (response == null || response.isEmpty()) {
            return DestinationsResultSet.builder()
                    .items(List.of())
                    .total(0).build();
        }
        List<Destination> oldDestinations = destinationRepository.selectAll();
        Set<String> existingNames = oldDestinations.stream()
                .map(Destination::getName)
                .map(String::toLowerCase)
                .collect(Collectors.toSet());

        response.forEach(destination -> {
            String name = destination.getName().getOfficial().toLowerCase();
            destination.setApproved(existingNames.contains(name));
        });

        Integer start = page * size;
        Integer end = Math.min(start + size, response.size());
        if (start >= response.size()) {
            return DestinationsResultSet.builder()
                    .items(List.of())
                    .total(0).build();
        }
        List<DestinationItemVTO> paginatedList = response.subList(start, end);
        return DestinationsResultSet.builder()
                .items(paginatedList)
                .total(response.size())
                .build();
    }

    @Override
    @Transactional
    public void approveDestinations(List<DestinationDTO> destinationDTO) {
        List<Destination> destinations = mapper.toDestinations(destinationDTO);
        List<Destination> oldDestinations = destinationRepository.selectAll();
        Set<String> existingNames = oldDestinations.stream()
                .map(Destination::getName)
                .map(String::toLowerCase)
                .collect(Collectors.toSet());

        destinations.forEach(destination -> {
            if (existingNames.contains(destination.getName().toLowerCase()))
                throw new AppException(DESTINATION_ALREADY_EXIST);
        });
        destinationRepository.insertAll(destinations);
    }

    @Override
    public void removeDestination(Long destinationId) {
        Destination destination = destinationRepository.selectById(destinationId)
                .orElseThrow(() -> new AppException(DESTINATION_NOT_FOUND));
        destinationRepository.delete(destination);
    }

    @Override
    public ApprovedDestinationResultSet getAllApprovedDestinations(String quickSearch, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Destination> destinations = destinationRepository.selectAll(quickSearch, pageable);
        List<ApprovedDestinationListItem> result = mapper.toApprovedDestinationList(destinations.getContent());
        return ApprovedDestinationResultSet.builder()
                .items(result)
                .total(destinations.getTotalElements())
                .build();
    }

    @Override
    public DestinationVTO getDestination(Long destinationId) {
        Destination destination = destinationRepository.selectById(destinationId)
                .orElseThrow(() -> new AppException(DESTINATION_NOT_FOUND));

        return mapper.toDestinationVTO(destination);
    }
}
