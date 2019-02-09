import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class AddDataOlderService {
  public API = '//localhost:8080';
  constructor(private http: HttpClient) { }

  getProvince(): Observable<any> {
    return this.http.get(this.API + '/Province');
  }

  getGender():Observable<any> {
    return this.http.get(this.API + '/Gender');
  }

  getDisease():Observable<any> {
    return this.http.get(this.API + '/OlderDisease');
  }

  getOlder():Observable<any> {
    return this.http.get(this.API + '/DataOlderAll');
  }

  getOlderid(id):Observable<any> {
    return this.http.get(this.API + '/DataOlder/' + id );
  }
  getOlderDataAndDiseaseid(id):Observable<any> {
    return this.http.get(this.API + '/OlderDataAndDisease/'+id);
  }
}
