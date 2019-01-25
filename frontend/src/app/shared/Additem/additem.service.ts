import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class AdditemService {
  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  getcategory ():  Observable<any> {
    return this.http.get(this.API + '/Category');
  }
  getnote ():  Observable<any> {
    return this.http.get(this.API + '/Note');
  }
  getstock ():  Observable<any> {
    return this.http.get(this.API + '/Stock');
  }
  getShowAddItem ():  Observable<any> {
    return this.http.get(this.API + '/ShowAddItem');
  }
}

