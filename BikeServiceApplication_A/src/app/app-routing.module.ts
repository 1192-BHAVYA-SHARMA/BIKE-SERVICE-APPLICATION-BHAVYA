import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from 'src/components/login/login.component';
import { RegisterComponent } from 'src/components/register/register.component';
import { AppComponent } from './app.component';
import { HomeComponent } from 'src/components/home/home.component';
import { DetailsOfProviderComponent } from 'src/components/details-of-provider/details-of-provider.component';
import { LandingPageComponent } from 'src/components/landing-page/landing-page.component';
import { BookingBikeServiceComponent } from 'src/components/booking-bike-service/booking-bike-service.component';

const routes: Routes = [
  {path:'',component:LandingPageComponent},
  {path:'login',component:LoginComponent},
  {path:'register',component:RegisterComponent},
  {path:'home',component:HomeComponent},
  {path:'ervice-provider-details/:id',component:DetailsOfProviderComponent},
  {path:'back',component:HomeComponent},
  {path:'details/:id', component:DetailsOfProviderComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
