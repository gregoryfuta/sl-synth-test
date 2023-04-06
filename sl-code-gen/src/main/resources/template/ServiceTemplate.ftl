package ${packageName}.service;

import static i0.sealights.synth.common.RandomUtil.randomLongMax;

public class Service${classNo} {

<#assign maxMethodCount=methodCount-1>
<#list 0..maxMethodCount as i>
    public String method${i?string('000')}(final String input) {
        System.out.println("INPUT: " + input);
        sleep();
        return "OUTPUT: " + input;
    }

</#list>
    private static void sleep() {
        try {
            Thread.sleep(randomLongMax(20));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}