package com.cristianriano.movies.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

  @RequestMapping("/healthz")
  public String healthz() {
    return "OK";
  }
}
