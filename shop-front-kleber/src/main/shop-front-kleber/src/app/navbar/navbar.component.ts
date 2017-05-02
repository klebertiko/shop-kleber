import {Component, OnInit} from "@angular/core";
import {Http} from "@angular/http";

@Component({
  selector: 'navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  public totalQuantity: any;

  constructor(private http: Http) {}

  ngOnInit() {

  }

}
