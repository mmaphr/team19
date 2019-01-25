import { Component, OnInit } from '@angular/core';
import {OutactivityService} from "../service/outactivity.service";
import { MatDialog} from '@angular/material';

@Component({
  selector: 'app-shows-out-activity',
  templateUrl: './shows-out-activity.component.html',
  styleUrls: ['./shows-out-activity.component.css']
})
export class ShowsOutActivityComponent implements OnInit {
  dataColumns: string[] = ['nameActivity','nameRequestor','phonenum','descriptionActivity','date','organized','periodTimeS','periodTimeE','category','staff'];
  outActivity:Array<any>
  constructor(private outactivityService: OutactivityService) { }

  ngOnInit() {
    this.outactivityService.getOutActivity().subscribe
    (data => {
      this.outActivity = data;
      console.log(this.outActivity);
    });
  }

}
