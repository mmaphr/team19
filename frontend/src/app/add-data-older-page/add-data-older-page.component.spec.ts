import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddDataOlderPageComponent } from './add-data-older-page.component';

describe('AddDataOlderPageComponent', () => {
  let component: AddDataOlderPageComponent;
  let fixture: ComponentFixture<AddDataOlderPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddDataOlderPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddDataOlderPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
