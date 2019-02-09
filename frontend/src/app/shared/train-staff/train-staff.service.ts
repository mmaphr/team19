import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class TrainStaffService {
  public API = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getTrainStaff(): Observable<any>{
    return this.http.get(this.API + '/TrainStaff');
  }

  getStaff(): Observable<any>{
    return this.http.get(this.API + '/Staff');
  }

  getTrainAndStaff(): Observable<any>{
    return this.http.get(this.API + '/TrainAndStaff');
  }
}
