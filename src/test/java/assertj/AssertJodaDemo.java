package assertj;

import org.assertj.jodatime.api.Assertions;
import org.joda.time.LocalDate;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AssertJodaDemo
{
    @Test
    public void datetimeTest()
    {
        LocalDate date = new LocalDate(2023,12,31);
        List<String> dates = new ArrayList<>(Arrays.asList("2020-12-31","2022-12-31","2023-12-31"));

        Assertions.assertThat(date)
                .hasYear(2023)
                .isAfterOrEqualTo("2022-12-12" )
                .isBefore("2024-1-1")
                .isIn("2020-12-31","2022-12-31","2023-12-31")
                .isIn(dates.toArray(new String[0]));
    }
}
