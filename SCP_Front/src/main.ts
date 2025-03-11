import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import { provideHttpClient, withFetch } from '@angular/common/http';
import { provideRouter } from '@angular/router';
import { routes } from './app/app.routes';
import { FormsModule } from '@angular/forms';  // Assure-toi d'importer FormsModule ici
import { CommonModule } from '@angular/common';

bootstrapApplication(AppComponent, {
  providers: [
    provideHttpClient(withFetch()), // HttpClient fourni globalement
    provideRouter(routes), // Fournir le routage globalement
    FormsModule,
    CommonModule
  ]
})
  .catch((err) => console.error(err));
