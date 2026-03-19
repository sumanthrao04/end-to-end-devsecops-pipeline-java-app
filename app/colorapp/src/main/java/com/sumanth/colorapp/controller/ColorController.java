package com.sumanth.colorapp.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ColorController {


@GetMapping("/colors")
public List<String> getColors() {
    return List.of("red", "green", "blue", "yellow");
}

@GetMapping("/health-check")
public String health() {
    return "Application is running!";
}


}
