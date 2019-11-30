package helpers;

import manager.ApplicationManager;
import model.Note;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Optional;

public class NotesHelper extends HelperBase {
    public NotesHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public Optional<WebElement> addNote(Note note) throws InterruptedException {
        WebElement title = driverWait.until(ExpectedConditions.elementToBeClickable(By.id("edit_title")));
        title.sendKeys(note.getTitle());
        WebElement text = driverWait.until(ExpectedConditions.elementToBeClickable(By.id("edit_textarea")));
        text.sendKeys(note.getText());

        WebElement savedNotes;
        assertAndVerifyElement(By.id("savedNotes"));
        savedNotes = driverWait.until(ExpectedConditions.elementToBeClickable(By.id("savedNotes")));

        List<WebElement> noteListBefore = savedNotes.findElements(By.tagName("li"));

        WebElement saveNoteBtn = driverWait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveNote")));
        saveNoteBtn.click();

        Thread.sleep(1000);

        savedNotes = driverWait.until(ExpectedConditions.elementToBeClickable(By.id("savedNotes")));
        List<WebElement> noteListAfter = savedNotes.findElements(By.tagName("li"));
        Optional<WebElement> actual = Optional.empty();

        for (int i = 0; i < 5; i++) {
            try {
                actual = noteListAfter.stream().filter(item -> {
                            assertAndVerifyElement(By.id(item.getAttribute("id")));
                            return (item.getText().equals("a") && noteListAfter.size() == noteListBefore.size() + 1);
                        }
                ).findAny();
                break;
            } catch (org.openqa.selenium.StaleElementReferenceException ex) {
                Thread.sleep(1000);
            }
        }
        Assert.assertTrue(actual.isPresent());

        return actual;
    }

    public void editNote(Note oldNote, Note newNote) throws InterruptedException {
        WebElement savedNotes;
        savedNotes = driverWait.until(ExpectedConditions.elementToBeClickable(By.id("savedNotes")));
        List<WebElement> noteListBefore = savedNotes.findElements(By.tagName("li"));
        Optional<WebElement> element = Optional.empty();

        for (int i = 0; i < 5; i++) {
            try {
                element = noteListBefore.stream().filter(item -> {
                            assertAndVerifyElement(By.id(item.getAttribute("id")));
                            return (item.getText().equals(oldNote.getTitle()));
                        }
                ).findAny();
                break;
            } catch (org.openqa.selenium.StaleElementReferenceException ex) {
                Thread.sleep(1000);
            }
        }


        WebElement title = driverWait.until(ExpectedConditions.elementToBeClickable(By.id("edit_title")));
        title.sendKeys(newNote.getTitle());

        WebElement saveBtn = driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[1]/div/form/div[2]/div/span[1]/input")));
        saveBtn.click();

        for (int i = 0; i < 5; i++) {
            try {
                element = noteListBefore.stream().filter(item -> {
                            assertAndVerifyElement(By.id(item.getAttribute("id")));
                            return (item.getText().equals(newNote.getTitle()));
                        }
                ).findAny();
                break;
            } catch (org.openqa.selenium.StaleElementReferenceException ex) {
                Thread.sleep(1000);
            }
        }

        Assert.assertTrue(element.isPresent());
    }

}
