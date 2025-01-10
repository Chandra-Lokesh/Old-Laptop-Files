import { Component, OnInit } from '@angular/core';
import { TodoDataService } from '../todo-data.service';
import { CommonModule } from '@angular/common';
import { TodoCardComponent } from '../todo-card/todo-card.component';
import { Todo } from '../model/Todo';
import { TodoApiService } from '../todo-api.service';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-view-todos',
  standalone: true,
  imports: [CommonModule, TodoCardComponent, RouterModule],
  templateUrl: './view-todos.component.html',
  styleUrl: './view-todos.component.css'
})
export class ViewTodosComponent implements OnInit{

  todos:Array<Todo>=[]

  constructor(public todoDataService:TodoDataService,private todoApiService:TodoApiService){};

  ngOnInit():void{
    // this.updateArray();
    // this.todoApiService.fetchTodos()
    // .subscribe(response=>this.todoDataService.todos=response)
    this.todoDataService.fetchTodos();
  }

  // updateArray():void{
  //   this.todoApiService.fetchTodos()
  //   .subscribe(response => this.todos=response)
  // }

}
