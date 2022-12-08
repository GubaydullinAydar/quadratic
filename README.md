# quadratic

Spring Boot приложение. Java 11. Lombok. H2. Swagger.

Реализовано веб приложение для вычисления корней квадратного уравнения вида ax^2 + bx + c = 0

Описание процесса работы с программой.
Пользователь отправляет GET запрос на endpoint в формате JSON с полями: a, b, c - коэффициенты кв.уравнения.
Программа сохраняет значения коэффициентов и рассчитанных корней уравнения в базу данных.
Пользователю возвращаются значения корней уравнения в формате JSON с полями: x1, x2.
Если найти корни уравнения нельзя, то выводим пользователю ошибку. 
