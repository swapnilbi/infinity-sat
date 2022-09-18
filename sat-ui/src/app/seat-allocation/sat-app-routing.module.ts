import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SatAppComponent } from './sat-app.component';
import { HomeComponent } from './component/home/home.component';
import { SpaceAllotmentComponent } from './component/space-allotment/space-allotment.component';
import { CreateAllotmentComponent } from './component/create-allotment/create-allotment.component';
import { ReservationComponent } from './component/reservation/reservation.component';
import { ReservationHistoryComponent } from './component/reservation-history/reservation-history.component';
import { SpaceDistributeComponent } from './component/space-distribute/space-distribute.component';
import { ViewReservationComponent } from './component/view-reservation/view-reservation.component';

const routes: Routes = [  
  {
    path: '',
        component: SatAppComponent,
        children: [
          {
            path : "home",
            component : HomeComponent
          }, 
          {
            path : "space/allotment",
            component : SpaceAllotmentComponent
          }, 
          {
            path : "space/allotment/create",
            component : CreateAllotmentComponent
          },
          {
            path : "space/distribute",
            component : SpaceDistributeComponent
          },     
          {
            path : "reservation/new",
            component : ReservationComponent
          },
          {
            path : "reservation/history",
            component : ReservationHistoryComponent
          },
          {
            path : "reservation/view",
            component : ViewReservationComponent
          },         
          {
            path : "",
            component : ReservationComponent
          }
        ]  
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SatAppRoutingModule { }
