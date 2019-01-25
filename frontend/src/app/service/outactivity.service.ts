import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable()
export class OutactivityService {

  constructor(private http: HttpClient) {
  }

  public API = '//localhost:8080';

  public getAllCategory(): Observable<any> {
    return this.http.get(this.API + '/CategoryActivity');
  }

  public getOutActivity(): Observable<any> {
    return this.http.get(this.API + '/OutActivity');
  }

  public getAllOrganized(): Observable<any> {
    return this.http.get(this.API + '/Organized');
  }

  public getAllPeriodTime(): Observable<any> {
    return this.http.get(this.API + '/PeriodTime');
  }
  public getStaff(): Observable<any> {
    return this.http.get(this.API + '/Staff');
  }

  public postOutActivity(object: any, category_id: number, organized_id: number, periodTimeS_id: number, periodTimeE_id: number, staffId: number): Observable<any> {
   return this.http.post(this.API + '/outactivity/' + category_id + '/' + organized_id + '/' + periodTimeS_id + '/' + periodTimeE_id + '/'+staffId, {
      'nameActivity': object.nameActivity,
      'nameRequestor': object.nameRequestor,
      'phonenum': object.phonenum,
      'descriptionActivity': object.descriptionActivity,
      'date': object.date
    });


  }
}
