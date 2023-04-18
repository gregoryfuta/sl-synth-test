package gen.i0.sealights.synth.app.module000.api;

import gen.i0.sealights.synth.app.module000.service.Service000;
import reactor.core.publisher.Mono;

public class Controller000 {

    private final Service000 service;

    public Controller000(Service000 service) {
        this.service = service;
    }

    public Mono<String> ctrlAsyncMethod000(final String input) {
        return Mono.just(service.method000(input));
    }

    public String ctrlSyncMethod000(final String input) {
        return service.method000(input);
    }

    public Mono<String> ctrlAsyncMethod001(final String input) {
        return Mono.just(service.method001(input));
    }

    public String ctrlSyncMethod001(final String input) {
        return service.method001(input);
    }
}