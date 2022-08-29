package com.example.webfluxdemo.controller;


import com.example.webfluxdemo.entity.Post;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author xiaobox
 * @since 2022/8/28 11:29 AM
 */
@Log4j2
@RestController
@RequestMapping("/webflux")
public class WebFluxController {


    @GetMapping("/hello")
    public Mono<String> hello() {
        return Mono.just("Hello Spring Webflux");
    }

    @GetMapping("/posts")
    public Flux<Post> posts() {

        WebClient webClient = WebClient.create();
        Flux<Post> postFlux = webClient.get().uri("http://jsonplaceholder.typicode.com/posts").retrieve().bodyToFlux(Post.class);

        return postFlux;
    }

    @GetMapping(value = "/flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> flux() {
        Flux<String> flux = Flux.fromArray(new String[]{"a", "b", "c", "d"}).map(s -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "<letter:" + s + ">";
        });
        return flux;
    }


}
