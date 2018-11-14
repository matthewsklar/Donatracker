package com.donatracker.a3even2odd.donatracker;

import com.donatracker.a3even2odd.donatracker.models.category.Category;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit testers for Category methods.
 *
 * @author Matthew Sklar
 * @version 1.0
 * @since 1.0
 */
public class CategoryUnitTest {
    /**
     * Tester for add category.
     */
    @Test
    public void testAddCategory() {
        int origSize = Category.getCategories().size();

        int i;

        for (i = 0; i < origSize; i++) {
            boolean copy = false;

            for (Category category : Category.getCategories()) {
                if (Integer.toString(i).equals(category.toString())) {
                    copy = true;
                }
            }

            if (!copy) break;
        }

        String newCatName = Integer.toString(i);

        new Category(newCatName);

        // Test that category size increases
        assertEquals(origSize + 1, Category.getCategories().size());

        // Test that the correct category was added
        boolean newCatAdded = false;

        for (Category c : Category.getCategories()) {
            if (newCatName.equals(c.toString())) {
                newCatAdded = true;
            }
        }

        assertTrue(newCatAdded);

        // Test that category is not created
        new Category(newCatName);

        assertEquals(origSize + 1, Category.getCategories().size());

        // Test adding empty category
        new Category("");

        assertEquals(origSize + 1, Category.getCategories().size());
    }
}
