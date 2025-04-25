import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Workation {
  id: string;
  employee: string;
  origin: string;
  destination: string;
  startDate: string;
  endDate: string;
  workingDays: number;
  risk: string;
}

@Injectable({
  providedIn: 'root'
})
export class WorkationService {

  private apiUrl = 'http://localhost:8080/workflex/workation';

  constructor(private http: HttpClient) { }

  getWorkations(): Observable<Workation[]> {
    return this.http.get<Workation[]>(this.apiUrl);
  }
}
