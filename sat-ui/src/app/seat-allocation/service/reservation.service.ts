import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfig } from 'src/app/common/app.config';
import { BehaviorSubject, Observable } from 'rxjs';
import { map,tap } from 'rxjs/operators';
import { Response } from 'src/app/common/model/response.model';
import { CreateReservationDetails } from '../model/create-reservation-details.model';
import { SearchSeatInput } from '../model/search-seat-input.model';
import { BookingDetails } from '../model/booking-details.model';
import { HttpHelper } from 'src/app/common/utility/utility';
import { Seat } from '../model/seat.model';
import { BookSeatInput } from '../model/book-seat-input.model';


@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  private selectedSeat = new BehaviorSubject({
    seat: {},
    zoneName: ''
   });

  private refreshSearch = new BehaviorSubject(false);

  constructor(private httpClient : HttpClient) {
   }

  updateSelectedSeat(seatDetail: {seat: Seat, zoneName: string}){
    this.selectedSeat.next(seatDetail);
  }

  updateRefreshSearch(isRefreshSearch: any){
    this.refreshSearch.next(isRefreshSearch);
  }
  getSelectedSeat(){
    return this.selectedSeat.asObservable();
  }
  doRefreshSearch(){
    return this.refreshSearch.asObservable();
  }

  public initReservation(): Observable<CreateReservationDetails>{
    const serviceUrl = AppConfig.SERVICE_URL.INIT_RESERVATION;
    return this.httpClient.get<Response<CreateReservationDetails>>(serviceUrl)
    .pipe(
      map((data) => {
        return data.data;
      }),
      tap(event => {})
    );
  }

  public searchSeats(searchSeatInput : SearchSeatInput): Observable<any>{
    const serviceUrl = AppConfig.SERVICE_URL.SEARCH_SEATS;
    return this.httpClient.post<Response<any>>(serviceUrl,searchSeatInput)
    .pipe(
      map((data) => {
        return data.data;
      }),
      tap(event => {})
    );
  }

  public viewBookedReservation(searchSeatInput : SearchSeatInput): Observable<any>{
    const serviceUrl = AppConfig.SERVICE_URL.VIEW_BOOKED_SEATS;
    return this.httpClient.post<Response<any>>(serviceUrl,searchSeatInput)
    .pipe(
      map((data) => {
        return data.data;
      }),
      tap(event => {})
    );
  }

  public getBookingHistory(): Observable<Array<BookingDetails>>{
    const serviceUrl = AppConfig.SERVICE_URL.RESERVATION_HISTORY_SEATS;
    return this.httpClient.get<Response<Array<BookingDetails>>>(serviceUrl)
    .pipe(
      map((data) => {
        return data.data;
      }),
      tap(event => {})
    );
  }

  public bookSeat(seatDetail : BookSeatInput): Observable<any>{
      const serviceUrl = AppConfig.SERVICE_URL.BOOK_SEAT;
      return this.httpClient.post<Response<any>>(serviceUrl,seatDetail)
      .pipe(
        map((data) => {
          return data.data;
        }),
        tap(event => {})
      );
  }

  public getNextSlots(seatDetail : BookSeatInput): Observable<any>{
      const serviceUrl = AppConfig.SERVICE_URL.GET_NEXT_SLOTS;
      return this.httpClient.post<Response<any>>(serviceUrl,seatDetail)
      .pipe(
        map((data) => {
          return data.data;
        }),
        tap(event => {})
      );
  }

  public cancelBooking(reservation : BookingDetails): Observable<any>{
    let queryParams: any = {
      'id' : reservation.id
    }
    const serviceUrl = HttpHelper.getUrl(AppConfig.SERVICE_URL.CANCEL_RESERVATION,queryParams);
    return this.httpClient.delete<Response<any>>(serviceUrl)
    .pipe(
      map((data) => {
        return data.data;
      }),
      tap(event => {})
    );
  }


}
