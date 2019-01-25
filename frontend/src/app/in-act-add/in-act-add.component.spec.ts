import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InActAddComponent } from './in-act-add.component';

describe('InActAddComponent', () => {
  let component: InActAddComponent;
  let fixture: ComponentFixture<InActAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InActAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InActAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
