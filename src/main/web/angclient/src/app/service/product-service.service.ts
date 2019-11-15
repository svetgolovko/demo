import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Product } from '../model/product';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private productsUrl: string;
  constructor(private http: HttpClient) {
      this.productsUrl = 'http://localhost:8080/products';
    }
  public findAll(): Observable<Product[]> {
        return this.http.get<Product[]>(this.productsUrl);
    }
  public save(product: Product) {
        return this.http.post<Product>(this.productsUrl, product);
  }
   public getProduct(id: number): Observable<Product> {
        return this.http.get<Product>(this.productsUrl+`/${id}`);
    }
}
