import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainStaffComponent } from './train-staff.component';

describe('TrainStaffComponent', () => {
  let component: TrainStaffComponent;
  let fixture: ComponentFixture<TrainStaffComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrainStaffComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrainStaffComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
