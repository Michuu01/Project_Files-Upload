import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { NgForm } from '@angular/forms';
import { AuthService } from '../_services/auth.service';
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent implements OnInit {
  form: any = {
    email:null,
    username: null,
    password: null
  };
  msg= ' ';
  constructor(private service:AuthService, 
     private router:Router) { }

  ngOnInit(): void {
  }
  registerUser(){
    const { email, username, password,  } = this.form;
    this.service.register(email, username, password).subscribe(
      data =>{ 
      console.log("register confirm");
        this.router.navigate(['']);
      
     },
    

      error =>{
         console.log("NIE UDALO SIE....");
         this.msg="you enter a incorrect registration details!";
      }
    )
    }
    
     }

