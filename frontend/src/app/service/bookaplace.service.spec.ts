import { TestBed, inject } from '@angular/core/testing';

import { BookaplaceService } from './bookaplace.service';

describe('BookaplaceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BookaplaceService]
    });
  });

  it('should be created', inject([BookaplaceService], (service: BookaplaceService) => {
    expect(service).toBeTruthy();
  }));
});
