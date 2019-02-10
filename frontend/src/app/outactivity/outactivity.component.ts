import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {OutactivityService} from '../service/outactivity.service';
import {RouterModule, Routes, Router} from '@angular/router';
import { ShowsOutActivityComponent } from '../shows-out-activity/shows-out-activity.component';
import {MatSnackBar} from '@angular/material';

export interface Typ {
  value: string;
  viewValue: string;
}
@Component({
  selector: 'app-outactivity',
  templateUrl: './outactivity.component.html',
  styleUrls: ['./outactivity.component.css']
})
export class OutactivityComponent implements OnInit {
  typs: Array<any>
  organiz: Array<any>
  dat: Array<any>
  staf: Array<any>
  categoryActivityIDSelected: number
  organizedIDSelected: number
  periodTimeSIDSelected: number
  periodTimeEIDSelected: number
  staffIDSelected: number
  outact: any =
    {
      nameActivity: '',
      nameRequestor: '',
      phonenum: '',
      descriptionActivity: '',
      date: '',
      categoryActivity: {},
      organized: {},
      periodTimeS: {},
      periodTimeE: {},
      staffIDSelected:{}

    }

  constructor(private httpClient: HttpClient, private outactivityService: OutactivityService, private router: Router , private snackBar: MatSnackBar ) {
  }

  ngOnInit() {
    this.getCategorys();
    this.getOrganizeds();
    this.getPeriodTimes();
    this.getStaffs();

  }

  getCategorys() {
    this.outactivityService.getAllCategory().subscribe(data => {
      this.typs = data;
    });
  }

  getOrganizeds() {
    this.outactivityService.getAllOrganized().subscribe(data => {
      this.organiz = data;
    });
  }

  getPeriodTimes() {
    this.outactivityService.getAllPeriodTime().subscribe(data => {
      this.dat = data;
    });
  }
  getStaffs() {
    this.outactivityService.getStaff().subscribe(data => {
      this.staf = data;
    });
  }

  submit() {
    if (this.outact.nameActivity === '' ||
      this.outact.nameRequestor === '' ||
      this.outact.phonenum === '' ||
      this.outact.categoryActivityIDSelected === '' ||
      this.outact.organizedIDSelected === '' ||
      this.outact.descriptionActivity === '' ||
      this.outact.periodTimeS === '' ||
      this.outact.periodTimeE === '' ||
      this.outact.date === ''||
    this.outact.staffIDSelected==='')
      this.snackBar.open('กรุณากรอกข้อมูลให้ครบถ้วน', 'Ok');
    else {
      this.outactivityService.postOutActivity(this.outact,
        this.categoryActivityIDSelected, this.organizedIDSelected,
        this.periodTimeSIDSelected, this.periodTimeEIDSelected, this.staffIDSelected ).subscribe(data => {
        console.log(data);
          this.snackBar.open('Request is successful', 'Ok');
          this.router.navigate(['showsOutActivity']);
      }
      ,error => {
          this.snackBar.
          open('Request is not successful', 'Ok');
        console.log('Error', error);
      }
    )
      ;
    }
  }

}
