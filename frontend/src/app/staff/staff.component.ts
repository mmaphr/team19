import { Component, OnInit } from '@angular/core';
import { StaffService } from '../shared/staff-service/staff.service';
import { HttpClient} from '@angular/common/http';
import { Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-staff',
  templateUrl: './staff.component.html',
  styleUrls: ['./staff.component.css']
})
export class StaffComponent implements OnInit {

  provinces: Array<any>;
  genders: Array<any>;
  positions: Array<any>;

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

  constructor(private staffService:StaffService ,private httpClient: HttpClient ) { }

  ngOnInit() {
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
    this.staffData.address===''||
    this.staffData.phone===''||
    this.staffData.username===''||
    this.staffData.password===''){
    alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    }else{
    this.httpClient.post('http://localhost:8080/newStaff/' + this.staffData.genderSelect + '/' + this.staffData.provinceSelect + '/' + this.staffData.positionSelect + '/' + this.staffData.staffAge, this.staffData).subscribe(
      data => {
        alert('การเก็บข้อมูลเสร็จเรียบร้อย');
        console.log('PUT Request is successful', data);
      },
      error => {
        alert('เกิดข้อผิดพลาด');
        console.log('Error', error);
      });
    }

  }

}
