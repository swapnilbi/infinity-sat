import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { HttpRequestInterceptor } from './common/interceptors/http-interceptor';
import { AuthenticationModule } from './authentication/authentication.module';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppCommonModule } from './common/common.module';
import { MaterialModule } from '../app/seat-allocation/material.module';
@NgModule({
  declarations: [
    AppComponent       
  ],
  imports: [             
    AppCommonModule,    
    BrowserModule,
    BrowserAnimationsModule,        
    AppRoutingModule,    
    AuthenticationModule,
    HttpClientModule,
    MaterialModule 
  ],
  providers: [      
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpRequestInterceptor,
      multi: true
    }        
],
  bootstrap: [AppComponent]
})
export class AppModule { }
