import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {

  products: any;
  cart: any;

  constructor(private http: Http) {}

  addToCart(product) {
    this.http.post("/api/cart/add", {product: product, quantity: 1}).subscribe((data: any) => {
      this.cart = JSON.parse(data._body)
    })
  }

  getProducts() {
    this.http.get("/api/products").subscribe((data: any) => {
      this.products = JSON.parse(data._body)
    })
  }

  ngOnInit(): void {
    this.getProducts()
  }

}
