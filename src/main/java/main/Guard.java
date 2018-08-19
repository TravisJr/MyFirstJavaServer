package main;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Properties;
import java.util.prefs.Preferences;

class  Guard {


 static void Guardo()

    {
        Preferences prefs;
        String st, key;
        int limit = 0;

        prefs = Preferences.userRoot().node("/branch/leaf"); //метод для доступа к реестру
        key = prefs.get("key", ""); //получаем значение поля ley
        if (key.equals(""))

        {
            //Ветка если в реестре было пусто

            System.out.println("Ключа в реестре не обнаружено");
            Properties props = System.getProperties(); //получаем доступ к аппаратным характеристикам. Полный список -  System.getProperties().list(System.out);

            st = Runtime.getRuntime().availableProcessors() + System.getenv("PROCESSOR_ARCHITECTURE")
                    + props.getProperty("os.name") + props.getProperty("user.country") + props.getProperty("user.home");
            System.out.println(st);

            String md5Hex = DigestUtils.md5Hex(st); //Формируем хэш
            //System.out.println(md5Hex);
            prefs.put("key", md5Hex);
            prefs.put("limit", "1");
            System.out.println("Необходимыые поля в реестр добавлены");

        }

        else

        {
            //Ветка если всё таки ключ нашёлся


            Properties props = System.getProperties();
            st = Runtime.getRuntime().availableProcessors() + System.getenv("PROCESSOR_ARCHITECTURE")
                    + props.getProperty("os.name") + props.getProperty("user.country") + props.getProperty("user.home");
            String md5Hex = DigestUtils.md5Hex(st);
            key = prefs.get("key", ""); //берем потенциальный хэш

            try { //Перехватываем ошибку о несоответсвии типу данных внутри ячейки лимита типу int
                limit = Integer.parseInt(prefs.get("limit", "")); //берем лемит и кладем в int
            }

            catch (NumberFormatException е)
            { System.out.println("В поле лимита лежат данные другого типа");
            limit=5001; //закрываем лимит
            }



            if (md5Hex.equals(key) && limit <= 5000) {
                System.out.println("Доступ разрешен. Колличество использований программы = " + limit);
                limit++;
                prefs.put("limit", String.valueOf(limit));
            } else {
                System.out.println("Доступ в программу не разрешен");

                System.exit(0);

            }

        }
    }







}
