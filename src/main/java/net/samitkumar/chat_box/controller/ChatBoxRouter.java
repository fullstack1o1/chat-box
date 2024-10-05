package net.samitkumar.chat_box.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

import java.util.Map;

@Controller
class ChatBoxRouter {

    @GetMapping("/csrf")
    @ResponseBody
    public CsrfToken csrf(CsrfToken csrfToken) {
        return csrfToken;
    }

    @GetMapping("/register")
    String register() {
        return "forward:register.html";
    }

    @PostMapping("/register")
    @ResponseBody
    Map<String, Object> register(@RequestBody Map<String, Object> body) {
        return body;
    }

    @GetMapping("/message")
    @ResponseBody
    Map<String, String> message() {
        return Map.of("message", "Hello World!");
    }

    @GetMapping("/message/re")
    ResponseEntity<String> messageRe() {
        return ResponseEntity.ok("Hello World!");
    }

    @Bean
    RouterFunction<ServerResponse> functionalRouter() {
        return RouterFunctions
                .route()
                .GET("/message/sr", request -> ServerResponse.ok().body("Hello World"))
                .build();
    }
}
