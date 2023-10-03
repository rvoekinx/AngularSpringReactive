package com.reactivehello.reactivespring.controller;

import com.reactivehello.reactivespring.model.Reservation;
import com.reactivehello.reactivespring.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(ReservationResource.ROOM_V_1_REVERSATION)
@CrossOrigin
public class ReservationResource {

  public static final String ROOM_V_1_REVERSATION = "/room/v1/reservation/";

  private final ReservationService reservationService;

  @Autowired
  public ReservationResource(
      ReservationService reservationService) {
    this.reservationService = reservationService;
  }

  @GetMapping(path = "{roomId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<Reservation> getReservationById(@PathVariable String roomId) {
    return reservationService.getReservation(roomId);
  }

  @PostMapping(path = "",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public Mono<Reservation> createReservation(@RequestBody Mono<Reservation> reservationMono) {
    return reservationService.createReservation(reservationMono);
  }

  @PutMapping(path = "{roomId}",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public Mono<Reservation> updatePrice(@RequestBody Mono<Reservation> reservation,
      @PathVariable Long roomId) {
    return reservationService.updateReservation(roomId, reservation);
  }

  @DeleteMapping(path = "{roomId}")
  public Mono<Boolean> deleteReservation(@PathVariable String roomId) {
    return Mono.just(true);
  }
}
