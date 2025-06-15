import { Routes } from '@angular/router';
import { LoginComponent } from './features/auth/pages/login/login.component';
import { DashboardComponent } from './features/auth/pages/dashboard/dashboard.component';
import { RegisterComponent } from './features/auth/pages/register/register.component';

export const routes: Routes = [
  {
<<<<<<< HEAD
  path: 'login',
  loadComponent: () =>
    import('./features/auth/pages/login/login.component').then(m => m.LoginComponent)
},
  {
    path: 'dashboard',
    loadChildren: () => import('./features/auth/pages/dashboard/dashboard.module').then(m => m.DashboardModule)
  },
  {
    path: '**',
    redirectTo: 'login'
=======
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'dashboard',
    component: DashboardComponent 
  },
   {
    path: 'register',
    component:  RegisterComponent
  },
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
>>>>>>> 0c42804e2ffd44638b7cb65015cc5ab9d2b6d034
  }
];
