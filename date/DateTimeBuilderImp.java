
public class DateTimeBuilderImp implements  DateTimeBuilder{

    private int minute, hour;
    private int day, month, year;

    public DateTimeBuilderImp() {
        this.year = 0;
        this.month = 0;
        this.day = 0;
        this.hour = 0;
        this.minute = 0;
    }

    //SET METHODS
    public DateTimeBuilder setMinute (int minute){
        if ((minute < 0) || (minute > 59)){
            this.minute = 0;
            System.out.println(" Minute should be from 0 to 59 ");
            return this;
        }
        else {
            this.minute = minute;
            return this;
        }
    }

    public DateTimeBuilder setHour (int hour){
        if ((hour < 0) || (hour > 23)) {
            this.hour = 0;
            System.out.println(" Hour should be from 0 to 23 ");
            return this;
        }
        else {
            this.hour = hour;
            return this;
        }
    }

    public DateTimeBuilder setDay (int day){
        if ((day < 0) || (day > 31)){
            this.day = 0;
            System.out.println(" Day should be from 0 to 31");
            return this;
        }
        else if ((day > 28 &&(this.month == 2)) || (day > 30
            && (this.month == 4 || this.month == 6 ||
            this.month == 9 || this.month == 11)) ||
                (day > 31 && (this.month == 1 || this.month == 3
                || this.month == 5 || this.month == 7 ||
                this.month == 8 || this.month == 10 ||
                this.month == 12))){
            System.out.println(" Check if your day is possible ");
            this.day = 0;
            return this;

        }
        else{
            this.day = day;
            return this;
        }
    }

    public DateTimeBuilder setMonth (int month){
        if ((month < 0) || (month > 12)){
            System.out.println(" Month should be from 0 to 12");
            this.month = 0;
            return this;
        }
        else{
            this.month = month;
            return this;
        }
    }

    public DateTimeBuilder setYear (int year){
        if (year < 0){
            this.year = 0;
            System.out.println(" Check year ");
            return this;
        }
        else{
            this.year = year;
            return this;
        }
    }

    public DateNTime getDate(){
        return new DateNTime(minute, hour, day, month, year);
    }





}

