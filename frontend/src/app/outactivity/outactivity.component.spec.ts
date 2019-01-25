import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OutactivityComponent } from './outactivity.component';

describe('OutactivityComponent', () => {
  let component: OutactivityComponent;
  let fixture: ComponentFixture<OutactivityComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OutactivityComponent ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OutactivityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
