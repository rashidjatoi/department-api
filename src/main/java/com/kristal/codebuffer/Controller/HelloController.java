package com.kristal.codebuffer.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(path = "/")
    public String greeting() {
        return "Welcome";
    }
}
