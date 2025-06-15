<<<<<<< HEAD
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
=======
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

import { Router } from '@angular/router';
import { AuthService } from '../../../../core/services/auth.service';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-login',
  imports: [
    ReactiveFormsModule,
    CommonModule
  ],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  loginForm: FormGroup;

  errorMessage: string = '';
  loading: boolean = false;

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private router: Router
  ) {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.loginForm.valid) {
      this.loading = true;
      const { email, password } = this.loginForm.value;

      this.authService.login(email!, password!).subscribe({
        next: () => {
          this.loading = false;
          this.router.navigate(['/dashboard']);
        },
        error: (err) => {
          this.loading = false;
          this.errorMessage = 'Credenciales inválidas';
        }
      });
    }
  }

  registersubmit(){
    this.router.navigate(['/register']);
  }
}
>>>>>>> 0c42804e2ffd44638b7cb65015cc5ab9d2b6d034
