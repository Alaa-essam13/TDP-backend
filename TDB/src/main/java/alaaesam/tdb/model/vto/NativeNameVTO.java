package alaaesam.tdb.model.vto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NativeNameVTO {
    private String official;
    private String common;
}
