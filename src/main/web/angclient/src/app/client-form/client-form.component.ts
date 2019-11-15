import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientService } from '../service/client-service.service';
import { Client } from '../model/client'

@Component({
  selector: 'app-client-form',
  templateUrl: './client-form.component.html',
  styleUrls: ['./client-form.component.css']
})
export class ClientFormComponent {
  client : Client;
  constructor(
    private route: ActivatedRoute,
      private router : Router,
        private clientService: ClientService) {
            this.client = new Client ();
  }
  ngOnInit(): void {
      this.getClient();
  }
  onSubmit(){
    this.clientService.save(this.client).subscribe(result => this.gotoClientList());
  }
  gotoClientList() {
    this.router.navigate(['/clients']);
  }
  getClient(): void {
     const id = +this.route.snapshot.paramMap.get('id');
     if (id) {
      this.clientService.getClient(id)
             .subscribe(client => this.client = client);
     } else {
       this.client = new Client ();
     }
  }
}
