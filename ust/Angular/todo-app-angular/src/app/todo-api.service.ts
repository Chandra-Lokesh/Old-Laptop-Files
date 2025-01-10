import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, catchError, throwError } from 'rxjs';
import { Todo } from './model/Todo';
import { ErrorResponse } from './model/ErrorResponse';

@Injectable({
  providedIn: 'root'
})
export class TodoApiService {

  baseUrl = "http://localhost:8080/api/v1/"

  constructor(private todoClient: HttpClient, private router:Router, private errorResponse:ErrorResponse) { }

  createTodo(todo: Todo):Observable<Todo>{
    return this.todoClient.post<Todo>(this.baseUrl, todo);
  }

  fetchTodos():Observable<Array<Todo>>{
    console.log("fetching url...")
    
    return this.todoClient.get<Array<Todo>>(this.baseUrl)
    .pipe(
      catchError(
        err => {
          console.error(err)
          this.router.navigate(['/error'])
          return throwError(()=>err)
        }
      )
    );

  }

  fetchTodoById(id: number):Observable<Todo>{
    return this.todoClient.get<Todo>(`${this.baseUrl}${id}`);
  }

  deleteTodo(title:string):void{
    console.log(`deleting task with title: ${title}`);
    const url = `${this.baseUrl}${title}`;
    console.log(url);
    this.todoClient.delete<void>(`${this.baseUrl}${title}`)
    .subscribe(
      response => console.log(response),
      error => console.log(error)
    )
  }
}
