import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [    
  {
    path: 'login', 
    loadChildren: () => import('./authentication/authentication.module').then(m => m.AuthenticationModule)  
  },  
  {
    path: 'sat', 
    loadChildren: () => import('./seat-allocation/sat-app.module').then(m => m.SatModule)  
  },
  { 
    path: '', 
    redirectTo: 'login', 
    pathMatch: 'full' 
  }  
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
