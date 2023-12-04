# PokeEco - Simulador de Ecossistema Pokémon

![Logo PokeEco](https://github.com/MiqueiasFBarros/SimpEco_-PokeEco-/blob/main/src/assetsREADME/logopoke.png)


- **Aluno: Miquéias Ferreira Barros**
- Matrícula: 01595460

O Projeto SimpEco nomeado de PokeEco é um simulador de ecossistema inspirado no universo Pokémon, duas espécies de Pokémon interagem entre si e com o ambiente. Este projeto é uma oportunidade de observar de forma prática os princípios da programação orientada a objetos em Java, incluindo conceitos como encapsulamento, herança, polimorfismo e associação. Através deste ambiente virtual, você pode observar como esses princípios fundamentais são aplicados na modelagem de um ecossistema onde duas espécies de Pokémon coexistem.

---

## Funcionalidades

- **Interação Pokémon:** Observe a interação entre diferentes Pokémon no ambiente.
- **Vida dos Pokémon:** Pokémon perdem vida quando colidem entre si.
- **Coleta de Frutas:** Pokémon podem coletar frutas para recuperar vida.
- **Controle Automático:** A quantidade de Pokémon e frutas no ambiente é controlada automaticamente.

---

## Demonstração

![Demonstração do SimpEco](https://github.com/MiqueiasFBarros/SimpEco_-PokeEco-/blob/main/src/assetsREADME/example.gif)

## Remoção do Personagem

A feature do personagem foi removida para uma otimização do código principal, ou seja dos animais.

### Controles 

- Não há necessidade de controlar pois é tudo automático :)

### Como Executar o Projeto

1. Certifique-se de ter o Java instalado no seu sistema.

**Obs. O JDK usado neste projeto foi o OpenKDL da Red Hat.**

2. Clone o repositório ou faça o download dos arquivos do projeto.

3. Abra o projeto em sua IDE Java favorita.

4. Execute a classe `SimpEcoMain.java` para iniciar a simulação. 
4.1. `SimpEcoMain.java` se localiza na pasta `src\pokeeco\floresta\SimpEcoMain.java`

   
**Vamos abordar cada conceito em relação ao código fornecido:**

- 1. Encapsulamento:
O encapsulamento é uma prática de programação que consiste em esconder detalhes internos de uma classe e permitir acesso controlado a seus membros. No código:

A classe Animal encapsula os atributos (x, y, vida, vidaMaxima, imagem) e fornece métodos públicos para acessá-los.
Exemplo:
`public int getX() {
    return x;
}`
- 2. Herança:
A herança permite que uma classe herde atributos e métodos de outra classe. No código:

A classe Animal e Circulo implementam a interface EntidadeEcossistema.
Exemplo:
`public class Animal implements EntidadeEcossistema { /* ... */ }`
- 3. Polimorfismo:
Polimorfismo permite que objetos de diferentes classes sejam tratados como objetos da mesma classe por meio de interfaces ou herança. Exemplo:

O método intersects é polimórfico, sendo implementado de maneira diferente em Animal e Circulo.
Exemplo:
`public boolean intersects(EntidadeEcossistema outraEntidade) { /* ... */ }`
- 4. Associação:
Associação representa a relação entre diferentes classes.

SimpEco possui uma relação de composição com CirculoManager e AnimalManager.
AnimalManager usa CirculoManager para verificar colisões entre animais e pontos azuis.
- 5. Métodos e Comportamentos:
Métodos são funções dentro de uma classe que definem o comportamento dessa classe. Exemplos:

moveAleatoriamente() em Animal: Move o animal aleatoriamente no ecossistema.
checkCollisions() em CirculoManager: Verifica colisões entre círculos e outras entidades.
- 6. Construtores e Instanciação:
Construtores são métodos especiais para inicializar objetos de uma classe. Exemplos:

O construtor de Animal recebe parâmetros para inicializar os atributos da instância.
Exemplo:
`public Animal(int x, int y, int vidaMaxima, String imagemPath) { /* ... */ }`
- 7. Gerenciamento do Ecossistema:
O gerenciamento do ecossistema é realizado por SimpEco, AnimalManager, CirculoManager, Animal, e Circulo. Exemplos:

SimpEco controla a interface gráfica e coordena a lógica geral da simulação.
AnimalManager gerencia a lista de animais, movimentos, colisões e saúde dos animais.
CirculoManager gerencia a lista de pontos azuis, adições, desenhos e colisões.
- 8. Gerenciamento do Projeto:
O código está estruturado em múltiplos arquivos, seguindo uma abordagem modular.
O uso de pacotes `(br.nassau.pokeeco)` ajuda na organização do código.
O projeto utiliza a biblioteca Swing para criar a interface gráfica.
Esses conceitos são fundamentais para compreender a estrutura e o funcionamento do código do simulador de ecossistema. Eles contribuem para a clareza, manutenibilidade e extensibilidade do código.
