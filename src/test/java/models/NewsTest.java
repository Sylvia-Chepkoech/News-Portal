package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewsTest {

    public News newNews (){
        return new News("Rarua", "Raila chooses Karua as running mate", 4);
    }

    @Test
    public void getHeading_returnsHeadingCorrectly_String() {
        News news = newNews();
        assertEquals("Rarua", news.getHeading());
    }

    @Test
    public void getContext_returnsContextCorrectly_String() {
        News news = newNews();
        assertEquals("Raila chooses Karua as running mate", news.getContext());
    }@Test
    public void getDepartmentId_returnsDepartmentIdCorrectly_int() {
        News news = newNews();
        assertEquals(4, news.getDepartmentId());
    }
}