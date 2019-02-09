import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { TrainAddService } from '../shared/train-add/train-add.service';
import {MatSnackBar} from '@angular/material';

@Component({
  selector: 'app-train-add',
  templateUrl: './train-add.component.html',
  styleUrls: ['./train-add.component.css']
})
export class TrainAddComponent implements OnInit {

  traintypes: Array<any>;
  times: Array<any>;
  staffs: Array<any>;
  trainstaff: Array<any>;
  trainData: any = {
    trainName: '',
    trainDescription: '',
    trainDate: '',
    traintypesSelect:'',
    timesSelect:'',
    staffsSelect:''
  };

  dataColumns: string[] = ['no','trainname','staffname','date','type','description'];

  constructor(private snackBar: MatSnackBar,private trainAddService: TrainAddService,private httpClient: HttpClient) { }

  ngOnInit() {
    this.trainAddService.getTrainStaff().subscribe(data => {
      this.trainstaff = data;
      console.log(this.trainstaff);
    });
    this.trainAddService.getTimeDuration().subscribe(data => {
      this.times = data;
      console.log(this.times);
    });
    this.trainAddService.getStaff().subscribe(data => {
      this.staffs = data;
      console.log(this.staffs);
    });
    this.trainAddService.getTrainType().subscribe(data => {
      this.traintypes = data;
      console.log(this.traintypes);
    });
  }

  save(){
    if( this.trainData.trainName ===''||
    this.trainData.trainDescription===''||
    this.trainData.trainDate===''){
    this.snackBar.open('กรุณากรอกข้อมูลให้ครบถ้วนและถูกต้อง','OK');
    }else{
    this.httpClient.post('http://localhost:8080/newTrain/' + this.trainData.trainName + '/' 
                                                           + this.trainData.trainDescription + '/' 
                                                           + this.trainData.timesSelect + '/' 
                                                           + this.trainData.traintypesSelect + '/'
                                                           + this.trainData.staffsSelect + '/'
                                                           + this.trainData.trainDate, this.trainData).subscribe(
      data => {
        console.log('PUT Request is successful', data);
        this.trainData.trainName = '';
        this.trainData.trainDescription = '';
        this.trainData.timesSelect = '';
        this.trainData.traintypesSelect = '';
        this.trainData.staffsSelect = '';
        this.trainData.trainDate = '';

        this.trainAddService.getTrainStaff().subscribe(data => {
          this.trainstaff = data;
          console.log(this.trainstaff);
        });
        this.snackBar.open('การเก็บข้อมูลเสร็จเรียบร้อย','OK');
      },
      error => {
        console.log('Error', error);
        this.snackBar.open('เกิดข้อผิดพลาด','OK');
      });
    }
  }

}
