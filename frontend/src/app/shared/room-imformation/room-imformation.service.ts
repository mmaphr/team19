import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class RoomImformationService {
  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  getRoomAll(): Observable<any> {
    return this.http.get(this.API + '/Room');
  }
  getOlder1(older): Observable<any> {
    return this.http.get(this.API + '/getOlder1OfRoom/' +older);
  }
  getOlder2(older): Observable<any> {
    return this.http.get(this.API + '/getOlder2OfRoom/' +older);
  }
  getOlder3(older): Observable<any> {
    return this.http.get(this.API + '/getOlder3OfRoom/' +older);
  }
  getOlderName(older): Observable<any> {
    return this.http.get(this.API + '/Older/' +older);
  }
  getTypeRoom(): Observable<any> {
    return this.http.get(this.API + '/TypeRooms');
  }
  getRoomName(roomnumber): Observable<any> {
    return this.http.get(this.API + '/getRoomNumber/' +roomnumber);
  }
  getOlderAll(): Observable<any> {
    return this.http.get(this.API + '/OldersName');
  }
}
