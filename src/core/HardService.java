package core;

import java.math.BigDecimal;

public class HardService extends ServiceType {

    private BigDecimal tariff1;
    private BigDecimal tariff2;

    HardService(BigDecimal prev, BigDecimal pres, BigDecimal tariff1, BigDecimal tariff2) {
        super(prev, pres);
        if (prev.signum() < 0 || pres.signum() < 0
                || tariff1.signum() < 0 || tariff2.signum() < 0) {
            throw new IllegalArgumentException("Negative values or tariffs");
        }
        this.tariff1 = tariff1;
        this.tariff2 = tariff2;
    }

    @Override
    public BigDecimal getSum() {
        BigDecimal sum, result;
        if (super.getVolume().compareTo(new BigDecimal("100")) < 1) {
            result = super.getVolume().multiply(tariff1);
        } else {
            result = new BigDecimal("100").multiply(tariff1);
            BigDecimal reminder = super.getVolume().subtract(new BigDecimal("100"));
            sum = reminder.multiply(tariff2).setScale(2, BigDecimal.ROUND_HALF_UP);
            result = result.add(sum);
        }
        return result;
    }
}
