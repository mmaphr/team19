import { TestBed, inject } from '@angular/core/testing';

import { RoomImformationService } from './room-imformation.service';

describe('RoomImformationService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RoomImformationService]
    });
  });

  it('should be created', inject([RoomImformationService], (service: RoomImformationService) => {
    expect(service).toBeTruthy();
  }));
});
