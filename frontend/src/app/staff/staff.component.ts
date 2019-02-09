import { Component, OnInit } from '@angular/core';
import { StaffService } from '../shared/staff-service/staff.service';
import { HttpClient} from '@angular/common/http';
import { Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import {MatSnackBar} from '@angular/material';

@Component({
  selector: 'app-staff',
  templateUrl: './staff.component.html',
  styleUrls: ['./staff.component.css']
})
export class StaffComponent implements OnInit {

  provinces: Array<any>;
  genders: Array<any>;
  positions: Array<any>;
  staffs: Array<any>;
  staffData: any = {
    staffName: '',
    staffAge: '',
    address: '',
    phone:'',
    username:'',
    password:'',
    genderSelect:'',
    provinceSelect:'',
    positionSelect:''
  };
  dataColumns: string[] = ['no','staffname','address', 'province' ,'age', 'gender' ,'phone','username','password', 'position'];
  constructor(private snackBar: MatSnackBar,private staffService:StaffService ,private httpClient: HttpClient ) { }

  ngOnInit() {
    this.staffService.getStaff().subscribe(data =>{
      this.staffs = data;
      console.log(this.staffs);
    })

    this.staffService.getProvince().subscribe(data =>{
      this.provinces = data;
      console.log(this.provinces);
    })

    this.staffService.getPosition().subscribe(data =>{
      this.positions = data;
      console.log(this.positions);
    })

    this.staffService.getGender().subscribe(data =>{
      this.genders = data;
      console.log(this.genders);
    })
  }

  save(){
    if( this.staffData.staffName ===''||
    this.staffData.staffAge===''||
    this.staffData.address===''||
    this.staffData.phone===''||
    this.staffData.username===''||
    this.staffData.password===''||
    this.staffData.genderSelect===''||
    this.staffData.provinceSelect===''||
    this.staffData.positionSelect===''){
    this.snackBar.open('กรุณากรอกข้อมูลให้ครบถ้วนและถูกต้อง','OK');
    }else{
    this.httpClient.post('http://localhost:8080/newStaff/' + this.staffData.genderSelect + '/' + this.staffData.provinceSelect + '/' + this.staffData.positionSelect + '/' + this.staffData.staffAge, this.staffData).subscribe(
      data => {
        
        console.log('PUT Request is successful', data);
        this.staffData.staffName = '';
        this.staffData.staffAge = '';
        this.staffData.address = '';
        this.staffData.phone = '';
        this.staffData.username = '';
        this.staffData.password = '';
        this.staffData.genderSelect = '';
        this.staffData.provinceSelect = '';
        this.staffData.positionSelect = '';

        this.staffService.getStaff().subscribe(data =>{
          this.staffs = data;
          console.log(this.staffs);
        })
        this.snackBar.open('การเก็บข้อมูลเสร็จเรียบร้อย','OK');
      },
      error => {
        console.log('Error', error);
        this.snackBar.open('เกิดข้อผิดพลาด','OK');
      });
    }

  }

}
