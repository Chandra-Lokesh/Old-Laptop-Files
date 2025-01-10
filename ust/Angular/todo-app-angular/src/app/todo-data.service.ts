import { Injectable } from '@angular/core';
import { Todo } from './model/Todo';
import { TodoApiService } from './todo-api.service';

@Injectable({
  providedIn: 'root'
})
export class TodoDataService {

  constructor(private todoApiService: TodoApiService) { }

  todos:Array<Todo> = [];

  addTodo(todo:Todo){
    this.todos.push(todo);
  }

  deleteTodo(title:string){
    const index = this.todos.findIndex(t => t.title == title);
    if(index != -1)
      this.todos.splice(index,1);
  }

  fetchTodos(){
    this.todoApiService.fetchTodos().subscribe(
      response => this.todos=response
    )
  
    }
  
}
