import { Injectable } from '@angular/core';
<<<<<<< HEAD
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({ providedIn: 'root' })
export class AuthService {
  private baseUrl = 'http://localhost:7000/api/auth';

  constructor(private http: HttpClient, private router: Router) {}

  login(data: any) {
    return this.http.post(`${this.baseUrl}/login`, data, { responseType: 'text' });
  }

register(data: any) {
  return this.http.post(`${this.baseUrl}/register`, data);
}

  guardarToken(token: string) {
    localStorage.setItem('token', token);
  }

  obtenerToken(): string | null {
    return localStorage.getItem('token');
  }

  estaAutenticado(): boolean {
    return !!this.obtenerToken();
  }

  logout() {
    localStorage.removeItem('token');
    this.router.navigate(['/login']);
  }
=======

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }
>>>>>>> c4b8ca0 (avance proyecto)
}
