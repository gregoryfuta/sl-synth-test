package io.sealights.codegen;

import lombok.Builder;
import lombok.Value;

@Value
@Builder()
public class BuildParameters {

    @Builder.Default
    String basePackage = "i0.sealights.gen";
    @Builder.Default
    int modulesCount = 6;
    @Builder.Default
    int classCount = 6;
    @Builder.Default
    int methodCount = 6;
}
