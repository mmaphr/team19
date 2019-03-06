import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {WithdrawService} from '../shared/Withdarw/withdraw.service';
import {MatSnackBar} from '@angular/material';

@Component({
  selector: 'app-withdraw',
  templateUrl: './withdraw.component.html',
  styleUrls: ['./withdraw.component.css']
})
export class WithdrawComponent implements OnInit {

  displayedColumns: string[] = ['addCategory', 'addItemName', 'addAmount', 'addNote'];
  displayedColumnsStock: string[] = ['No', 'categoryName', 'productName', 'amountTotal'];
  itemname: Array<any>;
  department: Array<any>;
  category: Array<any>;
  stock: Array<any>;
  Showitem: Array<any>;

  usernameInput: string;
  passwordInput: string;
  Withdraw: any = {
    categoryInput: '',
    itemNameInput: '',
    amountItemInput: '',
    departmentInput: '',
    descriptionInput: ''
  };

  constructor(public snackBar: MatSnackBar, private withdrawService: WithdrawService, private httpClient: HttpClient , private router: Router) { }
  ngOnInit() {
    this.withdrawService.getwithdrawcategory().subscribe(data => {
      this.category = data;
      console.log(this.category);
    });
    this.withdrawService.getWithdrawDepartment().subscribe(data => {
      this.department = data;
      console.log(this.department);
    });
    this.withdrawService.getWithdrawStock().subscribe(datas => {
      this.stock = datas;
      console.log(this.stock);
    });
  }
  selectStock() {
    this.withdrawService.getwithdrawItemName(this.Withdraw.categoryInput).subscribe(data => {
      this.itemname = data;
      console.log(this.itemname);
    });
  }
  saveStock() {
    if (this.Withdraw.categoryInput === ''
      || this.Withdraw.itemNameInput === ''
      || this.Withdraw.amountItemInput === ''
      || this.Withdraw.amountItemInput === 0
      || this.Withdraw.amountItemInput < 0
      || this.Withdraw.departmentInput === ''
      || this.Withdraw.descriptionInput === ''
    ) {
      this.snackBar.open('กรุณาใส่ข้อมูลหรือจำนวนให้ถูกต้อง', 'OK', {});
    } else {
      this.usernameInput = localStorage.getItem('id');
      this.passwordInput = localStorage.getItem('pass');
      this.httpClient.post('http://localhost:8080/WithdrawStock/' + this.Withdraw.categoryInput + '/' + this.Withdraw.itemNameInput + '/' + this.Withdraw.amountItemInput + '/' + this.Withdraw.departmentInput + '/' + this.Withdraw.descriptionInput + '/' +  this.usernameInput + '/' +  this.passwordInput, this.Withdraw)
        .subscribe(
          data => {
            console.log('PUT Request is successful', data);
            this.withdrawService.getWithdrawStock().subscribe(datas => {
              this.stock = datas;
              console.log(this.stock);
            });
            this.withdrawService.getWithdraw().subscribe(data1 => {
              this.Showitem = data1;
              console.log(this.Showitem);
            });
            this.snackBar.open('การเบิกสำเสร็จ', 'OK', {});
          },
          error => {
            console.log('Rrror', error);
            this.snackBar.open('กรุณาตรวจสอบความยาวของสาเหตุที่เบิกสินค้า', 'OK', {});
          }
        );
    }
  }
}
