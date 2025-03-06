import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { ReportComponent } from './report/report.component';
import { ScpComponent } from './scp/scp.component';
import { FoundationComponent } from './foundation/foundation.component';
import { AppComponent } from './app.component';

export const routes: Routes = [

    { path: '', component: AppComponent },
    { path: 'home', component: HomeComponent },
    { path: 'login', component: LoginComponent },
    { path: 'logout', component: LoginComponent },
    { path: 'scps', component: ScpComponent },
    { path: 'reports', component: ReportComponent },
    { path: 'foundation', component: FoundationComponent }
];
