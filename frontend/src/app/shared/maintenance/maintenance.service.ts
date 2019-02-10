import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class MaintenanceService {

  public API = '//localhost:8080';

  constructor(private http: HttpClient) {
  }

  getStaff(): Observable<any> {
    return this.http.get(this.API + '/staff/getAll');
  }

  getMaintenanceStart(): Observable<any> {
    return this.http.get(this.API + '/maintenance/getStart');
  }

  getMaintenanceFinish(): Observable<any> {
    return this.http.get(this.API + '/maintenance/getFinish');
  }

  getPlace(): Observable<any> {
    return this.http.get(this.API + '/place/getAll');
  }

}
