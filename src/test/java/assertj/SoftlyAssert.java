//soft assertions get performed only after calling assertAll method
// even if one of assertion failed, rest of assertions will be evaluated

package assertj;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class SoftlyAssert
{
    @Test
    public static void SoftAssertionsDemo()
    {
        SoftAssertions sa = new SoftAssertions();

        sa.assertThat("Hello")
                .hasSize(5)
                .contains("el")
                .endsWith("o")
                .isEqualTo("Hello");

        System.out.println("see if i am getting printed before assert all");  // this should print even if one or more of assertions fail

        sa.assertAll();

        System.out.println("see if i am getting printed after assert all");   // this will be printed only if all assertions pass



    }
}
