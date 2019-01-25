import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowsOutActivityComponent } from './shows-out-activity.component';

describe('ShowsOutActivityComponent', () => {
  let component: ShowsOutActivityComponent;
  let fixture: ComponentFixture<ShowsOutActivityComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowsOutActivityComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowsOutActivityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
