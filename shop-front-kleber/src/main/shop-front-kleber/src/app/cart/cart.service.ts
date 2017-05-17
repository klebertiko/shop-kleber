import {Injectable} from "@angular/core";
import {Http, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";


@Injectable()
export class CartService {

  private currentCartEndpoint = "/api/cart/current";
  private addToCartEndpoint = "/api/cart/add";
  private removeFromCartEndpoint = "/api/cart/remove";
  private checkoutEndpoint = "/api/cart/remove";

  cart: any;

  constructor(private http: Http) {
  }

  getCurrent(): Observable<any> {
    return this.http.get(this.currentCartEndpoint)
      .map(data => this.cart = data.json())
      .catch(this.handleError);
  }

  addToCart(product): Observable<any> {
    return this.http.post(this.addToCartEndpoint, product)
      .map(data => this.cart = data.json())
      .catch(this.handleError);
  }

  removeFromCart(product): Observable<any> {
    return this.http.post(this.removeFromCartEndpoint, product)
      .map(data => this.cart = data.json())
      .catch(this.handleError);
  }

  checkout(cartItems): Observable<any> {
    return this.http.post(this.checkoutEndpoint, cartItems)
      .map(data => this.cart = data.json())
      .catch(this.handleError);
  }

  private handleError(error: Response | any) {
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    return Observable.throw(errMsg);
  }

}
