import {Component, OnInit} from "@angular/core";
import {Http, Response} from "@angular/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  welcome;

  constructor (private http: Http) {}


  ngOnInit(): void {
    this.welcome = this.http.get("/welcome").subscribe(welcome => this.welcome = welcome.json())
  }
}
