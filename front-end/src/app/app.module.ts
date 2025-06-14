import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { provideFirebaseApp, initializeApp } from '@angular/fire/app';
import { provideMessaging, getMessaging } from '@angular/fire/messaging';

import { AppComponent } from './app.component';
import { routes } from './app.routes';
import { TokenInterceptor } from './core/interceptors/token.interceptor';
import { DashboardComponent } from './features/auth/pages/dashboard/dashboard.component';
import { LoginComponent } from './features/auth/pages/login/login.component';
import { FormsModule } from '@angular/forms';
import { environment } from '../environments/environment';  // Asegúrate de que se está importando correctamente

import { AngularFireModule } from '@angular/fire';
import { AngularFireMessagingModule } from '@angular/fire/messaging';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes),

    // Inicializa Firebase
    provideFirebaseApp(() => initializeApp(environment.firebaseConfig)),

    // Proporcionar Firebase Messaging
    provideMessaging(() => getMessaging()),

    // Asegúrate de tener estos módulos
    AngularFireModule.initializeApp(environment.firebaseConfig),
    AngularFireMessagingModule,  // Importa el módulo para las notificaciones push
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
