import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { FoundationComponent } from './foundation/foundation.component';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { AuthGuard } from './login/auth.guard';
import { ScpListComponent } from './scp-list/scp-list.component';
import { ScpCreateComponent } from './scp-create/scp-create.component';
import { ScpEditComponent } from './scp-edit/scp-edit.component';
import { ReportListComponent } from './report-list/report-list.component';
import { ReportCreateComponent } from './report-create/report-create.component';
import { ReportEditComponent } from './report-edit/report-edit.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

export const routes: Routes = [
    { path: '', component: HomeComponent, canActivate: [AuthGuard] },
    { path: 'register', component: RegisterComponent },
    { path: 'login', component: LoginComponent },
    { path: 'home', redirectTo: '', pathMatch: 'full' },
    { path: 'scps', component: ScpListComponent, canActivate: [AuthGuard]  },
    { path: 'scp/create', component: ScpCreateComponent, canActivate: [AuthGuard]  },
    { path: 'scp/edit/:id', component: ScpEditComponent, canActivate: [AuthGuard]  },
    { path: 'reports', component: ReportListComponent, canActivate: [AuthGuard]  },
    { path: 'report/create', component: ReportCreateComponent, canActivate: [AuthGuard]  },
    { path: 'report/edit/:id', component: ReportEditComponent, canActivate: [AuthGuard]  },
    { path: 'foundation', component: FoundationComponent, canActivate: [AuthGuard] },
    { path: '**', component: PageNotFoundComponent },  // Page 404
];
