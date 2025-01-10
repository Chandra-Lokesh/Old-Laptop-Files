import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { Observable } from 'rxjs';
import { Todo } from '../model/Todo';
import { TodoApiService } from '../todo-api.service';
import { TodoCardComponent } from '../todo-card/todo-card.component';

@Component({
  selector: 'app-todo-details',
  standalone: true,
  imports: [RouterModule, TodoCardComponent],
  templateUrl: './todo-details.component.html',
  styleUrl: './todo-details.component.css'
})
export class TodoDetailsComponent implements OnInit {

  constructor(private activatedRoute: ActivatedRoute, private todoApiService: TodoApiService){}

  todo?: Todo; 
  obseravable?: Observable<Todo>;

  id = 0;

  ngOnInit():void{
    this.activatedRoute.params.subscribe(
      param=>{
        this.id = param['id']
      }
    )
    console.log(this.id);
    this.obseravable = this.todoApiService.fetchTodoById(this.id);
    this.obseravable.subscribe(
      next => {
        this.todo = next;
        console.log(next);
      }
    );
  }
}
