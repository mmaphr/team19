import { Component, OnInit } from '@angular/core';
import {LoginpageService} from '../shared/loginmain/loginpage.service';
import {Router} from '@angular/router';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-loginpage',
  templateUrl: './loginpage.component.html',
  styleUrls: ['./loginpage.component.css']
})
export class LoginpageComponent implements OnInit {

  login: any ={
    username:'',
    password:''
  };
  constructor(private loginpageService: LoginpageService,private router: Router) { }

  ngOnInit() {
  }

  submit(form:NgForm){
    this.loginpageService.login(form).subscribe(data => {
      localStorage.setItem('id',this.login.username);
      localStorage.setItem('pass',this.login.password);
      alert('login complete');
      this.router.navigate(['main']);
      },error => {
        alert('wrong username or password');
      }
    );
  }

}
