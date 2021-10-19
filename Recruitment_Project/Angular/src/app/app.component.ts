import { Component } from '@angular/core';
import { TokenStorageService } from './_services/token-storage.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
title = "PROJEKT"
  private roles: string[] = [];
  isLoggedIn = false;
  showAdmin = false;
  username?: string;

constructor(private tokenStorageService: TokenStorageService){}

ngOnInit(): void{
this.isLoggedIn= !!this.tokenStorageService.getToken();
if(this.isLoggedIn){

const user = this.tokenStorageService.getUser();

this.roles=user.roles;
this.showAdmin = this.roles.includes('ROLE_ADMIN');

this.username = user.username;
}
}
}
