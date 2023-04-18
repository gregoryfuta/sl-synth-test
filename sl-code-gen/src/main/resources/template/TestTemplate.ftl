package ${packageName};

import static i00test.sealights.synth.test.common.AssertionPredicate.predicateForInput;

import gen.i0.sealights.synth.app.module${module}.api.Controller${classNo};
import gen.i0.sealights.synth.app.module${module}.service.Service${classNo};
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

@DisplayName("Service${classNo}Test")
public class Service${classNo}Test {

<#assign maxMethodCount=methodCount-1>
<#list 0..maxMethodCount as i>
  @Test
  void testSync${i?string('000')}() {
    Service${classNo} service = new Service${classNo}();
    Controller${classNo} controller = new Controller${classNo}(service);

    IntStream.range(1, 5)
<#--        .parallel()-->
        .forEach(
            intValue -> {
              final String input = String.format("%03d", intValue);
              StepVerifier.create(controller.ctrlAsyncMethod${i?string('000')}(input))
                  .expectNextMatches(predicateForInput(input))
                  .expectComplete()
                  .verify();
            });
  }
</#list>
}