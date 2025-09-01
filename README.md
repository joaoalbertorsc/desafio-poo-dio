# Desafio de POO da DIO

## Descrição

Este projeto é uma solução para um Desafio de Projeto de Programação Orientada a Objetos (POO). O objetivo é aplicar os quatro pilares da POO (Abstração, Encapsulamento, Herança e Polimorfismo) para modelar um sistema de bootcamp educacional.

A aplicação simula a estrutura de um bootcamp, onde desenvolvedores (Devs) podem se inscrever, consumir conteúdos (Cursos e Mentorias) e progredir, acumulando experiência (XP) ao longo do processo.

## Conceitos de POO Aplicados

O projeto foi estruturado para demonstrar de forma prática os principais conceitos da Programação Orientada a Objetos:

-   **Abstração:** A classe `Conteudo` é abstrata e serve como um modelo para tudo o que pode ser oferecido em um bootcamp. Ela define os atributos e métodos comuns (`titulo`, `descricao`, `calcularXp()`) que Cursos e Mentorias devem possuir, abstraindo a complexidade de cada um.

-   **Encapsulamento:** Os atributos das classes são protegidos (geralmente `private`), e o acesso a eles é controlado por meio de métodos públicos (`getters` e `setters`). Isso garante a integridade dos dados dos objetos.

-   **Herança:** As classes `Curso` e `Mentoria` herdam da classe `Conteudo`. Elas reutilizam os atributos e métodos da classe mãe e adicionam seus próprios comportamentos e características específicas (`cargaHoraria` para `Curso` e `data` para `Mentoria`).

-   **Polimorfismo:** O método `calcularXp()` é sobrescrito nas classes filhas (`Curso` e `Mentoria`). Isso permite que cada tipo de conteúdo calcule a experiência de uma forma diferente, mesmo que a chamada ao método seja a mesma. Um `Bootcamp` ou um `Dev` pode tratar qualquer `Conteudo` de forma genérica, sem precisar saber se é um `Curso` ou uma `Mentoria`.

## Estrutura das Classes

O domínio da aplicação é composto pelas seguintes classes:

-   **`Conteudo`**: Classe mãe abstrata que representa qualquer conteúdo educacional do bootcamp.
    -   `String titulo`
    -   `String descricao`
    -   `double calcularXp()` (método abstrato)

-   **`Curso`**: Herda de `Conteudo`. Representa um curso com uma carga horária definida.
    -   `int cargaHoraria`
    -   O cálculo de XP é baseado na carga horária.

-   **`Mentoria`**: Herda de `Conteudo`. Representa uma sessão de mentoria agendada.
    -   `LocalDate data`
    -   O cálculo de XP é um valor bônus fixo.

-   **`Bootcamp`**: Representa o bootcamp em si. Contém um conjunto de conteúdos e os desenvolvedores inscritos.
    -   `String nome`
    -   `String descricao`
    -   `Set<Conteudo> conteudos`
    -   `Set<Dev> devsInscritos`

-   **`Dev`**: Representa um desenvolvedor participante.
    -   `String nome`
    -   `Set<Conteudo> conteudosInscritos`
    -   `Set<Conteudo> conteudosConcluidos`
    -   `inscreverBootcamp(Bootcamp bootcamp)`
    -   `progredir()`
    -   `calcularTotalXp()`

-   **`Main`**: Classe principal (ponto de entrada da aplicação) onde os objetos são instanciados e as interações são simuladas para demonstrar o funcionamento do modelo.

## Como Executar

Este é um projeto Java simples e não requer dependências externas ou um servidor de aplicação.

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/joaoalbertorsc/desafio-poo-dio
    ```

2.  **Abra em uma IDE:**
    Importe o projeto na sua IDE de preferência (IntelliJ IDEA, Eclipse, VS Code com extensões Java, etc.).

3.  **Execute a aplicação:**
    Localize a classe `Main.java` (geralmente em `src/main/java/br/com/desafio/Main.java`) e execute o método `main`. O resultado da simulação será impresso no console.
