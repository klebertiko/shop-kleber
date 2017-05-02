import {Component, OnInit} from "@angular/core";

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cart: any = [];
  totalPrice: number;
  totalQuantity: number;

  constructor() {}

  removeProduct(product) {

  }

  checkout(product) {
  }

  ngOnInit() {
    this.cart = [{id: 1, name: "Banana"}]
    this.totalPrice = 123
    this.totalQuantity = 123
  }
}
