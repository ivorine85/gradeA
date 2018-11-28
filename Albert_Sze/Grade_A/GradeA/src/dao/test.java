package dao;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class test {


    public static void main(String[] args) {
        String time = "13:32";
        System.out.println(Time.valueOf(time));
    }
}
