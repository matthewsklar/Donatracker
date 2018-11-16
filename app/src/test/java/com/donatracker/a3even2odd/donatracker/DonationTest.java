package com.donatracker.a3even2odd.donatracker;


import com.donatracker.a3even2odd.donatracker.models.donation.Donation;

import org.junit.Test;

import java.util.LinkedList;

import static com.donatracker.a3even2odd.donatracker.models.donation.Donation.load;
import static org.junit.Assert.*;

public class DonationTest {

    @Test
    public void loadTest() {

       LinkedList<Donation> donationNull = null;
       load(donationNull);
       assertTrue(Donation.getDonations().isEmpty());


       LinkedList<Donation> donationfull = new LinkedList<>();
       donationfull.add(new Donation());

       load(donationfull);
       assertEquals(Donation.getDonations().size(), 1);
    }
}


//        assertEquals – makes sure the two things compared are “equal”
//        assertFalse – makes sure the thing has a value of “false”
//        assertNotNull – makes sure the thing has a value
//        assertNotSame – makes sure two things are not the actual same thing
//        assertNull – makes sure the thing does not have a value
//        assertTrue – makes sure the thing has a value of “true”