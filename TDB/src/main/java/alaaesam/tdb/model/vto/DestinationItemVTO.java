package alaaesam.tdb.model.vto;

import lombok.*;

import java.util.List;
import java.util.Map;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DestinationItemVTO {
    private String flag;
    private NameVTO name;
    private List<String> capital;
    private Map<String, CurrencyVTO> currencies;
    private String region;
    private Long population;
    private Boolean approved;
}
