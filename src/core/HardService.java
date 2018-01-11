package core;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class HardService implements Service {

    private BigDecimal prev;
    private BigDecimal pres;
    private BigDecimal tariff1;
    private BigDecimal tariff2;
    private VolumeCounter volumeCounter;
    private LocalDateTime date;

    HardService(BigDecimal prev, BigDecimal pres, BigDecimal tariff1, BigDecimal tariff2) {
        if (prev.signum() < 0 || pres.signum() < 0
                || tariff1.signum() < 0 || tariff1.signum() < 0) {
            throw new IllegalArgumentException("Negative values or tariffs");
        }
        this.prev = prev;
        this.pres = pres;
        this.tariff1 = tariff1;
        this.tariff2 = tariff2;
        this.volumeCounter = new VolumeCounter(prev, pres);
        this.date = LocalDateTime.now();
    }

    @Override
    public BigDecimal getVolume() {
        return volumeCounter.getVolume();
    }

    @Override
    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public BigDecimal getSum() {
        BigDecimal sum, result;
        if (getVolume().compareTo(new BigDecimal("100")) < 1) {
            result = getVolume().multiply(tariff1);
        } else {
            BigDecimal res = new BigDecimal("100").multiply(tariff1);
            BigDecimal reminder = getVolume().subtract(new BigDecimal("100"));
            sum = reminder.multiply(tariff2).setScale(2, BigDecimal.ROUND_HALF_UP);
            result = res.add(sum);
        }
        return result;
    }

    @Override
    public String toString() {
        return "HardService{" +
                "prev=" + prev +
                ", pres=" + pres +
                ", tariff1=" + tariff1 +
                ", tariff2=" + tariff2 +
                ", volumeCounter=" + volumeCounter +
                ", date=" + date +
                '}';
    }
}
