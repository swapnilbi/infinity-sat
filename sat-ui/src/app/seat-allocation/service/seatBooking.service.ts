import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SeatBookingService {
  private selectedSeat = new BehaviorSubject({
    status:null,
    number: null,
    section: null,
canBeBooked: null
});
  constructor(private http: HttpClient) { }
  updateSelectedSeat(seat){
    this.selectedSeat.next(seat);
  }
  getSelectedSeat(){
    return this.selectedSeat.asObservable();
  }
  getSeats(param){
    const getURL = 'getURL';
    return this.http.post(getURL, param);
  }
  bookSeat(seatData){
    console.log("seatData", seatData);
  }
  searchSeats(param){
    const searchURL = 'seatURL';
    return this.http.post(searchURL, param);
  }
}
