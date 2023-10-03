import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Room} from "./app.component";


@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor(private http: HttpClient) {
    this.http = http;
  }

  private baseUrl: string = 'http://localhost:8888';
  private reservationUrl: string = this.baseUrl + '/room/v1/reservation/'
}
