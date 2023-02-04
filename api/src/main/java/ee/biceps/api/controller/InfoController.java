package ee.biceps.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InfoController {

    // TODO - can be a general controller to view the state of the api server?
    // monitoring, statistics, performance etc
    @GetMapping("/info")
    public ResponseEntity<Void> getInfo() {
        return ResponseEntity.ok().build();
    }

}
