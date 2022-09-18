import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';
import { AppCommonModule } from '../common/common.module';
import { CommonModule } from '@angular/common';
import { SatAppRoutingModule} from './sat-app-routing.module';
import { SatAppComponent } from './sat-app.component';
import { SpaceAllotmentComponent } from './component/space-allotment/space-allotment.component';
import { CreateAllotmentComponent } from './component/create-allotment/create-allotment.component';
import { SpaceDistributeComponent } from './component/space-distribute/space-distribute.component';
import { AgGridModule } from 'ag-grid-angular';

@NgModule({
  declarations: [        
    SatAppComponent,
    SpaceAllotmentComponent,
    CreateAllotmentComponent,
    SpaceDistributeComponent        
  ],
  imports: [    
    CommonModule,
    AgGridModule,   
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
