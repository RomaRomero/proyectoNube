<<<<<<< HEAD
import { Component } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  imports: [],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {

=======
import { Component, OnInit } from '@angular/core';
import {jwtDecode} from 'jwt-decode';
import { AuthService } from '../../../../core/services/auth.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  imports: [FormsModule,CommonModule,HttpClientModule],
  styleUrls: ['./dashboard.component.css'],
})
export class DashboardComponent implements OnInit {
  rol: string | null = null;

  constructor(private authService: AuthService) {}

  ngOnInit(): void {
    const token = this.authService.getToken();
    if (token) {
      const decoded: any = jwtDecode(token);
      this.rol = decoded.rol || null;
    }
  }
>>>>>>> 0c42804e2ffd44638b7cb65015cc5ab9d2b6d034
}
