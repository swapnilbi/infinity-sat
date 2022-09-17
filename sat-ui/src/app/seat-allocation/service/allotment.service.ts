import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map,tap } from 'rxjs/operators';
import { CreateAllotmentDetails } from '../model/create-allotment-details.model';
import { CreateAllotmentInput } from '../model/create-allotment-input.model';
import { AllotmentDetails } from '../model/allotment-details.model';
import { AppConfig } from '../../common/app.config';
import { HttpHelper } from '../../common/utility/utility';
import { Response } from '../../common/model/response.model';
import { SpaceCapacity } from '../model/space-capacity.model';

@Injectable({
  providedIn: 'root'
})
export class AllotmentService {

  constructor(private httpClient : HttpClient) { }

  public getAllotments(): Observable<Array<AllotmentDetails>>{        
    const serviceUrl = AppConfig.SERVICE_URL.GET_ALLOTMENTS_URL;    
    return this.httpClient.get<Response<Array<AllotmentDetails>>>(serviceUrl)
    .pipe(
      map((data) => {
        return data.data;
      }),
      tap(event => {})
    );
  }

  public getAllotmentsByZone(zoneId : number): Observable<Array<AllotmentDetails>>{        
    let queryParams: any = {
      'zoneId' : zoneId
    }        
    const serviceUrl = HttpHelper.getUrl(AppConfig.SERVICE_URL.GET_ALLOTMENTS_BY_ZONE_URL,queryParams);    
    return this.httpClient.get<Response<Array<AllotmentDetails>>>(serviceUrl)
    .pipe(
      map((data) => {
        return data.data;
      }),
      tap(event => {})
    );
  }


  public getSpaceCapacityList(): Observable<Array<SpaceCapacity>>{        
    const serviceUrl = AppConfig.SERVICE_URL.GET_SPACE_CAPACITY_URL;    
    return this.httpClient.get<Response<Array<SpaceCapacity>>>(serviceUrl)
    .pipe(
      map((data) => {
        return data.data;
      }),
      tap(event => {})
    );
  }

  public initAllotment(): Observable<CreateAllotmentDetails>{        
    const serviceUrl = AppConfig.SERVICE_URL.INIT_SPACE_ALLOTMENT;
    return this.httpClient.get<Response<CreateAllotmentDetails>>(serviceUrl)
    .pipe(
      map((data) => {
        return data.data;
      }),
      tap(event => {})
    );
  }

  public createAllotment(createAllotmentForm : CreateAllotmentInput): Observable<any>{        
    const serviceUrl = AppConfig.SERVICE_URL.CREATE_ALLOTMENT;    
    return this.httpClient.post<Response<any>>(serviceUrl,createAllotmentForm)
    .pipe(
      map((data) => {
        return data.data;
      }),
      tap(event => {})
    );
  }

}
