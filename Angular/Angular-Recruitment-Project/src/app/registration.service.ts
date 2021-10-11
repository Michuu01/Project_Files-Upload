import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user';
import{HttpClient} from '@angular/common/http'
@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private http:HttpClient) { }

public loginUserFromRemote(user:User):Observable<any>{
 
  return this.http.post<any>("http://localhost:8080/login", user);

}
public RegisterUsertoRemote(user:User):Observable<any>{
  return this.http.post<any>("http://localhost:8080/register", user);

}
//  public loginSuccesFromSpring(user:User):Observable<any>{
//   console.log("o tyu tutuutt") 
//   return this.http.get<any>("http://localhost:8080/loginsuccess");
   
//  }
}
