import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class StaffService {
  public API = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getProvince(): Observable<any>{
    return this.http.get(this.API + '/Province');
  }

  getPosition(): Observable<any>{
    return this.http.get(this.API + '/Position');
  }

  getGender(): Observable<any>{
    return this.http.get(this.API + '/Gender');
  }

  getStaff(): Observable<any>{
    return this.http.get(this.API + '/Staff');
  }

}
