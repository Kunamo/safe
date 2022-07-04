Frontend: React (oder Angular)
Backend: Spring Boot mit H2 Datenbank

Das Frontend sollte Methoden aufrufen, welche woanders definiert sind (z.B "Servcies" in Angular).
HTTP-Methods sind dort definiert. Der HTTP-Client vom Frontend kommuniziert mit dem
Spring Rest Controller, und mit Spring JPA wird dann die H2 DB bearbeitet.

Das ist der CRUD-Pathway. Ein Bild zu dem: Grundkonzept.png

Dieser Aufbau eliminiert SQL-Injections, XSS Injections muss man recherchieren.
Die Verschlüsselung passiert im Backend mittels BCrypt.

Das Grundkonzept wird überarbeitet, da per 04. Juli, Änderungen getroffen wurden. (Mehr: Reflexion 04.07.22).
