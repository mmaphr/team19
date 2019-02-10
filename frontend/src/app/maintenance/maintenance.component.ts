import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {MaintenanceService} from '../shared/maintenance/maintenance.service';

@Component({
  selector: 'app-maintenance',
  templateUrl: './maintenance.component.html',
  styleUrls: ['./maintenance.component.css']
})
export class MaintenanceComponent implements OnInit {

  constructor(private maintenanceService: MaintenanceService, private httpClient: HttpClient, private router: Router) {
  }

  displayedStartColumns: string[] = ['dateStartAndTimeStart', 'place', 'maintenanceName', 'description', 'staff', 'update'];
  displayedFinishColumns: string[] = ['dateStartAndTimeStart', 'dateFinishAndTimeFinish', 'place', 'maintenanceName', 'description', 'staff'];
  staff: Array<any>;
  place: Array<any>;
  maintenanceData: any = {
    maintenanceNameInput: '',
    placeSelect: '',
    descriptionInput: '',
    dateStart: '',
    timeStart: '',
    staffSelect: ''
  };
  showMaintenanceStart: Array<any>;
  showMaintenanceFinish: Array<any>;
  getMaintenanceId: Array<any>;

  ngOnInit() {
    this.maintenanceService.getStaff().subscribe(data => {
      this.staff = data;
      console.log(this.staff);
    });

    this.maintenanceService.getPlace().subscribe(data => {
      this.place = data;
      console.log(this.place);
    });

    this.maintenanceService.getMaintenanceStart().subscribe(data => {
      this.showMaintenanceStart = data;
      console.log(this.showMaintenanceStart);
    });

    this.maintenanceService.getMaintenanceFinish().subscribe(data => {
      this.showMaintenanceFinish = data;
      console.log(this.showMaintenanceFinish);
    });
  }

  save() {
    if (this.maintenanceData.maintenanceNameInput === '') {
      alert('กรุณากรอกชื่อการซ่อม');
    } else if (this.maintenanceData.dateStart === '' || this.maintenanceData.timeStart === '') {
      alert('กรุณาเลือกวันและเวลาของการซ่อม');
    } else if (this.maintenanceData.staffSelect === '') {
      alert('กรุณาเลือกผู้รับผิดชอบการซ่อม');
    } else {
      if (this.maintenanceData.descriptionInput === '') {
        this.maintenanceData.descriptionInput = '---';
      }
      this.httpClient.post('http://localhost:8080/maintenance/add/' + this.maintenanceData.maintenanceNameInput + '/' +
        this.maintenanceData.placeSelect + '/' + this.maintenanceData.descriptionInput + '/' + this.maintenanceData.dateStart + '/Mon%20Jan%2001%202019%20' + this.maintenanceData.timeStart + ':00%20GMT+7/' + this.maintenanceData.staffSelect,
        this.maintenanceData).subscribe(
        data => {
          console.log('PUT Request is successful', data);
          alert('เพิ่มรายการกิจกรรมสำเร็จ');
          this.maintenanceData.maintenanceNameInput = '';
          this.maintenanceData.descriptionInput = '';
          this.maintenanceData.dateStart = '';
          this.maintenanceData.timeStart = '';
          this.maintenanceData.staffSelect = '';
          this.maintenanceData.placeSelect = '';
          this.maintenanceService.getMaintenanceStart().subscribe(data2 => {
            this.showMaintenanceStart = data2;
            console.log(this.showMaintenanceStart);
          });
        },
        error => {
          console.log('Error', error);
          alert('Staff คนนี้ไม่ว่างในเวลาดังกล่าว');
        });
    }
  }

  update(maintenanceId) {
    this.httpClient.put('http://localhost:8080/maintenance/update/' + maintenanceId, this.getMaintenanceId).subscribe(
      data => {
        console.log('PUT Request is successful', data);
        alert('Update รายการซ่อมเสร็จสิ้น');
        this.maintenanceService.getMaintenanceStart().subscribe(data1 => {
          this.showMaintenanceStart = data1;
          console.log(this.showMaintenanceStart);
        });
        this.maintenanceService.getMaintenanceFinish().subscribe(data1 => {
          this.showMaintenanceFinish = data1;
          console.log(this.showMaintenanceFinish);
        });
      }, error => {
        console.log('Error', error);
      });
  }

}
