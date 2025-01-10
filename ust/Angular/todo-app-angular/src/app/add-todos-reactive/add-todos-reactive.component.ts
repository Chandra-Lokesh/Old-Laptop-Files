import { Component } from '@angular/core';
import { Validators, FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { TodoApiService } from '../todo-api.service';
import { TodoDataService } from '../todo-data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-todos-reactive',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './add-todos-reactive.component.html',
  styleUrl: './add-todos-reactive.component.css'
})

export class AddTodosReactiveComponent {
  constructor(private formBuilder: FormBuilder, private todoApiService: TodoApiService,
    private todoDataService: TodoDataService, private router: Router){}
  todoForm:FormGroup | any;
  ngOnInit():void{
    this.todoForm = this.formBuilder.group({
      title: ['', [Validators.required, Validators.pattern('[a-zA-Z0-9 ]{3,20}')]],
      status: ['', [Validators.required]],
      // dueDate: ['', [Validators.required]]
    })
  }

  // addTodos(todo:any){
  //   this.todoApiService.createTodo(todo)
  //   .subscribe(
  //     response => console.log(response),
  //     error => console.error(error)
  //   )
  // }

  addTodos(todo:any){
    this.todoApiService.createTodo(todo)
        .subscribe(
          response => {
            console.log(response)
            // this.todoDataService.fetchTodos()
            this.router.navigate(['/view'])

          },
          error => console.error(error)
          ) 
  
  }

}
