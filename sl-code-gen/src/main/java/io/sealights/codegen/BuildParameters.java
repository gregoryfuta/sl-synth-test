package io.sealights.codegen;

import lombok.Builder;
import lombok.Value;

@Value
@Builder()
public class BuildParameters {

    @Builder.Default
    String basePackage = "i0.sealights.synth.app";
    @Builder.Default
    int modulesCount = 1;
    @Builder.Default
    int classCount = 1;
    @Builder.Default
    int methodCount = 2;
}
