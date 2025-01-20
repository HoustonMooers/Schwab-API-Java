package com.hm.schwab.oauth;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Token implements Serializable {
	private static final long serialVersionUID = -1486157784268055615L;
	public static final long EXPIRATION_SLACK_TIME_IN_MS = 120 * 1000; //120 sec * 1000 ms / sec...2 mins
	public String token;
	public long expiration;

	public Token(String token, long expiration) {
		this.token = token;
		this.expiration = expiration;
	}

	public boolean isExpired() {
		//expiration is set about 2 minutes prior to when it actually expires
		return System.currentTimeMillis() > expiration;
	}

	public static Token load(File tokenfilelocation) {
		try (FileInputStream fileIn = new FileInputStream(tokenfilelocation);
				ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
			return (Token) objectIn.readObject();
		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error reading object: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.err.println("Class not found: " + e.getMessage());
		}
		return null;
	}

	public void store(File tokenfilelocation) {
		try (FileOutputStream fileOut = new FileOutputStream(tokenfilelocation);
				ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
			objectOut.writeObject(this);
		} catch (IOException e) {
			System.err.println("Error serializing object: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
