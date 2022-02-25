package com.cristianriano.movies.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
  @Value("${spring.application.name}")
  private String appName;

  @RequestMapping("/healthz")
  public String healthz() {
    return "OK";
  }

  @GetMapping("/about")
  public String about() {
    return appName;
  }
}
