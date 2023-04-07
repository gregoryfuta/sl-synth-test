package gen.i0.sealights.synth.app.module001.api;

import gen.i0.sealights.synth.app.module001.service.Service001;
import reactor.core.publisher.Mono;

public class Controller001 {

    private final Service001 service;

    public Controller001(Service001 service) {
        this.service = service;
    }

    public Mono<String> ctrlMethod000(final String input) {
        return Mono.just(service.method000(input));
    }

    public Mono<String> ctrlMethod001(final String input) {
        return Mono.just(service.method001(input));
    }
}