import { Component, OnInit } from '@angular/core';
import { RoomImformationService } from '../shared/room-imformation/room-imformation.service';
import { HttpClient} from '@angular/common/http';
import { MatDialogRef } from '@angular/material';
import {Router} from '@angular/router';
import { SafeResourceUrl, DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';
import {MatSnackBar} from '@angular/material';

@Component({
  selector: 'app-room-edit',
  templateUrl: './room-edit.component.html',
  styleUrls: ['./room-edit.component.css']
})
export class RoomEditComponent implements OnInit {

  types: Array<any>;
  static roomnumber : String;
  roomImData: any = {
    roomNumInput:'',
    typeSelect:'',
    buildingInput:'',
    floorInput:'',
    roomphoneInput:''

  };
  constructor(private router: Router, private rout: ActivatedRoute,private roomEditService:RoomImformationService ,private snackBar: MatSnackBar, private httpClient: HttpClient,private sanitizer: DomSanitizer) {
    this.sanitizer = sanitizer;
  }

  ngOnInit() {

    this.roomEditService.getTypeRoom().subscribe(data => {
      this.types = data;
      console.log(this.types);
    });

  }

  save(){
    console.log(this.roomImData.roomNumInput);
    if(this.roomImData.roomNumInput ===''||this.roomImData.typeSelect ===''||this.roomImData.buildingInput ===''||this.roomImData.floorInput ===''||this.roomImData.roomphoneInput ===''){
      this.snackBar.open('กรุณากรอกข้อมูลให้ครบถ้วน เพิ่มไม่สำเร็จ',"OK",{duration: 10000});
    }else{
      console.log(this.roomImData.roomNumInput);
      this.httpClient.post('http://localhost:8080/newRoom/'+this.roomImData.buildingInput+'/'+this.roomImData.floorInput+'/'+this.roomImData.roomNumInput+'/'+this.roomImData.roomphoneInput+'/'+this.roomImData.typeSelect,this.roomImData).subscribe(
        data => {
          this.snackBar.open('เพิ่มห้องพักสำเร็จ',"OK",{duration: 10000});

          console.log('เพิ่มห้องพักสำเร็จ', data);

          this.roomImData.roomNumInput = '';
          this.roomImData.typeSelect = '' ;
          // this.roomImData.buildingInput = '';
          // this.roomImData.floorInput = '';
          this.roomImData.roomphoneInput = '';


          // this.router.navigate(['roomInformation']);

        },
        error => {
          if(error.error.message=="หมายเลขห้องพักซ้ำ!!"){
            this.snackBar.open(error.error.message,"OK",{duration: 10000});

            console.log('Error', error.error.message);
          }else{
            this.snackBar.open("กรอกข้อมูลผิดพลาด กรุณาตรวจสอบข้อมูล","OK",{duration: 10000});

          }
        }
      );


    }
  }
}
