-- PLSQL Exercise 3: Stored Procedures

-- TABLE SETUP
CREATE TABLE SavingsAccounts (
    AccountID    NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(100),
    Balance      NUMBER(10,2)
);

CREATE TABLE Employees (
    EmployeeID   NUMBER PRIMARY KEY,
    EmployeeName VARCHAR2(100),
    Department   VARCHAR2(50),
    Salary       NUMBER(10,2)
);

CREATE TABLE Accounts (
    AccountID    NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(100),
    Balance      NUMBER(10,2)
);

INSERT INTO SavingsAccounts VALUES (1, 'Rajesh Kumar', 50000.00);
INSERT INTO SavingsAccounts VALUES (2, 'Priya Sharma', 30000.00);
INSERT INTO SavingsAccounts VALUES (3, 'Anil Mehta',   75000.00);

INSERT INTO Employees VALUES (1, 'Amit Shah',   'IT',      60000.00);
INSERT INTO Employees VALUES (2, 'Neha Gupta',  'IT',      55000.00);
INSERT INTO Employees VALUES (3, 'Ravi Verma',  'HR',      45000.00);
INSERT INTO Employees VALUES (4, 'Sonia Mehta', 'HR',      48000.00);
INSERT INTO Employees VALUES (5, 'Karan Singh', 'Finance', 70000.00);

INSERT INTO Accounts VALUES (1, 'Rajesh Kumar', 20000.00);
INSERT INTO Accounts VALUES (2, 'Priya Sharma', 5000.00);

COMMIT;

-- SCENARIO 1: Process Monthly Interest

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    FOR account IN (SELECT * FROM SavingsAccounts) LOOP
        UPDATE SavingsAccounts
        SET Balance = Balance + (Balance * 0.01)
        WHERE AccountID = account.AccountID;

        DBMS_OUTPUT.PUT_LINE('Interest applied for: ' || account.CustomerName || ' | Old Balance: $' || account.Balance || ' | New Balance: $' || ROUND(account.Balance * 1.01, 2));
    END LOOP;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest processing complete.');
END;
/

EXEC ProcessMonthlyInterest;

-- SCENARIO 2: Update Employee Bonus

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department   IN VARCHAR2,
    p_bonusPercent IN NUMBER
) AS
BEGIN
    FOR emp IN (SELECT * FROM Employees WHERE Department = p_department) LOOP
        UPDATE Employees
        SET Salary = Salary + (Salary * p_bonusPercent / 100)
        WHERE EmployeeID = emp.EmployeeID;

        DBMS_OUTPUT.PUT_LINE('Bonus applied for: ' || emp.EmployeeName || ' | Old Salary: $' || emp.Salary || ' | New Salary: $' || ROUND(emp.Salary * (1 + p_bonusPercent/100), 2));
    END LOOP;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Bonus update complete for department: ' || p_department);
END;
/

EXEC UpdateEmployeeBonus('IT', 10);

-- SCENARIO 3: Transfer Funds

CREATE OR REPLACE PROCEDURE TransferFunds(
    p_fromAccount IN NUMBER,
    p_toAccount   IN NUMBER,
    p_amount      IN NUMBER
) AS
    v_sourceBalance NUMBER;
BEGIN
    SELECT Balance INTO v_sourceBalance
    FROM Accounts
    WHERE AccountID = p_fromAccount;

    IF v_sourceBalance < p_amount THEN
        DBMS_OUTPUT.PUT_LINE('Transfer failed! Insufficient balance.' || ' Available: $' || v_sourceBalance || ' | Requested: $' || p_amount);
    ELSE
        UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_fromAccount;
        UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_toAccount;
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Transfer successful! $' || p_amount ||' transferred from Account ' || p_fromAccount || ' to Account ' || p_toAccount);
    END IF;
END;
/

EXEC TransferFunds(1, 2, 5000);
EXEC TransferFunds(2, 1, 20000);