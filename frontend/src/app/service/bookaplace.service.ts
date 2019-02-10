import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable()
export class BookaplaceService {

  constructor(private http: HttpClient) { }


public API = '//localhost:8080';

  public getAllPlace(): Observable<any> {
    return this.http.get(this.API + '/Place');
  }
  public getAllBookAPlace(): Observable<any> {
    return this.http.get(this.API + '/Bookaplace');
  }
  public getAllOut(id): Observable<any> {
    return this.http.get(this.API + '/out/' + id );
  }

}
