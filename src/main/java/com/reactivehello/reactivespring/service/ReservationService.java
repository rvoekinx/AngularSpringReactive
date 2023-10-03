package com.reactivehello.reactivespring.service;

import com.reactivehello.reactivespring.model.Reservation;
import reactor.core.publisher.Mono;

public interface ReservationService {

  Mono<Reservation> getReservation(String id);

  Mono<Reservation> createReservation(Mono<Reservation> reservationMono);

  Mono<Reservation> updateReservation(Long id, Mono<Reservation> reservationMono);

  Mono<Boolean> deleteReservation(Long id);

}
