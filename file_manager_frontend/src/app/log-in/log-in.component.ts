import { Component, Injectable, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

/** Import model */
import { User } from '../models/user.model';

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})

@Injectable()
export class LogInComponent implements OnInit {

  // Create a user from user model
  public user: User;

  USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser';

  // Username and password variable
  public username: String;
  public password: String;

  // Login state variable
  public loginState!: Boolean;

  constructor(
    // Define a HttpClient named http
    public http: HttpClient,
    private router: Router,
  ) {
    // Create user object from UserModel
    this.user = new User();
    // Assign initial login state
    this.loginState = false;
  }

  ngOnInit(): void {
  }

  authenticationService() {
    return this.http.get('http://localhost:8080/api/login',
      { headers: { authorization: this.createBasicAuthToken(this.username, this.password) } })
      .subscribe(() => 
      this.registerSuccessfulLogin(this.username, this.password)
      );
  }

  createBasicAuthToken(username: String, password: String) {
    localStorage.setItem("token", 'Basic ' + btoa(username + ":" + password));
    return 'Basic ' + window.btoa(username + ":" + password);
  }

  registerSuccessfulLogin(username: String, password: any) {
    sessionStorage.setItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME, password)
    console.log(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
    
    this.loginState = true;

    this.router.navigate(['/explorer'])
    
  }

  deneme() {
    const headers: HttpHeaders = new HttpHeaders({Authorization: localStorage.getItem('token')});
    return this.http.get('http://localhost:8080/api/deneme', {headers})
    .subscribe(res => console.log(res), err=>console.log(err));
  }

}
