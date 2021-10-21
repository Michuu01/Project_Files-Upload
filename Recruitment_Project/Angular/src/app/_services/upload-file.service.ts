import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class UploadFileService {
  private baseUrl = 'http://localhost:8080/File';

  constructor(private http: HttpClient) { }

  upload(file: File): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();

    formData.append('file', file);

    const req = new HttpRequest('POST', `${this.baseUrl}/Upload`, formData, {
      reportProgress: true,
      responseType: 'json'
    });

    return this.http.request(req);
  }

  download(file: string | undefined): Observable<Blob> {
    return this.http.get(`${this.baseUrl}/files/${file}`, {
      responseType: 'blob'
    });
  }

  getFiles(): Observable<any> {
		return this.http.get(`${this.baseUrl}/Allfiles`);
	  }
}