import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";
import {CartService} from "../cart/cart.service";

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {

  errorMessage: string;
  cart: any;
  products: any;

  constructor(private http: Http, private cartService: CartService) {
  }

  addToCart(product) {
    this.cartService.addToCart(product)
      .subscribe(
        cart => this.cart = cart,
        error => this.errorMessage = <any>error);
  }

  getProducts() {
    this.http.get("/api/products").subscribe(data => {
      this.products = data.json()
    });
  }

  ngOnInit(): void {
    this.getProducts();
  }

}
