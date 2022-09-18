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
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import { AgGridModule } from 'ag-grid-angular';
import { ModalModule } from 'ngx-bootstrap/modal';
import { SplitAllotmentComponent } from './component/split-allotment/split-allotment.component';
import { ReservationComponent } from './component/reservation/reservation.component';
import { ReservationHistoryComponent } from './component/reservation-history/reservation-history.component';
import { ViewReservationComponent } from './component/view-reservation/view-reservation.component';
import { FloorPlanComponent } from './component/floor-plan/floor-plan.component';
import { SeatComponent } from './component/seat/seat.component';
import { SeatSuggestionComponent } from './component/seat-suggestion/seat-suggestion.component';
import {OverlayModule} from '@angular/cdk/overlay';

@NgModule({
  declarations: [
    SatAppComponent,
    SpaceAllotmentComponent,
    CreateAllotmentComponent,
    SpaceDistributeComponent,
    SplitAllotmentComponent,
    ReservationComponent,
    ReservationHistoryComponent,
    ViewReservationComponent,
    FloorPlanComponent,
    SeatComponent,
    SeatSuggestionComponent
  ],
  imports: [
    CommonModule,
    AgGridModule,
    BsDatepickerModule,
    ModalModule.forRoot(),
    FormsModule,
    SatAppRoutingModule,
    AppCommonModule,
    ReactiveFormsModule,
    FormsModule,
    SweetAlert2Module.forRoot(),
    OverlayModule
  ],
  providers: []
})
export class SatModule { }
