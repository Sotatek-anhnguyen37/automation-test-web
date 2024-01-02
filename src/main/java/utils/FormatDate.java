package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDate {
    public static boolean statusOfSortDate(String dateString1, String dateString2, String pattern){
        try{
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            Date date1 = format.parse(convertDate(dateString1));
            Date date2 = format.parse(convertDate(dateString2));
            return date1.compareTo(date2)<=0;
        }catch(ParseException e){
            System.out.println(e.getMessage());
        }
        return true;
    }
    public static String convertDate(String dateString){
        String[] temp = dateString.split(" ");
        String month = convertMonth(temp[1]);
        String day = temp[2].substring(0, temp[2].length() - 2);
        return  month + "-" + day+ "-" +temp[0];
    }
    public static String convertMonth(String month){
        String numberMonth;
        switch (month){
            case "December":
                numberMonth = "12";
                break;
            case "November":
                numberMonth = "11";
                break;
            case "October":
                numberMonth = "10";
                break;
            case "September":
                numberMonth = "9";
                break;
            case "August":
                numberMonth = "8";
                break;
            case "July":
                numberMonth = "7";
                break;
            case "June":
                numberMonth = "6";
                break;
            case "May":
                numberMonth = "5";
                break;
            case "April":
                numberMonth = "4";
                break;
            case "March":
                numberMonth = "3";
                break;
            case "February":
                numberMonth = "2";
                break;
            case "January":
                numberMonth = "1";
                break;
            default:
                numberMonth = "0";
        }
        return numberMonth;
    }
}
