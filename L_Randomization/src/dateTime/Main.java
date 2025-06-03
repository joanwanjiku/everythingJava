package dateTime;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalDate may31st = LocalDate.of(2020, 5, 31);
        System.out.println(may31st);

        LocalDate yearMid = LocalDate.ofYearDay(2020, 182);
        System.out.println(yearMid);
        System.out.println("-------------------------------------------------------------");
        System.out.println(yearMid.getMonth());
        System.out.println(yearMid.getDayOfWeek());

        System.out.println("-------------------------------------------------------------");
        System.out.println(may31st.plusYears(2));
        System.out.println(may31st.plusMonths(2));
    }
}
