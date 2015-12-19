import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MarsRoverTest {
    @Test
    public void should_return_00W_when_received_a_left_turn_command() throws Exception {
        MarsRover marsRover = new MarsRover("0 0 N");

        marsRover.execute("L");

        assertThat(marsRover.getPositionAndOrientation(), is("0 0 W"));
    }
}
