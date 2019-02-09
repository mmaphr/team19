import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class TrainAddService {
  public API = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getTrainStaff(): Observable<any>{
    return this.http.get(this.API + '/TrainStaff');
  }

  getTrainType(): Observable<any>{
    return this.http.get(this.API + '/TrainType');
  }

  getStaff(): Observable<any>{
    return this.http.get(this.API + '/Staff');
  }

  getTimeDuration(): Observable<any> {
    return this.http.get(this.API + '/timeDuration/getAll');
  }

}
