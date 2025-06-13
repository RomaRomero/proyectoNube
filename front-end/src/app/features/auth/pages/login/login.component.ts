  import { Component } from '@angular/core';
  import { Router } from '@angular/router';
  import { AuthService } from '../../../../core/services/auth.service'; 
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

  @Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    imports:[CommonModule,FormsModule,HttpClientModule],
    styleUrls: ['./login.component.css']
  })
  export class LoginComponent {
    correo = '';
    clave = '';

    constructor(private auth: AuthService, private router: Router) {}

    login() {
      this.auth.login({ correo: this.correo, clave: this.clave }).subscribe({
        next: token => {
          this.auth.guardarToken(token);
          this.router.navigate(['/dashboard']);
        },
        error: () => alert('Credenciales incorrectas.')
      });
    }
  }
