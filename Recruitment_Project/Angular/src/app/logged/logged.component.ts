import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../_services/token-storage.service';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-board-user',
  templateUrl: './Logged.Component.html',
  styleUrls: ['./Logged.Component.scss']
})
export class LoggedComponent implements OnInit {
  isLogaOutIn = false;
  content?: string;

  constructor(private userService: UserService,
    private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
    this.userService.getUserBoard().subscribe(
      data => {
        this.content = data;
        if(this.content =="User Content."){
         this.isLogaOutIn = true;
        }else{
          this.isLogaOutIn = false;
        }
      },
      err => {
        this.content = JSON.parse(err.error).message;
      }
    );
  }
  logout(): void {
    this.tokenStorageService.signOut();
    window.location.reload();
  
  }
}
