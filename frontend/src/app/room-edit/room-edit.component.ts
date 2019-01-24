import { Component, OnInit } from '@angular/core';
import { RoomImformationService } from '../shared/room-imformation/room-imformation.service';
import { HttpClient} from '@angular/common/http';
import { MatDialogRef } from '@angular/material';
import {Router} from '@angular/router';
import { SafeResourceUrl, DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';

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
    typeSelect:''
  };
  constructor(private router: Router, private rout: ActivatedRoute,private roomEditService:RoomImformationService , private httpClient: HttpClient,private sanitizer: DomSanitizer) {
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
  if(this.roomImData.roomNumInput ===''||this.roomImData.typeSelect ===''){
    alert('กรุณากรอกข้อมูลให้ครบถ้วน เพิ่มไม่สำเร็จ');
  }else{
    console.log(this.roomImData.roomNumInput);
    this.httpClient.post('http://localhost:8080/newRoom/'+this.roomImData.roomNumInput+'/'+this.roomImData.typeSelect,this.roomImData).subscribe(
    data => {
              alert('Request is successful');
              console.log('เพิ่มห้องพักสำเร็จ', data);
              this.router.navigate(['roomInformation']);

          },
          error => {
              alert(error.error.message);
              console.log('Error', error.error.message);
          }
    );


  }
  }
}
