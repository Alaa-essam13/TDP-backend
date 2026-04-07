package alaaesam.tdb.core.controller;

import alaaesam.tdb.api.service.DestinationService;
import alaaesam.tdb.model.vto.ApprovedDestinationResultSet;
import alaaesam.tdb.model.dto.DestinationDTO;
import alaaesam.tdb.model.vto.DestinationVTO;
import alaaesam.tdb.model.vto.DestinationsResultSet;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@AllArgsConstructor
@RequestMapping("/destinations")
public class DestinationController {
    private final DestinationService destinationService;

    @GetMapping
    @Secured("ADMIN")
    public ResponseEntity<DestinationsResultSet> getDestinations(@Min(0)@RequestParam(defaultValue = "0") Integer page
            ,@Min(0)@RequestParam(defaultValue = "10") Integer size) {
        return ResponseEntity.ok(destinationService.getAllDestinations(page,size));
    }

    @PostMapping("/approve")
    @Secured("ADMIN")
    public ResponseEntity<Void> approveDestinations(@RequestBody List<DestinationDTO> destinationDTO){
        destinationService.approveDestinations(destinationDTO);
        for (int i = 0; i <destinationDTO.size(); i++) {
            System.out.println(destinationDTO.get(i).toString());
        }
        return ResponseEntity.status(CREATED).build();
    }

    @DeleteMapping("/approved/{destinationId}")
    @Secured("ADMIN")
    public ResponseEntity<Void> deleteDestination(@PathVariable("destinationId") Long destinationId){
        destinationService.removeDestination(destinationId);
        return ResponseEntity.status(NO_CONTENT).build();
    }

    @GetMapping("/approved/{destinationId}")
    @Secured({"ADMIN","USER"})
    public ResponseEntity<DestinationVTO> getDestination(@PathVariable("destinationId") Long destinationId){
        return ResponseEntity.ok(destinationService.getDestination(destinationId));
    }

    @GetMapping("/approved")
    @Secured({"ADMIN","USER"})
    public ResponseEntity<ApprovedDestinationResultSet> getApprovedDestinations(@RequestParam(name = "search",defaultValue = "") String quickSearch
            ,@Min(0)@RequestParam(name = "page", defaultValue = "0") Integer page
            , @Min(0)@RequestParam(name = "size", defaultValue = "10") Integer size){
        return ResponseEntity.ok(destinationService.getAllApprovedDestinations(quickSearch,page,size));
    }
}
