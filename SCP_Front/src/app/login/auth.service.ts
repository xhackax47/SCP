import { HttpClient } from '@angular/common/http';
import { Inject, Injectable, PLATFORM_ID } from '@angular/core';
import { catchError, map, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class AuthService {

  // URL de base de l'API
  private apiUrl = 'http://localhost:8080/api/v1/auth'; // URL de ton API
  private JWT_TOKEN = 'jwt_token'; // Clé pour stocker le token JWT
  private USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser'; // Déclaration de la constante

  constructor(private http: HttpClient, @Inject(PLATFORM_ID) private platformId: Object) {
    // Ajout d'un log pour voir si HttpClient est bien injecté
    console.log('HttpClient injecté:', this.http);
  }

  // Méthode de connexion pour envoyer les informations d'identification et recevoir un JWT
  authenticationService(username: string, password: string) {
    const credentials = { username, password };
    return this.http.post<any>(`${this.apiUrl}/login`, credentials).pipe(
      map((response) => {
        // Vérification si token existe
        if (!response || !response.token) {
          console.error('Le token est manquant dans la réponse');
          throw new Error('Token missing from response');
        }
        this.storeToken(response.token); // Sauvegarde du token dans le localStorage
        this.registerSuccessfulLogin(username, password); // Enregistrement du login
      }),
      catchError((error) => {
        console.error('Erreur API :', error); // Log de l'erreur
        return throwError(error); // Renvoyer l'erreur si elle survient
      })
    );
  }
  
  // Sauvegarde du token JWT dans le localStorage
  storeToken(token: string) {
    localStorage.setItem(this.JWT_TOKEN, token);  // Sauvegarde le token JWT dans le localStorage
  }

  // Méthode pour enregistrer l'utilisateur connecté dans la session
  registerSuccessfulLogin(username: string, password: string) {
    sessionStorage.setItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME, username);
  }

  // Méthode pour vérifier si l'utilisateur est connecté
  isUserLoggedIn(): boolean {
    return !!localStorage.getItem(this.JWT_TOKEN);  // Vérifie si le token JWT est présent
  }

  // Méthode pour récupérer le token JWT depuis le stockage local
  getToken(): string | null {
    return localStorage.getItem(this.JWT_TOKEN);
  }

  // Méthode pour se déconnecter et supprimer le token JWT
  logout() {
    sessionStorage.removeItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
    localStorage.removeItem(this.JWT_TOKEN);  // Supprime le token JWT du localStorage
  }

  // Méthode pour récupérer le nom de l'utilisateur connecté
  getLoggedInUserName(): string {
    return sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME) || '';
  }

  // Méthode pour créer un en-tête d'authentification avec le token JWT
  createJwtAuthToken() {
    const token = this.getToken();
    return token ? `Bearer ${token}` : '';
  }

  // Vérifier l'état de l'authentification
  checkAuthenticationStatus(): boolean {
    return this.isUserLoggedIn();
  }
}
