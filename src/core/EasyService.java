package core;

import java.math.BigDecimal;

public class EasyService extends ServiceType {

    private BigDecimal tariff;

    EasyService(BigDecimal prev, BigDecimal pres, BigDecimal tariff) {
        super(prev, pres);
        if (prev.signum() < 0 || pres.signum() < 0 || tariff.signum() < 0) {
            throw new IllegalArgumentException("Negative values or tariff");
        }
        this.tariff = tariff;
    }

    @Override
    public BigDecimal getSum() {
        return tariff.multiply(super.getVolume())
                .setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
