import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS, HttpClient } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { provideFirebaseApp, initializeApp } from '@angular/fire/app';

import { AppComponent } from './app.component';
import { routes } from './app.routes';
import { TokenInterceptor } from './core/interceptors/token.interceptor';
import { DashboardComponent } from './features/auth/pages/dashboard/dashboard.component';
import { LoginComponent } from './features/auth/pages/login/login.component';
import { FormsModule } from '@angular/forms';
import { environment } from '../environments/environment';
import { AngularFireMessagingModule } from '@angular/fire/messaging';
@NgModule({
  declarations: [],
  imports: [
    BrowserModule,
    LoginComponent,
    HttpClientModule,
    FormsModule,
    AppComponent,
    DashboardComponent,
    HttpClientModule,
    provideFirebaseApp(() => initializeApp(environment.firebaseConfig)),  // Initialize Firebase with your configuration
    AngularFireMessagingModule,  // Importa el módulo de mensajería de Firebase
    RouterModule.forRoot(routes)
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi: true }
  ],
})
export class AppModule {}
