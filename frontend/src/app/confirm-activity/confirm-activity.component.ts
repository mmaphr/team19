import {Component, OnInit} from '@angular/core';
import {OutactivityService} from '../service/outactivity.service';


@Component({
  selector: 'app-confirm-activity',
  templateUrl: './confirm-activity.component.html',
  styleUrls: ['./confirm-activity.component.css']
})
export class ConfirmActivityComponent implements OnInit {
  dataColumns: string[] = ['nameActivity', 'nameRequestor', 'phonenum', 'descriptionActivity',
    'date', 'organized', 'periodTimeS', 'periodTimeE', 'category', 'staff', 'confirm'];
  outActivity: Array<any>;

  constructor(private outactivityService: OutactivityService) {
  }

  ngOnInit() {
    this.outactivityService.getOutActivity().subscribe
    (data => {
      this.outActivity = data;
      console.log(this.outActivity);
    });
  }

}
