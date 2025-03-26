import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, AbstractControl, ValidationErrors, ReactiveFormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.less']
})
export class RegisterComponent {
  registerForm: FormGroup;
  errorMessage: string = '';
  successMessage: string = '';
  registerSuccess: boolean = false;
  registerError: boolean = false;

  constructor(private fb: FormBuilder, private http: HttpClient, private router: Router) {
    this.registerForm = this.fb.group({
      username: ['', [Validators.required, Validators.minLength(4), Validators.maxLength(30)], this.usernameExists.bind(this)],
      email: ['', [Validators.required, Validators.email, Validators.pattern('.+@fondation-scp\\.com')], this.emailExists.bind(this)],
      password: ['', [Validators.required, Validators.minLength(12), Validators.maxLength(30)]],
      securityLevel: ['', Validators.required]
    });
  }

  onSubmit() {
    this.register();
  }

  register() {
    if (this.registerForm.invalid) {
      this.registerForm.markAllAsTouched();
      return;
    }

    const accountData = this.registerForm.value;

    this.http.post('http://localhost:8080/account', accountData, { responseType: 'text' }).subscribe({
      next: (response) => {
        this.registerSuccess = true;
        this.successMessage = response;
        this.errorMessage = '';
        setTimeout(() => this.router.navigate(['/login']), 1000);
      },
      error: (error) => {
        this.registerSuccess = false;
        this.errorMessage = error.error;
        this.successMessage = '';
      }
    });
  }

  usernameExists(control: AbstractControl): Observable<ValidationErrors | null> {
    return this.http.get<boolean>(`http://localhost:8080/account/exists/username/${control.value}`).pipe(
      map(exists => (exists ? { usernameExists: true } : null))
    );
  }

  emailExists(control: AbstractControl): Observable<ValidationErrors | null> {
    return this.http.get<boolean>(`http://localhost:8080/account/exists/email/${control.value}`).pipe(
      map(exists => (exists ? { emailExists: true } : null))
    );
  }
}
