import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MarsRoverTest {

    private MarsRover marsRover;

    @Before
    public void setUp() throws Exception {
        marsRover = new MarsRover(0, 0, "N");
    }

    @Test
    public void should_return_00W_when_received_a_left_turn_command() throws Exception {
        MarsRover marsRover = this.marsRover;

        marsRover.execute("L");

        assertThat(marsRover.getPositionAndOrientation(), is("0 0 W"));
    }

    @Test
    public void should_return_00E_when_received_a_right_turn_command() throws Exception {

        marsRover.execute("R");

        assertThat(marsRover.getPositionAndOrientation(), is("0 0 E"));
    }

    @Test
    public void should_return_01N_when_received_a_move_command() throws Exception {
        marsRover.execute("M");

        assertThat(marsRover.getPositionAndOrientation(), is("0 1 N"));
    }

    @Test
    public void should_return_01W_when_received_a_move_command_given_another_initial_position_and_orientation() throws Exception {
        MarsRover marsRover = new MarsRover(1, 1, "W");

        marsRover.execute("M");

        assertThat(marsRover.getPositionAndOrientation(), is("0 1 W"));
    }

    @Test
    public void should_return_10N_when_received_multiple_commands() throws Exception {
        marsRover.execute("RML");

        assertThat(marsRover.getPositionAndOrientation(), is("1 0 N"));
    }

    @Test
    public void should_return_10S_when_received_another_multiple_commands() throws Exception {
        marsRover.execute("RMLRR");

        assertThat(marsRover.getPositionAndOrientation(), is("1 0 S"));
    }

    @Test
    public void should_return_OOW_when_received_B_command() throws Exception {
        MarsRover marsRover = new MarsRover(1, 0, "E");

        marsRover.execute("B");

        assertThat(marsRover.getPositionAndOrientation(), is("0 0 E"));

    }

    @Test
    public void should_return_OOS_when_received_M_command_given_marsRover_with_border_position() throws Exception {
        MarsRover marsRover = new MarsRover(0, 0, "N");

        marsRover.execute("LMLM");

        assertThat(marsRover.getPositionAndOrientation(), is("0 0 S"));

    }

    @Test
    public void should_return_55S_when_received_MRMR_given_another_initial_position_and_orientation() {
        MarsRover marsRover = new MarsRover(5, 5, "N");

        marsRover.execute("MRMR");

        assertThat(marsRover.getPositionAndOrientation(), is("5 5 S"));
    }
}

