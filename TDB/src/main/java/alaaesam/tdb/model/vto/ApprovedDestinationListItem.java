package alaaesam.tdb.model.vto;

import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApprovedDestinationListItem {
    private Long id;
    private String name;
    private String region;
    private String flag;
    private Long population;
    private List<String> capitals;
    private List<String> currencies;
}
