import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-comp1',
  templateUrl: './comp1.component.html',
  styleUrls: ['./comp1.component.css']
})
export class Comp1Component implements OnInit {
  public mensagem: string;
  public valor: number;
  public linkFoto: string;
  public textoDoForm: string = "";
  public senha: string = "";
  public clicado: boolean;
  public constructor() {
    console.log("Construtor chamado")
    this.mensagem = "Mensagem do componente 1"
    this.valor = 0;
    this.linkFoto = "../../assets/img.png"
    this.clicado = false;
  }
  ngOnInit(): void {
    console.log("ngOnInit chamado")
  }

  public mudarValor(): void {
    this.valor++;
    // console.log("Valor mudado para " + this.valor)
  }

  public enviarDados() {
    console.log("Texto do form: " + this.textoDoForm + " Senha: " + this.senha + " Clicado: " + this.clicado)
  }
}
