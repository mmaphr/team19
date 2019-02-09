import { TestBed, inject } from '@angular/core/testing';

import { TrainStaffService } from './train-staff.service';

describe('TrainStaffService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TrainStaffService]
    });
  });

  it('should be created', inject([TrainStaffService], (service: TrainStaffService) => {
    expect(service).toBeTruthy();
  }));
});
