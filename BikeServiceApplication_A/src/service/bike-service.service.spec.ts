import { TestBed } from '@angular/core/testing';

import { BikeServiceService } from './bike-service.service';

describe('BikeServiceService', () => {
  let service: BikeServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BikeServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
