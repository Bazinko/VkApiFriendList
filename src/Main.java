public class Main extends CollectionOfInformation {

    public static void main(String args[]) {

        while (true){
            System.out.println("Введите id человека, список друзей которого хотите узнать");
            user_id = input();

            if (user_id.equals("exit")){
                System.exit(0);
            }

            userinfo();
            getFriends(user_id);
            System.out.println("id принадлежит пользователю: " + user_name + " " + user_fname + " ("+user_id+")");
            System.out.println("Пользователь " + user_name + " " + user_fname + " дружит с " + --Friends + " человеком(ами):");
            for (int i=1; i<Friends+1; i++)
                System.out.println(i + ". " + listFriends[i]);
        }
    }
}