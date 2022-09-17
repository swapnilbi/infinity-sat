import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';
import { AppCommonModule } from '../common/common.module';
import { CommonModule } from '@angular/common';
import { SatAppRoutingModule} from './sat-app-routing.module';
import { HomeComponent } from './component/home/home.component';
import { SatAppComponent } from './sat-app.component';

@NgModule({
  declarations: [        
    SatAppComponent        
  ],
  imports: [    
    CommonModule,
    FormsModule, 
    SatAppRoutingModule,     
    AppCommonModule,                
    ReactiveFormsModule,    
    FormsModule,    
    SweetAlert2Module.forRoot()    
  ],
  providers: []  
})
export class SatModule { }
