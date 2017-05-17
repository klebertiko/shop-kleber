import {Component, OnInit} from "@angular/core";
import {CartService} from "./cart.service";

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  errorMessage: string;
  cart: any;

  constructor(private cartService: CartService) {
  }

  getCurrent() {
    this.cartService.getCurrent()
      .subscribe(
        cart => this.cart = cart,
        error => this.errorMessage = <any>error);
  }

  ngOnInit(): void {
    this.getCurrent();
  }

}
