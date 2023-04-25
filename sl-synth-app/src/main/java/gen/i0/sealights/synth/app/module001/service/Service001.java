package gen.i0.sealights.synth.app.module001.service;

import static i0.sealights.synth.common.RandomUtil.randomLongMax;

public class Service001 {

    public String method000(final String input) {
        sleep();
        System.out.println("INPUT: " + input + threadInfo());
        return "OUTPUT: " + input;
    }

    public String method001(final String input) {
        sleep();
        System.out.println("INPUT: " + input + threadInfo());
        return "OUTPUT: " + input;
    }

    private static void sleep() {
        try {
            // Thread.sleep(randomLongMax(120));
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private String threadInfo() {
        return ", " + Thread.currentThread().getThreadGroup() + "."
            + Thread.currentThread().getName() + "-"
            + Thread.currentThread().getId();
    }
}