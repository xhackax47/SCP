import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import { provideHttpClient } from '@angular/common/http';
import { provideRouter } from '@angular/router';
import { routes } from './app/app.routes';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

bootstrapApplication(AppComponent, {
  providers: [
    provideHttpClient(), // HttpClient fourni globalement
    provideRouter(routes), // Fournir le routage globalement
    FormsModule,  // Importer CommonModule ici pour les directives comme ngModel
    CommonModule  // Importer CommonModule ici pour les directives comme ngIf
  ]
})
  .catch((err) => console.error(err));
