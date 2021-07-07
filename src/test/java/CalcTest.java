import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


public class CalcTest {

    @DataProvider
    public static Object[][] inputForAddition(Method m) {
        switch (m.getName()) {
            case "additionEquals":
                return new Object[][] {{5, 2, 3}, {10, 20, -10}, {-1, -2147483648, 2147483647}, {-1, -1, 0}};
            case "additionEqualsNegative":
                return new Object[][] {{8, 3, 4}, {11, 10, 2}, {4, 9, -6}, {-2, 10, -9}};
            case "additionEqualsObject":
                return new Object[][] {{"test", 4, 7}, {1, null, 1}, {11, -11, "eleven"}, {45, "ten", 55}};
        }
        return null;
    }

    @DataProvider
    public static Object[][] inputForSubtraction(Method m) {
        switch (m.getName()) {
            case "subtractionEquals":
                return new Object[][] {{-2, 2 , 4}, {30, 20, -10}, {-2147483648, -2147483647, 1}, {-1, -1, 0}};
            case "subtractionEqualsNegative":
                return new Object[][] {{8, -6, 5}, {11, -10, 2}, {4, -9, -6}, {-2, -10, -9}};
            case "subtractionEqualsObject":
                return new Object[][] {{"test", 4, 7}, {1, null, 1}, {11, -11, "eleven"}, {45, "ten", 55}};
        }
        return null;
    }

    @DataProvider
    public static Object[][] inputForMultiplication(Method m) {
        switch (m.getName()) {
            case "multiplicationEquals":
                return new Object[][] {{8, 2 , 4}, {-200, 20, -10}, {-2147483648, -2147483648, 1}, {0, -1, 0}};
            case "multiplicationEqualsNegative":
                return new Object[][] {{8, 6, 5}, {11, 10, 2}, {4, 9, -6}, {-2, 10, -9}};
            case "multiplicationEqualsObject":
                return new Object[][] {{"test", 4, 7}, {1, null, 1}, {11, -11, "eleven"}, {45, "ten", 55}};
        }
        return null;
    }

    @DataProvider
    public static Object[][] inputForDivision(Method m) {
        switch (m.getName()) {
            case "divisionEquals":
                return new Object[][] {{3, 12 , 4}, {-20, 200, -10}, {-1, -2147483647, 2147483647}, {-1, -1, 1}};
            case "divisionEqualsNegative":
                return new Object[][] {{8, 6, 5}, {11, 10, 2}, {4, 9, -6}, {-2, 10, -9}};
            case "divisionEqualsObject":
                return new Object[][] {{"test", 4, 7}, {1, null, 1}, {11, -11, "eleven"}, {45, "ten", 55}};
        }
        return null;
    }

    //--------------Test additional--------------//
    @Test(dataProvider = "inputForAddition", groups = { "positive" })
    public void additionEquals(Object res, Object first, Object second) {
        Assert.assertEquals(res, new Calc().addition(first, second));
    }

    @Test(dataProvider = "inputForAddition", groups = { "negative" })
    public void additionEqualsNegative(Object res, Object first, Object second) {
        Assert.assertNotEquals(res, new Calc().addition(first, second), "Значения равны!");
    }

    // "выбрасываемые эксепшены" с объектами обрабатываю с параметром expectedExceptions
    @Test(dataProvider = "inputForAddition", groups = { "object" }, expectedExceptions = {NumberFormatException.class, ClassCastException.class, NullPointerException.class, AssertionError.class})
    public void additionEqualsObject(Object res, Object first, Object second) {
        Assert.assertEquals(res, new Calc().addition(first, second));
    }

    //--------------Test subtraction--------------//
    @Test(dataProvider = "inputForSubtraction", groups = { "positive" })
    public void subtractionEquals(Object res, Object first, Object second) {
        Assert.assertEquals(res, new Calc().subtraction(first, second));
    }

    @Test(dataProvider = "inputForSubtraction", groups = { "negative" })
    public void subtractionEqualsNegative(Object res, Object first, Object second) {
        Assert.assertNotEquals(res, new Calc().subtraction(first, second), "Значения равны!");
    }

    @Test(dataProvider = "inputForSubtraction", groups = { "object" }, expectedExceptions = {NumberFormatException.class, ClassCastException.class, NullPointerException.class, AssertionError.class})
    public void subtractionEqualsObject(Object res, Object first, Object second) {
        Assert.assertEquals(res, new Calc().subtraction(first, second));
    }

    //--------------Test multiplication--------------//
    @Test(dataProvider = "inputForMultiplication", groups = { "positive" })
    public void multiplicationEquals(Object res, Object first, Object second) {
        Assert.assertEquals(res, new Calc().multiplication(first, second));
    }

    @Test(dataProvider = "inputForMultiplication", groups = { "negative" })
    public void multiplicationEqualsNegative(Object res, Object first, Object second) {
        Assert.assertNotEquals(res, new Calc().multiplication(first, second), "Значения равны!");
    }

    @Test(dataProvider = "inputForMultiplication", groups = { "object" }, expectedExceptions = {NumberFormatException.class, ClassCastException.class, NullPointerException.class, AssertionError.class})
    public void multiplicationEqualsObject(Object res, Object first, Object second) {
        Assert.assertEquals(res, new Calc().multiplication(first, second));
    }

    //--------------Test division--------------//
    @Test(dataProvider = "inputForDivision", groups = { "positive" })
    public void divisionEquals(Object res, Object first, Object second) {
        Assert.assertEquals(res, new Calc().division(first, second));
    }

    @Test(dataProvider = "inputForDivision", groups = { "negative" })
    public void divisionEqualsNegative(Object res, Object first, Object second) {
        Assert.assertNotEquals(res, new Calc().division(first, second), "Значения равны!");
    }

    @Test(dataProvider = "inputForDivision", groups = { "object" }, expectedExceptions = {NumberFormatException.class, ClassCastException.class, NullPointerException.class, AssertionError.class})
    public void divisionEqualsObject(Object res, Object first, Object second) {
        Assert.assertEquals(res, new Calc().division(first, second));
    }
}
