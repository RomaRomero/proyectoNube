import { ApplicationConfig, importProvidersFrom, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';
import { routes } from './app.routes';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { providePrimeNG } from 'primeng/config';
import Aura from '@primeng/themes/aura';
import { provideMessaging } from '@angular/fire/messaging';
import { FirebaseApp } from '@angular/fire/app';
import { PushNotificationService } from './core/services/push.notification.service';  // Tu servicio de notificaciones push


export const appConfig: ApplicationConfig = {
  providers: [
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    importProvidersFrom(
      HttpClientModule,
      FormsModule,
    ), provideAnimationsAsync(),
    providePrimeNG({
      theme: {
        preset: Aura
      }
    }),
    provideMessaging(injector => ({
      ...injector.get(PushNotificationService),
      app: injector.get(FirebaseApp) // Ensure the app property is provided
    })),  // Si usas Firebase Messaging
    PushNotificationService  // Tu servicio de notificaciones push personalizado
  ]
};

