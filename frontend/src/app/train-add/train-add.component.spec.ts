import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainAddComponent } from './train-add.component';

describe('TrainAddComponent', () => {
  let component: TrainAddComponent;
  let fixture: ComponentFixture<TrainAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrainAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrainAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
