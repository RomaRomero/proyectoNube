import { Routes } from '@angular/router';

export const routes: Routes = [
  {
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
  }
];
