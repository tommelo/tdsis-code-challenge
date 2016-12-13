# tdsis-code-challenge
TDSiS - Code Challenge

Java 1.8+

1 - Uma loja tem um cesto cheio de meias, mas a loja só pode vender meias aos pares e do mesmo tamanho. Desenvolver um código/algoritmo que recebe a quantidade de meias e o tamanho delas e que devolva a quantidade máxima de pares que podem ser vendidos.

Formato de entrada:
- Primeira linha irá indicar quantas meias, n, existem na pilha;
- Segunda linha irá conter n tamanhos das meias separados por espaço, c0 c1 c2 ...;

Formato de saída:
- Imprimir o total de pares existentes na pilha.

Condições:
1 <= n <= 100
1 <= ci <= 100

Exemplo de entrada:
9

10 20 20 10 10 30 50 10 20

Exemplo de saída:
3


----- ----- ----- ----- ----- ----- 


2 - É necessário viajar da cidade C1 até Cn e não existe um caminho direto entre C1 e Cn.
Mas há cidades C2, C3, ..., Cn-1 tal que existem N1 rotas da Cidade C1 até Cn, e Ni rotas de Ci até Ci+1 sendo i=0 para n-1 e rotas de qualquer outra C1 até Cj sendo j != i+1.
Encontre o número total de rotas que podem ser tomadas saindo de C1 para chegar a Cn.

Obs.:
Deve-se de passar por todas as cidades Ci para i=1 até n-1 em ordem numerica para chegar a Cn;
Para cada Ci, Ci+1 há apenas Ni rotas que podem ser tomadas.

Formato de entrada:
- A primeira linha contém um inteiro T, significando o número de T de casos de testes que seguem.
- Cada caso de teste tem 2 linhas: A primeira linha contém um inteiro N (o número de cidades); o segundo contém N-1 inteiros (separados por espaço) onde o i-ésimo inteiro denota o número de rotas, Ni da cidade Ti até Ti+1.

Formato de Saída:
- Imprimir o número total de rotas de C1 até Cn

Condições:
1 <= T <= 1000
2 < N <= 100
1 <= Ni <= 1000

Exemplo de entrada:
1

4

2 2 2

Exemplo de saída:
8


----- ----- ----- ----- ----- ----- 


3 - Dado uma string s, encontrar se parte dela é um palíndromo.
Porém executando a seguinte operação antes:
Inverter os caracteres s[i,j](j incluso);

Após a operação verificar se s[k,l] é um palíndromo.

Formato de entrada:
- Primeira linha irá conter a string, s, a ser verificada;
- Segunda linha irá conter as, Q, verificações que deverão ser feitas;
- As Q linhas seguintes irão contér os índices (i, j ,k, l) a serem aplicados.

Formato de saída:
- Imprimir Q linhas contendo 'Yes' ou 'No' se o intervalo é um palíndromo.

Condições:
1 <= |s| <= 1000000
1 <= Q <= 333333
1 <= i <= j <= |s|
1 <= k <= l <= |s|
s contém apenas caracteres de 'a' a 'z'

Exemplo de entrada:
ababa

4

2 3 3 4

1 2 3 4

1 3 3 5

2 4 1 5

Exemplo de saída:
Yes

No

Yes

Yes
