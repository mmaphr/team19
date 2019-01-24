import { Component, OnInit } from '@angular/core';
import { RoomImformationService } from '../shared/room-imformation/room-imformation.service';
import { HttpClient} from '@angular/common/http';
import {MatTableDataSource,MatPaginator, MatSort, MatTable, MatTableModule, MatTabHeader,
MatHeaderRow, MatHeaderCell, MatHeaderCellDef, MatHeaderRowDef,
MatSortHeader, MatRow, MatRowDef,  MatCell, MatCellDef,MatDialog} from '@angular/material'
import {Router} from '@angular/router';
import { SafeResourceUrl, DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-room-all',
  templateUrl: './room-all.component.html',
  styleUrls: ['./room-all.component.css']
})
export class RoomAllComponent implements OnInit {
  showAllColumns: string[] = ['no','roomnumber','type','status','older1','older2','older3'];
  ShowAll: Array<any>;
  constructor(private roomImformationService : RoomImformationService,private router: Router, private rout: ActivatedRoute,
    private sanitizer: DomSanitizer,private matdialog : MatDialog, private httpClient: HttpClient) { }

  ngOnInit() {
    this.roomImformationService.getRoomAll()
    .subscribe(
    data => {
      this.ShowAll = data;
      console.log(this.ShowAll);
    });
  }


}
