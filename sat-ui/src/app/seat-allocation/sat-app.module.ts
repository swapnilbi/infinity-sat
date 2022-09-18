import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';
import { AppCommonModule } from '../common/common.module';
import { CommonModule } from '@angular/common';
import { SatAppRoutingModule} from './sat-app-routing.module';
import { SatAppComponent } from './sat-app.component';
import { SpaceAllotmentComponent } from './component/space-allotment/space-allotment.component';
import { CreateAllotmentComponent } from './component/create-allotment/create-allotment.component';
import { SeatBookingService } from './service/seatBooking.service';
import { RegistrationHistoryComponent } from './component/registration-history/registration-history.component';
import { MaterialModule } from './material.module';
import { SeatSearchComponent } from './component/seat-search/seat-search.component';

@NgModule({
  declarations: [        
    SatAppComponent,
    SpaceAllotmentComponent,
    CreateAllotmentComponent,
    RegistrationHistoryComponent,
    SeatSearchComponent        
  ],
  imports: [    
    CommonModule,
    FormsModule, 
    SatAppRoutingModule,     
    AppCommonModule,                
    ReactiveFormsModule,    
    FormsModule,    
    SweetAlert2Module.forRoot(),  
    MaterialModule  
  ],
  providers: [SeatBookingService]  
})
export class SatModule { }
