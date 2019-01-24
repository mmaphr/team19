import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { AddDataOlderService } from '../shared/DataOlder/add-data-older.service';


@Component({
  selector: 'app-add-data-older-page',
  templateUrl: './add-data-older-page.component.html',
  styleUrls: ['./add-data-older-page.component.css']
})
export class AddDataOlderPageComponent implements OnInit {

  dataColumns: string[] = ['Id','oldername','oldergender','parentname','parentaddress','parentphone'/**/];
  olderData: Array<any>;

  provinces: Array<any>;
  genders: Array<any>;
  diseases:  Array<any>;
  inputDataOlder: any = {
    oldername: '',
    olderbirth: '',
    oldergender: '',
    olderdisease: '',
    parentname: '',
    parentaddress: '',
    parentprovince: '',
    parentphone: ''

  };
  constructor(private addDataOlderService: AddDataOlderService , private httpClient: HttpClient) { }

  ngOnInit() {
    this.addDataOlderService.getProvince().subscribe(data => {
      this.provinces = data;
      console.log(this.provinces);
    });

    this.addDataOlderService.getGender().subscribe(data => {
      this.genders = data;
      console.log(this.genders);
    });

    this.addDataOlderService.getDisease().subscribe(data => {
      this.diseases = data;
      console.log(this.diseases);
    });

    this.addDataOlderService.getOlder().subscribe(data => {
      this.olderData = data;
      console.log(this.olderData);
    });
  }

  save(){
    console.log(this.inputDataOlder);
    if(this.inputDataOlder.oldername === '' ||
      this.inputDataOlder.olderbirth === '' ||
      this.inputDataOlder.oldergender === '' ||
      this.inputDataOlder.olderdisease === '' ||
      this.inputDataOlder.parentname === '' ||
      this.inputDataOlder.parentaddress === '' ||
      this.inputDataOlder.parentprovince === '' ||
      this.inputDataOlder.parentphone === '') {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    } else {
      this.httpClient.post('http://localhost:8080/AddDataOlder/' + this.inputDataOlder.olderbirth + '/' + this.inputDataOlder.oldergender + '/' +
        this.inputDataOlder.olderdisease + '/' + this.inputDataOlder.parentprovince, this.inputDataOlder)
        .subscribe(data => {
          alert('Request is successful');
          console.log('PUT Request is successful', data);
            this.addDataOlderService.getOlder().subscribe(data => {
              this.olderData = data;
              console.log(this.olderData);
            });
        },
        error => {
          alert('Request is not successful');
          console.log('Error', error);
        }
      );


    }
  }
}
