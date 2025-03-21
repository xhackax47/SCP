import { Component } from '@angular/core';
import { RouterModule } from '@angular/router'; // Importer RouterModule
import { AuthService } from './login/auth.service';
import { CommonModule, NgIf } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterModule, 
    CommonModule
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.less']
})

export class AppComponent {
  //constructor(private authService: AuthService) {}

  logout() {
    //this.authService.logout();
  }
  title = 'SCP Application';
}
