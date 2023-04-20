package i0.sealights.synth.app.module000.api;

import i0.sealights.synth.app.module000.service.Service000;
import reactor.core.publisher.Mono;

public class Controller000 {

    private final Service000 service;

    public Controller000(Service000 service) {
        this.service = service;
    }

    public Mono<String> ctrlAsyncMethod000(final String input) {
        return Mono.fromCallable(() -> service.method000(input));
    }

    public Mono<String> ctrlMethod001(final String input) {
        return Mono.fromCallable(() -> service.method001(input));
    }
}