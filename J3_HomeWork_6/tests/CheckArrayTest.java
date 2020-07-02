import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.geekbrains.java.practice.Main;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CheckArrayTest {
    @Parameterized.Parameters
    public static Collection<Object[]> parameters(){
        return Arrays.asList(new Object[][]{
                {new int[] {1, 1, 1, 4, 4, 1, 4, 4}, true},
                {new int[] {1, 1, 1, 1, 1, 1}, false},
                {new int[] {4, 4, 4, 4}, false},
                {new int[]{1, 4, 4, 1, 1, 4, 3}, false}
        });
    }
    private int[] in;
    private boolean out;

    public CheckArrayTest(int[] in, boolean out) {
        this.in = in;
        this.out = out;
    }

    @Test
    public void getFromArrayTest() {
        Assert.assertEquals(out, Main.checkArray(in));
    }
}
