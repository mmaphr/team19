import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RoomAllComponent } from './room-all.component';

describe('RoomAllComponent', () => {
  let component: RoomAllComponent;
  let fixture: ComponentFixture<RoomAllComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RoomAllComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RoomAllComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
