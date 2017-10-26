package ru.itis.Task6;

public class Date {
    private long year;
    private int month;
    private int daysInMonth;
    private int day;
    private boolean leapYear;

    public Date(long year){
        this.year = year;
        month = 1;
        day = 1;

        leapYear = year % 400 == 0 || year % 4 == 0 && year % 100 != 0;

        defineDaysInMonth();
    }

    private void defineDaysInMonth() {
        switch (month){
            case 1:
                daysInMonth = 31;
                break;
            case 2:
                if (leapYear){
                    daysInMonth = 29;
                }else {
                    daysInMonth = 28;
                }
                break;
            case 3:
                daysInMonth = 31;
                break;
            case 4:
                daysInMonth = 30;
                break;
            case 5:
                daysInMonth = 31;
                break;
            case 6:
                daysInMonth = 30;
                break;
            case 7:
                daysInMonth = 31;
                break;
            case 8:
                daysInMonth = 31;
                break;
            case 9:
                daysInMonth = 30;
                break;
            case 10:
                daysInMonth = 31;
                break;
            case 11:
                daysInMonth = 30;
                break;
            case 12:
                daysInMonth = 31;
        }


    }

    public void addDays(int days){
        for(int i = 0; i < days; i++){
            day++;
            if (day == daysInMonth){
                day = 0;
                month++;
                if (month > 12){
                    month = 1;
                }
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%04d",day,month,year);
    }
}
