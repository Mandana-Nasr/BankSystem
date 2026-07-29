# 🏦 BankSystem

A Java-based banking application developed as part of my Java Developer studies at Nackademin.

The project focuses on **Object-Oriented Programming, design patterns, account management and transaction handling**.

## Features

- Create and manage different types of bank accounts
- Savings accounts with interest
- Transaction accounts
- Transaction handling
- Transaction fees
- Account management through a bank facade
- Factory-based creation of accounts and transactions

## Design Patterns

The project uses several design patterns to structure the application:

- **Facade** – provides a simplified interface for interacting with the banking system
- **Factory** – handles creation of accounts and transactions
- **Decorator** – adds additional behaviour such as transaction fees
- **Object-Oriented Design** – uses inheritance, abstraction and encapsulation

## Technologies

- **Java**
- **Object-Oriented Programming (OOP)**
- **Design Patterns**
- **Git & GitHub**

## 📁 Project Structure

- `Account` – base class for bank accounts
- `SavingsAccount` – represents a savings account
- `TransactionAccount` – represents a transaction account
- `Transaction` – represents a banking transaction
- `AccountFactory` – creates different account types
- `TransactionFactory` – creates transactions
- `AccountDecorator` – base decorator for account functionality
- `FeeAccountDecorator` – adds transaction fees
- `BankFacade` – provides a simplified interface to the banking system
- `BankRepository` – handles storage/retrieval of banking data
- `HuvudProgram` – application entry point

## Purpose

The purpose of this project was to practice **object-oriented programming and software design** by building a banking system using multiple design patterns.

The project helped me gain experience in:

- Designing object-oriented applications
- Applying design patterns
- Working with inheritance and abstraction
- Separating responsibilities between classes
- Managing transactions and account behaviour
- Structuring a Java application

