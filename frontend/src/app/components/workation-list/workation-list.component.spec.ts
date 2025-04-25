import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { WorkationService } from '../../services/workation.service';
import { Workation } from '../../services/workation.service';

describe('WorkationService', () => {
  let service: WorkationService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [WorkationService]
    });

    service = TestBed.inject(WorkationService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should call GET and return a list of workations', () => {
    const mockWorkations: Workation[] = [
      {
        id: '1',
        employee: 'Alice',
        origin: 'Germany',
        destination: 'Spain',
        startDate: '2024-01-01',
        endDate: '2024-01-10',
        workingDays: 8,
        risk: 'LOW_RISK'
      }
    ];

    service.getWorkations().subscribe(workations => {
      expect(workations.length).toBe(1);
      expect(workations[0].employee).toEqual('Alice');
    });

    const req = httpMock.expectOne('http://localhost:8080/workflex/workation');
    expect(req.request.method).toBe('GET');
    req.flush(mockWorkations);
  });
});