import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class TestTreeMap {

    @Test
    public void testTree() throws Exception {
        TreeMap<Integer, String> map = new TreeMap<Integer, String>();
        map.put(1, "tom");
        map.put(2, "tom");
        map.put(3, "tom");
        map.put(4, "tom");
        map.put(5, "tom");
        map.put(6, "tom");
        map.put(7, "tom");
        map.put(8, "tom");

//        System.out.println(getRoot(map));
//        preOrderTravel(getRoot(map));
        preOrderTravel2(getRoot(map));
    }

    //得到根节点
    public static Map.Entry getRoot(TreeMap map) throws Exception {
        Field f = TreeMap.class.getDeclaredField("root");
        f.setAccessible(true);
        Object o = f.get(map);
        return (Map.Entry) o;
    }

    //得到e节点的k值
    public static Object getKey(Map.Entry e) throws Exception {
        Field f = e.getClass().getDeclaredField("key");
        f.setAccessible(true);
        Object o = f.get(e);
        return o;
    }

    //得到左节点
    public static Map.Entry getLeft(Map.Entry e) throws Exception {
        Field f = e.getClass().getDeclaredField("left");
        f.setAccessible(true);
        Object o = f.get(e);
        return (Map.Entry) o;
    }

    public static Object getLeftKey(Map.Entry e) throws Exception {


        Field f = e.getClass().getDeclaredField("left");
        f.setAccessible(true);
        Object o = f.get(e);
        if(o != null){
            Field k = o.getClass().getDeclaredField("left");
            k.setAccessible(true);
            return k.get(o);
        }
        return null;
    }
    //得到右节点

    public static Map.Entry getRight(Map.Entry e) throws Exception {
        Field f = e.getClass().getDeclaredField("right");
        f.setAccessible(true);
        Object o = f.get(e);
        return (Map.Entry) o;
    }

    public static Object getRightKey(Map.Entry e) throws Exception {
        Field f = e.getClass().getDeclaredField("right");
        f.setAccessible(true);
        Object o = f.get(e);
        if (o != null) {
            Field k = o.getClass().getDeclaredField("key");
            k.setAccessible(true);
            return k.get(o);
        }
        return null;
    }

    //递归
    public static void preOrderTravel(Map.Entry e) throws Exception {
        if (e != null) {
            preOrderTravel(getLeft(e));
            System.out.println(getKey(e));

            preOrderTravel(getRight(e));


        }
    }

    public static void preOrderTravel2(Map.Entry e) throws Exception {

        ArrayList<Map.Entry> list = new ArrayList<>();
        list.add(e);
        while (!list.isEmpty()) {
            ArrayList<Map.Entry> list1 = new ArrayList<>();
            for (Map.Entry en : list) {
                System.out.print(getKey(en));

                if (getLeft(en) != null) {
                    list1.add(getLeft(en));
                }
                if (getRight(en) != null){
                    list1.add(getRight(en));
                }
            }
            System.out.println();
            list = list1;
        }
    }
}
