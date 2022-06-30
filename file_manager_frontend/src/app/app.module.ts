import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'
import { FormsModule } from '@angular/forms';

/* Import components and modules of project */
import { AppComponent } from './app.component';
import { LogInComponent } from './log-in/log-in.component';
import { ExplorerComponent } from './explorer/explorer.component';

// Routing Module
import { AppRoutingModule } from './app-routing.module';

// Authentication Guard Service
import { AuthGuard } from './auth/guard.service';

@NgModule({
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    AppRoutingModule
  ],
  declarations: [
    AppComponent,
    LogInComponent,
    ExplorerComponent
  ],
  providers: [AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
