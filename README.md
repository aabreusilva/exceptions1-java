Java MVC

model - entities
      - enums
      - exception
      - services

Exercício: Fazer um programa para ler os dados de uma reserva
de hotel (número do quarto, data de entrada e data de saída) e
mostrar os dados da reserva, inclusive sua duração em dias. Em 
seguida, ler novas datas de entrada e saída, atualizar a reserva,
e mostrar novamente a reserva, conforme as seguintes regras:

- Alterações de reserva só podem ocorrer para datas futuras.
- A data de saída deve ser maior que a data de entrada.

3 tipos de soluções:
- Solução 1 (muito ruim): lógica de validação no programa inicial.
- Solução 2 (ruim): método retornando string.
- Solução 3 (boa): tratamento de exceções.

