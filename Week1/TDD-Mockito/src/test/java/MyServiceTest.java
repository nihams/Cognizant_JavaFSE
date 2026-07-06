import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    private ExternalApi mockApi;
    private MyService service;

    @BeforeEach
    public void setUp() {
        mockApi = Mockito.mock(ExternalApi.class);
        service = new MyService(mockApi);
    }

    // EXERCISE 1: Mocking and Stubbing
    @Test
    public void testExternalApi() {
        when(mockApi.getData()).thenReturn("Mock Data");
        String result = service.fetchData();

        assertEquals("Mock Data", result,
                "fetchData() should return the stubbed value from mockApi");
        System.out.println("testExternalApi passed: result = " + result);
    }

    @Test
    public void testGetUserData() {
        when(mockApi.getUserData(1)).thenReturn("User: Rajesh Kumar");
        String result = service.fetchUserData(1);

        assertEquals("User: Rajesh Kumar", result,
                "fetchUserData(1) should return stubbed user data");
        System.out.println("testGetUserData passed: result = " + result);
    }

    // EXERCISE 2: Verifying Interaction
    @Test
    public void testVerifyInteraction() {
        when(mockApi.getData()).thenReturn("Mock Data");
        service.fetchData();

        verify(mockApi).getData();
        System.out.println("testVerifyInteraction passed: getData() was called");
    }

    @Test
    public void testVerifyInteractionWithArgument() {
        when(mockApi.getUserData(42)).thenReturn("User 42");
        service.fetchUserData(42);

        verify(mockApi).getUserData(42);
        System.out.println("testVerifyInteractionWithArgument passed: getUserData(42) was called");
    }
}