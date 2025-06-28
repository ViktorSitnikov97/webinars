package task5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task5_advanced.LimitedStack;

public class LimitedStackTest {

    private final int size = 5;

    @Test
    public void pushAndPeekTest() throws Exception {
        LimitedStack<String> stack = new LimitedStack<>(2);
        stack.push("1");
        stack.push("2");

        String expected = "2";
        String actual = stack.peek();
        Assertions.assertEquals(expected, actual);
        Assertions.assertThrows(Exception.class, () -> stack.push("3"), "Stack is full!");
    }

    @Test
    public void popAndIsFullTest() throws Exception {
        LimitedStack<String> stack = new LimitedStack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");

        Assertions.assertTrue(stack.isFull());

        String actual = stack.pop();
        String expected = "5";

        Assertions.assertEquals(expected, actual);
        Assertions.assertThrows(
                Exception.class,
                () ->
                {
                    int length = stack.size();
                    for (int i = 0; i < length + 1; i++) {
                        stack.pop();
                    }
                },
                "Stack is empty!");

    }

    @Test
    public void sizeAndEmptyTest() throws Exception {
        LimitedStack<String> stack = new LimitedStack<>(size);

        Assertions.assertTrue(stack.isEmpty());

        stack.push("1");
        stack.push("2");
        stack.push("3");

        int expected = 3;
        int actual = stack.size();
        Assertions.assertEquals(expected, actual);
    }

}
