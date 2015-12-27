import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class MarsRoverTest {
    private MarsRover marsRover;
    private String commands;
    private String expectedStatus;

    public MarsRoverTest(MarsRover marsRover, String commands, String expectedStatus) {
        this.marsRover = marsRover;
        this.commands = commands;
        this.expectedStatus = expectedStatus;
    }

    @Parameters(name = "{index}: expect ({2}) when {0} received ({1}) commands")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new MarsRover(0, 0, "N"), "L", "0 0 W"},
                {new MarsRover(0, 0, "N"), "R", "0 0 E"},
                {new MarsRover(0, 0, "N"), "M", "0 1 N"},
                {new MarsRover(1, 1, "W"), "M", "0 1 W"},
                {new MarsRover(0, 1, "N"), "B", "0 0 N"},
                {new MarsRover(0, 0, "N"), "RML", "1 0 N"},
                {new MarsRover(0, 0, "N"), "RMLRR", "1 0 S"},
                {new MarsRover(0, 0, "N"), "LMLM", "0 0 S"},
                {new MarsRover(5, 5, "N"), "MRMR", "5 5 S"}
        });
    }

    @Test
    public void should_return_status_when_marsRover_received_commands() throws Exception {

        marsRover.execute(commands);

        assertThat(marsRover.status(), is(expectedStatus));
    }
}

