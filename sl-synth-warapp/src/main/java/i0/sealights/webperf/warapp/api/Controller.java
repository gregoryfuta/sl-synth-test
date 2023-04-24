package gen.i0.sealights.webperf.warapp.module000.api;

import gen.i0.sealights.webperf.warapp.module000.service.Service000;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final Service000 service;

    public Controller(Service000 service) {
        this.service = service;
    }

    @GetMapping("/get000")
    public String ctrlSyncMethod000(final String input) {
        return service.method000(input);
    }

    @GetMapping("/get001")
    public String ctrlSyncMethod001(final String input) {
        return service.method001(input);
    }

    @GetMapping("/get002")
    public String ctrlSyncMethod002(final String input) {
        return service.method002(input);
    }

    @GetMapping("/get003")
    public String ctrlSyncMethod003(final String input) {
        return service.method003(input);
    }

    @GetMapping("/get004")
    public String ctrlSyncMethod004(final String input) {
        return service.method004(input);
    }

    @GetMapping("/get031")
    public String ctrlSyncMethod031(final String input) {
        return service.method031(input);
    }
}