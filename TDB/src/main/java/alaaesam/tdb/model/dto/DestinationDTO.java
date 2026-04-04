package alaaesam.tdb.model.dto;


import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DestinationDTO {
    private String name;
    private String region;
    private String flag;
    private Long population;
    private List<String> capitals;
    private List<String> currencies;
}
