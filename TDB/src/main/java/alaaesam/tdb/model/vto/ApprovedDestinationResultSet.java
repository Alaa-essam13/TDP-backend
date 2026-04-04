package alaaesam.tdb.model.vto;


import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApprovedDestinationResultSet {
    private List<ApprovedDestinationListItem> items;
    private Long total;
}
