import { TestBed, inject } from '@angular/core/testing';

import { TrainAddService } from './train-add.service';

describe('TrainAddService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TrainAddService]
    });
  });

  it('should be created', inject([TrainAddService], (service: TrainAddService) => {
    expect(service).toBeTruthy();
  }));
});
