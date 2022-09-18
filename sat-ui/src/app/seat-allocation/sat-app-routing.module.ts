import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SatAppComponent } from './sat-app.component';
import { HomeComponent } from './component/home/home.component';
import { SpaceAllotmentComponent } from './component/space-allotment/space-allotment.component';
import { CreateAllotmentComponent } from './component/create-allotment/create-allotment.component';
import { SpaceDistributeComponent } from './component/space-distribute/space-distribute.component';

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
