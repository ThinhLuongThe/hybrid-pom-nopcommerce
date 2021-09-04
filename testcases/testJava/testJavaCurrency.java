package testJava;

import java.util.ArrayList;
import java.util.Collections;

public class testJavaCurrency {
    public static void main(String[] args) {
        String VND = "14.500.000 ₫";
        String VND2 = "14,500,000 VNĐ";
        String price_before = "$1,029.6";
        String price_after = "$1,029.59";

        ArrayList sortedList = new ArrayList();
        Object One = parsePriceOnCurrency(price_before, "$");
        Object True = parsePriceOnCurrency(price_after, "$");
        sortedList.add(One);
        sortedList.add(True);
        Collections.sort(sortedList);


        Object before, after;
        before = parsePriceOnCurrency(price_before, "$");
        after = parsePriceOnCurrency(price_after, "$");
        if ((float) before < (float) after) {
            System.out.println(before + "<" + after);
        } else {
            System.out.println("Condition = False");
            System.out.println(before + ">" + after);
        }
        System.out.println("List price is sorted: " + sortedList);
    }

    public static Object parsePriceOnCurrency(String targetPrice, String currency) {
        switch (currency) {
            case "₫":
                return Long.parseLong(targetPrice.replace("₫", "").replace(".", "").replace(",", "").trim());
            case "$":
                return Float.parseFloat(targetPrice.replace("$", "").replace(",", "").trim());
            case "€":
                return Float.parseFloat(targetPrice.replace("€", "").replace(",", "").trim());
            default:
                return Long.parseLong(targetPrice.replace("VNĐ", "").replace(".", "").replace(",", "").trim());
        }
    }
}
