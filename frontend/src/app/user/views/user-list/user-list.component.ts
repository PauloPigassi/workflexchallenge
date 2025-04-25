import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { User } from '../../interfaces/user.model';
import { UserService } from '../../services/user.service';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-user-list',
  standalone: true, 
  imports: [CommonModule,HttpClientModule],
  templateUrl: './user-list.component.html',
})
export class UserListComponent implements OnInit {
  users: User[] = [];

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    console.log('🚀 UserListComponent carregado');
    this.userService.getUsers().subscribe((data) => {
      this.users = data;
    });
  }
}
