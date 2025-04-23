package hust.soict.hedspi.aims.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hust.soict.hedspi.aims.media.*;

public class CartTest {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();
        Scanner sc = new Scanner(System.in);

        // Tạo các đối tượng media cụ thể
        Book book = new Book("Clean Code", "Programming", 29.99f);
        DigitalVideoDisc dvd = new DigitalVideoDisc("Interstellar", "Sci-Fi", "Christopher Nolan", 169, 15.5f);
        CompactDisc cd = new CompactDisc("Lo-Fi Chill","Lo-Fi Music","DJ Relax","LoFi Master",45,19.99f);

        // Thêm một số track cho CD
        cd.addTrack(new Track("Intro", 2));
        cd.addTrack(new Track("Lofi Vibes", 3));
        cd.addTrack(new Track("Rainy Day", 4));

        // Thêm vào danh sách
        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

        // In thông tin từng media bằng toString()
        for (Media m : mediae) {
            System.out.println(m.toString());
        }

        int choice = 1;
        while(true){
            System.out.println("Search by:\n0. Exit\n1. ID\n2. title");
            choice = sc.nextInt();
            sc.nextLine();
            if(choice == 0 ) break;
            else if(choice == 1){
                int id = sc.nextInt();
                for(Media media : mediae){
                    if(media.isMatch(id)){
                        System.out.println(media.toString());
                        return;
                    }
                }
                System.out.println("No result matched");
            }
            else if(choice == 2){
                String title = sc.nextLine();
                for(Media media : mediae){
                    if(media.isMatch(title)){
                        System.out.println(media.toString());
                        return;
                    }
                }
                System.out.println("No result matched");
            }
            else {System.out.println("Error. Please re-enter.");}
        }
        sc.close();   
    }    
}
