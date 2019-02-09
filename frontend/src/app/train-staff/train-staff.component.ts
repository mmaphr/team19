import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { TrainStaffService } from '../shared/train-staff/train-staff.service';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-train-staff',
  templateUrl: './train-staff.component.html',
  styleUrls: ['./train-staff.component.css']
})
export class TrainStaffComponent implements OnInit {

  trainstaff: Array<any>;
  training: Array<any>;
  staffs: Array<any>;
  trainingData: any = {
    trainstaffSelect:'',
    staffsSelect:''
  };

  dataColumns: string[] = ['no','trainname','staffname','date','type','description','etc'];

  constructor(private snackBar: MatSnackBar,private trainStaffService: TrainStaffService,private httpClient: HttpClient) { }
  

  ngOnInit() {
    this.trainStaffService.getTrainStaff().subscribe(data => {
      this.trainstaff = data;
      console.log(this.trainstaff);
    });
    this.trainStaffService.getTrainAndStaff().subscribe(data => {
      this.training = data;
      console.log(this.training);
    });
    this.trainStaffService.getStaff().subscribe(data => {
      this.staffs = data;
      console.log(this.staffs);
    });
  }

  save(id){
    if( this.trainingData.staffsSelect===''){
    this.snackBar.open('กรุณากรอกข้อมูลให้ครบถ้วนและถูกต้อง','OK');
    }else{
    this.httpClient.post('http://localhost:8080/Training/' + id + '/' + this.trainingData.staffsSelect, this.trainingData).subscribe(
      data => {
        console.log('PUT Request is successful', data);
        this.trainingData.trainstaffSelect = '';
        this.trainingData.staffsSelect = '';
        this.trainStaffService.getTrainAndStaff().subscribe(data => {
          this.training = data;
          console.log(this.training);
        });
        this.snackBar.open('การเก็บข้อมูลเสร็จเรียบร้อย','OK');
      },
      error => {
        console.log('Error', error);
        this.snackBar.open('พนักงานเข้าร่วมแล้ว','OK');
      });
    }
  }

}
