import { Component, OnInit } from '@angular/core';
import { RoomImformationService } from '../shared/room-imformation/room-imformation.service';
import { HttpClient} from '@angular/common/http';
import {MatTableDataSource,MatPaginator, MatSort, MatTable, MatTableModule, MatTabHeader,
  MatHeaderRow, MatHeaderCell, MatHeaderCellDef, MatHeaderRowDef,
  MatSortHeader, MatRow, MatRowDef,  MatCell, MatCellDef,MatDialog} from '@angular/material'
import {Router} from '@angular/router';
import { SafeResourceUrl, DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';
import { RoomImformationComponent } from '../room-imformation/room-imformation.component';
import {MatSnackBar} from '@angular/material';

@Component({
  selector: 'app-room-add',
  templateUrl: './room-add.component.html',
  styleUrls: ['./room-add.component.css']
})
export class RoomAddComponent implements OnInit {
  showAllColumns: string[] = ['build','floor','roomnumber','type','status','older1','add'];
  ShowAll: Array<any>;
  ShowName: Array<any>;
  static getId: any = {
    id:'',older1:'',older2:'',older3:''
  }
  roomImData : any = {
    nameInput:''
  };


  constructor(private roomImformationService : RoomImformationService,private router: Router, private rout: ActivatedRoute,
              private sanitizer: DomSanitizer,private matdialog : MatDialog, private httpClient: HttpClient,private snackBar: MatSnackBar) { }


  ngOnInit() {
    if(RoomImformationComponent.older1){
      this.router.navigate(['roomAll']);
      this.snackBar.open('มีในห้องพักแล้ว',"OK",{duration: 10000});
    }
    this.roomImformationService.getRoomAll()
      .subscribe(
        data => {
          this.ShowAll = data;
          console.log(this.ShowAll);
        });
    this.roomImformationService.getOlderAll()
      .subscribe(
        data => {
          this.ShowName = data;
          console.log(this.ShowName);
        });


  }

  add(id,older1,type){
    console.log(this.roomImData.nameInput);
    console.log(id,older1);
    if(this.roomImData.nameInput === ''){
      this.snackBar.open('กรุณาเลือก',"OK",{duration: 10000});
    }else{
      if(older1===null){
        console.log("ห้องว่างทุกที่");
        console.log(id);
        this.httpClient.put('http://localhost:8080/updateRoom1/' +id+ '/'+this.roomImData.nameInput+'/2/'+type.id,RoomAddComponent.getId)
          .subscribe(
            data => {
              this.snackBar.open('เพิ่มสำเร็จ',"OK",{duration: 10000});

              console.log('PUT Request is successful', data);
              // this.router.navigate(['roomAll']);
              this.roomImData.nameInput = '';
              this.roomImformationService.getRoomAll()
                .subscribe(
                  data => {
                    this.ShowAll = data;
                    console.log(this.ShowAll);
                  });
            },
            error => {
              this.snackBar.open(error.error.message,"OK",{duration: 10000});
              console.log('Error', error);
            });

      }else{
        console.log("ห้องเต็ม");
        this.snackBar.open("ห้องพักเต็ม ไม่สามารถเพิ่มเข้าห้องนี้ได้","OK",{duration: 10000});
      }
    }
  }



}


