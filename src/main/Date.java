/*
Import this class from your Project 1. The class implements the Java Interface Comparable. You
must implement the overriding comareTo() method,
 */

import java.util.Calendar;

/**
 * Date class provides the structure for the Date object, which contains a year, month and day.
 * It also contains informative methods to determine how many days are in each month, and whether
 * a certain Date object is valid. The Book class has a attribute datePublished which is of type Date.
 *
 * @author Hugo De Moraes, Jonathan Dong
 */
public class Date implements Comparable<Date> {
    private final int year;
    private final int month;
    private final int day;

    /**
     * Constructor for Date Object based on given string in the format of mm/dd/yyyy
     *
     * @param date String representation of date to be converted to Date Object
     */
    public Date(String date) {                      // taking mm/dd/yyyy and create a Date object
        String[] tokens = date.split("/");   // splits string date into respective tokens

        month = Integer.parseInt(tokens[0]);
        day = Integer.parseInt(tokens[1]);
        year = Integer.parseInt(tokens[2]);
    }

    /**
     * default Constructor for Date Object based on today's date
     */
    public Date() {
        Calendar calendar = Calendar.getInstance();

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public int compareTo(Date date) {

        if (this.year < date.year) {                            //first compare Years
            return -1;
        } else if (this.year > date.year) {
            return 1;
        } else {
            if (this.month < date.month) {                      //then compare months
                return -1;
            } else if (this.month > date.month) {
                return 1;
            } else {
                if (this.day < date.day)                        //finally compare days
                    return -1;
                else if (this.day > date.day) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }


    } //return 1, 0, or -1

    /**
     * getter method to return year attribute of Date object
     *
     * @return year attribute of Date object
     */
    public int getYear() {
        return year;
    }

    /**
     * getter method to return month attribute of Date object
     *
     * @return month attribute of Date object
     */
    public int getMonth() {
        return month;
    }

    /**
     * getter method to return day attribute of Date object
     *
     * @return day attribute of Date object
     */
    public int getDay() {
        return day;
    }

    /**
     * returns the number of days in February based on year attribute of Date object
     *
     * @return 29 if year is leap year, 28 if year is not
     */
    private int getFebruaryDays() {
        int QUADRENNIAL = 4;
        int CENTENNIAL = 100;
        int QUADRICENTENNIAL = 400;
        int FEB_DAYS_LEAP_YEAR = 29;
        int FEB_DAYS_NON_LEAP_YEAR = 28;

        if (((year % QUADRENNIAL == 0) & !(year % CENTENNIAL == 0)) || (year % QUADRICENTENNIAL == 0)) {
            return FEB_DAYS_LEAP_YEAR;
        } else {
            return FEB_DAYS_NON_LEAP_YEAR;
        }
    }

    /**
     * calculates number of days in month based off specific month
     *
     * @return number of days in month
     */
    private int getDaysInMonth() {
        int DAYS_IN_30DAY_MONTH = 30;
        int DAYS_IN_31DAY_MONTH = 31;
        int INDEX_OF_MONTH = month - 1; // this.month is 1 based 1:12, Calendar class is 0 based 0:11

        return switch (INDEX_OF_MONTH) {
            case Calendar.JANUARY,
                    Calendar.MARCH,
                    Calendar.MAY,
                    Calendar.JULY,
                    Calendar.AUGUST,
                    Calendar.OCTOBER,
                    Calendar.DECEMBER -> DAYS_IN_31DAY_MONTH;
            case Calendar.APRIL,
                    Calendar.JUNE,
                    Calendar.SEPTEMBER,
                    Calendar.NOVEMBER -> DAYS_IN_30DAY_MONTH;
            case Calendar.FEBRUARY -> getFebruaryDays();
            default -> -1;
        };
    }

    /**
     * checks if year of Date object is valid
     *
     * @return true if year is between 1900 and today's year
     */
    private boolean isValidYear() {
        Date today = new Date();
        int yearLeftBound = 1900;
        int yearRightBound = today.year;

        return (year >= yearLeftBound && year < yearRightBound)
                || (year == yearRightBound && month < today.month)
                || (year == yearRightBound && month == today.month && day <= today.day);
    }

    /**
     * checks if month of Date object is valid
     *
     * @return true if month is between 1 and 12
     */
    private boolean isValidMonth() {
        int MAX_MONTH_NUM = 12;
        int MIN_MONTH_NUM = 1;
        return month >= MIN_MONTH_NUM && month <= MAX_MONTH_NUM;
    }

    /**
     * checks if day of Date object is valid
     *
     * @return true if day is between 1 and num days in month
     */
    private boolean isValidDay() {
        return day <= getDaysInMonth() && day > 0;
    }

    /**
     * checks if Date Object is valid
     *
     * @return true if year, month and day is valid
     */
    public boolean isValid() {
        return isValidYear() && isValidMonth() && isValidDay();
    }

    /**
     * overridden toString method gives string representation of Date Object
     *
     * @return String containing month, day and year of Date
     */
    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }
}