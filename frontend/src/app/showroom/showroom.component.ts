import { Component, OnInit, Inject } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';

@Component({
  selector: 'app-showroom',
  templateUrl: './showroom.component.html',
  styleUrls: ['./showroom.component.css']
})
export class ShowroomComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<ShowroomComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any) {}

  ngOnInit() {
  }

}
