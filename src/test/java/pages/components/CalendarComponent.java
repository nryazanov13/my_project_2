package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {

    public void setDate(String month, String year, String day){
        // Убираем ведущий ноль для дней 01-09
        String formatedDay = day.startsWith("0") ? day.substring(1) : day;
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $$(".react-datepicker__day").findBy(text(formatedDay)).click();
    }
}
