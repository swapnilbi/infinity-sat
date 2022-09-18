import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SatAppComponent } from './sat-app.component';
import { HomeComponent } from './component/home/home.component';
import { SpaceAllotmentComponent } from './component/space-allotment/space-allotment.component';
import { CreateAllotmentComponent } from './component/create-allotment/create-allotment.component';
import { SeatSearchComponent } from './component/seat-search/seat-search.component';
import { RegistrationHistoryComponent } from './component/registration-history/registration-history.component';

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
            path : "reservation",
            component : SeatSearchComponent
          },
          {
            path : "reservation-history",
            component : RegistrationHistoryComponent
          },          
          {
            path : "",
            component : HomeComponent
          }
        ]  
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SatAppRoutingModule { }
