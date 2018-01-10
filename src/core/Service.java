package core;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface Service {

    BigDecimal getVolume();
    LocalDateTime getDate();
    BigDecimal getSum();
}
