import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { HealthCheckService } from  '../shared/healthcheck/health-check.service';
import {HttpClient} from '@angular/common/http';
import {MatSnackBar} from '@angular/material';


@Component({
  selector: 'app-health-check',
  templateUrl: './health-check.component.html',
  styleUrls: ['./health-check.component.css']
})
export class HealthCheckComponent implements OnInit {
  types: Array<any>;
  dataColumns: string[] = ['no','hospital','datecheck','healthCheckType','description','expenses'];
  healthChecks: Array<any>;
  inputHealthCheck: any = {
    hospital: '',
    datecheck: '',
    expenses: '',
    description: '',
    healthCheckType: '',
    dataOlderId: ''
  };
  constructor(private healthCheckService: HealthCheckService, private router: Router, private rout: ActivatedRoute,
              private httpClient: HttpClient , private snackBar: MatSnackBar ) { }

  ngOnInit() {
    this.rout.params.subscribe(params => {
      this.inputHealthCheck.dataOlderId = +params['id'];
      console.log(this.inputHealthCheck.dataOlderId);
    });

    this.healthCheckService.getHealthCheckType().subscribe(data => {
      this.types = data;
      console.log(this.types);
    });

    this.healthCheckService.getDataOlder(this.inputHealthCheck.dataOlderId).subscribe(healthCheckdata => {
      this.healthChecks = healthCheckdata;
      console.log(this.healthChecks);
    });
  }

  save()
  {
    if(this.inputHealthCheck.hospital === '' ||
      this.inputHealthCheck.datecheck === '' ||
      this.inputHealthCheck.expenses === '' ||
      this.inputHealthCheck.description === '' ||
      this.inputHealthCheck.parentname === '' ||
      this.inputHealthCheck.healthCheckType === '' ||
      this.inputHealthCheck.dataOlderId === '') {
      this.snackBar.open('กรุณากรอกข้อมูลให้ครบถ้วน', 'Ok');
    } else {
      this.httpClient.post('http://localhost:8080/AddHealthCheck/' + this.inputHealthCheck.datecheck + '/' + this.inputHealthCheck.healthCheckType + '/' +
        this.inputHealthCheck.dataOlderId , this.inputHealthCheck)
        .subscribe(data => {

            this.snackBar.open('Request is successful', 'Ok');
            console.log('PUT Request is successful', data);
            this.healthCheckService.getDataOlder(this.inputHealthCheck.dataOlderId).subscribe(healthCheckdata => {
              this.healthChecks = healthCheckdata;
              console.log(this.healthChecks);
            });
          },
          error => {
            this.snackBar.open('Request is not successful', 'Ok');
            console.log('Error', error);
          }
        );
    }
  }

}
