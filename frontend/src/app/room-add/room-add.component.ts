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
@Component({
  selector: 'app-room-add',
  templateUrl: './room-add.component.html',
  styleUrls: ['./room-add.component.css']
})
export class RoomAddComponent implements OnInit {
  showAllColumns: string[] = ['no','roomnumber','type','status','older1','older2','older3','add'];
  ShowAll: Array<any>;
  ShowName: Array<any>;
  static idOut : String
  static getId: any = {
    id:'',older1:'',older2:'',older3:''
  }
  roomImData : any = {
    nameInput:''
  };


  constructor(private roomImformationService : RoomImformationService,private router: Router, private rout: ActivatedRoute,
  private sanitizer: DomSanitizer,private matdialog : MatDialog, private httpClient: HttpClient) { }


  ngOnInit() {
  if(RoomImformationComponent.older11){
      this.router.navigate(['roomAll']);
      alert('มีในห้องพักแล้ว');
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

  add(id,older1,older2,older3,type){
    console.log(this.roomImData.nameInput);
    console.log(id,older1,older2,older3);
    if(this.roomImData.nameInput === ''){
      alert('กรุณาเลือก');
    }else{
      if(older1===null){
        if(older2===null){
          if(older3===null){
            console.log("ห้องว่างทุกที่");
            console.log(id);
            this.httpClient.put('http://localhost:8080/updateRoom1/' +id+ '/'+this.roomImData.nameInput+'/3/'+type.id,RoomAddComponent.getId)
            .subscribe(
            data => {

                alert('เพิ่มสำเร็จ');
                console.log('PUT Request is successful', data);
                this.router.navigate(['roomAll']);

             },
            error => {
                alert(error.error.message);
                console.log('Error', error);
            });

          }else if(older3!==null){
            console.log("ห้องว่างที่1-2");
            this.httpClient.put('http://localhost:8080/updateRoom1/' +id+ '/'+this.roomImData.nameInput+'/2/'+type.id,RoomAddComponent.getId)
            .subscribe(
            data => {

                alert('เพิ่มสำเร็จ');
                console.log('PUT Request is successful', data);
                this.router.navigate(['roomAll']);

             },
            error => {
                alert(error.error.message);
                console.log('Error', error);
            });
          }

        }else if(older2!==null){

          if(older3===null){
            console.log("ห้องว่างที่1,3");
            this.httpClient.put('http://localhost:8080/updateRoom1/' +id+ '/'+this.roomImData.nameInput+'/2/'+type.id,RoomAddComponent.getId)
            .subscribe(
            data => {

                alert('เพิ่มสำเร็จ');
                console.log('PUT Request is successful', data);
                this.router.navigate(['roomAll']);

             },
            error => {
                alert(error.error.message);
                console.log('Error', error);
            });

          }else if(older3!==null){
            console.log("ห้องว่างที่1");
            this.httpClient.put('http://localhost:8080/updateRoom1/' +id+ '/'+this.roomImData.nameInput+'/4/'+type.id,RoomAddComponent.getId)
            .subscribe(
            data => {

                alert('เพิ่มสำเร็จ');
                console.log('PUT Request is successful', data);
                this.router.navigate(['roomAll']);

             },
            error => {
                alert(error.error.message);
                console.log('Error', error);
            });

          }
        }
    }else if(older1!==null){
        if(older2===null){

          if(older3===null){
            console.log("ห้องว่างที่2-3");
            this.httpClient.put('http://localhost:8080/updateRoom2/' +id+ '/'+this.roomImData.nameInput+'/2/'+type.id,RoomAddComponent.getId)
            .subscribe(
            data => {

                alert('เพิ่มสำเร็จ');
                console.log('PUT Request is successful', data);
                this.router.navigate(['roomAll']);

             },
            error => {
                alert(error.error.message);
                console.log('Error', error);
            });

          }else if(older3!==null){
            console.log("ห้องว่างที่2");
            this.httpClient.put('http://localhost:8080/updateRoom2/' +id+ '/'+this.roomImData.nameInput+'/4/'+type.id,RoomAddComponent.getId)
            .subscribe(
            data => {

                alert('เพิ่มสำเร็จ');
                console.log('PUT Request is successful', data);
                this.router.navigate(['roomAll']);
             },
            error => {
                alert(error.error.message);
                console.log('Error', error);
            });
          }

        }else if(older2!==null){

          if(older3===null){
            console.log("ห้องว่างที่3");
            this.httpClient.put('http://localhost:8080/updateRoom3/' +id+ '/'+this.roomImData.nameInput+'/4/'+type.id,RoomAddComponent.getId)
            .subscribe(
            data => {

                alert('เพิ่มสำเร็จ');
                console.log('PUT Request is successful', data);
                this.router.navigate(['roomAll']);

             },
            error => {
                alert(error.error.message);
                console.log('Error', error);
            });
          }else if(older3!==null){
            console.log("ห้องเต็ม");
            alert("ห้องพักเต็ม ไม่สามารถเพิ่มเข้าห้องนี้ได้");
          }
        }
    }
    }


  }

}
