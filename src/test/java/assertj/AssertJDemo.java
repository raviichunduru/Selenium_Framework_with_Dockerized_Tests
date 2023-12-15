// using assertions class one can do multiple assertions in less code,, in readable way
// method chaining possible
// one can provide description for fail scenarios


package assertj;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Index;
import org.assertj.core.data.Offset;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class AssertJDemo
{
    @Test
    public static void StringAssertions()
    {
        String a="Hello World";

        Assertions.assertThat(a)
                .as("string is empty").isNotEmpty()
                .as("string is blank").isNotBlank()
                .containsIgnoringCase("world")
                .isEqualTo("Hello World")
                .matches("\\w.*"+"World")
                .doesNotContainPattern("\\d.*")
                .hasSize(11)
                .endsWith("World")
                .doesNotEndWith("\\w.*");
    }

    @Test
    public static void IntegerAssertions()
    {
        Integer a=10;

        Assertions.assertThat(a)
                .isEven()
                .isCloseTo(14, Offset.offset(5));
    }

    @Test
    public static void ListAssertions()
    {
        List<String> list1 = Arrays.asList("Automation","Selenium","Appium");
        List<String> list2 = Arrays.asList("Selenium","Appium");
        List<String> list3 = Arrays.asList("Sm","Am","Appium");

        Assertions.assertThat(list1)
                .isInstanceOfAny(List.class)
                .contains("Appium", Index.atIndex(2))
                .doesNotContain("test")
                .containsExactlyInAnyOrder("Selenium","Automation","Appium")
                .allMatch(a->a.length()>3)
                .containsAll(list2)
                .as("list 3 containing one or more elements of list1").doesNotContainAnyElementsOf(list3);
    }
}