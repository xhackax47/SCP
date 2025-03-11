import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ReportComponent } from './report/report.component';
import { ScpComponent } from './scp/scp.component';
import { FoundationComponent } from './foundation/foundation.component';
import { ErrorHandler, inject } from '@angular/core';
import { HomeComponent } from './home/home.component';

export const routes: Routes = [
    { path: '', redirectTo: 'home', pathMatch: 'full' },
    { path: 'home', component: HomeComponent },
    { path: 'login', component: LoginComponent },
    { path: 'logout', component: LoginComponent },
    { path: 'scps', component: ScpComponent },
    { path: 'reports', component: ReportComponent },
    { path: 'foundation', component: FoundationComponent },
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
