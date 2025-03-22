import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SCP } from '../models/scp.model';

@Injectable({
  providedIn: 'root'
})

export class ScpService {
  private apiUrlGetScps = 'http://localhost:8080/scps';
  private apiUrlCreateDeleteUpdateGetScpByID = 'http://localhost:8080/scp';

  constructor(private http: HttpClient) { }

  getAllScps(): Observable<SCP[]> {
    return this.http.get<SCP[]>(`${this.apiUrlGetScps}`);
  }

  getScpById(id: number): Observable<SCP> {
    return this.http.get<SCP>(`${this.apiUrlCreateDeleteUpdateGetScpByID}/${id}`);
  }

  createScp(scp: SCP): Observable<SCP> {
    return this.http.post<SCP>(this.apiUrlCreateDeleteUpdateGetScpByID, scp);
  }

  updateScp(id: number, scp: SCP): Observable<SCP> {
    return this.http.put<SCP>(`${this.apiUrlCreateDeleteUpdateGetScpByID}/${id}`, scp);
  }

  deleteScp(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrlCreateDeleteUpdateGetScpByID}/${id}`);
  }
}
