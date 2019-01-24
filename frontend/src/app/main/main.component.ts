import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  breakpoint: number;
  constructor() { }

  ngOnInit() {
    this.breakpoint = (window.innerWidth <= 1024) ? 1 : 3;
  }
  onResize(event) {
    this.breakpoint = (event.target.innerWidth <= 1024) ? 1 : 3;
  }
}
