package i00test.sealights.synth.test.common;

import java.util.List;

class TestMethodHit {
    private final String testName;
    private final List<String> methodNames;

    public TestMethodHit(String testName, List<String> methodNames) {
        this.testName = testName;
        this.methodNames = methodNames;
    }

    public String getTestName() {
        return testName;
    }

    public List<String> getMethodNames() {
        return methodNames;
    }
}
