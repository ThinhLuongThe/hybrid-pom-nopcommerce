package testJava;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class testJavaDate {

    public static void main(String[] args) {
        String[] dateList = {"11/10/1987", "17/02/1989", "14/02/2020", "31/09/2017",
                "Aug 02, 2020", "Aug 05 2020",
                "01 September 2021", "24 December, 2020"};
        ArrayList actualList = new ArrayList();
        int i;
        Object date;


        System.out.println("\nList before sorting");
        for (i = 0; i < dateList.length; i++) {
            date = parseStringToDate(dateList[i]);
            actualList.add(date);
            System.out.println(date);
        }

        System.out.println("\nList after sorting");
        Collections.sort(actualList);
        for (i = 0; i < actualList.size(); i++) {
            System.out.println(actualList.get(i));
        }
    }

    public static Date parseStringToDate(String dateInString) {
        SimpleDateFormat formater = null;
        try {
            if (dateInString.contains(",")) {
                dateInString = dateInString.replace(",", "");
            }
            if (dateInString.contains("/")) {
                formater = new SimpleDateFormat("dd/MM/yyyy");
            } else if (dateInString.length() == 11) {
                formater = new SimpleDateFormat("MMM dd yyyy");
            } else {
                formater = new SimpleDateFormat("dd MMMM yyyy");
            }
        } catch (Exception e) {
            System.out.println("Format is not correct" + e.getMessage());
        }

        Date date = null;
        try {
            date = formater.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
