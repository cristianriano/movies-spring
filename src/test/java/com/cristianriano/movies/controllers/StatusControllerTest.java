package com.cristianriano.movies.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class StatusControllerTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate template;

  @Test
  void healthz_shouldReturnOK() {
    assertThat(
        template.getForObject("http://localhost:" + port + "/healthz", String.class)
    ).isEqualTo("OK");
  }
}
