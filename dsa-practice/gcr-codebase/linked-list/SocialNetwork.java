class FriendNode {
    int friendId;
    FriendNode next;

    FriendNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}

class UserNode {
    int userId;
    String name;
    int age;
    FriendNode friendsHead; // head of this user's friend list
    UserNode next;          // next user in main list

    UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendsHead = null;
        this.next = null;
    }
}
class SocialNetwork {

    private UserNode head; // head of users list

    // add a new user to the list (at beginning for simplicity)
    public void addUser(int userId, String name, int age) {
        if (findUserById(userId) != null) {
            System.out.println("User with ID " + userId + " already exists");
            return;
        }
        UserNode newUser = new UserNode(userId, name, age);
        newUser.next = head;
        head = newUser;
    }

    // search user by ID
    public UserNode findUserById(int userId) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }

    // search user by Name (first match)
    public UserNode findUserByName(String name) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) return temp;
            temp = temp.next;
        }
        return null;
    }

    // helper: check if friendId already in user's friend list
    private boolean isFriend(FriendNode friendsHead, int friendId) {
        FriendNode curr = friendsHead;
        while (curr != null) {
            if (curr.friendId == friendId) return true;
            curr = curr.next;
        }
        return false;
    }

    // helper: add a friendId to a single user's friend list (insert at head)
    private FriendNode addFriendToList(FriendNode friendsHead, int friendId) {
        if (isFriend(friendsHead, friendId)) return friendsHead;
        FriendNode node = new FriendNode(friendId);
        node.next = friendsHead;
        return node;
    }

    // helper: remove friendId from a single user's friend list
    private FriendNode removeFriendFromList(FriendNode friendsHead, int friendId) {
        FriendNode curr = friendsHead;
        FriendNode prev = null;
        while (curr != null && curr.friendId != friendId) {
            prev = curr;
            curr = curr.next;
        }
        if (curr == null) return friendsHead; // not found
        if (prev == null) {          // deleting head
            friendsHead = curr.next;
        } else {
            prev.next = curr.next;
        }
        return friendsHead;
    }

    // 1. Add a friend connection between two users (undirected)
    public void addFriendConnection(int id1, int id2) {
        if (id1 == id2) {
            System.out.println("Cannot friend self");
            return;
        }
        UserNode u1 = findUserById(id1);
        UserNode u2 = findUserById(id2);

        if (u1 == null || u2 == null) {
            System.out.println("One or both users not found");
            return;
        }

        u1.friendsHead = addFriendToList(u1.friendsHead, id2);
        u2.friendsHead = addFriendToList(u2.friendsHead, id1);
    }

    // 2. Remove a friend connection
    public void removeFriendConnection(int id1, int id2) {
        UserNode u1 = findUserById(id1);
        UserNode u2 = findUserById(id2);

        if (u1 == null || u2 == null) {
            System.out.println("One or both users not found");
            return;
        }

        u1.friendsHead = removeFriendFromList(u1.friendsHead, id2);
        u2.friendsHead = removeFriendFromList(u2.friendsHead, id1);
    }

    // 3. Find mutual friends between two users
    public void printMutualFriends(int id1, int id2) {
        UserNode u1 = findUserById(id1);
        UserNode u2 = findUserById(id2);

        if (u1 == null || u2 == null) {
            System.out.println("One or both users not found");
            return;
        }

        System.out.print("Mutual friends of " + id1 + " and " + id2 + ": ");
        FriendNode f1 = u1.friendsHead;
        boolean found = false;

        while (f1 != null) {
            if (isFriend(u2.friendsHead, f1.friendId)) {
                System.out.print(f1.friendId + " ");
                found = true;
            }
            f1 = f1.next;
        }

        if (!found) System.out.print("None");
        System.out.println();
    }

    // 4. Display all friends of a specific user
    public void printFriendsOfUser(int userId) {
        UserNode user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found");
            return;
        }
        System.out.print("Friends of " + user.name + " (" + user.userId + "): ");
        FriendNode curr = user.friendsHead;
        if (curr == null) {
            System.out.println("No friends");
            return;
        }
        while (curr != null) {
            System.out.print(curr.friendId + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // 5. Count number of friends for a user
    public int countFriends(int userId) {
        UserNode user = findUserById(userId);
        if (user == null) return 0;
        int count = 0;
        FriendNode curr = user.friendsHead;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    // 6. Count friends for all users
    public void printFriendCountForAllUsers() {
        UserNode temp = head;
        while (temp != null) {
            int c = 0;
            FriendNode f = temp.friendsHead;
            while (f != null) {
                c++;
                f = f.next;
            }
            System.out.println(temp.name + " (" + temp.userId + ") has " + c + " friends");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        SocialNetwork sn = new SocialNetwork();

        sn.addUser(1, "Rishabh", 20);
        sn.addUser(2, "Pankaj", 22);
        sn.addUser(3, "Charlie", 21);
        sn.addUser(4, "David", 23);

        sn.addFriendConnection(1, 2);
        sn.addFriendConnection(1, 3);
        sn.addFriendConnection(2, 3);
        sn.addFriendConnection(2, 4);

        sn.printFriendsOfUser(1);            // friends of Rishabh
        sn.printFriendsOfUser(2);            // friends of Pankaj

        sn.printMutualFriends(1, 2);         // mutual of Rishabh & Pankaj

        System.out.println("Rishabh friend count = " + sn.countFriends(1));
        sn.printFriendCountForAllUsers();

        sn.removeFriendConnection(1, 2);
        sn.printFriendsOfUser(1);
        sn.printFriendsOfUser(2);
    }
}
