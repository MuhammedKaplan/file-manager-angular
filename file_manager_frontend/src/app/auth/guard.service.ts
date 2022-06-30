import { Injectable } from '@angular/core';
import { CanActivate } from '@angular/router';

import { AccountService } from '../services/account.service';
	

@Injectable()
export class AuthGuard implements CanActivate {
	
	// Define a AccountService named accountService
	constructor(private accountService: AccountService) {}

	// This method return boolean value according to login state
	canActivate() {
	  return this.accountService.isLoggedIn();
	}
}