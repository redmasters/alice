import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-comp2',
  templateUrl: './comp2.component.html',
  styleUrls: ['./comp2.component.css']
})
export class Comp2Component implements OnInit {
  public constructor(private activatedRoute: ActivatedRoute) {
    let p1: string;
    let p2: string;

    p1 = this.activatedRoute.snapshot.queryParams['p1']
    p2 = this.activatedRoute.snapshot.queryParams['p2']

    console.log("P1: " + p1 + " P2: " + p2)
  }
  ngOnInit(): void {
  }

}
