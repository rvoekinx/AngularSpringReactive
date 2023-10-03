import {Component} from '@angular/core';
import {ReservationService} from "./reservation.service";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'reservation-app';

  roomSearchForm: FormGroup;
  currentCheckInVal: string = '';
  currentCheckoutVal: string = '';
  currentPrice: number = 0;
  currentRoomNumber: number = 0;

  constructor(private reservationService: ReservationService) {
    this.rooms = [
      new Room("127", "127", "150"),
      new Room("130", "130", "180"),
      new Room("140", "140", "200"),
    ]
    this.currentRoomNumber = 0;

    this.roomSearchForm = new FormGroup<any>({
      checkin: new FormControl(''),
      checkout: new FormControl(''),
      roomNumber: new FormControl('')
    });

    this.roomSearchForm.valueChanges.subscribe(form => {
      this.currentCheckInVal = form.checkin;
      this.currentCheckoutVal = form.checkout;
      if (form.roomNumber) {
        let roomValues: string[] = form.roomNumber.split('|');
        this.currentRoomNumber = Number(roomValues[0]);
        this.currentPrice = Number(roomValues[1]);
      }
    })
  }

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
