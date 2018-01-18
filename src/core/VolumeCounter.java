package core;

import java.io.Serializable;
import java.math.BigDecimal;

public class VolumeCounter implements Serializable {

    static final long serialVersionUID = 573;

    private BigDecimal previousValue;
    private BigDecimal presentValue;

    VolumeCounter(BigDecimal previousValue, BigDecimal presentValue) {
        if (previousValue.compareTo(presentValue) > 0) {
            throw new IllegalArgumentException("Incorrect input, previous is bigger of present");
        }
        this.previousValue = previousValue;
        this.presentValue = presentValue;
    }

    public BigDecimal getVolume() {
        return presentValue.subtract(previousValue);
    }

    @Override
    public String toString() {
        return "VolumeCounter{" +
                "previousValue=" + previousValue +
                ", presentValue=" + presentValue +
                '}';
    }
}
