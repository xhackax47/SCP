import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { AuthService } from './auth.service';

@Component({
  selector: 'app-login',
  imports: [],
  templateUrl: 'login/login.component.html',
  styleUrl: 'login/login.component.less'
})

export class LoginComponent implements OnInit {

  username: string;
  password: string;
  errorMessage = 'Informations d\'identification invalides - ACTIVATION DE LA SECURITE PAR AGENT SCP MEMETIQUE';
  successMessage: string;
  invalidLogin = false;
  loginSuccess = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthService) { }

  ngOnInit() {
  }

  handleLogin() {
    this.authenticationService.authenticationService(this.username, this.password).subscribe((result) => {
      this.invalidLogin = false;
      this.loginSuccess = true;
      this.successMessage = 'Informations d\'identification valides - DESACTIVATION DE LA SECURITE PAR AGENT SCP MEMETIQUE';
      this.router.navigate(['/home']);
    }, () => {
      this.invalidLogin = true;
      this.loginSuccess = false;
    });
  }
}
