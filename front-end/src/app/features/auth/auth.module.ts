import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
<<<<<<< HEAD
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import { LoginComponent } from './pages/login/login.component';

@NgModule({
  declarations: [
  ],
  imports: [
    LoginComponent,
    CommonModule,
    FormsModule,
    RouterModule.forChild([
      { path: '', component: LoginComponent }
    ])
  ]
})
export class AuthModule {}
=======

import { AuthRoutingModule } from './auth-routing.module';


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    AuthRoutingModule,
    
  ]
})
export class AuthModule { }
>>>>>>> 0c42804e2ffd44638b7cb65015cc5ab9d2b6d034
