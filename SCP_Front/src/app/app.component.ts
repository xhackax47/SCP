import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { FoundationComponent } from './foundation/foundation.component';
import { LoginComponent } from './login/login.component';
import { ReportComponent } from './report/report.component';
import { ScpComponent } from './scp/scp.component';

@Component({
  selector: 'app-root',
  imports: [RouterLink, 
    HomeComponent, 
    FoundationComponent, 
    LoginComponent, 
    ReportComponent, 
    ScpComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.less'
})

export class AppComponent {
  title = 'SCP Foundation';
}
