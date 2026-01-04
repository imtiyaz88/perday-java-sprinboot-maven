# Upgrade to Spring Boot 3.5.0

This branch upgrades the project to Spring Boot 3.5.0 and applies dependency overrides to address security issues.

Changes included:
- Bump Spring Boot parent to `3.5.0`.
- Override `org.springframework:spring-web` to `6.2.8`.
- Override `org.apache.tomcat.embed:tomcat-embed-core` to `10.1.47`.
- Override `org.apache.commons:commons-lang3` to `3.18.0`.

Validation performed:
- `./mvnw -DskipTests package` builds successfully.
- Dependency CVE scan performed; major issues addressed.

Notes:
- No runtime regressions detected during build; please run integration tests and smoke test endpoints.
