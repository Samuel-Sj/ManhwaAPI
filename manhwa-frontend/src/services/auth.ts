import { Injectable } from '@angular/core';
import {Router} from '@angular/router'
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root',
})
export class Auth {
  private apiUrl = "localhost:8080/login";
  private token: string | null = null;
  constructor (private http: HttpClient, private router: Router) {}
  
  login (username: string, password: string): Observable<any>{
    return this.http.post(`${this.apiUrl}/login`, {username, password});
  }
  setToken(token: string):void{
    this.token = token;
    localStorage.setItem('access_token', token);
  }

  getToken():string | null{
    return this.token || localStorage.getItem('access_token')
  }

  logout():void{
    this.token = null;
    localStorage.removeItem('access_token');
    this.router.navigate(['/login']);

  }

  isAuthenticated(): boolean{
    return this.getToken() !== null;
  }
}
