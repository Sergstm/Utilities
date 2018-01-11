package core;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ServiceType implements Service {

    private BigDecimal prev;
    private BigDecimal pres;
    private VolumeCounter volumeCounter;
    private BigDecimal tariff;
    private LocalDateTime date;

    ServiceType(BigDecimal prev, BigDecimal pres, BigDecimal tariff) {
        this.prev = prev;
        this.pres = pres;
        this.volumeCounter = new VolumeCounter(prev, pres);
        this.tariff = tariff;
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
        return tariff.multiply(getVolume())
                .setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public String toString() {
        return "ServiceType{" +
                "prev=" + prev +
                ", pres=" + pres +
                ", volumeCounter=" + volumeCounter +
                ", tariff=" + tariff +
                ", date=" + date +
                '}';
    }
}
