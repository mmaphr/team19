import { Component, OnInit, Inject } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import { SafeResourceUrl, DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';
import { RoomImformationService } from '../shared/room-imformation/room-imformation.service';
import {MatSnackBar} from '@angular/material';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import { ShowroomComponent } from '../showroom/showroom.component';



@Component({
  selector: 'app-room-imformation',
  templateUrl: './room-imformation.component.html',
  styleUrls: ['./room-imformation.component.css']
})
export class RoomImformationComponent implements OnInit {
  static room : String;
  static older1 : boolean = false;
  static floor : String;
  static build : String;


  showAllColumns: string[] = ['room','older'];
  roomImData : any = {
    nameInput:''
  };

  constructor(private router: Router, private rout: ActivatedRoute,private roomImformationService:RoomImformationService , private httpClient: HttpClient,private sanitizer: DomSanitizer
    ,private snackBar: MatSnackBar,private dialog: MatDialog) {
    this.sanitizer = sanitizer;
  }

  ngOnInit() {


  }
  search(){
    if(this.roomImData.nameInput ===''){
      this.snackBar.open('กรุณากรอกข้อมูลให้ครบถ้วน ค้นหาไม่สำเร็จ',"OK",{duration: 10000});
    }else if(this.roomImData.nameInput ==='allData'){
      this.snackBar.open('ค้นหาทั้งหมด',"OK",{duration: 10000});
      this.router.navigate(['roomAll']);
    }else{
      this.roomImformationService.getOlder1(this.roomImData.nameInput).subscribe(
        data => {
          if(data === null){
            RoomImformationComponent.older1 = false;
            console.log("ไม่พบใน");
            console.log(RoomImformationComponent.older1);
          }else if(data.roomnumber){
            console.log(data.roomnumber);
            RoomImformationComponent.room = data.roomnumber;
            RoomImformationComponent.floor = data.floor;
            RoomImformationComponent.build = data.building;
            console.log(RoomImformationComponent.room, RoomImformationComponent.floor, RoomImformationComponent.build);
            this.dialog.open(ShowroomComponent, {
              width: '250px',
              data: {room: RoomImformationComponent.room, name: this.roomImData.nameInput, floor: RoomImformationComponent.floor, build: RoomImformationComponent.build}
            });
            // this.snackBar.open("ผู้สูงอายุพักอยู่ที่ห้อง " +RoomImformationComponent.older1,"OK",{duration: 10000});
            RoomImformationComponent.older1 = true;
            console.log(RoomImformationComponent.older1);

          }},
        error => {
          this.snackBar.open('ไม่พบชื่อผู้สูงอายุในห้องพัก',"OK",{duration: 10000});
          console.log('Error', error);
        }
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



