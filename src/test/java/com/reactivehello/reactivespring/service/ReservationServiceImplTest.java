package com.reactivehello.reactivespring.service;

import com.reactivehello.reactivespring.controller.ReservationResource;
import com.reactivehello.reactivespring.model.Reservation;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ReservationServiceImplTest {

  @Autowired
  private ApplicationContext context;

  private WebTestClient webTestClient;
  private Reservation reservation;

  @BeforeEach
  void setUp() {
    webTestClient = WebTestClient.bindToApplicationContext(this.context).build();
    reservation = new Reservation(123L, LocalDate.now(), LocalDate.now().plus(10, ChronoUnit.DAYS),
        180);
  }

  @Test
  void createReservation() {
    webTestClient.post().uri(ReservationResource.ROOM_V_1_REVERSATION)
        .body(Mono.just(reservation), Reservation.class)
        .exchange()
        .expectStatus().isOk()
        .expectHeader().contentType(MediaType.APPLICATION_JSON)
        .expectBody(Reservation.class);
  }

  @Test
  void listAllReservations() {
    webTestClient.get().uri(ReservationResource.ROOM_V_1_REVERSATION)
        .exchange().expectStatus().isOk().expectBodyList(Reservation.class);
  }
}
