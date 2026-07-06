import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

//Exercise 1: Setting Up JUnit
//Exercise 4: AAA Pattern,Test Fixtures,Setup and Teardown
public class BankAccountTest {
    private BankAccount account;

    // Setup methods
    @BeforeEach
    public void setUp() {
        account = new BankAccount("Anusha Kumar", 10000.00);
        System.out.println("setUp: Fresh BankAccount created with balance 10000");
    }

    // Teardown methods
    @AfterEach
    public void tearDown() {
        account = null;
        System.out.println("tearDown: BankAccount set to null\n");
    }

    // Deposit Test
    @Test
    public void testDeposit() {
        // ARRANGE - set up test data
        double depositAmount = 5000.00;

        // ACT - perform the action
        account.deposit(depositAmount);

        // ASSERT - verify the result
        assertEquals(15000.00, account.getBalance(),
                "Balance should be 15000 after depositing 5000");
        System.out.println("testDeposit passed: balance is " + account.getBalance());
    }

    // Withdraw Test
    @Test
    public void testWithdraw() {
        // ARRANGE
        double withdrawAmount = 3000.00;

        // ACT
        account.withdraw(withdrawAmount);

        // ASSERT
        assertEquals(7000.00, account.getBalance(),
                "Balance should be 7000 after withdrawing 3000");
        System.out.println("testWithdraw passed: balance is " + account.getBalance());
    }

    // Test insufficient balance throws exception
    @Test
    public void testWithdrawInsufficientBalance() {
        // ARRANGE
        double withdrawAmount = 20000.00;

        // ACT + ASSERT
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(withdrawAmount);
        }, "Should throw exception when withdrawing more than balance");
        System.out.println("testWithdrawInsufficientBalance passed: exception thrown correctly");
    }

    // Test invalid deposit throws exception
    @Test
    public void testDepositNegativeAmount() {
        // ARRANGE
        double negativeAmount = -500.00;

        // ACT + ASSERT
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(negativeAmount);
        }, "Should throw exception for negative deposit");
        System.out.println("testDepositNegativeAmount passed: exception thrown correctly");
    }

    // Test account holder name
    @Test
    public void testAccountHolder() {
        // ARRANGE -done in setUp()

        // ACT
        String name = account.getAccountHolder();

        // ASSERT
        assertEquals("Anusha Kumar", name, "Account holder name should match");
        assertNotNull(name, "Account holder name should not be null");
        System.out.println("testAccountHolder passed: name is " + name);
    }
}