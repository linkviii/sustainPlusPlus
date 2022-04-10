package extraLarge;

import java.util.Arrays;
import java.util.function.Consumer;

class ZZZScratchPad {
    static void testConsumeClosure(){
        final int[] c = { 0, 0 };
        Consumer<Boolean> f = eq -> {
            c[0]++;
            if (eq)
                c[1]++;
        };
        f.accept(true);
        f.accept(false);
        System.out.println(Arrays.toString(c));

    }
}