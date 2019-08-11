package command;

import static org.junit.Assert.*;
import org.junit.Test;

public class SchedulerTest {

  @Test
  public void runsCommands() {
    
    Scheduler s = Scheduler.getInstance();
    class MyCommand extends Command {
        public int executeCount = 0;

        protected void execute() {
            executeCount += 1;
        }

        protected boolean isFinished() {
            return false;
        }
    }
    MyCommand c = new MyCommand();
    s.add(c);

    // first run adds the command
    s.run();
    // second executes it
    s.run();

    assertTrue(c.executeCount == 1);
  }
}