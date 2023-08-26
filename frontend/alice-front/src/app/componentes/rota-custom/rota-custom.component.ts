import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-rota-custom',
  templateUrl: './rota-custom.component.html',
  styleUrls: ['./rota-custom.component.css']
})
export class RotaCustomComponent implements OnInit {

  public idRecebido: string = "";
  public constructor(private activatedRoute: ActivatedRoute, private router : Router) {
  }
  public ngOnInit(): void {
    this.idRecebido = this.activatedRoute.snapshot.params['id']
    console.log("Id recebido: " + this.idRecebido)

  }

  public inicio() {
    this.router.navigate(['/'])
  }
}
