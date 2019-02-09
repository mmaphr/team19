import { Component, OnInit } from '@angular/core';
import { AddDataOlderService } from '../shared/DataOlder/add-data-older.service';
import { Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-more-date-older',
  templateUrl: './more-date-older.component.html',
  styleUrls: ['./more-date-older.component.css']
})
export class MoreDateOlderComponent implements OnInit {
  dataOlder: Array<any>;
  OlderDataAndDiseases: Array<any>;
  dataOlderId: number ;
  constructor(private addDataOlderService: AddDataOlderService , private router: Router, private rout: ActivatedRoute) { }

  ngOnInit() {
    this.rout.params.subscribe(params => {
      this.dataOlderId = +params['id'];
      console.log(this.dataOlderId);
    });
    this.addDataOlderService.getOlderid(this.dataOlderId).subscribe(data => {
      this.dataOlder = data;
      console.log(this.dataOlder);
    });
    this.addDataOlderService.getOlderDataAndDiseaseid(this.dataOlderId).subscribe(data => {
      this.OlderDataAndDiseases = data;
      console.log(this.OlderDataAndDiseases);
    });
  }

}
