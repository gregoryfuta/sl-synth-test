package i0.sealights.synth.app.module000.service;

import static i0.sealights.synth.common.RandomUtil.randomLongMax;

public class Service000 {

    public String method000(final String input) {
        System.out.println("INPUT: " + input);
        sleep();
        return "OUTPUT: " + input;
    }

    public String method001(final String input) {
        System.out.println("INPUT: " + input);
        sleep();
        return "OUTPUT: " + input;
    }

    private static void sleep() {
        try {
            Thread.sleep(randomLongMax(120));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}