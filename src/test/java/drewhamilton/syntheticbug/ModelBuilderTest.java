package drewhamilton.syntheticbug;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ModelBuilderTest {

    @Test
    public void useBuilder_setsExpectedValues() {
        Model model = new Model.Builder()
                .setTitle("Title")
                .setDescription("Description")
                .build();

        assertEquals("Title", model.getTitle());
        assertEquals("Description", model.getDescription());
    }
}
