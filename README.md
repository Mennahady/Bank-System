Spring Boot Bank System

A complete banking system built with Spring Boot, implementing real-world banking operations such as branch management, user onboarding, account handling, and financial transactions with robust business rules and data integrity.

This project demonstrates deep understanding of:

Spring Boot layered architecture

JPA relationships & cascading

Business logic implementation

Transactional consistency

DTO validation

REST API design

Exception handling

⭐ Features
🏦 Branch Management

Create bank branches

Fetch branch details

View all users in a branch

Auto-assign users to nearest branch based on address

👤 User Management

Create users with email uniqueness validation

Auto-assign branch using address keywords

Link user to a different branch

View user details

Fetch user's bank accounts

💰 Account Management

Create accounts for users

Account types: SAVINGS, CHECKING

Unique account numbers

Fetch account details

Update account balance

🔁 Transactions

Deposit

Withdrawal

Transfer (same-user only)

View account transaction history

Filter transactions by date range and type

Full rollback using @Transactional

📐 System Architecture

The project follows a strict layered architecture:

Controller → Service → Repository → Entity

Entities

Branch

User

Account

Transaction

DTOs

BranchDto

UserDto

AccountDto

TransactionDto

Repositories

BranchRepository

UserRepository

AccountRepository

TransactionRepository

Services

BranchService

UserService

AccountService

TransactionService


Branch     1 ────────∞   User
User       1 ────────∞   Account
Account    1 ────────∞   Transaction (source)
Account    1 ────────∞   Transaction (target)
