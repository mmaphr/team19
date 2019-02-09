import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class HealthCheckService {
  public API = '//localhost:8080';
  constructor(private http: HttpClient) { }

  getHealthCheckType(): Observable<any> {
    return this.http.get(this.API + '/HealthCheckType');
  }

  getDataOlder(id): Observable<any> {
    return this.http.get(this.API + '/HealthCheck/'+id);
  }

}
