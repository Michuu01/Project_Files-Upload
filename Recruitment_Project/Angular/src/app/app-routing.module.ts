import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoggedComponent } from './logged/logged.component';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './profile/profile.component';
import { RegistrationComponent } from './registration/registration.component';
import { AuthInterceptor } from './_services/auth.interceptor';

const routes: Routes = [

  {path: 'home', component:HomeComponent},
{path: 'login' , component:LoginComponent},
{path: 'registration', component:RegistrationComponent},
{path: 'logged', component:LoggedComponent},
{path: 'profile', component:ProfileComponent},
{ path: '', redirectTo: 'home', pathMatch: 'full' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
