import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router'; // Importer RouterModule
import { AuthService } from './login/auth.service';
import { CommonModule } from '@angular/common';

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
  constructor(public authService: AuthService, private router: Router) {}

  logout() {
    this.authService.logout();
    if (!this.authService.isUserLoggedIn()) {
      console.log('Déconnexion réussie.');
    } else {
      console.error('L\'utilisateur est toujours connecté.');
    }
    this.router.navigate(['/login']);
  }
  title = 'SCP Application';
}
