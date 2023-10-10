package gen.i0.sealights.synth.app.module002.api;

import gen.i0.sealights.synth.app.module002.service.Service001;
import reactor.core.publisher.Mono;

public class Controller001 {

    private final Service001 service;

    public Controller001(Service001 service) {
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