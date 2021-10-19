import { Component, OnInit } from '@angular/core';
import { LoggedComponent } from '../logged/logged.component';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
  currentUser: any;

  constructor(private token: TokenStorageService,  ) { }

  ngOnInit(): void {
    this.currentUser = this.token.getUser();
  }
}