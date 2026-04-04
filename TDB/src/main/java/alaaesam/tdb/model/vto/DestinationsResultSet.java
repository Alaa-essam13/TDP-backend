package alaaesam.tdb.model.vto;

import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DestinationsResultSet {
    private List<DestinationItemVTO> items;
    private Integer total;
}
