import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class TaskTest {
    // @Before
    // public void setUp() {
    //     DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/to_do_test", null , null);
    // }
    // @After
    // public void tearDown() {
    //     try(Connection con = DB.sql2o.open()) {
    //         String sql = "DELETE FROM tasks *;";
    //         con.createQuery(sql).executeUpdate();
    //     }

    @Test
  public void Task_instantiatesCorrectly_true() {
    Task myTask = new Task("Mow the lawn");
    assertEquals(true, myTask instanceof Task);
  }
  @Test
  public void Task_instantiatesWithDescription_String() {
      Task myTask = new Task("Mow the lawn");
      assertEquals("Mow the lawn", myTask.getDescription());
  }
    @Test
      public void
      isCompleted_isFalseAfterInstatiation_false() {
        Task myTask = new Task ("Mow the lawn");
        assertEquals(false, myTask.isCompleted());
    }
    @Test
        public void getCreatedAt_instantiatesWithCurrentTime_today() {
        Task myTask = new Task("Mow the lawn");
        assertEquals(LocalDateTime.now().getDayOfWeek(), myTask.getCreatedAt().getDayOfWeek());
}
    @Test
    public void all_returnsAllInstancesOfTask_true() {
        Task firstTask = new Task("Mow the lawn");
        Task secondTask = new Task("Buy groceries");
        assertEquals(true, Task.all().contains(firstTask));
        assertEquals(true , Task.all().contains(secondTask));
    }
    @Test
        public void clear_emptiesAllTasksFromArrayList_0() {
        Task myTask = new Task ("Mow the lawn");
        Task.clear();
        assertEquals(Task.all().size(),0);
    }
    @Test
    public void getId_tasksInstatiateWithAnID_1() {
        Task.clear();
        Task myTask = new Task("Mow the lawn");
        assertEquals(1, myTask.getId());
    }

}
