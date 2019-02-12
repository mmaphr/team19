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
showAllColumns: string[] = ['no','roomnumber','type','status','older1','delete1','older2','delete2','older3','delete3'];
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

  delete1(id,older1,older2,older3,nameInput){
    console.log(id,older1,older2,older3,nameInput);
    if(older1===null){
        if(older2===null){

          if(older3===null){
            console.log("ห้องว่างทุกที่");
            console.log(id);
            this.snackBar.open('ไม่มีผู้พัก',"OK",{duration: 10000});


          }else if(older3!==null){
            console.log("ห้องว่างที่1-2");
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

        }else if(older2!==null){

          if(older3===null){
            console.log("ห้องว่างที่1,3");
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

          }else if(older3!==null){
            console.log("ห้องว่างที่1");
            this.httpClient.put('http://localhost:8080/deleteRoom1/'+id+'/'+nameInput+'/3',RoomDeleteComponent.getId)
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
    }else if(older1!==null){
        if(older2===null){

          if(older3===null){
            console.log("ห้องว่างที่2-3");
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

          }else if(older3!==null){
            console.log("ห้องว่างที่2");
            this.httpClient.put('http://localhost:8080/deleteRoom1/'+id+'/'+nameInput+'/3',RoomDeleteComponent.getId)
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

        }else if(older2!==null){

          if(older3===null){
            console.log("ห้องว่างที่3");
            this.httpClient.put('http://localhost:8080/deleteRoom1/'+id+'/'+nameInput+'/3',RoomDeleteComponent.getId)
            .subscribe(
            data => {
              this.snackBar.open('ลบสำเร็จ',"OK",{duration: 10000});

                console.log('PUT Request is successful', data);
                this.router.navigate(['roomAll']);

             },
            error => {
                alert('อัพเดทไม่สำเร็จ');
                console.log('Error', error);
            });
          }else if(older3!==null){
            console.log("ห้องเต็ม");
            this.httpClient.put('http://localhost:8080/deleteRoom1/'+id+'/'+nameInput+'/2',RoomDeleteComponent.getId)
            .subscribe(
            data => {

              this.snackBar.open('ลบสำเร็จ',"OK",{duration: 10000});
                console.log('PUT Request is successful', data);
                this.router.navigate(['roomAll']);

             },
            error => {
                alert('อัพเดทไม่สำเร็จ');
                console.log('Error', error);
            });
          }
        }
    }
  }


  delete2(id,older1,older2,older3,nameInput){
    console.log(id,older1,older2,older3,nameInput);
    if(older1===null){
        if(older2===null){

          if(older3===null){
            console.log("ห้องว่างทุกที่");
            console.log(id);
            alert('ไม่มีผู้พัก');

          }else if(older3!==null){
            console.log("ห้องว่างที่1-2");
            this.httpClient.put('http://localhost:8080/deleteRoom2/'+id+'/'+nameInput+'/1',RoomDeleteComponent.getId)
            .subscribe(
            data => {

              this.snackBar.open('ลบสำเร็จ',"OK",{duration: 10000});
                console.log('PUT Request is successful', data);
                this.router.navigate(['roomAll']);

             },
            error => {
                alert('อัพเดทไม่สำเร็จ');
                console.log('Error', error);
            });
          }

        }else if(older2!==null){

          if(older3===null){
            console.log("ห้องว่างที่1,3");
            this.httpClient.put('http://localhost:8080/deleteRoom2/'+id+'/'+nameInput+'/1',RoomDeleteComponent.getId)

            .subscribe(
            data => {

              this.snackBar.open('ลบสำเร็จ',"OK",{duration: 10000});
                console.log('PUT Request is successful', data);
                this.router.navigate(['roomAll']);

             },
            error => {
                alert('อัพเดทไม่สำเร็จ');
                console.log('Error', error);
            });

          }else if(older3!==null){
            console.log("ห้องว่างที่1");
            this.httpClient.put('http://localhost:8080/deleteRoom2/'+id+'/'+nameInput+'/3',RoomDeleteComponent.getId)
            .subscribe(
            data => {

              this.snackBar.open('ลบสำเร็จ',"OK",{duration: 10000});
                console.log('PUT Request is successful', data);
                this.router.navigate(['roomAll']);

             },
            error => {
                alert('อัพเดทไม่สำเร็จ');
                console.log('Error', error);
            });

          }
        }
    }else if(older1!==null){
        if(older2===null){

          if(older3===null){
            console.log("ห้องว่างที่2-3");
            this.httpClient.put('http://localhost:8080/deleteRoom2/'+id+'/'+nameInput+'/1',RoomDeleteComponent.getId)
            .subscribe(
            data => {

              this.snackBar.open('ลบสำเร็จ',"OK",{duration: 10000});
                console.log('PUT Request is successful', data);
                this.router.navigate(['roomAll']);

             },
            error => {
                alert('อัพเดทไม่สำเร็จ');
                console.log('Error', error);
            });

          }else if(older3!==null){
            console.log("ห้องว่างที่2");
            this.httpClient.put('http://localhost:8080/deleteRoom2/'+id+'/'+nameInput+'/3',RoomDeleteComponent.getId)
            .subscribe(
            data => {

              this.snackBar.open('ลบสำเร็จ',"OK",{duration: 10000});
                console.log('PUT Request is successful', data);
                this.router.navigate(['roomAll']);

             },
            error => {
                alert('อัพเดทไม่สำเร็จ');
                console.log('Error', error);
            });
          }

        }else if(older2!==null){

          if(older3===null){
            console.log("ห้องว่างที่3");
            this.httpClient.put('http://localhost:8080/deleteRoom2/'+id+'/'+nameInput+'/3',RoomDeleteComponent.getId)
            .subscribe(
            data => {

              this.snackBar.open('ลบสำเร็จ',"OK",{duration: 10000});
                console.log('PUT Request is successful', data);
                this.router.navigate(['roomAll']);

             },
            error => {
                alert('อัพเดทไม่สำเร็จ');
                console.log('Error', error);
            });
          }else if(older3!==null){
            console.log("ห้องเต็ม");
            this.httpClient.put('http://localhost:8080/deleteRoom2/'+id+'/'+nameInput+'/2',RoomDeleteComponent.getId)
            .subscribe(
            data => {

              this.snackBar.open('ลบสำเร็จ',"OK",{duration: 10000});
                console.log('PUT Request is successful', data);
                this.router.navigate(['roomAll']);

             },
            error => {
                alert('อัพเดทไม่สำเร็จ');
                console.log('Error', error);
            });
          }
        }
    }
  }
  delete3(id,older1,older2,older3,nameInput){
    console.log(id,older1,older2,older3,nameInput);
    if(older1===null){
        if(older2===null){

          if(older3===null){
            console.log("ห้องว่างทุกที่");
            console.log(id);
            alert('ไม่มีผู้พัก');

          }else if(older3!==null){
            console.log("ห้องว่างที่1-2");
            this.httpClient.put('http://localhost:8080/deleteRoom3/'+id+'/'+nameInput+'/1',RoomDeleteComponent.getId)
            .subscribe(
            data => {

              this.snackBar.open('ลบสำเร็จ',"OK",{duration: 10000});
                console.log('PUT Request is successful', data);
                this.router.navigate(['roomAll']);
             },
            error => {
                alert('อัพเดทไม่สำเร็จ');
                console.log('Error', error);
            });
          }

        }else if(older2!==null){

          if(older3===null){
            console.log("ห้องว่างที่1,3");
            this.httpClient.put('http://localhost:8080/deleteRoom3/'+id+'/'+nameInput+'/1',RoomDeleteComponent.getId)

            .subscribe(
            data => {

              this.snackBar.open('ลบสำเร็จ',"OK",{duration: 10000});
                console.log('PUT Request is successful', data);
                this.router.navigate(['roomAll']);

             },
            error => {
                alert('อัพเดทไม่สำเร็จ');
                console.log('Error', error);
            });

          }else if(older3!==null){
            console.log("ห้องว่างที่1");
            this.httpClient.put('http://localhost:8080/deleteRoom3/'+id+'/'+nameInput+'/3',RoomDeleteComponent.getId)
            .subscribe(
            data => {

              this.snackBar.open('ลบสำเร็จ',"OK",{duration: 10000});
                console.log('PUT Request is successful', data);
                this.router.navigate(['roomAll']);

             },
            error => {
                alert('อัพเดทไม่สำเร็จ');
                console.log('Error', error);
            });

          }
        }
    }else if(older1!==null){
        if(older2===null){

          if(older3===null){
            console.log("ห้องว่างที่2-3");
            this.httpClient.put('http://localhost:8080/deleteRoom3/'+id+'/'+nameInput+'/1',RoomDeleteComponent.getId)
            .subscribe(
            data => {

              this.snackBar.open('ลบสำเร็จ',"OK",{duration: 10000});
                console.log('PUT Request is successful', data);
                this.router.navigate(['roomAll']);

             },
            error => {
                alert('อัพเดทไม่สำเร็จ');
                console.log('Error', error);
            });

          }else if(older3!==null){
            console.log("ห้องว่างที่2");
            this.httpClient.put('http://localhost:8080/deleteRoom3/'+id+'/'+nameInput+'/3',RoomDeleteComponent.getId)
            .subscribe(
            data => {

              this.snackBar.open('ลบสำเร็จ',"OK",{duration: 10000});
                console.log('PUT Request is successful', data);
                this.router.navigate(['roomAll']);

             },
            error => {
                alert('อัพเดทไม่สำเร็จ');
                console.log('Error', error);
            });
          }

        }else if(older2!==null){

          if(older3===null){
            console.log("ห้องว่างที่3");
            this.httpClient.put('http://localhost:8080/deleteRoom3/'+id+'/'+nameInput+'/3',RoomDeleteComponent.getId)
            .subscribe(
            data => {

              this.snackBar.open('ลบสำเร็จ',"OK",{duration: 10000});
                console.log('PUT Request is successful', data);
                this.router.navigate(['roomAll']);

             },
            error => {
                alert('อัพเดทไม่สำเร็จ');
                console.log('Error', error);
            });
          }else if(older3!==null){
            console.log("ห้องเต็ม");
            this.httpClient.put('http://localhost:8080/deleteRoom3/'+id+'/'+nameInput+'/2',RoomDeleteComponent.getId)
            .subscribe(
            data => {

              this.snackBar.open('ลบสำเร็จ',"OK",{duration: 10000});
                console.log('PUT Request is successful', data);
                this.router.navigate(['roomAll']);

             },
            error => {
                alert('อัพเดทไม่สำเร็จ');
                console.log('Error', error);
            });
          }
        }
    }
  }
}
