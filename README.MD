# Internato Gestor

Sistema de gestão de Internato Médico para estudantes do curso de Medicina, desenvolvido em **Spring Boot**.

## Descrição

O sistema gerencia:

- Semestres letivos (P9 a P12)
- Alunos
- Preceptores
- Coordenadores
- Locais de prática (hospitais, clínicas)
- Especialidades
- Plantões e alocações de alunos

Funcionalidades implementadas:

- CRUD completo para alunos, preceptores, coordenadores, locais, especialidades e plantões
- Alocação de alunos em plantões com validações:
  - Plantão cheio
  - Sobreposição de horários
  - Duplicidade de alocação
- DTOs para separar entidades da API
- Validações de campos obrigatórios
- Banco H2 (para testes) e suporte a PostgreSQL
- Estrutura pronta para MapStruct ou mapeamento manual entre entidades e DTOs

## Tecnologias

- Java 17
- Spring Boot 3.3
- Spring Data JPA
- H2 / PostgreSQL
- Jakarta Validation
- Maven

## Estrutura do Projeto

