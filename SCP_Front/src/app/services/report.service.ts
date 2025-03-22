import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Report } from '../models/report.model';

@Injectable({
  providedIn: 'root'
})
export class ReportService {
  private apiUrlGetReports = 'http://localhost:8080/reports';
  private apiUrlCreateDeleteUpdateGetReportByID = 'http://localhost:8080/report';

  constructor(private http: HttpClient) {}

  getReports(): Observable<Report[]> {
    return this.http.get<Report[]>(this.apiUrlGetReports);
  }

  getReportById(id: number): Observable<Report> {
    return this.http.get<Report>(`${this.apiUrlCreateDeleteUpdateGetReportByID}/${id}`);
  }

  createReport(report: Report): Observable<Report> {
    return this.http.post<Report>(this.apiUrlCreateDeleteUpdateGetReportByID, report);
  }

  updateReport(id: number, report: Report): Observable<Report> {
    return this.http.put<Report>(`${this.apiUrlCreateDeleteUpdateGetReportByID}/${id}`, report);
  }

  deleteReport(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrlCreateDeleteUpdateGetReportByID}/${id}`);
  }
}
