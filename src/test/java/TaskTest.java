import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test
    public void shouldReturnId() {
        Task task = new Task(26);

        int expected = 26;
        int actual = task.getId();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesTest() {
        Task task = new Task(26);

        boolean expected = false;
        boolean actual = task.matches("f");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFoundTitle() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFoundTitle() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = false;
        boolean actual = simpleTask.matches("Гулять");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFoundTopicNoProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("приложения");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFoundProjectNoTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("НетоБанка");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFoundTopicNotProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = false;
        boolean actual = meeting.matches("вторник");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFoundOneFromArray() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Яйца");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldNotFoundInArray() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("Картошка");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnParametersMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        String expected = "Выкатка 3й версии приложения";
        String actual = meeting.getTopic();
        Assertions.assertEquals(expected, actual);

        String expected1 = "Приложение НетоБанка";
        String actual1 = meeting.getProject();
        Assertions.assertEquals(expected1, actual1);

        String expected2 = "Во вторник после обеда";
        String actual2 = meeting.getStart();
        Assertions.assertEquals(expected2, actual2);
    }

    @Test
    public void shouldReturnParametersEpic() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        String[] expected = { "Молоко", "Яйца", "Хлеб" };
        String[] actual = epic.getSubtasks();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldReturnParametersSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String expected = "Позвонить родителям";
        String actual = simpleTask.getTitle();
        Assertions.assertEquals(expected, actual);
    }
}
