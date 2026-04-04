package alaaesam.tdb.model.vto;

import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DestinationVTO {
    private Long id;
    private String flag;
    private String name;
    private List<String> capitals;
    private List<String> currencies;
    private String region;
    private Long population;
}
