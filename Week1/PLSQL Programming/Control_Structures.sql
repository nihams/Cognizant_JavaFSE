-- PLSQL Exercise 1: Control Structures

-- TABLE SETUP
CREATE TABLE Customers (
    CustomerID   NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(100),
    Age          NUMBER,
    Balance      NUMBER(10,2),
    IsVIP        VARCHAR2(5) DEFAULT 'FALSE'
);

CREATE TABLE Loans (
    LoanID       NUMBER PRIMARY KEY,
    CustomerID   NUMBER,
    InterestRate NUMBER(5,2),
    DueDate      DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

INSERT INTO Customers VALUES (1, 'Rajesh Kumar', 65, 15000.00, 'FALSE');
INSERT INTO Customers VALUES (2, 'Priya Sharma', 45, 8000.00,  'FALSE');
INSERT INTO Customers VALUES (3, 'Anil Mehta',   70, 12000.00, 'FALSE');
INSERT INTO Customers VALUES (4, 'Sunita Verma', 30, 500.00,   'FALSE');
INSERT INTO Customers VALUES (5, 'Vikram Singh', 62, 20000.00, 'FALSE');

INSERT INTO Loans VALUES (1, 1, 8.50,  SYSDATE + 10);
INSERT INTO Loans VALUES (2, 2, 9.00,  SYSDATE + 45);
INSERT INTO Loans VALUES (3, 3, 7.75,  SYSDATE + 20);
INSERT INTO Loans VALUES (4, 4, 10.00, SYSDATE + 5);
INSERT INTO Loans VALUES (5, 5, 8.00,  SYSDATE + 25);

COMMIT;

-- SCENARIO 1: Age-based loan interest discount

BEGIN
    FOR customer IN (SELECT * FROM Customers) LOOP
        IF customer.Age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = customer.CustomerID;
            
            DBMS_OUTPUT.PUT_LINE('Discount applied for: ' || customer.CustomerName || ' (Age: ' || customer.Age || ')');
        ELSE
            DBMS_OUTPUT.PUT_LINE('No discount for: ' || customer.CustomerName || ' (Age: ' || customer.Age || ')');
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- SCENARIO 2: VIP status based on balance

BEGIN
    FOR customer IN (SELECT * FROM Customers) LOOP
        IF customer.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = customer.CustomerID;
            
            DBMS_OUTPUT.PUT_LINE('VIP status set for: ' || customer.CustomerName || ' (Balance: $' || customer.Balance || ')');
        ELSE
            DBMS_OUTPUT.PUT_LINE('Not VIP: ' || customer.CustomerName || ' (Balance: $' || customer.Balance || ')');
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- SCENARIO 3: Loan reminders due within 30 days

BEGIN
    FOR loan IN (
        SELECT l.LoanID, l.DueDate, c.CustomerName
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.DueDate <= SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || loan.CustomerName || ', your loan (ID: ' || loan.LoanID || ') is due on ' || TO_CHAR(loan.DueDate, 'DD-MON-YYYY') || '. Please make your payment.');
    END LOOP;
END;
/