import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.geekbrains.java.practice.Main;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MainTest {
    @Parameterized.Parameters
    public static Collection<Object[]> parameters(){
        return Arrays.asList(new Object[][]{
                {new int[] {1, 7}, new int[] {1, 2, 4, 4, 2, 3, 4, 1, 7}},
                {new int[] {2, 1, 3, 2, 3, 1, 2, 7}, new int[] {4, 2, 1, 3, 2, 3, 1, 2, 7}},
                {new int[] {5}, new int[] {1, 3, 4, 5}},
                {new int[]{}, new int[]{4, 4, 4, 4, 4, 4, 4}}
        });
    }
    private int[] in;
    private int[] out;

    public MainTest(int[] out, int[] in) {
        this.in = in;
        this.out = out;
    }

    @Test
    public void getFromArrayTest() {
        Assert.assertArrayEquals(out, Main.getFromArray(in));
    }
}
