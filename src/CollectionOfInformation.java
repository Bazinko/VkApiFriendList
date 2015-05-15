import java.util.Scanner;

public class CollectionOfInformation extends HTMLHandling {
    public static String[] listFriends;
    public static int Friends;
    public static String user_id;
    public static String user_name;
    public static String user_fname;

    public static void userinfo() {

        String otv ="https://api.vkontakte.ru/method/getProfiles?uids=" + user_id;
        otv = getHTML(otv);
        //System.out.println(otv);
        String[] o = otv.split("\"response\":");
        otv = o[1];

        o = otv.split(",");
        String otv1 = o[1];
        String otv2 = o[2];
        user_name=otv1.split("\":\"")[1].split("\"")[0];
        user_fname=otv2.split("\":\"")[1].split("\"")[0];
    }

    public static void getFriends(String id) {
        String otv = getListFriendsApi(id);
        //System.out.println(otv);
        String[] o = otv.split("\"response\":");
        otv = o[1];
        String[] list=otv.split("\"uid\":");
        int riens = list.length;
        Friends = riens;
        listFriends=list;

        for(int i=1; i<riens; i++) {
            listFriends[i]=" ("+list[i].split(",\"first_name\":\"")[0]+") "+
                    list[i].split(",\"first_name\":\"")[1].split("\",\"last_name\":\"")[0]+
                    " "+list[i].split(",\"first_name\":\"")[1].split("\",\"last_name\":\"")[1].split("\",\"")[0];
        }
    }

    public static String getListFriendsApi(String id) {
        String R="https://api.vk.com/method/friends.get?user_id=" + id
                + "&order=mobile&fields=onlain&namecase=nom";
        return getHTML(R);
    }

    public static String input() {
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }
}