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
}
=======
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:7000/api/auth';
  private tokenKey = 'auth_token'; // Clave para almacenar el token en localStorage

  constructor(private http: HttpClient) {}

  // Método para iniciar sesión
  login(email: string, password: string): Observable<string> {
    return this.http.post<string>(
      `${this.apiUrl}/login`,
      { correo: email, clave: password },
      { responseType: 'text' as 'json' } // Indica que la respuesta es texto plano (el token)
    ).pipe(
      tap(token => this.saveToken(token)) // Guarda el token al recibirlo
    );
  }

  // Método para registrar un nuevo usuario
  register(usuario: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/register`, usuario);
  }

  // Almacenar el token en localStorage
  private saveToken(token: string): void {
    localStorage.setItem(this.tokenKey, token);
  }

  // Obtener el token almacenado
  getToken(): string | null {
    return localStorage.getItem(this.tokenKey);
  }

  // Verificar si el usuario está autenticado
  isLoggedIn(): boolean {
    return !!this.getToken();
  }

  // Cerrar sesión (eliminar el token)
  logout(): void {
    localStorage.removeItem(this.tokenKey);
  }

  // Agregar el token a las cabeceras HTTP
  getAuthHeaders(): HttpHeaders {
    const token = this.getToken();
    return new HttpHeaders({
      'Authorization': `Bearer ${token}`
    });
  }
}
>>>>>>> 0c42804e2ffd44638b7cb65015cc5ab9d2b6d034
