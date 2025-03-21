// import { Injectable } from '@angular/core';
// import { HttpClient } from '@angular/common/http';
// import { Observable } from 'rxjs';
// import { Scp } from '../models/scp.model';

// @Injectable({
//   providedIn: 'root'
// })
// export class ScpService {
//   private apiUrl = 'http://localhost:8100/scps';

//   constructor(private http: HttpClient) { }

//   getAllScps(): Observable<Scp[]> {
//     return this.http.get<Scp[]>(`${this.apiUrl}`);
//   }

//   getScpById(id: number): Observable<Scp> {
//     return this.http.get<Scp>(`${this.apiUrl}/${id}`);
//   }

//   createScp(scp: Scp): Observable<Scp> {
//     return this.http.post<Scp>(this.apiUrl, scp);
//   }

//   updateScp(id: number, scp: Scp): Observable<Scp> {
//     return this.http.put<Scp>(`${this.apiUrl}/${id}`, scp);
//   }

//   deleteScp(id: number): Observable<void> {
//     return this.http.delete<void>(`${this.apiUrl}/${id}`);
//   }
// }
