import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'; // Importer RouterModule
import { AuthService } from './auth.service';
import { FormsModule } from '@angular/forms';  // Assure-toi d'importer FormsModule ici
import { CommonModule } from '@angular/common'; // Importer CommonModule ici

@Component({
  selector: 'app-login',
  standalone: true,
  providers: [AuthService],
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.less']
})

export class LoginComponent implements OnInit {
  username: string = '';
  password: string = '';
  errorMessage = 'Informations d\'identification invalides';
  successMessage: string = '';
  invalidLogin = false;
  loginSuccess = false;

  constructor(
    private router: Router,
    private authenticationService: AuthService) { }

  ngOnInit() {}

  handleLogin() {
    this.authenticationService.authenticationService(this.username, this.password).subscribe({
      next: (response) => {
        this.invalidLogin = false;
        this.loginSuccess = true;
        this.successMessage = 'Informations d\'identification valides';
        this.router.navigate(['/home']);
      },
      error: (error) => {
        this.invalidLogin = true;
        this.loginSuccess = false;
      }
    });    
  }
}
