import { Component, OnInit } from '@angular/core';
import { User } from 'src/model/User';
import { BikeServiceService } from 'src/service/bike-service.service';

@Component({
  selector: 'app-all-users',
  templateUrl: './all-users.component.html',
  styleUrls: ['./all-users.component.css']
})
export class AllUsersComponent  implements  OnInit{

  users!: User[];

  constructor(private sev: BikeServiceService) { }

  ngOnInit(): void {
    this.sev.getAllUsers().subscribe(users => {
      this.users = users;
    });
  }
}
