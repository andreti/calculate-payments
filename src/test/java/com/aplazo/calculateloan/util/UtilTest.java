package com.aplazo.calculateloan.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UtilTest {

    @Test
    public void addWeekTest() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2022);
        calendar.set(Calendar.MONTH, 2);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        Date now = calendar.getTime();

        now = Util.addWeek(now);

        assertTrue(now.after(calendar.getTime()));

    }

    @Test
    public void calculatePayTest() {
        Double value = Util.calculatePay(500000.0, 2.0, 5);
        assertEquals(value, 110000.0);
    }
}
