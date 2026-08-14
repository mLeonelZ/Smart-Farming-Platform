# 🌾 Smart Farming Platform

## 📖 Sobre o Projeto
A **Smart Farming Platform** é uma solução web desenvolvida para a modernização da produção agropecuária através da Agricultura de Precisão. O sistema centraliza o gerenciamento de propriedades rurais de grande porte, permitindo o monitoramento contínuo das condições ambientais através de sensores IoT e estações meteorológicas. 

O objetivo principal é transformar dados brutos do campo (temperatura, umidade, pH, ventos) em inteligência de negócios, reduzindo o tempo de resposta a eventos climáticos e aumentando a eficiência operacional das lavouras.

## 🚀 Principais Funcionalidades

### 1. Gestão Cadastral
* **Fazendas e Talhões:** Mapeamento estrutural das propriedades e suas subdivisões.
* **Culturas:** Gerenciamento do tipo de plantio de cada área.
* **Dispositivos:** Cadastro de Sensores e Estações Meteorológicas vinculados aos talhões.

### 2. Monitoramento e Recepção de Dados (IoT)
* Recepção contínua de telemetria dos sensores (Temperatura, Umidade do ar/solo, Luminosidade, pH, Precipitação).
* **Simulador de Sensores:** Módulo automatizado (via rotinas agendadas) que injeta dados simulados no banco para homologação e demonstração do sistema.

### 3. Inteligência e Alertas
* Motor de regras de negócio para monitoramento de estresse hídrico, risco de geada e anomalias nas medições.
* Integração com APIs externas de previsão meteorológica.
* Sistema de recomendação inteligente para manejo de irrigação.

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 17+
* **Framework:** Spring Boot (Web, Data JPA, Validation, Scheduling)
* **Banco de Dados:** PostgreSQL / MySQL *(ajuste conforme sua escolha)*
* **Migrações de Banco:** Flyway / Liquibase *(opcional, mas recomendado)*
* **Testes:** JUnit 5 e Mockito
* **Documentação de API:** Swagger / SpringDoc OpenAPI

## 🏗️ Arquitetura e Modelagem
O projeto foi estruturado utilizando a arquitetura em camadas (Controllers, Services, Repositories, DTOs e Entities), garantindo separação de responsabilidades e facilitando a manutenção e a criação de testes automatizados.

## ⚙️ Como Executar o Projeto

### Pré-requisitos
* Java Development Kit (JDK) 21 ou superior instalado.
* Maven instalado.
* Banco de dados (PostgreSQL/MySQL) rodando localmente ou via Docker.

### Passos
1. Clone o repositório:
   ```bash
   git clone https://github.com/mLeonelZ/Smart-Farming-Platform
