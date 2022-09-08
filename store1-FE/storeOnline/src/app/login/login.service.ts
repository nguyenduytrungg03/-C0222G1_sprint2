import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Login} from '../model/Login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  constructor(private http: HttpClient) {
  }

  login(accout: Login): Observable<any> {
    return  this.http.post<Login>('http://localhost:8080/sign', accout);
  }
}
