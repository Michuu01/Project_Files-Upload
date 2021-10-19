import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http: HttpClient) { }

  getPublicContent(): Observable<any> {
    return this.http.get('http://localhost:8080/api/test/all', { responseType: 'text' });
  }

  getUserBoard(): Observable<any> {
    return this.http.get('http://localhost:8080/api/test/user', { responseType: 'text' });
  }

//   getModeratorBoard(): Observable<any> {
//     return this.http.get(API_URL + 'mod', { responseType: 'text' });
//   }

//   getAdminBoard(): Observable<any> {
//     return this.http.get(API_URL + 'admin', { responseType: 'text' });
//   }
// }
}