import { TestBed } from '@angular/core/testing';

import { WorkationService } from './workation.service';

describe('WorkationService', () => {
  let service: WorkationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WorkationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
