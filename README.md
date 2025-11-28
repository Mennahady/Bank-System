Spring Boot Bank System

A complete banking system built using Spring Boot, implementing real-world operations such as branch management, user onboarding, account handling, and secure money transactions.
This project demonstrates layered architecture, JPA relationships, DTO validation, and business logic implementation.

📌 Features
🏦 Branch Management

Create branches

Get branch details

View all users in a branch

Auto-assign users to nearest branch using address keywords

👤 User Management

Create users with email uniqueness validation

Automatic branch assignment

Link user to specific branch

Fetch user details

List all user accounts

💳 Account Management

Create accounts

Supports account types: SAVINGS, CHECKING

Unique account numbers

Get account details

Update balance (deposit/withdrawal)

💸 Transactions

Deposit

Withdrawal

Transfer (same-user only)

View account transactions

Search transactions by date range and type

Full rollback safety with @Transactional

🏛️ Architecture Overview

Follows Spring Boot layered architecture:

Controller → Service → Repository → Entity

Entities

Branch

User

Account

Transaction

Supporting Layers

DTOs (input/output data)

Repositories (JPA)

Services (business logic)

REST Controllers (API)

🔗 Entity Relationships
Branch     1 ───────∞   User
User       1 ───────∞   Account
Account    1 ───────∞   Transaction (source)
Account    1 ───────∞   Transaction (target)
