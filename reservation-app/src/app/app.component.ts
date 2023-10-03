import {Component} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'reservation-app';

  constructor(private http: HttpClient) {
    this.rooms = [
      new Room("127", "127", "150"),
      new Room("130", "130", "180"),
      new Room("140", "140", "200"),
    ]
  }

  private baseUrl: string = 'http://localhost:8888';
  private reservationUrl: string = this.baseUrl + '/room/v1/reservation/'

  rooms: Room[];

}

export class Room {
  id: string;
  roomNumber: string;
  price: string;

  constructor(id: string, roomNumber: string, price: string) {
    this.id = id;
    this.roomNumber = roomNumber;
    this.price = price;
  }
}
