import { Component, OnInit } from '@angular/core';
import { VisitorService } from '../shared/visitor/visitor.service';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {AddDataOlderService} from '../shared/DataOlder/add-data-older.service';
import {MatSnackBar} from '@angular/material';


@Component({
  selector: 'app-visitor',
  templateUrl: './visitor.component.html',
  styleUrls: ['./visitor.component.css']
})
export class VisitorComponent implements OnInit {
  static older1 : String;
  static older2 : String;
  static older3 : String;
  dataColumns: string[] = ['id','visitorname','numid','gender','age','address','phone','older','status','date'/**/];
  olderData: Array<any>;
  visitorData: Array<any>;
  ShowName: Array<any>;
  provinces: Array<any>;
  genders: Array<any>;
  status:  Array<any>;
  inputData: any = {
    namevisitor: '',
    numid: '',
    gender: '',
    age: '',
    address: '',
    provice: '',
    phone: '',
    older: '',
    status:''

  };
  constructor(private visitorService: VisitorService , private httpClient: HttpClient,private snackBar: MatSnackBar) { }

  ngOnInit() {
    this.visitorService.getProvince().subscribe(data => {
      this.provinces = data;
      console.log(this.provinces);
    });

    this.visitorService.getGender().subscribe(data => {
      this.genders = data;
      console.log(this.genders);
    });
    this.visitorService.getStatus().subscribe(data => {
      this.status = data;
      console.log(this.status);
    });
    this.visitorService.getOlderAll().subscribe(data => {
      this.ShowName = data;
      console.log(this.ShowName);
    });
    this.visitorService.getVisitor().subscribe(data => {
      this.visitorData = data;
      console.log(this.visitorData);
    });



  }

  save(){
    console.log(this.inputData);
    if(this.inputData.namevisitor === '' ||
      this.inputData.numid === '' ||
      this.inputData.gender === '' ||
      this.inputData.age === '' ||
      this.inputData.address === '' ||
      this.inputData.provice === '' ||
      this.inputData.phone === '' ||
      this.inputData.older === ''||
      this.inputData.status === '') {
      this.snackBar.open('กรุณากรอกข้อมูลให้ครบถ้วน',"OK",{duration: 10000});
    } else {
      this.httpClient.post('http://localhost:8080/AddVisitor/' + this.inputData.namevisitor + '/' + this.inputData.numid + '/' + this.inputData.gender + '/' + this.inputData.age + '/'  + this.inputData.provice + '/' + this.inputData.phone + '/' + this.inputData.older + '/' + this.inputData.status , this.inputData)
        .subscribe(data => {
            this.snackBar.open('บันทึกสำเร็จ',"OK",{});
            console.log('PUT Request is successful', data);
            this.visitorService.getOlder1(this.inputData.older).subscribe(
              data => {
                if(data.roomnumber){
                  console.log(data.roomnumber);
                  VisitorComponent.older1 = data.roomnumber;
                  console.log(VisitorComponent.older1);
                  this.snackBar.open("ผู้สูงอายุพักอยู่ที่ห้อง " +VisitorComponent.older1,"OK",{duration: 10000});
                }}
            );
            this.visitorService.getOlder2(this.inputData.older).subscribe(
              data => {
                if(data.roomnumber){
                  console.log(data.roomnumber);
                  VisitorComponent.older1 = data.roomnumber;
                  console.log(VisitorComponent.older1);
                  this.snackBar.open("ผู้สูงอายุพักอยู่ที่ห้อง " +VisitorComponent.older1,"OK",{duration: 10000});
                }}
            );
            this.visitorService.getOlder3(this.inputData.older).subscribe(
              data => {
                if(data.roomnumber){
                  console.log(data.roomnumber);
                  VisitorComponent.older1 = data.roomnumber;
                  console.log(VisitorComponent.older1);
                  this.snackBar.open("ผู้สูงอายุพักอยู่ที่ห้อง " +VisitorComponent.older1,"OK",{duration: 10000});
                }}
            );
            this.inputData.namevisitor = '';
            this.inputData.numid = '' ;
            this.inputData.gender = '';
            this.inputData.age = '';
            this.inputData.address = '';
            this.inputData.provice = '';
            this.inputData.phone = '';
            this.inputData.older = '';
            this.inputData.status = '';
            this.visitorService.getVisitor().subscribe(data => {
              this.visitorData = data;
              console.log(this.visitorData);
            });
          },
          error => {
          if(error.error.message=="ไม่เจอผู้สูงอายุนี้ในห้องพัก") {
            this.snackBar.open(error.error.message, "OK", {duration: 10000});
          }else{
            this.snackBar.open("กรอกข้อมูลผิดพลาด ตรวจสอบเลขบัตรประชาชนหรือเบอร์โทร", "OK", {duration: 10000});

          }
            console.log('Error', error);
          }
        );


    }
  }
}
