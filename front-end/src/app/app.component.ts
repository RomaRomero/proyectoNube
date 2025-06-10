import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { PushNotificationService } from './core/services/push.notification.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'front-end';

  
    constructor(private pushNotificationService: PushNotificationService, private http: HttpClient) {}
  
    ngOnInit(): void {
      // Solicitar permiso para recibir notificaciones push
      this.pushNotificationService.requestPermission().subscribe(
        (token) => {
          console.log('Token de notificación recibido:', token);
  
          // Enviar el token al servidor (microservicio)
          this.sendTokenToServer(token);
        },
        (error) => {
          console.error('Error al obtener el token de notificación:', error);
        }
      );
  
      // Escuchar las notificaciones entrantes
      this.pushNotificationService.receiveMessage().subscribe((message) => {
        console.log('Mensaje de notificación recibido:', message);
      });
    }
  
    // Enviar el token al servidor (microservicio)
    sendTokenToServer(token: string) {
      const url = 'http://localhost:8080/push'; // URL de tu microservicio
      const body = { token: token, title: 'Notificación de prueba', body: 'Este es el contenido de la notificación' };
  
      this.http.post(url, body).subscribe(response => {
        console.log('Respuesta del servidor:', response);
      });
    }
  }
  
