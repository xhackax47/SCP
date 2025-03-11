import { Component } from '@angular/core';
import { RouterModule } from '@angular/router'; // Importer RouterModule

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterModule],  // Ajouter RouterModule ici
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.less']
})
export class AppComponent {
  title = 'SCP Application';
}
