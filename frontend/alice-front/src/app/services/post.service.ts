import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Post} from "../model/Post";

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http: HttpClient) { }

  public consumirPosts(): Observable<Post[]>{
    return this.http.get<Post[]>("https://jsonplaceholder.typicode.com/posts")
  }

  public adicionarPost(postagem: Post): Observable<Post>{
    return this.http.post<Post>("https://jsonplaceholder.typicode.com/posts", postagem)
  }
}
