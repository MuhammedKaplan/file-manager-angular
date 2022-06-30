import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(
    // Define router type of Router
    private router: Router,
  ) { }

  // Create login control method return boolean
  isLoggedIn(): boolean {
    // Get token item from local storage
    const token = localStorage.getItem('token');
    // If we have token then login state true
    if (token) {
      return true;
    }
    // If we don't have token then login state true 
    else {
      this.router.navigate(['/login']);
      return false;
    }
  }

}