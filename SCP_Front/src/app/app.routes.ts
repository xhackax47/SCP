import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ReportComponent } from './report/report.component';
import { ScpComponent } from './scp/scp.component';
import { FoundationComponent } from './foundation/foundation.component';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { AuthGuard } from './login/auth.guard';

export const routes: Routes = [
    { path: 'register', component: RegisterComponent },
    { path: 'login', component: LoginComponent },
    { path: 'logout', component: LoginComponent },
    { path: '', component: HomeComponent, canActivate: [AuthGuard]  },
    { path: 'home', redirectTo: '', pathMatch: 'full' },
    { path: 'scps', component: ScpComponent, canActivate: [AuthGuard] },
    { path: 'reports', component: ReportComponent, canActivate: [AuthGuard] },
    { path: 'foundation', component: FoundationComponent, canActivate: [AuthGuard] },
    /*
    //{ path: '**', component: PageNotFoundComponent },  // Wildcard route for a 404 page
    {
        path: "old-user-page",
        redirectTo: ({ queryParams }) => {
            const errorHandler = inject(ErrorHandler);
            const userIdParam = queryParams['userId'];
            if (userIdParam !== undefined) {
                return `/user/${userIdParam}`;
            } else {
                errorHandler.handleError(new Error('Attempted navigation to user page without user ID.'));
                return `/not-found`;
            }
        },
    },
    */
];
