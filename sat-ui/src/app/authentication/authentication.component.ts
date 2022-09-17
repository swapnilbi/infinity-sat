import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserAuthService } from './service/user-auth.service';
import { UserProfile } from './model/user-profile.model';
import { timer } from 'rxjs';
import { tap } from 'rxjs/operators';

@Component({
  selector: 'app-root',
  templateUrl: './authentication.component.html'  
})
export class AuthenticationComponent implements OnInit {
    
  userProfile: UserProfile | null = null;

  constructor(private userAuthService : UserAuthService, private router: Router) { }

  ngOnInit(): void {        
    this.userAuthService.getUser().subscribe(response =>{
      if(response){                
        this.userProfile =  response;                
        this.router.navigate(['sat']);         
      }else{                
        this.router.navigate(['login']);           
      }      
    });    
  }

   
}
