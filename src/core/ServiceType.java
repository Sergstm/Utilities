package core;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ServiceType implements Service {

    private BigDecimal prev;
    private BigDecimal pres;
    private VolumeCounter volumeCounter;
    private LocalDateTime date;

    ServiceType(BigDecimal prev, BigDecimal pres) {
        if (prev.signum() < 0 || pres.signum() < 0) {
            throw new IllegalArgumentException("Negative values");
        }
        this.prev = prev;
        this.pres = pres;
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
        return null;
    }

    @Override
    public String toString() {
        return "EasyService{" +
                "prev=" + prev +
                ", pres=" + pres +
                ", volumeCounter=" + volumeCounter +
                ", date=" + date +
                '}';
    }
}
