import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {OutactivityService} from '../service/outactivity.service';
import {RouterModule, Routes, Router, ActivatedRoute} from '@angular/router';
import {BookaplaceService} from '../service/bookaplace.service';
import {MatSnackBar} from '@angular/material';


@Component({
  selector: 'app-bookaplace',
  templateUrl: './bookaplace.component.html',
  styleUrls: ['./bookaplace.component.css']
})
export class BookaplaceComponent implements OnInit {
  placet: Array<any>;
  out: Array<any>;

  placeTypeIDSelected: number;
  outactivi: number;
  bplace: any =
    {
      nameCaretaker: '',
      namePlace: '',
      cardid: '',
      phonCaretaker: '',
      descriptionPlace: '',
      placeTypeIDSelected: ''

    };

  constructor(private httpClient: HttpClient, private outactivityService: OutactivityService, private router: Router, private bookaplaceService: BookaplaceService, private snackBar: MatSnackBar, private rout: ActivatedRoute) {
  }

  ngOnInit() {


    this.rout.params.subscribe(params => {
      this.outactivi = +params['id'];
      console.log(this.outactivi);
    });
    this.bookaplaceService.getAllOut(this.outactivi).subscribe(data => {
      this.out = data;
      console.log(this.out);
    });
    this.bookaplaceService.getAllPlace().subscribe(data => {
      this.placet = data;
      console.log(this.placet);
    });

  }


  accept() {
    {
      if (this.bplace.nameCaretaker === '' ||
        this.bplace.namePlace === '' ||
        this.bplace.cardid === '' ||
        this.bplace.phonCaretaker === '' ||
        this.bplace.descriptionPlace === '' ||
        this.bplace.typePlace === '') {
        this.snackBar.open('กรุณากรอกข้อมูลให้ครบถ้วน', 'Ok');
      } else {
        this.httpClient.post('http://localhost:8080/bookaplace/' + this.bplace.placeTypeIDSelected + '/' + this.outactivi, this.bplace)
          .subscribe(data => {

              this.snackBar.open('Request is successful', 'Ok');
              console.log('PUT Request is successful', data);

            },
            error => {
              this.snackBar.open('Request is not successful', 'Ok');
              console.log('Error', error);
            });
      }
    }
  }
}





