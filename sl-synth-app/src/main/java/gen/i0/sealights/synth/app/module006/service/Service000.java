package gen.i0.sealights.synth.app.module006.service;

import static i0.sealights.synth.common.RandomUtil.randomLongMax;

public class Service000 {

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

    public String method002(final String input) {
        sleep();
        System.out.println("INPUT: " + input + threadInfo());
        return "OUTPUT: " + input;
    }

    public String method003(final String input) {
        sleep();
        System.out.println("INPUT: " + input + threadInfo());
        return "OUTPUT: " + input;
    }

    public String method004(final String input) {
        sleep();
        System.out.println("INPUT: " + input + threadInfo());
        return "OUTPUT: " + input;
    }

    public String method005(final String input) {
        sleep();
        System.out.println("INPUT: " + input + threadInfo());
        return "OUTPUT: " + input;
    }

    public String method006(final String input) {
        sleep();
        System.out.println("INPUT: " + input + threadInfo());
        return "OUTPUT: " + input;
    }

    public String method007(final String input) {
        sleep();
        System.out.println("INPUT: " + input + threadInfo());
        return "OUTPUT: " + input;
    }

    public String method008(final String input) {
        sleep();
        System.out.println("INPUT: " + input + threadInfo());
        return "OUTPUT: " + input;
    }

    public String method009(final String input) {
        sleep();
        System.out.println("INPUT: " + input + threadInfo());
        return "OUTPUT: " + input;
    }

    private static void sleep() {
        try {
            // Thread.sleep(randomLongMax(120));
            Thread.sleep(5);
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