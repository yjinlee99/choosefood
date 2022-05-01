package SQL;

import java.util.ArrayList;

public class SQLTest {
    public static void main(String[] args) {
        ArrayList<DTO> dtos = DAO.getFoods();

        for(int i=0; i <dtos.size(); i++) {
            DTO dto = dtos.get(i);
            System.out.println(dto.getTitle());
            System.out.println(dto.getIntro());
            System.out.println(dto.getIngredient());
            System.out.println(dto.getStep());
            System.out.println(dto.getThumbnail());
            System.out.println(dto.getStepimg());
            System.out.println(dto.getThema());
            System.out.println(dto.getTaste());
            System.out.println(dto.getSituation());
            System.out.println();
        }
//        String a[][] = DAO.getTitle();
//        for(int i = 0; i<a.length; i++)
//            System.out.println(a[i][0]);
//        String img[][] = DAO.getThumbnail();
//        System.out.println(img[0][0]);
//        for(int i = 0; i<a.length; i++)
//            System.out.println(img[i][0]);
    }
}
