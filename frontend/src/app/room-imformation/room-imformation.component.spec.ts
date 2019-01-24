import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RoomImformationComponent } from './room-imformation.component';

describe('RoomImformationComponent', () => {
  let component: RoomImformationComponent;
  let fixture: ComponentFixture<RoomImformationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RoomImformationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RoomImformationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
