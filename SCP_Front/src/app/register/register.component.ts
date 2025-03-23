import { Component, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { FormsModule, NgForm } from '@angular/forms';
import { CommonModule } from '@angular/common'; // Importer CommonModule ici

@Component({
  selector: 'app-register',
  imports: [FormsModule, CommonModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.less'
})
export class RegisterComponent {
  username: string = '';
  email: string = '';
  password: string = '';
  securityLevel: number = 1;
  errorMessage: string = '';
  successMessage: string = '';
  registerSuccess: boolean = false;
  registerError: boolean = false;

  constructor(private http: HttpClient, private router: Router) {}

  register() {
    const accountData = {
      userName: this.username,
      defaultEmail: this.email,
      password: this.password,
      securityLevel: this.securityLevel
    };

    this.http.post('http://localhost:8080/account', accountData).subscribe({
      next: (response) => {
        this.registerSuccess = true;
        this.successMessage = 'Compte créé avec succès !';
        this.errorMessage = '';
        setTimeout(() => this.router.navigate(['/login']), 1000);
      },
      error: (error) => {
        this.registerSuccess = false;
        this.errorMessage = 'Erreur lors de la création du compte';
        this.successMessage = '';
      }
    });
  }
}
