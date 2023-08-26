import {Component, OnInit} from '@angular/core';
import {PostService} from "../../services/post.service";
import {Post} from "../../model/Post";

@Component({
  selector: 'app-comp3',
  templateUrl: './comp3.component.html',
  styleUrls: ['./comp3.component.css']
})
export class Comp3Component implements OnInit {
  public constructor(private service: PostService) {
  }

  ngOnInit(): void {
    this.service
      .consumirPosts()
      .subscribe({
        next: (res: Post[]) => {
          console.log("Sucesso")
          console.log(res)
        },
        error: (err: any) => {
          console.log("Erro")
          console.log(err)
        }
      })
  }

  public enviarDados(): void {

    let postagem: Post = new Post();
    postagem.body = "Teste de body";
    postagem.title = "Teste";
    postagem.userId = 1;

    this.service
      .adicionarPost(postagem)
      .subscribe({

        next: (res: Post) => {
          console.log("Post adicionado com sucesso")
          console.log(res)
        },

        error: (err: any) => {
          console.log("Erro ao adicionar post")
          console.log(err)

        }
      })

  }

}
