import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
import { User } from '../user';
import { NgForm } from '@angular/forms';
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent implements OnInit {


  user= new User();
  constructor(private service:RegistrationService,
     private router:Router) { }

  ngOnInit(): void {
  }
  registerUser(){

    this.service.RegisterUsertoRemote(this.user).subscribe(
      data =>{ 
      console.log("register confirm");
        this.router.navigate(['']);
      
     },
    

      error =>
         console.log("NIE UDALO SIE....")
    
    )
    }
    
     }


