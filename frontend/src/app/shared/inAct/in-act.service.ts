import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class InActService {

  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  getDaysOfTheWeek(): Observable<any> {
    return this.http.get(this.API + '/daysOfTheWeek/getAll');
  }

  getTimeDuration(): Observable<any> {
    return this.http.get(this.API + '/timeDuration/getAll');
  }

  getStaff(): Observable<any> {
    return this.http.get(this.API + '/staff/getAll');
  }

  getInAct(): Observable<any> {
      return this.http.get(this.API + '/internalActivity/getAll');
  }

}
