import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SatAppComponent } from './sat-app.component';
import { HomeComponent } from './component/home/home.component';

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
