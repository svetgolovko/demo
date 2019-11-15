import { Component, OnInit } from '@angular/core';
import { Product } from '../model/product';
import { ProductService } from '../service/product-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products : Product [];
  constructor(private route: ActivatedRoute,
                 private router : Router,
                     private productService: ProductService) { }

  ngOnInit() {
   this.productService.findAll().subscribe(data => {
        this.products = data;
      });
  }
}
