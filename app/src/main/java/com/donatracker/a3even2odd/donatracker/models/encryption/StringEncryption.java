package com.donatracker.a3even2odd.donatracker.models.encryption;

import android.util.Base64;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Random;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * Utilities for encrypting and decrypting text strings.
 *
 * @author Matthew Weissel
 * @version 1.0
 * @since 1.0
 */
public class StringEncryption {
    private static final Random RANDOM = new SecureRandom();
    private static final String SALT_ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "abcdefghijklmnopqrstuvwxyz";
    private static final int HASH_ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;

    /**
     * Generates randomized salt value to be hashed with a passed String.
     *
     * @param length the length of the salt value to generate
     * @return a randomized salt value of the specified length consisting of characters contained in the
     *         SALT_ALPHABET String.
     */
    public static String generateSalt(int length) {

        StringBuilder returnValue = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            returnValue.append(SALT_ALPHABET.charAt(RANDOM.nextInt(SALT_ALPHABET.length())));
        }
        return new String(returnValue);
    }

    /**
     * Runs passed text through a hash function (PBKDF2, with Hmac + SHA1 as the pseudo-random function)
     * and returns an array of byte containing an encrypted version of the passed text
     *
     * @param text an array of characters to be hashed
     * @param salt an array containing a generated salt value to be included in the hashing of the
     *             passed text
     * @return a byte array containing the hashed version of the passed text
     */
    public static byte[] hash(char[] text, byte[] salt) {

        PBEKeySpec spec = new PBEKeySpec(text, salt, HASH_ITERATIONS, KEY_LENGTH);

        Arrays.fill(text, Character.MIN_VALUE); //dispose of unsecured information

        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
        } finally {
            spec.clearPassword();
        }
    }

    /**
     * Encrypts a passed text string by hashing it along with a randomized salt value of a specified
     * length
     *
     * @param text the text to encrypt
     * @param salt the salt value to hash with the passed text string
     * @return an encrypted version of the passed String
     */
    public static String secure(String text, String salt) {

        byte[] secureStringBytes = hash(text.toCharArray(), salt.getBytes());

        return Base64.encodeToString(secureStringBytes, Base64.DEFAULT);
    }

    /**
     * Checks an unencrypted passed text string against an encrypted text string to determine if
     * the two Strings are equal by hashing the unencrypted String.
     *
     * @param providedText the unencrypted text to hash
     * @param securedText the encrypted text
     * @param salt the salt value to hash with the provided text
     * @return true if the two hashes are the same.
     *         false otherwise.
     */
    public static boolean verify(String providedText, String securedText, String salt) {
        return secure(providedText, salt).equalsIgnoreCase(securedText);
    }
}
