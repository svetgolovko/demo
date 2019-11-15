import { Component, OnInit } from '@angular/core';
import { Client } from '../model/client';
import { ClientService } from '../service/client-service.service';
import  { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.css']
})
export class ClientListComponent implements OnInit {

  clients: Client[];

  constructor( private clientService: ClientService) {
      console.log('Hello ClientListComponent clientService');
  }
  ngOnInit() {
    this.clientService.findAll().subscribe(data => {
      this.clients = data;
    });
  }
}
