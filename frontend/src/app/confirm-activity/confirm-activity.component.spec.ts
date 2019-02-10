import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfirmActivityComponent } from './confirm-activity.component';

describe('ConfirmActivityComponent', () => {
  let component: ConfirmActivityComponent;
  let fixture: ComponentFixture<ConfirmActivityComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConfirmActivityComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConfirmActivityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
