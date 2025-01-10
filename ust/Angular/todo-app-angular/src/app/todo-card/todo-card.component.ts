import { Component, Input } from '@angular/core';
import { Todo } from '../model/Todo';
// import { TodoDataService } from '../todo-data.service';
import { CommonModule } from '@angular/common';
import { TodoApiService } from '../todo-api.service';
import { RouterModule } from '@angular/router';


@Component({
  selector: 'app-todo-card',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './todo-card.component.html',
  styleUrl: './todo-card.component.css'
})
export class TodoCardComponent {

  constructor(public todoApiService: TodoApiService){}

  @Input('todo')
  todo?:Todo;

  delete():void{
    if(this.todo?.title)
      this.todoApiService.deleteTodo(this.todo.title);
  }
}
