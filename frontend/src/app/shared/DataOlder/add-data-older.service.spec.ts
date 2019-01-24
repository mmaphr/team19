import { TestBed, inject } from '@angular/core/testing';

import { AddDataOlderService } from './add-data-older.service';

describe('AddDataOlderService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AddDataOlderService]
    });
  });

  it('should be created', inject([AddDataOlderService], (service: AddDataOlderService) => {
    expect(service).toBeTruthy();
  }));
});
