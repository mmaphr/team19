import { Component, OnInit } from '@angular/core';
import {AdditemService} from '../shared/Additem/additem.service';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {MatSnackBar} from '@angular/material';

@Component({
  selector: 'app-additem',
  templateUrl: './additem.component.html',
  styleUrls: ['./additem.component.css']
})
export class AdditemComponent implements OnInit {

  displayedColumns: string[] = ['addCategory', 'addItemName', 'addAmount', 'addNote'];
  displayedColumnsStock: string[] = ['No', 'categoryName', 'productName', 'amountTotal'];
  category: Array<any>;
  note: Array<any>;
  stock: Array<any>;
  Showitem: Array<any>;

  usernameInput: string;
  passwordInput: string;
  Input: any = {
    categoryInput: '',
    itemNameInput: '',
    amountItemInput: '',
    noteItemInput: ''
  };

  constructor(public snackBar: MatSnackBar, private additemService: AdditemService, private httpClient: HttpClient , private router: Router) { }

  ngOnInit() {
    this.additemService.getcategory().subscribe(data => {
      this.category = data;
      console.log(this.category);
    });
    this.additemService.getnote().subscribe(data => {
      this.note = data;
      console.log(this.note);
    });
    this.additemService.getstock().subscribe(data => {
      this.stock = data;
      console.log(this.stock);
    });
  }
  saveStock() {
    if (this.Input.categoryInput === ''
      || this.Input.itemNameInput === ''
      || this.Input.amountItemInput === ''
      || this.Input.amountItemInput === 0
      || this.Input.amountItemInput < 0
      || this.Input.noteItemInput === ''
    ){
      this.snackBar.open('กรุณาใส่ข้อมูลหรือจำนวนให้ถูกต้อง', 'OK', {});
    } else {
      this.usernameInput = localStorage.getItem('id');
      this.passwordInput = localStorage.getItem('pass');
      this.httpClient.post('http://localhost:8080/AddStock/' + this.Input.categoryInput + '/' + this.Input.itemNameInput + '/' + this.Input.amountItemInput + '/' + this.Input.noteItemInput + '/' +  this.usernameInput + '/' +  this.passwordInput, this.Input)
        .subscribe(
          data => {
            console.log('PUT Request is successful', data);
            this.additemService.getstock().subscribe(data => {
              this.stock = data;
              console.log(this.stock);
            });
            this.additemService.getShowAddItem().subscribe(data => {
              this.Showitem = data;
              console.log(this.Showitem);
            });
            this.snackBar.open('บันทึกสำเร็จ', 'OK', {});
          },
          error => {
            console.log('Rrror', error);
            this.snackBar.open('กรุณาตรวจสอบชื่อสินค้า "ต้องขึ้นต้นด้วยตัวใหญ่และมีความยาวมากกว่า2ตัว"', 'OK', {});
          }
        );
    }
  }
}
