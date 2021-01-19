![logo](https://github.com/edtonlemos/barbearia-xpto/blob/main/src/main/webapp/resources/img/logo_barbearia.png?raw=true)

> Projeto realizado como desafio técnico durante a fase de recrutamento na [ESIG  Software & Consultoria](https://www.esig.com.br/portal/). O desafio consistiu em desenvolver uma aplicação web em que fosse possível cadastrar, atualizar e remover um registro e persistir esses dados em um banco.
>
> O projeto escolhido foi um sistema para agendamento de horários em uma Barbearia. O usuário poderá manter os serviços oferecidos com seus respectivos valores no sistema e criar agendamentos contendo nome do cliente, horário, observações e uma lista de serviços a serem realizados. 

[TOC]

## Tecnologias Utilizadas

1. JavaServer Faces
2. Spring Boot
3. [JoinFaces](https://github.com/joinfaces/joinfaces-maven-jar-example)
4. Hibernate
5. PostgreSQL
6. Primefaces

## O que foi implementado

Os seguintes itens foram implementados neste desafio:

*A. Criar uma aplicação java web utilizando JavaServer Faces (JSF);*

*B. Utilizar persistência em um banco de dados (qualquer banco desejado);*

*C. Utilizar Hibernate e JPA;*

*D. Utilizar Spring Framework Boot 2.0*; e

*G. Utilizar Primefaces*.



## Funcionalidades do sistema

![agendamento](https://raw.githubusercontent.com/edtonlemos/barbearia-xpto/main/src/main/webapp/resources/img/tela_agendamento.png)

***Agendamento***: Nesta tela o usuário tem acesso a um formulário onde pode inserir um novo Agendamento, que é composto por *nome* do cliente, um *horário* (com data e hora), uma *observação* e por uma *lista de serviços*. Para inserir serviços no agendamento, o usuário deve selecionar um serviço da lista e clicar no botão "inserir serviço" para adicionar. Ao final, clicar no botão "salvar" para registrar o agendamento no banco. Automaticamente uma tabela contendo todos os agendamentos já registrados no banco de dados estarão sendo exibidos abaixo dos campos do formulário. Nessa tabela é possível clicar nos botões de "remover" e "editar". O botão "editar" irá ocupar todos os campos do formulário na página com  os dados do registro selecionado. Lá o usuário pode editar o que for necessário e clicar "salvar" para atualizar o registro ou "cancelar" para finalizar a edição sem salvar nenhuma alteração. Na seção 'Serviços' do formulário é possível também clicar em um link para criar ou editar os serviços oferecidos na lista.

------

![servicos](https://github.com/edtonlemos/barbearia-xpto/blob/main/src/main/webapp/resources/img/tela_servico.png?raw=true)

**Serviços:** Nesta tela, o usuário cadastra os tipos de serviços que são oferecidos na barbearia (Corte, Hidratação, Manicure, etc.) e os seus respectivos valores. Assim como no agendamento, o CRUD também funciona nos registros inseridos no banco. Porém, quando algum serviço já foi inserido em um agendamento ele não pode ser removido, apenas editado (limitação da forma como o banco foi modelado).

> *Nesta versão ainda não foi possível validar todos os dados que são gravados no banco. Muitas funcionalidades também foram abstraídas para apresentar apenas  os requisitos principais do desafio.*



## Instruções para execução 

O projeto está no **[GitHub](https://github.com/edtonlemos/barbearia-xpto)**.

> *O sistema é um projeto Maven, então pode ser executado de outras formas*

1. Baixe e extraia o arquivo .zip para seu workspace ou clone o repositório em sua máquina;

2. Utilizando a IDE Eclipse, importe um projeto existente do tipo **Maven**;

3. Aguarde o projeto ser montado na IDE;

4. Tenha o PostgreSQL instalado e crie um banco chamado "barbearia-xpto". Utilize as credenciais *user: postgres* e *senha:postgres* ou altere essas informações no arquivo "application.properties";

5. Procure o arquivo "BarbeariaXptoApplication.java" dentro da pasta Java Resources/src/main/java/br.com.edtonlemos.barbeariaxpto;

6. Execute o arquivo (Run as...) acima como *Java Application*;

7. Se não ocorrer nenhum erro, o Spring Boot irá subir a aplicação;

8. Abra um navegador de sua preferência e acesse o endereço:

   **http://localhost:8080/agendamento.xhtml**

   *ou http://localhost:8080/servico.xhtml*

   

