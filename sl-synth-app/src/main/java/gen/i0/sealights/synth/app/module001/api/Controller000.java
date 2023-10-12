package gen.i0.sealights.synth.app.module001.api;

import gen.i0.sealights.synth.app.module001.service.Service000;
import reactor.core.publisher.Mono;

public class Controller000 {

    private final Service000 service;

    public Controller000(Service000 service) {
        this.service = service;
    }

    public Mono<String> ctrlAsyncMethod000(final String input) {
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

    public Mono<String> ctrlAsyncMethod002(final String input) {
        return Mono.fromCallable(() -> service.method002(input));
    }

    public String ctrlSyncMethod002(final String input) {
        return service.method002(input);
    }
}