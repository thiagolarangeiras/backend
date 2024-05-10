# ESTUDO DE CASO: uol.com.br

<a href="https://github.com/pauloDalponte" >Paulo Cesar Becker Dal Ponte</a><br>
<a href="https://github.com/jpdarabas" >João Pedro Darabas Cardoso</a><br>
<a href="https://github.com/thiagolarangeiras" >Thiago Larangeira de Souza</a><br>

## 1 MANIPULAR NOTÍCIAS 

### 1.1 CONTROLE DE COMENTÁRIOS 
Endpoints:
* Inserir novo comentário(post)
* Ler novo comentário(get)
* Modificar comentário(put)
* Excluir comentário(delete)

#### 1.1.1 Requisição: Inserir Comentário
	[POST]/noticias/{noticia-id}/comentarios
```json
{
 "usuario":"joao_silva",
 "texto": "Uma total calamidade!"
}
```

Status Code/Erros Esperados:
* '404 Not Found'/ Não há uma notícia com este id
* '429 Too Many Requests'/ Muitos comentários feitos pelo mesmo usuário.
* '400 Bad Request'/ Número de caracteres mínimos não atendidos(mínimo 3)
* '400 Bad Request'/ Número de caracteres máximos ultrapassados(máximo 300)
* '401 Unauthorized'/ Usuário não autenticado
* '201 Created'/ Criado comentário


#### 1.1.2 Requisição: Ler comentários
	[GET] /noticias/{noticia-id}/comentarios

Status Code/Erros Esperados:
* '404 Not Found'/ Notícia não existe
* '200 OK'/ Retorno dos comentários da notícia

#### 1.1.3 Requisição: Modificar comentário
	[PUT] /noticias/{noticia-id}/comentarios/{comentario-id}
```JSON
{
"texto": "A maior calamidade já vista!"
}
```

Status Code/Erros Esperados:
* '400 Bad Request'/ Se o novo comentário não for enviado
* '404 Not Found'/ Não há uma notícia com este id
* '401 Unauthorized'/ Se o usuário não estiver autenticado ou não for o dono do comentário
* '200 OK'/ Em sucesso

#### 1.1.4 Requisição: Excluir comentário
	[DELETE] /noticias/{noticia-id}/comentarios/{comentario-id}

Status Code/Erros Esperados:
* '404 Not Found'/ Não há uma notícia com este id
* '401 Unauthorized'/ Se o usuário não estiver autenticado ou não for o dono do comentário
* '204 No Content'/  Em sucesso

### 1.2 CONTROLE DE POSTAGEM DE NOTÍCIAS
Endpoints:
* Inserir nova notícia(post)
* Ler notícias(get)
* Modificar notícias(put)
* Excluir notícia(delete)

#### 1.2.1 Requisição: Inserir Notícia
	[POST] /noticias
```JSON
{
 "autor":"carlos_andrade",
 "titulo": "Porque usamos isso?"
"texto":"É um fato estabelecido há muito tempo que um leitor se distraiu com o          conteúdo legível de uma página ao observar seu layout. O objetivo de usar Lorem Ipsum é que ele tem uma distribuição de letras mais ou menos normal, em vez de usar 'Conteúdo aqui, conteúdo aqui', fazendo com que pareça um inglês legível. "
}
```
Status Code/Erros Esperados:
* '400 Bad Request/ Faltando algum nos campos necessários ou formato errado
* '401 Unauthorized'/ Usuário não autenticado
* '403 Forbidden'/ Sem permissão
* '500 Internal Server Error'/ Erro no servidor
* '200 OK'/ Postada com sucesso

#### 1.2.2 Requisição: Ler Notícia
	[GET] /noticias

Status Code/Erros Esperados:
* '404 Not Found/ Não existe a notícia
* '500 Error Internal'/ Erro interno no servidor
* '200 OK'/ Retorno concluído

#### 1.2.3 Requisição: Alterar Notícia
	[PUT] /noticias/{noticia-id}
```JSON
{
"autor":"carlos_andrade",
 "titulo": "Porque usamos isso?"
"texto":"Apenas foi trocado o texto pelo erro anterior! "
}
```

Status Code/Erros Esperados:
* '400 Bad Request/ Faltando algum nos campos necessários ou formato errado
* '401 Unauthorized'/ Usuário não autenticado e não for autor
* '403 Forbidden'/ Sem permissão 
* '404 Not Found'/ Se não for encontrada a notícia
* '500 Internal Server Error'/ Erro no servidor
* '200 OK'/ Atualizada com sucesso

#### 1.2.4 Requisição: Deletar Notícia
	[DELETE] /noticias/{noticia-id}

Status Code/Erros Esperados:
* '401 Unauthorized'/ Usuário não autenticado e não for autor
* '403 Forbidden'/ Sem permissão 
* '404 Not Found'/ Se não for encontrada a notícia
* '500 Internal Server Error'/ Erro no servidor
* '200'OK/ Deletada com sucesso
