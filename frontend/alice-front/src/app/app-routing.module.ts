import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {Comp1Component} from "./componentes/comp1/comp1.component";
import {Comp2Component} from "./componentes/comp2/comp2.component";
import {RotaCustomComponent} from "./componentes/rota-custom/rota-custom.component";
import {Comp3Component} from "./componentes/comp3/comp3.component";

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/welcome' },
  { path: 'welcome', loadChildren: () => import('./pages/welcome/welcome.module').then(m => m.WelcomeModule) },
  { path: 'link1', component: Comp1Component},
  { path: 'link2', component: Comp2Component},
  {path: 'link3', component: Comp3Component},
  {path: 'custom/:id', component: RotaCustomComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
