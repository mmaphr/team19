import { TestBed, inject } from '@angular/core/testing';

import { InActService } from './in-act.service';

describe('InActService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [InActService]
    });
  });

  it('should be created', inject([InActService], (service: InActService) => {
    expect(service).toBeTruthy();
  }));
});
