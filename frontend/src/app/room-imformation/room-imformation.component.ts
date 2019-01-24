import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { MatDialogRef } from '@angular/material';
import {Router} from '@angular/router';
import { SafeResourceUrl, DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';
import { RoomImformationService } from '../shared/room-imformation/room-imformation.service';

@Component({
  selector: 'app-room-imformation',
  templateUrl: './room-imformation.component.html',
  styleUrls: ['./room-imformation.component.css']
})
export class RoomImformationComponent implements OnInit {
  static older1 : String;
  static older11 : boolean = false;
  static older2 : String;
  static older21 : boolean = false;
  static older3 : String;
  static older31 : boolean = false;

  showAllColumns: string[] = ['room','older'];
  roomImData : any = {
  nameInput:''
  };

  constructor(private router: Router, private rout: ActivatedRoute,private roomImformationService:RoomImformationService , private httpClient: HttpClient,private sanitizer: DomSanitizer) {
        this.sanitizer = sanitizer;
  }

  ngOnInit() {


  }
  search(){
    if(this.roomImData.nameInput ===''){
        alert('กรุณากรอกข้อมูลให้ครบถ้วน ค้นหาไม่สำเร็จ');
    }else if(this.roomImData.nameInput ==='allData'){
        alert('ค้นหาทั้งหมด');
        this.router.navigate(['roomAll']);
    }else{
      this.roomImformationService.getOlder1(this.roomImData.nameInput).subscribe(
      data => {
        if(data === null){
            RoomImformationComponent.older11 = false;
            console.log("ไม่พบใน1");
            console.log(RoomImformationComponent.older11);
        }else if(data.roomnumber){
            console.log(data.roomnumber);
            RoomImformationComponent.older1 = data.roomnumber;
            console.log(RoomImformationComponent.older1);
            alert("ผู้สูงอายุพักอยู่ที่ห้อง " +RoomImformationComponent.older1);
            RoomImformationComponent.older11 = true;
            console.log(RoomImformationComponent.older11);

        }},
            error => {
                alert('ไม่พบชื่อผู้สูงอายุในห้องพัก');
                console.log('Error', error);
            }
        );

      this.roomImformationService.getOlder2(this.roomImData.nameInput).subscribe(
      data => {
        if(data === null){
            RoomImformationComponent.older21 = false;
            console.log("ไม่พบใน2");
            console.log(RoomImformationComponent.older21);

        }else if(data.roomnumber){
            console.log(data.roomnumber);
            RoomImformationComponent.older2 = data.roomnumber;
            console.log(RoomImformationComponent.older2);
            alert("ผู้สูงอายุพักอยู่ที่ห้อง " +RoomImformationComponent.older2);
            RoomImformationComponent.older21 = true;
            console.log(RoomImformationComponent.older11);

        }}
        );
      this.roomImformationService.getOlder3(this.roomImData.nameInput).subscribe(
      data => {
        if(data === null){
           RoomImformationComponent.older31 = false;
            console.log("ไม่พบใน3");
            console.log(RoomImformationComponent.older31);

        }else if(data.roomnumber){
            console.log(data.roomnumber);
            RoomImformationComponent.older3 = data.roomnumber;
            console.log(RoomImformationComponent.older3);
            alert("ผู้สูงอายุพักอยู่ที่ห้อง " +RoomImformationComponent.older3);
            RoomImformationComponent.older31 = true;
            console.log(RoomImformationComponent.older11);

        }}
        );

    }


  }



  add(){
  this.router.navigate(['roomAdd']);
  }
  delete(){
  this.router.navigate(['roomDelete']);
  }
}


