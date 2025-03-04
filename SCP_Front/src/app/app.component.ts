import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HomeComponent } from './home/home.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, HomeComponent],
  templateUrl: 'home/home.component.html',
  styleUrl: 'home/home.component.less'
})
export class AppComponent {
  title = 'SCP Foundation';
}
