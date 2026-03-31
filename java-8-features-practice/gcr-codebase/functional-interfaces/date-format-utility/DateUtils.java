import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

interface DateUtils{
    static String dateFormat(LocalDate date, String pattern){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }
}