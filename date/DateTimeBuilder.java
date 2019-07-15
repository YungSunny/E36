public interface DateTimeBuilder {

    DateTimeBuilder setMinute (int minute);
    DateTimeBuilder setHour (int hour);
    DateTimeBuilder setDay (int day);
    DateTimeBuilder setMonth (int month);
    DateTimeBuilder setYear (int year);

    DateNTime getDate();



}
