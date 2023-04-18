import { TestBed } from '@angular/core/testing';

import { ServiceExempleService } from './service-exemple.service';

describe('ServiceExempleService', () => {
  let service: ServiceExempleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServiceExempleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
