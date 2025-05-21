public class ContactsManager {
    Contact[] myFriends;
    int friendsCount;
     // Création de compteur
    public ContactsManager() {
        this.friendsCount = 0;
        this.myFriends = new Contact[500];
    }
    // Ajoute un nouveau contact au tableau.
    public void addContact(Contact contact) {
        myFriends[friendsCount] = contact;
        friendsCount++;
    }
    //: Recherche un contact par nom et retourne l'objet Contact correspondant.
    public Contact searchContact(String searchName) {
        for (int i = 0; i < friendsCount; i++) {
            if (myFriends[i].name.equalsIgnoreCase(searchName)) {
                return myFriends[i];
            }
        }
        return null;
    }
}
