import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MoreDateOlderComponent } from './more-date-older.component';

describe('MoreDateOlderComponent', () => {
  let component: MoreDateOlderComponent;
  let fixture: ComponentFixture<MoreDateOlderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MoreDateOlderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MoreDateOlderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
