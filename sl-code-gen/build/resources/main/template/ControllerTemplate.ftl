package ${packageName}.api;

import ${packageName}.service.Service${classNo};
import reactor.core.publisher.Mono;

public class Controller${classNo} {

    private final Service${classNo} service;

    public Controller${classNo}(Service${classNo} service) {
        this.service = service;
    }
<#assign maxMethodCount=methodCount-1>
<#list 0..maxMethodCount as i>

    public Mono<String> ctrlAsyncMethod${i?string('000')}(final String input) {
        return Mono.fromCallable(() -> service.method${i?string('000')}(input));
    }

    public String ctrlSyncMethod${i?string('000')}(final String input) {
        return service.method${i?string('000')}(input);
    }
</#list>
}