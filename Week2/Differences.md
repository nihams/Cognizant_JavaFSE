# Difference between JPA, Hibernate and Spring Data JPA

## Java Persistence API (JPA)

- JPA is a **specification** (JSR 338) — a set of rules defined by Java for how objects
  should be persisted, read, and managed against a relational database.
- It does **not** contain any concrete implementation. It's just interfaces and
  annotations (`@Entity`, `@Id`, `EntityManager`, etc.) that define a contract.
- Think of JPA as a rulebook — it doesn't do anything by itself.

## Hibernate

- Hibernate is an **ORM tool that implements the JPA specification**.
- It's one of several JPA providers (others include EclipseLink, OpenJPA), but by far
  the most widely used.
- Hibernate does the real work: converting Java objects into SQL, managing sessions,
  transactions, caching, and executing queries against the database.
- Using plain Hibernate means writing a fair amount of boilerplate: opening a
  `Session`, starting a `Transaction`, catching `HibernateException`, committing or
  rolling back, and closing the session manually for every operation.

## Spring Data JPA

- Spring Data JPA does **not** implement JPA itself — it sits **on top of** a JPA
  provider (Hibernate, in our case) as another layer of abstraction.
- Its whole purpose is to **eliminate the boilerplate** shown above. Instead of writing
  session/transaction management by hand, you define an interface extending
  `JpaRepository`, and Spring generates the implementation at runtime.
- It also manages transactions for you via `@Transactional`, so you don't manually
  open/commit/rollback sessions.

## Side-by-side: adding an entity

**Plain Hibernate** — manual session and transaction handling, explicit try/catch/finally:

```java
public Integer addEmployee(Employee employee) {
    Session session = factory.openSession();
    Transaction tx = null;
    Integer employeeID = null;
    try {
        tx = session.beginTransaction();
        employeeID = (Integer) session.save(employee);
        tx.commit();
    } catch (HibernateException e) {
        if (tx != null) tx.rollback();
        e.printStackTrace();
    } finally {
        session.close();
    }
    return employeeID;
}
```

**Spring Data JPA** — no session handling at all, just a repository call:

```java
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

@Autowired
private EmployeeRepository employeeRepository;

@Transactional
public void addEmployee(Employee employee) {
    employeeRepository.save(employee);
}
```
