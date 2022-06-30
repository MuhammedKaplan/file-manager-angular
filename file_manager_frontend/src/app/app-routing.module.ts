import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

/** Import necessary modules and services */
// Authentication
import { AuthGuard } from './auth/guard.service';

// Modules
import { ExplorerComponent } from './explorer/explorer.component';
import { LogInComponent } from './log-in/log-in.component';

// Url routing paths
const routes: Routes = [
  { path: '', component: LogInComponent, },
  { path: 'login', component: LogInComponent },
  { path: 'explorer', component: ExplorerComponent, canActivate: [AuthGuard]}
];

@NgModule({
  // Use RouterModule from router in angular
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }