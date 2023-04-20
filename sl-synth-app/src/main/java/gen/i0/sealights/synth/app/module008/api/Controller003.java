package gen.i0.sealights.synth.app.module008.api;

import gen.i0.sealights.synth.app.module008.service.Service003;
import reactor.core.publisher.Mono;

public class Controller003 {

    private final Service003 service;

    public Controller003(Service003 service) {
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

    public Mono<String> ctrlAsyncMethod003(final String input) {
        return Mono.fromCallable(() -> service.method003(input));
    }

    public String ctrlSyncMethod003(final String input) {
        return service.method003(input);
    }

    public Mono<String> ctrlAsyncMethod004(final String input) {
        return Mono.fromCallable(() -> service.method004(input));
    }

    public String ctrlSyncMethod004(final String input) {
        return service.method004(input);
    }

    public Mono<String> ctrlAsyncMethod005(final String input) {
        return Mono.fromCallable(() -> service.method005(input));
    }

    public String ctrlSyncMethod005(final String input) {
        return service.method005(input);
    }

    public Mono<String> ctrlAsyncMethod006(final String input) {
        return Mono.fromCallable(() -> service.method006(input));
    }

    public String ctrlSyncMethod006(final String input) {
        return service.method006(input);
    }

    public Mono<String> ctrlAsyncMethod007(final String input) {
        return Mono.fromCallable(() -> service.method007(input));
    }

    public String ctrlSyncMethod007(final String input) {
        return service.method007(input);
    }

    public Mono<String> ctrlAsyncMethod008(final String input) {
        return Mono.fromCallable(() -> service.method008(input));
    }

    public String ctrlSyncMethod008(final String input) {
        return service.method008(input);
    }

    public Mono<String> ctrlAsyncMethod009(final String input) {
        return Mono.fromCallable(() -> service.method009(input));
    }

    public String ctrlSyncMethod009(final String input) {
        return service.method009(input);
    }
}