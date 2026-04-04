package alaaesam.tdb.model.vto;

import lombok.*;

import java.util.Map;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NameVTO {
    private String common;
    private String official;
    private Map<String,NativeNameVTO> nativeName;
}
