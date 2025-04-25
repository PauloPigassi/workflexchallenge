import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

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

  private readonly apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) { }

  getWorkations(): Observable<Workation[]> {
    return this.http.get<Workation[]>(this.apiUrl+"/workflex/workation");
  }
}
