# VenturaHR
Este projeto foi criado para a disciplina de Projeto de Bloco do bloco de Desenvolvimento Java do Instituto Infnet. O PDF na raiz do projeto contém diagramas, regras de negócios, e requisitos do sistema.

## Tecnologias
- O projeto foi dividido em 4 micro-serviços feitos em Spring Boot. O banco utilizado foi o MySQL.
- O front-end foi feito através de Java EE com Tomcat Server 9.0.50.

## Como rodar
Depois de clonar o repositório, os seguintes passos são necessários:
1. Adicionar nas variáveis de ambiente de todos os micro-serviços as seguintes variáveis:
  - DATASOURCE_URL = Corresponde a URL e a porta do banco, além do nome do banco. Exemplo: localhost:3306/pb
  - DATASOURCE_USERNAME = Usuário de acesso ao banco. Exemplo: root
  - DATASOURCE_PASSWORD = Senha de aceso ao banco
2. Os micro-serviços devem ser rodados na seguinte ordem:
    1. VenturaHrUsuarioApplication
    2. VenturaHrCandidaturaApplication
    3. VenturaHrVagaApplication
    4. VenturaHrAutenticacaoApplication
3. Em seguida, rode o projeto web (VenturaHr_Web)
