public class Main {
    public static void main (String args[]){

        DateTimeBuilder builder1 = new DateTimeBuilderImp();
        DateTimeBuilder builder2 = new DateTimeBuilderImp();


        builder1.setMinute(8);
        builder1.setHour(10);
        builder1.setDay(5);
        builder1.setMonth(5);
        builder1.setYear(1995);


        /*
        builder2.setMinute(7);
        builder2.setHour(2);
        builder2.setDay(8);
        builder2.setMonth(10);
        builder2.setYear(1900);


        builder1.addYear(1);
        builder1.addDay(25);
        builder1.addHour(23);
        builder1.addMinute(1);
        builder1.addMonth(8);

        //builder.subMinute(180);
        //builder.subHour(10);
        //builder.subHour(34);
        //builder.subDay(65);
        //builder.subMonth(16);

        */

        DateNTime builderObj1 = builder1.getDate();

        /*
        DateNTime builderObj2 = builder2.getDate();
        System.out.println(builderObj2.toString());
        System.out.println(builderObj1.compareTo(builderObj2));
        */
        DateNTime builderObj2 = new DateNTime(50,20,30,8,1998);
        System.out.println(builderObj2.toString());
        System.out.println(builderObj2.compareTo(builderObj2));
        //builderObj2.subMinute(990000);

        System.out.println(builderObj2.toString());

    }

}
