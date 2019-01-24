import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class LoginpageService {

  constructor(private http:HttpClient) { }

  login(form:any){
    return this.http.post('//localhost:8080/Login',form);
  }
}
