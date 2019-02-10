import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BookaplaceComponent } from './bookaplace.component';

describe('BookaplaceComponent', () => {
  let component: BookaplaceComponent;
  let fixture: ComponentFixture<BookaplaceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BookaplaceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BookaplaceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
