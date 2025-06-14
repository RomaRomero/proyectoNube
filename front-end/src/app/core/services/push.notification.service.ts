import { Injectable } from '@angular/core';
import { Messaging, getToken } from '@angular/fire/messaging';
import { Observable } from 'rxjs';
import { onMessage } from '@angular/fire/messaging';

@Injectable({
  providedIn: 'root'
})
export class PushNotificationService {

  constructor(private afMessaging: Messaging) { }

  // Solicitar permiso para recibir notificaciones
  requestPermission(): Observable<any> {
    return new Observable(observer => {
      getToken(this.afMessaging).then(
        (token: string | null) => {
          if (token) {
            console.log('Notification token:', token);
            observer.next(token);  // Devuelve el token
          } else {
            console.error('No se pudo obtener el token');
            observer.error('No se pudo obtener el token'); // Manejo de error si no se obtiene el token
          }
        }
      ).catch(
        (error: Error) => {
          console.error('Permission request failed:', error);
          observer.error(error); // Manejo del error si la solicitud de permiso falla
        }
      );
    });
  }

  // Escuchar mensajes de Firebase
  receiveMessage(): Observable<any> {
    return new Observable(observer => {
      const unsubscribe = onMessage(this.afMessaging, (payload: any) => {
        console.log('Message received:', payload);
        observer.next(payload); // Devuelve el mensaje recibido
      });

      return () => unsubscribe(); // Ensure cleanup when observable is unsubscribed
    });
  }
}
