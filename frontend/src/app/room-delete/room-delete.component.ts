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
  selector: 'app-room-delete',
  templateUrl: './room-delete.component.html',
  styleUrls: ['./room-delete.component.css']
})
export class RoomDeleteComponent implements OnInit {
  showAllColumns: string[] = ['build','floor','roomnumber','type','status','older1','day','delete1'];
  ShowAll: Array<any>;
  static idOut : String
  static getId: any = {
    id:'',older1:'',older2:'',older3:'',nameInput:''
  }



  constructor(private roomImformationService : RoomImformationService,private router: Router, private rout: ActivatedRoute,
              private sanitizer: DomSanitizer,private matdialog : MatDialog, private httpClient: HttpClient,private snackBar: MatSnackBar) { }

  ngOnInit() {
    this.roomImformationService.getRoomAll()
      .subscribe(
        data => {
          this.ShowAll = data;
          console.log(this.ShowAll);
        });

  }

  delete1(id,older1,nameInput){
    console.log(id,older1,nameInput);

    this.httpClient.put('http://localhost:8080/deleteRoom1/'+id+'/'+nameInput+'/1',RoomDeleteComponent.getId)
      .subscribe(
        data => {
          this.snackBar.open('ลบสำเร็จ',"OK",{duration: 10000});

          console.log('PUT Request is successful', data);
          this.router.navigate(['roomAll']);

        },
        error => {
          this.snackBar.open('อัพเดทไม่สำเร็จ',"OK",{duration: 10000});

          console.log('Error', error);
        });
  }





}
