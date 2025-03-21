import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule], // ✅ Laisse ces imports
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

  login() {
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
