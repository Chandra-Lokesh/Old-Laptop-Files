import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { MainComponent } from './main/main.component';
import { AddTodosComponent } from './add-todos/add-todos.component';
import { ViewTodosComponent } from './view-todos/view-todos.component';
import { FooterComponent } from './footer/footer.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HeaderComponent, MainComponent, AddTodosComponent, ViewTodosComponent, FooterComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})

export class AppComponent implements OnInit{
  title = 'todo-app-angular';

  ngOnInit(): void {
    sessionStorage.setItem('isloggedin','yes')
  }

}
