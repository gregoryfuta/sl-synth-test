package io.sealights.codegen;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class DataModel {
    String classNo;
    Integer methodCount;
    String packageName;
    String module;
}
