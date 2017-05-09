import {Component, OnInit} from "@angular/core";
import {CartService} from "../cart/cart.service";

@Component({
  selector: 'navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  errorMessage: string;
  cart: any;

  constructor(private cartService: CartService) {
  }

  getOrCreateCurrent() {
    this.cartService.getOrCreateCurrent()
      .subscribe(
        cart => this.cart = cart,
        error => this.errorMessage = <any>error);
  }

  ngOnInit() {
    this.getOrCreateCurrent();
  }

}
