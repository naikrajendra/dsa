package com.rpk.dsa.practice;

public class TimeConversion {

        public static String timeConversion(String s) {
        // Write your code here
        // Break string into multi-part e.g. 12:01:00PM, 12:01:00AM, 07:05:45PM
        // 11:59:59PM, 04:59:59AM, 06:40:03AM
        String hour = s.substring(0, 2); // 11
        //System.out.println(hour);
        String minss = s.substring(2, 8); // :59:59
        //System.out.println(minss);
        String ampm = s.substring(8, 10); // PM
        //System.out.println(ampm);
        String newHr = new String();

        // 1:00:00 PM 13:00:00
        // if it is PM and hour is between 1-11 then add 12 to it
        if(ampm.equalsIgnoreCase("PM")) {
            int hr = Integer.parseInt(hour); //11
            if(hr < 12 && hr > 0 ) {
                hr = hr + 12; // 23
                newHr = Integer.toString(hr);
            } else newHr = hour; // 12
        } else if (ampm.equalsIgnoreCase("AM")) {
            int hr = Integer.parseInt(hour); // 4
            if(hr == 12) 
                newHr = "00";
            else newHr = hour;                
        }
        // 12:01:00 AM will become 00:01:00, 3:01:00 AM 
        // if is is AM and hour is 12 then substract 12 from it.
        // Dont change min:ss
        // construct new string
        String newTime = newHr + minss; // '12' + ':01:00', "00" + ':01:00'
        return newTime;

    }

    public static void main(String[] args) {
        String time1 = "12:01:00PM";
        String time2 = "12:01:00AM";
        String time3 = "07:05:45PM";
        String time4 = "11:59:59PM";
        String time5 = "04:59:59AM";
        String time6 = "06:40:03AM";

        System.out.println(timeConversion(time1)); // 12:01:00
        System.out.println(timeConversion(time2)); // 00:01:00
        System.out.println(timeConversion(time3)); // 19:05:45
        System.out.println(timeConversion(time4)); // 23:59:59
        System.out.println(timeConversion(time5)); // 04:59:59
        System.out.println(timeConversion(time6)); // 06:40:03
    }

}
