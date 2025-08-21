# Changelog

All notable changes to this project will be documented in this file.  
This project follows [Semantic Versioning](https://semver.org/).

---

## [Unreleased]

## [X.Y.Z] - YYYY-MM-DD
### Added
- New features

### Changed
- Changes in existing functionality

### Fixed
- Bug fixes

### Security
- Security-related updates

---

## [0.1.0] - 2025-08-17
### Added
- JWT-based authentication with `JwtUtil` and `JwtAuthenticationFilter`
- `AuthController` for user login and registration
- Password hashing with `BCryptPasswordEncoder`
- Request validation using `spring-boot-starter-validation`
- DuplicateResourceException handling for duplicate usernames
- Example API endpoints in `README.md`

### Security
- Configured `SecurityConfig` with `AuthenticationManager` and `PasswordEncoder`
- Allowed `/auth/**` endpoints for public access while securing others
