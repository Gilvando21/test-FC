# language: pt
# encoding: utf-8

Funcionalidade: Validar credencias de login  senha inválidas
  @web
 Esquema do Cenário:  Validar credencias de login  senha inválidas
    Dado que o usuario acesse o site
    Quando digitar login e senha invalido
    Então  valido mensagem de erro "<mensagem>"

Exemplos:
    |mensagem|
    |  tentar novamente   |