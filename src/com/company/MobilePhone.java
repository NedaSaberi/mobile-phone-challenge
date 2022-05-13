package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {
    private ArrayList<Contact> contactsarray = new ArrayList<>();

    boolean quit = false;


    private Scanner scanner = new Scanner(System.in);

    public MobilePhone() {
        while (!quit) {
            System.out.println("Select the relevant option to \n 1- Print list of contacts\n 2- Add new contact\n 3- Update existing contact\n 4- Remove contact\n 5- Search contact\n 6- Quit");
            int option = scanner.nextInt();
            switch (option) {
                case 1: // print
                    printList(contactsarray);
                    break;
                case 2: //add
                    Contact newContact = getInfo();
                    add(newContact);
                    System.out.println("Contact " + newContact.getName() + " was added");
                    break;
                case 3: //update
                    Scanner updateScanner = new Scanner(System.in);
                    System.out.println("Enter the name of current contact to change: ");
                    String currentName = updateScanner.nextLine();
                    int index = findIndex(currentName);
                    if (index >= 0) {
                        System.out.println(contactsarray.get(index).getName() + "\t\t" + contactsarray.get(index).getMobileNumber() + "\n was found");
                        Contact updatedContact = getInfo();
                        update(index, updatedContact);
                    } else
                        System.out.println("Contact not found");
                    break;
                case 4: //remove
                    Scanner removeScanner = new Scanner(System.in);
                    System.out.println("Enter the name of contact to remove: ");
                    String name = removeScanner.nextLine();
                    int removeIndex = findIndex(name);
                    if (removeIndex >= 0) {
                        remove(removeIndex);
                        System.out.println("Contact " + name + " was removed");
                    }
                    else
                        System.out.println("Contact not found");
                    break;
                case 5: //search
                    Scanner searchScanner = new Scanner(System.in);
                    System.out.println("Enter the name to search: ");
                    String searchedName = searchScanner.nextLine();
                    int searchIndex = findIndex(searchedName);
                    if (searchIndex >= 0) {
                        System.out.println("Founded Contact: ");
                        System.out.println(contactsarray.get(searchIndex).getName() + "\t\t" + contactsarray.get(searchIndex).getMobileNumber());
                    } else
                        System.out.println("Not exist");
                    break;
                case 6: //quit
                    quit();

            }
        }
    }


    public void printList(ArrayList<Contact> contactsarray) {
        System.out.println("Contacts\n---------- ");
        for (int i = 0; i < contactsarray.size(); i++) {
            System.out.println(contactsarray.get(i).getName() + "\t\t" + contactsarray.get(i).getMobileNumber());
        }
    }

    public void add(Contact newContact) {
        contactsarray.add(newContact);
    }

    public void update(int index, Contact newContact) {
        contactsarray.set(index, newContact);
    }

    public void remove(int removeIndex) {
        Contact removeContact = contactsarray.get(removeIndex);
        contactsarray.remove(removeContact);
    }

    private int findIndex(Contact searchContact) {
        return contactsarray.indexOf(searchContact);
    }

    private int findIndex(String contactName) {
        for (int i = 0; i < contactsarray.size(); i++) {
            Contact contact = contactsarray.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }


    public void quit() {
        quit = true;
    }

    private Contact getInfo() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter the name: ");
        String name = scanner1.nextLine();
        System.out.println("Enter the number: ");
        String number = scanner1.nextLine();
        Contact Contact = new Contact(name, number);
        return Contact;
    }

}
