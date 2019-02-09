import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class WithdrawService {

  public API = '//localhost:8080';
  constructor(private http: HttpClient) { }

  getwithdrawcategory ():  Observable<any> {
    return this.http.get(this.API + '/WithdrawCategory');
  }
  getwithdrawItemName (category):  Observable<any> {
    return this.http.get(this.API + '/WithdrawItemName/' + category);
  }
  getWithdrawDepartment ():  Observable<any> {
    return this.http.get(this.API + '/WithdrawDepartment');
  }
  getWithdrawStock ():  Observable<any> {
    return this.http.get(this.API + '/WithdrawStock');
  }
  getWithdraw ():  Observable<any> {
    return this.http.get(this.API + '/ShowWithdraw');
  }
}
