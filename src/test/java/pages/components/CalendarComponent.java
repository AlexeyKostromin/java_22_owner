package pages.components;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CalendarComponent {

    public void selectDate(String dayOfBirth, String monthOfBirth, String yearOfBirth) {
        $("[class=react-datepicker__year-select]").selectOption(yearOfBirth);
        $("[class=react-datepicker__month-select]").selectOption(monthOfBirth);
        //$(".react-datepicker__day--027:not(.react-datepicker__day--outside-month").click();
        //$x(String.format("//*[contains(@class, 'datepicker__day--0%s')][not(contains(@class, 'datepicker__day--outside-month'))]", dayOfBirth)).click();
        $x(String.format("//*[contains(@class, 'datepicker__day--0%s') and not(contains(@class, 'datepicker__day--outside-month'))]", dayOfBirth)).click();

    }
}
