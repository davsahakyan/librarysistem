package com.librarysystem;

import java.text.SimpleDateFormat;
import java.util.*;

public class DateHandler {

    public String currentDate() {
        Calendar currentCal = new GregorianCalendar();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setTimeZone(currentCal.getTimeZone());
        return dateFormat.format(currentCal.getTime());
    }

    public String expirationDate() {
        Calendar expirationCal = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        expirationCal.add(Calendar.DAY_OF_MONTH, 14);
        sdf.setTimeZone(expirationCal.getTimeZone());
        return sdf.format(expirationCal.getTime());
    }


}
