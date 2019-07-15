
public class DateNTime implements Comparable <DateNTime>{

    private int minute, hour;
    private int day, month, year;

    public DateNTime(int minute, int hour, int day, int month, int year) {
        this.minute = minute;
        this.hour = hour;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getMinute() {
        return minute;
    }

    public void addMinute (int minute){
        int tempMinute = this.minute + minute;
        int tempHour = 0;
        if (tempMinute > 59){
            tempHour = tempMinute / 60;
            tempMinute = tempMinute % 60;
            addHour(tempHour);
            this.minute = tempMinute;
        }
        else {
            this.minute = tempMinute;
        }
    }

    public void addHour (int hour){
        int tempHour = this.hour + hour;
        int tempDay = 0;
        if (tempHour > 23){
            tempDay = tempHour / 24;
            tempHour = tempHour % 24;
            addDay(tempDay);
            this.hour = tempHour;
        }
        else{
            this.hour = tempHour;
        }
    }

    public void addDay (int day){
        int tempDay = this.day + day;
        int tempMonth = 0;
        if (tempDay > 30 && (((this.month) == 4) ||
                ((this.month) == 6) || ((this.month)
                == 9) || ((this.month) == 11))) {
            tempMonth = tempDay / 30;
            tempDay = tempDay % 30;
            addMonth(tempMonth);
            this.day = tempDay;
        }
        else if (tempDay > 31 && (((this.month) == 1) ||
                ((this.month) == 3) || ((this.month)
                == 5) || ((this.month) == 7) ||
                ((this.month) == 8) || ((this.month)
                == 10) || ((this.month) == 12))){
            tempMonth = tempDay / 31;
            tempDay = tempDay % 31;
            addMonth(tempMonth);
            this.day = tempDay;
        }
        else if (tempDay > 28 && (this.month == 2)){
            tempMonth = tempDay / 28;
            tempDay = tempDay % 28;
            addMonth(tempMonth);
            this.day = tempDay;
        }
        else{
            this.day = tempDay;
        }
    }

    public void addMonth (int month){
        int tempMonth = this.month + month;
        int tempYear = 0;
        if (tempMonth > 12){
            tempYear = tempMonth / 12;
            tempMonth = tempMonth % 12;
            addYear(tempYear);
            this.month = tempMonth;
        }
        else {
            this.month = tempMonth;
        }
    }

    public void addYear (int year){
        this.year = this.year + year;
    }

    //SUBTRACTION METHODS
    public void subMinute(int minute){
        int tempMinute = this.minute - minute;
        int tempHour = 0;
        if (tempMinute < 0){
            tempHour = ((-tempMinute) / 60) + 1;
            tempMinute = tempHour * 60 + tempMinute;
            subHour(tempHour);
            this.minute = tempMinute;
        }
        else {
            this.minute = tempMinute;
        }
    }

    public void subHour (int hour){
        int tempHour = this.hour - hour;
        int tempDay = 0;
        if (tempHour < 0){
            tempDay = ((-tempHour) / 24) + 1;
            tempHour = tempDay * 24 + tempHour;
            subDay(tempDay);
            this.hour = tempHour;
        }
        else{
            this.hour = tempHour;
        }
    }

    public void subDay (int day){
        int tempDay = this.day - day;
        int tempMonth = 0;
        if ((this.month == 4) || ((this.month) == 6)
                || ((this.month) == 9) || ((this.month) == 11)){
            tempMonth = (-tempDay / 30) + 1;
            tempDay = tempMonth * 30 + tempDay;
            subMonth(tempMonth);
            this.day = tempDay;
        }
        else if (((this.month ) == 1) || ((this.month ) == 3)
                || ((this.month) == 5) || ((this.month) == 7)
                || ((this.month) == 8) || ((this.month) == 10)
                || ((this.month ) == 12)){
            tempMonth = (-tempDay / 31) + 1;
            tempDay = tempMonth * 31 + tempDay;
            subMonth(tempMonth);
            this.day = tempDay;
        }
        else if ((this.month == 2)){
            tempMonth = (-tempDay / 28) + 1;
            tempDay = tempMonth * 28 + tempDay;
            subMonth(tempMonth);
            this.day = tempDay;
        }
        else{
            this.day = tempDay;
        }
    }

    public void subMonth (int month){
        int tempMonth = this.month - month;
        int tempYear = 0;
        if (tempMonth < 0){
            tempYear = (-tempMonth / 12) + 1;
            tempMonth = tempYear * 12 + tempMonth;
            subYear(tempYear);
            this.month = tempMonth;
        }
        else {
            this.month = tempMonth;
        }
    }
    public void subYear (int year){
        this.year = this.year - year;
    }

    public int getHour() {
        return hour;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int compareTo (DateNTime date){
        if (year > date.getYear()){
            return -1;
        }
        else if (year < date.getYear()){
            return 1;
        }
        else if (year == date.getYear()){
            return 0;
        }
        else if (month > date.getMonth()){
            return -1;
        }
        else if (month < date.getMonth()){
            return 1;
        }
        else if (month == date.getMonth()){
            return 0;
        }
        else if (day > date.getDay()){
            return -1;
        }
        else if (day < date.getDay()){
            return 1;
        }
        else if (day == date.getDay()){
            return 0;
        }
        else if (hour > date.getHour()){
            return -1;
        }
        else if (hour < date.getHour()){
            return 1;
        }
        else if (hour == date.getHour()){
            return 0;
        }
        else if (minute > date.getMinute()){
            return -1;
        }
        else if (minute < date.getMinute()){
            return 1;
        }
        else if (minute == date.getMinute()){
            return 0;
        }
        else{
            System.out.println("Can't compare");
            return -420;
        }
    }

    public String toString(){
        return "Year: " + this.year + " Month: " + this.month + " Day: " + this.day
                + " Hour: " + this.hour + " Minute: " + this.minute;
    }

}






