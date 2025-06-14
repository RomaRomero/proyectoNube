import { Injectable } from '@angular/core';
import { Messaging, getToken, onMessage } from '@angular/fire/messaging';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from '../../../environments/environment';  // Importar el archivo environment.ts


@Injectable({
  providedIn: 'root'
})
export class PushNotificationService {

    private apiKey: string = environment.apiKey;  // Aquí tomamos la API Key desde environment.ts
  private apiUrlMicroservice: string = environment.apiUrlMicroservice; 
  constructor(private afMessaging: Messaging) { }

  // Solicitar permiso para recibir notificaciones
  requestPermission(): Observable<string> {
    return new Observable<string>((observer) => {
      // Solicitar el token de Firebase para las notificaciones push
      getToken(this.afMessaging, {
        vapidKey: this.apiKey // VAPID key para FCM (reemplázalo con tu propia clave)
      }).then((token: string | null) => {
        if (token) {
          console.log('Notification token:', token);
          observer.next(token);  // Devuelve el token
          observer.complete(); // Marca el observable como completo
        } else {
          console.error('No se pudo obtener el token');
          observer.error('No se pudo obtener el token'); // En caso de error
        }
      }).catch((error) => {
        console.error('Permission request failed:', error);
        observer.error(error); // En caso de error
      });
    }).pipe(
      catchError((error) => {
        console.error('Error al obtener token', error);
        throw error; // Propaga el error
      })
    );
  }

  // Escuchar mensajes de Firebase
  receiveMessage(): Observable<any> {
    return new Observable<any>((observer) => {
      // Escuchar los mensajes entrantes desde Firebase
      const unsubscribe = onMessage(this.afMessaging, (payload) => {
        console.log('Mensaje recibido:', payload);
        observer.next(payload);  // Devuelve el mensaje recibido
      });

      // Cuando el observable se desuscribe, limpia el listener
      return () => unsubscribe();
    });
  }
}
