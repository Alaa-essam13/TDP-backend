package alaaesam.tdb.lib;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
@Data
public class CommonData {
    private Long userId;
}
