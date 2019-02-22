import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {InActService} from '../shared/inAct/in-act.service';
import {MatSnackBar} from '@angular/material';

@Component({
  selector: 'app-in-act-add',
  templateUrl: './in-act-add.component.html',
  styleUrls: ['./in-act-add.component.css']
})
export class InActAddComponent implements OnInit {
  displayedColumns: string[] = ['day', 'time', 'actName', 'description', 'staff'];
  day: Array<any>;
  time: Array<any>;
  staff: Array<any>;
  inActData: any = {
    actNameInput: '',
    daySelect: '',
    descriptionInput: '',
    timeSelect: '',
    staffSelect: ''
  };
  showAct: Array<any>;

  constructor(private inActService: InActService, private httpClient: HttpClient, private router: Router, private snackBar: MatSnackBar) {
  }

  ngOnInit() {
    this.inActService.getDaysOfTheWeek().subscribe(data => {
      this.day = data;
      console.log(this.day);
    });
    this.inActService.getTimeDuration().subscribe(data => {
      this.time = data;
      console.log(this.time);
    });
    this.inActService.getStaff().subscribe(data => {
      this.staff = data;
      console.log(this.staff);
    });
    this.inActService.getInAct().subscribe(data => {
      this.showAct = data;
      console.log(this.showAct);
    });
  }

  save() {
    if (this.inActData.actNameInput === '') {
      this.snackBar.open('กรุณากรอกชื่อกิจกรรม', 'OK', {});
    } else if (this.inActData.daySelect === '' || this.inActData.timeSelect === '') {
      this.snackBar.open('กรุณาเลือกวันและเวลาของกิจกรรม', 'OK', {});
    } else if (this.inActData.staffSelect === '') {
      this.snackBar.open('กรุณาเลือกผู้ดูแลหรือผู้รับผิดชอบกิจกรรม', 'OK', {});
    } else {
      if (this.inActData.descriptionInput === '') {
        this.inActData.descriptionInput = '---';
      }
      this.httpClient.post('http://localhost:8080/internalActivity/add/' + this.inActData.actNameInput + '/' + this.inActData.descriptionInput + '/' + this.inActData.staffSelect + '/' + this.inActData.daySelect + '/' + this.inActData.timeSelect, this.inActData).subscribe(
        data => {
          console.log('PUT Request is successful', data);
          this.snackBar.open('เพิ่มรายการกิจกรรมสำเร็จ', 'OK', {});
          this.inActData.actNameInput = '';
          this.inActData.daySelect = '';
          this.inActData.descriptionInput = '';
          this.inActData.timeSelect = '';
          this.inActData.staffSelect = '';
          this.inActService.getInAct().subscribe(data => {
            this.showAct = data;
            console.log(this.showAct);
          });
        },
        error => {
          console.log('Error', error);
          this.snackBar.open('ชื่อกิจกรรมไม่ถูกต้อง หรือมีกิจกรรมในเวลาดังกล่าวแล้ว', 'OK', {});
        });
    }
  }
}
