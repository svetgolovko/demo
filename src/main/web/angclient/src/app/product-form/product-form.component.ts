import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../service/product-service.service';
import { Product } from '../model/product'

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css']
})
export class ProductFormComponent {
  product : Product ;
  constructor(
    private route: ActivatedRoute,
       private router : Router,
           private productService: ProductService) {
              this.product = new Product ();
                }
  ngOnInit(): void {
        this.getProduct();
    }
  onSubmit(){
      this.productService.save(this.product).subscribe(result => this.gotoProductList());
  }
  gotoProductList() {
      this.router.navigate(['/products']);
  }
  getProduct(): void {
     const id = +this.route.snapshot.paramMap.get('id');
     if (id) {
      this.productService.getProduct(id)
             .subscribe(product => this.product = product);
     } else {
       this.product = new Product ();
     }
  }
}
