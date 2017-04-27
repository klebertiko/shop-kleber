import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";

import {AppComponent} from "./app.component";
import {routing} from "./app.routing";
import {ShopComponent} from "./shop/shop.component";
import {NavbarComponent} from "./navbar/navbar.component";
import {CartComponent} from "./cart/cart.component";

@NgModule({
  declarations: [
    AppComponent,
    ShopComponent,
    NavbarComponent,
    CartComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
