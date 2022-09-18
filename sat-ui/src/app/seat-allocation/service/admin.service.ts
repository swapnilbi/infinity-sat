import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map,tap } from 'rxjs/operators';
import { AppConfig } from '../../common/app.config';
import { HttpHelper } from '../../common/utility/utility';
import { Response } from '../../common/model/response.model';
import { SpaceCapacity } from '../model/space-capacity.model';
import { Division } from '../model/division.model';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private httpClient : HttpClient) { }

  public getUserChildDivisions(): Observable<Array<Division>>{             
    const serviceUrl = AppConfig.SERVICE_URL.GET_MANAGER_SUB_DIVISION_LIST;          
    return this.httpClient.get<Response<Array<Division>>>(serviceUrl)
    .pipe(
      map((data) => {
        return data.data;
      }),
      tap(event => {})
    );
  }


}
