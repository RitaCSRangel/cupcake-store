import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { Product } from './product-model';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  private apiServerUrl = 'http://localhost:8080/products';

  constructor(private http: HttpClient) { }

  public getAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.apiServerUrl}/all`);
  }
}
