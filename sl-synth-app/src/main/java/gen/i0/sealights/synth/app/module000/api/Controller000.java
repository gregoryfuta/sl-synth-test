package gen.i0.sealights.synth.app.module000.api;

import com.esotericsoftware.reflectasm.MethodAccess;
import gen.i0.sealights.synth.app.module000.service.Service000;
import i0.sealights.synth.common.EsotericClass;
import reactor.core.publisher.Mono;

public class Controller000 {

    private final Service000 service;

    public Controller000(Service000 service) {
        this.service = service;

        MethodAccess access = MethodAccess.get(EsotericClass.class);
        EsotericClass esotericClass = new EsotericClass();
        String name = (String) access.invoke(esotericClass, "hello", "001");
    }

    public Mono<String> ctrlAsyncMethod000(final String input) {
        MethodAccess access = MethodAccess.get(EsotericClass.class);
        EsotericClass esotericClass = new EsotericClass();
        String name = (String) access.invoke(esotericClass, "hello", "001");
        return Mono.fromCallable(() -> service.method000(input));
    }

    public String ctrlSyncMethod000(final String input) {
        return service.method000(input);
    }

    public Mono<String> ctrlAsyncMethod001(final String input) {
        return Mono.fromCallable(() -> service.method001(input));
    }

    public String ctrlSyncMethod001(final String input) {
        return service.method001(input);
    }
}