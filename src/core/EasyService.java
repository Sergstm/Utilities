package core;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EasyService implements Service {

    private BigDecimal prev;
    private BigDecimal pres;
    private BigDecimal tariff;
    private VolumeCounter volumeCounter;
    private LocalDateTime date;

    EasyService(BigDecimal prev, BigDecimal pres, BigDecimal tariff) {
        if (prev.signum() < 0 || pres.signum() < 0 || tariff.signum() < 0) {
            throw new IllegalArgumentException("Negative values or tariff");
        }
        this.prev = prev;
        this.pres = pres;
        this.tariff = tariff;
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
        return tariff.multiply(volumeCounter.getVolume())
                .setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public String toString() {
        return "EasyService{" +
                "prev=" + prev +
                ", pres=" + pres +
                ", tariff=" + tariff +
                ", volumeCounter=" + volumeCounter +
                ", date=" + date +
                '}';
    }
}
