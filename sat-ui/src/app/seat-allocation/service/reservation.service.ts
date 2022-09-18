import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfig } from 'src/app/common/app.config';
import { Observable } from 'rxjs';
import { map,tap } from 'rxjs/operators';
import { Response } from 'src/app/common/model/response.model';
import { CreateReservationDetails } from '../model/create-reservation-details.model';


@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor(private httpClient : HttpClient) { }

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

}
