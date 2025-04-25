import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common'; // <-- Add this
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { WorkationListComponent } from './components/workation-list/workation-list.component';

@NgModule({
  declarations: [
    AppComponent,
    WorkationListComponent
  ],
  imports: [
    BrowserModule,
    CommonModule, // <-- Make sure it's here
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
