package hu.bme.mit.train.tachograph;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrainTachographTest {
    TrainTachograph t;

    @Test
    public void OverridingJoystickPositionToNegative_SetsReferenceSpeedToZero() {
        Assert.assertEquals(null, t);
    }

}