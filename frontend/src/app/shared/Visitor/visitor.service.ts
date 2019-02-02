import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class VisitorService {
  public API = '//localhost:8080';
  constructor(private http: HttpClient) { }

  getProvince(): Observable<any> {
    return this.http.get(this.API + '/Province');
  }

  getGender():Observable<any> {
    return this.http.get(this.API + '/Gender');
  }

  getStatus():Observable<any> {
    return this.http.get(this.API + '/relativeStatus');
  }

  getOlderAll(): Observable<any> {
    return this.http.get(this.API + '/OldersName');
  }

  getVisitor(): Observable<any> {
    return this.http.get(this.API + '/Visitor');
  }
  getOlder1(older): Observable<any> {
    return this.http.get(this.API + '/checkOlder1OfRoom/' +older);
  }
  getOlder2(older): Observable<any> {
    return this.http.get(this.API + '/checkOlder2OfRoom/' +older);
  }
  getOlder3(older): Observable<any> {
    return this.http.get(this.API + '/checkOlder3OfRoom/' + older);
  }
}
