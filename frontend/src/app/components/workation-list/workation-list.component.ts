import { Component, OnInit } from '@angular/core';
import { Workation, WorkationService } from '../../services/workation.service';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';


@Component({
  selector: 'app-workation-list',
  imports: [CommonModule, HttpClientModule],
  templateUrl: './workation-list.component.html',
  styleUrls: ['./workation-list.component.scss']
})
export class WorkationListComponent implements OnInit {

  workations: Workation[] = [];
  sortedColumn: string = '';
  sortDirection: 'asc' | 'desc' = 'asc';
  

  constructor(private workationService: WorkationService) { }

  ngOnInit(): void {
    this.workationService.getWorkations().subscribe(data => {
      this.workations = data;
    });
  }

  sort(column: string): void {
    if (this.sortedColumn === column) {
      this.sortDirection = this.sortDirection === 'asc' ? 'desc' : 'asc';
    } else {
      this.sortedColumn = column;
      this.sortDirection = 'asc';
    }

    this.workations.sort((a: any, b: any) => {
      const valueA = a[column];
      const valueB = b[column];
      if (valueA < valueB) return this.sortDirection === 'asc' ? -1 : 1;
      if (valueA > valueB) return this.sortDirection === 'asc' ? 1 : -1;
      return 0;
    });
  }

  getFormattedRisk(risk: string): { text: string, icon: string } {
    switch (risk) {
      case 'LOW':
        return { text: 'Low risk', icon: 'assets/icons/yellow-risk.svg' };
      case 'NO':
        return { text: 'No risk', icon: 'assets/icons/green-risk.svg' };
      case 'HIGH':
        return { text: 'High risk', icon: 'assets/icons/red-risk.svg' };
      default:
        return { text: risk, icon: '' };
    }
  }
  
  
  getFlag(country: string): string {
    const countryCodeMap: { [key: string]: string } = {
      Germany: 'DE',
      'United States': 'US',
      Ukraine: 'UA',
      Belgium: 'BE',
      Spain: 'ES',
      Greece: 'GR',
      India: 'IN'
      // Adicione mais conforme necessário
    };
  
    const code = countryCodeMap[country] || '';
    return code
      .toUpperCase()
      .replace(/./g, char =>
        String.fromCodePoint(127397 + char.charCodeAt(0))
      );
  }
  

}
