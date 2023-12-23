Project Title

Advanced Authentication and Data Sharing

Project Overview

As part of our project, we explored and implemented advanced authentication and data sharing techniques, specifically Verifiable Credentials, JWT (JSON Web Token), and Selective Disclosure JWT. We successfully integrated these tools into a web application developed using Angular for the frontend and Spring Boot for the backend. This README provides a detailed explanation of our project.

Project Features

Our web application centers around a login form that captures user details, including username, password, father's name, and age. Upon submitting this form, the backend processes the request, generating a Verifiable Credential and a JWT token.

What is JWT?

JWT (JSON Web Token) is a compact, URL-safe means of representing claims between two parties. In the context of our project, JWTs are used for secure communication between the frontend and backend.

JWT Algorithms Used
We implemented JWT in Spring Boot using various algorithms for signature verification and encryption. Common algorithms include HMAC (HS256), RSASSA-PKCS1-v1_5 (RS256), and ECDSA (ES256).

What is a Verifiable Credential?

A Verifiable Credential is a tamper-evident credential that enables secure data sharing. It is typically associated with a subject, issuer, and various claims.

Process of Generating Verifiable Credential in Spring Boot:
Submission of Form Data: The user submits the login form with details.
Backend Processing: The Spring Boot backend processes the form data.
Verifiable Credential Generation: Based on the processed data, the backend generates a Verifiable Credential.
JWT Token Generation: Simultaneously, a JWT token is created for secure communication.
Selective Disclosure JWT

As an extension of JWT, Selective Disclosure JWT allows users to share specific claims from their JWT token, enhancing privacy and security.

Example of Selective Disclosure JWT:
Consider a scenario where a user has a JWT token with claims for username, email, and role. With Selective Disclosure JWT, the user can selectively share only the username claim with a third party, keeping the other information confidential.

Tools Used:

Frontend
HTML: Used for structuring the web pages.
CSS: Used for styling the web pages.
Angular: A powerful frontend framework for building dynamic web applications.
Backend
Spring Boot: A Java-based framework for creating standalone, production-grade Spring-based applications.
Database
SQL: A relational database for storing and retrieving user data securely.
