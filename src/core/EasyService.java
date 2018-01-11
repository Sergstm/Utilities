package core;

import java.math.BigDecimal;

class EasyService extends ServiceType {

    EasyService(BigDecimal prev, BigDecimal pres, BigDecimal tariff) {
        super(prev, pres, tariff);
        if (prev.signum() < 0 || pres.signum() < 0 || tariff.signum() < 0) {
            throw new IllegalArgumentException("Negative values or tariff");
        }
    }
}
