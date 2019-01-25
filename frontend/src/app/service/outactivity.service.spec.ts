import { TestBed, inject } from '@angular/core/testing';

import { OutactivityService } from './outactivity.service';

describe('OutactivityService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [OutactivityService]
    });
  });

  it('should be created', inject([OutactivityService], (service: OutactivityService) => {
    expect(service).toBeTruthy();
  }));
});
